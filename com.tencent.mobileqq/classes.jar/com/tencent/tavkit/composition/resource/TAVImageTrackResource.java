package com.tencent.tavkit.composition.resource;

import android.support.annotation.Nullable;
import com.tencent.tav.asset.CompositionTrackSegment;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.ImageDecoder;
import com.tencent.tavkit.ciimage.CIImage;
import java.util.HashMap;

public class TAVImageTrackResource
  extends TAVResource
{
  private boolean emptyAudioTrack;
  @Nullable
  private CGSize imageDecodeSize;
  private String path;
  
  public TAVImageTrackResource(String paramString, CMTime paramCMTime)
  {
    this(paramString, paramCMTime, false);
  }
  
  public TAVImageTrackResource(String paramString, CMTime paramCMTime, boolean paramBoolean)
  {
    this.path = paramString;
    this.emptyAudioTrack = paramBoolean;
    this.duration = paramCMTime;
    this.sourceTimeRange = new CMTimeRange(CMTime.CMTimeZero, paramCMTime);
  }
  
  public TAVImageTrackResource clone()
  {
    TAVImageTrackResource localTAVImageTrackResource = new TAVImageTrackResource(this.path, this.duration.clone());
    localTAVImageTrackResource.sourceTimeRange = this.sourceTimeRange.clone();
    localTAVImageTrackResource.scaledDuration = this.scaledDuration.clone();
    return localTAVImageTrackResource;
  }
  
  public String getPath()
  {
    return this.path;
  }
  
  public CIImage imageAtTime(CMTime paramCMTime, CGSize paramCGSize)
  {
    return null;
  }
  
  public void setImageDecodeSize(CGSize paramCGSize)
  {
    this.imageDecodeSize = paramCGSize;
  }
  
  @Nullable
  public TrackInfo trackInfoForType(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 1) && (!this.emptyAudioTrack)) {
      return null;
    }
    if (paramInt1 == 1) {
      paramInt1 = 3;
    }
    CompositionTrackSegment localCompositionTrackSegment = new CompositionTrackSegment(this.path, 0, this.sourceTimeRange, this.sourceTimeRange, paramInt1);
    if (this.imageDecodeSize != null)
    {
      localObject = new HashMap();
      ((HashMap)localObject).put(ImageDecoder.EXTRA_INFO_KEY_DECODE_SIZE, this.imageDecodeSize);
      localCompositionTrackSegment.setExtraInfo((HashMap)localObject);
    }
    Object localObject = new TrackInfo();
    ((TrackInfo)localObject).setCompositionTrackSegment(localCompositionTrackSegment);
    ((TrackInfo)localObject).setSelectedTimeRange(getSourceTimeRange());
    ((TrackInfo)localObject).setScaleToDuration(getScaledDuration());
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavkit.composition.resource.TAVImageTrackResource
 * JD-Core Version:    0.7.0.1
 */