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
  private static final String TAG = "AudioRecorder";
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
    //   1: getstatic 111	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_SAMPLE_RATE_IN_HZ	I
    //   4: bipush 16
    //   6: iconst_2
    //   7: invokestatic 117	android/media/AudioRecord:getMinBufferSize	(III)I
    //   10: putfield 61	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mBufSize	I
    //   13: getstatic 67	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:TAG	Ljava/lang/String;
    //   16: astore_1
    //   17: new 119	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   24: astore_2
    //   25: aload_2
    //   26: ldc 122
    //   28: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload_2
    //   33: aload_0
    //   34: getfield 61	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mBufSize	I
    //   37: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload_1
    //   42: aload_2
    //   43: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 138	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: aload_0
    //   50: getfield 61	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mBufSize	I
    //   53: getstatic 59	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_OUTPUT_BUFFER_SIZE	I
    //   56: if_icmpgt +10 -> 66
    //   59: aload_0
    //   60: getstatic 59	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_OUTPUT_BUFFER_SIZE	I
    //   63: putfield 61	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mBufSize	I
    //   66: aload_0
    //   67: aload_0
    //   68: getfield 61	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mBufSize	I
    //   71: newarray byte
    //   73: putfield 73	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mBuffer	[B
    //   76: aload_0
    //   77: new 113	android/media/AudioRecord
    //   80: dup
    //   81: iconst_1
    //   82: getstatic 111	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_SAMPLE_RATE_IN_HZ	I
    //   85: getstatic 141	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_CHANNEL_COUNT	I
    //   88: bipush 16
    //   90: imul
    //   91: iconst_2
    //   92: aload_0
    //   93: getfield 61	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mBufSize	I
    //   96: invokespecial 144	android/media/AudioRecord:<init>	(IIIII)V
    //   99: putfield 83	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mARecorder	Landroid/media/AudioRecord;
    //   102: aload_0
    //   103: getfield 83	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mARecorder	Landroid/media/AudioRecord;
    //   106: invokevirtual 147	android/media/AudioRecord:getState	()I
    //   109: iconst_1
    //   110: if_icmpeq +21 -> 131
    //   113: getstatic 67	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:TAG	Ljava/lang/String;
    //   116: ldc 149
    //   118: invokestatic 152	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   121: aload_0
    //   122: getfield 54	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
    //   125: iconst_0
    //   126: invokevirtual 156	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State:transfer	(I)V
    //   129: iconst_4
    //   130: ireturn
    //   131: aload_0
    //   132: getfield 83	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mARecorder	Landroid/media/AudioRecord;
    //   135: invokevirtual 159	android/media/AudioRecord:getRecordingState	()I
    //   138: iconst_1
    //   139: if_icmpne +37 -> 176
    //   142: aload_0
    //   143: getfield 83	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mARecorder	Landroid/media/AudioRecord;
    //   146: invokevirtual 162	android/media/AudioRecord:startRecording	()V
    //   149: goto +27 -> 176
    //   152: astore_1
    //   153: getstatic 67	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:TAG	Ljava/lang/String;
    //   156: ldc 164
    //   158: aload_1
    //   159: iconst_0
    //   160: anewarray 4	java/lang/Object
    //   163: invokestatic 168	com/tencent/ttpic/baseutils/log/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   166: aload_0
    //   167: getfield 54	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
    //   170: iconst_0
    //   171: invokevirtual 156	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State:transfer	(I)V
    //   174: iconst_5
    //   175: ireturn
    //   176: aload_0
    //   177: getfield 83	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mARecorder	Landroid/media/AudioRecord;
    //   180: invokevirtual 159	android/media/AudioRecord:getRecordingState	()I
    //   183: iconst_3
    //   184: if_icmpne +10 -> 194
    //   187: aload_0
    //   188: getfield 83	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mARecorder	Landroid/media/AudioRecord;
    //   191: invokevirtual 171	android/media/AudioRecord:stop	()V
    //   194: aload_0
    //   195: getfield 54	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
    //   198: iconst_2
    //   199: invokevirtual 156	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State:transfer	(I)V
    //   202: aload_0
    //   203: new 173	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$AsyncPcmWriter
    //   206: dup
    //   207: aload_0
    //   208: aload_0
    //   209: getfield 63	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mPcmPath	Ljava/lang/String;
    //   212: getstatic 176	com/tencent/ttpic/voicechanger/common/audio/AudioRecorderCompat:AUDIO_INPUT_BUFFER_SIZE	I
    //   215: invokespecial 179	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$AsyncPcmWriter:<init>	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;Ljava/lang/String;I)V
    //   218: putfield 181	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mAsyncPcmWriter	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$AsyncPcmWriter;
    //   221: new 119	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   228: astore_1
    //   229: aload_1
    //   230: ldc 183
    //   232: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload_1
    //   237: invokestatic 189	java/lang/System:currentTimeMillis	()J
    //   240: invokevirtual 192	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload_0
    //   245: new 194	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread
    //   248: dup
    //   249: aload_0
    //   250: aload_1
    //   251: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokespecial 197	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:<init>	(Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder;Ljava/lang/String;)V
    //   257: putfield 199	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mRecThread	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread;
    //   260: aload_0
    //   261: getfield 199	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mRecThread	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread;
    //   264: invokevirtual 202	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$SimpleRecordThread:start	()V
    //   267: iconst_0
    //   268: ireturn
    //   269: astore_1
    //   270: getstatic 67	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:TAG	Ljava/lang/String;
    //   273: aload_1
    //   274: invokevirtual 205	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   277: invokestatic 152	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   280: aload_0
    //   281: getfield 54	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
    //   284: iconst_0
    //   285: invokevirtual 156	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State:transfer	(I)V
    //   288: iconst_1
    //   289: ireturn
    //   290: astore_1
    //   291: getstatic 67	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:TAG	Ljava/lang/String;
    //   294: ldc 207
    //   296: aload_1
    //   297: iconst_0
    //   298: anewarray 4	java/lang/Object
    //   301: invokestatic 209	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   304: aload_0
    //   305: getfield 54	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
    //   308: iconst_0
    //   309: invokevirtual 156	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State:transfer	(I)V
    //   312: iconst_3
    //   313: ireturn
    //   314: astore_1
    //   315: getstatic 67	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:TAG	Ljava/lang/String;
    //   318: aload_1
    //   319: invokevirtual 210	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   322: invokestatic 152	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   325: aload_0
    //   326: getfield 54	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder:mCurrentState	Lcom/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State;
    //   329: iconst_0
    //   330: invokevirtual 156	com/tencent/ttpic/voicechanger/common/audio/AudioRecorder$State:transfer	(I)V
    //   333: iconst_2
    //   334: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	335	0	this	AudioRecorder
    //   16	26	1	str	String
    //   152	7	1	localSecurityException	java.lang.SecurityException
    //   228	23	1	localStringBuilder1	StringBuilder
    //   269	5	1	localFileNotFoundException	java.io.FileNotFoundException
    //   290	7	1	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   314	5	1	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   24	19	2	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   142	149	152	java/lang/SecurityException
    //   202	221	269	java/io/FileNotFoundException
    //   76	102	290	java/lang/IllegalArgumentException
    //   66	76	314	java/lang/OutOfMemoryError
  }
  
  public void onDelaySet(int paramInt) {}
  
  public void onRecordError(int paramInt)
  {
    OnErrorListener localOnErrorListener = this.mOnErrorListener;
    if (localOnErrorListener != null) {
      localOnErrorListener.onError(paramInt);
    }
  }
  
  public void onRecordStop()
  {
    AudioRecorder.AsyncPcmWriter localAsyncPcmWriter = this.mAsyncPcmWriter;
    if (localAsyncPcmWriter != null) {
      localAsyncPcmWriter.onStop();
    }
  }
  
  public void onRecording(byte[] paramArrayOfByte, int paramInt)
  {
    AudioRecorder.AsyncPcmWriter localAsyncPcmWriter = this.mAsyncPcmWriter;
    if (localAsyncPcmWriter != null) {
      localAsyncPcmWriter.onRecord(paramArrayOfByte, paramInt);
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
      if (this.mCurrentState.equalState(new int[] { 4, 2 }))
      {
        this.mCurrentState.transfer(8);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
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
      if (!this.mCurrentState.equalState(new int[] { 16 }))
      {
        LogUtils.i(TAG, "stop() is forgotten by someone, so call it now!");
        stop();
      }
      this.mCurrentState.transfer(1);
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
      if (this.mCurrentState.equalState(new int[] { 8, 2 }))
      {
        this.mCurrentState.transfer(4);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("current status is: ");
      localStringBuilder.append(this.mCurrentState);
      throw new IllegalStateException(localStringBuilder.toString());
    }
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
      ??? = this.mRecThread;
      if ((??? != null) && (!???.equals(Thread.currentThread())))
      {
        try
        {
          this.mRecThread.join();
        }
        catch (InterruptedException localInterruptedException)
        {
          LogUtils.e(TAG, localInterruptedException.getMessage());
        }
        this.mRecThread = null;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.voicechanger.common.audio.AudioRecorder
 * JD-Core Version:    0.7.0.1
 */