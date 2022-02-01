package com.tencent.ttpic.voicechanger.common.audio;

import android.media.AudioRecord;
import com.tencent.ttpic.baseutils.log.LogUtils;

@Deprecated
public class AudioRecorderAndChangerForKitKat
  extends AudioRecorderCompat
{
  public static final int AUDIO_BIT_RATE;
  public static final int AUDIO_CHANNEL_COUNT = 1;
  public static final int AUDIO_INPUT_BUFFER_SIZE;
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
    AUDIO_BIT_RATE = BIT_RATES[1];
    double d = AUDIO_SAMPLE_RATE_IN_HZ;
    Double.isNaN(d);
    AUDIO_INPUT_BUFFER_SIZE = (int)(d * 0.02D * 1.0D * 4.0D);
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
    //   0: invokestatic 114	java/lang/System:currentTimeMillis	()J
    //   3: pop2
    //   4: aload_0
    //   5: getstatic 63	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:AUDIO_SAMPLE_RATE_IN_HZ	I
    //   8: bipush 16
    //   10: iconst_2
    //   11: invokestatic 120	android/media/AudioRecord:getMinBufferSize	(III)I
    //   14: putfield 93	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mBufSize	I
    //   17: getstatic 123	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:TAG	Ljava/lang/String;
    //   20: astore_3
    //   21: new 125	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   28: astore 4
    //   30: aload 4
    //   32: ldc 129
    //   34: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload 4
    //   40: aload_0
    //   41: getfield 93	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mBufSize	I
    //   44: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_3
    //   49: aload 4
    //   51: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 146	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: aload_0
    //   58: getfield 93	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mBufSize	I
    //   61: istore_1
    //   62: getstatic 79	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:AUDIO_OUTPUT_BUFFER_SIZE	I
    //   65: istore_2
    //   66: iload_1
    //   67: iload_2
    //   68: if_icmpgt +8 -> 76
    //   71: aload_0
    //   72: iload_2
    //   73: putfield 93	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mBufSize	I
    //   76: aload_0
    //   77: aload_0
    //   78: getfield 93	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mBufSize	I
    //   81: newarray byte
    //   83: putfield 148	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mBuffer	[B
    //   86: aload_0
    //   87: new 116	android/media/AudioRecord
    //   90: dup
    //   91: iconst_1
    //   92: getstatic 63	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:AUDIO_SAMPLE_RATE_IN_HZ	I
    //   95: bipush 16
    //   97: iconst_2
    //   98: aload_0
    //   99: getfield 93	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mBufSize	I
    //   102: invokespecial 151	android/media/AudioRecord:<init>	(IIIII)V
    //   105: putfield 153	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mARecorder	Landroid/media/AudioRecord;
    //   108: aload_0
    //   109: getfield 153	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mARecorder	Landroid/media/AudioRecord;
    //   112: invokevirtual 156	android/media/AudioRecord:getState	()I
    //   115: iconst_1
    //   116: if_icmpeq +21 -> 137
    //   119: getstatic 123	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:TAG	Ljava/lang/String;
    //   122: ldc 158
    //   124: invokestatic 161	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   127: aload_0
    //   128: getfield 91	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
    //   131: iconst_1
    //   132: invokevirtual 165	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State:transfer	(I)V
    //   135: iconst_4
    //   136: ireturn
    //   137: aload_0
    //   138: getfield 153	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mARecorder	Landroid/media/AudioRecord;
    //   141: invokevirtual 168	android/media/AudioRecord:getRecordingState	()I
    //   144: iconst_1
    //   145: if_icmpne +37 -> 182
    //   148: aload_0
    //   149: getfield 153	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mARecorder	Landroid/media/AudioRecord;
    //   152: invokevirtual 171	android/media/AudioRecord:startRecording	()V
    //   155: goto +27 -> 182
    //   158: astore_3
    //   159: getstatic 123	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:TAG	Ljava/lang/String;
    //   162: ldc 173
    //   164: aload_3
    //   165: iconst_0
    //   166: anewarray 175	java/lang/Object
    //   169: invokestatic 179	com/tencent/ttpic/baseutils/log/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   172: aload_0
    //   173: getfield 91	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
    //   176: iconst_1
    //   177: invokevirtual 165	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State:transfer	(I)V
    //   180: iconst_5
    //   181: ireturn
    //   182: aload_0
    //   183: getfield 153	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mARecorder	Landroid/media/AudioRecord;
    //   186: invokevirtual 168	android/media/AudioRecord:getRecordingState	()I
    //   189: iconst_3
    //   190: if_icmpne +10 -> 200
    //   193: aload_0
    //   194: getfield 153	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mARecorder	Landroid/media/AudioRecord;
    //   197: invokevirtual 182	android/media/AudioRecord:stop	()V
    //   200: aload_0
    //   201: getfield 91	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
    //   204: iconst_4
    //   205: invokevirtual 165	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State:transfer	(I)V
    //   208: aload_0
    //   209: new 184	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$AsyncPcmWriterForKitKat
    //   212: dup
    //   213: aload_0
    //   214: aload_0
    //   215: getfield 186	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mPcmPath	Ljava/lang/String;
    //   218: getstatic 77	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:AUDIO_INPUT_BUFFER_SIZE	I
    //   221: invokespecial 189	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$AsyncPcmWriterForKitKat:<init>	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;Ljava/lang/String;I)V
    //   224: putfield 191	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mAsyncPcmWriter	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$AsyncPcmWriterForKitKat;
    //   227: new 125	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   234: astore_3
    //   235: aload_3
    //   236: ldc 193
    //   238: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload_3
    //   243: invokestatic 114	java/lang/System:currentTimeMillis	()J
    //   246: invokevirtual 196	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload_0
    //   251: new 198	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat
    //   254: dup
    //   255: aload_0
    //   256: aload_3
    //   257: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokespecial 201	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:<init>	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat;Ljava/lang/String;)V
    //   263: putfield 203	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mRecThread	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat;
    //   266: aload_0
    //   267: getfield 203	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mRecThread	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat;
    //   270: invokevirtual 206	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$SimpleRecordThreadForKitKat:start	()V
    //   273: iconst_0
    //   274: ireturn
    //   275: astore_3
    //   276: getstatic 123	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:TAG	Ljava/lang/String;
    //   279: aload_3
    //   280: invokevirtual 209	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   283: invokestatic 161	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   286: aload_0
    //   287: getfield 91	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
    //   290: iconst_1
    //   291: invokevirtual 165	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State:transfer	(I)V
    //   294: iconst_1
    //   295: ireturn
    //   296: astore_3
    //   297: getstatic 123	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:TAG	Ljava/lang/String;
    //   300: ldc 211
    //   302: aload_3
    //   303: iconst_0
    //   304: anewarray 175	java/lang/Object
    //   307: invokestatic 213	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   310: aload_0
    //   311: getfield 91	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
    //   314: iconst_1
    //   315: invokevirtual 165	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State:transfer	(I)V
    //   318: iconst_3
    //   319: ireturn
    //   320: astore_3
    //   321: getstatic 123	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:TAG	Ljava/lang/String;
    //   324: aload_3
    //   325: invokevirtual 214	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   328: invokestatic 161	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   331: aload_0
    //   332: getfield 91	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State;
    //   335: iconst_1
    //   336: invokevirtual 165	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderAndChangerForKitKat$State:transfer	(I)V
    //   339: iconst_2
    //   340: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	341	0	this	AudioRecorderAndChangerForKitKat
    //   61	8	1	i	int
    //   65	8	2	j	int
    //   20	29	3	str	String
    //   158	7	3	localSecurityException	java.lang.SecurityException
    //   234	23	3	localStringBuilder1	StringBuilder
    //   275	5	3	localFileNotFoundException	java.io.FileNotFoundException
    //   296	7	3	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   320	5	3	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   28	22	4	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   148	155	158	java/lang/SecurityException
    //   208	227	275	java/io/FileNotFoundException
    //   86	108	296	java/lang/IllegalArgumentException
    //   76	86	320	java/lang/OutOfMemoryError
  }
  
  public int init(int paramInt1, int paramInt2)
  {
    init();
    long l = System.currentTimeMillis();
    this.mVoiceChanger = new VoiceChanger(this.mPcmPath, AUDIO_SAMPLE_RATE_IN_HZ, paramInt1, paramInt2);
    this.needVoiceChange = true;
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Audio Processers: start voice changer = ");
    localStringBuilder.append(System.currentTimeMillis() - l);
    LogUtils.d(str, localStringBuilder.toString());
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("init() - currentState = ");
    localStringBuilder.append(this.mCurrentState);
    LogUtils.d(str, localStringBuilder.toString());
    return 0;
  }
  
  public void onDelaySet(int paramInt) {}
  
  public void onRecordError(int paramInt)
  {
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRecordError() - currentState = ");
    localStringBuilder.append(this.mCurrentState);
    LogUtils.e((String)localObject, localStringBuilder.toString());
    localObject = this.mOnErrorListener;
    if (localObject != null) {
      ((OnErrorListener)localObject).onError(paramInt);
    }
  }
  
  public void onRecordStop()
  {
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRecordStop() - currentState = ");
    localStringBuilder.append(this.mCurrentState);
    LogUtils.d((String)localObject, localStringBuilder.toString());
    localObject = this.mAsyncPcmWriter;
    if (localObject != null) {
      ((AudioRecorderAndChangerForKitKat.AsyncPcmWriterForKitKat)localObject).onStop();
    }
  }
  
  public void onRecording(byte[] paramArrayOfByte, int paramInt)
  {
    AudioRecorderAndChangerForKitKat.AsyncPcmWriterForKitKat localAsyncPcmWriterForKitKat = this.mAsyncPcmWriter;
    if (localAsyncPcmWriterForKitKat != null) {
      localAsyncPcmWriterForKitKat.onRecord(paramArrayOfByte, paramInt);
    }
  }
  
  public void pause()
  {
    ??? = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pause() - currentState = ");
    localStringBuilder.append(this.mCurrentState);
    LogUtils.d((String)???, localStringBuilder.toString());
    synchronized (this.mCurrentState)
    {
      if (this.mCurrentState.equalState(new int[] { 16 }))
      {
        LogUtils.d(TAG, "current state has been 16");
        return;
      }
      if (this.mCurrentState.equalState(new int[] { 8, 4 }))
      {
        this.mCurrentState.transfer(16);
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("current status is: ");
      localStringBuilder.append(this.mCurrentState);
      throw new IllegalStateException(localStringBuilder.toString());
    }
  }
  
  public void release()
  {
    LogUtils.d(TAG, "release start");
    AudioRecord localAudioRecord;
    synchronized (this.mCurrentState)
    {
      if (!this.mCurrentState.equalState(new int[] { 32 }))
      {
        LogUtils.i(TAG, "stop() is forgotten by someone, so call it now!");
        stop(null);
      }
      this.mCurrentState.transfer(2);
      this.mHasRecordLength = 0;
      ??? = this.mRecThread;
      if ((??? != null) && (!???.equals(Thread.currentThread()))) {
        try
        {
          this.mRecThread.join();
        }
        catch (InterruptedException localInterruptedException)
        {
          LogUtils.e(TAG, localInterruptedException.getMessage());
          this.mRecThread = null;
        }
      }
      localAudioRecord = this.mARecorder;
      if (localAudioRecord != null) {
        localAudioRecord.release();
      }
      LogUtils.d(TAG, "AduioRecord release finish");
      this.mHasRecordLength = 0;
      LogUtils.d(TAG, "release finish");
      return;
    }
  }
  
  public void resume()
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resume() - currentState = ");
    localStringBuilder.append(this.mCurrentState);
    LogUtils.d(str, localStringBuilder.toString());
    start();
  }
  
  public void setOnErrorListener(OnErrorListener paramOnErrorListener)
  {
    this.mOnErrorListener = paramOnErrorListener;
  }
  
  public void start()
  {
    ??? = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start() - currentState = ");
    localStringBuilder.append(this.mCurrentState);
    LogUtils.d((String)???, localStringBuilder.toString());
    synchronized (this.mCurrentState)
    {
      if (this.mCurrentState.equalState(new int[] { 8 }))
      {
        LogUtils.w(TAG, "current state has been 8");
        return;
      }
      if (this.mCurrentState.equalState(new int[] { 16, 4 }))
      {
        this.mCurrentState.transfer(8);
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("current status is: ");
      localStringBuilder.append(this.mCurrentState);
      throw new IllegalStateException(localStringBuilder.toString());
    }
  }
  
  public void stop(AudioRecorderCompat.AudioListener paramAudioListener)
  {
    ??? = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stop() - currentState = ");
    localStringBuilder.append(this.mCurrentState);
    LogUtils.d((String)???, localStringBuilder.toString());
    synchronized (this.mCurrentState)
    {
      if (this.mCurrentState.equalState(new int[] { 32 }))
      {
        LogUtils.d(TAG, "current state has been 32");
        return;
      }
      this.mCurrentState.transfer(32);
      ??? = this.mRecThread;
      if ((??? != null) && (!???.equals(Thread.currentThread())))
      {
        this.mListener = paramAudioListener;
        try
        {
          this.mRecThread.join();
          paramAudioListener = TAG;
          ??? = new StringBuilder();
          ((StringBuilder)???).append("stop() - join() - currentState = ");
          ((StringBuilder)???).append(this.mCurrentState);
          LogUtils.d(paramAudioListener, ((StringBuilder)???).toString());
        }
        catch (InterruptedException paramAudioListener)
        {
          LogUtils.e(TAG, paramAudioListener.getMessage());
        }
        this.mRecThread = null;
      }
      return;
    }
  }
  
  protected void tryReleaseChanger()
  {
    VoiceChanger localVoiceChanger = this.mVoiceChanger;
    if (localVoiceChanger != null) {
      localVoiceChanger.release();
    }
  }
  
  protected void tryReleasePacker()
  {
    RealTimePcmPacker localRealTimePcmPacker = this.mPcmPacker;
    if (localRealTimePcmPacker != null) {
      localRealTimePcmPacker.stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.voicechanger.common.audio.AudioRecorderAndChangerForKitKat
 * JD-Core Version:    0.7.0.1
 */