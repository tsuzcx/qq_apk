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
  
  public void handleRelease()
  {
    try
    {
      super.release();
    }
    catch (Exception localException)
    {
      TPLogUtil.e("TPThumbPlayer[TPAsyncMediaPlayer.java]", localException);
    }
    this.mHandlerThread.quit();
    this.mHandlerThread = null;
    this.mEventHandler.removeCallbacksAndMessages(null);
    this.mEventHandler = null;
    synchronized (this.mReleaseCondition)
    {
      this.mReleaseCondition.notify();
      return;
    }
  }
  
  public void handleReset()
  {
    try
    {
      super.reset();
    }
    catch (Exception localException)
    {
      TPLogUtil.e("TPThumbPlayer[TPAsyncMediaPlayer.java]", localException);
    }
    synchronized (this.mResetCondition)
    {
      this.mResetCondition.notify();
      return;
    }
  }
  
  public void handleSeekTo(Message paramMessage)
  {
    try
    {
      synchronized (this.mStateLock)
      {
        super.seekTo(paramMessage.arg1);
      }
    }
    catch (Exception paramMessage)
    {
      TPLogUtil.e("TPThumbPlayer[TPAsyncMediaPlayer.java]", paramMessage);
      return;
    }
  }
  
  @TargetApi(26)
  public void handleSeekToByMode(Message paramMessage)
  {
    try
    {
      synchronized (this.mStateLock)
      {
        super.seekTo(((Long)paramMessage.obj).longValue(), paramMessage.arg1);
      }
    }
    catch (Exception paramMessage)
    {
      TPLogUtil.e("TPThumbPlayer[TPAsyncMediaPlayer.java]", paramMessage);
      return;
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
  
  public void handleStop()
  {
    try
    {
      super.stop();
    }
    catch (Exception localException)
    {
      TPLogUtil.e("TPThumbPlayer[TPAsyncMediaPlayer.java]", localException);
    }
    synchronized (this.mStopCondition)
    {
      this.mStopCondition.notify();
      return;
    }
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
      }
      catch (InterruptedException localInterruptedException)
      {
        TPLogUtil.e("TPThumbPlayer[TPAsyncMediaPlayer.java]", localInterruptedException);
      }
      return;
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
      }
      catch (InterruptedException localInterruptedException)
      {
        TPLogUtil.e("TPThumbPlayer[TPAsyncMediaPlayer.java]", localInterruptedException);
      }
      return;
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
      }
      catch (InterruptedException localInterruptedException)
      {
        TPLogUtil.e("TPThumbPlayer[TPAsyncMediaPlayer.java]", localInterruptedException);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.systemplayer.TPAsyncMediaPlayer
 * JD-Core Version:    0.7.0.1
 */