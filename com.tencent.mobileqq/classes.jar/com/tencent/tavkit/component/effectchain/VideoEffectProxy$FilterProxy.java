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

class VideoEffectProxy$FilterProxy
  implements TAVVideoEffect.Filter, IReportable
{
  @NonNull
  private final HashMap<String, TAVVideoEffect.Filter> filterMap = new HashMap();
  private boolean onEffectRemove;
  @NonNull
  private final FilterChainReportSession reportSession = new FilterChainReportSession();
  
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
      return ((BaseVideoEffect)paramTAVVideoEffect).a(paramRenderInfo);
    }
    return paramTAVVideoEffect.createFilter();
  }
  
  @Nullable
  private TAVVideoEffect.Filter getCacheFilter(TAVVideoEffect paramTAVVideoEffect, RenderInfo paramRenderInfo)
  {
    if ((paramTAVVideoEffect == null) || (TextUtils.isEmpty(paramTAVVideoEffect.effectId()))) {
      return null;
    }
    String str = paramTAVVideoEffect.effectId();
    if (this.filterMap.containsKey(str)) {
      return (TAVVideoEffect.Filter)this.filterMap.get(str);
    }
    paramTAVVideoEffect = createFilter(paramTAVVideoEffect, paramRenderInfo);
    this.filterMap.put(str, paramTAVVideoEffect);
    return paramTAVVideoEffect;
  }
  
  public CIImage apply(TAVVideoEffect paramTAVVideoEffect, CIImage paramCIImage, RenderInfo paramRenderInfo)
  {
    if (!(paramTAVVideoEffect instanceof VideoEffectProxy))
    {
      paramTAVVideoEffect = paramCIImage;
      return paramTAVVideoEffect;
    }
    Object localObject = ((VideoEffectProxy)paramTAVVideoEffect).getEffects();
    if ((((VideoEffectProxy)paramTAVVideoEffect).isAutoCheckEffectRemove()) || (this.onEffectRemove)) {
      checkRuntimeRelease((List)localObject);
    }
    Iterator localIterator = ((List)localObject).iterator();
    for (;;)
    {
      paramTAVVideoEffect = paramCIImage;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (TAVVideoEffect)localIterator.next();
      TAVVideoEffect.Filter localFilter = getCacheFilter((TAVVideoEffect)localObject, paramRenderInfo);
      if (localFilter != null)
      {
        paramTAVVideoEffect = null;
        long l = System.nanoTime();
        if ((localFilter instanceof IReportable)) {
          paramTAVVideoEffect = ((IReportable)localFilter).getReportKey();
        }
        localObject = localFilter.apply((TAVVideoEffect)localObject, paramCIImage, paramRenderInfo);
        paramCIImage = (CIImage)localObject;
        if (!TextUtils.isEmpty(paramTAVVideoEffect))
        {
          this.reportSession.tick(paramTAVVideoEffect, System.nanoTime() - l);
          paramCIImage = (CIImage)localObject;
        }
      }
    }
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
    }
    finally {}
    this.reportSession.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavkit.component.effectchain.VideoEffectProxy.FilterProxy
 * JD-Core Version:    0.7.0.1
 */