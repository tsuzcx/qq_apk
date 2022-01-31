package com.tencent.ttpic.voicechanger.common.audio;

import android.content.Context;
import android.media.AudioRecord;
import android.text.TextUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.logic.watermark.FFTData;

public class AudioRecorderCompat
{
  public static int AUDIO_BIT_RATE = BIT_RATES[1];
  public static int AUDIO_CHANNEL_COUNT = 0;
  public static int AUDIO_INPUT_BUFFER_SIZE = (int)(AUDIO_SAMPLE_RATE_IN_HZ * 0.02D * AUDIO_CHANNEL_COUNT * 4.0D);
  public static int AUDIO_OUTPUT_BUFFER_SIZE = AUDIO_INPUT_BUFFER_SIZE * AUDIO_CHANNEL_COUNT;
  public static int AUDIO_SAMPLE_RATE_IN_HZ = 0;
  public static final int[] BIT_RATES;
  public static final int ERROR_AUDIO_FILE_NOT_EXIST = 1;
  public static final int ERROR_AUDIO_ILLEGAL_ARGUMENT = 3;
  public static final int ERROR_AUDIO_INIT_AUDIORECORD_FAILED = 4;
  public static final int ERROR_AUDIO_OUT_OF_MEMORY = 2;
  public static final int ERROR_AUDIO_REAL_PACKER_FAILED = 7;
  public static final int ERROR_AUDIO_RECORD_READ_FAILED = 6;
  public static final int ERROR_AUDIO_RECORD_START_FAILED = 5;
  public static final int[] SAMPLE_RATES;
  protected static final String TAG = AudioRecorderCompat.class.getSimpleName();
  public static final int WX_VOICE_HTTP_ERROR_NETWORK = -201;
  protected AudioRecord mARecorder;
  protected AudioRecorderCompat.AsyncPcmWriter mAsyncPcmWriter;
  protected String mAudioPath;
  protected int mBufSize = AUDIO_OUTPUT_BUFFER_SIZE;
  protected byte[] mBuffer;
  protected AudioRecorderCompat.State mCurrentState = new AudioRecorderCompat.State(this);
  private int mDecibel;
  protected int mDelay;
  private FFTData mFFTDataResult = new FFTData(AUDIO_INPUT_BUFFER_SIZE, AUDIO_SAMPLE_RATE_IN_HZ / 2);
  protected boolean mHasDelaySet;
  protected int mHasRecordLength;
  private int mLastBufferSize = AUDIO_INPUT_BUFFER_SIZE;
  private int mLastSampleRate = AUDIO_SAMPLE_RATE_IN_HZ;
  protected AudioRecorderCompat.AudioListener mListener;
  protected OnErrorListener mOnErrorListener;
  protected RealTimePcmPacker mPcmPacker;
  protected boolean mRealPackerEnable;
  protected AudioRecorderCompat.SimpleRecordThread mRecThread;
  protected boolean mVoice2TextEnable;
  protected boolean mVoiceChangeEnable;
  protected VoiceChanger mVoiceChanger;
  protected boolean mWrite2FileEnable;
  private short[] mfftbuffer = new short[AUDIO_INPUT_BUFFER_SIZE];
  private boolean needDB = false;
  
  static
  {
    SAMPLE_RATES = new int[] { 8000, 11025, 16000, 22050, 44100, 48000 };
    BIT_RATES = new int[] { 64000, 96000, 128000 };
    AUDIO_SAMPLE_RATE_IN_HZ = SAMPLE_RATES[2];
    AUDIO_CHANNEL_COUNT = 1;
  }
  
  public AudioRecorderCompat(String paramString)
  {
    this.mAudioPath = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      bool1 = true;
      this.mWrite2FileEnable = bool1;
      if ((TextUtils.isEmpty(paramString)) || (!this.mAudioPath.endsWith(".m4a"))) {
        break label123;
      }
    }
    label123:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.mRealPackerEnable = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  public void enableVoice2Text(Context paramContext, OnErrorListener paramOnErrorListener)
  {
    VoiceTextRecognizer.getInstance().init(paramContext, true);
    VoiceTextRecognizer.getInstance().setVRErrorListener(new AudioRecorderCompat.1(this, paramOnErrorListener));
    VoiceTextRecognizer.getInstance().start();
    this.mVoice2TextEnable = true;
  }
  
