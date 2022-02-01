package com.tencent.mobileqq.mini.audiorecorder;

import amtj;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import avsb;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class LameMp3EncodeThread
  extends Thread
{
  public static final String TAG = LameMp3EncodeThread.class.getName();
  private boolean isPause;
  private boolean isRecording;
  private String mAudioFileFormat = "mp3";
  private int mAudioSource = 1;
  private int mCallbackFrameSize;
  private int mEncodingPcmFormat = 2;
  private int mInSampleRate = 8000;
  private Handler mMainHandler;
  private MediaPlayer mMediaPlayer;
  private boolean mNativeLoaded;
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
    super(amtj.a(2131705118));
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
    this.mNativeLoaded = avsb.a().c();
    QLog.e("[miniapp]-LameMp3Native", 1, "mNativeLoaded : " + this.mNativeLoaded);
    if (!this.mNativeLoaded) {}
    try
    {
      this.mNativeLoaded = avsb.a().b();
      if (this.mNativeLoaded) {}
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          System.loadLibrary("native_lame_mp3");
          this.mNativeLoaded = true;
          QLog.e("[miniapp]-LameMp3Native", 1, "load so exception, load local libnative_lame_mp3.so success!");
          return;
        }
        catch (Throwable localThrowable2)
        {
          this.mNativeLoaded = false;
          QLog.e("[miniapp]-LameMp3Native", 1, "load so exception, fail to load local libnative_lame_mp3.so:" + this.mNativeLoaded, localThrowable2);
        }
        localThrowable1 = localThrowable1;
        QLog.e("[miniapp]-LameMp3Native", 1, "load so exception, fail to load network libnative_lame_mp3.so:" + this.mNativeLoaded, localThrowable1);
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
      QLog.e(TAG, 1, "请先关闭录音");
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
      this.mMainHandler.sendMessage(LameMp3Recorder.generatePlayErrMsg(amtj.a(2131705115)));
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
    //   1: getfield 223	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:isRecording	Z
    //   4: ifeq +14 -> 18
    //   7: getstatic 41	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:TAG	Ljava/lang/String;
    //   10: iconst_1
    //   11: ldc_w 302
    //   14: invokestatic 305	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: return
    //   18: aload_0
    //   19: getfield 212	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mRecordFilPath	Ljava/lang/String;
    //   22: invokestatic 100	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   25: ifeq +14 -> 39
    //   28: getstatic 41	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:TAG	Ljava/lang/String;
    //   31: iconst_1
    //   32: ldc_w 307
    //   35: invokestatic 152	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: return
    //   39: aload_0
    //   40: getfield 128	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mNativeLoaded	Z
    //   43: ifne +28 -> 71
    //   46: aload_0
    //   47: getfield 80	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   50: ifnull -33 -> 17
    //   53: aload_0
    //   54: getfield 80	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   57: ldc_w 308
    //   60: invokestatic 51	amtj:a	(I)Ljava/lang/String;
    //   63: invokestatic 311	com/tencent/mobileqq/mini/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   66: invokevirtual 195	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   69: pop
    //   70: return
    //   71: bipush 237
    //   73: invokestatic 316	android/os/Process:setThreadPriority	(I)V
    //   76: aload_0
    //   77: getfield 64	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mInSampleRate	I
    //   80: bipush 16
    //   82: iconst_2
    //   83: invokestatic 322	android/media/AudioRecord:getMinBufferSize	(III)I
    //   86: istore 6
    //   88: iload 6
    //   90: ifge +28 -> 118
    //   93: aload_0
    //   94: getfield 80	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   97: ifnull -80 -> 17
    //   100: aload_0
    //   101: getfield 80	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   104: ldc_w 323
    //   107: invokestatic 51	amtj:a	(I)Ljava/lang/String;
    //   110: invokestatic 311	com/tencent/mobileqq/mini/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   113: invokevirtual 195	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   116: pop
    //   117: return
    //   118: aload_0
    //   119: getfield 64	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mInSampleRate	I
    //   122: iconst_2
    //   123: imul
    //   124: iconst_1
    //   125: imul
    //   126: iconst_5
    //   127: imul
    //   128: newarray short
    //   130: astore 14
    //   132: ldc2_w 324
    //   135: aload 14
    //   137: arraylength
    //   138: i2d
    //   139: ldc2_w 326
    //   142: dmul
    //   143: dadd
    //   144: d2i
    //   145: newarray byte
    //   147: astore 12
    //   149: aload_0
    //   150: getfield 329	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   153: ifle +928 -> 1081
    //   156: aload_0
    //   157: getfield 329	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   160: newarray byte
    //   162: astore 10
    //   164: new 331	java/io/FileOutputStream
    //   167: dup
    //   168: aload_0
    //   169: getfield 212	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mRecordFilPath	Ljava/lang/String;
    //   172: invokestatic 333	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:createSDFile	(Ljava/lang/String;)Ljava/io/File;
    //   175: invokespecial 336	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   178: astore 11
    //   180: aload 11
    //   182: ifnonnull +97 -> 279
    //   185: getstatic 41	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:TAG	Ljava/lang/String;
    //   188: iconst_1
    //   189: ldc_w 338
    //   192: invokestatic 152	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   195: aload_0
    //   196: getfield 80	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   199: ifnull -182 -> 17
    //   202: aload_0
    //   203: getfield 80	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   206: ldc_w 339
    //   209: invokestatic 51	amtj:a	(I)Ljava/lang/String;
    //   212: invokestatic 311	com/tencent/mobileqq/mini/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   215: invokevirtual 195	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   218: pop
    //   219: return
    //   220: astore 8
    //   222: aload_0
    //   223: getfield 80	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   226: ifnull -209 -> 17
    //   229: aload_0
    //   230: getfield 80	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   233: ldc_w 340
    //   236: invokestatic 51	amtj:a	(I)Ljava/lang/String;
    //   239: invokestatic 311	com/tencent/mobileqq/mini/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   242: invokevirtual 195	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   245: pop
    //   246: return
    //   247: astore 8
    //   249: aload_0
    //   250: getfield 80	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   253: ifnull +20 -> 273
    //   256: aload_0
    //   257: getfield 80	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   260: ldc_w 341
    //   263: invokestatic 51	amtj:a	(I)Ljava/lang/String;
    //   266: invokestatic 311	com/tencent/mobileqq/mini/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   269: invokevirtual 195	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   272: pop
    //   273: aconst_null
    //   274: astore 11
    //   276: goto -96 -> 180
    //   279: aload_0
    //   280: getfield 64	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mInSampleRate	I
    //   283: aload_0
    //   284: getfield 68	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mOutChannel	I
    //   287: aload_0
    //   288: getfield 64	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mInSampleRate	I
    //   291: aload_0
    //   292: getfield 70	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mOutBitRate	I
    //   295: aload_0
    //   296: getfield 72	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mQuality	I
    //   299: invokestatic 347	com/tencent/mobileqq/mini/audiorecorder/LameMp3Native:jniInit	(IIIII)V
    //   302: aload_0
    //   303: iconst_1
    //   304: putfield 223	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:isRecording	Z
    //   307: aload_0
    //   308: iconst_0
    //   309: putfield 236	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:isPause	Z
    //   312: new 318	android/media/AudioRecord
    //   315: dup
    //   316: aload_0
    //   317: getfield 56	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mAudioSource	I
    //   320: aload_0
    //   321: getfield 64	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mInSampleRate	I
    //   324: bipush 16
    //   326: aload_0
    //   327: getfield 58	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mEncodingPcmFormat	I
    //   330: iload 6
    //   332: iconst_2
    //   333: imul
    //   334: invokespecial 349	android/media/AudioRecord:<init>	(IIIII)V
    //   337: astore 13
    //   339: aload 13
    //   341: invokevirtual 352	android/media/AudioRecord:startRecording	()V
    //   344: aload_0
    //   345: getfield 80	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   348: ifnull +739 -> 1087
    //   351: aload_0
    //   352: getfield 80	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   355: iconst_1
    //   356: invokevirtual 356	android/os/Handler:sendEmptyMessage	(I)Z
    //   359: pop
    //   360: goto +727 -> 1087
    //   363: aload_0
    //   364: getfield 223	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:isRecording	Z
    //   367: ifeq +701 -> 1068
    //   370: aload_0
    //   371: getfield 236	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:isPause	Z
    //   374: istore 7
    //   376: iload 7
    //   378: ifeq +47 -> 425
    //   381: iload_2
    //   382: ifne -19 -> 363
    //   385: iconst_1
    //   386: istore_2
    //   387: goto -24 -> 363
    //   390: astore 8
    //   392: aload_0
    //   393: getfield 80	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   396: ifnull +20 -> 416
    //   399: aload_0
    //   400: getfield 80	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   403: ldc_w 357
    //   406: invokestatic 51	amtj:a	(I)Ljava/lang/String;
    //   409: invokestatic 311	com/tencent/mobileqq/mini/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   412: invokevirtual 195	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   415: pop
    //   416: invokestatic 360	com/tencent/mobileqq/mini/audiorecorder/LameMp3Native:jniClose	()V
    //   419: aload_0
    //   420: iconst_0
    //   421: putfield 223	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:isRecording	Z
    //   424: return
    //   425: iload_2
    //   426: ifeq +645 -> 1071
    //   429: iconst_0
    //   430: istore_2
    //   431: aload 13
    //   433: aload 14
    //   435: iconst_0
    //   436: iload 6
    //   438: invokevirtual 364	android/media/AudioRecord:read	([SII)I
    //   441: istore_3
    //   442: aload_0
    //   443: aload_0
    //   444: iload_3
    //   445: aload 14
    //   447: invokevirtual 366	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:getVoiceSize	(I[S)I
    //   450: putfield 217	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mVoiceLevel	I
    //   453: iload_3
    //   454: ifge +163 -> 617
    //   457: aload_0
    //   458: getfield 80	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   461: ifnull +607 -> 1068
    //   464: aload_0
    //   465: getfield 80	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   468: ldc_w 367
    //   471: invokestatic 51	amtj:a	(I)Ljava/lang/String;
    //   474: invokestatic 311	com/tencent/mobileqq/mini/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   477: invokevirtual 195	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   480: pop
    //   481: goto +616 -> 1097
    //   484: aload_0
    //   485: aload 8
    //   487: iload 7
    //   489: invokespecial 369	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:onFrameRecord	([BZ)V
    //   492: iload_1
    //   493: ifle +25 -> 518
    //   496: iload_1
    //   497: newarray byte
    //   499: astore 8
    //   501: aload 10
    //   503: iconst_0
    //   504: aload 8
    //   506: iconst_0
    //   507: iload_1
    //   508: invokestatic 373	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   511: aload_0
    //   512: aload 8
    //   514: iconst_1
    //   515: invokespecial 369	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:onFrameRecord	([BZ)V
    //   518: aload 12
    //   520: invokestatic 377	com/tencent/mobileqq/mini/audiorecorder/LameMp3Native:jniFlush	([B)I
    //   523: istore_1
    //   524: iload_1
    //   525: ifge +27 -> 552
    //   528: aload_0
    //   529: getfield 80	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   532: ifnull +20 -> 552
    //   535: aload_0
    //   536: getfield 80	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   539: ldc_w 378
    //   542: invokestatic 51	amtj:a	(I)Ljava/lang/String;
    //   545: invokestatic 311	com/tencent/mobileqq/mini/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   548: invokevirtual 195	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   551: pop
    //   552: iload_1
    //   553: ifeq +12 -> 565
    //   556: aload 11
    //   558: aload 12
    //   560: iconst_0
    //   561: iload_1
    //   562: invokevirtual 382	java/io/FileOutputStream:write	([BII)V
    //   565: aload 11
    //   567: invokevirtual 385	java/io/FileOutputStream:close	()V
    //   570: aload 13
    //   572: invokevirtual 388	android/media/AudioRecord:stop	()V
    //   575: aload 13
    //   577: invokevirtual 391	android/media/AudioRecord:release	()V
    //   580: invokestatic 360	com/tencent/mobileqq/mini/audiorecorder/LameMp3Native:jniClose	()V
    //   583: aload_0
    //   584: iconst_0
    //   585: putfield 223	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:isRecording	Z
    //   588: aload_0
    //   589: getfield 80	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   592: ifnull -575 -> 17
    //   595: aload_0
    //   596: getfield 78	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mp3Player	Lcom/tencent/mobileqq/mini/audiorecorder/LameMp3Recorder;
    //   599: invokevirtual 394	com/tencent/mobileqq/mini/audiorecorder/LameMp3Recorder:getRecordDuration	()J
    //   602: lconst_1
    //   603: lcmp
    //   604: ifle +417 -> 1021
    //   607: aload_0
    //   608: getfield 80	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   611: iconst_5
    //   612: invokevirtual 356	android/os/Handler:sendEmptyMessage	(I)Z
    //   615: pop
    //   616: return
    //   617: iload_3
    //   618: ifne +6 -> 624
    //   621: goto -258 -> 363
    //   624: aload 14
    //   626: aload 14
    //   628: iload_3
    //   629: aload 12
    //   631: invokestatic 398	com/tencent/mobileqq/mini/audiorecorder/LameMp3Native:jniEncode	([S[SI[B)I
    //   634: istore 5
    //   636: iload 5
    //   638: ifge +30 -> 668
    //   641: aload_0
    //   642: getfield 80	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   645: ifnull +423 -> 1068
    //   648: aload_0
    //   649: getfield 80	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   652: ldc_w 399
    //   655: invokestatic 51	amtj:a	(I)Ljava/lang/String;
    //   658: invokestatic 311	com/tencent/mobileqq/mini/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   661: invokevirtual 195	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   664: pop
    //   665: goto +432 -> 1097
    //   668: iload_1
    //   669: istore 4
    //   671: aload 8
    //   673: astore 9
    //   675: iload 5
    //   677: ifeq +205 -> 882
    //   680: aload 11
    //   682: aload 12
    //   684: iconst_0
    //   685: iload 5
    //   687: invokevirtual 382	java/io/FileOutputStream:write	([BII)V
    //   690: iload_1
    //   691: istore 4
    //   693: aload 8
    //   695: astore 9
    //   697: aload_0
    //   698: getfield 329	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   701: ifle +181 -> 882
    //   704: aload 8
    //   706: astore 9
    //   708: aload 8
    //   710: ifnull +13 -> 723
    //   713: aload_0
    //   714: aload 8
    //   716: iconst_0
    //   717: invokespecial 369	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:onFrameRecord	([BZ)V
    //   720: aconst_null
    //   721: astore 9
    //   723: iconst_0
    //   724: istore_3
    //   725: iload_1
    //   726: istore 4
    //   728: iload_1
    //   729: iload 5
    //   731: iadd
    //   732: istore 5
    //   734: iload 4
    //   736: istore_1
    //   737: aload 9
    //   739: astore 8
    //   741: iload 5
    //   743: istore 4
    //   745: iload 4
    //   747: aload_0
    //   748: getfield 329	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   751: if_icmplt +109 -> 860
    //   754: aload_0
    //   755: getfield 329	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   758: newarray byte
    //   760: astore 9
    //   762: iload_1
    //   763: ifle +70 -> 833
    //   766: aload 10
    //   768: iconst_0
    //   769: aload 9
    //   771: iconst_0
    //   772: iload_1
    //   773: invokestatic 373	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   776: aload_0
    //   777: getfield 329	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   780: iload_1
    //   781: isub
    //   782: istore 5
    //   784: aload 12
    //   786: iconst_0
    //   787: aload 9
    //   789: iload_1
    //   790: iload 5
    //   792: invokestatic 373	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   795: iconst_0
    //   796: istore_1
    //   797: iload_3
    //   798: iload 5
    //   800: iadd
    //   801: istore_3
    //   802: iload 4
    //   804: aload_0
    //   805: getfield 329	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   808: isub
    //   809: istore 4
    //   811: iload 4
    //   813: aload_0
    //   814: getfield 329	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   817: if_icmplt +257 -> 1074
    //   820: aload_0
    //   821: aload 9
    //   823: iconst_0
    //   824: invokespecial 369	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:onFrameRecord	([BZ)V
    //   827: aconst_null
    //   828: astore 8
    //   830: goto -85 -> 745
    //   833: aload 12
    //   835: iload_3
    //   836: aload 9
    //   838: iconst_0
    //   839: aload_0
    //   840: getfield 329	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   843: invokestatic 373	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   846: aload_0
    //   847: getfield 329	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   850: istore 5
    //   852: iload 5
    //   854: iload_3
    //   855: iadd
    //   856: istore_3
    //   857: goto -55 -> 802
    //   860: iload 4
    //   862: ifle +30 -> 892
    //   865: aload 12
    //   867: iload_3
    //   868: aload 10
    //   870: iload_1
    //   871: iload 4
    //   873: iload_1
    //   874: isub
    //   875: invokestatic 373	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   878: aload 8
    //   880: astore 9
    //   882: iload 4
    //   884: istore_1
    //   885: aload 9
    //   887: astore 8
    //   889: goto -526 -> 363
    //   892: iconst_0
    //   893: istore 4
    //   895: aload 8
    //   897: astore 9
    //   899: goto -17 -> 882
    //   902: astore 8
    //   904: aload 9
    //   906: astore 8
    //   908: aload_0
    //   909: getfield 80	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   912: ifnull +200 -> 1112
    //   915: aload_0
    //   916: getfield 80	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   919: ldc_w 400
    //   922: invokestatic 51	amtj:a	(I)Ljava/lang/String;
    //   925: invokestatic 311	com/tencent/mobileqq/mini/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   928: invokevirtual 195	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   931: pop
    //   932: goto +180 -> 1112
    //   935: astore 8
    //   937: aload_0
    //   938: getfield 80	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   941: ifnull -376 -> 565
    //   944: aload_0
    //   945: getfield 80	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   948: ldc_w 401
    //   951: invokestatic 51	amtj:a	(I)Ljava/lang/String;
    //   954: invokestatic 311	com/tencent/mobileqq/mini/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   957: invokevirtual 195	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   960: pop
    //   961: goto -396 -> 565
    //   964: astore 8
    //   966: aload 13
    //   968: invokevirtual 388	android/media/AudioRecord:stop	()V
    //   971: aload 13
    //   973: invokevirtual 391	android/media/AudioRecord:release	()V
    //   976: aload 8
    //   978: athrow
    //   979: astore 8
    //   981: invokestatic 360	com/tencent/mobileqq/mini/audiorecorder/LameMp3Native:jniClose	()V
    //   984: aload_0
    //   985: iconst_0
    //   986: putfield 223	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:isRecording	Z
    //   989: aload 8
    //   991: athrow
    //   992: astore 8
    //   994: aload_0
    //   995: getfield 80	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   998: ifnull -428 -> 570
    //   1001: aload_0
    //   1002: getfield 80	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   1005: ldc_w 402
    //   1008: invokestatic 51	amtj:a	(I)Ljava/lang/String;
    //   1011: invokestatic 311	com/tencent/mobileqq/mini/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   1014: invokevirtual 195	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   1017: pop
    //   1018: goto -448 -> 570
    //   1021: new 102	java/io/File
    //   1024: dup
    //   1025: aload_0
    //   1026: getfield 212	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mRecordFilPath	Ljava/lang/String;
    //   1029: invokespecial 103	java/io/File:<init>	(Ljava/lang/String;)V
    //   1032: astore 8
    //   1034: aload 8
    //   1036: invokevirtual 107	java/io/File:exists	()Z
    //   1039: ifeq -1022 -> 17
    //   1042: aload 8
    //   1044: invokevirtual 405	java/io/File:delete	()Z
    //   1047: pop
    //   1048: return
    //   1049: astore 8
    //   1051: aload 9
    //   1053: astore 8
    //   1055: goto -147 -> 908
    //   1058: astore 9
    //   1060: goto -152 -> 908
    //   1063: astore 9
    //   1065: goto -157 -> 908
    //   1068: goto +29 -> 1097
    //   1071: goto -640 -> 431
    //   1074: aload 9
    //   1076: astore 8
    //   1078: goto -333 -> 745
    //   1081: aconst_null
    //   1082: astore 10
    //   1084: goto -920 -> 164
    //   1087: iconst_0
    //   1088: istore_2
    //   1089: iconst_0
    //   1090: istore_1
    //   1091: aconst_null
    //   1092: astore 8
    //   1094: goto -731 -> 363
    //   1097: aload 8
    //   1099: ifnull -607 -> 492
    //   1102: iload_1
    //   1103: ifne +12 -> 1115
    //   1106: iconst_1
    //   1107: istore 7
    //   1109: goto -625 -> 484
    //   1112: goto -15 -> 1097
    //   1115: iconst_0
    //   1116: istore 7
    //   1118: goto -634 -> 484
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1121	0	this	LameMp3EncodeThread
    //   492	611	1	i	int
    //   381	708	2	j	int
    //   441	427	3	k	int
    //   669	225	4	m	int
    //   634	222	5	n	int
    //   86	351	6	i1	int
    //   374	743	7	bool	boolean
    //   220	1	8	localFileNotFoundException	java.io.FileNotFoundException
    //   247	1	8	localIOException	java.io.IOException
    //   390	96	8	localIllegalStateException	java.lang.IllegalStateException
    //   499	397	8	localObject1	java.lang.Object
    //   902	1	8	localThrowable1	Throwable
    //   906	1	8	localObject2	java.lang.Object
    //   935	1	8	localThrowable2	Throwable
    //   964	13	8	localObject3	java.lang.Object
    //   979	11	8	localObject4	java.lang.Object
    //   992	1	8	localThrowable3	Throwable
    //   1032	11	8	localFile	File
    //   1049	1	8	localThrowable4	Throwable
    //   1053	45	8	localObject5	java.lang.Object
    //   673	379	9	localObject6	java.lang.Object
    //   1058	1	9	localThrowable5	Throwable
    //   1063	12	9	localThrowable6	Throwable
    //   162	921	10	arrayOfByte1	byte[]
    //   178	503	11	localFileOutputStream	java.io.FileOutputStream
    //   147	719	12	arrayOfByte2	byte[]
    //   337	635	13	localAudioRecord	android.media.AudioRecord
    //   130	497	14	arrayOfShort	short[]
    // Exception table:
    //   from	to	target	type
    //   164	180	220	java/io/FileNotFoundException
    //   164	180	247	java/io/IOException
    //   339	344	390	java/lang/IllegalStateException
    //   766	795	902	java/lang/Throwable
    //   833	852	902	java/lang/Throwable
    //   556	565	935	java/lang/Throwable
    //   344	360	964	finally
    //   363	376	964	finally
    //   431	453	964	finally
    //   457	481	964	finally
    //   484	492	964	finally
    //   496	518	964	finally
    //   518	524	964	finally
    //   528	552	964	finally
    //   556	565	964	finally
    //   565	570	964	finally
    //   624	636	964	finally
    //   641	665	964	finally
    //   680	690	964	finally
    //   697	704	964	finally
    //   713	720	964	finally
    //   745	762	964	finally
    //   766	795	964	finally
    //   802	827	964	finally
    //   833	852	964	finally
    //   865	878	964	finally
    //   908	932	964	finally
    //   937	961	964	finally
    //   994	1018	964	finally
    //   339	344	979	finally
    //   392	416	979	finally
    //   570	580	979	finally
    //   966	979	979	finally
    //   565	570	992	java/lang/Throwable
    //   802	827	1049	java/lang/Throwable
    //   745	762	1058	java/lang/Throwable
    //   865	878	1058	java/lang/Throwable
    //   680	690	1063	java/lang/Throwable
    //   697	704	1063	java/lang/Throwable
    //   713	720	1063	java/lang/Throwable
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
    ThreadManagerV2.executeOnSubThread(this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.audiorecorder.LameMp3EncodeThread
 * JD-Core Version:    0.7.0.1
 */