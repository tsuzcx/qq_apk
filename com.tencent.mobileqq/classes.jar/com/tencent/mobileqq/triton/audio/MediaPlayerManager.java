package com.tencent.mobileqq.triton.audio;

import android.media.MediaPlayer;
import com.tencent.mobileqq.triton.engine.TTLog;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MediaPlayerManager
{
  public static final String TAG = "[audio] MediaPlayerManager";
  private static MediaPlayerManager sInstance;
  private ConcurrentLinkedQueue<MediaPlayer> realPlayers = new ConcurrentLinkedQueue();
  
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
    MediaPlayer localMediaPlayer2 = (MediaPlayer)this.realPlayers.poll();
    MediaPlayer localMediaPlayer1 = localMediaPlayer2;
    if (localMediaPlayer2 == null)
    {
      localMediaPlayer1 = new MediaPlayer();
      TTLog.w("[audio] MediaPlayerManager", "new MediaPlayer on dequeue. " + localMediaPlayer1);
    }
    return localMediaPlayer1;
  }
  
  public void enqueuePlayer(MediaPlayer paramMediaPlayer)
  {
    if (paramMediaPlayer != null) {
      this.realPlayers.add(paramMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.audio.MediaPlayerManager
 * JD-Core Version:    0.7.0.1
 */