package com.tencent.ttpic.voicechanger.common.audio;

import android.media.AudioRecord;
import com.tencent.ttpic.baseutils.log.LogUtils;

@Deprecated
public class AudioRecorder
{
  public static final int ERROR_AUDIO_FILE_NOT_EXIST = 1;
  public static final int ERROR_AUDIO_ILLEGAL_ARGUMENT = 3;
  public static final int ERROR_AUDIO_INIT_AUDIORECORD_FAILED = 4;
  public static final int ERROR_AUDIO_OUT_OF_MEMORY = 2;
  public static final int ERROR_AUDIO_RECORD_READ_FAILED = 6;
  public static final int ERROR_AUDIO_RECORD_START_FAILED = 5;
  private static final String TAG = AudioRecorder.class.getSimpleName();
  private AudioRecord mARecorder;
  private AudioRecorder.AsyncPcmWriter mAsyncPcmWriter;
  private int mBufSize = AudioRecorderCompat.AUDIO_OUTPUT_BUFFER_SIZE;
  private byte[] mBuffer;
  private AudioRecorder.State mCurrentState = new AudioRecorder.State(this);
  private int mDelay;
  private boolean mHasDelaySet;
  private int mHasRecordLength;
  private OnErrorListener mOnErrorListener;
  private String mPcmPath;
  private AudioRecorder.SimpleRecordThread mRecThread;
  
  public AudioRecorder(String paramString)
  {
    this.mPcmPath = paramString;
  }
  
  public int getDelay()
  {
    return this.mDelay;
  }
  
  /* Error */
  public int init()
  {
    // Byte code:
    //   0: aload_0
    //   1: getstatic 114	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_SAMPLE_RATE_IN_HZ	I
    //   4: bipush 16
    //   6: iconst_2
    //   7: invokestatic 120	android/media/AudioRecord:getMinBufferSize	(III)I
    //   10: putfield 67	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mBufSize	I
    //   13: getstatic 48	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:TAG	Ljava/lang/String;
    //   16: new 122	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   23: ldc 125
    //   25: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_0
    //   29: getfield 67	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mBufSize	I
    //   32: invokevirtual 132	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   35: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 141	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: aload_0
    //   42: getfield 67	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mBufSize	I
    //   45: getstatic 65	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_OUTPUT_BUFFER_SIZE	I
    //   48: if_icmpgt +10 -> 58
    //   51: aload_0
    //   52: getstatic 65	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_OUTPUT_BUFFER_SIZE	I
    //   55: putfield 67	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mBufSize	I
    //   58: aload_0
    //   59: aload_0
    //   60: getfield 67	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mBufSize	I
    //   63: newarray byte
    //   65: putfield 76	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mBuffer	[B
    //   68: aload_0
    //   69: new 116	android/media/AudioRecord
    //   72: dup
    //   73: iconst_1
    //   74: getstatic 114	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_SAMPLE_RATE_IN_HZ	I
    //   77: getstatic 144	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_CHANNEL_COUNT	I
    //   80: bipush 16
    //   82: imul
    //   83: iconst_2
    //   84: aload_0
    //   85: getfield 67	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mBufSize	I
    //   88: invokespecial 147	android/media/AudioRecord:<init>	(IIIII)V
    //   91: putfield 86	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mARecorder	Landroid/media/AudioRecord;
    //   94: aload_0
    //   95: getfield 86	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mARecorder	Landroid/media/AudioRecord;
    //   98: invokevirtual 150	android/media/AudioRecord:getState	()I
    //   101: iconst_1
    //   102: if_icmpeq +66 -> 168
    //   105: getstatic 48	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:TAG	Ljava/lang/String;
    //   108: ldc 152
    //   110: invokestatic 155	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   113: aload_0
    //   114: getfield 60	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
    //   117: iconst_0
    //   118: invokevirtual 159	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State:transfer	(I)V
    //   121: iconst_4
    //   122: ireturn
    //   123: astore_1
    //   124: getstatic 48	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:TAG	Ljava/lang/String;
    //   127: aload_1
    //   128: invokevirtual 162	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   131: invokestatic 155	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: aload_0
    //   135: getfield 60	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
    //   138: iconst_0
    //   139: invokevirtual 159	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State:transfer	(I)V
    //   142: iconst_2
    //   143: ireturn
    //   144: astore_1
    //   145: getstatic 48	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:TAG	Ljava/lang/String;
    //   148: ldc 164
    //   150: aload_1
    //   151: iconst_0
    //   152: anewarray 4	java/lang/Object
    //   155: invokestatic 167	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   158: aload_0
    //   159: getfield 60	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
    //   162: iconst_0
    //   163: invokevirtual 159	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State:transfer	(I)V
    //   166: iconst_3
    //   167: ireturn
    //   168: aload_0
    //   169: getfield 86	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mARecorder	Landroid/media/AudioRecord;
    //   172: invokevirtual 170	android/media/AudioRecord:getRecordingState	()I
    //   175: iconst_1
    //   176: if_icmpne +10 -> 186
    //   179: aload_0
    //   180: getfield 86	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mARecorder	Landroid/media/AudioRecord;
    //   183: invokevirtual 173	android/media/AudioRecord:startRecording	()V
    //   186: aload_0
    //   187: getfield 86	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mARecorder	Landroid/media/AudioRecord;
    //   190: invokevirtual 170	android/media/AudioRecord:getRecordingState	()I
    //   193: iconst_3
    //   194: if_icmpne +10 -> 204
    //   197: aload_0
    //   198: getfield 86	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mARecorder	Landroid/media/AudioRecord;
    //   201: invokevirtual 176	android/media/AudioRecord:stop	()V
    //   204: aload_0
    //   205: getfield 60	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
    //   208: iconst_2
    //   209: invokevirtual 159	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State:transfer	(I)V
    //   212: aload_0
    //   213: new 178	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$AsyncPcmWriter
    //   216: dup
    //   217: aload_0
    //   218: aload_0
    //   219: getfield 69	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mPcmPath	Ljava/lang/String;
    //   222: getstatic 181	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_INPUT_BUFFER_SIZE	I
    //   225: invokespecial 184	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$AsyncPcmWriter:<init>	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;Ljava/lang/String;I)V
    //   228: putfield 186	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mAsyncPcmWriter	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$AsyncPcmWriter;
    //   231: aload_0
    //   232: new 188	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread
    //   235: dup
    //   236: aload_0
    //   237: new 122	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   244: ldc 190
    //   246: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: invokestatic 196	java/lang/System:currentTimeMillis	()J
    //   252: invokevirtual 199	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   255: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokespecial 202	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:<init>	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;Ljava/lang/String;)V
    //   261: putfield 204	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mRecThread	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread;
    //   264: aload_0
    //   265: getfield 204	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mRecThread	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread;
    //   268: invokevirtual 207	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:start	()V
    //   271: iconst_0
    //   272: ireturn
    //   273: astore_1
    //   274: getstatic 48	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:TAG	Ljava/lang/String;
    //   277: ldc 209
    //   279: aload_1
    //   280: iconst_0
    //   281: anewarray 4	java/lang/Object
    //   284: invokestatic 212	com/tencent/ttpic/baseutils/log/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   287: aload_0
    //   288: getfield 60	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
    //   291: iconst_0
    //   292: invokevirtual 159	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State:transfer	(I)V
    //   295: iconst_5
    //   296: ireturn
    //   297: astore_1
    //   298: getstatic 48	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:TAG	Ljava/lang/String;
    //   301: aload_1
    //   302: invokevirtual 213	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   305: invokestatic 155	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   308: aload_0
    //   309: getfield 60	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
    //   312: iconst_0
    //   313: invokevirtual 159	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State:transfer	(I)V
    //   316: iconst_1
    //   317: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	318	0	this	AudioRecorder
    //   123	5	1	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   144	7	1	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   273	7	1	localSecurityException	java.lang.SecurityException
    //   297	5	1	localFileNotFoundException	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   58	68	123	java/lang/OutOfMemoryError
    //   68	94	144	java/lang/IllegalArgumentException
    //   179	186	273	java/lang/SecurityException
    //   212	231	297	java/io/FileNotFoundException
  }
  
