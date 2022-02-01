package com.tencent.tav.asset;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeMapping;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompositionTrack
  extends AssetTrack<CompositionTrackSegment>
{
  protected List<CompositionTrackSegment> segments = new ArrayList();
  
  CompositionTrack() {}
  
  CompositionTrack(Asset paramAsset, int paramInt1, int paramInt2, CMTimeRange paramCMTimeRange)
  {
    super(paramAsset, paramInt1, paramInt2, paramCMTimeRange);
  }
  
  public List<CompositionTrackSegment> getSegments()
  {
    return this.segments;
  }
  
  public CompositionTrackSegment segmentForTrackTime(CMTime paramCMTime)
  {
    Object localObject = this.segments;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        AssetTrackSegment localAssetTrackSegment = (AssetTrackSegment)((Iterator)localObject).next();
        if (localAssetTrackSegment != null)
        {
          CMTimeRange localCMTimeRange = localAssetTrackSegment.getTimeMapping().getTarget();
          if ((localCMTimeRange != null) && (localCMTimeRange.containsTime(paramCMTime)) && ((localAssetTrackSegment instanceof CompositionTrackSegment))) {
            return (CompositionTrackSegment)localAssetTrackSegment;
          }
        }
      }
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CompositionTrack{segments=");
    localStringBuilder.append(this.segments);
    localStringBuilder.append(", trackID=");
    localStringBuilder.append(this.trackID);
    localStringBuilder.append(", mediaType=");
    localStringBuilder.append(this.mediaType);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tav.asset.CompositionTrack
 * JD-Core Version:    0.7.0.1
 */