package com.tencent.qqmini.minigame.plugins;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.qqmini.minigame.R.string;
import com.tencent.qqmini.minigame.audiorecorder.MiniGameLameMp3Recorder;
import com.tencent.qqmini.minigame.audiorecorder.MiniGameLameMp3Recorder.AudioRecordListener;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.core.utils.NativeBuffer;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.DeviceInfoUtil;
import java.io.File;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

class AudioRecorderJsPlugin$AudioManager
  implements MiniGameLameMp3Recorder.AudioRecordListener
{
  public static final String CLASS_NAME_APP_OPS_MANAGER = "AppOpsManager";
  private static final String DEFAULT_AUDIO_SOURCE = "mic";
  private static final String DEFAULT_FILE_FORMAT = "mp3";
  private static final int DEFAULT_FRAME_SIZE = 0;
  private static final int DEFAULT_IN_CHANNEL = 1;
  private static final int DEFAULT_OUT_BIT_RATE = 48000;
  private static final long DEFAULT_RECORD_TIME = 60000L;
  private static final int DEFAULT_SAMPLE_RATE = 8000;
  public static final String FUNCTION_NAME_CHECK_OP_NOT_THROW = "checkOpNoThrow";
  public static final String MANUFACTURER_MEI_ZU = "MeiZu";
  private static final int MAX_FRAME_SIZE = 100;
  private static final int MAX_IN_CHANNEL = 2;
  private static final long MAX_RECORD_TIME = 600000L;
  private static final long MIN_RECORD_TIME = 1000L;
  public static final int OP_RECORD_AUDIO = 27;
  private String audioSourceStr;
  private Context context;
  private String fileFormat;
  private int frameSize;
  private IJsService iJsService;
  private int inChannel;
  private int outBitRate;
  private long recordTime;
  private volatile MiniGameLameMp3Recorder recorder;
  private int sampleRate;
  
  private AudioRecorderJsPlugin$AudioManager(AudioRecorderJsPlugin paramAudioRecorderJsPlugin, Context paramContext)
  {
    this.context = paramContext;
  }
  
  private String getAudioFormat(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.toLowerCase();
      if (paramString.endsWith("aac")) {
        return "m4a";
      }
      paramString.endsWith("mp3");
    }
    return "mp3";
  }
  
  private String getTransferFilePath(String paramString)
  {
    paramString = ((MiniAppFileManager)AudioRecorderJsPlugin.access$200(this.this$0).getManager(MiniAppFileManager.class)).getTmpPath(paramString);
    try
    {
      FileUtils.createFile(paramString);
      return paramString;
    }
    catch (Exception localException)
    {
      QMLog.w(AudioRecorderJsPlugin.access$100(), "getTransferFilePath fail", localException);
    }
    return paramString;
  }
  
  private void initRecorder(String paramString)
  {
    if (this.recorder == null) {
      this.recorder = new MiniGameLameMp3Recorder();
    }
    updateRecorderConfig(paramString);
    this.recorder.initThread();
    this.recorder.setAudioRecordListener(this);
    this.recorder.setRecordFilePath(getTransferFilePath(this.fileFormat));
    this.recorder.setRecordTime(this.recordTime);
    this.recorder.setSampleRate(this.sampleRate);
    this.recorder.setInChannel(this.inChannel);
    this.recorder.setOutBitRate(this.outBitRate);
    this.recorder.setRecordFileFormat(this.fileFormat);
    this.recorder.setCallbackFrameSize(this.frameSize);
    this.recorder.setAudioSource(this.audioSourceStr);
  }
  
  private void updateRecorderConfig(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        this.recordTime = paramString.optLong("duration");
        if (this.recordTime <= 0L) {
          break label301;
        }
        l = this.recordTime;
        this.recordTime = l;
        this.recordTime = Math.max(this.recordTime, 1000L);
        this.recordTime = Math.min(this.recordTime, 600000L);
        this.sampleRate = paramString.optInt("sampleRate");
        if (this.sampleRate <= 0) {
          break label308;
        }
        i = this.sampleRate;
        this.sampleRate = i;
        this.inChannel = paramString.optInt("numberOfChannels");
        if (this.inChannel <= 0) {
          break label315;
        }
        i = this.inChannel;
        this.inChannel = i;
        this.inChannel = Math.min(this.inChannel, 2);
        this.inChannel = 1;
        this.outBitRate = paramString.optInt("encodeBitRate");
        if (this.outBitRate <= 0) {
          break label320;
        }
        i = this.outBitRate;
        this.outBitRate = i;
        this.outBitRate /= 1000;
        this.fileFormat = getAudioFormat(paramString.optString("format"));
        this.fileFormat = "mp3";
        this.frameSize = paramString.optInt("frameSize");
        if (this.frameSize < 0) {
          break label326;
        }
        i = this.frameSize;
        this.frameSize = i;
        this.frameSize = Math.min(this.frameSize, 100);
        this.frameSize *= 1024;
        this.audioSourceStr = paramString.optString("audioSource");
        if (TextUtils.isEmpty(this.audioSourceStr))
        {
          this.audioSourceStr = "mic";
          return;
        }
      }
      catch (JSONException paramString)
      {
        QMLog.w(AudioRecorderJsPlugin.access$100(), "updateRecorderConfig fail", paramString);
      }
      return;
      label301:
      long l = 60000L;
      continue;
      label308:
      int i = 8000;
      continue;
      label315:
      i = 1;
      continue;
      label320:
      i = 48000;
      continue;
      label326:
      i = 0;
    }
  }
  
  public void destroy()
  {
    try
    {
      this.context = null;
      this.iJsService = null;
      if (this.recorder != null)
      {
        this.recorder.recordStop();
        return;
      }
    }
    catch (Exception localException)
    {
      QMLog.e(AudioRecorderJsPlugin.access$100(), "destroy exception", localException);
    }
  }
  
  public boolean isForbidByMeiZu(Context paramContext)
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool2 = false;
    if (i < 19) {
      return false;
    }
    if (!"MeiZu".equalsIgnoreCase(Build.MANUFACTURER)) {
      return false;
    }
    paramContext = paramContext.getSystemService("appops");
    boolean bool1 = bool4;
    if (paramContext != null)
    {
      bool1 = bool4;
      if (paramContext.getClass().getSimpleName().equals("AppOpsManager"))
      {
        bool1 = bool3;
        try
        {
          Object localObject = paramContext.getClass().getMethod("checkOpNoThrow", new Class[] { Integer.TYPE, Integer.TYPE, String.class });
          bool1 = bool3;
          ApplicationInfo localApplicationInfo = AppLoaderFactory.g().getContext().getApplicationInfo();
          bool1 = bool3;
          if (((Integer)((Method)localObject).invoke(paramContext, new Object[] { Integer.valueOf(27), Integer.valueOf(localApplicationInfo.uid), localApplicationInfo.packageName })).intValue() != 0) {
            bool2 = true;
          }
          bool1 = bool2;
          paramContext = AudioRecorderJsPlugin.access$100();
          bool1 = bool2;
          localObject = new StringBuilder();
          bool1 = bool2;
          ((StringBuilder)localObject).append("isForbidByMeiZu result = ");
          bool1 = bool2;
          ((StringBuilder)localObject).append(bool2);
          bool1 = bool2;
          QMLog.i(paramContext, ((StringBuilder)localObject).toString());
          return bool2;
        }
        catch (Exception paramContext)
        {
          QMLog.e(AudioRecorderJsPlugin.access$100(), "isForbidByMeiZu fail", paramContext);
        }
      }
    }
    return bool1;
  }
  
  public void onRecordError(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("state", "error");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("recordError:");
      localStringBuilder.append(paramString);
      localJSONObject.put("errMsg", localStringBuilder.toString());
      AudioRecorderJsPlugin.access$1000(this.this$0, "onRecorderStateChange", localJSONObject.toString());
      return;
    }
    catch (Exception paramString)
    {
      QMLog.w(AudioRecorderJsPlugin.access$100(), "onRecordError fail", paramString);
    }
  }
  
  public void onRecordFrame(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("state", "frameRecorded");
      NativeBuffer.packNativeBuffer(this.iJsService, paramArrayOfByte, NativeBuffer.TYPE_BUFFER_NATIVE, "frameBuffer", localJSONObject);
      localJSONObject.put("isLastFrame", paramBoolean);
      String str = AudioRecorderJsPlugin.access$100();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRecordFrame length: ");
      localStringBuilder.append(paramArrayOfByte.length);
      localStringBuilder.append(" isLastFrame: ");
      localStringBuilder.append(paramBoolean);
      QMLog.i(str, localStringBuilder.toString());
      AudioRecorderJsPlugin.access$900(this.this$0, "onRecorderStateChange", localJSONObject.toString());
      return;
    }
    catch (JSONException paramArrayOfByte)
    {
      QMLog.e(AudioRecorderJsPlugin.access$100(), "onRecordFrame failed", paramArrayOfByte);
    }
  }
  
  public void onRecordPause()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("state", "pause");
      AudioRecorderJsPlugin.access$600(this.this$0, "onRecorderStateChange", localJSONObject.toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.w(AudioRecorderJsPlugin.access$100(), "onRecordPause fail", localJSONException);
    }
  }
  
  public void onRecordResume()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("state", "resume");
      AudioRecorderJsPlugin.access$500(this.this$0, "onRecorderStateChange", localJSONObject.toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.w(AudioRecorderJsPlugin.access$100(), "onRecordResume fail", localJSONException);
    }
  }
  
  public void onRecordStart()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("state", "start");
      AudioRecorderJsPlugin.access$400(this.this$0, "onRecorderStateChange", localJSONObject.toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.w(AudioRecorderJsPlugin.access$100(), "onRecordStart fail", localJSONException);
    }
  }
  
  public void onRecordStop(String paramString, long paramLong1, long paramLong2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      paramString = ((MiniAppFileManager)AudioRecorderJsPlugin.access$700(this.this$0).getManager(MiniAppFileManager.class)).getWxFilePath(paramString);
      String str = AudioRecorderJsPlugin.access$100();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRecordStop tempFilePath: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" duration: ");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(" fileSize: ");
      localStringBuilder.append(paramLong2);
      QMLog.d(str, localStringBuilder.toString());
      localJSONObject.put("state", "stop");
      localJSONObject.put("tempFilePath", paramString);
      localJSONObject.put("duration", paramLong1);
      localJSONObject.put("fileSize", paramLong2);
      AudioRecorderJsPlugin.access$800(this.this$0, "onRecorderStateChange", localJSONObject.toString());
      return;
    }
    catch (JSONException paramString)
    {
      QMLog.w(AudioRecorderJsPlugin.access$100(), "onRecordStop fail", paramString);
    }
  }
  
  public void pauseRecord(RequestEvent paramRequestEvent)
  {
    if (this.recorder == null)
    {
      paramRequestEvent.fail(this.context.getString(R.string.mini_game_record_do_not_start));
      return;
    }
    this.recorder.recordPause();
    paramRequestEvent.ok();
  }
  
  public void resumeRecord(RequestEvent paramRequestEvent)
  {
    if (this.recorder == null)
    {
      paramRequestEvent.fail(this.context.getString(R.string.mini_game_record_do_not_start));
      return;
    }
    this.recorder.recordResume();
    paramRequestEvent.ok();
  }
  
  public void startRecord(RequestEvent paramRequestEvent)
  {
    Object localObject;
    if ((this.recorder != null) && (!this.recorder.isRecordIdle()))
    {
      paramRequestEvent.fail(this.context.getString(R.string.mini_game_record_is_recording_now));
      paramRequestEvent = AudioRecorderJsPlugin.access$100();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startRecord fail ");
      ((StringBuilder)localObject).append(this.context.getString(R.string.mini_game_record_is_recording_now));
      QMLog.w(paramRequestEvent, ((StringBuilder)localObject).toString());
      return;
    }
    if (!AudioRecorderJsPlugin.access$300(this.this$0))
    {
      paramRequestEvent.fail(this.context.getString(R.string.mini_game_record_so_load_error));
      paramRequestEvent = AudioRecorderJsPlugin.access$100();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startRecord fail ");
      ((StringBuilder)localObject).append(this.context.getString(R.string.mini_game_record_so_load_error));
      QMLog.w(paramRequestEvent, ((StringBuilder)localObject).toString());
      return;
    }
    for (;;)
    {
      try
      {
        localObject = Environment.getExternalStorageDirectory();
        boolean bool = ((File)localObject).exists();
        int k = 0;
        if ((bool) && (((File)localObject).canWrite()))
        {
          i = 1;
          int j = k;
          if (Environment.getExternalStorageState().equals("mounted"))
          {
            j = k;
            if (i != 0) {
              j = 1;
            }
          }
          if (j != 0)
          {
            localObject = DeviceInfoUtil.getSDCardMemory();
            if ((new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() > 1) && (localObject != null) && (localObject[1] > 2L))
            {
              if (isForbidByMeiZu(this.context))
              {
                paramRequestEvent.fail(this.context.getString(R.string.mini_game_record_microphone_forbidden));
                localObject = AudioRecorderJsPlugin.access$100();
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("startRecord fail ");
                localStringBuilder.append(this.context.getString(R.string.mini_game_record_microphone_forbidden));
                QMLog.w((String)localObject, localStringBuilder.toString());
                return;
              }
              QMLog.i(AudioRecorderJsPlugin.access$100(), "startRecord initRecorder");
              initRecorder(paramRequestEvent.jsonParams);
              localObject = AudioRecorderJsPlugin.access$100();
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("startRecord path: ");
              localStringBuilder.append(this.recorder.getRecordFilePath());
              QMLog.i((String)localObject, localStringBuilder.toString());
              ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).muteAudioFocus(this.context, true);
              this.iJsService = paramRequestEvent.jsService;
              this.recorder.recordStart();
              paramRequestEvent.ok();
              return;
            }
            paramRequestEvent.fail(this.context.getString(R.string.mini_game_record_sdcard_full));
            localObject = AudioRecorderJsPlugin.access$100();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("startRecord fail ");
            localStringBuilder.append(this.context.getString(R.string.mini_game_record_sdcard_full));
            QMLog.w((String)localObject, localStringBuilder.toString());
            return;
          }
          paramRequestEvent.fail(this.context.getString(R.string.mini_game_record_no_sdcard));
          localObject = AudioRecorderJsPlugin.access$100();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("startRecord fail ");
          localStringBuilder.append(this.context.getString(R.string.mini_game_record_no_sdcard));
          QMLog.w((String)localObject, localStringBuilder.toString());
          return;
        }
      }
      catch (Exception localException)
      {
        paramRequestEvent.fail();
        QMLog.w(AudioRecorderJsPlugin.access$100(), "startRecord exception", localException);
        return;
      }
      int i = 0;
    }
  }
  
  public void stopRecord(RequestEvent paramRequestEvent)
  {
    if (this.recorder == null)
    {
      paramRequestEvent.fail(this.context.getString(R.string.mini_game_record_do_not_start));
      return;
    }
    this.recorder.recordStop();
    paramRequestEvent.ok();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.AudioRecorderJsPlugin.AudioManager
 * JD-Core Version:    0.7.0.1
 */