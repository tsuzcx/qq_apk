package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;

public class PTFilter$PTCopyFilter
  extends PTFilter
{
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.PTFilter.PTCopyFilter
 * JD-Core Version:    0.7.0.1
 */