  public void onDelaySet(int paramInt) {}
  
  public void onRecordError(int paramInt)
  {
    if (this.mOnErrorListener != null) {
      this.mOnErrorListener.onError(paramInt);
    }
  }
  
  public void onRecordStop()
  {
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
    LogUtils.d(TAG, "pause");
    synchronized (this.mCurrentState)
    {
      if (this.mCurrentState.equalState(new int[] { 8 }))
      {
        LogUtils.d(TAG, "current state has been 8");
        return;
      }
      if (!this.mCurrentState.equalState(new int[] { 4, 2 })) {
        throw new IllegalStateException("current status is: " + this.mCurrentState);
      }
    }
    this.mCurrentState.transfer(8);
  }
  
  public void release()
  {
    LogUtils.d(TAG, "release start");
    synchronized (this.mCurrentState)
    {
      if (!this.mCurrentState.equalState(new int[] { 16 }))
      {
        LogUtils.i(TAG, "stop() is forgotten by someone, so call it now!");
        stop();
      }
      this.mCurrentState.transfer(1);
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
    LogUtils.d(TAG, "resume, delegate to start");
    start();
  }
  
  public void setOnErrorListener(OnErrorListener paramOnErrorListener)
  {
    this.mOnErrorListener = paramOnErrorListener;
  }
  
  public void start()
  {
    LogUtils.d(TAG, "start");
    synchronized (this.mCurrentState)
    {
      if (this.mCurrentState.equalState(new int[] { 4 }))
      {
        LogUtils.w(TAG, "current state has been 4");
        return;
      }
      if (!this.mCurrentState.equalState(new int[] { 8, 2 })) {
        throw new IllegalStateException("current status is: " + this.mCurrentState);
      }
    }
    this.mCurrentState.transfer(4);
  }
  
  public void stop()
  {
    LogUtils.d(TAG, "stop");
    synchronized (this.mCurrentState)
    {
      if (this.mCurrentState.equalState(new int[] { 16 }))
      {
        LogUtils.d(TAG, "current state has been 16");
        return;
      }
      this.mCurrentState.transfer(16);
      if ((this.mRecThread == null) || (this.mRecThread.equals(Thread.currentThread()))) {
        return;
      }
    }
    try
    {
      this.mRecThread.join();
      this.mRecThread = null;
      return;
      localObject = finally;
      throw localObject;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        LogUtils.e(TAG, localInterruptedException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.voicechanger.common.audio.AudioRecorder
 * JD-Core Version:    0.7.0.1
 */