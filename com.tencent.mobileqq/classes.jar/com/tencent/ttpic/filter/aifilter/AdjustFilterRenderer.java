package com.tencent.ttpic.filter.aifilter;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.openapi.filter.Renderer;
import java.util.Iterator;
import java.util.List;

public final class AdjustFilterRenderer
  implements Renderer
{
  private final List<BaseFilter> filterList;
  
  public AdjustFilterRenderer(List<BaseFilter> paramList)
  {
    this.filterList = paramList;
  }
  
  public Frame process(Frame paramFrame)
  {
    Iterator localIterator = this.filterList.iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (BaseFilter)localIterator.next();
      if ((localObject instanceof ColorTemperatureLutFilter))
      {
        ((BaseFilter)localObject).applyFilterChain(true, 0.0F, 0.0F);
        ((ColorTemperatureLutFilter)localObject).updateAlpha(((ColorTemperatureLutFilter)localObject).getAlphaTemp());
      }
      for (;;)
      {
        localObject = ((BaseFilter)localObject).RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
        paramFrame.unlock();
        paramFrame = (Frame)localObject;
        break;
        ((BaseFilter)localObject).applyFilterChain(true, 0.0F, 0.0F);
      }
    }
    return paramFrame;
  }
  
  public void release()
  {
    if (this.filterList != null)
    {
      Iterator localIterator = this.filterList.iterator();
      while (localIterator.hasNext()) {
        ((BaseFilter)localIterator.next()).clearGLSLSelf();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.aifilter.AdjustFilterRenderer
 * JD-Core Version:    0.7.0.1
 */