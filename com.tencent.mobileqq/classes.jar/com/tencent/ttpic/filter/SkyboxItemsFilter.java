package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import com.tencent.aekit.openrender.internal.AEFilterI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.trigger.TriggerCtrlItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class SkyboxItemsFilter
  implements AEFilterI
{
  private int blendMode;
  private MaskBlendFilter maskBlendFilter;
  private List<SkyboxFilter> skyboxFilters = new ArrayList();
  private List<StickerItem> skyboxItemList;
  
  public SkyboxItemsFilter(List<StickerItem> paramList, String paramString)
  {
    this.skyboxItemList = paramList;
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      SkyboxFilter localSkyboxFilter = new SkyboxFilter(paramString, (StickerItem)localIterator.next());
      this.skyboxFilters.add(localSkyboxFilter);
    }
    this.maskBlendFilter = new MaskBlendFilter();
    this.blendMode = ((StickerItem)paramList.get(0)).blendMode;
  }
  
  public Frame RenderProcess(Frame paramFrame)
  {
    return paramFrame;
  }
  
  public void apply()
  {
    Iterator localIterator = this.skyboxFilters.iterator();
    while (localIterator.hasNext()) {
      ((SkyboxFilter)localIterator.next()).ApplyGLSLFilter();
    }
    this.maskBlendFilter.ApplyGLSLFilter();
  }
  
  public void clear()
  {
    Iterator localIterator = this.skyboxFilters.iterator();
    while (localIterator.hasNext()) {
      ((SkyboxFilter)localIterator.next()).clearGLSLSelf();
    }
    this.maskBlendFilter.clearGLSLSelf();
  }
  
  public List<StickerItem> getItems()
  {
    return this.skyboxItemList;
  }
  
  public Frame render(Frame paramFrame, PTDetectInfo paramPTDetectInfo, int paramInt, Bitmap paramBitmap)
  {
    Iterator localIterator = this.skyboxFilters.iterator();
    Frame localFrame;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localFrame = ((SkyboxFilter)localIterator.next()).render(paramFrame, paramPTDetectInfo, paramInt);
    } while (localFrame == paramFrame);
    for (paramPTDetectInfo = localFrame;; paramPTDetectInfo = paramFrame)
    {
      paramBitmap = this.maskBlendFilter.render(paramFrame, paramPTDetectInfo, paramBitmap, this.blendMode);
      if (paramPTDetectInfo != paramFrame) {
        paramPTDetectInfo.unlock();
      }
      return paramBitmap;
    }
  }
  
  public void setTriggerCtrlItemMap(HashMap<String, TriggerCtrlItem> paramHashMap)
  {
    if (paramHashMap != null)
    {
      Iterator localIterator = this.skyboxFilters.iterator();
      while (localIterator.hasNext())
      {
        SkyboxFilter localSkyboxFilter = (SkyboxFilter)localIterator.next();
        TriggerCtrlItem localTriggerCtrlItem = (TriggerCtrlItem)paramHashMap.get(localSkyboxFilter.getItemId());
        if (localTriggerCtrlItem != null) {
          localSkyboxFilter.setTriggerCtrlItem(localTriggerCtrlItem);
        }
      }
    }
  }
  
  public void updatePreview(Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.SkyboxItemsFilter
 * JD-Core Version:    0.7.0.1
 */