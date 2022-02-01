package com.tencent.tavkit.composition.resource;

import android.support.annotation.Nullable;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.ciimage.CIImage;
import java.util.HashMap;

@Deprecated
public class TAVImageResource
  extends TAVResource
{
  private HashMap<Thread, CIImage> ciImageHashMap = new HashMap();
  private boolean emptyAudioTrack;
  private CIImage image;
  
  public TAVImageResource(CIImage paramCIImage, CMTime paramCMTime)
  {
    this(paramCIImage, paramCMTime, false);
  }
  
  public TAVImageResource(CIImage paramCIImage, CMTime paramCMTime, boolean paramBoolean)
  {
    this.image = paramCIImage;
    this.duration = paramCMTime;
    this.sourceTimeRange = new CMTimeRange(CMTime.CMTimeZero, paramCMTime);
    this.emptyAudioTrack = paramBoolean;
  }
  
  public TAVResource clone()
  {
    TAVImageResource localTAVImageResource = new TAVImageResource(this.image, this.duration.clone());
    localTAVImageResource.sourceTimeRange = this.sourceTimeRange.clone();
    localTAVImageResource.scaledDuration = this.scaledDuration.clone();
    localTAVImageResource.ciImageHashMap = this.ciImageHashMap;
    return localTAVImageResource;
  }
  
  public CIImage imageAtTime(CMTime paramCMTime, CGSize paramCGSize)
  {
    if (!this.sourceTimeRange.containsTime(paramCMTime)) {
      return null;
    }
    if (this.image == null) {
      return null;
    }
    Thread localThread = Thread.currentThread();
    paramCGSize = (CIImage)this.ciImageHashMap.get(localThread);
    paramCMTime = paramCGSize;
    if (paramCGSize == null)
    {
      paramCMTime = this.image.simpleClone();
      this.ciImageHashMap.put(localThread, paramCMTime);
    }
    paramCMTime.reset();
    return paramCMTime;
  }
  
  @Nullable
  public TrackInfo trackInfoForType(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      return newEmptyTrackInfo(paramInt1, paramInt2);
    }
    if ((this.emptyAudioTrack) && (paramInt1 == 2)) {
      return newEmptyTrackInfo(paramInt1, paramInt2);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavkit.composition.resource.TAVImageResource
 * JD-Core Version:    0.7.0.1
 */