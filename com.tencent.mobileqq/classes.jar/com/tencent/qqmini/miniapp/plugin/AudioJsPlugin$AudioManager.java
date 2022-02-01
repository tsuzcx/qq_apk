package com.tencent.qqmini.miniapp.plugin;

import android.app.Activity;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;
import com.tencent.qqmini.miniapp.R.string;
import com.tencent.qqmini.miniapp.audiorecorder.LameMp3Recorder;
import com.tencent.qqmini.miniapp.audiorecorder.LameMp3Recorder.AudioPlayerListener;
import com.tencent.qqmini.miniapp.audiorecorder.LameMp3Recorder.AudioRecordListener;
import com.tencent.qqmini.miniapp.audiorecorder.LameMp3Recorder.OnErrorListener;
import com.tencent.qqmini.miniapp.util.AudioHelper;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.core.utils.NativeBuffer;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.DeviceInfoUtil;
import java.io.File;
import org.json.JSONObject;

class AudioJsPlugin$AudioManager
  implements LameMp3Recorder.AudioPlayerListener, LameMp3Recorder.AudioRecordListener, LameMp3Recorder.OnErrorListener
{
  private long audioDuration = 60000L;
  private Activity context;
  private int fateOfRecorder = 0;
  private String fileFormat = "mp3";
  private boolean isRecordManagerApi;
  private int maxTime = 600;
  private RequestEvent playVoiceReq;
  private volatile LameMp3Recorder recorder;
  private RequestEvent startRecordReq;
  private RequestEvent stopRecordReq;
  
  private AudioJsPlugin$AudioManager(AudioJsPlugin paramAudioJsPlugin, Activity paramActivity)
  {
    this.context = paramActivity;
  }
  
  private int getFateOfRecorder()
  {
    return this.fateOfRecorder;
  }
  
  private LameMp3Recorder getLameMp3Recorder()
  {
    if (this.recorder == null)
    {
      this.recorder = new LameMp3Recorder(this.context);
      this.recorder.setMaxRecordTime(this.maxTime);
      this.recorder.setRecordTime(this.audioDuration);
      this.recorder.setRecordFileFormat(this.fileFormat);
      this.recorder.setRecordFilPath(getTransferFilePath(this.fileFormat));
      this.recorder.setAudioRecordListener(this);
      this.recorder.setOnErrorListener(this);
      this.recorder.setOnPlayListener(this);
    }
    return this.recorder;
  }
  
  private String getTransferFilePath(String paramString)
  {
    paramString = ((MiniAppFileManager)AudioJsPlugin.access$2500(this.this$0).getManager(MiniAppFileManager.class)).getTmpPath(paramString);
    try
    {
      FileUtils.createFile(paramString);
      return paramString;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramString;
  }
  
  private void handleOnRecordEnd(String paramString, long paramLong1, long paramLong2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      paramString = ((MiniAppFileManager)AudioJsPlugin.access$3000(this.this$0).getManager(MiniAppFileManager.class)).getWxFilePath(paramString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleOnRecordEnd, tempFilePath:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", duration:");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(", fileSize:");
      localStringBuilder.append(paramLong2);
      QMLog.d("AudioJsPlugin", localStringBuilder.toString());
      localJSONObject.put("tempFilePath", paramString);
      localJSONObject.put("duration", paramLong1);
      localJSONObject.put("fileSize", paramLong2);
      paramString = new StringBuilder();
      paramString.append("handleOnRecordEnd : ");
      paramString.append(this.isRecordManagerApi);
      QMLog.d("AudioJsPlugin", paramString.toString());
      if (this.isRecordManagerApi)
      {
        localJSONObject.put("state", "stop");
        AudioJsPlugin.access$3100(this.this$0, "onRecorderStateChange", localJSONObject.toString());
        return;
      }
      this.startRecordReq.ok(localJSONObject);
      if (this.stopRecordReq == null) {
        break label226;
      }
      this.stopRecordReq.ok();
      this.stopRecordReq = null;
      return;
    }
    catch (Exception paramString)
    {
      label220:
      label226:
      break label220;
    }
    handleRecordFail("onRecordEnd exception");
  }
  
  private void handlePlayVoice(int paramInt)
  {
    if (paramInt == 8)
    {
      this.playVoiceReq.fail();
      return;
    }
    this.playVoiceReq.ok();
  }
  
  private void handleRecordFail(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleRecordFail : ");
    ((StringBuilder)localObject).append(this.isRecordManagerApi);
    QMLog.d("AudioJsPlugin", ((StringBuilder)localObject).toString());
    if (this.isRecordManagerApi)
    {
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("state", "error");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("recordError:");
        localStringBuilder.append(paramString);
        ((JSONObject)localObject).put("errMsg", localStringBuilder.toString());
        AudioJsPlugin.access$3200(this.this$0, "onRecorderStateChange", ((JSONObject)localObject).toString());
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    this.startRecordReq.fail();
  }
  
  private void releasePlayer()
  {
    if (this.recorder != null) {
      this.recorder.playStop();
    }
  }
  
  private void setFateOfRecorder(int paramInt)
  {
    this.fateOfRecorder = paramInt;
  }
  
  public boolean isRecording()
  {
    return (this.recorder != null) && (this.recorder.isRecording());
  }
  
  public void onErrorInfo(String paramString)
  {
    paramString = getLameMp3Recorder().getRecordFilPath();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AudioManager.onRecorderNotReady() is called,path is:");
    localStringBuilder.append(paramString);
    QMLog.e("AudioJsPlugin", localStringBuilder.toString());
    this.startRecordReq.fail();
  }
  
  public void onPlayFinish()
  {
    QMLog.d("AudioJsPlugin", "onPlayFinish");
    releasePlayer();
    this.playVoiceReq.ok();
  }
  
  public void onPlayPause()
  {
    QMLog.d("AudioJsPlugin", "onPlayPause");
  }
  
  public void onPlayResume()
  {
    QMLog.d("AudioJsPlugin", "onPlayResume");
  }
  
  public void onPlayStart()
  {
    QMLog.d("AudioJsPlugin", "onPlayStart");
  }
  
  public void onPlayStop()
  {
    QMLog.d("AudioJsPlugin", "onPlayStop");
    releasePlayer();
    this.playVoiceReq.ok();
  }
  
  public void onPlayUpdate(int paramInt1, int paramInt2) {}
  
  public void onRecordFrame(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramArrayOfByte != null)
    {
      Object localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("state", "frameRecorded");
        NativeBuffer.packNativeBuffer(null, paramArrayOfByte, NativeBuffer.TYPE_BUFFER_BASE64, "frameBuffer", (JSONObject)localObject);
        ((JSONObject)localObject).put("isLastFrame", paramBoolean);
        AudioJsPlugin.access$2900(this.this$0, "onRecorderStateChange", ((JSONObject)localObject).toString());
        return;
      }
      catch (Throwable paramArrayOfByte)
      {
        if (QMLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onRecordFrame failed! ");
          ((StringBuilder)localObject).append(Log.getStackTraceString(paramArrayOfByte));
          QMLog.e("AudioJsPlugin", ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  public void onRecordPause()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onRecordPause : ");
    ((StringBuilder)localObject).append(this.isRecordManagerApi);
    QMLog.d("AudioJsPlugin", ((StringBuilder)localObject).toString());
    if (this.isRecordManagerApi)
    {
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("state", "pause");
        AudioJsPlugin.access$2700(this.this$0, "onRecorderStateChange", ((JSONObject)localObject).toString());
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void onRecordResume()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onRecordResume : ");
    ((StringBuilder)localObject).append(this.isRecordManagerApi);
    QMLog.d("AudioJsPlugin", ((StringBuilder)localObject).toString());
    if (this.isRecordManagerApi)
    {
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("state", "resume");
        AudioJsPlugin.access$2800(this.this$0, "onRecorderStateChange", ((JSONObject)localObject).toString());
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void onRecordStart()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onRecordStart : ");
    ((StringBuilder)localObject).append(this.isRecordManagerApi);
    QMLog.d("AudioJsPlugin", ((StringBuilder)localObject).toString());
    if (this.isRecordManagerApi)
    {
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("state", "start");
        AudioJsPlugin.access$2600(this.this$0, "onRecorderStateChange", ((JSONObject)localObject).toString());
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QMLog.e("AudioJsPlugin", localException.getMessage());
      }
    }
  }
  
  public void onRecordStop(String paramString, long paramLong1, long paramLong2)
  {
    if (this.recorder == null) {
      return;
    }
    int i = getFateOfRecorder();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRecordStop, fateOfRecorder is:");
    localStringBuilder.append(i);
    localStringBuilder.append(", recordFilePath:");
    localStringBuilder.append(paramString);
    QMLog.d("AudioJsPlugin", localStringBuilder.toString());
    if (i == 0) {
      handleOnRecordEnd(paramString, paramLong1, paramLong2);
    }
  }
  
  public void onRecordUpdate(int paramInt1, int paramInt2) {}
  
  public void pauseVoice(RequestEvent paramRequestEvent)
  {
    if (this.recorder != null)
    {
      this.recorder.playPause();
      paramRequestEvent.ok();
      return;
    }
    paramRequestEvent.fail();
  }
  
  public void playVoice(String paramString, RequestEvent paramRequestEvent)
  {
    this.playVoiceReq = paramRequestEvent;
    if (new File(paramString).exists())
    {
      if (this.recorder == null)
      {
        this.recorder = getLameMp3Recorder();
        this.recorder.setOnPlayListener(this);
        this.recorder.playStart(paramString);
        return;
      }
      this.recorder.playStart(paramString);
      return;
    }
    handlePlayVoice(8);
  }
  
  public void release()
  {
    if (this.recorder != null) {
      this.recorder.onDestory();
    }
  }
  
  public void startRecord(RequestEvent paramRequestEvent, boolean paramBoolean)
  {
    QMLog.i("AudioJsPlugin", "startRecord() begin");
    this.startRecordReq = paramRequestEvent;
    this.isRecordManagerApi = paramBoolean;
    if ((this.recorder != null) && (this.recorder.isRecording()))
    {
      QMLog.i("AudioJsPlugin", "startRecord() is recording now");
      return;
    }
    Object localObject = Environment.getExternalStorageDirectory();
    int i;
    if ((((File)localObject).exists()) && (((File)localObject).canWrite())) {
      i = 1;
    } else {
      i = 0;
    }
    if ((Environment.getExternalStorageState().equals("mounted")) && (i != 0)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      localObject = DeviceInfoUtil.getSDCardMemory();
      if ((new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() > 1) && (localObject != null) && (localObject[1] > 2L))
      {
        if (AudioHelper.isForbidByRubbishMeizu(1))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("startRecord() ");
          ((StringBuilder)localObject).append(this.context.getString(R.string.mini_sdk_microphone_forbidden));
          QMLog.i("AudioJsPlugin", ((StringBuilder)localObject).toString());
          paramRequestEvent.fail();
          return;
        }
        QMLog.d("AudioJsPlugin", "startRecord() is called");
        if (this.recorder == null) {
          this.recorder = getLameMp3Recorder();
        }
        paramRequestEvent = this.recorder.getRecordFilPath();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("path: ");
        ((StringBuilder)localObject).append(paramRequestEvent);
        QMLog.i("AudioJsPlugin", ((StringBuilder)localObject).toString());
        ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).muteAudioFocus(this.context, true);
        this.recorder.recordStart();
        setFateOfRecorder(0);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startRecord() ");
      ((StringBuilder)localObject).append(this.context.getString(R.string.mini_sdk_sdcard_full_no_send));
      QMLog.d("AudioJsPlugin", ((StringBuilder)localObject).toString());
      paramRequestEvent.fail();
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startRecord() ");
    ((StringBuilder)localObject).append(this.context.getString(R.string.mini_sdk_nosdcardnosend));
    QMLog.w("AudioJsPlugin", ((StringBuilder)localObject).toString());
    paramRequestEvent.fail();
  }
  
  public void stopRecord(int paramInt, RequestEvent paramRequestEvent, boolean paramBoolean)
  {
    this.isRecordManagerApi = paramBoolean;
    this.stopRecordReq = paramRequestEvent;
    if (this.recorder != null)
    {
      this.recorder.recordStop();
      paramRequestEvent.ok();
      return;
    }
    paramRequestEvent.fail();
  }
  
  public void stopVoice(RequestEvent paramRequestEvent)
  {
    if (this.recorder != null)
    {
      this.recorder.playStop();
      paramRequestEvent.ok();
      return;
    }
    paramRequestEvent.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.AudioJsPlugin.AudioManager
 * JD-Core Version:    0.7.0.1
 */