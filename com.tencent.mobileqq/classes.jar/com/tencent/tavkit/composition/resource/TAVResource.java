package com.tencent.tavkit.composition.resource;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.MutableComposition;
import com.tencent.tav.asset.MutableCompositionTrack;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.ciimage.CIImage;
import java.util.ArrayList;
import java.util.List;

public abstract class TAVResource
  implements Cloneable
{
  @NonNull
  protected CMTime duration = CMTime.CMTimeZero;
  @NonNull
  protected CMTime scaledDuration = CMTime.CMTimeInvalid;
  @NonNull
  protected CMTimeRange sourceTimeRange = new CMTimeRange(CMTime.CMTimeZero, CMTime.CMTimeZero);
  
  public abstract TAVResource clone();
  
  public CMTime getDuration()
  {
    return this.duration;
  }
  
  public CMTime getScaledDuration()
  {
    if (this.scaledDuration.equals(CMTime.CMTimeInvalid)) {
      return this.sourceTimeRange.getDuration();
    }
    return this.scaledDuration;
  }
  
  @NonNull
  public CMTimeRange getSourceTimeRange()
  {
    return this.sourceTimeRange;
  }
  
  public CIImage imageAtTime(CMTime paramCMTime, CGSize paramCGSize)
  {
    return null;
  }
  
  @NonNull
  protected TrackInfo newEmptyTrackInfo(int paramInt1, int paramInt2)
  {
    Object localObject = (AssetTrack)tracksForType(paramInt1).get(paramInt2);
    TrackInfo localTrackInfo = new TrackInfo();
    localTrackInfo.setTrack((AssetTrack)localObject);
    localObject = new CMTime(1L, 30);
    localTrackInfo.setSelectedTimeRange(new CMTimeRange(CMTime.CMTimeZero, (CMTime)localObject));
    localTrackInfo.setScaleToDuration(getScaledDuration());
    return localTrackInfo;
  }
  
  public void setDuration(@NonNull CMTime paramCMTime)
  {
    this.duration = paramCMTime;
  }
  
  public void setScaledDuration(@NonNull CMTime paramCMTime)
  {
    this.scaledDuration = paramCMTime;
  }
  
  public void setSourceTimeRange(@NonNull CMTimeRange paramCMTimeRange)
  {
    this.sourceTimeRange = paramCMTimeRange.clone();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TAVResource{duration=");
    localStringBuilder.append(this.duration.getTimeUs());
    localStringBuilder.append(", sourceTimeRange=");
    localStringBuilder.append(this.sourceTimeRange.toSimpleString());
    localStringBuilder.append(", scaledDuration=");
    localStringBuilder.append(this.scaledDuration.getTimeUs());
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  @Nullable
  public TrackInfo trackInfoForType(int paramInt1, int paramInt2)
  {
    return newEmptyTrackInfo(paramInt1, paramInt2);
  }
  
  public List<AssetTrack> tracksForType(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    MutableCompositionTrack localMutableCompositionTrack = new MutableComposition().addMutableTrackWithMediaType(paramInt, 0);
    localMutableCompositionTrack.insertEmptyTimeRange(new CMTimeRange(CMTime.CMTimeZero, this.duration));
    localArrayList.add(localMutableCompositionTrack);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavkit.composition.resource.TAVResource
 * JD-Core Version:    0.7.0.1
 */