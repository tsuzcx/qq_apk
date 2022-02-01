package com.tencent.qqmini.miniapp.audiorecorder;

import android.content.Context;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.qqmini.miniapp.R.string;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.task.MiniAppSoLoader;
import java.io.File;

public class LameMp3EncodeThread
  extends Thread
{
  public static final String TAG = LameMp3EncodeThread.class.getName();
  private boolean isPause = false;
  private boolean isRecording = false;
  private String mAudioFileFormat = "mp3";
  private int mAudioSource = 1;
  private int mCallbackFrameSize;
  private int mEncodingPcmFormat = 2;
  private int mInSampleRate = 8000;
  private Handler mMainHandler;
  private MediaPlayer mMediaPlayer;
  private boolean mNativeLoaded = false;
  private int mOutBitRate = 32;
  private int mOutChannel = 1;
  private int mOutSampleRate = 8000;
  private String mPlayFilePath;
  private int mQuality = 7;
  private String mRecordFilPath;
  private long mRecordTime = 60000L;
  private int mVoiceLevel;
  private LameMp3Recorder mp3Player;
  
  public LameMp3EncodeThread(LameMp3Recorder paramLameMp3Recorder, Handler paramHandler)
  {
    super(AppLoaderFactory.g().getContext().getResources().getString(R.string.mini_sdk_record_thread));
    this.mp3Player = paramLameMp3Recorder;
    this.mMainHandler = paramHandler;
    start();
    loadLameMp3So();
  }
  
  public static File createSDFile(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    File localFile;
    do
    {
      return paramString;
      localFile = new File(paramString);
      paramString = localFile;
    } while (localFile.exists());
    if (localFile.isDirectory())
    {
      localFile.mkdirs();
      return localFile;
    }
    localFile.createNewFile();
    return localFile;
  }
  
  private void loadLameMp3So()
  {
    this.mNativeLoaded = MiniAppSoLoader.g().isLameMp3SoLoaded();
    QMLog.e("[miniapp]-LameMp3Native", "mNativeLoaded : " + this.mNativeLoaded);
    if (!this.mNativeLoaded) {}
    try
    {
      this.mNativeLoaded = MiniAppSoLoader.g().loadLameMp3So();
      if (this.mNativeLoaded) {}
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          System.loadLibrary("mini_lamemp3");
          this.mNativeLoaded = true;
          QMLog.i("[miniapp]-LameMp3Native", "load so exception, load local libmini_lamemp3.so success!");
          return;
        }
        catch (Throwable localThrowable2)
        {
          this.mNativeLoaded = false;
          QMLog.i("[miniapp]-LameMp3Native", "load so exception, fail to load local libmini_lamemp3.so:" + this.mNativeLoaded, localThrowable2);
        }
        localThrowable1 = localThrowable1;
        QMLog.e("[miniapp]-LameMp3Native", "load so exception, fail to load network libmini_lamemp3.so:" + this.mNativeLoaded, localThrowable1);
      }
    }
  }
  
  private void onFrameRecord(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    Message localMessage;
    if ((this.mMainHandler != null) && (paramArrayOfByte != null))
    {
      localMessage = Message.obtain();
      localMessage.obj = paramArrayOfByte;
      localMessage.what = 6;
      if (!paramBoolean) {
        break label52;
      }
    }
    label52:
    for (int i = 1;; i = 0)
    {
      localMessage.arg1 = i;
      this.mMainHandler.sendMessage(localMessage);
      return;
    }
  }
  
  public int getAudioSource()
  {
    return this.mAudioSource;
  }
  
  public int getEncodingPcmFormat()
  {
    return this.mEncodingPcmFormat;
  }
  
  public int getInSampleRate()
  {
    return this.mInSampleRate;
  }
  
  public MediaPlayer getMediaPlayer()
  {
    if (this.mMediaPlayer == null) {
      this.mMediaPlayer = new MediaPlayer();
    }
    return this.mMediaPlayer;
  }
  
  public int getOutBitRate()
  {
    return this.mOutBitRate;
  }
  
  public int getOutChannel()
  {
    return this.mOutChannel;
  }
  
  public int getOutSampleRate()
  {
    return this.mOutSampleRate;
  }
  
  public void getPlayTime()
  {
    if (this.mMediaPlayer != null) {}
  }
  
  public int getQuality()
  {
    return this.mQuality;
  }
  
  public String getRecordFilPath()
  {
    return this.mRecordFilPath;
  }
  
  public long getRecordTime()
  {
    return this.mRecordTime;
  }
  
  public int getVoiceLevel()
  {
    return this.mVoiceLevel;
  }
  
  public int getVoiceSize(int paramInt, short[] paramArrayOfShort)
  {
    if (this.isRecording)
    {
      long l = 0L;
      int i = 0;
      try
      {
        while (i < paramArrayOfShort.length)
        {
          l += paramArrayOfShort[i] * paramArrayOfShort[i];
          i += 1;
        }
        paramInt = (int)(Math.log10(l / paramInt) * 10.0D) / 10;
        return paramInt - 1;
      }
      catch (Exception paramArrayOfShort)
      {
        paramArrayOfShort.printStackTrace();
      }
    }
    return 1;
  }
  
  public boolean isPause()
  {
    return this.isPause;
  }
  
  public boolean isRecording()
  {
    return this.isRecording;
  }
  
  public void onDestory()
  {
    stopPlay();
    restoreRecording();
  }
  
  public boolean play()
  {
    return play(this.mPlayFilePath);
  }
  
  public boolean play(String paramString)
  {
    if (this.isRecording)
    {
      QMLog.e(TAG, "请先关闭录音");
      return false;
    }
    if (this.mMediaPlayer == null) {
      this.mMediaPlayer = new MediaPlayer();
    }
    try
    {
      this.mMediaPlayer.setAudioStreamType(3);
      this.mMediaPlayer.setDataSource(paramString);
      this.mMediaPlayer.prepareAsync();
      this.mMediaPlayer.setOnPreparedListener(new LameMp3EncodeThread.1(this));
      this.mMediaPlayer.setOnCompletionListener(new LameMp3EncodeThread.2(this));
      return false;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      this.mMainHandler.sendMessage(LameMp3Recorder.generatePlayErrMsg(AppLoaderFactory.g().getContext().getResources().getString(R.string.mini_sdk_record_play_error)));
      stopPlay();
    }
    return false;
  }
  
  public boolean playPause()
  {
    if ((this.mMediaPlayer != null) && (this.mMediaPlayer.isPlaying()))
    {
      this.mMediaPlayer.pause();
      return true;
    }
    return false;
  }
  
  public boolean playResume()
  {
    if (this.mMediaPlayer != null)
    {
      this.mMediaPlayer.start();
      return true;
    }
    return false;
  }
  
  public void restoreRecording()
  {
    this.isRecording = false;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 94	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:isRecording	Z
    //   4: ifeq +13 -> 17
    //   7: getstatic 41	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:TAG	Ljava/lang/String;
    //   10: ldc_w 328
    //   13: invokestatic 331	com/tencent/qqmini/sdk/launcher/log/QMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: return
    //   17: aload_0
    //   18: getfield 240	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mRecordFilPath	Ljava/lang/String;
    //   21: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   24: ifeq +13 -> 37
    //   27: getstatic 41	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:TAG	Ljava/lang/String;
    //   30: ldc_w 333
    //   33: invokestatic 176	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: return
    //   37: aload_0
    //   38: getfield 102	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mNativeLoaded	Z
    //   41: ifne +37 -> 78
    //   44: aload_0
    //   45: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   48: ifnull -32 -> 16
    //   51: aload_0
    //   52: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   55: invokestatic 50	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   58: invokevirtual 54	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getContext	()Landroid/content/Context;
    //   61: invokevirtual 60	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   64: getstatic 336	com/tencent/qqmini/miniapp/R$string:mini_sdk_record_so_unload	I
    //   67: invokevirtual 71	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   70: invokestatic 339	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   73: invokevirtual 223	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   76: pop
    //   77: return
    //   78: bipush 237
    //   80: invokestatic 344	android/os/Process:setThreadPriority	(I)V
    //   83: aload_0
    //   84: getfield 84	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mInSampleRate	I
    //   87: bipush 16
    //   89: iconst_2
    //   90: invokestatic 350	android/media/AudioRecord:getMinBufferSize	(III)I
    //   93: istore 6
    //   95: iload 6
    //   97: ifge +37 -> 134
    //   100: aload_0
    //   101: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   104: ifnull -88 -> 16
    //   107: aload_0
    //   108: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   111: invokestatic 50	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   114: invokevirtual 54	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getContext	()Landroid/content/Context;
    //   117: invokevirtual 60	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   120: getstatic 353	com/tencent/qqmini/miniapp/R$string:mini_sdk_record_samplerate_error	I
    //   123: invokevirtual 71	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   126: invokestatic 339	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   129: invokevirtual 223	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   132: pop
    //   133: return
    //   134: aload_0
    //   135: getfield 84	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mInSampleRate	I
    //   138: iconst_2
    //   139: imul
    //   140: iconst_1
    //   141: imul
    //   142: iconst_5
    //   143: imul
    //   144: newarray short
    //   146: astore 14
    //   148: ldc2_w 354
    //   151: aload 14
    //   153: arraylength
    //   154: i2d
    //   155: ldc2_w 356
    //   158: dmul
    //   159: dadd
    //   160: d2i
    //   161: newarray byte
    //   163: astore 12
    //   165: aload_0
    //   166: getfield 359	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   169: ifle +1017 -> 1186
    //   172: aload_0
    //   173: getfield 359	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   176: newarray byte
    //   178: astore 10
    //   180: new 361	java/io/FileOutputStream
    //   183: dup
    //   184: aload_0
    //   185: getfield 240	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mRecordFilPath	Ljava/lang/String;
    //   188: invokestatic 363	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:createSDFile	(Ljava/lang/String;)Ljava/io/File;
    //   191: invokespecial 366	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   194: astore 11
    //   196: aload 11
    //   198: ifnonnull +123 -> 321
    //   201: getstatic 41	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:TAG	Ljava/lang/String;
    //   204: ldc_w 368
    //   207: invokestatic 176	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   210: aload_0
    //   211: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   214: ifnull -198 -> 16
    //   217: aload_0
    //   218: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   221: invokestatic 50	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   224: invokevirtual 54	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getContext	()Landroid/content/Context;
    //   227: invokevirtual 60	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   230: getstatic 371	com/tencent/qqmini/miniapp/R$string:mini_sdk_record_input_null	I
    //   233: invokevirtual 71	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   236: invokestatic 339	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   239: invokevirtual 223	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   242: pop
    //   243: return
    //   244: astore 8
    //   246: aload_0
    //   247: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   250: ifnull -234 -> 16
    //   253: aload_0
    //   254: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   257: invokestatic 50	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   260: invokevirtual 54	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getContext	()Landroid/content/Context;
    //   263: invokevirtual 60	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   266: getstatic 374	com/tencent/qqmini/miniapp/R$string:mini_sdk_record_mk_file_error	I
    //   269: invokevirtual 71	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   272: invokestatic 339	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   275: invokevirtual 223	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   278: pop
    //   279: return
    //   280: astore 8
    //   282: aload_0
    //   283: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   286: ifnull +29 -> 315
    //   289: aload_0
    //   290: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   293: invokestatic 50	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   296: invokevirtual 54	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getContext	()Landroid/content/Context;
    //   299: invokevirtual 60	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   302: getstatic 377	com/tencent/qqmini/miniapp/R$string:mini_sdk_record_wr_file_error	I
    //   305: invokevirtual 71	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   308: invokestatic 339	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   311: invokevirtual 223	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   314: pop
    //   315: aconst_null
    //   316: astore 11
    //   318: goto -122 -> 196
    //   321: aload_0
    //   322: getfield 84	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mInSampleRate	I
    //   325: aload_0
    //   326: getfield 88	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mOutChannel	I
    //   329: aload_0
    //   330: getfield 84	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mInSampleRate	I
    //   333: aload_0
    //   334: getfield 90	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mOutBitRate	I
    //   337: aload_0
    //   338: getfield 92	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mQuality	I
    //   341: invokestatic 383	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Native:jniInit	(IIIII)V
    //   344: aload_0
    //   345: iconst_1
    //   346: putfield 94	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:isRecording	Z
    //   349: aload_0
    //   350: iconst_0
    //   351: putfield 96	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:isPause	Z
    //   354: new 346	android/media/AudioRecord
    //   357: dup
    //   358: aload_0
    //   359: getfield 76	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mAudioSource	I
    //   362: aload_0
    //   363: getfield 84	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mInSampleRate	I
    //   366: bipush 16
    //   368: aload_0
    //   369: getfield 78	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mEncodingPcmFormat	I
    //   372: iload 6
    //   374: iconst_2
    //   375: imul
    //   376: invokespecial 385	android/media/AudioRecord:<init>	(IIIII)V
    //   379: astore 13
    //   381: aload 13
    //   383: invokevirtual 388	android/media/AudioRecord:startRecording	()V
    //   386: aload_0
    //   387: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   390: ifnull +802 -> 1192
    //   393: aload_0
    //   394: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   397: iconst_1
    //   398: invokevirtual 392	android/os/Handler:sendEmptyMessage	(I)Z
    //   401: pop
    //   402: goto +790 -> 1192
    //   405: aload_0
    //   406: getfield 94	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:isRecording	Z
    //   409: ifeq +764 -> 1173
    //   412: aload_0
    //   413: getfield 96	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:isPause	Z
    //   416: istore 7
    //   418: iload 7
    //   420: ifeq +56 -> 476
    //   423: iload_2
    //   424: ifne -19 -> 405
    //   427: iconst_1
    //   428: istore_2
    //   429: goto -24 -> 405
    //   432: astore 8
    //   434: aload_0
    //   435: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   438: ifnull +29 -> 467
    //   441: aload_0
    //   442: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   445: invokestatic 50	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   448: invokevirtual 54	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getContext	()Landroid/content/Context;
    //   451: invokevirtual 60	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   454: getstatic 395	com/tencent/qqmini/miniapp/R$string:mini_sdk_record_init_error	I
    //   457: invokevirtual 71	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   460: invokestatic 339	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   463: invokevirtual 223	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   466: pop
    //   467: invokestatic 398	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Native:jniClose	()V
    //   470: aload_0
    //   471: iconst_0
    //   472: putfield 94	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:isRecording	Z
    //   475: return
    //   476: iload_2
    //   477: ifeq +699 -> 1176
    //   480: iconst_0
    //   481: istore_2
    //   482: aload 13
    //   484: aload 14
    //   486: iconst_0
    //   487: iload 6
    //   489: invokevirtual 402	android/media/AudioRecord:read	([SII)I
    //   492: istore_3
    //   493: aload_0
    //   494: aload_0
    //   495: iload_3
    //   496: aload 14
    //   498: invokevirtual 404	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:getVoiceSize	(I[S)I
    //   501: putfield 245	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mVoiceLevel	I
    //   504: iload_3
    //   505: ifge +181 -> 686
    //   508: aload_0
    //   509: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   512: ifnull +661 -> 1173
    //   515: aload_0
    //   516: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   519: invokestatic 50	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   522: invokevirtual 54	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getContext	()Landroid/content/Context;
    //   525: invokevirtual 60	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   528: getstatic 407	com/tencent/qqmini/miniapp/R$string:mini_sdk_record_error	I
    //   531: invokevirtual 71	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   534: invokestatic 339	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   537: invokevirtual 223	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   540: pop
    //   541: goto +661 -> 1202
    //   544: aload_0
    //   545: aload 8
    //   547: iload 7
    //   549: invokespecial 409	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:onFrameRecord	([BZ)V
    //   552: iload_1
    //   553: ifle +25 -> 578
    //   556: iload_1
    //   557: newarray byte
    //   559: astore 8
    //   561: aload 10
    //   563: iconst_0
    //   564: aload 8
    //   566: iconst_0
    //   567: iload_1
    //   568: invokestatic 413	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   571: aload_0
    //   572: aload 8
    //   574: iconst_1
    //   575: invokespecial 409	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:onFrameRecord	([BZ)V
    //   578: aload 12
    //   580: invokestatic 417	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Native:jniFlush	([B)I
    //   583: istore_1
    //   584: iload_1
    //   585: ifge +36 -> 621
    //   588: aload_0
    //   589: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   592: ifnull +29 -> 621
    //   595: aload_0
    //   596: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   599: invokestatic 50	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   602: invokevirtual 54	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getContext	()Landroid/content/Context;
    //   605: invokevirtual 60	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   608: getstatic 420	com/tencent/qqmini/miniapp/R$string:mini_sdk_record_encode_error	I
    //   611: invokevirtual 71	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   614: invokestatic 339	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   617: invokevirtual 223	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   620: pop
    //   621: iload_1
    //   622: ifeq +12 -> 634
    //   625: aload 11
    //   627: aload 12
    //   629: iconst_0
    //   630: iload_1
    //   631: invokevirtual 424	java/io/FileOutputStream:write	([BII)V
    //   634: aload 11
    //   636: invokevirtual 427	java/io/FileOutputStream:close	()V
    //   639: aload 13
    //   641: invokevirtual 430	android/media/AudioRecord:stop	()V
    //   644: aload 13
    //   646: invokevirtual 433	android/media/AudioRecord:release	()V
    //   649: invokestatic 398	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Native:jniClose	()V
    //   652: aload_0
    //   653: iconst_0
    //   654: putfield 94	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:isRecording	Z
    //   657: aload_0
    //   658: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   661: ifnull -645 -> 16
    //   664: aload_0
    //   665: getfield 104	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mp3Player	Lcom/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder;
    //   668: invokevirtual 436	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder:getRecordDuration	()J
    //   671: lconst_1
    //   672: lcmp
    //   673: ifle +453 -> 1126
    //   676: aload_0
    //   677: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   680: iconst_5
    //   681: invokevirtual 392	android/os/Handler:sendEmptyMessage	(I)Z
    //   684: pop
    //   685: return
    //   686: iload_3
    //   687: ifne +6 -> 693
    //   690: goto -285 -> 405
    //   693: aload 14
    //   695: aload 14
    //   697: iload_3
    //   698: aload 12
    //   700: invokestatic 440	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Native:jniEncode	([S[SI[B)I
    //   703: istore 5
    //   705: iload 5
    //   707: ifge +39 -> 746
    //   710: aload_0
    //   711: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   714: ifnull +459 -> 1173
    //   717: aload_0
    //   718: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   721: invokestatic 50	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   724: invokevirtual 54	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getContext	()Landroid/content/Context;
    //   727: invokevirtual 60	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   730: getstatic 420	com/tencent/qqmini/miniapp/R$string:mini_sdk_record_encode_error	I
    //   733: invokevirtual 71	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   736: invokestatic 339	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   739: invokevirtual 223	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   742: pop
    //   743: goto +459 -> 1202
    //   746: iload_1
    //   747: istore 4
    //   749: aload 8
    //   751: astore 9
    //   753: iload 5
    //   755: ifeq +205 -> 960
    //   758: aload 11
    //   760: aload 12
    //   762: iconst_0
    //   763: iload 5
    //   765: invokevirtual 424	java/io/FileOutputStream:write	([BII)V
    //   768: iload_1
    //   769: istore 4
    //   771: aload 8
    //   773: astore 9
    //   775: aload_0
    //   776: getfield 359	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   779: ifle +181 -> 960
    //   782: aload 8
    //   784: astore 9
    //   786: aload 8
    //   788: ifnull +13 -> 801
    //   791: aload_0
    //   792: aload 8
    //   794: iconst_0
    //   795: invokespecial 409	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:onFrameRecord	([BZ)V
    //   798: aconst_null
    //   799: astore 9
    //   801: iconst_0
    //   802: istore_3
    //   803: iload_1
    //   804: istore 4
    //   806: iload_1
    //   807: iload 5
    //   809: iadd
    //   810: istore 5
    //   812: iload 4
    //   814: istore_1
    //   815: aload 9
    //   817: astore 8
    //   819: iload 5
    //   821: istore 4
    //   823: iload 4
    //   825: aload_0
    //   826: getfield 359	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   829: if_icmplt +109 -> 938
    //   832: aload_0
    //   833: getfield 359	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   836: newarray byte
    //   838: astore 9
    //   840: iload_1
    //   841: ifle +70 -> 911
    //   844: aload 10
    //   846: iconst_0
    //   847: aload 9
    //   849: iconst_0
    //   850: iload_1
    //   851: invokestatic 413	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   854: aload_0
    //   855: getfield 359	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   858: iload_1
    //   859: isub
    //   860: istore 5
    //   862: aload 12
    //   864: iconst_0
    //   865: aload 9
    //   867: iload_1
    //   868: iload 5
    //   870: invokestatic 413	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   873: iconst_0
    //   874: istore_1
    //   875: iload_3
    //   876: iload 5
    //   878: iadd
    //   879: istore_3
    //   880: iload 4
    //   882: aload_0
    //   883: getfield 359	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   886: isub
    //   887: istore 4
    //   889: iload 4
    //   891: aload_0
    //   892: getfield 359	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   895: if_icmplt +284 -> 1179
    //   898: aload_0
    //   899: aload 9
    //   901: iconst_0
    //   902: invokespecial 409	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:onFrameRecord	([BZ)V
    //   905: aconst_null
    //   906: astore 8
    //   908: goto -85 -> 823
    //   911: aload 12
    //   913: iload_3
    //   914: aload 9
    //   916: iconst_0
    //   917: aload_0
    //   918: getfield 359	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   921: invokestatic 413	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   924: aload_0
    //   925: getfield 359	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   928: istore 5
    //   930: iload 5
    //   932: iload_3
    //   933: iadd
    //   934: istore_3
    //   935: goto -55 -> 880
    //   938: iload 4
    //   940: ifle +30 -> 970
    //   943: aload 12
    //   945: iload_3
    //   946: aload 10
    //   948: iload_1
    //   949: iload 4
    //   951: iload_1
    //   952: isub
    //   953: invokestatic 413	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   956: aload 8
    //   958: astore 9
    //   960: iload 4
    //   962: istore_1
    //   963: aload 9
    //   965: astore 8
    //   967: goto -562 -> 405
    //   970: iconst_0
    //   971: istore 4
    //   973: aload 8
    //   975: astore 9
    //   977: goto -17 -> 960
    //   980: astore 8
    //   982: aload 9
    //   984: astore 8
    //   986: aload_0
    //   987: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   990: ifnull +227 -> 1217
    //   993: aload_0
    //   994: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   997: invokestatic 50	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   1000: invokevirtual 54	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getContext	()Landroid/content/Context;
    //   1003: invokevirtual 60	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1006: getstatic 443	com/tencent/qqmini/miniapp/R$string:mini_sdk_record_write_file_error	I
    //   1009: invokevirtual 71	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   1012: invokestatic 339	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   1015: invokevirtual 223	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   1018: pop
    //   1019: goto +198 -> 1217
    //   1022: astore 8
    //   1024: aload_0
    //   1025: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   1028: ifnull -394 -> 634
    //   1031: aload_0
    //   1032: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   1035: invokestatic 50	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   1038: invokevirtual 54	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getContext	()Landroid/content/Context;
    //   1041: invokevirtual 60	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1044: getstatic 443	com/tencent/qqmini/miniapp/R$string:mini_sdk_record_write_file_error	I
    //   1047: invokevirtual 71	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   1050: invokestatic 339	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   1053: invokevirtual 223	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   1056: pop
    //   1057: goto -423 -> 634
    //   1060: astore 8
    //   1062: aload 13
    //   1064: invokevirtual 430	android/media/AudioRecord:stop	()V
    //   1067: aload 13
    //   1069: invokevirtual 433	android/media/AudioRecord:release	()V
    //   1072: aload 8
    //   1074: athrow
    //   1075: astore 8
    //   1077: invokestatic 398	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Native:jniClose	()V
    //   1080: aload_0
    //   1081: iconst_0
    //   1082: putfield 94	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:isRecording	Z
    //   1085: aload 8
    //   1087: athrow
    //   1088: astore 8
    //   1090: aload_0
    //   1091: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   1094: ifnull -455 -> 639
    //   1097: aload_0
    //   1098: getfield 106	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   1101: invokestatic 50	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   1104: invokevirtual 54	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getContext	()Landroid/content/Context;
    //   1107: invokevirtual 60	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1110: getstatic 446	com/tencent/qqmini/miniapp/R$string:mini_sdk_record_close_error	I
    //   1113: invokevirtual 71	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   1116: invokestatic 339	com/tencent/qqmini/miniapp/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   1119: invokevirtual 223	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   1122: pop
    //   1123: goto -484 -> 639
    //   1126: new 128	java/io/File
    //   1129: dup
    //   1130: aload_0
    //   1131: getfield 240	com/tencent/qqmini/miniapp/audiorecorder/LameMp3EncodeThread:mRecordFilPath	Ljava/lang/String;
    //   1134: invokespecial 129	java/io/File:<init>	(Ljava/lang/String;)V
    //   1137: astore 8
    //   1139: aload 8
    //   1141: invokevirtual 133	java/io/File:exists	()Z
    //   1144: ifeq -1128 -> 16
    //   1147: aload 8
    //   1149: invokevirtual 449	java/io/File:delete	()Z
    //   1152: pop
    //   1153: return
    //   1154: astore 8
    //   1156: aload 9
    //   1158: astore 8
    //   1160: goto -174 -> 986
    //   1163: astore 9
    //   1165: goto -179 -> 986
    //   1168: astore 9
    //   1170: goto -184 -> 986
    //   1173: goto +29 -> 1202
    //   1176: goto -694 -> 482
    //   1179: aload 9
    //   1181: astore 8
    //   1183: goto -360 -> 823
    //   1186: aconst_null
    //   1187: astore 10
    //   1189: goto -1009 -> 180
    //   1192: iconst_0
    //   1193: istore_2
    //   1194: iconst_0
    //   1195: istore_1
    //   1196: aconst_null
    //   1197: astore 8
    //   1199: goto -794 -> 405
    //   1202: aload 8
    //   1204: ifnull -652 -> 552
    //   1207: iload_1
    //   1208: ifne +12 -> 1220
    //   1211: iconst_1
    //   1212: istore 7
    //   1214: goto -670 -> 544
    //   1217: goto -15 -> 1202
    //   1220: iconst_0
    //   1221: istore 7
    //   1223: goto -679 -> 544
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1226	0	this	LameMp3EncodeThread
    //   552	656	1	i	int
    //   423	771	2	j	int
    //   492	454	3	k	int
    //   747	225	4	m	int
    //   703	231	5	n	int
    //   93	395	6	i1	int
    //   416	806	7	bool	boolean
    //   244	1	8	localFileNotFoundException	java.io.FileNotFoundException
    //   280	1	8	localIOException	java.io.IOException
    //   432	114	8	localIllegalStateException	java.lang.IllegalStateException
    //   559	415	8	localObject1	java.lang.Object
    //   980	1	8	localThrowable1	Throwable
    //   984	1	8	localObject2	java.lang.Object
    //   1022	1	8	localThrowable2	Throwable
    //   1060	13	8	localObject3	java.lang.Object
    //   1075	11	8	localObject4	java.lang.Object
    //   1088	1	8	localThrowable3	Throwable
    //   1137	11	8	localFile	File
    //   1154	1	8	localThrowable4	Throwable
    //   1158	45	8	localObject5	java.lang.Object
    //   751	406	9	localObject6	java.lang.Object
    //   1163	1	9	localThrowable5	Throwable
    //   1168	12	9	localThrowable6	Throwable
    //   178	1010	10	arrayOfByte1	byte[]
    //   194	565	11	localFileOutputStream	java.io.FileOutputStream
    //   163	781	12	arrayOfByte2	byte[]
    //   379	689	13	localAudioRecord	android.media.AudioRecord
    //   146	550	14	arrayOfShort	short[]
    // Exception table:
    //   from	to	target	type
    //   180	196	244	java/io/FileNotFoundException
    //   180	196	280	java/io/IOException
    //   381	386	432	java/lang/IllegalStateException
    //   844	873	980	java/lang/Throwable
    //   911	930	980	java/lang/Throwable
    //   625	634	1022	java/lang/Throwable
    //   386	402	1060	finally
    //   405	418	1060	finally
    //   482	504	1060	finally
    //   508	541	1060	finally
    //   544	552	1060	finally
    //   556	578	1060	finally
    //   578	584	1060	finally
    //   588	621	1060	finally
    //   625	634	1060	finally
    //   634	639	1060	finally
    //   693	705	1060	finally
    //   710	743	1060	finally
    //   758	768	1060	finally
    //   775	782	1060	finally
    //   791	798	1060	finally
    //   823	840	1060	finally
    //   844	873	1060	finally
    //   880	905	1060	finally
    //   911	930	1060	finally
    //   943	956	1060	finally
    //   986	1019	1060	finally
    //   1024	1057	1060	finally
    //   1090	1123	1060	finally
    //   381	386	1075	finally
    //   434	467	1075	finally
    //   639	649	1075	finally
    //   1062	1075	1075	finally
    //   634	639	1088	java/lang/Throwable
    //   880	905	1154	java/lang/Throwable
    //   823	840	1163	java/lang/Throwable
    //   943	956	1163	java/lang/Throwable
    //   758	768	1168	java/lang/Throwable
    //   775	782	1168	java/lang/Throwable
    //   791	798	1168	java/lang/Throwable
  }
  
  public void setAudioSource(int paramInt)
  {
    this.mAudioSource = paramInt;
  }
  
  public void setAudioSource(String paramString)
  {
    int j = 1;
    int i;
    if (TextUtils.isEmpty(paramString)) {
      i = j;
    }
    for (;;)
    {
      setAudioSource(i);
      return;
      paramString = paramString.toLowerCase();
      if ("auto".equals(paramString))
      {
        i = 0;
      }
      else
      {
        i = j;
        if (!"mic".equals(paramString)) {
          if ("camcorder".equals(paramString))
          {
            i = 5;
          }
          else if ("voice_communication".equals(paramString))
          {
            i = 7;
          }
          else
          {
            i = j;
            if ("voice_recognition".equals(paramString)) {
              i = 6;
            }
          }
        }
      }
    }
  }
  
  public void setCallbackFrameSize(int paramInt)
  {
    this.mCallbackFrameSize = paramInt;
  }
  
  public void setEncodingPcmFormat(int paramInt)
  {
    this.mEncodingPcmFormat = paramInt;
  }
  
  public void setFilePath(String paramString)
  {
    this.mRecordFilPath = paramString;
  }
  
  public void setFilePlayPath(String paramString)
  {
    this.mPlayFilePath = paramString;
  }
  
  public void setInSampleRate(int paramInt)
  {
    this.mInSampleRate = paramInt;
  }
  
  public void setOutBitRate(int paramInt)
  {
    this.mOutBitRate = paramInt;
  }
  
  public void setOutChannel(int paramInt)
  {
    this.mOutChannel = paramInt;
  }
  
  public void setOutSampleRate(int paramInt)
  {
    this.mOutSampleRate = paramInt;
  }
  
  public void setPause(boolean paramBoolean)
  {
    this.isPause = paramBoolean;
  }
  
  public void setQuality(int paramInt)
  {
    this.mQuality = paramInt;
  }
  
  public void setRecordFilPath(String paramString)
  {
    this.mRecordFilPath = paramString;
  }
  
  public void setRecordFileFormat(String paramString)
  {
    this.mAudioFileFormat = paramString;
  }
  
  public void setRecordTime(long paramLong)
  {
    this.mRecordTime = paramLong;
  }
  
  public void startRecord()
  {
    ThreadManager.getSubThreadHandler().post(this);
  }
  
  public boolean stopPlay()
  {
    if (this.mMediaPlayer != null)
    {
      this.mMediaPlayer.stop();
      this.mMediaPlayer.release();
      this.mMediaPlayer = null;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.audiorecorder.LameMp3EncodeThread
 * JD-Core Version:    0.7.0.1
 */