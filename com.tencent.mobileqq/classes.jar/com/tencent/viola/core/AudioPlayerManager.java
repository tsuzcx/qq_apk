package com.tencent.viola.core;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.viola.utils.ViolaLogUtils;

public class AudioPlayerManager
{
  private static final String TAG = "AudioPlayerManager";
  private SparseArray<String> mAudioUrlArray = new SparseArray();
  private volatile String mCurrentDataSource;
  private volatile int mCurrentUniqueId;
  private Handler mHandler;
  private HandlerThread mHandlerThread = new HandlerThread("ViolaAudioPlayerThread");
  private SparseArray<AudioPlayerManager.AudioManagerListener> mManagerListenerArray = new SparseArray();
  private MediaPlayer mMediaPlayer;
  private SparseArray<Integer> mPlayDurationArray = new SparseArray();
  private Runnable mRunnable;
  private SparseArray<Integer> mTimeIntervalArray = new SparseArray();
  
  public AudioPlayerManager()
  {
    this.mHandlerThread.start();
    this.mHandler = new Handler(this.mHandlerThread.getLooper());
    this.mRunnable = new AudioPlayerManager.1(this);
    initMediaPlayer();
  }
  
  private void initMediaPlayer()
  {
    release();
    this.mMediaPlayer = new MediaPlayer();
    this.mMediaPlayer.setAudioStreamType(3);
    this.mMediaPlayer.setOnBufferingUpdateListener(new AudioPlayerManager.2(this));
    this.mMediaPlayer.setOnPreparedListener(new AudioPlayerManager.3(this));
    this.mMediaPlayer.setOnErrorListener(new AudioPlayerManager.4(this));
    this.mMediaPlayer.setOnCompletionListener(new AudioPlayerManager.5(this));
  }
  
  private void reset()
  {
    this.mMediaPlayer.reset();
  }
  
  private void timerChange()
  {
    this.mHandler.post(this.mRunnable);
  }
  
  public int getCurrentDuration()
  {
    return this.mMediaPlayer.getCurrentPosition();
  }
  
  public int getTotalDuration()
  {
    return this.mMediaPlayer.getDuration();
  }
  
  public void pause(int paramInt)
  {
    if ((this.mCurrentDataSource.equals(this.mAudioUrlArray.get(paramInt))) && (paramInt == this.mCurrentUniqueId) && (this.mMediaPlayer.isPlaying()))
    {
      this.mMediaPlayer.pause();
      this.mPlayDurationArray.put(this.mCurrentUniqueId, Integer.valueOf(this.mMediaPlayer.getCurrentPosition()));
      AudioPlayerManager.AudioManagerListener localAudioManagerListener = (AudioPlayerManager.AudioManagerListener)this.mManagerListenerArray.get(this.mCurrentUniqueId);
      if (localAudioManagerListener != null) {
        localAudioManagerListener.playPaused();
      }
      ViolaLogUtils.d("AudioPlayerManager", "pausing,pause audio,data:" + this.mCurrentDataSource + ",pasuedDuration:" + this.mMediaPlayer.getCurrentPosition());
    }
  }
  
  public void play(int paramInt)
  {
    try
    {
      String str = (String)this.mAudioUrlArray.get(paramInt);
      if (TextUtils.isEmpty(str)) {
        return;
      }
      if ((this.mCurrentUniqueId == paramInt) && (str.equals(this.mCurrentDataSource)))
      {
        this.mMediaPlayer.start();
        localAudioManagerListener = (AudioPlayerManager.AudioManagerListener)this.mManagerListenerArray.get(this.mCurrentUniqueId);
        if (localAudioManagerListener != null)
        {
          if (((Integer)this.mPlayDurationArray.get(this.mCurrentUniqueId, Integer.valueOf(0))).intValue() != 0) {
            break label142;
          }
          localAudioManagerListener.playStart();
        }
        for (;;)
        {
          timerChange();
          ViolaLogUtils.d("AudioPlayerManager", "playing,resume current audio,data:" + str + ",startDuration:" + this.mPlayDurationArray.get(this.mCurrentUniqueId));
          return;
          label142:
          localAudioManagerListener.playResume();
        }
      }
      if (!this.mMediaPlayer.isPlaying()) {
        break label272;
      }
    }
    catch (Exception localException)
    {
      reset();
      this.mCurrentDataSource = null;
      this.mCurrentUniqueId = -1;
      return;
    }
    this.mMediaPlayer.pause();
    this.mPlayDurationArray.put(this.mCurrentUniqueId, Integer.valueOf(this.mMediaPlayer.getCurrentPosition()));
    AudioPlayerManager.AudioManagerListener localAudioManagerListener = (AudioPlayerManager.AudioManagerListener)this.mManagerListenerArray.get(this.mCurrentUniqueId);
    if (localAudioManagerListener != null) {
      localAudioManagerListener.playPaused();
    }
    ViolaLogUtils.d("AudioPlayerManager", "playing,paused last audio,data:" + this.mCurrentDataSource + ",pasuedDuration:" + this.mMediaPlayer.getCurrentPosition());
    label272:
    this.mCurrentUniqueId = paramInt;
    this.mCurrentDataSource = localException;
    this.mMediaPlayer.reset();
    this.mMediaPlayer.setDataSource(localException);
    this.mMediaPlayer.prepareAsync();
    ViolaLogUtils.d("AudioPlayerManager", "playing,play new audio,data:" + this.mCurrentDataSource);
  }
  
  public void prepareData(int paramInt, String paramString, AudioPlayerManager.AudioManagerListener paramAudioManagerListener)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.mAudioUrlArray.put(paramInt, paramString);
    }
    if (paramAudioManagerListener != null) {
      this.mManagerListenerArray.put(paramInt, paramAudioManagerListener);
    }
  }
  
  public void release()
  {
    if (this.mMediaPlayer != null)
    {
      this.mMediaPlayer.stop();
      this.mMediaPlayer.reset();
      this.mMediaPlayer.release();
      this.mMediaPlayer = null;
      this.mManagerListenerArray.clear();
      this.mAudioUrlArray.clear();
      this.mTimeIntervalArray.clear();
      this.mPlayDurationArray.clear();
      this.mCurrentDataSource = null;
      this.mCurrentUniqueId = -1;
      this.mHandler.removeCallbacks(this.mRunnable);
    }
  }
  
  public void setTimeInterval(int paramInt1, int paramInt2)
  {
    this.mTimeIntervalArray.put(paramInt1, Integer.valueOf(paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.core.AudioPlayerManager
 * JD-Core Version:    0.7.0.1
 */