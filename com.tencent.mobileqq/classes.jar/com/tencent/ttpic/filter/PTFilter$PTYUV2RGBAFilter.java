package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.SurfaceTextureFilter;

public class PTFilter$PTYUV2RGBAFilter
  extends PTFilter
{
  public PTFilter$PTYUV2RGBAFilter()
  {
    this.mFilter = new SurfaceTextureFilter();
  }
  
  public void setRotationAndFlip(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 1;
    BaseFilter localBaseFilter = this.mFilter;
    int i;
    if (paramBoolean1)
    {
      i = 1;
      if (!paramBoolean2) {
        break label38;
      }
    }
    for (;;)
    {
      localBaseFilter.setRotationAndFlip(paramInt, i, j);
      return;
      i = 0;
      break;
      label38:
      j = 0;
    }
  }
  
  public void setTextureCoordsMatrix(float[] paramArrayOfFloat)
  {
    this.mFilter.updateMatrix(paramArrayOfFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.PTFilter.PTYUV2RGBAFilter
 * JD-Core Version:    0.7.0.1
 */