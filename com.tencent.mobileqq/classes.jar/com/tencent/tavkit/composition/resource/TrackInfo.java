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
    paramCMTimeRange = new CompositionTrackSegment(this.compositionTrackSegment.getSourcePath(), this.compositionTrackSegment.getSourceTrackID(), this.compositionTrackSegment.getTimeMapping().getSource(), paramCMTimeRange, this.compositionTrackSegment.getSourceType());
    paramCMTimeRange.setExtraInfo(this.compositionTrackSegment.getExtraInfo());
    return paramCMTimeRange;
  }
  
  public int getMediaType()
  {
    Object localObject = this.track;
    if (localObject != null) {
      return ((AssetTrack)localObject).getMediaType();
    }
    localObject = this.compositionTrackSegment;
    if (localObject != null)
    {
      int j = ((CompositionTrackSegment)localObject).getSourceType();
      int i = j;
      if (j == 3) {
        i = 1;
      }
      return i;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavkit.composition.resource.TrackInfo
 * JD-Core Version:    0.7.0.1
 */