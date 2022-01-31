package com.tencent.qqmini.sdk.runtime.plugin;

import android.app.Activity;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;
import bgnt;
import bgok;
import bgpc;
import bgpi;
import bher;
import bhes;
import bhet;
import bhev;
import bhis;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.DeviceInfoUtil;
import java.io.File;
import org.json.JSONObject;

class AudioJsPlugin$AudioManager
  implements bhes, bhet, bhev
{
  private long audioDuration = 60000L;
  private Activity context;
  private int fateOfRecorder = 0;
  private String fileFormat = "mp3";
  private boolean isRecordManagerApi;
  private int maxTime = 600;
  private bgok playVoiceReq;
  private volatile bher recorder;
  private bgok startRecordReq;
  private bgok stopRecordReq;
  
  private AudioJsPlugin$AudioManager(AudioJsPlugin paramAudioJsPlugin, Activity paramActivity)
  {
    this.context = paramActivity;
  }
  
  private int getFateOfRecorder()
  {
    return this.fateOfRecorder;
  }
  
  private bher getLameMp3Recorder()
  {
    if (this.recorder == null)
    {
      this.recorder = new bher(this.context);
      this.recorder.e(this.maxTime);
      this.recorder.a(this.audioDuration);
      this.recorder.c(this.fileFormat);
      this.recorder.a(getTransferFilePath(this.fileFormat));
      this.recorder.a(this);
      this.recorder.a(this);
      this.recorder.a(this);
    }
    return this.recorder;
  }
  
  private String getTransferFilePath(String paramString)
  {
    paramString = bgnt.a().b(paramString);
    try
    {
      bgpc.a(paramString);
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
      paramString = bgnt.a().e(paramString);
      QMLog.d("AudioJsPlugin", "handleOnRecordEnd, tempFilePath:" + paramString + ", duration:" + paramLong1 + ", fileSize:" + paramLong2);
      localJSONObject.put("tempFilePath", paramString);
      localJSONObject.put("duration", paramLong1);
      localJSONObject.put("fileSize", paramLong2);
      QMLog.d("AudioJsPlugin", "handleOnRecordEnd : " + this.isRecordManagerApi);
      if (this.isRecordManagerApi)
      {
        localJSONObject.put("state", "stop");
        AudioJsPlugin.access$1900(this.this$0, "onRecorderStateChange", localJSONObject.toString());
        return;
      }
      this.startRecordReq.a(localJSONObject);
      if (this.stopRecordReq != null)
      {
        this.stopRecordReq.a();
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
      this.playVoiceReq.b();
      return;
    }
    this.playVoiceReq.a();
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
        AudioJsPlugin.access$2000(this.this$0, "onRecorderStateChange", localJSONObject.toString());
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    this.startRecordReq.b();
  }
  
  private void releasePlayer()
  {
    if (this.recorder != null) {
      this.recorder.e();
    }
  }
  
  private void setFateOfRecorder(int paramInt)
  {
    this.fateOfRecorder = paramInt;
  }
  
  public boolean isRecording()
  {
    return (this.recorder != null) && (this.recorder.a());
  }
  
  public void onErrorInfo(String paramString)
  {
    paramString = getLameMp3Recorder().a();
    QMLog.e("AudioJsPlugin", "AudioManager.onRecorderNotReady() is called,path is:" + paramString);
    this.startRecordReq.b();
  }
  
  public void onPlayFinish()
  {
    QMLog.d("AudioJsPlugin", "onPlayFinish");
    releasePlayer();
    this.playVoiceReq.a();
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
    this.playVoiceReq.a();
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
      bgpi.a(AudioJsPlugin.access$1700(this.this$0), paramArrayOfByte, bgpi.b, "frameBuffer", localJSONObject);
      localJSONObject.put("isLastFrame", paramBoolean);
      AudioJsPlugin.access$1800(this.this$0, "onRecorderStateChange", localJSONObject.toString());
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
      AudioJsPlugin.access$1500(this.this$0, "onRecorderStateChange", localJSONObject.toString());
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
      AudioJsPlugin.access$1600(this.this$0, "onRecorderStateChange", localJSONObject.toString());
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
      AudioJsPlugin.access$1400(this.this$0, "onRecorderStateChange", localJSONObject.toString());
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
  
  public void pauseVoice(bgok parambgok)
  {
    if (this.recorder != null)
    {
      this.recorder.f();
      parambgok.a();
      return;
    }
    parambgok.b();
  }
  
  public void playVoice(String paramString, bgok parambgok)
  {
    this.playVoiceReq = parambgok;
    if (new File(paramString).exists())
    {
      if (this.recorder == null)
      {
        this.recorder = getLameMp3Recorder();
        this.recorder.a(this);
        this.recorder.d(paramString);
        return;
      }
      this.recorder.d(paramString);
      return;
    }
    handlePlayVoice(8);
  }
  
  public void release()
  {
    if (this.recorder != null) {
      this.recorder.g();
    }
  }
  
  public void startRecord(bgok parambgok, boolean paramBoolean)
  {
    QMLog.i("AudioJsPlugin", "startRecord() begin");
    this.startRecordReq = parambgok;
    this.isRecordManagerApi = paramBoolean;
    if ((this.recorder != null) && (this.recorder.a()))
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
          if (bhis.a(1))
          {
            QMLog.i("AudioJsPlugin", "startRecord() " + this.context.getString(2131694349));
            parambgok.b();
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
          parambgok = this.recorder.a();
          QMLog.i("AudioJsPlugin", "path: " + parambgok);
          ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).muteAudioFocus(this.context, true);
          this.recorder.a();
          setFateOfRecorder(0);
          return;
        }
        QMLog.d("AudioJsPlugin", "startRecord() " + this.context.getString(2131694403));
        parambgok.b();
        return;
      }
    }
    QMLog.w("AudioJsPlugin", "startRecord() " + this.context.getString(2131694351));
    parambgok.b();
  }
  
  public void stopRecord(int paramInt, bgok parambgok, boolean paramBoolean)
  {
    this.isRecordManagerApi = paramBoolean;
    this.stopRecordReq = parambgok;
    if (this.recorder != null)
    {
      this.recorder.b();
      parambgok.a();
      return;
    }
    parambgok.b();
  }
  
  public void stopVoice(bgok parambgok)
  {
    if (this.recorder != null)
    {
      this.recorder.e();
      parambgok.a();
      return;
    }
    parambgok.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.AudioJsPlugin.AudioManager
 * JD-Core Version:    0.7.0.1
 */