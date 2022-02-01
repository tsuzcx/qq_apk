package com.tencent.tav.decoder;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.AssetTrackSegment;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeMapping;
import com.tencent.tav.coremedia.CMTimeRange;

public class DecoderTrackSegment
{
  private CMTime decoderStartTime;
  private CMTime scaledDuration;
  private CMTimeRange timeRange;
  private DecoderAssetTrack videoAsset;
  
  public DecoderTrackSegment(long paramLong)
  {
    this(new CMTimeRange(CMTime.CMTimeZero, new CMTime((float)paramLong / 1000.0F)), null);
  }
  
  public DecoderTrackSegment(AssetTrack paramAssetTrack, AssetTrackSegment paramAssetTrackSegment)
  {
    this(paramAssetTrackSegment.getTimeMapping().getSource().clone(), DecoderAssetTrack.create(paramAssetTrack, paramAssetTrackSegment));
    setScaledDuration(paramAssetTrackSegment.getScaleDuration());
  }
  
  public DecoderTrackSegment(@NonNull CMTimeRange paramCMTimeRange, @Nullable DecoderAssetTrack paramDecoderAssetTrack)
  {
    this.videoAsset = paramDecoderAssetTrack;
    this.timeRange = paramCMTimeRange;
    this.scaledDuration = paramCMTimeRange.getDuration();
    this.decoderStartTime = CMTime.CMTimeZero;
  }
  
  public CMTime getDecoderStartTime()
  {
    return this.decoderStartTime;
  }
  
  public CMTime getScaledDuration()
  {
    return this.scaledDuration;
  }
  
  @NonNull
  public CMTimeRange getTimeRange()
  {
    return this.timeRange;
  }
  
  @Nullable
  public DecoderAssetTrack getVideoAsset()
  {
    return this.videoAsset;
  }
  
  public void setScaledDuration(CMTime paramCMTime)
  {
    this.scaledDuration = paramCMTime;
  }
  
  public void setTimeRange(@NonNull CMTimeRange paramCMTimeRange)
  {
    this.timeRange = paramCMTimeRange;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.decoder.DecoderTrackSegment
 * JD-Core Version:    0.7.0.1
 */