  public int getDecibel()
  {
    return this.mDecibel;
  }
  
  public int getDelay()
  {
    return this.mDelay;
  }
  
  public FFTData getFFTResult()
  {
    return this.mFFTDataResult;
  }
  
  public int init()
  {
    return initWithAudioSource(1);
  }
  
  public int init(int paramInt1, int paramInt2)
  {
    return initWithAudioSource(1, paramInt1, paramInt2);
  }
  
  /* Error */
  public int initWithAudioSource(int paramInt)
  {
    // Byte code:
    //   0: invokestatic 219	java/lang/System:currentTimeMillis	()J
    //   3: lstore 4
    //   5: aload_0
    //   6: getstatic 89	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_SAMPLE_RATE_IN_HZ	I
    //   9: bipush 16
    //   11: iconst_2
    //   12: invokestatic 224	android/media/AudioRecord:getMinBufferSize	(III)I
    //   15: putfield 117	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mBufSize	I
    //   18: getstatic 78	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:TAG	Ljava/lang/String;
    //   21: new 226	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   28: ldc 229
    //   30: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_0
    //   34: getfield 117	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mBufSize	I
    //   37: invokevirtual 236	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   40: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 245	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: aload_0
    //   47: getfield 117	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mBufSize	I
    //   50: getstatic 101	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_OUTPUT_BUFFER_SIZE	I
    //   53: if_icmpgt +10 -> 63
    //   56: aload_0
    //   57: getstatic 101	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_OUTPUT_BUFFER_SIZE	I
    //   60: putfield 117	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mBufSize	I
    //   63: aload_0
    //   64: aload_0
    //   65: getfield 117	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mBufSize	I
    //   68: newarray byte
    //   70: putfield 247	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mBuffer	[B
    //   73: aload_0
    //   74: new 221	android/media/AudioRecord
    //   77: dup
    //   78: iload_1
    //   79: getstatic 89	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_SAMPLE_RATE_IN_HZ	I
    //   82: getstatic 91	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_CHANNEL_COUNT	I
    //   85: bipush 16
    //   87: imul
    //   88: iconst_2
    //   89: aload_0
    //   90: getfield 117	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mBufSize	I
    //   93: invokespecial 250	android/media/AudioRecord:<init>	(IIIII)V
    //   96: putfield 252	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mARecorder	Landroid/media/AudioRecord;
    //   99: aload_0
    //   100: getfield 252	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mARecorder	Landroid/media/AudioRecord;
    //   103: invokevirtual 255	android/media/AudioRecord:getState	()I
    //   106: iconst_1
    //   107: if_icmpeq +72 -> 179
    //   110: getstatic 78	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:TAG	Ljava/lang/String;
    //   113: ldc_w 257
    //   116: invokestatic 260	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: aload_0
    //   120: getfield 115	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
    //   123: iconst_1
    //   124: invokevirtual 264	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State:transfer	(I)V
    //   127: iconst_4
    //   128: ireturn
    //   129: astore 6
    //   131: getstatic 78	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:TAG	Ljava/lang/String;
    //   134: aload 6
    //   136: invokevirtual 267	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   139: invokestatic 260	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   142: aload_0
    //   143: getfield 115	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
    //   146: iconst_1
    //   147: invokevirtual 264	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State:transfer	(I)V
    //   150: iconst_2
    //   151: ireturn
    //   152: astore 6
    //   154: getstatic 78	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:TAG	Ljava/lang/String;
    //   157: ldc_w 269
    //   160: aload 6
    //   162: iconst_0
    //   163: anewarray 4	java/lang/Object
    //   166: invokestatic 272	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   169: aload_0
    //   170: getfield 115	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
    //   173: iconst_1
    //   174: invokevirtual 264	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State:transfer	(I)V
    //   177: iconst_3
    //   178: ireturn
    //   179: aload_0
    //   180: getfield 252	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mARecorder	Landroid/media/AudioRecord;
    //   183: invokevirtual 275	android/media/AudioRecord:getRecordingState	()I
    //   186: iconst_1
    //   187: if_icmpne +10 -> 197
    //   190: aload_0
    //   191: getfield 252	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mARecorder	Landroid/media/AudioRecord;
    //   194: invokevirtual 278	android/media/AudioRecord:startRecording	()V
    //   197: aload_0
    //   198: getfield 252	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mARecorder	Landroid/media/AudioRecord;
    //   201: invokevirtual 275	android/media/AudioRecord:getRecordingState	()I
    //   204: iconst_3
    //   205: if_icmpne +10 -> 215
    //   208: aload_0
    //   209: getfield 252	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mARecorder	Landroid/media/AudioRecord;
    //   212: invokevirtual 281	android/media/AudioRecord:stop	()V
    //   215: aload_0
    //   216: getfield 115	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
    //   219: iconst_4
    //   220: invokevirtual 264	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State:transfer	(I)V
    //   223: aload_0
    //   224: new 283	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$AsyncPcmWriter
    //   227: dup
    //   228: aload_0
    //   229: aload_0
    //   230: getfield 132	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mAudioPath	Ljava/lang/String;
    //   233: getstatic 99	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_INPUT_BUFFER_SIZE	I
    //   236: invokespecial 286	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$AsyncPcmWriter:<init>	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;Ljava/lang/String;I)V
    //   239: putfield 288	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mAsyncPcmWriter	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$AsyncPcmWriter;
    //   242: aload_0
    //   243: new 290	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread
    //   246: dup
    //   247: aload_0
    //   248: new 226	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   255: ldc_w 292
    //   258: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: invokestatic 219	java/lang/System:currentTimeMillis	()J
    //   264: invokevirtual 295	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   267: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokespecial 298	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:<init>	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat;Ljava/lang/String;)V
    //   273: putfield 300	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mRecThread	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread;
    //   276: aload_0
    //   277: getfield 300	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mRecThread	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread;
    //   280: invokevirtual 301	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$SimpleRecordThread:start	()V
    //   283: invokestatic 219	java/lang/System:currentTimeMillis	()J
    //   286: lstore_2
    //   287: getstatic 78	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:TAG	Ljava/lang/String;
    //   290: new 226	java/lang/StringBuilder
    //   293: dup
    //   294: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   297: ldc_w 303
    //   300: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: lload_2
    //   304: lload 4
    //   306: lsub
    //   307: invokevirtual 295	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   310: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: invokestatic 245	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   316: aload_0
    //   317: getfield 150	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mRealPackerEnable	Z
    //   320: ifeq +75 -> 395
    //   323: aload_0
    //   324: new 305	com/tencent/ttpic/voicechanger/common/audio/RealTimePcmPacker
    //   327: dup
    //   328: getstatic 93	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_BIT_RATE	I
    //   331: getstatic 89	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_SAMPLE_RATE_IN_HZ	I
    //   334: getstatic 91	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_CHANNEL_COUNT	I
    //   337: invokespecial 308	com/tencent/ttpic/voicechanger/common/audio/RealTimePcmPacker:<init>	(III)V
    //   340: putfield 310	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mPcmPacker	Lcom/tencent/ttpic/voicechanger/common/audio/RealTimePcmPacker;
    //   343: aload_0
    //   344: getfield 310	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mPcmPacker	Lcom/tencent/ttpic/voicechanger/common/audio/RealTimePcmPacker;
    //   347: aload_0
    //   348: getfield 132	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mAudioPath	Ljava/lang/String;
    //   351: invokevirtual 313	com/tencent/ttpic/voicechanger/common/audio/RealTimePcmPacker:setOutputPath	(Ljava/lang/String;)V
    //   354: aload_0
    //   355: getfield 288	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mAsyncPcmWriter	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$AsyncPcmWriter;
    //   358: invokevirtual 316	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$AsyncPcmWriter:onPrepare	()V
    //   361: invokestatic 219	java/lang/System:currentTimeMillis	()J
    //   364: lstore 4
    //   366: getstatic 78	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:TAG	Ljava/lang/String;
    //   369: new 226	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   376: ldc_w 318
    //   379: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: lload 4
    //   384: lload_2
    //   385: lsub
    //   386: invokevirtual 295	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   389: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: invokestatic 245	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   395: iconst_0
    //   396: ireturn
    //   397: astore 6
    //   399: getstatic 78	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:TAG	Ljava/lang/String;
    //   402: ldc_w 320
    //   405: aload 6
    //   407: iconst_0
    //   408: anewarray 4	java/lang/Object
    //   411: invokestatic 323	com/tencent/ttpic/baseutils/log/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   414: aload_0
    //   415: getfield 115	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
    //   418: iconst_1
    //   419: invokevirtual 264	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State:transfer	(I)V
    //   422: iconst_5
    //   423: ireturn
    //   424: astore 6
    //   426: getstatic 78	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:TAG	Ljava/lang/String;
    //   429: aload 6
    //   431: invokevirtual 324	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   434: invokestatic 260	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   437: aload_0
    //   438: getfield 115	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
    //   441: iconst_1
    //   442: invokevirtual 264	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State:transfer	(I)V
    //   445: iconst_1
    //   446: ireturn
    //   447: astore 6
    //   449: getstatic 78	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:TAG	Ljava/lang/String;
    //   452: aload 6
    //   454: invokevirtual 325	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   457: invokestatic 260	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   460: aload_0
    //   461: getfield 115	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State;
    //   464: iconst_1
    //   465: invokevirtual 264	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat$State:transfer	(I)V
    //   468: bipush 7
    //   470: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	471	0	this	AudioRecorderCompat
    //   0	471	1	paramInt	int
    //   286	99	2	l1	long
    //   3	380	4	l2	long
    //   129	6	6	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   152	9	6	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   397	9	6	localSecurityException	java.lang.SecurityException
    //   424	6	6	localFileNotFoundException	java.io.FileNotFoundException
    //   447	6	6	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   63	73	129	java/lang/OutOfMemoryError
    //   73	99	152	java/lang/IllegalArgumentException
    //   190	197	397	java/lang/SecurityException
    //   223	242	424	java/io/FileNotFoundException
    //   316	395	447	java/lang/Exception
  }
  
