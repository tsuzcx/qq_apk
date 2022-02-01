package com.tencent.youtu.sdkkitframework.liveness;

import android.content.Context;
import android.graphics.YuvImage;
import android.os.Environment;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import com.tencent.youtu.sdkkitframework.common.FileUtils;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSDKStats;
import com.tencent.youtu.sdkkitframework.common.YtVideoEncoder;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.ProcessHelper;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper.StateClassName;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtFrameworkFireEventType;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKPlatformContext;
import com.tencent.youtu.ytfacetrack.YTFaceTrack;
import com.tencent.youtu.ytfacetrack.YTFaceTrack.FaceStatus;
import com.tencent.youtu.ytfacetrack.param.YTFaceTrackParam;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectOnFrame;
import com.tencent.youtu.ytposedetect.data.YTActRefData;
import com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ActionLivenessState
  extends YtFSMBaseState
{
  private static final String TAG = ActionLivenessState.class.getSimpleName();
  private YTActRefData actReflectData;
  int actReflectUXMode = 0;
  private int actionContinuousFailedCount = 0;
  private int actionCurrentIndex;
  private String[] actionDataParsed;
  private YTPoseDetectInterface.PoseDetectOnFrame actionFrameHandler;
  private int actionLiveType = 1;
  private ArrayList<ActionLivenessState.BestFrame> bestFrames;
  private int codecSettingBitRate = 4194304;
  private int codecSettingFrameRate = 30;
  private int codecSettingiFrameInterval = 1;
  private int continuousDetectCount = 0;
  private String controlConfig = "";
  private int currentRotateState;
  private String extraTips = "";
  private YTFaceTrack.FaceStatus[] faceStatus;
  private String innerMp4Path = Environment.getExternalStorageDirectory().getPath() + "/temp.mp4";
  private boolean isActionFinished = false;
  private boolean isLoadResourceOnline = false;
  private String legitimatePoseVersion = "3.5.4";
  private YTFaceTrackParam mOriginParam;
  private boolean needLocalConfig = false;
  private boolean needManualTrigger = false;
  private YtSDKKitCommon.StateNameHelper.StateClassName nextStateName;
  private int poseReadyCount = 0;
  private SilentLivenessState.FacePreviewingAdvise poseState = SilentLivenessState.FacePreviewingAdvise.ADVISE_NAN;
  private int securityLevel = 1;
  private int stableCountNum = 5;
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
      YtLogger.i(TAG, "action check rounds: " + this.actionCurrentIndex + "start check pose: " + this.actionLiveType);
      YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE)).handleStateAction("reset_timeout", null);
      this.poseReadyCount = 0;
      return true;
      this.actionLiveType = 1;
      continue;
      this.actionLiveType = 2;
      continue;
      this.actionLiveType = 3;
      continue;
      this.actionLiveType = 4;
      continue;
      this.actionLiveType = 5;
    }
  }
  
  private void clearData()
  {
    this.bestFrames = new ArrayList();
    this.actionContinuousFailedCount = 0;
    this.isActionFinished = false;
    this.actionCurrentIndex = -1;
    this.poseReadyCount = 0;
    this.poseState = SilentLivenessState.FacePreviewingAdvise.ADVISE_NAN;
    changeToNextAction(this.actionDataParsed, this.actionCurrentIndex + 1);
    this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE;
    this.videoEncoder.abortEncoding();
    this.actionFrameHandler = new ActionLivenessState.6(this);
    YTPoseDetectInterface.start(YtFSM.getInstance().getContext().currentAppContext, YtFSM.getInstance().getContext().currentCamera, YtFSM.getInstance().getContext().currentCameraId, new ActionLivenessState.7(this));
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
    if (paramInt == 5) {
      return "fl_act_silence";
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
    for (;;)
    {
      try
      {
        Object localObject = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
        this.continuousDetectCount = ((Integer)((YtFSMBaseState)localObject).getStateDataBy("continuous_detect_count")).intValue();
        this.faceStatus = ((YTFaceTrack.FaceStatus[])((YtFSMBaseState)localObject).getStateDataBy("face_status"));
        this.poseState = ((SilentLivenessState.FacePreviewingAdvise)((YtFSMBaseState)localObject).getStateDataBy("pose_state"));
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
        case 0: 
          this.stateData.put("current_action_type", Integer.valueOf(i));
          if (this.actReflectUXMode == 1)
          {
            this.actionLiveType = 5;
            this.actionDataParsed = new String[] { "5" };
          }
          this.stateData.put("action_seq", this.actionDataParsed);
          return;
        }
      }
      catch (Exception localException)
      {
        YtLogger.e(TAG, "action enter failed " + localException.getLocalizedMessage());
        CommonUtils.reportException("action enter failed ", localException);
        return;
      }
      this.actionLiveType = 1;
      continue;
      this.actionLiveType = 2;
      continue;
      this.actionLiveType = 3;
      continue;
      this.actionLiveType = 4;
      continue;
      this.actionLiveType = 5;
    }
  }
  
  public void enterFirst()
  {
    YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE)).handleStateAction("reset_timeout", null);
    Object localObject1 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_FETCH_STATE));
    if (localObject1 != null) {}
    try
    {
      localObject2 = ((YtFSMBaseState)localObject1).getStateDataBy("video_bitrate");
      if (localObject2 != null) {
        this.codecSettingBitRate = ((Integer)localObject2).intValue();
      }
      localObject2 = ((YtFSMBaseState)localObject1).getStateDataBy("video_framerate");
      if (localObject2 != null) {
        this.codecSettingFrameRate = ((Integer)localObject2).intValue();
      }
      localObject2 = ((YtFSMBaseState)localObject1).getStateDataBy("video_iframeinterval");
      if (localObject2 != null) {
        this.codecSettingiFrameInterval = ((Integer)localObject2).intValue();
      }
      localObject1 = (String)((YtFSMBaseState)localObject1).getStateDataBy("control_config");
      if (localObject1 != null) {
        this.controlConfig = ((String)localObject1);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2;
        int j;
        int i;
        YtLogger.e(TAG, "action enter first failed:" + localException.getLocalizedMessage());
      }
    }
    if (!this.controlConfig.isEmpty())
    {
      localObject1 = this.controlConfig.split("&");
      if (localObject1.length > 0)
      {
        j = localObject1.length;
        i = 0;
        while (i < j)
        {
          localObject2 = localObject1[i].split("=");
          if ((localObject2.length > 1) && (localObject2[0].equals("actref_ux_mode"))) {
            this.actReflectUXMode = Integer.parseInt(localObject2[1]);
          }
          i += 1;
        }
      }
    }
  }
  
  public void handleEvent(YtSDKKitFramework.YtFrameworkFireEventType paramYtFrameworkFireEventType, Object paramObject)
  {
    super.handleEvent(paramYtFrameworkFireEventType, paramObject);
    if ((this.needManualTrigger) && (paramYtFrameworkFireEventType == YtSDKKitFramework.YtFrameworkFireEventType.YT_EVENT_TRIGGER_CANCEL_LIVENESS)) {
      clearData();
    }
  }
  
  public void loadStateWith(String paramString, JSONObject paramJSONObject)
  {
    super.loadStateWith(paramString, paramJSONObject);
    YtFSM.getInstance().getContext().currentAppContext.getFilesDir().getAbsolutePath();
    try
    {
      if (paramJSONObject.has("resource_online")) {
        this.isLoadResourceOnline = paramJSONObject.getBoolean("resource_online");
      }
      if (paramJSONObject.has("video_path")) {
        this.innerMp4Path = paramJSONObject.getString("video_path");
      }
      if (paramJSONObject.has("local_config_flag")) {
        this.needLocalConfig = paramJSONObject.getBoolean("local_config_flag");
      }
      if (paramJSONObject.has("video_bitrate")) {
        this.codecSettingBitRate = paramJSONObject.getInt("video_bitrate");
      }
      if (paramJSONObject.has("video_framerate")) {
        this.codecSettingFrameRate = paramJSONObject.getInt("video_framerate");
      }
      if (paramJSONObject.has("video_iframeinterval")) {
        this.codecSettingiFrameInterval = paramJSONObject.getInt("video_iframeinterval");
      }
      if (paramJSONObject.has("manual_trigger")) {
        this.needManualTrigger = paramJSONObject.getBoolean("manual_trigger");
      }
      if (paramJSONObject.has("stable_frame_num")) {
        this.stableCountNum = paramJSONObject.getInt("stable_frame_num");
      }
      if (paramJSONObject.has("control_config")) {
        this.controlConfig = paramJSONObject.getString("control_config");
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        Object localObject2;
        paramString.printStackTrace();
        YtLogger.e(TAG, "action load failed1:" + paramString.getLocalizedMessage());
        continue;
        if (Integer.parseInt(localObject1[1]) != Integer.parseInt(localObject2[1])) {
          sendFSMEvent(new ActionLivenessState.2(this, paramString));
        } else if (Integer.parseInt(localObject1[2]) < Integer.parseInt(localObject2[2])) {
          YtFSM.getInstance().sendFSMEvent(new ActionLivenessState.3(this, paramString));
        }
      }
      this.continuousDetectCount = 0;
      this.stateData.put("action_type", Integer.valueOf(this.actionLiveType));
      try
      {
        if (!paramJSONObject.has("action_security_level")) {
          break label545;
        }
        this.securityLevel = paramJSONObject.getInt("action_security_level");
        paramString = paramJSONObject.getJSONArray("action_default_seq");
        if (paramString != null) {
          break label792;
        }
        YtSDKStats.getInstance().reportError(3145728, "yt_param_error");
        return;
      }
      catch (JSONException paramString)
      {
        YtLogger.e(TAG, "action load failed3: " + paramString.getLocalizedMessage());
        this.actionDataParsed = "0".split(" ");
      }
    }
    if (!this.isLoadResourceOnline) {
      FileUtils.loadLibrary("YTPoseDetect");
    }
    paramString = YTPoseDetectJNIInterface.getVersion();
    YtLogger.i(TAG, "YTPose Version: " + paramString);
    Object localObject1 = paramString.split("\\.");
    localObject2 = this.legitimatePoseVersion;
    YtLogger.i(TAG, "Wanted YTPose Version: " + (String)localObject2);
    localObject2 = ((String)localObject2).split("\\.");
    int i;
    if (Integer.parseInt(localObject1[0]) != Integer.parseInt(localObject2[0]))
    {
      sendFSMEvent(new ActionLivenessState.1(this, paramString));
      i = YTPoseDetectInterface.initModel();
      if (i == 0) {
        break label501;
      }
      YtLogger.e(TAG, "action load failed2: " + i);
      YtSDKStats.getInstance().reportError(i, "failed to init pose sdk");
      YtFSM.getInstance().sendFSMEvent(new ActionLivenessState.4(this, i));
    }
    for (;;)
    {
      try
      {
        label501:
        if (paramJSONObject.has("action_inner_settings"))
        {
          paramString = paramJSONObject.getJSONObject("action_inner_settings");
          paramJSONObject = paramString.keys();
          if (paramJSONObject.hasNext())
          {
            localObject1 = (String)paramJSONObject.next();
            YTPoseDetectJNIInterface.updateParam((String)localObject1, paramString.getString((String)localObject1));
            continue;
          }
        }
        label545:
        this.actionDataParsed = new String[paramString.length()];
      }
      catch (JSONException paramString)
      {
        YtLogger.d(TAG, "action load failed4: " + paramString.getLocalizedMessage());
        YTPoseDetectJNIInterface.configNativeLog(true);
        YTPoseDetectJNIInterface.updateParam("log_level", "3");
        YTPoseDetectJNIInterface.setLoggerListener(new ActionLivenessState.5(this));
        this.currentRotateState = YtFSM.getInstance().getContext().currentRotateState;
        this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE;
        this.videoEncoder = new YtVideoEncoder(null, true);
        this.mOriginParam = YTFaceTrack.getInstance().GetFaceTrackParam();
        YTPoseDetectJNIInterface.setSafetyLevel(this.securityLevel);
        this.bestFrames = new ArrayList();
        reset();
        return;
      }
      label792:
      i = 0;
      while (i < paramString.length())
      {
        this.actionDataParsed[i] = paramString.getString(i);
        i += 1;
      }
      YtLogger.d(TAG, "load action sequence from sdkconfig " + paramJSONObject.getString("action_default_seq") + " size :" + this.actionDataParsed.length);
    }
  }
  
  public void moveToNextState()
  {
    super.moveToNextState();
    if (this.nextStateName == YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE)
    {
      YtFSM.getInstance().transitNextRound(YtSDKKitCommon.StateNameHelper.classNameOfState(this.nextStateName));
      return;
    }
    YTFaceTrack.getInstance().SetFaceTrackParam(this.mOriginParam);
    YTPoseDetectInterface.stop();
    YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(this.nextStateName));
  }
  
  public void reset()
  {
    clearData();
    super.reset();
  }
  
  public void unload()
  {
    super.unload();
    if (YTPoseDetectInterface.isDetecting()) {
      YTPoseDetectInterface.stop();
    }
    YTPoseDetectInterface.releaseModel();
    if (this.videoEncoder != null)
    {
      this.videoEncoder.abortEncoding();
      this.videoEncoder = null;
    }
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    super.update(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramLong);
    if ((this.faceStatus != null) && (this.faceStatus.length > 0) && (this.continuousDetectCount > 0))
    {
      if ((this.continuousDetectCount <= 1) || (this.faceStatus.length > 1))
      {
        this.poseReadyCount = this.stableCountNum;
        YTPoseDetectInterface.reset();
      }
      if (this.actionFrameHandler == null)
      {
        YtLogger.e(TAG, "FrameHandle is null, check init first");
        return;
      }
      if ((this.poseReadyCount > this.stableCountNum + 10) && (!this.isActionFinished)) {
        sendFSMEvent(new ActionLivenessState.8(this));
      }
      this.poseReadyCount += 1;
      YTFaceTrackParam localYTFaceTrackParam = this.mOriginParam;
      localYTFaceTrackParam.detect_interval = 30;
      YTFaceTrack.getInstance().SetFaceTrackParam(localYTFaceTrackParam);
      YTPoseDetectInterface.poseDetect(this.faceStatus[0].xys, this.faceStatus[0].pointsVis, this.actionLiveType, paramArrayOfByte, YtFSM.getInstance().getContext().currentCamera, this.faceStatus[0].pitch, this.faceStatus[0].yaw, this.faceStatus[0].roll, this.actionFrameHandler, 1);
      AddOptPose(paramArrayOfByte, paramInt1, paramInt2, this.faceStatus[0].xys, this.faceStatus[0].pitch, this.faceStatus[0].yaw, this.faceStatus[0].roll);
    }
    moveToNextState();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState
 * JD-Core Version:    0.7.0.1
 */