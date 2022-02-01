package com.tencent.qqmini.miniapp.widget.media;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.os.Handler;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.ScreenOffOnListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

public class MiniAppAudioPlayer
  implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener
{
  private static final int MIN_START_TIME = 1000;
  public static final int STATE_BUFFERING = 0;
  public static final int STATE_COMPLETION = 5;
  public static final int STATE_ERROR = 6;
  public static final int STATE_PAUSE = 3;
  public static final int STATE_PLAYING = 2;
  public static final int STATE_PREPARE = 1;
  public static final int STATE_STOP = 4;
  private static final String TAG = "MiniAppAudioPlayer";
  private static final int UPDATE_INTERVAL = 100;
  private boolean audioFocus = false;
  private Context mContext;
  private int mDuration;
  private Runnable mLoopingRunnable = new MiniAppAudioPlayer.2(this);
  private MediaPlayer mPlayer;
  private MiniAppAudioPlayer.AudioPlayerListener mPlayerListener;
  private String mSrc;
  private Runnable mStartRunnable = new MiniAppAudioPlayer.1(this);
  private volatile int mStartTime;
  private int mState;
  private final Handler mUiHandler;
  private MiniAppAudioPlayer.OnPreparedListener preparedListener;
  
  public MiniAppAudioPlayer()
  {
    this(null);
  }
  
  public MiniAppAudioPlayer(Handler paramHandler)
  {
    this.mUiHandler = paramHandler;
    if (this.mPlayer != null) {
      if (this.mPlayer.isPlaying()) {
        stop();
      }
    }
    for (;;)
    {
      ScreenOffOnListener.getInstance().registListener(new MiniAppAudioPlayer.3(this));
      return;
      initMediaPlayer();
    }
  }
  
  private void handleCompletion()
  {
    if (this.mPlayer != null) {
      this.mDuration = this.mPlayer.getDuration();
    }
  }
  
  private void initMediaPlayer()
  {
    this.mPlayer = new MediaPlayer();
    this.mPlayer.setOnPreparedListener(this);
    this.mPlayer.setOnCompletionListener(this);
    this.mPlayer.setOnErrorListener(this);
    this.mPlayer.setOnSeekCompleteListener(this);
    this.mPlayer.setOnBufferingUpdateListener(this);
  }
  
