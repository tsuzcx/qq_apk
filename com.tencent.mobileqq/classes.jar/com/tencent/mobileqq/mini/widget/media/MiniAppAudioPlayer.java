package com.tencent.mobileqq.mini.widget.media;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.os.Handler;
import bhkm;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.utils.ScreenOffOnListener;
import com.tencent.qphone.base.util.QLog;

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
  private boolean audioFocus;
  private Context mContext;
  private int mDuration;
  private Runnable mLoopingRunnable = new MiniAppAudioPlayer.3(this);
  private MediaPlayer mPlayer;
  private MiniAppAudioPlayer.AudioPlayerListener mPlayerListener;
  private String mSrc;
  private Runnable mStartRunnable = new MiniAppAudioPlayer.2(this);
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
      ScreenOffOnListener.getInstance().registListener(new MiniAppAudioPlayer.1(this));
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
      bhkm.a(this.mContext, paramBoolean);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("MiniAppAudioPlayer", 2, "muteAudioFocus....." + localException);
    }
  }
  
  private void notifyPlayerError(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppAudioPlayer", 2, "notifyPlayerError.....what..." + paramInt1 + " extra..." + paramInt2);
    }
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
      while (!QLog.isColorLevel()) {}
      QLog.e("MiniAppAudioPlayer", 2, "resetMediaPlayer....." + localException);
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
        QLog.w("MiniAppAudioPlayer", 2, "getCurrentPosition: failed", localException);
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
      QLog.e("MiniAppAudioPlayer", 2, "mPlayer.isPlaying exception. " + localException);
    }
    return false;
  }
  
  public boolean isPrepared()
  {
    return this.mState == 1;
  }
  
  public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppAudioPlayer", 2, "onBufferingUpdate....." + paramInt);
    }
    if (this.mPlayerListener != null) {
      this.mPlayerListener.onPlayerBufferingUpdate(paramInt);
    }
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppAudioPlayer", 2, "onCompletion.....");
    }
    handleCompletion();
    notifyPlayerStateChange(5);
    notifyPlayerProgress(0);
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppAudioPlayer", 2, "onError.....what..." + paramInt1 + " extra..." + paramInt2);
    }
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
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppAudioPlayer", 2, "onPrepared.....");
    }
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
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppAudioPlayer", 2, "onSeekComplete.....");
    }
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
        while (!QLog.isColorLevel()) {}
        QLog.e("MiniAppAudioPlayer", 2, "seekTo....." + localException);
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
      do
      {
        resetMediaPlayer();
        notifyPlayerError(1, 0);
      } while (!QLog.isColorLevel());
      QLog.e("MiniAppAudioPlayer", 2, "setDataSource....." + paramString);
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
      QLog.i("MiniAppAudioPlayer", 2, "setVolume:" + paramFloat);
      this.mPlayer.setVolume(paramFloat, paramFloat);
    }
  }
  
  public void start()
  {
    if ((this.mState == 1) || (this.mState == 3)) {}
    try
    {
      ThreadManager.excute(this.mStartRunnable, 16, null, false);
      muteAudioFocus(this.audioFocus);
      if (this.mUiHandler != null) {
        this.mUiHandler.post(this.mLoopingRunnable);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("MiniAppAudioPlayer", 2, "resetMediaPlayer....." + localThrowable);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppAudioPlayer
 * JD-Core Version:    0.7.0.1
 */