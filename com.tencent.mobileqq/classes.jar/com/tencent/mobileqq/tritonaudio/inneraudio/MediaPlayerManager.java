package com.tencent.mobileqq.tritonaudio.inneraudio;

import android.media.MediaPlayer;
import android.util.Log;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MediaPlayerManager
{
  public static final String TAG = "MediaPlayerManager";
  private static MediaPlayerManager sInstance;
  private final ConcurrentLinkedQueue<MediaPlayer> mRealPlayers = new ConcurrentLinkedQueue();
  
  public static MediaPlayerManager getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new MediaPlayerManager();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  public MediaPlayer dequeuePlayer()
  {
    MediaPlayer localMediaPlayer = (MediaPlayer)this.mRealPlayers.poll();
    if (localMediaPlayer == null) {
      try
      {
        ReportMediaPlayer localReportMediaPlayer = new ReportMediaPlayer();
        return localReportMediaPlayer;
      }
      catch (Throwable localThrowable)
      {
        Log.e("MediaPlayerManager", "dequeuePlayer: ", localThrowable);
      }
    }
    return localMediaPlayer;
  }
  
  public void enqueuePlayer(MediaPlayer paramMediaPlayer)
  {
    if (paramMediaPlayer != null) {
      this.mRealPlayers.add(paramMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.inneraudio.MediaPlayerManager
 * JD-Core Version:    0.7.0.1
 */