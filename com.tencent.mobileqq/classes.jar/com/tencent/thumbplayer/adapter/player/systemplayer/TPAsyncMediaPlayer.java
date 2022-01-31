package com.tencent.thumbplayer.adapter.player.systemplayer;

import android.annotation.TargetApi;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.PlaybackParams;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import com.tencent.thumbplayer.utils.TPLogUtil;

public class TPAsyncMediaPlayer
  extends TPMediaPlayer
{
  private static final String TAG = "TPThumbPlayer[TPAsyncMediaPlayer.java]";
  private static final int TP_MEDIAPLAYER_MSG_PAUSE = 3;
  private static final int TP_MEDIAPLAYER_MSG_RELEASE = 8;
  private static final int TP_MEDIAPLAYER_MSG_RESET = 7;
  private static final int TP_MEDIAPLAYER_MSG_SEEK = 4;
  private static final int TP_MEDIAPLAYER_MSG_SEEK_BY_MODE = 5;
  private static final int TP_MEDIAPLAYER_MSG_SETSURFACE = 1;
  private static final int TP_MEDIAPLAYER_MSG_SET_PLAY_PARAM = 9;
  private static final int TP_MEDIAPLAYER_MSG_START = 2;
  private static final int TP_MEDIAPLAYER_MSG_STOP = 6;
  private static final int WAIT_STOP_TIMEOUT = 2500;
  private TPAsyncMediaPlayer.EventHandler mEventHandler;
  private HandlerThread mHandlerThread = new HandlerThread("TP-AsyncMediaPlayerThread");
  private boolean mIsSeeking = false;
  private long mLastSeekPos = 0L;
  private MediaPlayer.OnSeekCompleteListener mOnSeekCompleteListener;
  private MediaPlayer.OnSeekCompleteListener mOnSeekCompleteListenerInner = new TPAsyncMediaPlayer.1(this);
  private final Object mReleaseCondition = new Object();
  private final Object mResetCondition = new Object();
  private final Object mStateLock = new Object();
  private final Object mStopCondition = new Object();
  
  public TPAsyncMediaPlayer()
  {
    this.mHandlerThread.start();
    this.mEventHandler = new TPAsyncMediaPlayer.EventHandler(this.mHandlerThread.getLooper(), this);
  }
  
  public int getCurrentPosition()
  {
    if (this.mIsSeeking) {
      return (int)this.mLastSeekPos;
    }
    return super.getCurrentPosition();
  }
  
  public void handlePause()
  {
    try
    {
      super.pause();
      return;
    }
    catch (Exception localException)
    {
      TPLogUtil.e("TPThumbPlayer[TPAsyncMediaPlayer.java]", localException);
    }
  }
  
  /* Error */
  public void handleRelease()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 123	com/tencent/thumbplayer/adapter/player/systemplayer/TPMediaPlayer:release	()V
    //   4: aload_0
    //   5: getfield 80	com/tencent/thumbplayer/adapter/player/systemplayer/TPAsyncMediaPlayer:mHandlerThread	Landroid/os/HandlerThread;
    //   8: invokevirtual 127	android/os/HandlerThread:quit	()Z
    //   11: pop
    //   12: aload_0
    //   13: aconst_null
    //   14: putfield 80	com/tencent/thumbplayer/adapter/player/systemplayer/TPAsyncMediaPlayer:mHandlerThread	Landroid/os/HandlerThread;
    //   17: aload_0
    //   18: getfield 94	com/tencent/thumbplayer/adapter/player/systemplayer/TPAsyncMediaPlayer:mEventHandler	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPAsyncMediaPlayer$EventHandler;
    //   21: aconst_null
    //   22: invokevirtual 131	com/tencent/thumbplayer/adapter/player/systemplayer/TPAsyncMediaPlayer$EventHandler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   25: aload_0
    //   26: aconst_null
    //   27: putfield 94	com/tencent/thumbplayer/adapter/player/systemplayer/TPAsyncMediaPlayer:mEventHandler	Lcom/tencent/thumbplayer/adapter/player/systemplayer/TPAsyncMediaPlayer$EventHandler;
    //   30: aload_0
    //   31: getfield 58	com/tencent/thumbplayer/adapter/player/systemplayer/TPAsyncMediaPlayer:mReleaseCondition	Ljava/lang/Object;
    //   34: astore_1
    //   35: aload_1
    //   36: monitorenter
    //   37: aload_0
    //   38: getfield 58	com/tencent/thumbplayer/adapter/player/systemplayer/TPAsyncMediaPlayer:mReleaseCondition	Ljava/lang/Object;
    //   41: invokevirtual 134	java/lang/Object:notify	()V
    //   44: aload_1
    //   45: monitorexit
    //   46: return
    //   47: astore_1
    //   48: ldc 8
    //   50: aload_1
    //   51: invokestatic 119	com/tencent/thumbplayer/utils/TPLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   54: goto -50 -> 4
    //   57: astore_2
    //   58: aload_1
    //   59: monitorexit
    //   60: aload_2
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	TPAsyncMediaPlayer
    //   47	12	1	localException	Exception
    //   57	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	4	47	java/lang/Exception
    //   37	46	57	finally
    //   58	60	57	finally
  }
  
  /* Error */
  public void handleReset()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 138	com/tencent/thumbplayer/adapter/player/systemplayer/TPMediaPlayer:reset	()V
    //   4: aload_0
    //   5: getfield 56	com/tencent/thumbplayer/adapter/player/systemplayer/TPAsyncMediaPlayer:mResetCondition	Ljava/lang/Object;
    //   8: astore_1
    //   9: aload_1
    //   10: monitorenter
    //   11: aload_0
    //   12: getfield 56	com/tencent/thumbplayer/adapter/player/systemplayer/TPAsyncMediaPlayer:mResetCondition	Ljava/lang/Object;
    //   15: invokevirtual 134	java/lang/Object:notify	()V
    //   18: aload_1
    //   19: monitorexit
    //   20: return
    //   21: astore_1
    //   22: ldc 8
    //   24: aload_1
    //   25: invokestatic 119	com/tencent/thumbplayer/utils/TPLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   28: goto -24 -> 4
    //   31: astore_2
    //   32: aload_1
    //   33: monitorexit
    //   34: aload_2
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	TPAsyncMediaPlayer
    //   21	12	1	localException	Exception
    //   31	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	4	21	java/lang/Exception
    //   11	20	31	finally
    //   32	34	31	finally
  }
  
  public void handleSeekTo(Message paramMessage)
  {
    synchronized (this.mStateLock)
    {
      try
      {
        super.seekTo(paramMessage.arg1);
        return;
      }
      catch (Exception paramMessage)
      {
        for (;;)
        {
          TPLogUtil.e("TPThumbPlayer[TPAsyncMediaPlayer.java]", paramMessage);
        }
      }
    }
  }
  
  @TargetApi(26)
  public void handleSeekToByMode(Message paramMessage)
  {
    synchronized (this.mStateLock)
    {
      try
      {
        super.seekTo(((Long)paramMessage.obj).longValue(), paramMessage.arg1);
        return;
      }
      catch (Exception paramMessage)
      {
        for (;;)
        {
          TPLogUtil.e("TPThumbPlayer[TPAsyncMediaPlayer.java]", paramMessage);
        }
      }
    }
  }
  
  @TargetApi(23)
  public void handleSetPlaybackParams(Message paramMessage)
  {
    try
    {
      super.setPlaybackParams((PlaybackParams)paramMessage.obj);
      return;
    }
    catch (Exception paramMessage)
    {
      TPLogUtil.e("TPThumbPlayer[TPAsyncMediaPlayer.java]", paramMessage);
    }
  }
  
  public void handleSetSurface(Message paramMessage)
  {
    super.setSurface((Surface)paramMessage.obj);
  }
  
  public void handleStart()
  {
    try
    {
      super.start();
      return;
    }
    catch (Exception localException)
    {
      TPLogUtil.e("TPThumbPlayer[TPAsyncMediaPlayer.java]", localException);
    }
  }
  
  /* Error */
  public void handleStop()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 187	com/tencent/thumbplayer/adapter/player/systemplayer/TPMediaPlayer:stop	()V
    //   4: aload_0
    //   5: getfield 54	com/tencent/thumbplayer/adapter/player/systemplayer/TPAsyncMediaPlayer:mStopCondition	Ljava/lang/Object;
    //   8: astore_1
    //   9: aload_1
    //   10: monitorenter
    //   11: aload_0
    //   12: getfield 54	com/tencent/thumbplayer/adapter/player/systemplayer/TPAsyncMediaPlayer:mStopCondition	Ljava/lang/Object;
    //   15: invokevirtual 134	java/lang/Object:notify	()V
    //   18: aload_1
    //   19: monitorexit
    //   20: return
    //   21: astore_1
    //   22: ldc 8
    //   24: aload_1
    //   25: invokestatic 119	com/tencent/thumbplayer/utils/TPLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   28: goto -24 -> 4
    //   31: astore_2
    //   32: aload_1
    //   33: monitorexit
    //   34: aload_2
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	TPAsyncMediaPlayer
    //   21	12	1	localException	Exception
    //   31	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	4	21	java/lang/Exception
    //   11	20	31	finally
    //   32	34	31	finally
  }
  
  public void pause()
  {
    this.mEventHandler.sendEmptyMessage(3);
  }
  
  public void release()
  {
    synchronized (this.mReleaseCondition)
    {
      this.mEventHandler.sendEmptyMessage(8);
      try
      {
        this.mReleaseCondition.wait(2500L);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          TPLogUtil.e("TPThumbPlayer[TPAsyncMediaPlayer.java]", localInterruptedException);
        }
      }
    }
  }
  
  public void reset()
  {
    synchronized (this.mResetCondition)
    {
      this.mEventHandler.sendEmptyMessage(7);
      try
      {
        this.mResetCondition.wait(2500L);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          TPLogUtil.e("TPThumbPlayer[TPAsyncMediaPlayer.java]", localInterruptedException);
        }
      }
    }
  }
  
  public void seekTo(int paramInt)
  {
    Object localObject1 = this.mStateLock;
    long l = paramInt;
    try
    {
      this.mLastSeekPos = l;
      this.mIsSeeking = true;
      Message localMessage = Message.obtain();
      localMessage.what = 4;
      localMessage.arg1 = paramInt;
      this.mEventHandler.sendMessage(localMessage);
      return;
    }
    finally {}
  }
  
  public void seekTo(long paramLong, int paramInt)
  {
    synchronized (this.mStateLock)
    {
      this.mLastSeekPos = paramLong;
      this.mIsSeeking = true;
      Message localMessage = Message.obtain();
      localMessage.what = 5;
      localMessage.arg1 = paramInt;
      localMessage.obj = Long.valueOf(paramLong);
      this.mEventHandler.sendMessage(localMessage);
      return;
    }
  }
  
  public void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    this.mOnSeekCompleteListener = paramOnSeekCompleteListener;
    super.setOnSeekCompleteListener(this.mOnSeekCompleteListenerInner);
  }
  
  public void setPlaybackParams(PlaybackParams paramPlaybackParams)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 9;
    localMessage.obj = paramPlaybackParams;
    this.mEventHandler.sendMessage(localMessage);
  }
  
  public void setSurface(Surface paramSurface)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = paramSurface;
    this.mEventHandler.sendMessage(localMessage);
  }
  
  public void start()
  {
    this.mEventHandler.sendEmptyMessage(2);
  }
  
  public void stop()
  {
    synchronized (this.mStopCondition)
    {
      this.mEventHandler.sendEmptyMessage(6);
      try
      {
        this.mStopCondition.wait(2500L);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          TPLogUtil.e("TPThumbPlayer[TPAsyncMediaPlayer.java]", localInterruptedException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.systemplayer.TPAsyncMediaPlayer
 * JD-Core Version:    0.7.0.1
 */