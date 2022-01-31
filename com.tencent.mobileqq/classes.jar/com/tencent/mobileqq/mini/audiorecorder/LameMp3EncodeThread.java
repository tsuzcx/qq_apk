package com.tencent.mobileqq.mini.audiorecorder;

import alud;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
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
    super(alud.a(2131706370));
    this.mp3Player = paramLameMp3Recorder;
    this.mMainHandler = paramHandler;
    start();
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
      this.mMainHandler.sendMessage(LameMp3Recorder.generatePlayErrMsg(alud.a(2131706367)));
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
    //   1: getfield 165	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:isRecording	Z
    //   4: ifeq +13 -> 17
    //   7: getstatic 40	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:TAG	Ljava/lang/String;
    //   10: iconst_1
    //   11: ldc 252
    //   13: invokestatic 255	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: return
    //   17: aload_0
    //   18: getfield 154	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mRecordFilPath	Ljava/lang/String;
    //   21: invokestatic 96	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   24: ifeq +14 -> 38
    //   27: getstatic 40	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:TAG	Ljava/lang/String;
    //   30: iconst_1
    //   31: ldc_w 257
    //   34: invokestatic 199	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: return
    //   38: getstatic 262	com/tencent/mobileqq/mini/audiorecorder/LameMp3Native:mNativeLoaded	Z
    //   41: ifne +28 -> 69
    //   44: aload_0
    //   45: getfield 79	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   48: ifnull -32 -> 16
    //   51: aload_0
    //   52: getfield 79	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   55: ldc_w 263
    //   58: invokestatic 50	alud:a	(I)Ljava/lang/String;
    //   61: invokestatic 266	com/tencent/mobileqq/mini/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   64: invokevirtual 136	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   67: pop
    //   68: return
    //   69: bipush 237
    //   71: invokestatic 271	android/os/Process:setThreadPriority	(I)V
    //   74: aload_0
    //   75: getfield 63	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mInSampleRate	I
    //   78: bipush 16
    //   80: iconst_2
    //   81: invokestatic 277	android/media/AudioRecord:getMinBufferSize	(III)I
    //   84: istore 6
    //   86: iload 6
    //   88: ifge +28 -> 116
    //   91: aload_0
    //   92: getfield 79	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   95: ifnull -79 -> 16
    //   98: aload_0
    //   99: getfield 79	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   102: ldc_w 278
    //   105: invokestatic 50	alud:a	(I)Ljava/lang/String;
    //   108: invokestatic 266	com/tencent/mobileqq/mini/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   111: invokevirtual 136	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   114: pop
    //   115: return
    //   116: aload_0
    //   117: getfield 63	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mInSampleRate	I
    //   120: iconst_2
    //   121: imul
    //   122: iconst_1
    //   123: imul
    //   124: iconst_5
    //   125: imul
    //   126: newarray short
    //   128: astore 14
    //   130: ldc2_w 279
    //   133: aload 14
    //   135: arraylength
    //   136: i2d
    //   137: ldc2_w 281
    //   140: dmul
    //   141: dadd
    //   142: d2i
    //   143: newarray byte
    //   145: astore 12
    //   147: aload_0
    //   148: getfield 284	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   151: ifle +928 -> 1079
    //   154: aload_0
    //   155: getfield 284	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   158: newarray byte
    //   160: astore 10
    //   162: new 286	java/io/FileOutputStream
    //   165: dup
    //   166: aload_0
    //   167: getfield 154	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mRecordFilPath	Ljava/lang/String;
    //   170: invokestatic 288	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:createSDFile	(Ljava/lang/String;)Ljava/io/File;
    //   173: invokespecial 291	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   176: astore 11
    //   178: aload 11
    //   180: ifnonnull +97 -> 277
    //   183: getstatic 40	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:TAG	Ljava/lang/String;
    //   186: iconst_1
    //   187: ldc_w 293
    //   190: invokestatic 199	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   193: aload_0
    //   194: getfield 79	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   197: ifnull -181 -> 16
    //   200: aload_0
    //   201: getfield 79	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   204: ldc_w 294
    //   207: invokestatic 50	alud:a	(I)Ljava/lang/String;
    //   210: invokestatic 266	com/tencent/mobileqq/mini/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   213: invokevirtual 136	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   216: pop
    //   217: return
    //   218: astore 8
    //   220: aload_0
    //   221: getfield 79	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   224: ifnull -208 -> 16
    //   227: aload_0
    //   228: getfield 79	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   231: ldc_w 295
    //   234: invokestatic 50	alud:a	(I)Ljava/lang/String;
    //   237: invokestatic 266	com/tencent/mobileqq/mini/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   240: invokevirtual 136	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   243: pop
    //   244: return
    //   245: astore 8
    //   247: aload_0
    //   248: getfield 79	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   251: ifnull +20 -> 271
    //   254: aload_0
    //   255: getfield 79	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   258: ldc_w 296
    //   261: invokestatic 50	alud:a	(I)Ljava/lang/String;
    //   264: invokestatic 266	com/tencent/mobileqq/mini/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   267: invokevirtual 136	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   270: pop
    //   271: aconst_null
    //   272: astore 11
    //   274: goto -96 -> 178
    //   277: aload_0
    //   278: getfield 63	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mInSampleRate	I
    //   281: aload_0
    //   282: getfield 67	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mOutChannel	I
    //   285: aload_0
    //   286: getfield 63	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mInSampleRate	I
    //   289: aload_0
    //   290: getfield 69	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mOutBitRate	I
    //   293: aload_0
    //   294: getfield 71	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mQuality	I
    //   297: invokestatic 300	com/tencent/mobileqq/mini/audiorecorder/LameMp3Native:jniInit	(IIIII)V
    //   300: aload_0
    //   301: iconst_1
    //   302: putfield 165	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:isRecording	Z
    //   305: aload_0
    //   306: iconst_0
    //   307: putfield 178	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:isPause	Z
    //   310: new 273	android/media/AudioRecord
    //   313: dup
    //   314: aload_0
    //   315: getfield 55	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mAudioSource	I
    //   318: aload_0
    //   319: getfield 63	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mInSampleRate	I
    //   322: bipush 16
    //   324: aload_0
    //   325: getfield 57	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mEncodingPcmFormat	I
    //   328: iload 6
    //   330: iconst_2
    //   331: imul
    //   332: invokespecial 302	android/media/AudioRecord:<init>	(IIIII)V
    //   335: astore 13
    //   337: aload 13
    //   339: invokevirtual 305	android/media/AudioRecord:startRecording	()V
    //   342: aload_0
    //   343: getfield 79	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   346: ifnull +739 -> 1085
    //   349: aload_0
    //   350: getfield 79	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   353: iconst_1
    //   354: invokevirtual 309	android/os/Handler:sendEmptyMessage	(I)Z
    //   357: pop
    //   358: goto +727 -> 1085
    //   361: aload_0
    //   362: getfield 165	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:isRecording	Z
    //   365: ifeq +701 -> 1066
    //   368: aload_0
    //   369: getfield 178	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:isPause	Z
    //   372: istore 7
    //   374: iload 7
    //   376: ifeq +47 -> 423
    //   379: iload_2
    //   380: ifne -19 -> 361
    //   383: iconst_1
    //   384: istore_2
    //   385: goto -24 -> 361
    //   388: astore 8
    //   390: aload_0
    //   391: getfield 79	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   394: ifnull +20 -> 414
    //   397: aload_0
    //   398: getfield 79	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   401: ldc_w 310
    //   404: invokestatic 50	alud:a	(I)Ljava/lang/String;
    //   407: invokestatic 266	com/tencent/mobileqq/mini/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   410: invokevirtual 136	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   413: pop
    //   414: invokestatic 313	com/tencent/mobileqq/mini/audiorecorder/LameMp3Native:jniClose	()V
    //   417: aload_0
    //   418: iconst_0
    //   419: putfield 165	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:isRecording	Z
    //   422: return
    //   423: iload_2
    //   424: ifeq +645 -> 1069
    //   427: iconst_0
    //   428: istore_2
    //   429: aload 13
    //   431: aload 14
    //   433: iconst_0
    //   434: iload 6
    //   436: invokevirtual 317	android/media/AudioRecord:read	([SII)I
    //   439: istore_3
    //   440: aload_0
    //   441: aload_0
    //   442: iload_3
    //   443: aload 14
    //   445: invokevirtual 319	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:getVoiceSize	(I[S)I
    //   448: putfield 159	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mVoiceLevel	I
    //   451: iload_3
    //   452: ifge +163 -> 615
    //   455: aload_0
    //   456: getfield 79	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   459: ifnull +607 -> 1066
    //   462: aload_0
    //   463: getfield 79	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   466: ldc_w 320
    //   469: invokestatic 50	alud:a	(I)Ljava/lang/String;
    //   472: invokestatic 266	com/tencent/mobileqq/mini/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   475: invokevirtual 136	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   478: pop
    //   479: goto +616 -> 1095
    //   482: aload_0
    //   483: aload 8
    //   485: iload 7
    //   487: invokespecial 322	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:onFrameRecord	([BZ)V
    //   490: iload_1
    //   491: ifle +25 -> 516
    //   494: iload_1
    //   495: newarray byte
    //   497: astore 8
    //   499: aload 10
    //   501: iconst_0
    //   502: aload 8
    //   504: iconst_0
    //   505: iload_1
    //   506: invokestatic 328	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   509: aload_0
    //   510: aload 8
    //   512: iconst_1
    //   513: invokespecial 322	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:onFrameRecord	([BZ)V
    //   516: aload 12
    //   518: invokestatic 332	com/tencent/mobileqq/mini/audiorecorder/LameMp3Native:jniFlush	([B)I
    //   521: istore_1
    //   522: iload_1
    //   523: ifge +27 -> 550
    //   526: aload_0
    //   527: getfield 79	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   530: ifnull +20 -> 550
    //   533: aload_0
    //   534: getfield 79	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   537: ldc_w 333
    //   540: invokestatic 50	alud:a	(I)Ljava/lang/String;
    //   543: invokestatic 266	com/tencent/mobileqq/mini/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   546: invokevirtual 136	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   549: pop
    //   550: iload_1
    //   551: ifeq +12 -> 563
    //   554: aload 11
    //   556: aload 12
    //   558: iconst_0
    //   559: iload_1
    //   560: invokevirtual 337	java/io/FileOutputStream:write	([BII)V
    //   563: aload 11
    //   565: invokevirtual 340	java/io/FileOutputStream:close	()V
    //   568: aload 13
    //   570: invokevirtual 343	android/media/AudioRecord:stop	()V
    //   573: aload 13
    //   575: invokevirtual 346	android/media/AudioRecord:release	()V
    //   578: invokestatic 313	com/tencent/mobileqq/mini/audiorecorder/LameMp3Native:jniClose	()V
    //   581: aload_0
    //   582: iconst_0
    //   583: putfield 165	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:isRecording	Z
    //   586: aload_0
    //   587: getfield 79	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   590: ifnull -574 -> 16
    //   593: aload_0
    //   594: getfield 77	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mp3Player	Lcom/tencent/mobileqq/mini/audiorecorder/LameMp3Recorder;
    //   597: invokevirtual 349	com/tencent/mobileqq/mini/audiorecorder/LameMp3Recorder:getRecordDuration	()J
    //   600: lconst_1
    //   601: lcmp
    //   602: ifle +417 -> 1019
    //   605: aload_0
    //   606: getfield 79	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   609: iconst_5
    //   610: invokevirtual 309	android/os/Handler:sendEmptyMessage	(I)Z
    //   613: pop
    //   614: return
    //   615: iload_3
    //   616: ifne +6 -> 622
    //   619: goto -258 -> 361
    //   622: aload 14
    //   624: aload 14
    //   626: iload_3
    //   627: aload 12
    //   629: invokestatic 353	com/tencent/mobileqq/mini/audiorecorder/LameMp3Native:jniEncode	([S[SI[B)I
    //   632: istore 5
    //   634: iload 5
    //   636: ifge +30 -> 666
    //   639: aload_0
    //   640: getfield 79	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   643: ifnull +423 -> 1066
    //   646: aload_0
    //   647: getfield 79	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   650: ldc_w 354
    //   653: invokestatic 50	alud:a	(I)Ljava/lang/String;
    //   656: invokestatic 266	com/tencent/mobileqq/mini/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   659: invokevirtual 136	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   662: pop
    //   663: goto +432 -> 1095
    //   666: iload_1
    //   667: istore 4
    //   669: aload 8
    //   671: astore 9
    //   673: iload 5
    //   675: ifeq +205 -> 880
    //   678: aload 11
    //   680: aload 12
    //   682: iconst_0
    //   683: iload 5
    //   685: invokevirtual 337	java/io/FileOutputStream:write	([BII)V
    //   688: iload_1
    //   689: istore 4
    //   691: aload 8
    //   693: astore 9
    //   695: aload_0
    //   696: getfield 284	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   699: ifle +181 -> 880
    //   702: aload 8
    //   704: astore 9
    //   706: aload 8
    //   708: ifnull +13 -> 721
    //   711: aload_0
    //   712: aload 8
    //   714: iconst_0
    //   715: invokespecial 322	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:onFrameRecord	([BZ)V
    //   718: aconst_null
    //   719: astore 9
    //   721: iconst_0
    //   722: istore_3
    //   723: iload_1
    //   724: istore 4
    //   726: iload_1
    //   727: iload 5
    //   729: iadd
    //   730: istore 5
    //   732: iload 4
    //   734: istore_1
    //   735: aload 9
    //   737: astore 8
    //   739: iload 5
    //   741: istore 4
    //   743: iload 4
    //   745: aload_0
    //   746: getfield 284	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   749: if_icmplt +109 -> 858
    //   752: aload_0
    //   753: getfield 284	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   756: newarray byte
    //   758: astore 9
    //   760: iload_1
    //   761: ifle +70 -> 831
    //   764: aload 10
    //   766: iconst_0
    //   767: aload 9
    //   769: iconst_0
    //   770: iload_1
    //   771: invokestatic 328	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   774: aload_0
    //   775: getfield 284	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   778: iload_1
    //   779: isub
    //   780: istore 5
    //   782: aload 12
    //   784: iconst_0
    //   785: aload 9
    //   787: iload_1
    //   788: iload 5
    //   790: invokestatic 328	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   793: iconst_0
    //   794: istore_1
    //   795: iload_3
    //   796: iload 5
    //   798: iadd
    //   799: istore_3
    //   800: iload 4
    //   802: aload_0
    //   803: getfield 284	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   806: isub
    //   807: istore 4
    //   809: iload 4
    //   811: aload_0
    //   812: getfield 284	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   815: if_icmplt +257 -> 1072
    //   818: aload_0
    //   819: aload 9
    //   821: iconst_0
    //   822: invokespecial 322	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:onFrameRecord	([BZ)V
    //   825: aconst_null
    //   826: astore 8
    //   828: goto -85 -> 743
    //   831: aload 12
    //   833: iload_3
    //   834: aload 9
    //   836: iconst_0
    //   837: aload_0
    //   838: getfield 284	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   841: invokestatic 328	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   844: aload_0
    //   845: getfield 284	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mCallbackFrameSize	I
    //   848: istore 5
    //   850: iload 5
    //   852: iload_3
    //   853: iadd
    //   854: istore_3
    //   855: goto -55 -> 800
    //   858: iload 4
    //   860: ifle +30 -> 890
    //   863: aload 12
    //   865: iload_3
    //   866: aload 10
    //   868: iload_1
    //   869: iload 4
    //   871: iload_1
    //   872: isub
    //   873: invokestatic 328	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   876: aload 8
    //   878: astore 9
    //   880: iload 4
    //   882: istore_1
    //   883: aload 9
    //   885: astore 8
    //   887: goto -526 -> 361
    //   890: iconst_0
    //   891: istore 4
    //   893: aload 8
    //   895: astore 9
    //   897: goto -17 -> 880
    //   900: astore 8
    //   902: aload 9
    //   904: astore 8
    //   906: aload_0
    //   907: getfield 79	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   910: ifnull +200 -> 1110
    //   913: aload_0
    //   914: getfield 79	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   917: ldc_w 355
    //   920: invokestatic 50	alud:a	(I)Ljava/lang/String;
    //   923: invokestatic 266	com/tencent/mobileqq/mini/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   926: invokevirtual 136	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   929: pop
    //   930: goto +180 -> 1110
    //   933: astore 8
    //   935: aload_0
    //   936: getfield 79	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   939: ifnull -376 -> 563
    //   942: aload_0
    //   943: getfield 79	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   946: ldc_w 356
    //   949: invokestatic 50	alud:a	(I)Ljava/lang/String;
    //   952: invokestatic 266	com/tencent/mobileqq/mini/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   955: invokevirtual 136	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   958: pop
    //   959: goto -396 -> 563
    //   962: astore 8
    //   964: aload 13
    //   966: invokevirtual 343	android/media/AudioRecord:stop	()V
    //   969: aload 13
    //   971: invokevirtual 346	android/media/AudioRecord:release	()V
    //   974: aload 8
    //   976: athrow
    //   977: astore 8
    //   979: invokestatic 313	com/tencent/mobileqq/mini/audiorecorder/LameMp3Native:jniClose	()V
    //   982: aload_0
    //   983: iconst_0
    //   984: putfield 165	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:isRecording	Z
    //   987: aload 8
    //   989: athrow
    //   990: astore 8
    //   992: aload_0
    //   993: getfield 79	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   996: ifnull -428 -> 568
    //   999: aload_0
    //   1000: getfield 79	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mMainHandler	Landroid/os/Handler;
    //   1003: ldc_w 357
    //   1006: invokestatic 50	alud:a	(I)Ljava/lang/String;
    //   1009: invokestatic 266	com/tencent/mobileqq/mini/audiorecorder/LameMp3Recorder:generateRecordErrMsg	(Ljava/lang/String;)Landroid/os/Message;
    //   1012: invokevirtual 136	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   1015: pop
    //   1016: goto -448 -> 568
    //   1019: new 98	java/io/File
    //   1022: dup
    //   1023: aload_0
    //   1024: getfield 154	com/tencent/mobileqq/mini/audiorecorder/LameMp3EncodeThread:mRecordFilPath	Ljava/lang/String;
    //   1027: invokespecial 99	java/io/File:<init>	(Ljava/lang/String;)V
    //   1030: astore 8
    //   1032: aload 8
    //   1034: invokevirtual 103	java/io/File:exists	()Z
    //   1037: ifeq -1021 -> 16
    //   1040: aload 8
    //   1042: invokevirtual 360	java/io/File:delete	()Z
    //   1045: pop
    //   1046: return
    //   1047: astore 8
    //   1049: aload 9
    //   1051: astore 8
    //   1053: goto -147 -> 906
    //   1056: astore 9
    //   1058: goto -152 -> 906
    //   1061: astore 9
    //   1063: goto -157 -> 906
    //   1066: goto +29 -> 1095
    //   1069: goto -640 -> 429
    //   1072: aload 9
    //   1074: astore 8
    //   1076: goto -333 -> 743
    //   1079: aconst_null
    //   1080: astore 10
    //   1082: goto -920 -> 162
    //   1085: iconst_0
    //   1086: istore_2
    //   1087: iconst_0
    //   1088: istore_1
    //   1089: aconst_null
    //   1090: astore 8
    //   1092: goto -731 -> 361
    //   1095: aload 8
    //   1097: ifnull -607 -> 490
    //   1100: iload_1
    //   1101: ifne +12 -> 1113
    //   1104: iconst_1
    //   1105: istore 7
    //   1107: goto -625 -> 482
    //   1110: goto -15 -> 1095
    //   1113: iconst_0
    //   1114: istore 7
    //   1116: goto -634 -> 482
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1119	0	this	LameMp3EncodeThread
    //   490	611	1	i	int
    //   379	708	2	j	int
    //   439	427	3	k	int
    //   667	225	4	m	int
    //   632	222	5	n	int
    //   84	351	6	i1	int
    //   372	743	7	bool	boolean
    //   218	1	8	localFileNotFoundException	java.io.FileNotFoundException
    //   245	1	8	localIOException	java.io.IOException
    //   388	96	8	localIllegalStateException	java.lang.IllegalStateException
    //   497	397	8	localObject1	java.lang.Object
    //   900	1	8	localThrowable1	java.lang.Throwable
    //   904	1	8	localObject2	java.lang.Object
    //   933	1	8	localThrowable2	java.lang.Throwable
    //   962	13	8	localObject3	java.lang.Object
    //   977	11	8	localObject4	java.lang.Object
    //   990	1	8	localThrowable3	java.lang.Throwable
    //   1030	11	8	localFile	File
    //   1047	1	8	localThrowable4	java.lang.Throwable
    //   1051	45	8	localObject5	java.lang.Object
    //   671	379	9	localObject6	java.lang.Object
    //   1056	1	9	localThrowable5	java.lang.Throwable
    //   1061	12	9	localThrowable6	java.lang.Throwable
    //   160	921	10	arrayOfByte1	byte[]
    //   176	503	11	localFileOutputStream	java.io.FileOutputStream
    //   145	719	12	arrayOfByte2	byte[]
    //   335	635	13	localAudioRecord	android.media.AudioRecord
    //   128	497	14	arrayOfShort	short[]
    // Exception table:
    //   from	to	target	type
    //   162	178	218	java/io/FileNotFoundException
    //   162	178	245	java/io/IOException
    //   337	342	388	java/lang/IllegalStateException
    //   764	793	900	java/lang/Throwable
    //   831	850	900	java/lang/Throwable
    //   554	563	933	java/lang/Throwable
    //   342	358	962	finally
    //   361	374	962	finally
    //   429	451	962	finally
    //   455	479	962	finally
    //   482	490	962	finally
    //   494	516	962	finally
    //   516	522	962	finally
    //   526	550	962	finally
    //   554	563	962	finally
    //   563	568	962	finally
    //   622	634	962	finally
    //   639	663	962	finally
    //   678	688	962	finally
    //   695	702	962	finally
    //   711	718	962	finally
    //   743	760	962	finally
    //   764	793	962	finally
    //   800	825	962	finally
    //   831	850	962	finally
    //   863	876	962	finally
    //   906	930	962	finally
    //   935	959	962	finally
    //   992	1016	962	finally
    //   337	342	977	finally
    //   390	414	977	finally
    //   568	578	977	finally
    //   964	977	977	finally
    //   563	568	990	java/lang/Throwable
    //   800	825	1047	java/lang/Throwable
    //   743	760	1056	java/lang/Throwable
    //   863	876	1056	java/lang/Throwable
    //   678	688	1061	java/lang/Throwable
    //   695	702	1061	java/lang/Throwable
    //   711	718	1061	java/lang/Throwable
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.audiorecorder.LameMp3EncodeThread
 * JD-Core Version:    0.7.0.1
 */