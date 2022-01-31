package com.tencent.tav.core.composition;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.Transform;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MutableVideoCompositionLayerInstruction
  implements VideoCompositionLayerInstruction
{
  private AssetTrack assetTrack;
  private List<VideoCompositionLayerInstruction.CropRectangleRamp> cropRectangleRampList = new ArrayList();
  private CMTime duration = new CMTime(2147483647L);
  private boolean flipX = false;
  private boolean flipY = false;
  private List<VideoCompositionLayerInstruction.OpacityRamp> opacityRampList = new ArrayList();
  private int trackID;
  private List<VideoCompositionLayerInstruction.TransformRamp> transformRampList = new ArrayList();
  
  public MutableVideoCompositionLayerInstruction() {}
  
  public MutableVideoCompositionLayerInstruction(int paramInt)
  {
    this.trackID = paramInt;
  }
  
  public MutableVideoCompositionLayerInstruction(@NonNull AssetTrack paramAssetTrack)
  {
    this.trackID = paramAssetTrack.getTrackID();
    this.assetTrack = paramAssetTrack;
    this.duration = paramAssetTrack.getDuration();
  }
  
  @NonNull
  public VideoCompositionLayerInstruction.CropRectangleRamp getCropRectangleRampForTime(CMTime paramCMTime)
  {
    Iterator localIterator = this.cropRectangleRampList.iterator();
    while (localIterator.hasNext())
    {
      VideoCompositionLayerInstruction.CropRectangleRamp localCropRectangleRamp = (VideoCompositionLayerInstruction.CropRectangleRamp)localIterator.next();
      if (localCropRectangleRamp.timeRange.containsTime(paramCMTime)) {
        return localCropRectangleRamp;
      }
    }
    return new VideoCompositionLayerInstruction.CropRectangleRamp(new CMTimeRange(CMTime.CMTimeZero, this.duration));
  }
  
  @NonNull
  public VideoCompositionLayerInstruction.OpacityRamp getOpacityRampForTime(CMTime paramCMTime)
  {
    Iterator localIterator = this.opacityRampList.iterator();
    while (localIterator.hasNext())
    {
      VideoCompositionLayerInstruction.OpacityRamp localOpacityRamp = (VideoCompositionLayerInstruction.OpacityRamp)localIterator.next();
      if (localOpacityRamp.timeRange.containsTime(paramCMTime)) {
        return localOpacityRamp;
      }
    }
    return new VideoCompositionLayerInstruction.OpacityRamp(new CMTimeRange(CMTime.CMTimeZero, this.duration));
  }
  
  public int getTrackID()
  {
    return this.trackID;
  }
  
  @NonNull
  public VideoCompositionLayerInstruction.TransformRamp getTransformRampForTime(CMTime paramCMTime)
  {
    Iterator localIterator = this.transformRampList.iterator();
    while (localIterator.hasNext())
    {
      VideoCompositionLayerInstruction.TransformRamp localTransformRamp = (VideoCompositionLayerInstruction.TransformRamp)localIterator.next();
      if (localTransformRamp.timeRange.containsTime(paramCMTime)) {
        return localTransformRamp;
      }
    }
    return new VideoCompositionLayerInstruction.TransformRamp(new CMTimeRange(CMTime.CMTimeZero, this.duration));
  }
  
  public void setCropRectangle(CGRect paramCGRect, @NonNull CMTime paramCMTime)
  {
    CMTime localCMTime = this.duration;
    Iterator localIterator = this.cropRectangleRampList.iterator();
    while (localIterator.hasNext())
    {
      VideoCompositionLayerInstruction.CropRectangleRamp localCropRectangleRamp = (VideoCompositionLayerInstruction.CropRectangleRamp)localIterator.next();
      if (localCropRectangleRamp.timeRange.containsTime(paramCMTime))
      {
        localCMTime = localCropRectangleRamp.timeRange.getEnd();
        localCropRectangleRamp.timeRange = new CMTimeRange(localCropRectangleRamp.timeRange.getStart(), paramCMTime.sub(localCropRectangleRamp.timeRange.getStart()));
      }
    }
    for (;;)
    {
      paramCMTime = new VideoCompositionLayerInstruction.CropRectangleRamp(new CMTimeRange(paramCMTime, localCMTime.sub(paramCMTime)));
      paramCMTime.startCropRectangle = paramCGRect;
      paramCMTime.endCropRectangle = paramCGRect;
      this.cropRectangleRampList.add(paramCMTime);
      return;
    }
  }
  
  public void setCropRectangleRampFromStartCropRectangle(CGRect paramCGRect1, CGRect paramCGRect2, @NonNull CMTimeRange paramCMTimeRange)
  {
    VideoCompositionLayerInstruction.CropRectangleRamp localCropRectangleRamp = new VideoCompositionLayerInstruction.CropRectangleRamp(paramCMTimeRange);
    localCropRectangleRamp.startCropRectangle = paramCGRect1;
    localCropRectangleRamp.endCropRectangle = paramCGRect2;
    paramCGRect1 = this.cropRectangleRampList.iterator();
    CMTime localCMTime;
    if (paramCGRect1.hasNext())
    {
      paramCGRect1 = (VideoCompositionLayerInstruction.CropRectangleRamp)paramCGRect1.next();
      paramCGRect2 = paramCGRect1.timeRange.getStart();
      localCMTime = paramCGRect1.timeRange.getEnd();
      if ((!paramCMTimeRange.containsTime(paramCGRect2)) || (!paramCMTimeRange.containsTime(localCMTime))) {
        break label164;
      }
      paramCGRect1.timeRange = CMTimeRange.CMTimeRangeInvalid;
    }
    for (;;)
    {
      int j;
      for (int i = 0; i < this.cropRectangleRampList.size(); i = j + 1)
      {
        paramCGRect1 = (VideoCompositionLayerInstruction.CropRectangleRamp)this.cropRectangleRampList.get(i);
        j = i;
        if (paramCGRect1.timeRange == CMTimeRange.CMTimeRangeInvalid)
        {
          this.cropRectangleRampList.remove(paramCGRect1);
          j = i - 1;
        }
      }
      label164:
      if ((paramCMTimeRange.containsTime(paramCGRect2)) && (!paramCMTimeRange.containsTime(localCMTime))) {
        paramCGRect1.timeRange = new CMTimeRange(paramCMTimeRange.getEnd(), paramCGRect1.timeRange.getEnd().sub(paramCMTimeRange.getEnd()));
      } else if ((paramCMTimeRange.containsTime(localCMTime)) && (!paramCMTimeRange.containsTime(paramCGRect2))) {
        paramCGRect1.timeRange = new CMTimeRange(paramCGRect1.timeRange.getStart(), paramCMTimeRange.getStart().sub(paramCGRect1.timeRange.getStart()));
      }
    }
    this.cropRectangleRampList.add(localCropRectangleRamp);
  }
  
  public void setFlipX(boolean paramBoolean)
  {
    this.flipX = paramBoolean;
  }
  
  public void setFlipY(boolean paramBoolean)
  {
    this.flipY = paramBoolean;
  }
  
  public void setOpacity(float paramFloat, @NonNull CMTime paramCMTime)
  {
    CMTime localCMTime = this.duration;
    Iterator localIterator = this.opacityRampList.iterator();
    while (localIterator.hasNext())
    {
      VideoCompositionLayerInstruction.OpacityRamp localOpacityRamp = (VideoCompositionLayerInstruction.OpacityRamp)localIterator.next();
      if (localOpacityRamp.timeRange.containsTime(paramCMTime))
      {
        localCMTime = localOpacityRamp.timeRange.getEnd();
        localOpacityRamp.timeRange = new CMTimeRange(localOpacityRamp.timeRange.getStart(), paramCMTime.sub(localOpacityRamp.timeRange.getStart()));
      }
    }
    for (;;)
    {
      paramCMTime = new VideoCompositionLayerInstruction.OpacityRamp(new CMTimeRange(paramCMTime, localCMTime.sub(paramCMTime)));
      paramCMTime.startOpacity = paramFloat;
      paramCMTime.endOpacity = paramFloat;
      this.opacityRampList.add(paramCMTime);
      return;
    }
  }
  
  public void setOpacityRampFromStartOpacity(float paramFloat1, float paramFloat2, @NonNull CMTimeRange paramCMTimeRange)
  {
    VideoCompositionLayerInstruction.OpacityRamp localOpacityRamp = new VideoCompositionLayerInstruction.OpacityRamp(paramCMTimeRange);
    localOpacityRamp.startOpacity = paramFloat1;
    localOpacityRamp.endOpacity = paramFloat2;
    Object localObject = this.opacityRampList.iterator();
    CMTime localCMTime1;
    CMTime localCMTime2;
    if (((Iterator)localObject).hasNext())
    {
      localObject = (VideoCompositionLayerInstruction.OpacityRamp)((Iterator)localObject).next();
      localCMTime1 = ((VideoCompositionLayerInstruction.OpacityRamp)localObject).timeRange.getStart();
      localCMTime2 = ((VideoCompositionLayerInstruction.OpacityRamp)localObject).timeRange.getEnd();
      if ((!paramCMTimeRange.containsTime(localCMTime1)) || (!paramCMTimeRange.containsTime(localCMTime2))) {
        break label173;
      }
      ((VideoCompositionLayerInstruction.OpacityRamp)localObject).timeRange = CMTimeRange.CMTimeRangeInvalid;
    }
    for (;;)
    {
      int j;
      for (int i = 0; i < this.opacityRampList.size(); i = j + 1)
      {
        paramCMTimeRange = (VideoCompositionLayerInstruction.OpacityRamp)this.opacityRampList.get(i);
        j = i;
        if (paramCMTimeRange.timeRange == CMTimeRange.CMTimeRangeInvalid)
        {
          this.opacityRampList.remove(paramCMTimeRange);
          j = i - 1;
        }
      }
      label173:
      if ((paramCMTimeRange.containsTime(localCMTime1)) && (!paramCMTimeRange.containsTime(localCMTime2))) {
        ((VideoCompositionLayerInstruction.OpacityRamp)localObject).timeRange = new CMTimeRange(paramCMTimeRange.getEnd(), ((VideoCompositionLayerInstruction.OpacityRamp)localObject).timeRange.getEnd().sub(paramCMTimeRange.getEnd()));
      } else if ((paramCMTimeRange.containsTime(localCMTime2)) && (!paramCMTimeRange.containsTime(localCMTime1))) {
        ((VideoCompositionLayerInstruction.OpacityRamp)localObject).timeRange = new CMTimeRange(((VideoCompositionLayerInstruction.OpacityRamp)localObject).timeRange.getStart(), paramCMTimeRange.getStart().sub(((VideoCompositionLayerInstruction.OpacityRamp)localObject).timeRange.getStart()));
      }
    }
    this.opacityRampList.add(localOpacityRamp);
  }
  
  public void setTrackID(int paramInt)
  {
    this.trackID = paramInt;
  }
  
  public void setTransform(@Nullable Transform paramTransform, @NonNull CMTime paramCMTime)
  {
    CMTime localCMTime = this.duration;
    Iterator localIterator = this.transformRampList.iterator();
    while (localIterator.hasNext())
    {
      VideoCompositionLayerInstruction.TransformRamp localTransformRamp = (VideoCompositionLayerInstruction.TransformRamp)localIterator.next();
      if (localTransformRamp.timeRange.containsTime(paramCMTime))
      {
        localCMTime = localTransformRamp.timeRange.getEnd();
        localTransformRamp.timeRange = new CMTimeRange(localTransformRamp.timeRange.getStart(), paramCMTime.sub(localTransformRamp.timeRange.getStart()));
      }
    }
    for (;;)
    {
      paramCMTime = new VideoCompositionLayerInstruction.TransformRamp(new CMTimeRange(paramCMTime, localCMTime.sub(paramCMTime)));
      paramCMTime.startTransform = paramTransform;
      paramCMTime.endTransform = paramTransform;
      this.transformRampList.add(paramCMTime);
      return;
    }
  }
  
  public void setTransformRampFromStartTransform(@Nullable Transform paramTransform1, @Nullable Transform paramTransform2, @NonNull CMTimeRange paramCMTimeRange)
  {
    VideoCompositionLayerInstruction.TransformRamp localTransformRamp = new VideoCompositionLayerInstruction.TransformRamp(paramCMTimeRange);
    localTransformRamp.startTransform = paramTransform1;
    localTransformRamp.endTransform = paramTransform2;
    paramTransform1 = this.transformRampList.iterator();
    CMTime localCMTime;
    if (paramTransform1.hasNext())
    {
      paramTransform1 = (VideoCompositionLayerInstruction.TransformRamp)paramTransform1.next();
      paramTransform2 = paramTransform1.timeRange.getStart();
      localCMTime = paramTransform1.timeRange.getEnd();
      if ((!paramCMTimeRange.containsTime(paramTransform2)) || (!paramCMTimeRange.containsTime(localCMTime))) {
        break label164;
      }
      paramTransform1.timeRange = CMTimeRange.CMTimeRangeInvalid;
    }
    for (;;)
    {
      int j;
      for (int i = 0; i < this.transformRampList.size(); i = j + 1)
      {
        paramTransform1 = (VideoCompositionLayerInstruction.TransformRamp)this.transformRampList.get(i);
        j = i;
        if (paramTransform1.timeRange == CMTimeRange.CMTimeRangeInvalid)
        {
          this.transformRampList.remove(paramTransform1);
          j = i - 1;
        }
      }
      label164:
      if ((paramCMTimeRange.containsTime(paramTransform2)) && (!paramCMTimeRange.containsTime(localCMTime))) {
        paramTransform1.timeRange = new CMTimeRange(paramCMTimeRange.getEnd(), paramTransform1.timeRange.getEnd().sub(paramCMTimeRange.getEnd()));
      } else if ((paramCMTimeRange.containsTime(localCMTime)) && (!paramCMTimeRange.containsTime(paramTransform2))) {
        paramTransform1.timeRange = new CMTimeRange(paramTransform1.timeRange.getStart(), paramCMTimeRange.getStart().sub(paramTransform1.timeRange.getStart()));
      }
    }
    this.transformRampList.add(localTransformRamp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.tav.core.composition.MutableVideoCompositionLayerInstruction
 * JD-Core Version:    0.7.0.1
 */