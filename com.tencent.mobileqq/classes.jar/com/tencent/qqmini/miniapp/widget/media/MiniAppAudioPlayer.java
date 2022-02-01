package com.tencent.qqmini.miniapp.widget.media;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.os.Handler;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
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
    paramHandler = this.mPlayer;
    if (paramHandler != null)
    {
      if (paramHandler.isPlaying()) {
        stop();
      }
    }
    else {
      initMediaPlayer();
    }
    ScreenOffOnListener.getInstance().registListener(new MiniAppAudioPlayer.3(this));
  }
  
  private void handleCompletion()
  {
    MediaPlayer localMediaPlayer = this.mPlayer;
    if (localMediaPlayer != null) {
      this.mDuration = localMediaPlayer.getDuration();
    }
  }
  
  private void initMediaPlayer()
  {
    this.mPlayer = new ReportMediaPlayer();
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("muteAudioFocus.....");
      localStringBuilder.append(localException);
      QMLog.e("MiniAppAudioPlayer", localStringBuilder.toString());
    }
  }
  
  private void notifyPlayerError(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("notifyPlayerError.....what...");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" extra...");
    ((StringBuilder)localObject).append(paramInt2);
    QMLog.d("MiniAppAudioPlayer", ((StringBuilder)localObject).toString());
    localObject = this.mPlayerListener;
    if (localObject != null)
    {
      ((MiniAppAudioPlayer.AudioPlayerListener)localObject).onError(paramInt1, paramInt2);
      notifyPlayerStateChange(6);
    }
  }
  
  private void notifyPlayerProgress(int paramInt)
  {
    MiniAppAudioPlayer.AudioPlayerListener localAudioPlayerListener = this.mPlayerListener;
    if (localAudioPlayerListener != null) {
      localAudioPlayerListener.onPlayerProgress(this.mSrc, this.mDuration, paramInt);
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
    MediaPlayer localMediaPlayer = this.mPlayer;
    if (localMediaPlayer != null) {
      try
      {
        localMediaPlayer.reset();
        return;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("resetMediaPlayer.....");
        localStringBuilder.append(localException);
        QMLog.e("MiniAppAudioPlayer", localStringBuilder.toString());
      }
    }
  }
  
  public int getCurrentPosition()
  {
    MediaPlayer localMediaPlayer = this.mPlayer;
    int j = 0;
    int i = j;
    if (localMediaPlayer != null) {
      try
      {
        i = Math.max(localMediaPlayer.getCurrentPosition(), 0);
      }
      catch (Exception localException)
      {
        QMLog.w("MiniAppAudioPlayer", "getCurrentPosition: failed", localException);
        i = j;
      }
    }
    return Math.min(i, this.mDuration);
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mPlayer.isPlaying exception. ");
      localStringBuilder.append(localException);
      QMLog.e("MiniAppAudioPlayer", localStringBuilder.toString());
    }
    return false;
  }
  
  public boolean isPrepared()
  {
    return this.mState == 1;
  }
  
  public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    paramMediaPlayer = new StringBuilder();
    paramMediaPlayer.append("onBufferingUpdate.....");
    paramMediaPlayer.append(paramInt);
    QMLog.d("MiniAppAudioPlayer", paramMediaPlayer.toString());
    paramMediaPlayer = this.mPlayerListener;
    if (paramMediaPlayer != null) {
      paramMediaPlayer.onPlayerBufferingUpdate(paramInt);
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
    paramMediaPlayer = new StringBuilder();
    paramMediaPlayer.append("onError.....what...");
    paramMediaPlayer.append(paramInt1);
    paramMediaPlayer.append(" extra...");
    paramMediaPlayer.append(paramInt2);
    QMLog.d("MiniAppAudioPlayer", paramMediaPlayer.toString());
    if (paramInt1 == 100)
    {
      paramMediaPlayer = this.mPlayer;
      if (paramMediaPlayer != null) {
        paramMediaPlayer.release();
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
    paramMediaPlayer = this.preparedListener;
    if (paramMediaPlayer != null) {
      paramMediaPlayer.onPrepared();
    }
    paramMediaPlayer = this.mPlayer;
    int i;
    if (paramMediaPlayer != null) {
      i = paramMediaPlayer.getDuration();
    } else {
      i = 0;
    }
    this.mDuration = Math.max(i, 0);
  }
  
  public void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    QMLog.d("MiniAppAudioPlayer", "onSeekComplete.....");
    paramMediaPlayer = this.mPlayerListener;
    if (paramMediaPlayer != null) {
      paramMediaPlayer.onPlayerSeek(true, getCurrentPosition());
    }
  }
  
  public void pause()
  {
    muteAudioFocus(false);
    MediaPlayer localMediaPlayer = this.mPlayer;
    if (localMediaPlayer != null)
    {
      localMediaPlayer.pause();
      notifyPlayerStateChange(3);
    }
  }
  
  public void release()
  {
    muteAudioFocus(false);
    Object localObject = this.mPlayer;
    if (localObject != null)
    {
      ((MediaPlayer)localObject).release();
      this.mPlayer = null;
      notifyPlayerProgress(0);
    }
    localObject = this.mUiHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacks(this.mLoopingRunnable);
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
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("seekTo.....");
        localStringBuilder.append(localException);
        QMLog.e("MiniAppAudioPlayer", localStringBuilder.toString());
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
      paramOnPreparedListener = new StringBuilder();
      paramOnPreparedListener.append("setDataSource.....");
      paramOnPreparedListener.append(paramString);
      QMLog.e("MiniAppAudioPlayer", paramOnPreparedListener.toString());
    }
  }
  
  public void setLooping(boolean paramBoolean)
  {
    MediaPlayer localMediaPlayer = this.mPlayer;
    if (localMediaPlayer != null) {
      localMediaPlayer.setLooping(paramBoolean);
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setVolume:");
      localStringBuilder.append(paramFloat);
      QMLog.i("MiniAppAudioPlayer", localStringBuilder.toString());
      this.mPlayer.setVolume(paramFloat, paramFloat);
    }
  }
  
  public void start()
  {
    int i = this.mState;
    if ((i == 1) || (i == 3)) {
      try
      {
        ThreadManager.executeOnComputationThreadPool(this.mStartRunnable);
        muteAudioFocus(this.audioFocus);
        if (this.mUiHandler != null)
        {
          this.mUiHandler.post(this.mLoopingRunnable);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("resetMediaPlayer.....");
        localStringBuilder.append(localThrowable);
        QMLog.e("MiniAppAudioPlayer", localStringBuilder.toString());
      }
    }
  }
  
  public void stop()
  {
    MediaPlayer localMediaPlayer = this.mPlayer;
    if (localMediaPlayer != null)
    {
      localMediaPlayer.stop();
      muteAudioFocus(false);
      notifyPlayerProgress(0);
      notifyPlayerStateChange(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.media.MiniAppAudioPlayer
 * JD-Core Version:    0.7.0.1
 */