package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;

public class FlipProcessor
{
  private BaseFilter flipFilter = new BaseFilter(BaseFilter.getFragmentShader(0));
  private Frame frame = new Frame();
  
  public void clearFrame()
  {
    this.frame.clear();
  }
  
  public void init()
  {
    this.flipFilter.apply();
  }
  
  public Frame process(int paramInt1, int paramInt2, int paramInt3)
  {
    this.flipFilter.RenderProcess(paramInt1, paramInt2, paramInt3, -1, 0.0D, this.frame);
    return this.frame;
  }
  
  public void release()
  {
    this.flipFilter.ClearGLSL();
    this.frame.clear();
  }
  
  public void updateParam(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 1;
    BaseFilter localBaseFilter = this.flipFilter;
    int i;
    if (paramBoolean1)
    {
      i = 1;
      if (!paramBoolean2) {
        break label35;
      }
    }
    for (;;)
    {
      localBaseFilter.setRotationAndFlip(0, i, j);
      return;
      i = 0;
      break;
      label35:
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.FlipProcessor
 * JD-Core Version:    0.7.0.1
 */