  public int initWithAudioSource(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = initWithAudioSource(paramInt1);
    if (paramInt1 != 0) {
      return paramInt1;
    }
    long l = System.currentTimeMillis();
    this.mVoiceChanger = new VoiceChanger(this.mAudioPath, AUDIO_SAMPLE_RATE_IN_HZ, paramInt2, paramInt3);
    LogUtils.d(TAG, "Audio Processers: start voice changer = " + (System.currentTimeMillis() - l));
    LogUtils.d(TAG, "init() - currentState = " + this.mCurrentState);
    this.mVoiceChangeEnable = true;
    return paramInt1;
  }
  
  public void onDelaySet(int paramInt) {}
  
  public void onRecordError(int paramInt)
  {
    LogUtils.e(TAG, "onRecordError() - currentState = " + this.mCurrentState);
    if (this.mOnErrorListener != null) {
      this.mOnErrorListener.onError(paramInt);
    }
  }
  
  public void onRecordStop()
  {
    LogUtils.d(TAG, "onRecordStop() - currentState = " + this.mCurrentState);
    if (this.mAsyncPcmWriter != null) {
      this.mAsyncPcmWriter.onStop();
    }
  }
  
  public void onRecording(byte[] paramArrayOfByte, int paramInt)
  {
    if ((this.mWrite2FileEnable) && (this.mAsyncPcmWriter != null)) {
      this.mAsyncPcmWriter.onRecord(paramArrayOfByte, paramInt);
    }
    if (this.mVoice2TextEnable) {
      VoiceTextRecognizer.getInstance().recognizeFromPCMBuffer(paramArrayOfByte, paramInt);
    }
  }
  
