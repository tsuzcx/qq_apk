package com.tencent.ttpic.filter;

import com.tencent.ttpic.openapi.filter.FaceColorAndBrightnessFilter;

public class PTFilter$PTFaceColorAndBrightnessFilter
  extends PTFilter
{
  public PTFilter$PTFaceColorAndBrightnessFilter()
  {
    this.mFilter = new FaceColorAndBrightnessFilter();
  }
  
  public void updateCurve(int[] paramArrayOfInt, boolean paramBoolean)
  {
    ((FaceColorAndBrightnessFilter)this.mFilter).updateCurve(paramArrayOfInt, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.PTFilter.PTFaceColorAndBrightnessFilter
 * JD-Core Version:    0.7.0.1
 */