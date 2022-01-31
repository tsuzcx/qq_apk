package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.model.StickerItem;
import java.util.List;

public class LutItemsFilter
{
  private LutFilter lutFilter;
  
  public LutItemsFilter(List<StickerItem> paramList, String paramString)
  {
    this.lutFilter = new LutFilter(paramString, (StickerItem)paramList.get(0));
  }
  
  public void apply()
  {
    this.lutFilter.ApplyGLSLFilter();
  }
  
  public void clear()
  {
    this.lutFilter.clearGLSLSelf();
  }
  
  public Frame render(Frame paramFrame, PTDetectInfo paramPTDetectInfo, int paramInt, Bitmap paramBitmap)
  {
    return this.lutFilter.render(paramFrame, paramPTDetectInfo, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.LutItemsFilter
 * JD-Core Version:    0.7.0.1
 */