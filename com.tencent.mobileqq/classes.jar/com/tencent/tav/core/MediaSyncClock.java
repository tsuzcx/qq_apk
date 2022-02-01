package com.tencent.tav.core;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.logger.Logger;

public class MediaSyncClock
{
  private static final String TAG = "MediaSyncClock";
  private final CMTime MAX_AHEAD = CMTime.fromMs(300L);
  private final CMTime MAX_DELAY = CMTime.fromMs(100L);
  private CMTime audioTime = CMTime.CMTimeZero;
  private boolean enable;
  private CMTime videoTime = CMTime.CMTimeZero;
  
  public MediaSyncClock(boolean paramBoolean)
  {
    this.enable = paramBoolean;
  }
  
  private void syncAudioInternal(CMTime paramCMTime)
  {
    try
    {
      try
      {
        while ((this.enable) && (paramCMTime.sub(this.MAX_AHEAD).bigThan(this.videoTime)))
        {
          Logger.i("MediaSyncClock", "syncAudio() wait");
          wait();
        }
        this.audioTime = paramCMTime;
      }
      finally
      {
        break label63;
      }
    }
    catch (InterruptedException paramCMTime)
    {
      label53:
      label63:
      break label53;
    }
    Logger.e("MediaSyncClock", "avSync interrupt");
    return;
    for (;;)
    {
      throw paramCMTime;
    }
  }
  
  private void syncVideoInternal(CMTime paramCMTime)
  {
    try
    {
      this.videoTime = paramCMTime;
      notify();
      return;
    }
    finally
    {
      paramCMTime = finally;
      throw paramCMTime;
    }
  }
  
  public void close()
  {
    try
    {
      this.enable = false;
      notifyAll();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void syncAudio(CMTime paramCMTime)
  {
    if (!this.enable) {
      return;
    }
    syncAudioInternal(paramCMTime);
  }
  
  public void syncVideo(CMTime paramCMTime)
  {
    if (!this.enable) {
      return;
    }
    syncVideoInternal(paramCMTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.core.MediaSyncClock
 * JD-Core Version:    0.7.0.1
 */