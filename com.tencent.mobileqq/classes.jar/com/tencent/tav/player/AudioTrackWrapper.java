package com.tencent.tav.player;

import android.media.AudioTrack;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.util.Log;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportAudioTrack;
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
    if (paramInt1 <= 0) {
      return;
    }
    AudioTrackWrapper.AudioTrackConfig localAudioTrackConfig = new AudioTrackWrapper.AudioTrackConfig(paramInt1, paramInt2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("init:--> ");
    localStringBuilder.append(this);
    Log.d("AudioTrackWrapper", localStringBuilder.toString());
    try
    {
      this.mAudioTrack = new ReportAudioTrack(localAudioTrackConfig.streamType, localAudioTrackConfig.sampleRateInHz, localAudioTrackConfig.channelConfig, localAudioTrackConfig.audioFormat, localAudioTrackConfig.bufferSizeInBytes, localAudioTrackConfig.mode);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localIllegalArgumentException.printStackTrace();
      this.mAudioTrack = null;
    }
    AudioTrack localAudioTrack = this.mAudioTrack;
    if (localAudioTrack != null) {
      localAudioTrack.play();
    }
  }
  
  public boolean allow()
  {
    return this.mAudioTrack != null;
  }
  
  public void flush()
  {
    if (!allow()) {
      return;
    }
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
      Logger.e("AudioTrackWrapper", "flush: ", localException);
    }
  }
  
  public void parse()
  {
    if (!allow()) {
      return;
    }
    AudioTrack localAudioTrack = this.mAudioTrack;
    if ((localAudioTrack != null) && (localAudioTrack.getPlayState() == 3)) {
      this.mAudioTrack.pause();
    }
  }
  
  public void release()
  {
    if (!allow()) {
      return;
    }
    stop();
    this.mAudioTrack.release();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("release:--> ");
    localStringBuilder.append(this);
    Log.d("AudioTrackWrapper", localStringBuilder.toString());
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
    if (!allow()) {
      return;
    }
    if ((this.mAudioTrack.getState() == 3) || (this.mAudioTrack.getState() == 2)) {
      this.mAudioTrack.stop();
    }
  }
  
  public void writeData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!allow()) {
      return;
    }
    AudioTrack localAudioTrack = this.mAudioTrack;
    if (localAudioTrack != null) {
      try
      {
        localAudioTrack.write(paramArrayOfByte, paramInt1, paramInt2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.player.AudioTrackWrapper
 * JD-Core Version:    0.7.0.1
 */