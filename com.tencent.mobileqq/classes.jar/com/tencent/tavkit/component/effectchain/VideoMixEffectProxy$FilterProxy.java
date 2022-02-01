package com.tencent.tavkit.component.effectchain;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.ImageCollection;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect.Filter;
import com.tencent.tavkit.report.FilterChainReportSession;
import com.tencent.tavkit.report.IReportable;
import com.tencent.tavkit.report.MemoryReportHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

class VideoMixEffectProxy$FilterProxy
  implements TAVVideoMixEffect.Filter, IReportable
{
  private final HashMap<String, TAVVideoMixEffect.Filter> filterMap = new HashMap();
  private boolean onEffectRemove;
  private final FilterChainReportSession reportSession = new FilterChainReportSession();
  
  private CIImage apply(ImageCollection paramImageCollection, RenderInfo paramRenderInfo, CIImage paramCIImage, TAVVideoMixEffect paramTAVVideoMixEffect)
  {
    TAVVideoMixEffect.Filter localFilter = getCacheFilter(paramTAVVideoMixEffect);
    if (localFilter == null) {
      return paramCIImage;
    }
    paramCIImage = null;
    long l = System.nanoTime();
    if ((localFilter instanceof IReportable)) {
      paramCIImage = ((IReportable)localFilter).getReportKey();
    }
    paramImageCollection = localFilter.apply(paramTAVVideoMixEffect, paramImageCollection, paramRenderInfo);
    if (!TextUtils.isEmpty(paramCIImage)) {
      this.reportSession.tick(paramCIImage, System.nanoTime() - l);
    }
    return paramImageCollection;
  }
  
  private void checkRuntimeRelease(List<TAVVideoMixEffect> paramList)
  {
    if (!this.onEffectRemove) {
      return;
    }
    this.onEffectRemove = false;
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    Object localObject;
    while (paramList.hasNext())
    {
      localObject = (TAVVideoMixEffect)paramList.next();
      if (!TextUtils.isEmpty(((TAVVideoMixEffect)localObject).effectId())) {
        localArrayList.add(((TAVVideoMixEffect)localObject).effectId());
      }
    }
    paramList = new HashSet(this.filterMap.keySet()).iterator();
    while (paramList.hasNext())
    {
      localObject = (String)paramList.next();
      if (!localArrayList.contains(localObject))
      {
        ((TAVVideoMixEffect.Filter)this.filterMap.get(localObject)).release();
        this.filterMap.remove(localObject);
      }
    }
  }
  
  @Nullable
  private TAVVideoMixEffect.Filter getCacheFilter(TAVVideoMixEffect paramTAVVideoMixEffect)
  {
    if ((paramTAVVideoMixEffect != null) && (!TextUtils.isEmpty(paramTAVVideoMixEffect.effectId())))
    {
      String str = paramTAVVideoMixEffect.effectId();
      if (this.filterMap.containsKey(str)) {
        return (TAVVideoMixEffect.Filter)this.filterMap.get(str);
      }
      paramTAVVideoMixEffect = paramTAVVideoMixEffect.createFilter();
      this.filterMap.put(str, paramTAVVideoMixEffect);
      return paramTAVVideoMixEffect;
    }
    return null;
  }
  
  private void notifyOnEffectRemove()
  {
    this.onEffectRemove = true;
  }
  
  public CIImage apply(TAVVideoMixEffect paramTAVVideoMixEffect, ImageCollection paramImageCollection, RenderInfo paramRenderInfo)
  {
    boolean bool = paramTAVVideoMixEffect instanceof VideoMixEffectProxy;
    Object localObject1 = null;
    if (!bool) {
      return null;
    }
    paramTAVVideoMixEffect = (VideoMixEffectProxy)paramTAVVideoMixEffect;
    Object localObject2 = paramTAVVideoMixEffect.getEffects();
    if ((paramTAVVideoMixEffect.isAutoCheckEffectRemove()) || (this.onEffectRemove)) {
      checkRuntimeRelease((List)localObject2);
    }
    localObject2 = ((List)localObject2).iterator();
    for (paramTAVVideoMixEffect = localObject1; ((Iterator)localObject2).hasNext(); paramTAVVideoMixEffect = apply(paramImageCollection, paramRenderInfo, paramTAVVideoMixEffect, (TAVVideoMixEffect)((Iterator)localObject2).next())) {}
    return paramTAVVideoMixEffect;
  }
  
  public String getReportKey()
  {
    return MemoryReportHelper.appendReportKey(this.filterMap.values());
  }
  
  public void release()
  {
    try
    {
      Iterator localIterator = this.filterMap.values().iterator();
      while (localIterator.hasNext()) {
        ((TAVVideoMixEffect.Filter)localIterator.next()).release();
      }
      this.filterMap.clear();
      this.reportSession.commit();
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavkit.component.effectchain.VideoMixEffectProxy.FilterProxy
 * JD-Core Version:    0.7.0.1
 */