package com.tencent.youtu.sdkkitframework.liveness;

import android.content.Context;
import android.graphics.YuvImage;
import android.os.Environment;
import android.util.Log;
import com.tencent.youtu.lipreader.jni.YTLipReader;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import com.tencent.youtu.sdkkitframework.common.FileUtils;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSDKStats;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper.StateClassName;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYTBaseFunctionListener;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtFrameworkFireEventType;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKPlatformContext;
import com.tencent.youtu.ytfacetrack.YTFaceTrack.FaceStatus;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LipReadLivenessState
  extends YtFSMBaseState
{
  private static final String TAG = LipReadLivenessState.class.getSimpleName();
  private String[] actionDataParsed;
  long beginTimeMs;
  private boolean canTransit;
  private int continuousDetectCount = 0;
  private int currentRotateState = YtFSM.getInstance().getContext().currentRotateState;
  long endTimeMs;
  private YTFaceTrack.FaceStatus[] faceStatus;
  private String innerAudioPath = Environment.getExternalStorageDirectory().getPath() + "/tmpaudio.spx";
  private boolean isFinished;
  private boolean isLoadResourceOnline = false;
  private YTFaceTrack.FaceStatus[] lastFaceStatus;
  private YuvImage lastFrame;
  private boolean needCheckPose = false;
  private boolean needManualTrigger = false;
  private YtSDKKitCommon.StateNameHelper.StateClassName nextStateName;
  private int numIntervalMs = 1000;
  private SilentLivenessState.FacePreviewingAdvise poseState = SilentLivenessState.FacePreviewingAdvise.ADVISE_NAN;
  YTLipReader ytLipReader;
  
  private void clearData()
  {
    this.isFinished = false;
    this.canTransit = false;
    this.poseState = SilentLivenessState.FacePreviewingAdvise.ADVISE_NAN;
    this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE;
    if (this.ytLipReader != null) {
      this.ytLipReader.reset();
    }
  }
  
  private void sendCancelFailEvent()
  {
    Object localObject;
    if (this.poseState == SilentLivenessState.FacePreviewingAdvise.ADVISE_NOT_IN_RECT) {
      localObject = "fl_pose_not_in_rect";
    }
    for (;;)
    {
      String str = CommonUtils.makeMessageJson(4194304, (String)localObject, "LipRead check failed");
      YtSDKStats.getInstance().reportError(4194304, (String)localObject);
      localObject = new HashMap();
      ((HashMap)localObject).put("ui_tips", "rst_failed");
      ((HashMap)localObject).put("ui_action", "process_finished");
      ((HashMap)localObject).put("process_action", "failed");
      ((HashMap)localObject).put("error_code", Integer.valueOf(4194304));
      ((HashMap)localObject).put("error_reason_code", Integer.valueOf(4194304));
      ((HashMap)localObject).put("message", str);
      YtFSM.getInstance().sendFSMEvent((HashMap)localObject);
      return;
      if (this.poseState == SilentLivenessState.FacePreviewingAdvise.ADVISE_TOO_FAR) {
        localObject = "fl_pose_closer";
      } else if (this.poseState == SilentLivenessState.FacePreviewingAdvise.ADVISE_TOO_CLOSE) {
        localObject = "fl_pose_farer";
      } else if (this.poseState == SilentLivenessState.FacePreviewingAdvise.ADVISE_INCORRECT_POSTURE) {
        localObject = "fl_pose_keep";
      } else if (this.poseState == SilentLivenessState.FacePreviewingAdvise.ADVISE_NO_FACE) {
        localObject = "fl_no_face";
      } else {
        localObject = "fl_act_silence";
      }
    }
  }
  
  public void enter()
  {
    super.enter();
    try
    {
      Object localObject = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
      this.poseState = ((SilentLivenessState.FacePreviewingAdvise)((YtFSMBaseState)localObject).getStateDataBy("pose_state"));
      this.continuousDetectCount = ((Integer)((YtFSMBaseState)localObject).getStateDataBy("continuous_detect_count")).intValue();
      this.faceStatus = ((YTFaceTrack.FaceStatus[])((YtFSMBaseState)localObject).getStateDataBy("face_status"));
      this.lastFaceStatus = ((YTFaceTrack.FaceStatus[])((YtFSMBaseState)localObject).getStateDataBy("last_face_status"));
      this.lastFrame = ((YuvImage)((YtFSMBaseState)localObject).getStateDataBy("last_frame"));
      localObject = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_FETCH_STATE));
      if (localObject != null)
      {
        localObject = (String)((YtFSMBaseState)localObject).getStateDataBy("action_data");
        YtLogger.d(TAG, "action data :" + (String)localObject);
        this.actionDataParsed = ((String)localObject).split(",");
        this.stateData.put("action_seq", this.actionDataParsed);
      }
      return;
    }
    catch (Exception localException)
    {
      YtLogger.e(TAG, "lipread enter failed " + localException.getLocalizedMessage());
      CommonUtils.reportException("lipread enter failed ", localException);
    }
  }
  
  public void enterFirst()
  {
    this.beginTimeMs = System.currentTimeMillis();
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
    Log.d(TAG, "LipReading loadStateWith.....");
    super.loadStateWith(paramString, paramJSONObject);
    try
    {
      if (paramJSONObject.has("force_pose_check")) {
        this.needCheckPose = paramJSONObject.getBoolean("force_pose_check");
      }
      if (paramJSONObject.has("manual_trigger")) {
        this.needManualTrigger = paramJSONObject.getBoolean("manual_trigger");
      }
      paramString = paramJSONObject.getJSONArray("action_default_seq");
      if (paramString == null)
      {
        YtSDKStats.getInstance().reportError(3145728, "yt_param_error");
        YtLogger.e(TAG, "Failed to load action data");
        return;
      }
      this.actionDataParsed = new String[paramString.length()];
      int i = 0;
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
        YtLogger.e(TAG, "lipread load failed1:" + paramString.getLocalizedMessage());
        this.actionDataParsed = "0".split(",");
      }
    }
    this.isFinished = false;
    this.canTransit = false;
    YtFSM.getInstance().getContext().currentAppContext.getFilesDir().getAbsolutePath();
    try
    {
      if (paramJSONObject.has("resource_online")) {
        this.isLoadResourceOnline = paramJSONObject.getBoolean("resource_online");
      }
      if (paramJSONObject.has("audio_path")) {
        this.innerAudioPath = paramJSONObject.getString("audio_path");
      }
      if (paramJSONObject.has("num_interval_ms")) {
        this.numIntervalMs = paramJSONObject.getInt("num_interval_ms");
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        YtLogger.e(TAG, "lipread load failed2:" + paramString.getLocalizedMessage());
      }
    }
    if (!this.isLoadResourceOnline) {
      FileUtils.loadLibrary("YTLipReader");
    }
    this.ytLipReader = new YTLipReader();
    this.ytLipReader.init();
    YtLogger.i(TAG, "YTLipReader Version: " + this.ytLipReader.getVersion());
    this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE;
    this.stateData.put("action_seq", this.actionDataParsed);
  }
  
  public void moveToNextState()
  {
    super.moveToNextState();
    this.endTimeMs = System.currentTimeMillis();
    Object localObject2;
    Object localObject3;
    if (this.endTimeMs - this.beginTimeMs > this.actionDataParsed.length * this.numIntervalMs)
    {
      this.isFinished = true;
      Object localObject1 = null;
      if (YtFSM.getInstance().getContext().baseFunctionListener != null) {
        localObject1 = YtFSM.getInstance().getContext().baseFunctionListener.getVoiceData();
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject3 = localObject1;
        }
        try
        {
          FileInputStream localFileInputStream = new FileInputStream(new File(this.innerAudioPath));
          localObject2 = localObject1;
          localObject3 = localObject1;
          if (localFileInputStream.available() != 0)
          {
            localObject3 = localObject1;
            localObject2 = new byte[localFileInputStream.available()];
          }
          localObject3 = localObject2;
          localFileInputStream.read((byte[])localObject2);
          localObject3 = localObject2;
          localFileInputStream.close();
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            YtLogger.e(TAG, "fetch audio data failed:" + localIOException.getLocalizedMessage());
            localObject2 = localObject3;
          }
        }
        if (localObject2 == null) {
          YtLogger.e(TAG, "fetch audio data failed");
        }
        this.stateData.put("audio_data", localObject2);
        localObject1 = this.ytLipReader.feature();
        if (localObject1 == null) {
          YtLogger.e(TAG, "feature is null");
        }
        this.stateData.put("feature", localObject1);
        localObject1 = this.ytLipReader.lipReadingFeature();
        if (localObject1 == null) {
          YtLogger.e(TAG, "lipread feature is null");
        }
        this.stateData.put("lipreading_feature", localObject1);
        this.stateData.put("last_frame", this.lastFrame);
        this.stateData.put("face_extra_list", this.ytLipReader.getImageListJsonStr());
        if (this.lastFaceStatus == null) {
          YtLogger.e(TAG, "last frame landmark is null");
        }
        this.stateData.put("last_frame_landmark", this.lastFaceStatus[0].xys5p);
        this.canTransit = true;
        return;
        YtLogger.w(TAG, "Base function listener for getting voice data not found");
      }
    }
    YtFSM.getInstance().transitNextRound(YtSDKKitCommon.StateNameHelper.classNameOfState(this.nextStateName));
  }
  
  public void reset()
  {
    clearData();
    super.reset();
  }
  
  public void unload()
  {
    if (this.ytLipReader != null) {
      this.ytLipReader = null;
    }
    super.unload();
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    super.update(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramLong);
    if (!this.isFinished) {
      if (((this.needCheckPose) && (this.poseState != SilentLivenessState.FacePreviewingAdvise.ADVISE_PASS)) || ((this.faceStatus != null) && (this.faceStatus.length > 1)) || (this.poseState == SilentLivenessState.FacePreviewingAdvise.ADVISE_NO_FACE))
      {
        this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.IDLE_STATE;
        YtLogger.d(TAG, "lipread cancel with pose type " + this.poseState);
        sendCancelFailEvent();
        moveToNextState();
      }
    }
    while (!this.canTransit) {
      for (;;)
      {
        return;
        this.ytLipReader.feed(this.faceStatus[0].xys, paramArrayOfByte, paramInt1, paramInt2, this.currentRotateState, this.faceStatus[0].pitch, this.faceStatus[0].yaw, this.faceStatus[0].roll);
      }
    }
    YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_LIVENESS_REQ_RESULT_STATE));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.LipReadLivenessState
 * JD-Core Version:    0.7.0.1
 */