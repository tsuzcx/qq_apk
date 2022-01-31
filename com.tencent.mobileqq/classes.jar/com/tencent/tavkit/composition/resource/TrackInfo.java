package com.tencent.tavkit.composition.resource;

import android.support.annotation.Nullable;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.CompositionTrackSegment;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeMapping;
import com.tencent.tav.coremedia.CMTimeRange;

public class TrackInfo
{
  private CompositionTrackSegment compositionTrackSegment;
  private CMTime scaleToDuration;
  private CMTimeRange selectedTimeRange;
  @Nullable
  private AssetTrack track;
  
  public CompositionTrackSegment getCompositionTrackSegment(CMTimeRange paramCMTimeRange)
  {
    return new CompositionTrackSegment(this.compositionTrackSegment.getSourcePath(), this.compositionTrackSegment.getSourceTrackID(), this.compositionTrackSegment.getTimeMapping().getSource(), paramCMTimeRange, this.compositionTrackSegment.getSourceType());
  }
  
  public int getMediaType()
  {
    int i;
    if (this.track != null) {
      i = this.track.getMediaType();
    }
    int j;
    do
    {
      return i;
      if (this.compositionTrackSegment == null) {
        break;
      }
      j = this.compositionTrackSegment.getSourceType();
      i = j;
    } while (j != 3);
    return 1;
    return 0;
  }
  
  public CMTime getScaleToDuration()
  {
    return this.scaleToDuration;
  }
  
  public CMTimeRange getSelectedTimeRange()
  {
    return this.selectedTimeRange;
  }
  
  @Nullable
  public AssetTrack getTrack()
  {
    return this.track;
  }
  
  public void setCompositionTrackSegment(CompositionTrackSegment paramCompositionTrackSegment)
  {
    this.compositionTrackSegment = paramCompositionTrackSegment;
  }
  
  public void setScaleToDuration(CMTime paramCMTime)
  {
    this.scaleToDuration = paramCMTime;
  }
  
  public void setSelectedTimeRange(CMTimeRange paramCMTimeRange)
  {
    this.selectedTimeRange = paramCMTimeRange;
  }
  
  public void setTrack(AssetTrack paramAssetTrack)
  {
    this.track = paramAssetTrack;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavkit.composition.resource.TrackInfo
 * JD-Core Version:    0.7.0.1
 */