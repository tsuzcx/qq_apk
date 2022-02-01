package com.tencent.tavkit.component.effectchain;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.BaseVideoEffect;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect.Filter;
import com.tencent.tavkit.report.FilterChainReportSession;
import com.tencent.tavkit.report.IReportable;
import com.tencent.tavkit.report.MemoryReportHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

class VideoEffectProxy$FilterProxy
  implements TAVVideoEffect.Filter, IReportable
{
  private final HashMap<String, TAVVideoEffect.Filter> filterMap = new HashMap();
  private boolean onEffectRemove;
  private final FilterChainReportSession reportSession = new FilterChainReportSession();
  
  @NotNull
  private CIImage apply(CIImage paramCIImage, RenderInfo paramRenderInfo, TAVVideoEffect paramTAVVideoEffect)
  {
    TAVVideoEffect.Filter localFilter = getCacheFilter(paramTAVVideoEffect, paramRenderInfo);
    if (localFilter == null) {
      return paramCIImage;
    }
    String str = null;
    long l = System.nanoTime();
    if ((localFilter instanceof IReportable)) {
      str = ((IReportable)localFilter).getReportKey();
    }
    paramCIImage = localFilter.apply(paramTAVVideoEffect, paramCIImage, paramRenderInfo);
    if (!TextUtils.isEmpty(str)) {
      this.reportSession.tick(str, System.nanoTime() - l);
    }
    return paramCIImage;
  }
  
  private void checkRuntimeRelease(List<TAVVideoEffect> paramList)
  {
    this.onEffectRemove = false;
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    Object localObject;
    while (paramList.hasNext())
    {
      localObject = (TAVVideoEffect)paramList.next();
      if (!TextUtils.isEmpty(((TAVVideoEffect)localObject).effectId())) {
        localArrayList.add(((TAVVideoEffect)localObject).effectId());
      }
    }
    paramList = new HashSet(this.filterMap.keySet()).iterator();
    while (paramList.hasNext())
    {
      localObject = (String)paramList.next();
      if (!localArrayList.contains(localObject))
      {
        ((TAVVideoEffect.Filter)this.filterMap.get(localObject)).release();
        this.filterMap.remove(localObject);
      }
    }
  }
  
  private TAVVideoEffect.Filter createFilter(TAVVideoEffect paramTAVVideoEffect, RenderInfo paramRenderInfo)
  {
    if ((paramTAVVideoEffect instanceof BaseVideoEffect)) {
      return ((BaseVideoEffect)paramTAVVideoEffect).createFilter(paramRenderInfo);
    }
    return paramTAVVideoEffect.createFilter();
  }
  
  @Nullable
  private TAVVideoEffect.Filter getCacheFilter(TAVVideoEffect paramTAVVideoEffect, RenderInfo paramRenderInfo)
  {
    if ((paramTAVVideoEffect != null) && (!TextUtils.isEmpty(paramTAVVideoEffect.effectId())))
    {
      String str = paramTAVVideoEffect.effectId();
      TAVVideoEffect.Filter localFilter2 = (TAVVideoEffect.Filter)this.filterMap.get(str);
      TAVVideoEffect.Filter localFilter1 = localFilter2;
      if (localFilter2 == null)
      {
        localFilter1 = createFilter(paramTAVVideoEffect, paramRenderInfo);
        this.filterMap.put(str, localFilter1);
      }
      return localFilter1;
    }
    return null;
  }
  
  @NonNull
  public CIImage apply(TAVVideoEffect paramTAVVideoEffect, CIImage paramCIImage, RenderInfo paramRenderInfo)
  {
    if (!(paramTAVVideoEffect instanceof VideoEffectProxy)) {
      return paramCIImage;
    }
    paramTAVVideoEffect = (VideoEffectProxy)paramTAVVideoEffect;
    List localList = paramTAVVideoEffect.getEffects();
    if ((paramTAVVideoEffect.isAutoCheckEffectRemove()) || (this.onEffectRemove)) {
      checkRuntimeRelease(localList);
    }
    paramTAVVideoEffect = localList.iterator();
    while (paramTAVVideoEffect.hasNext()) {
      paramCIImage = apply(paramCIImage, paramRenderInfo, (TAVVideoEffect)paramTAVVideoEffect.next());
    }
    return paramCIImage;
  }
  
  public String getReportKey()
  {
    return MemoryReportHelper.appendReportKey(this.filterMap.values());
  }
  
  public void notifyOnEffectRemove()
  {
    this.onEffectRemove = true;
  }
  
  public void release()
  {
    try
    {
      Iterator localIterator = this.filterMap.values().iterator();
      while (localIterator.hasNext()) {
        ((TAVVideoEffect.Filter)localIterator.next()).release();
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
 * Qualified Name:     com.tencent.tavkit.component.effectchain.VideoEffectProxy.FilterProxy
 * JD-Core Version:    0.7.0.1
 */