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
      QMLog.d("AudioJsPlugin", "handleOnRecordEnd, tempFilePath:" + paramString + ", duration:" + paramLong1 + ", fileSize:" + paramLong2);
      localJSONObject.put("tempFilePath", paramString);
      localJSONObject.put("duration", paramLong1);
      localJSONObject.put("fileSize", paramLong2);
      QMLog.d("AudioJsPlugin", "handleOnRecordEnd : " + this.isRecordManagerApi);
      if (this.isRecordManagerApi)
      {
        localJSONObject.put("state", "stop");
        AudioJsPlugin.access$3100(this.this$0, "onRecorderStateChange", localJSONObject.toString());
        return;
      }
      this.startRecordReq.ok(localJSONObject);
      if (this.stopRecordReq != null)
      {
        this.stopRecordReq.ok();
        this.stopRecordReq = null;
        return;
      }
    }
    catch (Exception paramString)
    {
      handleRecordFail("onRecordEnd exception");
    }
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
    QMLog.d("AudioJsPlugin", "handleRecordFail : " + this.isRecordManagerApi);
    if (this.isRecordManagerApi)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("state", "error");
        localJSONObject.put("errMsg", "recordError:" + paramString);
        AudioJsPlugin.access$3200(this.this$0, "onRecorderStateChange", localJSONObject.toString());
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
    QMLog.e("AudioJsPlugin", "AudioManager.onRecorderNotReady() is called,path is:" + paramString);
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
    JSONObject localJSONObject;
    if (paramArrayOfByte != null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("state", "frameRecorded");
      NativeBuffer.packNativeBuffer(null, paramArrayOfByte, NativeBuffer.TYPE_BUFFER_BASE64, "frameBuffer", localJSONObject);
      localJSONObject.put("isLastFrame", paramBoolean);
      AudioJsPlugin.access$2900(this.this$0, "onRecorderStateChange", localJSONObject.toString());
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      while (!QMLog.isColorLevel()) {}
      QMLog.e("AudioJsPlugin", "onRecordFrame failed! " + Log.getStackTraceString(paramArrayOfByte));
    }
  }
  
  public void onRecordPause()
  {
    QMLog.d("AudioJsPlugin", "onRecordPause : " + this.isRecordManagerApi);
    JSONObject localJSONObject;
    if (this.isRecordManagerApi) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("state", "pause");
      AudioJsPlugin.access$2700(this.this$0, "onRecorderStateChange", localJSONObject.toString());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onRecordResume()
  {
    QMLog.d("AudioJsPlugin", "onRecordResume : " + this.isRecordManagerApi);
    JSONObject localJSONObject;
    if (this.isRecordManagerApi) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("state", "resume");
      AudioJsPlugin.access$2800(this.this$0, "onRecorderStateChange", localJSONObject.toString());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onRecordStart()
  {
    QMLog.d("AudioJsPlugin", "onRecordStart : " + this.isRecordManagerApi);
    JSONObject localJSONObject;
    if (this.isRecordManagerApi) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("state", "start");
      AudioJsPlugin.access$2600(this.this$0, "onRecorderStateChange", localJSONObject.toString());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QMLog.e("AudioJsPlugin", localException.getMessage());
    }
  }
  
  public void onRecordStop(String paramString, long paramLong1, long paramLong2)
  {
    if (this.recorder == null) {}
    int i;
    do
    {
      return;
      i = getFateOfRecorder();
      QMLog.d("AudioJsPlugin", "onRecordStop, fateOfRecorder is:" + i + ", recordFilePath:" + paramString);
      if (i == 0)
      {
        handleOnRecordEnd(paramString, paramLong1, paramLong2);
        return;
      }
    } while (i != 1);
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
    if ((((File)localObject).exists()) && (((File)localObject).canWrite()))
    {
      i = 1;
      if ((!Environment.getExternalStorageState().equals("mounted")) || (i == 0)) {
        break label182;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject = DeviceInfoUtil.getSDCardMemory();
        if ((new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() > 1) && (localObject != null) && (localObject[1] > 2L))
        {
          if (AudioHelper.isForbidByRubbishMeizu(1))
          {
            QMLog.i("AudioJsPlugin", "startRecord() " + this.context.getString(R.string.mini_sdk_microphone_forbidden));
            paramRequestEvent.fail();
            return;
            i = 0;
            break;
            label182:
            i = 0;
            continue;
          }
          QMLog.d("AudioJsPlugin", "startRecord() is called");
          if (this.recorder == null) {
            this.recorder = getLameMp3Recorder();
          }
          paramRequestEvent = this.recorder.getRecordFilPath();
          QMLog.i("AudioJsPlugin", "path: " + paramRequestEvent);
          ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).muteAudioFocus(this.context, true);
          this.recorder.recordStart();
          setFateOfRecorder(0);
          return;
        }
        QMLog.d("AudioJsPlugin", "startRecord() " + this.context.getString(R.string.mini_sdk_sdcard_full_no_send));
        paramRequestEvent.fail();
        return;
      }
    }
    QMLog.w("AudioJsPlugin", "startRecord() " + this.context.getString(R.string.mini_sdk_nosdcardnosend));
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