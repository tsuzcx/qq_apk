package com.tencent.mobileqq.tritonaudio.inneraudio;

import android.media.MediaPlayer;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MediaPlayerManager
{
  public static final String TAG = "[audio] MediaPlayerManager";
  private static MediaPlayerManager sInstance;
  private final ConcurrentLinkedQueue<MediaPlayer> mRealPlayers = new ConcurrentLinkedQueue();
  
  public static MediaPlayerManager getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new MediaPlayerManager();
      }
      return sInstance;
    }
    finally {}
  }
  
  public MediaPlayer dequeuePlayer()
  {
    MediaPlayer localMediaPlayer2 = (MediaPlayer)this.mRealPlayers.poll();
    MediaPlayer localMediaPlayer1 = localMediaPlayer2;
    if (localMediaPlayer2 == null) {}
    try
    {
      localMediaPlayer1 = new MediaPlayer();
      return localMediaPlayer1;
    }
    catch (Throwable localThrowable) {}
    return localMediaPlayer2;
  }
  
  public void enqueuePlayer(MediaPlayer paramMediaPlayer)
  {
    if (paramMediaPlayer != null) {
      this.mRealPlayers.add(paramMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.inneraudio.MediaPlayerManager
 * JD-Core Version:    0.7.0.1
 */