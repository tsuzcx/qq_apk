package com.tencent.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.openapi.filter.AlphaAdjustFilter;

public class PTFilter$PTAlphaFilter
  extends PTFilter
{
  public PTFilter$PTAlphaFilter()
  {
    this.mFilter = new AlphaAdjustFilter();
  }
  
  public int init()
  {
    int i = super.init();
    this.mFilter.setAdjustParam(0.0F);
    this.mFilter.applyFilterChain(true, 0.0F, 0.0F);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.PTFilter.PTAlphaFilter
 * JD-Core Version:    0.7.0.1
 */