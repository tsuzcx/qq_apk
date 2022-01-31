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
    localObject1 = (MediaPlayer)this.realPlayers.poll();
    Object localObject2 = localObject1;
    if (localObject1 == null) {}
    try
    {
      localObject2 = new MediaPlayer();
      TTLog.e("[audio] MediaPlayerManager", "new MediaPlayer on dequeue - exception. ", localThrowable1);
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        TTLog.w("[audio] MediaPlayerManager", "new MediaPlayer on dequeue. " + localObject2);
        return localObject2;
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          localObject1 = localThrowable1;
          Object localObject3 = localThrowable2;
        }
      }
      localThrowable1 = localThrowable1;
    }
    return localObject1;
  }
  
  public void enqueuePlayer(MediaPlayer paramMediaPlayer)
  {
    if (paramMediaPlayer != null) {
      this.realPlayers.add(paramMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.audio.MediaPlayerManager
 * JD-Core Version:    0.7.0.1
 */