package com.tencent.tavkit.composition.resource;

import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.ciimage.CIImage;

public class TAVEmptyResource
  extends TAVResource
{
  private boolean insertTimeRange;
  private boolean provideEmptyImage;
  
  public TAVEmptyResource(CMTime paramCMTime)
  {
    this(paramCMTime, true);
  }
  
  public TAVEmptyResource(CMTime paramCMTime, boolean paramBoolean)
  {
    this(paramCMTime, paramBoolean, false);
  }
  
  public TAVEmptyResource(CMTime paramCMTime, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.provideEmptyImage = paramBoolean2;
    this.insertTimeRange = paramBoolean1;
    this.duration = paramCMTime;
    this.sourceTimeRange = new CMTimeRange(CMTime.CMTimeZero, paramCMTime);
  }
  
  public TAVResource clone()
  {
    TAVEmptyResource localTAVEmptyResource = new TAVEmptyResource(this.duration.clone());
    localTAVEmptyResource.insertTimeRange = this.insertTimeRange;
    localTAVEmptyResource.provideEmptyImage = this.provideEmptyImage;
    localTAVEmptyResource.sourceTimeRange = this.sourceTimeRange.clone();
    localTAVEmptyResource.scaledDuration = this.scaledDuration.clone();
    return localTAVEmptyResource;
  }
  
  public CIImage imageAtTime(CMTime paramCMTime, CGSize paramCGSize)
  {
    if (this.provideEmptyImage) {
      return new CIImage(paramCGSize);
    }
    return null;
  }
  
  public void setInsertTimeRange(boolean paramBoolean)
  {
    this.insertTimeRange = paramBoolean;
  }
  
  public void setProvideEmptyImage(boolean paramBoolean)
  {
    this.provideEmptyImage = paramBoolean;
  }
  
  public TrackInfo trackInfoForType(int paramInt1, int paramInt2)
  {
    if (!this.insertTimeRange) {
      return null;
    }
    return super.trackInfoForType(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavkit.composition.resource.TAVEmptyResource
 * JD-Core Version:    0.7.0.1
 */