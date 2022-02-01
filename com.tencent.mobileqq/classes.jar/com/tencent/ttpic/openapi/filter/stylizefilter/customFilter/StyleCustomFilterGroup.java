package com.tencent.ttpic.openapi.filter.stylizefilter.customFilter;

import android.text.TextUtils;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.ttpic.filter.blurmaskfilter.OptimGaussianMaskFilter;
import com.tencent.ttpic.openapi.filter.CustomFilterItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StyleCustomFilterGroup
{
  private static final String GAUSS_FILTER = "gaussFilter";
  private VideoFilterBase copyFilter = new VideoFilterBase("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private List<CustomFilterItem> customFilterList;
  private Map<String, OptimGaussianMaskFilter> gaussianFilterMap = new HashMap();
  private Map<String, StyleCustomNormalFilter> normalFilterMap = new HashMap();
  private Map<String, Frame> tmpFrameMap = new HashMap();
  
  public StyleCustomFilterGroup(List<CustomFilterItem> paramList)
  {
    this.customFilterList = paramList;
    constructFilters();
  }
  
  private void constructFilters()
  {
    Iterator localIterator1 = this.customFilterList.iterator();
    while (localIterator1.hasNext())
    {
      CustomFilterItem localCustomFilterItem = (CustomFilterItem)localIterator1.next();
      if (localCustomFilterItem != null)
      {
        Object localObject;
        if (TextUtils.isEmpty(localCustomFilterItem.filterName))
        {
          localObject = new StyleCustomNormalFilter(localCustomFilterItem.vertex, localCustomFilterItem.fragment);
          Iterator localIterator2;
          String str;
          if ((localCustomFilterItem.lutPaths != null) && (localCustomFilterItem.lutPaths.size() > 0))
          {
            localIterator2 = localCustomFilterItem.lutPaths.keySet().iterator();
            while (localIterator2.hasNext())
            {
              str = (String)localIterator2.next();
              ((StyleCustomNormalFilter)localObject).updateLut((String)localCustomFilterItem.lutPaths.get(str), str);
            }
          }
          if ((localCustomFilterItem.materialPaths != null) && (localCustomFilterItem.materialPaths.size() > 0))
          {
            localIterator2 = localCustomFilterItem.materialPaths.keySet().iterator();
            while (localIterator2.hasNext())
            {
              str = (String)localIterator2.next();
              ((StyleCustomNormalFilter)localObject).updateMaterial((String)localCustomFilterItem.materialPaths.get(str), str);
            }
          }
          this.normalFilterMap.put(localCustomFilterItem.id, localObject);
        }
        else if ("gaussFilter".equals(localCustomFilterItem.filterName))
        {
          localObject = new OptimGaussianMaskFilter(false, localCustomFilterItem.filterValue, false);
          ((OptimGaussianMaskFilter)localObject).setCustomSizeW(localCustomFilterItem.inputFrameSize[0]);
          ((OptimGaussianMaskFilter)localObject).setCustomSizeH(localCustomFilterItem.inputFrameSize[1]);
          this.gaussianFilterMap.put(localCustomFilterItem.id, localObject);
        }
      }
    }
  }
  
  public void apply()
  {
    Iterator localIterator = this.normalFilterMap.values().iterator();
    while (localIterator.hasNext()) {
      ((StyleCustomNormalFilter)localIterator.next()).apply();
    }
    localIterator = this.gaussianFilterMap.values().iterator();
    while (localIterator.hasNext()) {
      ((OptimGaussianMaskFilter)localIterator.next()).applyForCustomFilter(false);
    }
    this.copyFilter.apply();
  }
  
  public void destroy()
  {
    Iterator localIterator = this.normalFilterMap.values().iterator();
    while (localIterator.hasNext()) {
      ((StyleCustomNormalFilter)localIterator.next()).clearGLSLSelf();
    }
    localIterator = this.gaussianFilterMap.values().iterator();
    while (localIterator.hasNext()) {
      ((OptimGaussianMaskFilter)localIterator.next()).clear();
    }
    this.copyFilter.clear();
  }
  
  public Frame render(Frame paramFrame)
  {
    this.tmpFrameMap.clear();
    float f = paramFrame.height * 1.0F / paramFrame.width;
    Iterator localIterator = this.customFilterList.iterator();
    label105:
    Object localObject2;
    while (localIterator.hasNext())
    {
      CustomFilterItem localCustomFilterItem = (CustomFilterItem)localIterator.next();
      Object localObject3;
      if (TextUtils.isEmpty(localCustomFilterItem.filterName))
      {
        localObject3 = (StyleCustomNormalFilter)this.normalFilterMap.get(localCustomFilterItem.id);
        if (localObject3 != null)
        {
          label128:
          int j;
          label154:
          int m;
          if (localCustomFilterItem.preFilterId.size() == 0)
          {
            localObject1 = paramFrame;
            if (localObject1 == null) {
              break label378;
            }
            if (localCustomFilterItem.inputFrameSize[0] <= 0) {
              break label380;
            }
            i = localCustomFilterItem.inputFrameSize[0];
            int k = (int)(i * f);
            if (localCustomFilterItem.outputFrameSize[0] <= 0) {
              break label389;
            }
            j = localCustomFilterItem.outputFrameSize[0];
            m = (int)(j * f);
            if ((Math.abs(i - ((Frame)localObject1).width) < 2) && (Math.abs(k - ((Frame)localObject1).height) < 2)) {
              break label395;
            }
            localObject2 = FrameBufferCache.getInstance().get(i, k);
            this.copyFilter.RenderProcess(((Frame)localObject1).getTextureId(), i, k, -1, 0.0D, (Frame)localObject2);
            localObject1 = localObject2;
          }
          label389:
          label395:
          for (;;)
          {
            ((StyleCustomNormalFilter)localObject3).updateWidthHeightParam(1.0F / j, 1.0F / m);
            ((StyleCustomNormalFilter)localObject3).updateImgSize(j, m);
            localObject1 = ((StyleCustomNormalFilter)localObject3).RenderProcess((Frame)localObject1);
            this.tmpFrameMap.put(localCustomFilterItem.id, localObject1);
            break;
            if (localCustomFilterItem.preFilterId.size() == 1)
            {
              localObject1 = (Frame)this.tmpFrameMap.get(localCustomFilterItem.preFilterId.get(0));
              break label105;
            }
            localObject1 = (Frame)this.tmpFrameMap.get(localCustomFilterItem.preFilterId.get(0));
            localObject2 = (Frame)this.tmpFrameMap.get(localCustomFilterItem.preFilterId.get(1));
            if (localObject2 == null) {
              break;
            }
            ((StyleCustomNormalFilter)localObject3).setTexture2(((Frame)localObject2).getTextureId());
            break label105;
            label378:
            break;
            label380:
            i = ((Frame)localObject1).width;
            break label128;
            j = i;
            break label154;
          }
        }
      }
      else if ("gaussFilter".equals(localCustomFilterItem.filterName))
      {
        localObject2 = (OptimGaussianMaskFilter)this.gaussianFilterMap.get(localCustomFilterItem.id);
        if (localObject2 != null)
        {
          if (localCustomFilterItem.preFilterId.size() == 0) {}
          for (localObject1 = paramFrame;; localObject1 = (Frame)this.tmpFrameMap.get(localCustomFilterItem.preFilterId.get(0)))
          {
            localObject3 = FrameBufferCache.getInstance().get(((Frame)localObject1).width, ((Frame)localObject1).height);
            ((OptimGaussianMaskFilter)localObject2).updateVideoSize(((Frame)localObject1).width, ((Frame)localObject1).height);
            localObject2 = ((OptimGaussianMaskFilter)localObject2).RenderProcess((Frame)localObject1, (Frame)localObject3);
            if (localObject2 != localObject1) {
              ((Frame)localObject1).unlock();
            }
            if (localObject2 != localObject3) {
              ((Frame)localObject3).unlock();
            }
            this.tmpFrameMap.put(localCustomFilterItem.id, localObject2);
            break;
          }
        }
      }
    }
    int i = this.customFilterList.size();
    paramFrame = (Frame)this.tmpFrameMap.get(((CustomFilterItem)this.customFilterList.get(i - 1)).id);
    Object localObject1 = this.tmpFrameMap.values().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Frame)((Iterator)localObject1).next();
      if (localObject2 != paramFrame) {
        ((Frame)localObject2).unlock();
      }
    }
    return paramFrame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.stylizefilter.customFilter.StyleCustomFilterGroup
 * JD-Core Version:    0.7.0.1
 */