package com.tencent.qqmini.minigame.plugins;

import android.content.Context;
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
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.DeviceInfoUtil;
import java.io.File;
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
    String str2 = "mp3";
    String str1 = str2;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.toLowerCase();
      if (!paramString.endsWith("aac")) {
        break label31;
      }
      str1 = "m4a";
    }
    label31:
    do
    {
      return str1;
      str1 = str2;
    } while (!paramString.endsWith("mp3"));
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
    int j = 1;
    try
    {
      paramString = new JSONObject(paramString);
      this.recordTime = paramString.optLong("duration");
      long l;
      if (this.recordTime > 0L)
      {
        l = this.recordTime;
        this.recordTime = l;
        this.recordTime = Math.max(this.recordTime, 1000L);
        this.recordTime = Math.min(this.recordTime, 600000L);
        this.sampleRate = paramString.optInt("sampleRate");
        if (this.sampleRate <= 0) {
          break label289;
        }
        i = this.sampleRate;
        label92:
        this.sampleRate = i;
        this.inChannel = paramString.optInt("numberOfChannels");
        i = j;
        if (this.inChannel > 0) {
          i = this.inChannel;
        }
        this.inChannel = i;
        this.inChannel = Math.min(this.inChannel, 2);
        this.inChannel = 1;
        this.outBitRate = paramString.optInt("encodeBitRate");
        if (this.outBitRate <= 0) {
          break label296;
        }
        i = this.outBitRate;
        label165:
        this.outBitRate = i;
        this.outBitRate /= 1000;
        this.fileFormat = getAudioFormat(paramString.optString("format"));
        this.fileFormat = "mp3";
        this.frameSize = paramString.optInt("frameSize");
        if (this.frameSize < 0) {
          break label302;
        }
      }
      label289:
      label296:
      label302:
      for (int i = this.frameSize;; i = 0)
      {
        this.frameSize = i;
        this.frameSize = Math.min(this.frameSize, 100);
        this.frameSize *= 1024;
        this.audioSourceStr = paramString.optString("audioSource");
        if (TextUtils.isEmpty(this.audioSourceStr)) {
          this.audioSourceStr = "mic";
        }
        return;
        l = 60000L;
        break;
        i = 8000;
        break label92;
        i = 48000;
        break label165;
      }
      return;
    }
    catch (JSONException paramString)
    {
      QMLog.w(AudioRecorderJsPlugin.access$100(), "updateRecorderConfig fail", paramString);
    }
  }
  
  public void destroy()
  {
    try
    {
      this.context = null;
      this.iJsService = null;
      if (this.recorder != null) {
        this.recorder.recordStop();
      }
      return;
    }
    catch (Exception localException)
    {
      QMLog.e(AudioRecorderJsPlugin.access$100(), "destroy exception", localException);
    }
  }
  
  /* Error */
  public boolean isForbidByMeiZu(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 256	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 19
    //   5: if_icmpge +5 -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: ldc 35
    //   12: getstatic 261	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   15: invokevirtual 264	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   18: ifeq -10 -> 8
    //   21: aload_1
    //   22: ldc_w 266
    //   25: invokevirtual 272	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   28: astore_1
    //   29: aload_1
    //   30: ifnull +164 -> 194
    //   33: aload_1
    //   34: invokevirtual 276	java/lang/Object:getClass	()Ljava/lang/Class;
    //   37: invokevirtual 281	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   40: ldc 10
    //   42: invokevirtual 285	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   45: ifeq +149 -> 194
    //   48: aload_1
    //   49: invokevirtual 276	java/lang/Object:getClass	()Ljava/lang/Class;
    //   52: ldc 32
    //   54: iconst_3
    //   55: anewarray 278	java/lang/Class
    //   58: dup
    //   59: iconst_0
    //   60: getstatic 291	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   63: aastore
    //   64: dup
    //   65: iconst_1
    //   66: getstatic 291	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   69: aastore
    //   70: dup
    //   71: iconst_2
    //   72: ldc 85
    //   74: aastore
    //   75: invokevirtual 295	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   78: astore 4
    //   80: invokestatic 301	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   83: invokevirtual 305	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getContext	()Landroid/content/Context;
    //   86: invokevirtual 309	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   89: astore 5
    //   91: aload 4
    //   93: aload_1
    //   94: iconst_3
    //   95: anewarray 4	java/lang/Object
    //   98: dup
    //   99: iconst_0
    //   100: bipush 27
    //   102: invokestatic 313	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   105: aastore
    //   106: dup
    //   107: iconst_1
    //   108: aload 5
    //   110: getfield 318	android/content/pm/ApplicationInfo:uid	I
    //   113: invokestatic 313	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   116: aastore
    //   117: dup
    //   118: iconst_2
    //   119: aload 5
    //   121: getfield 321	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   124: aastore
    //   125: invokevirtual 327	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   128: checkcast 287	java/lang/Integer
    //   131: invokevirtual 331	java/lang/Integer:intValue	()I
    //   134: istore_2
    //   135: iload_2
    //   136: ifeq +33 -> 169
    //   139: iconst_1
    //   140: istore_3
    //   141: invokestatic 126	com/tencent/qqmini/minigame/plugins/AudioRecorderJsPlugin:access$100	()Ljava/lang/String;
    //   144: new 333	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 334	java/lang/StringBuilder:<init>	()V
    //   151: ldc_w 336
    //   154: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: iload_3
    //   158: invokevirtual 343	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   161: invokevirtual 346	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 350	com/tencent/qqmini/sdk/launcher/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   167: iload_3
    //   168: ireturn
    //   169: iconst_0
    //   170: istore_3
    //   171: goto -30 -> 141
    //   174: astore_1
    //   175: iconst_0
    //   176: istore_3
    //   177: invokestatic 126	com/tencent/qqmini/minigame/plugins/AudioRecorderJsPlugin:access$100	()Ljava/lang/String;
    //   180: ldc_w 352
    //   183: aload_1
    //   184: invokestatic 249	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   187: goto -20 -> 167
    //   190: astore_1
    //   191: goto -14 -> 177
    //   194: iconst_0
    //   195: istore_3
    //   196: goto -29 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	this	AudioManager
    //   0	199	1	paramContext	Context
    //   134	2	2	i	int
    //   140	56	3	bool	boolean
    //   78	14	4	localMethod	java.lang.reflect.Method
    //   89	31	5	localApplicationInfo	android.content.pm.ApplicationInfo
    // Exception table:
    //   from	to	target	type
    //   48	135	174	java/lang/Exception
    //   141	167	190	java/lang/Exception
  }
  
  public void onRecordError(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("state", "error");
      localJSONObject.put("errMsg", "recordError:" + paramString);
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
      QMLog.i(AudioRecorderJsPlugin.access$100(), "onRecordFrame length: " + paramArrayOfByte.length + " isLastFrame: " + paramBoolean);
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
      QMLog.d(AudioRecorderJsPlugin.access$100(), "onRecordStop tempFilePath: " + paramString + " duration: " + paramLong1 + " fileSize: " + paramLong2);
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
    int k = 0;
    if ((this.recorder != null) && (!this.recorder.isRecordIdle()))
    {
      paramRequestEvent.fail(this.context.getString(R.string.mini_game_record_is_recording_now));
      QMLog.w(AudioRecorderJsPlugin.access$100(), "startRecord fail " + this.context.getString(R.string.mini_game_record_is_recording_now));
      return;
    }
    if (!AudioRecorderJsPlugin.access$300(this.this$0))
    {
      paramRequestEvent.fail(this.context.getString(R.string.mini_game_record_so_load_error));
      QMLog.w(AudioRecorderJsPlugin.access$100(), "startRecord fail " + this.context.getString(R.string.mini_game_record_so_load_error));
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject = Environment.getExternalStorageDirectory();
        if ((((File)localObject).exists()) && (((File)localObject).canWrite()))
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
          if (j == 0) {
            break label448;
          }
          localObject = DeviceInfoUtil.getSDCardMemory();
          if ((new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() <= 1) || (localObject == null) || (localObject[1] <= 2L)) {
            break label397;
          }
          if (!isForbidByMeiZu(this.context)) {
            break;
          }
          paramRequestEvent.fail(this.context.getString(R.string.mini_game_record_microphone_forbidden));
          QMLog.w(AudioRecorderJsPlugin.access$100(), "startRecord fail " + this.context.getString(R.string.mini_game_record_microphone_forbidden));
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
    QMLog.i(AudioRecorderJsPlugin.access$100(), "startRecord initRecorder");
    initRecorder(paramRequestEvent.jsonParams);
    QMLog.i(AudioRecorderJsPlugin.access$100(), "startRecord path: " + this.recorder.getRecordFilePath());
    ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).muteAudioFocus(this.context, true);
    this.iJsService = paramRequestEvent.jsService;
    this.recorder.recordStart();
    paramRequestEvent.ok();
    return;
    label397:
    paramRequestEvent.fail(this.context.getString(R.string.mini_game_record_sdcard_full));
    QMLog.w(AudioRecorderJsPlugin.access$100(), "startRecord fail " + this.context.getString(R.string.mini_game_record_sdcard_full));
    return;
    label448:
    paramRequestEvent.fail(this.context.getString(R.string.mini_game_record_no_sdcard));
    QMLog.w(AudioRecorderJsPlugin.access$100(), "startRecord fail " + this.context.getString(R.string.mini_game_record_no_sdcard));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.AudioRecorderJsPlugin.AudioManager
 * JD-Core Version:    0.7.0.1
 */