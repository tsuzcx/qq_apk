package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.app.Activity;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import bbbr;
import bbct;
import com.tencent.mobileqq.mini.appbrand.utils.FileUtils;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.audiorecorder.LameMp3Recorder;
import com.tencent.mobileqq.mini.audiorecorder.LameMp3Recorder.AudioPlayerListener;
import com.tencent.mobileqq.mini.audiorecorder.LameMp3Recorder.AudioRecordListener;
import com.tencent.mobileqq.mini.audiorecorder.LameMp3Recorder.OnErrorListener;
import com.tencent.mobileqq.mini.sdk.BridgeInfo;
import com.tencent.mobileqq.minigame.manager.GameLoadManager;
import com.tencent.mobileqq.minigame.utils.NativeBuffer;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
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
  private BridgeInfo playVoiceBidge;
  private volatile LameMp3Recorder recorder;
  private BridgeInfo startRecordBridge;
  private BridgeInfo stopRecordBridge;
  
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
    paramString = MiniAppFileManager.getInstance().getTmpPath(paramString);
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
      paramString = MiniAppFileManager.getInstance().getWxFilePath(paramString);
      QLog.d("[mini] AudioJsPlugin", 1, "handleOnRecordEnd, tempFilePath:" + paramString + ", duration:" + paramLong1 + ", fileSize:" + paramLong2);
      localJSONObject.put("tempFilePath", paramString);
      localJSONObject.put("duration", paramLong1);
      localJSONObject.put("fileSize", paramLong2);
      QLog.d("[mini] AudioJsPlugin", 1, "handleOnRecordEnd : " + this.isRecordManagerApi);
      if (this.isRecordManagerApi)
      {
        localJSONObject.put("state", "stop");
        AudioJsPlugin.access$1500(this.this$0, "onRecorderStateChange", localJSONObject.toString());
        return;
      }
      AudioJsPlugin.access$1400(this.this$0, "startRecord", this.startRecordBridge, localJSONObject);
      if (this.stopRecordBridge != null)
      {
        AudioJsPlugin.access$1300(this.this$0, "stopRecord", this.stopRecordBridge);
        this.stopRecordBridge = null;
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
      AudioJsPlugin.access$1200(this.this$0, "playVoice", this.playVoiceBidge);
      return;
    }
    AudioJsPlugin.access$1400(this.this$0, "playVoice", this.playVoiceBidge, null);
  }
  
  private void handleRecordFail(String paramString)
  {
    QLog.d("[mini] AudioJsPlugin", 1, "handleRecordFail : " + this.isRecordManagerApi);
    if (this.isRecordManagerApi)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("state", "error");
        localJSONObject.put("errMsg", "recordError:" + paramString);
        AudioJsPlugin.access$1500(this.this$0, "onRecorderStateChange", localJSONObject.toString());
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    AudioJsPlugin.access$1200(this.this$0, "startRecord", this.startRecordBridge);
  }
  
  private int parseAudioType(String paramString)
  {
    int j = 0;
    int i = j;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.toLowerCase();
      if (!paramString.endsWith(".slk")) {
        break label29;
      }
      i = 1;
    }
    label29:
    do
    {
      return i;
      i = j;
    } while (!paramString.endsWith(".amr"));
    return 0;
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
    QLog.e("[mini] AudioJsPlugin", 2, "AudioManager.onRecorderNotReady() is called,path is:" + paramString);
    AudioJsPlugin.access$1200(this.this$0, "startRecord", this.startRecordBridge);
  }
  
  public void onPlayFinish()
  {
    QLog.d("[mini] AudioJsPlugin", 2, "onPlayFinish");
    releasePlayer();
    AudioJsPlugin.access$1400(this.this$0, "playVoice", this.playVoiceBidge, null);
  }
  
  public void onPlayPause()
  {
    QLog.d("[mini] AudioJsPlugin", 2, "onPlayPause");
  }
  
  public void onPlayResume()
  {
    QLog.d("[mini] AudioJsPlugin", 2, "onPlayResume");
  }
  
  public void onPlayStart()
  {
    QLog.d("[mini] AudioJsPlugin", 2, "onPlayStart");
  }
  
  public void onPlayStop()
  {
    QLog.d("[mini] AudioJsPlugin", 2, "onPlayStop");
    releasePlayer();
    AudioJsPlugin.access$1400(this.this$0, "playVoice", this.playVoiceBidge, null);
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
      NativeBuffer.packNativeBuffer(paramArrayOfByte, NativeBuffer.TYPE_BUFFER_BASE64, "frameBuffer", localJSONObject, GameLoadManager.g().getGameEngine().getNativeBufferPool());
      localJSONObject.put("isLastFrame", paramBoolean);
      AudioJsPlugin.access$1500(this.this$0, "onRecorderStateChange", localJSONObject.toString());
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      while (!this.this$0.isColorLevel()) {}
      this.this$0.miniLogE("[mini] AudioJsPlugin", 2, "onRecordFrame failed! " + Log.getStackTraceString(paramArrayOfByte));
    }
  }
  
  public void onRecordPause()
  {
    QLog.d("[mini] AudioJsPlugin", 2, "onRecordPause : " + this.isRecordManagerApi);
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
    QLog.d("[mini] AudioJsPlugin", 2, "onRecordResume : " + this.isRecordManagerApi);
    JSONObject localJSONObject;
    if (this.isRecordManagerApi) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("state", "resume");
      AudioJsPlugin.access$1500(this.this$0, "onRecorderStateChange", localJSONObject.toString());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onRecordStart()
  {
    QLog.d("[mini] AudioJsPlugin", 1, "onRecordStart : " + this.isRecordManagerApi);
    JSONObject localJSONObject;
    if (this.isRecordManagerApi) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("state", "start");
      AudioJsPlugin.access$1500(this.this$0, "onRecorderStateChange", localJSONObject.toString());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.e("[mini] AudioJsPlugin", 1, localException, new Object[0]);
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
      QLog.d("[mini] AudioJsPlugin", 2, "onRecordStop, fateOfRecorder is:" + i + ", recordFilePath:" + paramString);
      if (i == 0)
      {
        handleOnRecordEnd(paramString, paramLong1, paramLong2);
        return;
      }
    } while (i != 1);
  }
  
  public void onRecordUpdate(int paramInt1, int paramInt2) {}
  
  public void pauseVoice(BridgeInfo paramBridgeInfo)
  {
    if (this.recorder != null)
    {
      this.recorder.playPause();
      AudioJsPlugin.access$1400(this.this$0, "pauseVoice", paramBridgeInfo, null);
      return;
    }
    AudioJsPlugin.access$1200(this.this$0, "pauseVoice", paramBridgeInfo);
  }
  
  public void playVoice(String paramString, BridgeInfo paramBridgeInfo)
  {
    this.playVoiceBidge = paramBridgeInfo;
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
  
  public void startRecord(BridgeInfo paramBridgeInfo, boolean paramBoolean)
  {
    QLog.i("[mini] AudioJsPlugin", 2, "startRecord() begin");
    this.startRecordBridge = paramBridgeInfo;
    this.isRecordManagerApi = paramBoolean;
    if ((this.recorder != null) && (this.recorder.isRecording()))
    {
      if (this.this$0.isColorLevel()) {
        this.this$0.miniLogD("[mini] AudioJsPlugin", 2, "startRecord() is recording now");
      }
      return;
    }
    Object localObject = Environment.getExternalStorageDirectory();
    int i;
    if ((((File)localObject).exists()) && (((File)localObject).canWrite()))
    {
      i = 1;
      if ((!Environment.getExternalStorageState().equals("mounted")) || (i == 0)) {
        break label218;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject = bbct.b();
        if ((new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() > 1) && (localObject != null) && (localObject[1] > 2L))
        {
          if (AudioHelper.b(1))
          {
            if (this.this$0.isColorLevel()) {
              this.this$0.miniLogD("[mini] AudioJsPlugin", 2, "startRecord() " + this.context.getString(2131698463));
            }
            AudioJsPlugin.access$1200(this.this$0, "startRecord", paramBridgeInfo);
            return;
            i = 0;
            break;
            label218:
            i = 0;
            continue;
          }
          QLog.d("[mini] AudioJsPlugin", 2, "startRecord() is called");
          if (this.recorder == null) {
            this.recorder = getLameMp3Recorder();
          }
          paramBridgeInfo = this.recorder.getRecordFilPath();
          QLog.i("QQRecorder", 2, "path: " + paramBridgeInfo);
          bbbr.a(this.context, true);
          this.recorder.recordStart();
          setFateOfRecorder(0);
          return;
        }
        QLog.d("[mini] AudioJsPlugin", 2, "startRecord() " + this.context.getString(2131719049));
        AudioJsPlugin.access$1200(this.this$0, "startRecord", paramBridgeInfo);
        return;
      }
    }
    QLog.w("[mini] AudioJsPlugin", 2, "startRecord() " + this.context.getString(2131694693));
    AudioJsPlugin.access$1200(this.this$0, "startRecord", paramBridgeInfo);
  }
  
  public void stopRecord(int paramInt, BridgeInfo paramBridgeInfo, boolean paramBoolean)
  {
    this.isRecordManagerApi = paramBoolean;
    this.stopRecordBridge = paramBridgeInfo;
    if (this.recorder != null)
    {
      this.recorder.recordStop();
      AudioJsPlugin.access$1300(this.this$0, "stopRecord", this.stopRecordBridge);
      return;
    }
    AudioJsPlugin.access$1200(this.this$0, "stopRecord", this.stopRecordBridge);
  }
  
  public void stopVoice(BridgeInfo paramBridgeInfo)
  {
    if (this.recorder != null)
    {
      this.recorder.playStop();
      AudioJsPlugin.access$1300(this.this$0, "stopVoice", paramBridgeInfo);
      return;
    }
    AudioJsPlugin.access$1200(this.this$0, "stopVoice", paramBridgeInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.AudioJsPlugin.AudioManager
 * JD-Core Version:    0.7.0.1
 */