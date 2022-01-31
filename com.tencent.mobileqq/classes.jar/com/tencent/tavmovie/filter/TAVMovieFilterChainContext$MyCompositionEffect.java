package com.tencent.tavmovie.filter;

import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect.Filter;
import com.tencent.tavkit.report.IReportable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class TAVMovieFilterChainContext$MyCompositionEffect
  implements TAVVideoEffect.Filter, IReportable
{
  private final List<TAVVideoEffect.Filter> effects = new ArrayList();
  
  private TAVMovieFilterChainContext$MyCompositionEffect(List<TAVVideoEffect> paramList)
  {
    TAVVideoEffect localTAVVideoEffect;
    paramList = localTAVVideoEffect.iterator();
    while (paramList.hasNext())
    {
      localTAVVideoEffect = (TAVVideoEffect)paramList.next();
      this.effects.add(localTAVVideoEffect.createFilter());
    }
  }
  
  public CIImage apply(TAVVideoEffect paramTAVVideoEffect, CIImage paramCIImage, RenderInfo paramRenderInfo)
  {
    Iterator localIterator = this.effects.iterator();
    while (localIterator.hasNext()) {
      paramCIImage = ((TAVVideoEffect.Filter)localIterator.next()).apply(paramTAVVideoEffect, paramCIImage, paramRenderInfo);
    }
    return paramCIImage;
  }
  
  public String getReportKey()
  {
    return this.this$0.reportKey;
  }
  
  public void release()
  {
    Iterator localIterator = this.effects.iterator();
    while (localIterator.hasNext()) {
      ((TAVVideoEffect.Filter)localIterator.next()).release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavmovie.filter.TAVMovieFilterChainContext.MyCompositionEffect
 * JD-Core Version:    0.7.0.1
 */