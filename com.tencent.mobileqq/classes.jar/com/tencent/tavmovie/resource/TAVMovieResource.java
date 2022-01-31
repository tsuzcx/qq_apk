package com.tencent.tavmovie.resource;

import android.support.annotation.NonNull;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.resource.TAVResource;
import com.tencent.tavmovie.base.TAVMovieTimeEffect;
import com.tencent.tavmovie.utils.CloneUtil;
import java.util.List;

public abstract class TAVMovieResource
{
  protected CMTime duration;
  protected int errorStatus;
  protected CGSize naturalSize;
  protected CMTimeRange sourceTimeRange;
  protected TAVMovieResource.TAVMovieResourceStatus status;
  protected TAVMovieTimeEffect timeEffect;
  protected List<TAVMovieTimeEffect> timeEffects;
  protected CMTimeRange timeRange;
  protected TAVMovieResource.TAVResourceType type;
  
  public abstract TAVMovieResource clone();
  
  protected void cloneFrom(@NonNull TAVMovieResource paramTAVMovieResource)
  {
    Object localObject2 = null;
    if (paramTAVMovieResource.sourceTimeRange != null)
    {
      localObject1 = paramTAVMovieResource.sourceTimeRange.clone();
      this.sourceTimeRange = ((CMTimeRange)localObject1);
      if (paramTAVMovieResource.timeRange == null) {
        break label125;
      }
      localObject1 = paramTAVMovieResource.timeRange.clone();
      label37:
      this.timeRange = ((CMTimeRange)localObject1);
      if (paramTAVMovieResource.duration == null) {
        break label130;
      }
    }
    label130:
    for (Object localObject1 = paramTAVMovieResource.duration.clone();; localObject1 = null)
    {
      this.duration = ((CMTime)localObject1);
      this.timeEffects = CloneUtil.cloneMovieTimeEffects(paramTAVMovieResource.timeEffects);
      this.type = paramTAVMovieResource.type;
      localObject1 = localObject2;
      if (paramTAVMovieResource.naturalSize != null) {
        localObject1 = paramTAVMovieResource.naturalSize.clone();
      }
      this.naturalSize = ((CGSize)localObject1);
      this.status = paramTAVMovieResource.status;
      this.errorStatus = paramTAVMovieResource.errorStatus;
      return;
      localObject1 = null;
      break;
      label125:
      localObject1 = null;
      break label37;
    }
  }
  
  public abstract TAVResource convertToResource();
  
  public abstract TAVMovieResource dataClone();
  
  public boolean equals(Object paramObject)
  {
    return super.equals(paramObject);
  }
  
  public CMTime getDuration()
  {
    return this.duration;
  }
  
  public int getErrorStatus()
  {
    return this.errorStatus;
  }
  
  public CGSize getNaturalSize()
  {
    return this.naturalSize;
  }
  
  public CMTimeRange getSourceTimeRange()
  {
    return this.sourceTimeRange;
  }
  
  public TAVMovieResource.TAVMovieResourceStatus getStatus()
  {
    return this.status;
  }
  
  public TAVMovieTimeEffect getTimeEffect()
  {
    return this.timeEffect;
  }
  
  public List<TAVMovieTimeEffect> getTimeEffects()
  {
    return this.timeEffects;
  }
  
  public CMTimeRange getTimeRange()
  {
    return this.timeRange;
  }
  
  public TAVMovieResource.TAVResourceType getType()
  {
    return this.type;
  }
  
  public void setDuration(CMTime paramCMTime)
  {
    this.duration = paramCMTime;
  }
  
  public void setErrorStatus(int paramInt)
  {
    this.errorStatus = paramInt;
  }
  
  public void setNaturalSize(CGSize paramCGSize)
  {
    this.naturalSize = paramCGSize;
  }
  
  public void setSourceTimeRange(@NonNull CMTimeRange paramCMTimeRange)
  {
    this.sourceTimeRange = paramCMTimeRange;
  }
  
  public void setStatus(TAVMovieResource.TAVMovieResourceStatus paramTAVMovieResourceStatus)
  {
    this.status = paramTAVMovieResourceStatus;
  }
  
  public void setTimeEffect(TAVMovieTimeEffect paramTAVMovieTimeEffect)
  {
    this.timeEffect = paramTAVMovieTimeEffect;
  }
  
  public void setTimeEffects(List<TAVMovieTimeEffect> paramList)
  {
    this.timeEffects = paramList;
  }
  
  public void setTimeRange(CMTimeRange paramCMTimeRange)
  {
    this.timeRange = paramCMTimeRange;
  }
  
  public void setType(TAVMovieResource.TAVResourceType paramTAVResourceType)
  {
    this.type = paramTAVResourceType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavmovie.resource.TAVMovieResource
 * JD-Core Version:    0.7.0.1
 */