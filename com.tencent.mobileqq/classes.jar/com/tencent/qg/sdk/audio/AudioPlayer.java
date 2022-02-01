package com.tencent.qg.sdk.audio;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

public class AudioPlayer
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener
{
  protected static final int MSG_PAUSE = 3;
  protected static final int MSG_PLAY = 1;
  protected static final int MSG_SEEK = 4;
  protected static final int MSG_STOP = 2;
  public static final String TAG = "AudioPlayer";
  protected Context mContext;
  protected int mCurrentPos = -1;
  protected boolean mIsLoop = false;
  protected AudioPlayer.PlayHandler mPlayHandler;
  protected HandlerThread mPlayThread;
  protected MediaPlayer mPlayer;
  protected long mPlayerHandle;
  protected String mSrc;
  protected float mVolume = 1.0F;
  
  public AudioPlayer(Context paramContext, long paramLong)
  {
    this.mContext = paramContext;
    this.mPlayerHandle = paramLong;
  }
  
  protected void checkAudioThread()
  {
    if (this.mPlayThread == null)
    {
      this.mPlayThread = new HandlerThread("audio_play_thread");
      this.mPlayThread.start();
      this.mPlayHandler = new AudioPlayer.PlayHandler(this, this.mPlayThread.getLooper());
    }
  }
  
  public int getCurrentTime()
  {
    int i = this.mCurrentPos;
    if (i > 0) {
      return i;
    }
    return 0;
  }
  
  protected void handlePause()
  {
    MediaPlayer localMediaPlayer = this.mPlayer;
    if (localMediaPlayer == null)
    {
      Log.e("AudioPlayer", "pause failed : player is null? why??");
      return;
    }
    this.mCurrentPos = localMediaPlayer.getCurrentPosition();
    release();
  }
  
  protected void handlePlay()
  {
    if (TextUtils.isEmpty(this.mSrc))
    {
      Log.e("AudioPlayer", "play failed : please set src first!");
      return;
    }
    MediaPlayer localMediaPlayer = this.mPlayer;
    if (localMediaPlayer != null)
    {
      if (localMediaPlayer.isPlaying()) {
        this.mPlayer.stop();
      }
      MediaPlayerPool.getInstance().recycleMediaPlayer(this.mPlayer);
    }
    this.mPlayer = MediaPlayerPool.getInstance(this).applyMediaPlayer(this.mSrc, this, this, this);
    localMediaPlayer = this.mPlayer;
    if (localMediaPlayer == null)
    {
      Log.e("AudioPlayer", "play failed : apply media player failed.");
      return;
    }
    localMediaPlayer.setLooping(this.mIsLoop);
    localMediaPlayer = this.mPlayer;
    float f = this.mVolume;
    localMediaPlayer.setVolume(f, f);
    int i = this.mCurrentPos;
    if (i > 0) {
      this.mPlayer.seekTo(i);
    }
  }
  
  protected void handleSeekTo(int paramInt)
  {
    MediaPlayer localMediaPlayer = this.mPlayer;
    if (localMediaPlayer == null)
    {
      Log.e("AudioPlayer", "seek failed : player is null");
      return;
    }
    localMediaPlayer.seekTo(paramInt);
  }
  
  protected void handleStop()
  {
    if (this.mPlayer == null)
    {
      Log.e("AudioPlayer", "stop failed : player is null? why??");
      return;
    }
    this.mCurrentPos = -1;
    release();
  }
  
  public boolean isEnd()
  {
    return false;
  }
  
  protected native void nativeEnded(long paramLong);
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    Log.d("AudioPlayer", "onCompletetion");
    nativeEnded(this.mPlayerHandle);
    this.mCurrentPos = -1;
    release();
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    paramMediaPlayer = new StringBuilder();
    paramMediaPlayer.append("onError:");
    paramMediaPlayer.append(paramInt1);
    Log.e("AudioPlayer", paramMediaPlayer.toString());
    release();
    return false;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    Log.e("AudioPlayer", "onPrepared");
    try
    {
      this.mPlayer.start();
      return;
    }
    catch (IllegalStateException paramMediaPlayer)
    {
      label16:
      break label16;
    }
    Log.e("AudioPlayer", "play failed : IllegalStateException.");
  }
  
  public void pause()
  {
    if (this.mPlayHandler != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 3;
      this.mPlayHandler.sendMessage(localMessage);
    }
  }
  
  public void play()
  {
    checkAudioThread();
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    this.mPlayHandler.sendMessage(localMessage);
  }
  
  protected void release()
  {
    if (this.mPlayer != null) {
      MediaPlayerPool.getInstance().releaseMediaPlayer(this.mPlayer);
    }
    this.mPlayer = null;
  }
  
  public void releaseThread()
  {
    HandlerThread localHandlerThread = this.mPlayThread;
    if (localHandlerThread != null)
    {
      localHandlerThread.getLooper().quit();
      this.mPlayThread = null;
    }
    this.mPlayHandler = null;
  }
  
  public void seek(int paramInt)
  {
    if (this.mPlayHandler != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 4;
      localMessage.obj = Integer.valueOf(paramInt);
      this.mPlayHandler.sendMessage(localMessage);
    }
  }
  
  public void setLoop(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AudioPlayer:");
    localStringBuilder.append(this);
    localStringBuilder.append(", setLoop:");
    localStringBuilder.append(paramBoolean);
    Log.d("AudioPlayer", localStringBuilder.toString());
    this.mIsLoop = paramBoolean;
  }
  
  public void setSrc(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AudioPlayer:");
    localStringBuilder.append(this);
    localStringBuilder.append(", setSrc:");
    localStringBuilder.append(paramString);
    Log.d("AudioPlayer", localStringBuilder.toString());
    this.mSrc = paramString;
  }
  
  public void setVolume(float paramFloat)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AudioPlayer:");
    localStringBuilder.append(this);
    localStringBuilder.append(", setVolume:");
    localStringBuilder.append(paramFloat);
    Log.d("AudioPlayer", localStringBuilder.toString());
    this.mVolume = paramFloat;
  }
  
  public void stop()
  {
    if (this.mPlayHandler != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 2;
      this.mPlayHandler.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qg.sdk.audio.AudioPlayer
 * JD-Core Version:    0.7.0.1
 */