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
  private static final String TAG = "ActionLivenessState";
  private YTActRefData actReflectData;
  int actReflectUXMode;
  private int actionContinuousFailedCount = 0;
  private int actionCurrentIndex;
  private String[] actionDataParsed;
  private YTPoseDetectInterface.PoseDetectOnFrame actionFrameHandler;
  private int actionFrameNum;
  private int actionLiveType = 1;
  private ArrayList<ActionLivenessState.BestFrame> bestFrames;
  private int codecSettingBitRate;
  private int codecSettingFrameRate;
  private int codecSettingiFrameInterval;
  private int continuousDetectCount = 0;
  private String controlConfig;
  private int currentRotateState;
  private String extraTips;
  private YTFaceTracker.TrackedFace[] faceStatus;
  private String innerMp4Path;
  private boolean isActionFinished = false;
  private boolean isLoadResourceOnline = false;
  private int lastActionFrameNum;
  private String legitimatePoseVersion = "3.6.5";
  private YTFaceTracker.Param mOriginParam;
  private boolean needCheckMultiFaces;
  private boolean needLocalConfig;
  private boolean needManualTrigger;
  private YtSDKKitCommon.StateNameHelper.StateClassName nextStateName;
  private int poseReadyCount;
  private int poseState = -1;
  private int securityLevel;
  private int stableCountNum;
  private YTFaceTracker tracker;
  private YtVideoEncoder videoEncoder;
  
  public ActionLivenessState()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
    localStringBuilder.append("/temp.mp4");
    this.innerMp4Path = localStringBuilder.toString();
    this.securityLevel = 1;
    this.needLocalConfig = false;
    this.codecSettingBitRate = 2097152;
    this.codecSettingFrameRate = 30;
    this.codecSettingiFrameInterval = 1;
    this.extraTips = "";
    this.needManualTrigger = false;
    this.poseReadyCount = 0;
    this.stableCountNum = 5;
    this.controlConfig = "";
    this.actionFrameNum = 20;
    this.actReflectUXMode = 0;
    this.needCheckMultiFaces = false;
  }
  
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
    if (paramArrayOfString.length == 0) {
      return false;
    }
    this.actionCurrentIndex = paramInt;
    paramInt = this.actionCurrentIndex;
    if (paramInt >= paramArrayOfString.length) {
      return false;
    }
    paramInt = Integer.parseInt(paramArrayOfString[paramInt]);
    if ((paramInt != 0) && (paramInt != 1))
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt == 5) {
              this.actionLiveType = 5;
            }
          }
          else {
            this.actionLiveType = 4;
          }
        }
        else {
          this.actionLiveType = 3;
        }
      }
      else {
        this.actionLiveType = 2;
      }
    }
    else {
      this.actionLiveType = 1;
    }
    this.stateData.put("current_action_type", Integer.valueOf(paramInt));
    paramArrayOfString = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("action check rounds: ");
    localStringBuilder.append(this.actionCurrentIndex);
    localStringBuilder.append("start check pose: ");
    localStringBuilder.append(this.actionLiveType);
    YtLogger.i(paramArrayOfString, localStringBuilder.toString());
    YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE)).handleStateAction("reset_timeout", null);
    this.poseReadyCount = 0;
    return true;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fl_act_error");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
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
      this.faceStatus = ((YTFaceTracker.TrackedFace[])((YtFSMBaseState)localObject).getStateDataBy("face_status"));
      this.poseState = ((Integer)((YtFSMBaseState)localObject).getStateDataBy("pose_state")).intValue();
      localObject = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_FETCH_STATE));
      if ((localObject != null) && (!this.needLocalConfig))
      {
        localObject = (String)((YtFSMBaseState)localObject).getStateDataBy("action_data");
        str = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("action data :");
        localStringBuilder.append((String)localObject);
        YtLogger.d(str, localStringBuilder.toString());
        this.actionDataParsed = ((String)localObject).split(",");
        if (this.actionDataParsed.length > this.actionCurrentIndex)
        {
          int i = Integer.parseInt(this.actionDataParsed[this.actionCurrentIndex]);
          if ((i != 0) && (i != 1))
          {
            if (i != 2)
            {
              if (i != 3)
              {
                if (i != 4)
                {
                  if (i == 5) {
                    this.actionLiveType = 5;
                  }
                }
                else {
                  this.actionLiveType = 4;
                }
              }
              else {
                this.actionLiveType = 3;
              }
            }
            else {
              this.actionLiveType = 2;
            }
          }
          else {
            this.actionLiveType = 1;
          }
          this.stateData.put("current_action_type", Integer.valueOf(i));
        }
      }
      if (this.actReflectUXMode == 1)
      {
        this.actionLiveType = 5;
        this.actionDataParsed = new String[] { "5" };
      }
      this.stateData.put("action_seq", this.actionDataParsed);
    }
    catch (Exception localException)
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("action enter failed ");
      localStringBuilder.append(localException.getLocalizedMessage());
      YtLogger.e(str, localStringBuilder.toString());
      CommonUtils.reportException("action enter failed ", localException);
    }
    YtFSM.getInstance().updateCacheStrategy(YtFSM.YtFSMUpdateStrategy.CacheStrategy);
  }
  
  public void enterFirst()
  {
    Object localObject1 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
    ((YtFSMBaseState)localObject1).handleStateAction("reset_timeout", null);
    Object localObject2 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_FETCH_STATE));
    Object localObject3;
    if (localObject2 != null) {
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
        localObject3 = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("action enter first failed:");
        localStringBuilder.append(localException.getLocalizedMessage());
        YtLogger.e((String)localObject3, localStringBuilder.toString());
      }
    }
    if (!this.controlConfig.isEmpty())
    {
      String[] arrayOfString = this.controlConfig.split("&");
      if (arrayOfString.length > 0)
      {
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          localObject3 = arrayOfString[i].split("=");
          if ((localObject3.length > 1) && (localObject3[0].equals("actref_ux_mode"))) {
            this.actReflectUXMode = Integer.parseInt(localObject3[1]);
          }
          i += 1;
        }
      }
    }
    this.tracker = ((YTFaceTracker)((YtFSMBaseState)localObject1).getStateDataBy("detect_instance"));
    this.mOriginParam = this.tracker.getParam();
    localObject1 = this.mOriginParam;
    ((YTFaceTracker.Param)localObject1).detInterval = this.actionFrameNum;
    this.tracker.setParam((YTFaceTracker.Param)localObject1);
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
    int i = 0;
    try
    {
      if (paramJSONObject.has("resource_online")) {
        this.isLoadResourceOnline = paramJSONObject.getBoolean("resource_online");
      }
      if (paramJSONObject.has("video_path"))
      {
        this.innerMp4Path = paramJSONObject.getString("video_path");
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString.getFilesDir());
        ((StringBuilder)localObject1).append("/temp.mp4");
        this.innerMp4Path = ((StringBuilder)localObject1).toString();
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
      this.actionFrameNum = paramJSONObject.optInt("action_frame_num", 20);
      this.lastActionFrameNum = paramJSONObject.optInt("last_action_frame_num", 3);
      this.needCheckMultiFaces = paramJSONObject.optBoolean("need_check_multiface", false);
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      localObject1 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("action load failed1:");
      ((StringBuilder)localObject2).append(paramString.getLocalizedMessage());
      YtLogger.e((String)localObject1, ((StringBuilder)localObject2).toString());
    }
    if (!this.isLoadResourceOnline) {
      FileUtils.loadLibrary("YTPoseDetect");
    }
    paramString = YTPoseDetectJNIInterface.getVersion();
    Object localObject1 = TAG;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("YTPose Version: ");
    ((StringBuilder)localObject2).append(paramString);
    YtLogger.i((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = paramString.split("\\.");
    localObject2 = this.legitimatePoseVersion;
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Wanted YTPose Version: ");
    localStringBuilder.append((String)localObject2);
    YtLogger.i(str, localStringBuilder.toString());
    localObject2 = ((String)localObject2).split("\\.");
    if (Integer.parseInt(localObject1[0]) != Integer.parseInt(localObject2[0])) {
      sendFSMEvent(new ActionLivenessState.1(this, paramString));
    } else if (Integer.parseInt(localObject1[1]) != Integer.parseInt(localObject2[1])) {
      sendFSMEvent(new ActionLivenessState.2(this, paramString));
    } else if (Integer.parseInt(localObject1[2]) < Integer.parseInt(localObject2[2])) {
      YtFSM.getInstance().sendFSMEvent(new ActionLivenessState.3(this, paramString));
    }
    int j = YTPoseDetectInterface.initModel();
    if (j != 0)
    {
      paramString = TAG;
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("action load failed2: ");
      paramJSONObject.append(j);
      YtLogger.e(paramString, paramJSONObject.toString());
      YtSDKStats.getInstance().reportError(j, "failed to init pose sdk");
      YtFSM.getInstance().sendFSMEvent(new ActionLivenessState.4(this, j));
      return;
    }
    this.continuousDetectCount = 0;
    this.stateData.put("action_type", Integer.valueOf(this.actionLiveType));
    try
    {
      if (paramJSONObject.has("action_security_level")) {
        this.securityLevel = paramJSONObject.getInt("action_security_level");
      }
      paramString = paramJSONObject.getJSONArray("action_default_seq");
      if (paramString == null)
      {
        YtSDKStats.getInstance().reportError(3145728, "yt_param_error");
        return;
      }
      this.actionDataParsed = new String[paramString.length()];
      while (i < paramString.length())
      {
        this.actionDataParsed[i] = paramString.getString(i);
        i += 1;
      }
      paramString = TAG;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("load action sequence from sdkconfig ");
      ((StringBuilder)localObject1).append(paramJSONObject.getString("action_default_seq"));
      ((StringBuilder)localObject1).append(" size :");
      ((StringBuilder)localObject1).append(this.actionDataParsed.length);
      YtLogger.d(paramString, ((StringBuilder)localObject1).toString());
    }
    catch (JSONException paramString)
    {
      localObject1 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("action load failed3: ");
      ((StringBuilder)localObject2).append(paramString.getLocalizedMessage());
      YtLogger.e((String)localObject1, ((StringBuilder)localObject2).toString());
      this.actionDataParsed = "0".split(" ");
    }
    try
    {
      if (paramJSONObject.has("action_inner_settings"))
      {
        paramString = paramJSONObject.getJSONObject("action_inner_settings");
        paramJSONObject = paramString.keys();
        while (paramJSONObject.hasNext())
        {
          localObject1 = (String)paramJSONObject.next();
          YTPoseDetectJNIInterface.updateParam((String)localObject1, paramString.getString((String)localObject1));
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramJSONObject = TAG;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("action load failed4: ");
      ((StringBuilder)localObject1).append(paramString.getLocalizedMessage());
      YtLogger.d(paramJSONObject, ((StringBuilder)localObject1).toString());
      YTPoseDetectJNIInterface.configNativeLog(true);
      YTPoseDetectJNIInterface.updateParam("log_level", "3");
      paramString = new StringBuilder();
      paramString.append("");
      paramString.append(this.actionFrameNum);
      YTPoseDetectJNIInterface.updateParam("frame_num", paramString.toString());
      paramString = new StringBuilder();
      paramString.append("");
      paramString.append(this.lastActionFrameNum);
      YTPoseDetectJNIInterface.updateParam("last_frame_num", paramString.toString());
      YTPoseDetectJNIInterface.setLoggerListener(new ActionLivenessState.5(this));
      this.currentRotateState = YtFSM.getInstance().getContext().currentRotateState;
      this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE;
      this.videoEncoder = new YtVideoEncoder(null, true);
      YTPoseDetectJNIInterface.setSafetyLevel(this.securityLevel);
      this.bestFrames = new ArrayList();
      reset();
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
    YtVideoEncoder localYtVideoEncoder = this.videoEncoder;
    if (localYtVideoEncoder != null)
    {
      localYtVideoEncoder.abortEncoding();
      this.videoEncoder.stopEncoding();
      this.videoEncoder = null;
    }
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    super.update(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramLong);
    Object localObject = this.faceStatus;
    if ((localObject != null) && (localObject.length > 0))
    {
      paramInt3 = this.continuousDetectCount;
      if (paramInt3 > 0)
      {
        if ((paramInt3 <= 1) || ((this.needCheckMultiFaces) && (this.poseState == 7)))
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
        localObject = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("pose count");
        localStringBuilder.append(this.poseReadyCount);
        localStringBuilder.append(" stable ");
        localStringBuilder.append(this.stableCountNum);
        localStringBuilder.append(" isAction");
        localStringBuilder.append(this.isActionFinished);
        YtLogger.d((String)localObject, localStringBuilder.toString());
        if ((this.poseReadyCount > this.stableCountNum + 10) && (!this.isActionFinished))
        {
          localObject = TAG;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("tips:");
          localStringBuilder.append(getTipsByPoseType(this.actionLiveType));
          YtLogger.d((String)localObject, localStringBuilder.toString());
          sendFSMEvent(new ActionLivenessState.8(this));
        }
        YTPoseDetectInterface.poseDetect(this.faceStatus[0].faceShape, this.faceStatus[0].faceVisible, this.actionLiveType, paramArrayOfByte, paramInt1, paramInt2, this.faceStatus[0].pitch, this.faceStatus[0].yaw, this.faceStatus[0].roll, this.actionFrameHandler, 1);
        this.poseReadyCount += 1;
        AddOptPose(paramArrayOfByte, paramInt1, paramInt2, this.faceStatus[0].faceShape, this.faceStatus[0].pitch, this.faceStatus[0].yaw, this.faceStatus[0].roll);
      }
    }
    moveToNextState();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState
 * JD-Core Version:    0.7.0.1
 */