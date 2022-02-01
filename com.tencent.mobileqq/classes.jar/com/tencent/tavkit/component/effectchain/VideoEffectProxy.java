package com.tencent.tavkit.component.effectchain;

import android.support.annotation.NonNull;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect.Filter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class VideoEffectProxy
  implements TAVVideoEffect
{
  private boolean autoCheckEffectRemove = true;
  @NonNull
  private CopyOnWriteArrayList<TAVVideoEffect> effects = new CopyOnWriteArrayList();
  @NonNull
  private final List<VideoEffectProxy.FilterProxy> filterProxies = new ArrayList();
  
  public TAVVideoEffect.Filter createFilter()
  {
    VideoEffectProxy.FilterProxy localFilterProxy = new VideoEffectProxy.FilterProxy(null);
    this.filterProxies.add(localFilterProxy);
    return localFilterProxy;
  }
  
  @NonNull
  public String effectId()
  {
    return "VideoEffectProxy" + Integer.toHexString(hashCode());
  }
  
  @NonNull
  public List<TAVVideoEffect> getEffects()
  {
    try
    {
      CopyOnWriteArrayList localCopyOnWriteArrayList = this.effects;
      return localCopyOnWriteArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isAutoCheckEffectRemove()
  {
    return this.autoCheckEffectRemove;
  }
  
  public void notifyOnEffectRemove()
  {
    Iterator localIterator = this.filterProxies.iterator();
    while (localIterator.hasNext()) {
      ((VideoEffectProxy.FilterProxy)localIterator.next()).notifyOnEffectRemove();
    }
  }
  
  public void setAutoCheckEffectRemove(boolean paramBoolean)
  {
    this.autoCheckEffectRemove = paramBoolean;
  }
  
  public void setEffects(@NonNull CopyOnWriteArrayList<TAVVideoEffect> paramCopyOnWriteArrayList)
  {
    try
    {
      this.effects = paramCopyOnWriteArrayList;
      return;
    }
    finally
    {
      paramCopyOnWriteArrayList = finally;
      throw paramCopyOnWriteArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavkit.component.effectchain.VideoEffectProxy
 * JD-Core Version:    0.7.0.1
 */