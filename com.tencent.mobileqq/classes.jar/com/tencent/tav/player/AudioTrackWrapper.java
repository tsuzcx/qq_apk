package com.tencent.tav.player;

import android.media.AudioTrack;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.util.Log;
import com.tencent.tav.decoder.logger.Logger;

public class AudioTrackWrapper
{
  private static final String TAG = "AudioTrackWrapper";
  private AudioTrack mAudioTrack;
  
  public AudioTrackWrapper(int paramInt1, int paramInt2)
  {
    try
    {
      init(paramInt1, paramInt2);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public AudioTrackWrapper(MediaFormat paramMediaFormat)
  {
    try
    {
      init(paramMediaFormat.getInteger("sample-rate"), paramMediaFormat.getInteger("channel-count"));
      return;
    }
    catch (Exception paramMediaFormat)
    {
      paramMediaFormat.printStackTrace();
    }
  }
  
  private void init(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= 0) {}
    for (;;)
    {
      return;
      AudioTrackWrapper.AudioTrackConfig localAudioTrackConfig = new AudioTrackWrapper.AudioTrackConfig(paramInt1, paramInt2);
      Log.d("AudioTrackWrapper", "init:--> " + this);
      try
      {
        this.mAudioTrack = new AudioTrack(localAudioTrackConfig.streamType, localAudioTrackConfig.sampleRateInHz, localAudioTrackConfig.channelConfig, localAudioTrackConfig.audioFormat, localAudioTrackConfig.bufferSizeInBytes, localAudioTrackConfig.mode);
        if (this.mAudioTrack == null) {
          continue;
        }
        this.mAudioTrack.play();
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          localIllegalArgumentException.printStackTrace();
          this.mAudioTrack = null;
        }
      }
    }
  }
  
  public boolean allow()
  {
    return this.mAudioTrack != null;
  }
  
  public void flush()
  {
    if (!allow()) {}
    for (;;)
    {
      return;
      try
      {
        if (this.mAudioTrack != null)
        {
          this.mAudioTrack.flush();
          return;
        }
      }
      catch (Exception localException)
      {
        Logger.e("AudioTrackWrapper", localException);
      }
    }
  }
  
  public void parse()
  {
    if (!allow()) {}
    while ((this.mAudioTrack == null) || (this.mAudioTrack.getPlayState() != 3)) {
      return;
    }
    this.mAudioTrack.pause();
  }
  
  public void release()
  {
    if (!allow()) {
      return;
    }
    stop();
    this.mAudioTrack.release();
    Log.d("AudioTrackWrapper", "release:--> " + this);
  }
  
  public void setVolume(float paramFloat)
  {
    if (!allow()) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.mAudioTrack.setVolume(paramFloat);
      return;
    }
    this.mAudioTrack.setStereoVolume(paramFloat, paramFloat);
  }
  
  public void stop()
  {
    if (!allow()) {}
    while ((this.mAudioTrack.getState() != 3) && (this.mAudioTrack.getState() != 2)) {
      return;
    }
    this.mAudioTrack.stop();
  }
  
  public void writeData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!allow()) {}
    for (;;)
    {
      return;
      if (this.mAudioTrack != null) {
        try
        {
          this.mAudioTrack.write(paramArrayOfByte, paramInt1, paramInt2);
          if (this.mAudioTrack.getPlayState() != 3)
          {
            this.mAudioTrack.play();
            return;
          }
        }
        catch (Exception paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.tav.player.AudioTrackWrapper
 * JD-Core Version:    0.7.0.1
 */