  public void pause()
  {
    LogUtils.d(TAG, "pause() - currentState = " + this.mCurrentState);
    synchronized (this.mCurrentState)
    {
      if (this.mCurrentState.equalState(new int[] { 16 }))
      {
        LogUtils.d(TAG, "current state has been 16");
        return;
      }
      if (!this.mCurrentState.equalState(new int[] { 8, 4 })) {
        throw new IllegalStateException("current status is: " + this.mCurrentState);
      }
    }
    this.mCurrentState.transfer(16);
  }
  
  public void release()
  {
    LogUtils.d(TAG, "release start");
    synchronized (this.mCurrentState)
    {
      if (!this.mCurrentState.equalState(new int[] { 32 }))
      {
        LogUtils.i(TAG, "stop() is forgotten by someone, so call it now!");
        stop(null);
      }
      this.mCurrentState.transfer(2);
      this.mHasRecordLength = 0;
      if ((this.mRecThread == null) || (this.mRecThread.equals(Thread.currentThread()))) {}
    }
    try
    {
      this.mRecThread.join();
      if (this.mARecorder != null) {
        this.mARecorder.release();
      }
      LogUtils.d(TAG, "AduioRecord release finish");
      this.mHasRecordLength = 0;
      LogUtils.d(TAG, "release finish");
      return;
      localObject = finally;
      throw localObject;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        LogUtils.e(TAG, localInterruptedException.getMessage());
        this.mRecThread = null;
      }
    }
  }
  
  public void resume()
  {
    LogUtils.d(TAG, "resume() - currentState = " + this.mCurrentState);
    start();
  }
  
  public void setNeedDB(boolean paramBoolean)
  {
    this.needDB = paramBoolean;
  }
  
  public void setOnErrorListener(OnErrorListener paramOnErrorListener)
  {
    this.mOnErrorListener = paramOnErrorListener;
  }
  
  public void setSampleRate(int paramInt)
  {
    AUDIO_SAMPLE_RATE_IN_HZ = paramInt;
    AUDIO_INPUT_BUFFER_SIZE = (int)(AUDIO_SAMPLE_RATE_IN_HZ * 0.02D * AUDIO_CHANNEL_COUNT * 4.0D);
    AUDIO_OUTPUT_BUFFER_SIZE = AUDIO_INPUT_BUFFER_SIZE * AUDIO_CHANNEL_COUNT;
    if ((this.mLastBufferSize != AUDIO_INPUT_BUFFER_SIZE) || (this.mLastSampleRate != AUDIO_SAMPLE_RATE_IN_HZ))
    {
      this.mFFTDataResult = new FFTData(AUDIO_INPUT_BUFFER_SIZE, AUDIO_SAMPLE_RATE_IN_HZ);
      this.mfftbuffer = new short[AUDIO_INPUT_BUFFER_SIZE];
    }
  }
  
  public void start()
  {
    LogUtils.d(TAG, "start() - currentState = " + this.mCurrentState);
    synchronized (this.mCurrentState)
    {
      if (this.mCurrentState.equalState(new int[] { 8 }))
      {
        LogUtils.w(TAG, "current state has been 8");
        return;
      }
      if (!this.mCurrentState.equalState(new int[] { 16, 4 })) {
        throw new IllegalStateException("current status is: " + this.mCurrentState);
      }
    }
    this.mCurrentState.transfer(8);
  }
  
  public void stop(AudioRecorderCompat.AudioListener paramAudioListener)
  {
    LogUtils.d(TAG, "stop() - currentState = " + this.mCurrentState);
    synchronized (this.mCurrentState)
    {
      if (this.mCurrentState.equalState(new int[] { 32 }))
      {
        LogUtils.d(TAG, "current state has been 32");
        return;
      }
      this.mCurrentState.transfer(32);
      if ((this.mRecThread == null) || (this.mRecThread.equals(Thread.currentThread()))) {
        return;
      }
      this.mListener = paramAudioListener;
    }
    try
    {
      this.mRecThread.join();
      LogUtils.d(TAG, "stop() - join() - currentState = " + this.mCurrentState);
      this.mRecThread = null;
      return;
      paramAudioListener = finally;
      throw paramAudioListener;
    }
    catch (InterruptedException paramAudioListener)
    {
      for (;;)
      {
        LogUtils.e(TAG, paramAudioListener.getMessage());
      }
    }
  }
  
  protected void tryReleaseChanger()
  {
    if (this.mVoiceChanger != null) {
      this.mVoiceChanger.release();
    }
  }
  
  protected void tryReleasePacker()
  {
    if (this.mPcmPacker != null) {
      this.mPcmPacker.stop();
    }
  }
  
  protected void tryReleaseRecognizer()
  {
    if (this.mVoice2TextEnable)
    {
      VoiceTextRecognizer.getInstance().destroy();
      this.mVoice2TextEnable = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.voicechanger.common.audio.AudioRecorderCompat
 * JD-Core Version:    0.7.0.1
 */