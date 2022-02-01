package com.tencent.youtu.sdkkitframework.liveness;

import android.content.Context;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Environment;
import android.util.Log;
import com.tencent.youtu.YTFaceTracker.TrackedFace;
import com.tencent.youtu.lipreader.jni.YTLipReader;
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
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYTBaseFunctionListener;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtFrameworkFireEventType;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKPlatformContext;
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
  private static final String TAG = "LipReadLivenessState";
  private String[] actionDataParsed;
  private int audioBitRate;
  private int audioDelay;
  private int audioSampleRate;
  private int backendProtoType;
  long beginTimeMs;
  private YTFaceTracker.TrackedFace bestFaceStatus;
  private YuvImage bestFrame;
  private boolean canTransit;
  private int codecSettingBitRate;
  private int codecSettingFrameRate;
  private int codecSettingiFrameInterval;
  private int continuousDetectCount = 0;
  private int currentRotateState = YtFSM.getInstance().getContext().currentRotateState;
  long endTimeMs;
  private YTFaceTracker.TrackedFace[] faceStatus;
  private String innerAudioPath;
  private String innerMp4Path;
  private boolean isFinished;
  private boolean isLoadResourceOnline;
  private YuvImage lastFrame;
  private boolean needCheckMultiFace;
  private boolean needCheckPose;
  private boolean needManualTrigger;
  private YtSDKKitCommon.StateNameHelper.StateClassName nextStateName;
  private int numIntervalMs;
  private int poseState = -1;
  private YtVideoEncoder videoEncoder;
  YTLipReader ytLipReader;
  
  public LipReadLivenessState()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
    localStringBuilder.append("/lipreadtemp.mp4");
    this.innerMp4Path = localStringBuilder.toString();
    this.isLoadResourceOnline = false;
    this.needCheckPose = true;
    this.numIntervalMs = 1000;
    this.needManualTrigger = false;
    this.codecSettingBitRate = 2097152;
    this.codecSettingFrameRate = 30;
    this.codecSettingiFrameInterval = 1;
    this.audioSampleRate = 44100;
    this.audioBitRate = 64000;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
    localStringBuilder.append("/tmpaudio.spx");
    this.innerAudioPath = localStringBuilder.toString();
    this.backendProtoType = 0;
    this.needCheckMultiFace = false;
  }
  
  private void clearData()
  {
    this.isFinished = false;
    this.canTransit = false;
    this.poseState = -1;
    this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE;
    if (this.backendProtoType != 2)
    {
      localObject = this.videoEncoder;
      if (localObject != null)
      {
        ((YtVideoEncoder)localObject).abortEncoding();
        this.videoEncoder = null;
      }
    }
    Object localObject = this.ytLipReader;
    if (localObject != null) {
      ((YTLipReader)localObject).reset();
    }
  }
  
  private void sendCancelFailEvent()
  {
    Object localObject = SilentLivenessState.convertAdvise(this.poseState);
    Integer localInteger = Integer.valueOf(4194304);
    String str = CommonUtils.makeMessageJson(4194304, (String)localObject, "LipRead check failed");
    YtSDKStats.getInstance().reportError(4194304, (String)localObject);
    localObject = new HashMap();
    ((HashMap)localObject).put("ui_tips", "rst_failed");
    ((HashMap)localObject).put("ui_action", "process_finished");
    ((HashMap)localObject).put("process_action", "failed");
    ((HashMap)localObject).put("error_code", localInteger);
    ((HashMap)localObject).put("error_reason_code", localInteger);
    ((HashMap)localObject).put("message", str);
    YtFSM.getInstance().sendFSMEvent((HashMap)localObject);
  }
  
  public void enter()
  {
    super.enter();
    try
    {
      Object localObject = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
      this.poseState = ((Integer)((YtFSMBaseState)localObject).getStateDataBy("pose_state")).intValue();
      this.continuousDetectCount = ((Integer)((YtFSMBaseState)localObject).getStateDataBy("continuous_detect_count")).intValue();
      this.faceStatus = ((YTFaceTracker.TrackedFace[])((YtFSMBaseState)localObject).getStateDataBy("face_status"));
      this.bestFaceStatus = ((YTFaceTracker.TrackedFace)((YtFSMBaseState)localObject).getStateDataBy("best_face_status"));
      this.bestFrame = ((YuvImage)((YtFSMBaseState)localObject).getStateDataBy("best_image"));
      this.lastFrame = ((YuvImage)((YtFSMBaseState)localObject).getStateDataBy("last_frame"));
      localObject = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_FETCH_STATE));
      if (localObject != null)
      {
        localObject = (String)((YtFSMBaseState)localObject).getStateDataBy("action_data");
        str = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("action data :");
        localStringBuilder.append((String)localObject);
        YtLogger.d(str, localStringBuilder.toString());
        this.actionDataParsed = ((String)localObject).split(",");
        this.stateData.put("action_seq", this.actionDataParsed);
        return;
      }
    }
    catch (Exception localException)
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("lipread enter failed ");
      localStringBuilder.append(localException.getLocalizedMessage());
      YtLogger.e(str, localStringBuilder.toString());
      CommonUtils.reportException("lipread enter failed ", localException);
    }
  }
  
  public void enterFirst()
  {
    this.beginTimeMs = System.currentTimeMillis();
    if (this.backendProtoType != 2)
    {
      Camera.Size localSize = YtFSM.getInstance().getContext().currentCamera.getParameters().getPreviewSize();
      int j;
      int i;
      if (YtFSM.getInstance().getContext().currentRotateState >= 5)
      {
        j = localSize.height;
        i = localSize.width;
      }
      else
      {
        j = localSize.width;
        i = localSize.height;
      }
      this.videoEncoder = new YtVideoEncoder(null, true);
      this.videoEncoder.startAudioVideoEncoding(j, i, new File(this.innerMp4Path), this.codecSettingBitRate, this.codecSettingFrameRate, this.codecSettingiFrameInterval, this.audioSampleRate, this.audioBitRate, this.audioDelay);
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
    Log.d(TAG, "LipReading loadStateWith.....");
    super.loadStateWith(paramString, paramJSONObject);
    Object localObject;
    try
    {
      if (paramJSONObject.has("force_pose_check")) {
        this.needCheckPose = paramJSONObject.getBoolean("force_pose_check");
      }
      if (paramJSONObject.has("manual_trigger")) {
        this.needManualTrigger = paramJSONObject.getBoolean("manual_trigger");
      }
      if (paramJSONObject.has("video_path"))
      {
        this.innerMp4Path = paramJSONObject.getString("video_path");
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append(YtFSM.getInstance().getContext().currentAppContext.getFilesDir());
        paramString.append("/lipreadtemp.mp4");
        this.innerMp4Path = paramString.toString();
      }
      if (paramJSONObject.has("backend_proto_type")) {
        this.backendProtoType = paramJSONObject.getInt("backend_proto_type");
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
      if (paramJSONObject.has("audio_bitrate")) {
        this.audioBitRate = paramJSONObject.getInt("audio_bitrate");
      }
      if (paramJSONObject.has("audio_samplerate")) {
        this.audioSampleRate = paramJSONObject.getInt("audio_samplerate");
      }
      this.audioDelay = paramJSONObject.optInt("audio_delay", 500);
      this.needCheckMultiFace = paramJSONObject.optBoolean("need_check_multiface", false);
      paramString = paramJSONObject.optJSONArray("action_default_seq");
      if (paramString == null)
      {
        YtSDKStats.getInstance().reportError(3145728, "yt_param_error");
        YtLogger.e(TAG, "Failed to load action data");
        this.actionDataParsed = "0".split(",");
      }
      else
      {
        this.actionDataParsed = new String[paramString.length()];
        int i = 0;
        while (i < paramString.length())
        {
          this.actionDataParsed[i] = paramString.getString(i);
          i += 1;
        }
      }
      paramString = TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("load action sequence from sdkconfig ");
      ((StringBuilder)localObject).append(paramJSONObject.getString("action_default_seq"));
      ((StringBuilder)localObject).append(" size :");
      ((StringBuilder)localObject).append(this.actionDataParsed.length);
      YtLogger.d(paramString, ((StringBuilder)localObject).toString());
    }
    catch (JSONException paramString)
    {
      localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("lipread load failed1:");
      localStringBuilder.append(paramString.getLocalizedMessage());
      YtLogger.e((String)localObject, localStringBuilder.toString());
      this.actionDataParsed = "0".split(",");
    }
    this.isFinished = false;
    this.canTransit = false;
    YtFSM.getInstance().getContext().currentAppContext.getFilesDir().getAbsolutePath();
    try
    {
      if (paramJSONObject.has("resource_online")) {
        this.isLoadResourceOnline = paramJSONObject.getBoolean("resource_online");
      }
      if (paramJSONObject.has("audio_path"))
      {
        this.innerAudioPath = paramJSONObject.getString("audio_path");
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append(YtFSM.getInstance().getContext().currentAppContext.getFilesDir());
        paramString.append("/tmpaudio.spx");
        this.innerAudioPath = paramString.toString();
      }
      if (paramJSONObject.has("num_interval_ms")) {
        this.numIntervalMs = paramJSONObject.getInt("num_interval_ms");
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      paramJSONObject = TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("lipread load failed2:");
      ((StringBuilder)localObject).append(paramString.getLocalizedMessage());
      YtLogger.e(paramJSONObject, ((StringBuilder)localObject).toString());
    }
    if (!this.isLoadResourceOnline) {
      FileUtils.loadLibrary("YTLipReader");
    }
    this.ytLipReader = new YTLipReader();
    this.ytLipReader.init();
    paramString = TAG;
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("YTLipReader Version: ");
    paramJSONObject.append(this.ytLipReader.getVersion());
    YtLogger.i(paramString, paramJSONObject.toString());
    this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE;
    this.stateData.put("action_seq", this.actionDataParsed);
  }
  
  public void moveToNextState()
  {
    super.moveToNextState();
    this.endTimeMs = System.currentTimeMillis();
    if (this.endTimeMs - this.beginTimeMs > this.actionDataParsed.length * this.numIntervalMs)
    {
      this.isFinished = true;
      Object localObject2 = null;
      Object localObject4 = null;
      byte[] arrayOfByte = null;
      Object localObject5;
      Object localObject3;
      if (this.backendProtoType == 2)
      {
        if (YtFSM.getInstance().getContext().baseFunctionListener != null) {
          arrayOfByte = YtFSM.getInstance().getContext().baseFunctionListener.getVoiceData();
        } else {
          YtLogger.w(TAG, "Base function listener for getting voice data not found");
        }
        localObject2 = arrayOfByte;
        if (arrayOfByte == null)
        {
          localObject4 = arrayOfByte;
          try
          {
            localObject5 = new FileInputStream(new File(this.innerAudioPath));
            localObject2 = arrayOfByte;
            localObject4 = arrayOfByte;
            if (((FileInputStream)localObject5).available() != 0)
            {
              localObject4 = arrayOfByte;
              localObject2 = new byte[((FileInputStream)localObject5).available()];
            }
            localObject4 = localObject2;
            ((FileInputStream)localObject5).read((byte[])localObject2);
            localObject4 = localObject2;
            ((FileInputStream)localObject5).close();
          }
          catch (IOException localIOException1)
          {
            localObject2 = TAG;
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append("fetch audio data failed:");
            ((StringBuilder)localObject5).append(localIOException1.getLocalizedMessage());
            YtLogger.e((String)localObject2, ((StringBuilder)localObject5).toString());
            localObject2 = localObject4;
          }
        }
      }
      else
      {
        this.videoEncoder.stopEncoding();
        localObject1 = localObject4;
        try
        {
          localObject5 = new FileInputStream(new File(this.innerMp4Path));
          localObject1 = localObject4;
          if (((FileInputStream)localObject5).available() != 0)
          {
            localObject1 = localObject4;
            localObject2 = new byte[((FileInputStream)localObject5).available()];
          }
          localObject1 = localObject2;
          ((FileInputStream)localObject5).read((byte[])localObject2);
          localObject1 = localObject2;
          ((FileInputStream)localObject5).close();
        }
        catch (IOException localIOException2)
        {
          localObject4 = TAG;
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("Failed fetch action video ");
          ((StringBuilder)localObject5).append(localIOException2.getLocalizedMessage());
          YtLogger.e((String)localObject4, ((StringBuilder)localObject5).toString());
          localObject3 = localObject1;
        }
      }
      if (localObject3 == null) {
        YtLogger.e(TAG, "fetch audio data failed");
      }
      this.stateData.put("audio_data", localObject3);
      Object localObject1 = this.ytLipReader.feature();
      if (localObject1 == null) {
        YtLogger.e(TAG, "feature is null");
      }
      this.stateData.put("feature", localObject1);
      localObject1 = this.ytLipReader.lipReadingFeature();
      if (localObject1 == null) {
        YtLogger.e(TAG, "lipread feature is null");
      }
      this.stateData.put("lipreading_feature", localObject1);
      this.stateData.put("last_frame", this.bestFrame);
      this.stateData.put("face_extra_list", this.ytLipReader.getImageListJsonStr());
      if (this.bestFaceStatus == null) {
        YtLogger.e(TAG, "last frame landmark is null");
      } else {
        this.stateData.put("last_frame_landmark", YtSDKKitCommon.ProcessHelper.convert90PTo5P(this.bestFaceStatus.faceShape));
      }
      this.canTransit = true;
      return;
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
    if (this.backendProtoType != 2)
    {
      YtVideoEncoder localYtVideoEncoder = this.videoEncoder;
      if (localYtVideoEncoder != null)
      {
        localYtVideoEncoder.abortEncoding();
        this.videoEncoder = null;
      }
    }
    super.unload();
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    super.update(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramLong);
    if (this.backendProtoType != 2)
    {
      this.videoEncoder.queueFrame(this.lastFrame);
      this.videoEncoder.encode();
    }
    if (!this.isFinished)
    {
      if (this.needCheckPose)
      {
        paramInt3 = this.poseState;
        if ((paramInt3 != 0) && (paramInt3 != 9)) {}
      }
      else
      {
        if (((!this.needCheckMultiFace) || (this.poseState != 7)) && (this.poseState != 1)) {
          break label148;
        }
      }
      this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.IDLE_STATE;
      paramArrayOfByte = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("lipread cancel with pose type ");
      localStringBuilder.append(this.poseState);
      YtLogger.d(paramArrayOfByte, localStringBuilder.toString());
      sendCancelFailEvent();
      break label198;
      label148:
      this.ytLipReader.feed(this.faceStatus[0].faceShape, paramArrayOfByte, paramInt1, paramInt2, this.currentRotateState, this.faceStatus[0].pitch, this.faceStatus[0].yaw, this.faceStatus[0].roll);
      label198:
      moveToNextState();
      return;
    }
    if (this.canTransit) {
      YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_LIVENESS_REQ_RESULT_STATE));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.LipReadLivenessState
 * JD-Core Version:    0.7.0.1
 */