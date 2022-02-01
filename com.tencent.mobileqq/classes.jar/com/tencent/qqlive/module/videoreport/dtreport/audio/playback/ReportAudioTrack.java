package com.tencent.qqlive.module.videoreport.dtreport.audio.playback;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.support.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioPlayer;
import com.tencent.qqlive.module.videoreport.dtreport.audio.api.IAudioTrackListener;
import java.nio.ByteBuffer;

public class ReportAudioTrack
  extends AudioTrack
  implements IAudioPlayer, IAudioTrackListener
{
  private BaseAudioPlayerProxy mAudioProxy = new BaseAudioPlayerProxy(this);
  private long mTotalBytes;
  
  public ReportAudioTrack(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  public ReportAudioTrack(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
  }
  
  public ReportAudioTrack(AudioAttributes paramAudioAttributes, AudioFormat paramAudioFormat, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramAudioAttributes, paramAudioFormat, paramInt1, paramInt2, paramInt3);
  }
  
  private int bytesToDuration(long paramLong)
  {
    return (int)((float)paramLong * 1000.0F / getByteRate());
  }
  
  private int getByteRate()
  {
    return getSampleRate() * getChannelCount() * AudioUtil.getBytesPerSample(getAudioFormat());
  }
  
  private void handleErr(int paramInt)
  {
    if (paramInt < 0) {
      this.mAudioProxy.onAudioError(this, paramInt, paramInt);
    }
    if ((this.mTotalBytes >= getDtAudioStreamLength()) && (getDtAudioStreamLength() > 0L)) {
      this.mAudioProxy.onAudioCompletion(this);
    }
  }
  
  public final int getCurrentPosition__()
  {
    return bytesToDuration(this.mTotalBytes);
  }
  
  public long getDtAudioStreamLength()
  {
    return -1L;
  }
  
  public final int getDuration__()
  {
    return bytesToDuration(getDtAudioStreamLength());
  }
  
  public final String getPlayerId__()
  {
    return "AudioTrack_" + hashCode();
  }
  
  public final int getPlayerType__()
  {
    return 101;
  }
  
  public final boolean isAudioPlayer__()
  {
    return true;
  }
  
  public void pause()
  {
    super.pause();
    this.mAudioProxy.pause();
  }
  
  public void play()
  {
    super.play();
    if (!this.mAudioProxy.isPaused())
    {
      this.mAudioProxy.prepare();
      this.mAudioProxy.onAudioPrepared(this);
    }
    this.mAudioProxy.start();
  }
  
  public void stop()
  {
    super.stop();
    this.mAudioProxy.stop();
    this.mAudioProxy.reset();
    this.mTotalBytes = 0L;
  }
  
  public int write(@NonNull ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
  {
    this.mTotalBytes += paramInt1;
    paramInt1 = super.write(paramByteBuffer, paramInt1, paramInt2);
    handleErr(paramInt1);
    return paramInt1;
  }
  
  public int write(@NonNull ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, long paramLong)
  {
    this.mTotalBytes += paramInt1;
    paramInt1 = super.write(paramByteBuffer, paramInt1, paramInt2, paramLong);
    handleErr(paramInt1);
    return paramInt1;
  }
  
  public int write(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mTotalBytes += paramInt2;
    paramInt1 = super.write(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
    handleErr(paramInt1);
    return paramInt1;
  }
  
  public int write(@NonNull float[] paramArrayOfFloat, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mTotalBytes += AudioUtil.floatByteCount() * paramInt2;
    paramInt1 = super.write(paramArrayOfFloat, paramInt1, paramInt2, paramInt3);
    handleErr(paramInt1);
    return paramInt1;
  }
  
  public int write(@NonNull short[] paramArrayOfShort, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mTotalBytes += AudioUtil.shortByteSize() * paramInt2;
    paramInt1 = super.write(paramArrayOfShort, paramInt1, paramInt2, paramInt3);
    handleErr(paramInt1);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportAudioTrack
 * JD-Core Version:    0.7.0.1
 */