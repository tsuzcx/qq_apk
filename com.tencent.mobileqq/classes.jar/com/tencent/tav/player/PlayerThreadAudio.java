package com.tencent.tav.player;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v4.util.SparseArrayCompat;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.tav.core.AudioCompositionDecoderTrack;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.logger.Logger;
import java.nio.ByteBuffer;

public class PlayerThreadAudio
  implements Handler.Callback
{
  private static final String TAG = "PlayerThreadAudio";
  private AudioCompositionDecoderTrack audioDecoderTrack;
  public volatile CMSampleState currentPlayingState = new CMSampleState();
  public volatile long lastSyncMessgeId = -1L;
  private AudioTrackWrapper mAudioTrack;
  private boolean mLooper;
  private Handler mMainHandler;
  private Handler mPlayHandler;
  private int mStatus = 1;
  private HandlerThread mThread;
  private Handler mVideoHandler;
  private float rate = 1.0F;
  private float volume = 1.0F;
  
  public PlayerThreadAudio(AudioCompositionDecoderTrack paramAudioCompositionDecoderTrack, Handler paramHandler1, Handler paramHandler2)
  {
    this.audioDecoderTrack = paramAudioCompositionDecoderTrack;
    this.mMainHandler = paramHandler1;
    this.mVideoHandler = paramHandler2;
    initThread();
  }
  
  private void actionPrepare()
  {
    if (this.audioDecoderTrack != null)
    {
      int i = this.mStatus;
      updateStatus(2);
      releaseAudioTrack();
    }
  }
  
  private String catLog(int paramInt)
  {
    return (String)PlayerThread.map.get(paramInt);
  }
  
  private void initThread()
  {
    this.mThread = new HandlerThread("PlayerAudioThread");
    this.mThread.start();
    this.mPlayHandler = new Handler(this.mThread.getLooper(), this);
  }
  
  private void pause()
  {
    if (this.mStatus == 2)
    {
      this.mLooper = false;
      this.currentPlayingState = new CMSampleState();
      removePendingMessage(new int[] { 12 });
    }
  }
  
  private void play(Object paramObject)
  {
    if (this.mStatus == 1) {
      return;
    }
    this.mLooper = true;
    if (((paramObject instanceof CMTime)) && (Math.abs(((CMTime)paramObject).getTimeUs() - this.currentPlayingState.getTime().getTimeUs()) > 100000L)) {
      seekTo(paramObject);
    }
    if (this.mStatus == 3) {
      updateStatus(2);
    }
    sendMessage(12, "play", System.currentTimeMillis());
  }
  
  private void playerFinish()
  {
    this.currentPlayingState = new CMSampleState();
    this.audioDecoderTrack.seekTo(CMTime.CMTimeZero, false, true);
    this.mLooper = false;
    updateStatus(3);
    removePendingMessage(new int[] { 12 });
  }
  
  private void readSample()
  {
    Object localObject5 = null;
    if ((this.audioDecoderTrack == null) || (!this.mLooper)) {
      return;
    }
    this.audioDecoderTrack.setRate(this.rate);
    Object localObject2 = CMSampleState.fromError(-2L);
    v("PlayerThreadAudio", "readSample start");
    for (;;)
    {
      try
      {
        localObject1 = this.audioDecoderTrack.readSample();
        CMSampleState localCMSampleState;
        Logger.e("PlayerThreadAudio", "java.lang.IllegalStateException: buffer was freed", localException2);
      }
      catch (Exception localException2)
      {
        try
        {
          localCMSampleState = ((CMSampleBuffer)localObject1).getState();
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            ByteBuffer localByteBuffer;
            byte[] arrayOfByte;
            localObject4 = localException1;
            localObject3 = localObject1;
            localObject1 = localObject4;
            localObject4 = localException3;
          }
        }
        try
        {
          v("PlayerThreadAudio", "readSample finish " + localCMSampleState);
          localObject2 = localObject1;
          v("PlayerThreadAudio", "processFrame() called sampleState--> " + localCMSampleState);
          if (this.mAudioTrack == null)
          {
            v("PlayerThreadAudio", "processFrame() called new mediaFormat");
            this.mAudioTrack = new AudioTrackWrapper(44100, 1);
            this.mAudioTrack.setVolume(this.volume);
          }
          if ((!localCMSampleState.stateMatchingTo(new long[] { -1L, -3L, -100L })) && (!localCMSampleState.getTime().bigThan(this.audioDecoderTrack.getDuration()))) {
            break;
          }
          v("PlayerThreadAudio", "processFrame() called end of stream");
          playerFinish();
          this.currentPlayingState = localCMSampleState;
          return;
        }
        catch (Exception localException4)
        {
          localObject3 = localObject1;
          localObject1 = localObject4;
          localObject4 = localException4;
          break label217;
          localObject1 = null;
          break label339;
        }
        localException2 = localException2;
        localObject1 = localObject2;
        localObject2 = null;
      }
      label217:
      localObject4 = localObject1;
    }
    if ((((CMSampleState)localObject4).getStateCode() >= 0L) && (localObject2 != null)) {
      localObject1 = localObject5;
    }
    try
    {
      localByteBuffer = ((CMSampleBuffer)localObject2).getSampleByteBuffer();
      if (localByteBuffer == null) {
        break label507;
      }
      localObject1 = localObject5;
      localByteBuffer.position(0);
      localObject1 = localObject5;
      arrayOfByte = new byte[localByteBuffer.limit()];
      localObject1 = arrayOfByte;
      Logger.v("PlayerThreadAudio", "read sample thread: " + Thread.currentThread().getId() + " " + ((CMSampleBuffer)localObject2).getTime());
      localObject1 = arrayOfByte;
      localByteBuffer.get(arrayOfByte);
      localObject1 = arrayOfByte;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        label339:
        Logger.e("PlayerThreadAudio", "readSample: ", localException1);
        continue;
        v("PlayerThreadAudio", "processFrame() called run audioData length exception");
      }
      v("PlayerThreadAudio", "processFrame() not run looper");
      return;
    }
    if (localObject1 != null)
    {
      v("PlayerThreadAudio", "processFrame() called run audioData length audioData--" + localObject1.length);
      this.audioDecoderTrack.asyncReadNextSample(CMTime.CMTimeInvalid);
      this.mAudioTrack.writeData((byte[])localObject1, 0, localObject1.length);
      this.currentPlayingState = ((CMSampleState)localObject4);
      if ((!this.mLooper) || (this.rate <= 0.0F)) {
        break label471;
      }
      v("PlayerThreadAudio", "processFrame() called run looper " + this.currentPlayingState);
      scheduleNextWork();
    }
  }
  
  /* Error */
  private void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 69	com/tencent/tav/player/PlayerThreadAudio:releaseAudioTrack	()V
    //   4: aload_0
    //   5: iconst_0
    //   6: newarray int
    //   8: invokespecial 115	com/tencent/tav/player/PlayerThreadAudio:removePendingMessage	([I)V
    //   11: aload_0
    //   12: iconst_1
    //   13: invokespecial 66	com/tencent/tav/player/PlayerThreadAudio:updateStatus	(I)V
    //   16: ldc 10
    //   18: new 188	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   25: ldc_w 312
    //   28: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_0
    //   32: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 317	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   41: pop
    //   42: aload_0
    //   43: getfield 94	com/tencent/tav/player/PlayerThreadAudio:mThread	Landroid/os/HandlerThread;
    //   46: invokevirtual 321	android/os/HandlerThread:quit	()Z
    //   49: pop
    //   50: aload_0
    //   51: aconst_null
    //   52: putfield 94	com/tencent/tav/player/PlayerThreadAudio:mThread	Landroid/os/HandlerThread;
    //   55: aload_0
    //   56: getfield 57	com/tencent/tav/player/PlayerThreadAudio:mVideoHandler	Landroid/os/Handler;
    //   59: astore_1
    //   60: aload_1
    //   61: monitorenter
    //   62: aload_0
    //   63: getfield 57	com/tencent/tav/player/PlayerThreadAudio:mVideoHandler	Landroid/os/Handler;
    //   66: sipush 850
    //   69: invokevirtual 325	android/os/Handler:sendEmptyMessage	(I)Z
    //   72: pop
    //   73: aload_1
    //   74: monitorexit
    //   75: aload_0
    //   76: aconst_null
    //   77: putfield 108	com/tencent/tav/player/PlayerThreadAudio:mPlayHandler	Landroid/os/Handler;
    //   80: aload_0
    //   81: aconst_null
    //   82: putfield 57	com/tencent/tav/player/PlayerThreadAudio:mVideoHandler	Landroid/os/Handler;
    //   85: return
    //   86: astore_2
    //   87: aload_1
    //   88: monitorexit
    //   89: aload_2
    //   90: athrow
    //   91: astore_1
    //   92: ldc 10
    //   94: ldc_w 327
    //   97: aload_1
    //   98: invokestatic 244	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   101: aload_0
    //   102: getfield 57	com/tencent/tav/player/PlayerThreadAudio:mVideoHandler	Landroid/os/Handler;
    //   105: astore_1
    //   106: aload_1
    //   107: monitorenter
    //   108: aload_0
    //   109: getfield 57	com/tencent/tav/player/PlayerThreadAudio:mVideoHandler	Landroid/os/Handler;
    //   112: sipush 850
    //   115: invokevirtual 325	android/os/Handler:sendEmptyMessage	(I)Z
    //   118: pop
    //   119: aload_1
    //   120: monitorexit
    //   121: aload_0
    //   122: aconst_null
    //   123: putfield 108	com/tencent/tav/player/PlayerThreadAudio:mPlayHandler	Landroid/os/Handler;
    //   126: aload_0
    //   127: aconst_null
    //   128: putfield 57	com/tencent/tav/player/PlayerThreadAudio:mVideoHandler	Landroid/os/Handler;
    //   131: return
    //   132: astore_2
    //   133: aload_1
    //   134: monitorexit
    //   135: aload_2
    //   136: athrow
    //   137: astore_2
    //   138: aload_0
    //   139: getfield 57	com/tencent/tav/player/PlayerThreadAudio:mVideoHandler	Landroid/os/Handler;
    //   142: astore_1
    //   143: aload_1
    //   144: monitorenter
    //   145: aload_0
    //   146: getfield 57	com/tencent/tav/player/PlayerThreadAudio:mVideoHandler	Landroid/os/Handler;
    //   149: sipush 850
    //   152: invokevirtual 325	android/os/Handler:sendEmptyMessage	(I)Z
    //   155: pop
    //   156: aload_1
    //   157: monitorexit
    //   158: aload_0
    //   159: aconst_null
    //   160: putfield 108	com/tencent/tav/player/PlayerThreadAudio:mPlayHandler	Landroid/os/Handler;
    //   163: aload_0
    //   164: aconst_null
    //   165: putfield 57	com/tencent/tav/player/PlayerThreadAudio:mVideoHandler	Landroid/os/Handler;
    //   168: aload_2
    //   169: athrow
    //   170: astore_2
    //   171: aload_1
    //   172: monitorexit
    //   173: aload_2
    //   174: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	PlayerThreadAudio
    //   91	7	1	localException	Exception
    //   86	4	2	localObject1	Object
    //   132	4	2	localObject2	Object
    //   137	32	2	localObject3	Object
    //   170	4	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   62	75	86	finally
    //   87	89	86	finally
    //   16	55	91	java/lang/Exception
    //   108	121	132	finally
    //   133	135	132	finally
    //   16	55	137	finally
    //   92	101	137	finally
    //   145	158	170	finally
    //   171	173	170	finally
  }
  
  private void releaseAudioTrack()
  {
    if (this.mAudioTrack != null)
    {
      this.mAudioTrack.stop();
      this.mAudioTrack.release();
      this.mAudioTrack = null;
    }
  }
  
  private void removePendingMessage(int... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      this.mPlayHandler.removeCallbacksAndMessages(null);
    }
    for (;;)
    {
      return;
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        int k = paramVarArgs[i];
        this.mPlayHandler.removeMessages(k);
        i += 1;
      }
    }
  }
  
  private void scheduleNextWork()
  {
    sendMessage(12, "schedule next", System.currentTimeMillis());
  }
  
  private void seekTo(Object paramObject)
  {
    if ((paramObject instanceof PlayerMessage)) {
      paramObject = ((PlayerMessage)paramObject).bizMsg1;
    }
    for (;;)
    {
      if ((paramObject instanceof CMTime))
      {
        this.currentPlayingState = new CMSampleState((CMTime)paramObject);
        this.audioDecoderTrack.seekTo((CMTime)paramObject, false, true);
      }
      if (this.mAudioTrack != null) {
        this.mAudioTrack.flush();
      }
      return;
    }
  }
  
  private void setVolume(Object paramObject)
  {
    float f;
    if ((paramObject instanceof PlayerMessage)) {
      f = ((Float)((PlayerMessage)paramObject).bizMsg1).floatValue();
    }
    for (;;)
    {
      if ((f >= 0.0F) && (f <= 1.0F)) {
        setVolumeToAudioTrack(f);
      }
      return;
      if ((paramObject instanceof Float)) {
        f = ((Float)paramObject).floatValue();
      } else {
        f = 1.0F;
      }
    }
  }
  
  private void setVolumeToAudioTrack(float paramFloat)
  {
    this.volume = paramFloat;
    if (this.mAudioTrack != null) {
      this.mAudioTrack.setVolume(paramFloat);
    }
  }
  
  private void stop(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      removePendingMessage(new int[] { 12 });
      this.mLooper = false;
      this.currentPlayingState = new CMSampleState();
    }
    updateStatus(1);
    releaseAudioTrack();
  }
  
  private void updateStatus(int paramInt)
  {
    this.mStatus = paramInt;
  }
  
  private void v(String paramString1, String paramString2)
  {
    Logger.v(paramString1, paramString2);
  }
  
  public CMTime getCurrentPlayingState()
  {
    return this.currentPlayingState.getTime();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject4 = null;
    PlayerMessage localPlayerMessage;
    if (paramMessage.obj == null)
    {
      localPlayerMessage = null;
      if (localPlayerMessage == null) {
        break label519;
      }
    }
    label78:
    Object localObject3;
    label519:
    for (Object localObject1 = localPlayerMessage.bizMsg1;; localObject3 = null)
    {
      StringBuilder localStringBuilder = new StringBuilder().append("handleMessage() called with: msg = [").append(catLog(paramMessage.what)).append(paramMessage.what).append("]--status-->").append(this.mStatus).append("--from-->");
      if (localPlayerMessage == null) {
        v("PlayerThreadAudio", localObject4 + " targetObj = " + localObject1);
      }
      for (;;)
      {
        try
        {
          int i = paramMessage.what;
          switch (i)
          {
          }
        }
        catch (Exception localException)
        {
          Logger.e("PlayerThreadAudio", "handleMessage: error", localException);
          return false;
          play(localException);
          continue;
        }
        finally
        {
          if ((localPlayerMessage == null) || (TextUtils.isEmpty(localPlayerMessage.form)) || (!localPlayerMessage.form.startsWith("syncAudioStatus"))) {
            continue;
          }
          Log.d("PlayerThreadAudio", "handleMessage:  SyncMessageId = " + localPlayerMessage.msgId + ", what = " + paramMessage.what);
          this.lastSyncMessgeId = localPlayerMessage.msgId;
        }
        if ((localPlayerMessage != null) && (!TextUtils.isEmpty(localPlayerMessage.form)) && (localPlayerMessage.form.startsWith("syncAudioStatus")))
        {
          Log.d("PlayerThreadAudio", "handleMessage:  SyncMessageId = " + localPlayerMessage.msgId + ", what = " + paramMessage.what);
          this.lastSyncMessgeId = localPlayerMessage.msgId;
        }
        return true;
        localPlayerMessage = (PlayerMessage)paramMessage.obj;
        break;
        localObject4 = localPlayerMessage;
        break label78;
        actionPrepare();
        continue;
        readSample();
        continue;
        pause();
        continue;
        stop(false);
        continue;
        playerFinish();
        continue;
        setVolume(localObject2);
        continue;
        release();
        continue;
        seekTo(localObject2);
      }
    }
  }
  
  public boolean isFinished()
  {
    return (3 == this.mStatus) && (this.currentPlayingState.isInvalid());
  }
  
  public void sendMessage(int paramInt, Object paramObject, String paramString, long paramLong)
  {
    v("PlayerThreadAudio", "sendMessage() called with: what = [" + catLog(paramInt) + "], obj = [" + paramObject + "], from = [" + paramString + "]");
    if ((this.mPlayHandler != null) && (this.mThread != null))
    {
      if (((paramInt == 3) || (paramInt == -1) || (paramInt == 5) || (paramInt == 6)) && (this.mPlayHandler.hasMessages(12)))
      {
        this.mPlayHandler.removeMessages(12);
        sendMessage(12, "schedule next", System.currentTimeMillis());
      }
      this.mPlayHandler.obtainMessage(paramInt, new PlayerMessage(paramObject, paramString, paramLong)).sendToTarget();
    }
  }
  
  public void sendMessage(int paramInt, String paramString, long paramLong)
  {
    v("PlayerThreadAudio", "sendMessage() called with: what = [" + catLog(paramInt) + "], from = [" + paramString + "]");
    if ((this.mPlayHandler != null) && (this.mThread != null)) {
      this.mPlayHandler.obtainMessage(paramInt, new PlayerMessage(null, paramString, paramLong)).sendToTarget();
    }
  }
  
  public void sendMessageDelay(int paramInt, long paramLong1, String paramString, long paramLong2)
  {
    v("PlayerThreadAudio", "sendMessageDelay() called with: what = [" + catLog(paramInt) + "], delay = [" + paramLong1 + "], from = [" + paramString + "]");
    if (this.mPlayHandler != null)
    {
      Message localMessage = new Message();
      localMessage.what = paramInt;
      localMessage.obj = new PlayerMessage(null, paramString, paramLong2);
      this.mPlayHandler.sendMessageDelayed(localMessage, paramLong1);
    }
  }
  
  public void setRate(float paramFloat)
  {
    this.rate = Math.abs(paramFloat);
  }
  
  public void update(AudioCompositionDecoderTrack paramAudioCompositionDecoderTrack)
  {
    this.audioDecoderTrack = paramAudioCompositionDecoderTrack;
  }
  
  @Deprecated
  public void updateComposition(AudioCompositionDecoderTrack paramAudioCompositionDecoderTrack)
  {
    sendMessage(4, "updateComposition", System.currentTimeMillis());
    sendMessage(1, paramAudioCompositionDecoderTrack, "updateComposition", System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.player.PlayerThreadAudio
 * JD-Core Version:    0.7.0.1
 */