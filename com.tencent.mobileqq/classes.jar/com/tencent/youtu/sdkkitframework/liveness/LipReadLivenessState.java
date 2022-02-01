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
  private static final String TAG = LipReadLivenessState.class.getSimpleName();
  private String[] actionDataParsed;
  private int audioBitRate = 64000;
  private int audioDelay;
  private int audioSampleRate = 44100;
  private int backendProtoType = 0;
  long beginTimeMs;
  private YTFaceTracker.TrackedFace bestFaceStatus;
  private YuvImage bestFrame;
  private boolean canTransit;
  private int codecSettingBitRate = 2097152;
  private int codecSettingFrameRate = 30;
  private int codecSettingiFrameInterval = 1;
  private int continuousDetectCount = 0;
  private int currentRotateState = YtFSM.getInstance().getContext().currentRotateState;
  long endTimeMs;
  private YTFaceTracker.TrackedFace[] faceStatus;
  private String innerAudioPath = Environment.getExternalStorageDirectory().getPath() + "/tmpaudio.spx";
  private String innerMp4Path = Environment.getExternalStorageDirectory().getPath() + "/lipreadtemp.mp4";
  private boolean isFinished;
  private boolean isLoadResourceOnline = false;
  private YuvImage lastFrame;
  private boolean needCheckMultiFace = false;
  private boolean needCheckPose = true;
  private boolean needManualTrigger = false;
  private YtSDKKitCommon.StateNameHelper.StateClassName nextStateName;
  private int numIntervalMs = 1000;
  private int poseState = -1;
  private YtVideoEncoder videoEncoder;
  YTLipReader ytLipReader;
  
  private void clearData()
  {
    this.isFinished = false;
    this.canTransit = false;
    this.poseState = -1;
    this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE;
    if ((this.backendProtoType != 2) && (this.videoEncoder != null))
    {
      this.videoEncoder.abortEncoding();
      this.videoEncoder = null;
    }
    if (this.ytLipReader != null) {
      this.ytLipReader.reset();
    }
  }
  
  private void sendCancelFailEvent()
  {
    Object localObject = SilentLivenessState.convertAdvise(this.poseState);
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
    Camera.Size localSize;
    int i;
    if (this.backendProtoType != 2)
    {
      localSize = YtFSM.getInstance().getContext().currentCamera.getParameters().getPreviewSize();
      if (YtFSM.getInstance().getContext().currentRotateState < 5) {
        break label112;
      }
      i = localSize.height;
    }
    for (int j = localSize.width;; j = localSize.height)
    {
      this.videoEncoder = new YtVideoEncoder(null, true);
      this.videoEncoder.startAudioVideoEncoding(i, j, new File(this.innerMp4Path), this.codecSettingBitRate, this.codecSettingFrameRate, this.codecSettingiFrameInterval, this.audioSampleRate, this.audioBitRate, this.audioDelay);
      return;
      label112:
      i = localSize.width;
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
    for (;;)
    {
      try
      {
        if (paramJSONObject.has("force_pose_check")) {
          this.needCheckPose = paramJSONObject.getBoolean("force_pose_check");
        }
        if (paramJSONObject.has("manual_trigger")) {
          this.needManualTrigger = paramJSONObject.getBoolean("manual_trigger");
        }
        if (!paramJSONObject.has("video_path")) {
          continue;
        }
        this.innerMp4Path = paramJSONObject.getString("video_path");
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
        if (paramString != null) {
          continue;
        }
        YtSDKStats.getInstance().reportError(3145728, "yt_param_error");
        YtLogger.e(TAG, "Failed to load action data");
        this.actionDataParsed = "0".split(",");
      }
      catch (JSONException paramString)
      {
        YtLogger.e(TAG, "lipread load failed1:" + paramString.getLocalizedMessage());
        this.actionDataParsed = "0".split(",");
        continue;
        this.actionDataParsed = new String[paramString.length()];
        i = 0;
        if (i >= paramString.length()) {
          continue;
        }
        this.actionDataParsed[i] = paramString.getString(i);
        i += 1;
        continue;
        this.innerAudioPath = (YtFSM.getInstance().getContext().currentAppContext.getFilesDir() + "/tmpaudio.spx");
        continue;
      }
      YtLogger.d(TAG, "load action sequence from sdkconfig " + paramJSONObject.getString("action_default_seq") + " size :" + this.actionDataParsed.length);
      this.isFinished = false;
      this.canTransit = false;
      YtFSM.getInstance().getContext().currentAppContext.getFilesDir().getAbsolutePath();
      try
      {
        if (paramJSONObject.has("resource_online")) {
          this.isLoadResourceOnline = paramJSONObject.getBoolean("resource_online");
        }
        if (!paramJSONObject.has("audio_path")) {
          continue;
        }
        this.innerAudioPath = paramJSONObject.getString("audio_path");
        if (paramJSONObject.has("num_interval_ms")) {
          this.numIntervalMs = paramJSONObject.getInt("num_interval_ms");
        }
      }
      catch (Exception paramString)
      {
        int i;
        paramString.printStackTrace();
        YtLogger.e(TAG, "lipread load failed2:" + paramString.getLocalizedMessage());
        continue;
      }
      if (!this.isLoadResourceOnline) {
        FileUtils.loadLibrary("YTLipReader");
      }
      this.ytLipReader = new YTLipReader();
      this.ytLipReader.init();
      YtLogger.i(TAG, "YTLipReader Version: " + this.ytLipReader.getVersion());
      this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE;
      this.stateData.put("action_seq", this.actionDataParsed);
      return;
      this.innerMp4Path = (YtFSM.getInstance().getContext().currentAppContext.getFilesDir() + "/lipreadtemp.mp4");
    }
  }
  
  public void moveToNextState()
  {
    super.moveToNextState();
    this.endTimeMs = System.currentTimeMillis();
    if (this.endTimeMs - this.beginTimeMs > this.actionDataParsed.length * this.numIntervalMs)
    {
      this.isFinished = true;
      Object localObject3 = null;
      Object localObject5 = null;
      Object localObject1 = null;
      FileInputStream localFileInputStream;
      if (this.backendProtoType == 2)
      {
        if (YtFSM.getInstance().getContext().baseFunctionListener != null)
        {
          localObject1 = YtFSM.getInstance().getContext().baseFunctionListener.getVoiceData();
          localObject3 = localObject1;
          if (localObject1 == null) {
            localObject5 = localObject1;
          }
        }
        try
        {
          localFileInputStream = new FileInputStream(new File(this.innerAudioPath));
          localObject3 = localObject1;
          localObject5 = localObject1;
          if (localFileInputStream.available() != 0)
          {
            localObject5 = localObject1;
            localObject3 = new byte[localFileInputStream.available()];
          }
          localObject5 = localObject3;
          localFileInputStream.read((byte[])localObject3);
          localObject5 = localObject3;
          localFileInputStream.close();
        }
        catch (IOException localIOException1)
        {
          for (;;)
          {
            label147:
            YtLogger.e(TAG, "fetch audio data failed:" + localIOException1.getLocalizedMessage());
            localObject3 = localObject5;
          }
        }
        if (localObject3 == null) {
          YtLogger.e(TAG, "fetch audio data failed");
        }
        this.stateData.put("audio_data", localObject3);
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
        this.stateData.put("last_frame", this.bestFrame);
        this.stateData.put("face_extra_list", this.ytLipReader.getImageListJsonStr());
        if (this.bestFaceStatus != null) {
          break label443;
        }
        YtLogger.e(TAG, "last frame landmark is null");
      }
      for (;;)
      {
        for (;;)
        {
          this.canTransit = true;
          return;
          YtLogger.w(TAG, "Base function listener for getting voice data not found");
          break;
          this.videoEncoder.stopEncoding();
          Object localObject2 = localObject5;
          try
          {
            localFileInputStream = new FileInputStream(new File(this.innerMp4Path));
            localObject2 = localObject5;
            if (localFileInputStream.available() != 0)
            {
              localObject2 = localObject5;
              localObject3 = new byte[localFileInputStream.available()];
            }
            localObject2 = localObject3;
            localFileInputStream.read((byte[])localObject3);
            localObject2 = localObject3;
            localFileInputStream.close();
          }
          catch (IOException localIOException2)
          {
            YtLogger.e(TAG, "Failed fetch action video " + localIOException2.getLocalizedMessage());
            Object localObject4 = localObject2;
          }
        }
        break label147;
        label443:
        this.stateData.put("last_frame_landmark", YtSDKKitCommon.ProcessHelper.convert90PTo5P(this.bestFaceStatus.faceShape));
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
    if ((this.backendProtoType != 2) && (this.videoEncoder != null))
    {
      this.videoEncoder.abortEncoding();
      this.videoEncoder = null;
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
    if (!this.isFinished) {
      if (((this.needCheckPose) && (this.poseState != 0) && (this.poseState != 9)) || ((this.needCheckMultiFace) && (this.poseState == 7)) || (this.poseState == 1))
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
        this.ytLipReader.feed(this.faceStatus[0].faceShape, paramArrayOfByte, paramInt1, paramInt2, this.currentRotateState, this.faceStatus[0].pitch, this.faceStatus[0].yaw, this.faceStatus[0].roll);
      }
    }
    YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_LIVENESS_REQ_RESULT_STATE));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.LipReadLivenessState
 * JD-Core Version:    0.7.0.1
 */