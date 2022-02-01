package com.tencent.youtu.sdkkitframework.liveness;

import android.content.Context;
import android.graphics.YuvImage;
import android.os.Environment;
import com.tencent.youtu.sdkkitframework.common.FileUtils;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtVideoEncoder;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.ProcessHelper;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper.StateClassName;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKPlatformContex;
import com.tencent.youtu.ytcommon.tools.YTUtils;
import com.tencent.youtu.ytfacetrack.YTFaceTrack.FaceStatus;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectOnFrame;
import com.tencent.youtu.ytposedetect.data.YTActRefData;
import com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ActionLivenessState
  extends YtFSMBaseState
{
  private static final String TAG = ActionLivenessState.class.getSimpleName();
  private YTActRefData actReflectData;
  private int actionContinuousFailedCount = 0;
  private int actionCurrentIndex;
  private String[] actionDataParsed;
  private YTPoseDetectInterface.PoseDetectOnFrame actionFrameHandler;
  private int actionLiveType = 1;
  private ArrayList<ActionLivenessState.BestFrame> bestFrames;
  private int continuousDetectCount = 0;
  private int currentRotateState;
  private YTFaceTrack.FaceStatus[] faceStatus;
  private String innerMp4Path = Environment.getExternalStorageDirectory().getPath() + "/temp.mp4";
  private boolean isActionFinished = false;
  private boolean isLoadResourceOnline = false;
  private boolean needLocalConfig = false;
  private YtSDKKitCommon.StateNameHelper.StateClassName nextStateName;
  private int securityLevel = 1;
  private YtVideoEncoder videoEncoder;
  
  private void AddOptPose(byte[] paramArrayOfByte, int paramInt1, int paramInt2, float[] paramArrayOfFloat, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f = YtSDKKitCommon.ProcessHelper.preCheckCloseEyeScore(paramArrayOfFloat);
    ActionLivenessState.BestFrame localBestFrame = new ActionLivenessState.BestFrame(this);
    localBestFrame.eyeScore = f;
    localBestFrame.pitch = paramFloat1;
    localBestFrame.yaw = paramFloat2;
    localBestFrame.roll = paramFloat3;
    localBestFrame.f5p = YtSDKKitCommon.ProcessHelper.convert90PTo5P(paramArrayOfFloat);
    localBestFrame.frame = new YuvImage(paramArrayOfByte, 17, paramInt1, paramInt2, null);
    this.bestFrames.add(localBestFrame);
    if (this.bestFrames.size() > 20) {
      this.bestFrames.remove(0);
    }
  }
  
  private boolean changeToNextAction(String[] paramArrayOfString, int paramInt)
  {
    if (paramArrayOfString.length == 0) {}
    do
    {
      return false;
      this.actionCurrentIndex = paramInt;
    } while (this.actionCurrentIndex >= paramArrayOfString.length);
    paramInt = Integer.parseInt(paramArrayOfString[this.actionCurrentIndex]);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.stateData.put("current_action_type", Integer.valueOf(paramInt));
      YtLogger.d(TAG, "action check rounds: " + this.actionCurrentIndex + "start check pose: " + this.actionLiveType);
      YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE)).handleStateAction("reset_timeout", null);
      return true;
      this.actionLiveType = 1;
      continue;
      this.actionLiveType = 2;
      continue;
      this.actionLiveType = 3;
      continue;
      this.actionLiveType = 4;
    }
  }
  
  private String getTipsByPoseType(int paramInt)
  {
    if (paramInt == 1) {
      return "fl_act_blink";
    }
    if (paramInt == 2) {
      return "fl_act_open_mouth";
    }
    if (paramInt == 4) {
      return "fl_act_shake_head";
    }
    if (paramInt == 3) {
      return "fl_act_nod_head";
    }
    return "fl_act_error" + paramInt;
  }
  
  private void sendFSMEvent(HashMap<String, Object> paramHashMap)
  {
    YtFSM.getInstance().sendFSMEvent(paramHashMap);
  }
  
  public void enter()
  {
    super.enter();
    try
    {
      Object localObject = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
      this.continuousDetectCount = ((Integer)((YtFSMBaseState)localObject).getStateDataBy("continuous_detect_count")).intValue();
      this.faceStatus = ((YTFaceTrack.FaceStatus[])((YtFSMBaseState)localObject).getStateDataBy("face_status"));
      localObject = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_FETCH_STATE));
      int i;
      if ((localObject != null) && (!this.needLocalConfig))
      {
        localObject = (String)((YtFSMBaseState)localObject).getStateDataBy("action_data");
        YtLogger.d(TAG, "action data :" + (String)localObject);
        this.actionDataParsed = ((String)localObject).split(",");
        if (this.actionDataParsed.length > this.actionCurrentIndex) {
          i = Integer.parseInt(this.actionDataParsed[this.actionCurrentIndex]);
        }
      }
      switch (i)
      {
      default: 
        this.stateData.put("current_action_type", Integer.valueOf(i));
        if ((!this.isActionFinished) && (this.faceStatus != null) && (this.faceStatus.length > 0) && (this.continuousDetectCount > 1)) {
          sendFSMEvent(new ActionLivenessState.2(this));
        }
        this.stateData.put("action_seq", this.actionDataParsed);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        YtLogger.e(TAG, localException.getLocalizedMessage());
        continue;
        this.actionLiveType = 1;
        continue;
        this.actionLiveType = 2;
        continue;
        this.actionLiveType = 3;
        continue;
        this.actionLiveType = 4;
      }
    }
  }
  
  public void enterFirst()
  {
    YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE)).handleStateAction("reset_timeout", null);
  }
  
  public void loadStateWith(String paramString, JSONObject paramJSONObject)
  {
    int j = 0;
    super.loadStateWith(paramString, paramJSONObject);
    paramString = YtFSM.getInstance().getContext().currentAppContex;
    String str1 = paramString.getFilesDir().getAbsolutePath();
    try
    {
      this.isLoadResourceOnline = paramJSONObject.getBoolean("resource_online");
      if (paramJSONObject.has("video_path")) {
        this.innerMp4Path = paramJSONObject.getString("video_path");
      }
      if (paramJSONObject.has("local_config_flag")) {
        this.needLocalConfig = paramJSONObject.getBoolean("local_config_flag");
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        String[] arrayOfString;
        localJSONException.printStackTrace();
        YtLogger.e(TAG, "Failed to parse json:" + localJSONException.getLocalizedMessage());
      }
      i = YTPoseDetectInterface.initModel();
      if (i == 0) {
        break label285;
      }
      YtLogger.e(TAG, "return: " + i);
      YtFSM.getInstance().sendFSMEvent(new ActionLivenessState.1(this, i));
      return;
      this.continuousDetectCount = 0;
      this.stateData.put("action_type", Integer.valueOf(this.actionLiveType));
    }
    if (!this.isLoadResourceOnline) {
      YTUtils.loadLibrary("YTPoseDetect");
    }
    arrayOfString = new String[1];
    arrayOfString[0] = "rotBasis.bin";
    int i;
    if (!this.isLoadResourceOnline)
    {
      i = 0;
      while (i < arrayOfString.length)
      {
        String str2 = arrayOfString[i];
        String str3 = str1 + "/" + str2;
        FileUtils.copyAsset(paramString.getAssets(), "FaceTrackModels/poseest/" + str2, str3);
        i += 1;
      }
    }
    try
    {
      label285:
      if (paramJSONObject.has("action_security_level")) {
        this.securityLevel = paramJSONObject.getInt("action_security_level");
      }
      paramString = paramJSONObject.getJSONArray("action_default_seq");
      this.actionDataParsed = new String[paramString.length()];
      i = j;
      while (i < paramString.length())
      {
        this.actionDataParsed[i] = paramString.getString(i);
        i += 1;
      }
      YtLogger.d(TAG, "load action sequence from sdkconfig " + paramJSONObject.getString("action_default_seq") + " size :" + this.actionDataParsed.length);
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        YtLogger.d(TAG, paramString.getLocalizedMessage());
        this.actionDataParsed = "0".split(" ");
      }
    }
    this.currentRotateState = YtFSM.getInstance().getContext().currentRotateState;
    this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE;
    this.videoEncoder = new YtVideoEncoder(null, true);
    YTPoseDetectJNIInterface.setSafetyLevel(this.securityLevel);
    this.bestFrames = new ArrayList();
    reset();
  }
  
  public void moveToNextState()
  {
    super.moveToNextState();
    if (this.nextStateName == YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE)
    {
      YtFSM.getInstance().transitNextRound(YtSDKKitCommon.StateNameHelper.classNameOfState(this.nextStateName));
      return;
    }
    YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(this.nextStateName));
  }
  
  public void reset()
  {
    this.bestFrames = new ArrayList();
    this.actionContinuousFailedCount = 0;
    this.isActionFinished = false;
    this.actionCurrentIndex = -1;
    changeToNextAction(this.actionDataParsed, this.actionCurrentIndex + 1);
    this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE;
    this.videoEncoder.abortEncoding();
    if (!this.videoEncoder.isEncodingStarted())
    {
      YtLogger.d(TAG, "??Start encoder");
      this.videoEncoder.startEncoding(480, 640, new File(this.innerMp4Path));
    }
    this.actionFrameHandler = new ActionLivenessState.3(this);
    YTPoseDetectInterface.start(YtFSM.getInstance().getContext().currentAppContex, YtFSM.getInstance().getContext().currentCamera, YtFSM.getInstance().getContext().currentCameraId, new ActionLivenessState.4(this));
    super.reset();
  }
  
  public void unload()
  {
    super.unload();
    if (YTPoseDetectInterface.isDetecting()) {
      YTPoseDetectInterface.stop();
    }
    YTPoseDetectInterface.releaseModel();
    this.videoEncoder.abortEncoding();
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    super.update(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
    if ((this.faceStatus != null) && (this.faceStatus.length > 0))
    {
      if ((this.continuousDetectCount <= 1) || (this.faceStatus.length > 1)) {
        YTPoseDetectInterface.reset();
      }
      if (this.actionFrameHandler == null)
      {
        YtLogger.e(TAG, "FrameHandle is null, check init first");
        return;
      }
      YTPoseDetectInterface.poseDetect(this.faceStatus[0].xys, this.faceStatus[0].pointsVis, this.actionLiveType, paramArrayOfByte, YtFSM.getInstance().getContext().currentCamera, this.faceStatus[0].pitch, this.faceStatus[0].yaw, this.faceStatus[0].roll, this.actionFrameHandler);
      AddOptPose(paramArrayOfByte, paramInt1, paramInt2, this.faceStatus[0].xys, this.faceStatus[0].pitch, this.faceStatus[0].yaw, this.faceStatus[0].roll);
    }
    moveToNextState();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState
 * JD-Core Version:    0.7.0.1
 */