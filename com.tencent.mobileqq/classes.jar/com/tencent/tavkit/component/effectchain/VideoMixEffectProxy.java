package com.tencent.tavkit.component.effectchain;

import android.support.annotation.NonNull;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect.Filter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class VideoMixEffectProxy
  implements TAVVideoMixEffect
{
  private boolean autoCheckEffectRemove = true;
  @NonNull
  private CopyOnWriteArrayList<TAVVideoMixEffect> effects = new CopyOnWriteArrayList();
  @NonNull
  private final List<VideoMixEffectProxy.FilterProxy> filterProxies = new ArrayList();
  
  public TAVVideoMixEffect.Filter createFilter()
  {
    VideoMixEffectProxy.FilterProxy localFilterProxy = new VideoMixEffectProxy.FilterProxy(null);
    this.filterProxies.add(localFilterProxy);
    return localFilterProxy;
  }
  
  @NonNull
  public String effectId()
  {
    return "VideoMixEffectProxy" + Integer.toHexString(hashCode());
  }
  
  @NonNull
  public List<TAVVideoMixEffect> getEffects()
  {
    return this.effects;
  }
  
  public boolean isAutoCheckEffectRemove()
  {
    return this.autoCheckEffectRemove;
  }
  
  public void notifyOnEffectRemove()
  {
    Iterator localIterator = this.filterProxies.iterator();
    while (localIterator.hasNext()) {
      VideoMixEffectProxy.FilterProxy.access$000((VideoMixEffectProxy.FilterProxy)localIterator.next());
    }
  }
  
  public void setAutoCheckEffectRemove(boolean paramBoolean)
  {
    this.autoCheckEffectRemove = paramBoolean;
  }
  
  public void setEffects(@NonNull CopyOnWriteArrayList<TAVVideoMixEffect> paramCopyOnWriteArrayList)
  {
    this.effects = paramCopyOnWriteArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavkit.component.effectchain.VideoMixEffectProxy
 * JD-Core Version:    0.7.0.1
 */