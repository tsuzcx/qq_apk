package com.tencent.viola.core;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
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
    this.mMediaPlayer = new ReportMediaPlayer();
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
      Object localObject = (AudioPlayerManager.AudioManagerListener)this.mManagerListenerArray.get(this.mCurrentUniqueId);
      if (localObject != null) {
        ((AudioPlayerManager.AudioManagerListener)localObject).playPaused();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("pausing,pause audio,data:");
      ((StringBuilder)localObject).append(this.mCurrentDataSource);
      ((StringBuilder)localObject).append(",pasuedDuration:");
      ((StringBuilder)localObject).append(this.mMediaPlayer.getCurrentPosition());
      ViolaLogUtils.d("AudioPlayerManager", ((StringBuilder)localObject).toString());
    }
  }
  
  public void play(int paramInt)
  {
    try
    {
      Object localObject1 = (String)this.mAudioUrlArray.get(paramInt);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label377;
      }
      int i = this.mCurrentUniqueId;
      Object localObject2;
      if ((i == paramInt) && (((String)localObject1).equals(this.mCurrentDataSource)))
      {
        this.mMediaPlayer.start();
        localObject2 = (AudioPlayerManager.AudioManagerListener)this.mManagerListenerArray.get(this.mCurrentUniqueId);
        if (localObject2 != null) {
          if (((Integer)this.mPlayDurationArray.get(this.mCurrentUniqueId, Integer.valueOf(0))).intValue() == 0) {
            ((AudioPlayerManager.AudioManagerListener)localObject2).playStart();
          } else {
            ((AudioPlayerManager.AudioManagerListener)localObject2).playResume();
          }
        }
        timerChange();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("playing,resume current audio,data:");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(",startDuration:");
        ((StringBuilder)localObject2).append(this.mPlayDurationArray.get(this.mCurrentUniqueId));
        ViolaLogUtils.d("AudioPlayerManager", ((StringBuilder)localObject2).toString());
        return;
      }
      if (this.mMediaPlayer.isPlaying())
      {
        this.mMediaPlayer.pause();
        this.mPlayDurationArray.put(this.mCurrentUniqueId, Integer.valueOf(this.mMediaPlayer.getCurrentPosition()));
        localObject2 = (AudioPlayerManager.AudioManagerListener)this.mManagerListenerArray.get(this.mCurrentUniqueId);
        if (localObject2 != null) {
          ((AudioPlayerManager.AudioManagerListener)localObject2).playPaused();
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("playing,paused last audio,data:");
        ((StringBuilder)localObject2).append(this.mCurrentDataSource);
        ((StringBuilder)localObject2).append(",pasuedDuration:");
        ((StringBuilder)localObject2).append(this.mMediaPlayer.getCurrentPosition());
        ViolaLogUtils.d("AudioPlayerManager", ((StringBuilder)localObject2).toString());
      }
      this.mCurrentUniqueId = paramInt;
      this.mCurrentDataSource = ((String)localObject1);
      this.mMediaPlayer.reset();
      this.mMediaPlayer.setDataSource((String)localObject1);
      this.mMediaPlayer.prepareAsync();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("playing,play new audio,data:");
      ((StringBuilder)localObject1).append(this.mCurrentDataSource);
      ViolaLogUtils.d("AudioPlayerManager", ((StringBuilder)localObject1).toString());
      return;
    }
    catch (Exception localException)
    {
      label363:
      label377:
      break label363;
    }
    reset();
    this.mCurrentDataSource = null;
    this.mCurrentUniqueId = -1;
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
    MediaPlayer localMediaPlayer = this.mMediaPlayer;
    if (localMediaPlayer != null)
    {
      localMediaPlayer.stop();
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