package com.tencent.youtu.sdkkitframework.liveness;

import android.content.Context;
import android.graphics.YuvImage;
import android.os.Environment;
import com.tencent.youtu.YTFaceTracker;
import com.tencent.youtu.YTFaceTracker.Param;
import com.tencent.youtu.YTFaceTracker.TrackedFace;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import com.tencent.youtu.sdkkitframework.common.FileUtils;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSDKStats;
import com.tencent.youtu.sdkkitframework.common.YtVideoEncoder;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtFSM.YtFSMUpdateStrategy;
import com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.ProcessHelper;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper.StateClassName;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtFrameworkFireEventType;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKPlatformContext;
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
  private int actionFrameNum = 20;
  private int actionLiveType = 1;
  private ArrayList<ActionLivenessState.BestFrame> bestFrames;
  private int codecSettingBitRate = 2097152;
  private int codecSettingFrameRate = 30;
  private int codecSettingiFrameInterval = 1;
  private int continuousDetectCount = 0;
  private String controlConfig = "";
  private int currentRotateState;
  private String extraTips = "";
  private YTFaceTracker.TrackedFace[] faceStatus;
  private String innerMp4Path = Environment.getExternalStorageDirectory().getPath() + "/temp.mp4";
  private boolean isActionFinished = false;
  private boolean isLoadResourceOnline = false;
  private int lastActionFrameNum;
  private String legitimatePoseVersion = "3.6.5";
  private YTFaceTracker.Param mOriginParam;
  private boolean needCheckMultiFaces = false;
  private boolean needLocalConfig = false;
  private boolean needManualTrigger = false;
  private YtSDKKitCommon.StateNameHelper.StateClassName nextStateName;
  private int poseReadyCount = 0;
  private int poseState = -1;
  private int securityLevel = 1;
  private int stableCountNum = 5;
  private YTFaceTracker tracker;
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
    this.poseState = -1;
    changeToNextAction(this.actionDataParsed, this.actionCurrentIndex + 1);
    this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE;
    this.videoEncoder.abortEncoding();
    this.actionFrameHandler = new ActionLivenessState.6(this);
    YTPoseDetectInterface.start(YtFSM.getInstance().getContext().currentAppContext, YtFSM.getInstance().getContext().currentRotateState, new ActionLivenessState.7(this));
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
        this.faceStatus = ((YTFaceTracker.TrackedFace[])((YtFSMBaseState)localObject).getStateDataBy("face_status"));
        this.poseState = ((Integer)((YtFSMBaseState)localObject).getStateDataBy("pose_state")).intValue();
        localObject = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_FETCH_STATE));
        if ((localObject == null) || (this.needLocalConfig)) {
          continue;
        }
        localObject = (String)((YtFSMBaseState)localObject).getStateDataBy("action_data");
        YtLogger.d(TAG, "action data :" + (String)localObject);
        this.actionDataParsed = ((String)localObject).split(",");
        if (this.actionDataParsed.length <= this.actionCurrentIndex) {
          continue;
        }
        i = Integer.parseInt(this.actionDataParsed[this.actionCurrentIndex]);
        switch (i)
        {
        }
      }
      catch (Exception localException)
      {
        int i;
        YtLogger.e(TAG, "action enter failed " + localException.getLocalizedMessage());
        CommonUtils.reportException("action enter failed ", localException);
        continue;
        this.actionLiveType = 2;
        continue;
        this.actionLiveType = 3;
        continue;
        this.actionLiveType = 4;
        continue;
        this.actionLiveType = 5;
        continue;
        continue;
      }
      this.stateData.put("current_action_type", Integer.valueOf(i));
      if (this.actReflectUXMode == 1)
      {
        this.actionLiveType = 5;
        this.actionDataParsed = new String[] { "5" };
      }
      this.stateData.put("action_seq", this.actionDataParsed);
      YtFSM.getInstance().updateCacheStrategy(YtFSM.YtFSMUpdateStrategy.CacheStrategy);
      return;
      this.actionLiveType = 1;
    }
  }
  
  public void enterFirst()
  {
    Object localObject1 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
    ((YtFSMBaseState)localObject1).handleStateAction("reset_timeout", null);
    Object localObject2 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_FETCH_STATE));
    if (localObject2 != null) {}
    try
    {
      localObject3 = ((YtFSMBaseState)localObject2).getStateDataBy("video_bitrate");
      if (localObject3 != null) {
        this.codecSettingBitRate = ((Integer)localObject3).intValue();
      }
      localObject3 = ((YtFSMBaseState)localObject2).getStateDataBy("video_framerate");
      if (localObject3 != null) {
        this.codecSettingFrameRate = ((Integer)localObject3).intValue();
      }
      localObject3 = ((YtFSMBaseState)localObject2).getStateDataBy("video_iframeinterval");
      if (localObject3 != null) {
        this.codecSettingiFrameInterval = ((Integer)localObject3).intValue();
      }
      localObject2 = (String)((YtFSMBaseState)localObject2).getStateDataBy("control_config");
      if (localObject2 != null) {
        this.controlConfig = ((String)localObject2);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject3;
        int j;
        int i;
        YtLogger.e(TAG, "action enter first failed:" + localException.getLocalizedMessage());
      }
      this.tracker = ((YTFaceTracker)((YtFSMBaseState)localObject1).getStateDataBy("detect_instance"));
      this.mOriginParam = this.tracker.getParam();
      localObject1 = this.mOriginParam;
      ((YTFaceTracker.Param)localObject1).detInterval = this.actionFrameNum;
      this.tracker.setParam((YTFaceTracker.Param)localObject1);
    }
    if (!this.controlConfig.isEmpty())
    {
      localObject2 = this.controlConfig.split("&");
      if (localObject2.length > 0)
      {
        j = localObject2.length;
        i = 0;
        while (i < j)
        {
          localObject3 = localObject2[i].split("=");
          if ((localObject3.length > 1) && (localObject3[0].equals("actref_ux_mode"))) {
            this.actReflectUXMode = Integer.parseInt(localObject3[1]);
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
    paramString = YtFSM.getInstance().getContext().currentAppContext;
    paramString.getFilesDir().getAbsolutePath();
    Object localObject1;
    int i;
    for (;;)
    {
      try
      {
        if (paramJSONObject.has("resource_online")) {
          this.isLoadResourceOnline = paramJSONObject.getBoolean("resource_online");
        }
        if (!paramJSONObject.has("video_path")) {
          continue;
        }
        this.innerMp4Path = paramJSONObject.getString("video_path");
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
        this.actionFrameNum = paramJSONObject.optInt("action_frame_num", 20);
        this.lastActionFrameNum = paramJSONObject.optInt("last_action_frame_num", 3);
        this.needCheckMultiFaces = paramJSONObject.optBoolean("need_check_multiface", false);
      }
      catch (JSONException paramString)
      {
        Object localObject2;
        paramString.printStackTrace();
        YtLogger.e(TAG, "action load failed1:" + paramString.getLocalizedMessage());
        continue;
        if (Integer.parseInt(localObject1[1]) == Integer.parseInt(localObject2[1])) {
          continue;
        }
        sendFSMEvent(new ActionLivenessState.2(this, paramString));
        continue;
        if (Integer.parseInt(localObject1[2]) >= Integer.parseInt(localObject2[2])) {
          continue;
        }
        YtFSM.getInstance().sendFSMEvent(new ActionLivenessState.3(this, paramString));
        continue;
        this.continuousDetectCount = 0;
        this.stateData.put("action_type", Integer.valueOf(this.actionLiveType));
        try
        {
          if (!paramJSONObject.has("action_security_level")) {
            continue;
          }
          this.securityLevel = paramJSONObject.getInt("action_security_level");
          paramString = paramJSONObject.getJSONArray("action_default_seq");
          if (paramString != null) {
            break label908;
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
      localObject1 = paramString.split("\\.");
      localObject2 = this.legitimatePoseVersion;
      YtLogger.i(TAG, "Wanted YTPose Version: " + (String)localObject2);
      localObject2 = ((String)localObject2).split("\\.");
      if (Integer.parseInt(localObject1[0]) == Integer.parseInt(localObject2[0])) {
        continue;
      }
      sendFSMEvent(new ActionLivenessState.1(this, paramString));
      i = YTPoseDetectInterface.initModel();
      if (i == 0) {
        continue;
      }
      YtLogger.e(TAG, "action load failed2: " + i);
      YtSDKStats.getInstance().reportError(i, "failed to init pose sdk");
      YtFSM.getInstance().sendFSMEvent(new ActionLivenessState.4(this, i));
      return;
      this.innerMp4Path = (paramString.getFilesDir() + "/temp.mp4");
    }
    for (;;)
    {
      try
      {
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
        this.actionDataParsed = new String[paramString.length()];
      }
      catch (JSONException paramString)
      {
        YtLogger.d(TAG, "action load failed4: " + paramString.getLocalizedMessage());
        YTPoseDetectJNIInterface.configNativeLog(true);
        YTPoseDetectJNIInterface.updateParam("log_level", "3");
        YTPoseDetectJNIInterface.updateParam("frame_num", "" + this.actionFrameNum);
        YTPoseDetectJNIInterface.updateParam("last_frame_num", "" + this.lastActionFrameNum);
        YTPoseDetectJNIInterface.setLoggerListener(new ActionLivenessState.5(this));
        this.currentRotateState = YtFSM.getInstance().getContext().currentRotateState;
        this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE;
        this.videoEncoder = new YtVideoEncoder(null, true);
        YTPoseDetectJNIInterface.setSafetyLevel(this.securityLevel);
        this.bestFrames = new ArrayList();
        reset();
        return;
      }
      label908:
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
      this.videoEncoder.stopEncoding();
      this.videoEncoder = null;
    }
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    super.update(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramLong);
    if ((this.faceStatus != null) && (this.faceStatus.length > 0) && (this.continuousDetectCount > 0))
    {
      if ((this.continuousDetectCount <= 1) || ((this.needCheckMultiFaces) && (this.poseState == 7)))
      {
        this.poseReadyCount = this.stableCountNum;
        YTPoseDetectInterface.reset();
        this.isActionFinished = false;
      }
      if (this.actionFrameHandler == null)
      {
        YtLogger.e(TAG, "FrameHandle is null, check init first");
        return;
      }
      YtLogger.d(TAG, "pose count" + this.poseReadyCount + " stable " + this.stableCountNum + " isAction" + this.isActionFinished);
      if ((this.poseReadyCount > this.stableCountNum + 10) && (!this.isActionFinished))
      {
        YtLogger.d(TAG, "tips:" + getTipsByPoseType(this.actionLiveType));
        sendFSMEvent(new ActionLivenessState.8(this));
      }
      YTPoseDetectInterface.poseDetect(this.faceStatus[0].faceShape, this.faceStatus[0].faceVisible, this.actionLiveType, paramArrayOfByte, paramInt1, paramInt2, this.faceStatus[0].pitch, this.faceStatus[0].yaw, this.faceStatus[0].roll, this.actionFrameHandler, 1);
      this.poseReadyCount += 1;
      AddOptPose(paramArrayOfByte, paramInt1, paramInt2, this.faceStatus[0].faceShape, this.faceStatus[0].pitch, this.faceStatus[0].yaw, this.faceStatus[0].roll);
    }
    moveToNextState();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState
 * JD-Core Version:    0.7.0.1
 */