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
    Object localObject1 = paramTAVMovieResource.sourceTimeRange;
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((CMTimeRange)localObject1).clone();
    } else {
      localObject1 = null;
    }
    this.sourceTimeRange = ((CMTimeRange)localObject1);
    localObject1 = paramTAVMovieResource.timeRange;
    if (localObject1 != null) {
      localObject1 = ((CMTimeRange)localObject1).clone();
    } else {
      localObject1 = null;
    }
    this.timeRange = ((CMTimeRange)localObject1);
    localObject1 = paramTAVMovieResource.duration;
    if (localObject1 != null) {
      localObject1 = ((CMTime)localObject1).clone();
    } else {
      localObject1 = null;
    }
    this.duration = ((CMTime)localObject1);
    this.timeEffects = CloneUtil.cloneMovieTimeEffects(paramTAVMovieResource.timeEffects);
    this.type = paramTAVMovieResource.type;
    CGSize localCGSize = paramTAVMovieResource.naturalSize;
    localObject1 = localObject2;
    if (localCGSize != null) {
      localObject1 = localCGSize.clone();
    }
    this.naturalSize = ((CGSize)localObject1);
    this.status = paramTAVMovieResource.status;
    this.errorStatus = paramTAVMovieResource.errorStatus;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavmovie.resource.TAVMovieResource
 * JD-Core Version:    0.7.0.1
 */