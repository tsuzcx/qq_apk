package com.tencent.ttpic.voicechanger.common.audio;

import android.media.AudioRecord;
import com.tencent.ttpic.baseutils.log.LogUtils;

@Deprecated
public class AudioRecorderAndChangerForKitKat
  extends AudioRecorderCompat
{
  public static final int AUDIO_BIT_RATE = BIT_RATES[1];
  public static final int AUDIO_CHANNEL_COUNT = 1;
  public static final int AUDIO_INPUT_BUFFER_SIZE = (int)(AUDIO_SAMPLE_RATE_IN_HZ * 0.02D * 1.0D * 4.0D);
  public static final int AUDIO_OUTPUT_BUFFER_SIZE = AUDIO_INPUT_BUFFER_SIZE * 1;
  public static final int AUDIO_SAMPLE_RATE_IN_HZ;
  public static final int[] BIT_RATES;
  public static final int ERROR_AUDIO_FILE_NOT_EXIST = 1;
  public static final int ERROR_AUDIO_ILLEGAL_ARGUMENT = 3;
  public static final int ERROR_AUDIO_INIT_AUDIORECORD_FAILED = 4;
  public static final int ERROR_AUDIO_OUT_OF_MEMORY = 2;
  public static final int ERROR_AUDIO_RECORD_READ_FAILED = 6;
  public static final int ERROR_AUDIO_RECORD_START_FAILED = 5;
  public static final int[] SAMPLE_RATES = { 8000, 11025, 16000, 22050, 44100, 48000 };
  protected AudioRecord mARecorder;
  protected AudioRecorderAndChangerForKitKat.AsyncPcmWriterForKitKat mAsyncPcmWriter;
  protected int mBufSize = AUDIO_OUTPUT_BUFFER_SIZE;
  protected byte[] mBuffer;
  protected AudioRecorderAndChangerForKitKat.State mCurrentState = new AudioRecorderAndChangerForKitKat.State(this);
  protected int mDelay;
  protected boolean mHasDelaySet;
  protected int mHasRecordLength;
  protected OnErrorListener mOnErrorListener;
  protected RealTimePcmPacker mPcmPacker;
  protected String mPcmPath;
  protected AudioRecorderAndChangerForKitKat.SimpleRecordThreadForKitKat mRecThread;
  protected VoiceChanger mVoiceChanger;
  protected boolean needVoiceChange = false;
  
  static
  {
    BIT_RATES = new int[] { 64000, 96000, 128000 };
    AUDIO_SAMPLE_RATE_IN_HZ = SAMPLE_RATES[5];
  }
  
  public AudioRecorderAndChangerForKitKat(String paramString)
  {
    super(paramString);
  }
  
  public int getDelay()
  {
    return this.mDelay;
  }
  
  /* Error */
  public int init()
  {
    // Byte code:
    //   0: invokestatic 108	java/lang/System:currentTimeMillis	()J
    //   3: pop2
    //   4: aload_0
    //   5: getstatic 63	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:AUDIO_SAMPLE_RATE_IN_HZ	I
    //   8: bipush 16
    //   10: iconst_2
    //   11: invokestatic 114	android/media/AudioRecord:getMinBufferSize	(III)I
    //   14: putfield 87	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mBufSize	I
    //   17: getstatic 117	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:TAG	Ljava/lang/String;
    //   20: new 119	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   27: ldc 123
    //   29: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_0
    //   33: getfield 87	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mBufSize	I
    //   36: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   39: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 140	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: aload_0
    //   46: getfield 87	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mBufSize	I
    //   49: getstatic 73	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:AUDIO_OUTPUT_BUFFER_SIZE	I
    //   52: if_icmpgt +10 -> 62
    //   55: aload_0
    //   56: getstatic 73	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:AUDIO_OUTPUT_BUFFER_SIZE	I
    //   59: putfield 87	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mBufSize	I
    //   62: aload_0
    //   63: aload_0
    //   64: getfield 87	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mBufSize	I
    //   67: newarray byte
    //   69: putfield 142	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mBuffer	[B
    //   72: aload_0
    //   73: new 110	android/media/AudioRecord
    //   76: dup
    //   77: iconst_1
    //   78: getstatic 63	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:AUDIO_SAMPLE_RATE_IN_HZ	I
    //   81: bipush 16
    //   83: iconst_2
    //   84: aload_0
    //   85: getfield 87	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mBufSize	I
    //   88: invokespecial 145	android/media/AudioRecord:<init>	(IIIII)V
    //   91: putfield 147	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mARecorder	Landroid/media/AudioRecord;
    //   94: aload_0
    //   95: getfield 147	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mARecorder	Landroid/media/AudioRecord;
    //   98: invokevirtual 150	android/media/AudioRecord:getState	()I
    //   101: iconst_1
    //   102: if_icmpeq +66 -> 168
    //   105: getstatic 117	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:TAG	Ljava/lang/String;
    //   108: ldc 152
    //   110: invokestatic 155	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   113: aload_0
    //   114: getfield 85	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
    //   117: iconst_1
    //   118: invokevirtual 159	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State:transfer	(I)V
    //   121: iconst_4
    //   122: ireturn
    //   123: astore_1
    //   124: getstatic 117	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:TAG	Ljava/lang/String;
    //   127: aload_1
    //   128: invokevirtual 162	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   131: invokestatic 155	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: aload_0
    //   135: getfield 85	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
    //   138: iconst_1
    //   139: invokevirtual 159	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State:transfer	(I)V
    //   142: iconst_2
    //   143: ireturn
    //   144: astore_1
    //   145: getstatic 117	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:TAG	Ljava/lang/String;
    //   148: ldc 164
    //   150: aload_1
    //   151: iconst_0
    //   152: anewarray 166	java/lang/Object
    //   155: invokestatic 169	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   158: aload_0
    //   159: getfield 85	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
    //   162: iconst_1
    //   163: invokevirtual 159	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State:transfer	(I)V
    //   166: iconst_3
    //   167: ireturn
    //   168: aload_0
    //   169: getfield 147	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mARecorder	Landroid/media/AudioRecord;
    //   172: invokevirtual 172	android/media/AudioRecord:getRecordingState	()I
    //   175: iconst_1
    //   176: if_icmpne +10 -> 186
    //   179: aload_0
    //   180: getfield 147	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mARecorder	Landroid/media/AudioRecord;
    //   183: invokevirtual 175	android/media/AudioRecord:startRecording	()V
    //   186: aload_0
    //   187: getfield 147	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mARecorder	Landroid/media/AudioRecord;
    //   190: invokevirtual 172	android/media/AudioRecord:getRecordingState	()I
    //   193: iconst_3
    //   194: if_icmpne +10 -> 204
    //   197: aload_0
    //   198: getfield 147	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mARecorder	Landroid/media/AudioRecord;
    //   201: invokevirtual 178	android/media/AudioRecord:stop	()V
    //   204: aload_0
    //   205: getfield 85	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
    //   208: iconst_4
    //   209: invokevirtual 159	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State:transfer	(I)V
    //   212: aload_0
    //   213: new 180	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$AsyncPcmWriterForKitKat
    //   216: dup
    //   217: aload_0
    //   218: aload_0
    //   219: getfield 182	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mPcmPath	Ljava/lang/String;
    //   222: getstatic 71	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:AUDIO_INPUT_BUFFER_SIZE	I
    //   225: invokespecial 185	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$AsyncPcmWriterForKitKat:<init>	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;Ljava/lang/String;I)V
    //   228: putfield 187	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mAsyncPcmWriter	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$AsyncPcmWriterForKitKat;
    //   231: aload_0
    //   232: new 189	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat
    //   235: dup
    //   236: aload_0
    //   237: new 119	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   244: ldc 191
    //   246: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: invokestatic 108	java/lang/System:currentTimeMillis	()J
    //   252: invokevirtual 194	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   255: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokespecial 197	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:<init>	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;Ljava/lang/String;)V
    //   261: putfield 199	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mRecThread	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat;
    //   264: aload_0
    //   265: getfield 199	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mRecThread	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat;
    //   268: invokevirtual 202	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:start	()V
    //   271: iconst_0
    //   272: ireturn
    //   273: astore_1
    //   274: getstatic 117	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:TAG	Ljava/lang/String;
    //   277: ldc 204
    //   279: aload_1
    //   280: iconst_0
    //   281: anewarray 166	java/lang/Object
    //   284: invokestatic 207	com/tencent/ttpic/baseutils/log/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   287: aload_0
    //   288: getfield 85	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
    //   291: iconst_1
    //   292: invokevirtual 159	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State:transfer	(I)V
    //   295: iconst_5
    //   296: ireturn
    //   297: astore_1
    //   298: getstatic 117	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:TAG	Ljava/lang/String;
    //   301: aload_1
    //   302: invokevirtual 208	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   305: invokestatic 155	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   308: aload_0
    //   309: getfield 85	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
    //   312: iconst_1
    //   313: invokevirtual 159	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State:transfer	(I)V
    //   316: iconst_1
    //   317: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	318	0	this	AudioRecorderAndChangerForKitKat
    //   123	5	1	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   144	7	1	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   273	7	1	localSecurityException	java.lang.SecurityException
    //   297	5	1	localFileNotFoundException	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   62	72	123	java/lang/OutOfMemoryError
    //   72	94	144	java/lang/IllegalArgumentException
    //   179	186	273	java/lang/SecurityException
    //   212	231	297	java/io/FileNotFoundException
  }
  
  public int init(int paramInt1, int paramInt2)
  {
    init();
    long l = System.currentTimeMillis();
    this.mVoiceChanger = new VoiceChanger(this.mPcmPath, AUDIO_SAMPLE_RATE_IN_HZ, paramInt1, paramInt2);
    this.needVoiceChange = true;
    LogUtils.d(TAG, "Audio Processers: start voice changer = " + (System.currentTimeMillis() - l));
    LogUtils.d(TAG, "init() - currentState = " + this.mCurrentState);
    return 0;
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
    if (this.mAsyncPcmWriter != null) {
      this.mAsyncPcmWriter.onRecord(paramArrayOfByte, paramInt);
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
  
  public void setOnErrorListener(OnErrorListener paramOnErrorListener)
  {
    this.mOnErrorListener = paramOnErrorListener;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.voicechanger.common.audio.AudioRecorderAndChangerForKitKat
 * JD-Core Version:    0.7.0.1
 */