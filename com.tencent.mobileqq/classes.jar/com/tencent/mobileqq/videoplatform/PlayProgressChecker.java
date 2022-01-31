package com.tencent.mobileqq.videoplatform;

import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.mobileqq.videoplatform.util.LogUtil;
import com.tencent.mobileqq.videoplatform.util.ThreadUtil;
import com.tencent.superplayer.api.ISuperPlayer;
import java.util.concurrent.atomic.AtomicBoolean;

public class PlayProgressChecker
  implements Runnable
{
  static final int PROGRESS_REFRESH_TIME = 200;
  private VideoPlayerCallback mCallback;
  private long mId;
  public ISuperPlayer mPlayer;
  private AtomicBoolean mStoped = new AtomicBoolean(false);
  
  PlayProgressChecker(long paramLong, ISuperPlayer paramISuperPlayer, VideoPlayerCallback paramVideoPlayerCallback)
  {
    this.mPlayer = paramISuperPlayer;
    this.mCallback = paramVideoPlayerCallback;
    this.mId = paramLong;
  }
  
  protected String getLogTag()
  {
    return "[VideoPlatForm]PlayProgressChecker[" + this.mId + "]";
  }
  
  public void run()
  {
    if (this.mStoped.get()) {
      return;
    }
    if ((this.mPlayer != null) && (this.mPlayer.isPlaying()))
    {
      long l = this.mPlayer.getCurrentPositionMs();
      if (LogUtil.isColorLevel()) {
        LogUtil.d(getLogTag(), 2, "ProgressChecker, playPos = " + l);
      }
      if ((l > 0L) && (this.mCallback != null)) {
        ThreadUtil.postOnUIThread(new PlayProgressChecker.1(this, l));
      }
    }
    ThreadUtil.postOnSubThreadDelayed(this, 200L);
  }
  
  public void start()
  {
    if (LogUtil.isColorLevel()) {
      LogUtil.d(getLogTag(), 2, "start");
    }
    this.mStoped.set(false);
    ThreadUtil.removeCallbacksInSubHandler(this);
    ThreadUtil.postOnSubThreadDelayed(this, 200L);
  }
  
  public void stop()
  {
    if (LogUtil.isColorLevel()) {
      LogUtil.d(getLogTag(), 2, "stop");
    }
    this.mStoped.set(true);
    ThreadUtil.removeCallbacksInSubHandler(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.PlayProgressChecker
 * JD-Core Version:    0.7.0.1
 */