  private void muteAudioFocus(boolean paramBoolean)
  {
    try
    {
      ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).muteAudioFocus(this.mContext, paramBoolean);
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("MiniAppAudioPlayer", "muteAudioFocus....." + localException);
    }
  }
  
  private void notifyPlayerError(int paramInt1, int paramInt2)
  {
    QMLog.d("MiniAppAudioPlayer", "notifyPlayerError.....what..." + paramInt1 + " extra..." + paramInt2);
    if (this.mPlayerListener != null)
    {
      this.mPlayerListener.onError(paramInt1, paramInt2);
      notifyPlayerStateChange(6);
    }
  }
  
  private void notifyPlayerProgress(int paramInt)
  {
    if (this.mPlayerListener != null) {
      this.mPlayerListener.onPlayerProgress(this.mSrc, this.mDuration, paramInt);
    }
  }
  
  private void notifyPlayerStateChange(int paramInt)
  {
    try
    {
      this.mState = paramInt;
      if (this.mPlayerListener != null) {
        this.mPlayerListener.onPlayerStateChange(paramInt);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void resetMediaPlayer()
  {
    if (this.mPlayer != null) {}
    try
    {
      this.mPlayer.reset();
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("MiniAppAudioPlayer", "resetMediaPlayer....." + localException);
    }
  }
  
  public int getCurrentPosition()
  {
    int j = 0;
    int i = j;
    if (this.mPlayer != null) {}
    try
    {
      i = Math.max(this.mPlayer.getCurrentPosition(), 0);
      return Math.min(i, this.mDuration);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.w("MiniAppAudioPlayer", "getCurrentPosition: failed", localException);
        i = j;
      }
    }
  }
  
  public int getDuration()
  {
    return this.mDuration;
  }
  
  public int getState()
  {
    return this.mState;
  }
  
  public boolean isPaused()
  {
    return this.mState == 3;
  }
  
  public boolean isPlaying()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (this.mPlayer != null)
      {
        boolean bool3 = this.mPlayer.isPlaying();
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception localException)
    {
      QMLog.e("MiniAppAudioPlayer", "mPlayer.isPlaying exception. " + localException);
    }
    return false;
  }
  
  public boolean isPrepared()
  {
    return this.mState == 1;
  }
  
  public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    QMLog.d("MiniAppAudioPlayer", "onBufferingUpdate....." + paramInt);
    if (this.mPlayerListener != null) {
      this.mPlayerListener.onPlayerBufferingUpdate(paramInt);
    }
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    QMLog.d("MiniAppAudioPlayer", "onCompletion.....");
    handleCompletion();
    notifyPlayerStateChange(5);
    notifyPlayerProgress(0);
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    QMLog.d("MiniAppAudioPlayer", "onError.....what..." + paramInt1 + " extra..." + paramInt2);
    if (paramInt1 == 100)
    {
      if (this.mPlayer != null) {
        this.mPlayer.release();
      }
      initMediaPlayer();
    }
    notifyPlayerError(paramInt1, paramInt2);
    notifyPlayerProgress(0);
    return true;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    QMLog.d("MiniAppAudioPlayer", "onPrepared.....");
    notifyPlayerStateChange(1);
    if (this.preparedListener != null) {
      this.preparedListener.onPrepared();
    }
    if (this.mPlayer != null) {}
    for (int i = this.mPlayer.getDuration();; i = 0)
    {
      this.mDuration = Math.max(i, 0);
      return;
    }
  }
  
  public void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    QMLog.d("MiniAppAudioPlayer", "onSeekComplete.....");
    if (this.mPlayerListener != null) {
      this.mPlayerListener.onPlayerSeek(true, getCurrentPosition());
    }
  }
  
  public void pause()
  {
    muteAudioFocus(false);
    if (this.mPlayer != null)
    {
      this.mPlayer.pause();
      notifyPlayerStateChange(3);
    }
  }
  
  public void release()
  {
    muteAudioFocus(false);
    if (this.mPlayer != null)
    {
      this.mPlayer.release();
      this.mPlayer = null;
      notifyPlayerProgress(0);
    }
    if (this.mUiHandler != null) {
      this.mUiHandler.removeCallbacks(this.mLoopingRunnable);
    }
  }
  
  public void seekTo(int paramInt)
  {
    int i = getState();
    if ((this.mPlayer != null) && (i > 0) && (i < 3) && (paramInt >= 0)) {
      try
      {
        if (this.mPlayerListener != null) {
          this.mPlayerListener.onPlayerSeek(false, paramInt);
        }
        this.mPlayer.seekTo(paramInt);
        return;
      }
      catch (Exception localException)
      {
        QMLog.e("MiniAppAudioPlayer", "seekTo....." + localException);
        return;
      }
    }
    this.mStartTime = paramInt;
  }
  
  public void setAudioContext(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public void setAudioFocus(boolean paramBoolean)
  {
    this.audioFocus = paramBoolean;
  }
  
  public void setAudioPlayerListener(MiniAppAudioPlayer.AudioPlayerListener paramAudioPlayerListener)
  {
    this.mPlayerListener = paramAudioPlayerListener;
  }
  
  public void setDataSource(String paramString, MiniAppAudioPlayer.OnPreparedListener paramOnPreparedListener)
  {
    this.mSrc = paramString;
    this.preparedListener = paramOnPreparedListener;
    try
    {
      this.mDuration = 0;
      resetMediaPlayer();
      this.mPlayer.setDataSource(paramString);
      notifyPlayerStateChange(0);
      notifyPlayerProgress(0);
      this.mPlayer.prepareAsync();
      return;
    }
    catch (Exception paramString)
    {
      resetMediaPlayer();
      notifyPlayerError(1, 0);
      QMLog.e("MiniAppAudioPlayer", "setDataSource....." + paramString);
    }
  }
  
  public void setLooping(boolean paramBoolean)
  {
    if (this.mPlayer != null) {
      this.mPlayer.setLooping(paramBoolean);
    }
  }
  
  public void setStartTime(int paramInt)
  {
    this.mStartTime = paramInt;
  }
  
  public void setVolume(float paramFloat)
  {
    if ((this.mPlayer != null) && (paramFloat >= 0.0F) && (paramFloat <= 1.0F))
    {
      QMLog.i("MiniAppAudioPlayer", "setVolume:" + paramFloat);
      this.mPlayer.setVolume(paramFloat, paramFloat);
    }
  }
  
  public void start()
  {
    if ((this.mState == 1) || (this.mState == 3)) {}
    try
    {
      ThreadManager.executeOnComputationThreadPool(this.mStartRunnable);
      muteAudioFocus(this.audioFocus);
      if (this.mUiHandler != null) {
        this.mUiHandler.post(this.mLoopingRunnable);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("MiniAppAudioPlayer", "resetMediaPlayer....." + localThrowable);
    }
  }
  
  public void stop()
  {
    if (this.mPlayer != null)
    {
      this.mPlayer.stop();
      muteAudioFocus(false);
      notifyPlayerProgress(0);
      notifyPlayerStateChange(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.media.MiniAppAudioPlayer
 * JD-Core Version:    0.7.0.1
 */