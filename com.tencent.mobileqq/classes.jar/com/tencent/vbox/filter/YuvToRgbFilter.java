package com.tencent.vbox.filter;

import com.tencent.filter.BaseFilter;

public class YuvToRgbFilter
  extends BaseFilter
{
  public YuvToRgbFilter()
  {
    super(Shader.yuvToRgba);
  }
  
  private void initParams() {}
  
  public void apply()
  {
    initParams();
    super.apply();
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    initParams();
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.vbox.filter.YuvToRgbFilter
 * JD-Core Version:    0.7.0.1
 */