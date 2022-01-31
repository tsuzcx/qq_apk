package com.tencent.ttpic.filter;

import com.tencent.ttpic.model.CameraFilterParam;

public class PTSmoothBeauty
  extends FaceBeautysRealAutoFilter
{
  private CameraFilterParam mBeautyParam = new CameraFilterParam();
  
  public void setBeautyLevel(int paramInt)
  {
    this.mBeautyParam.smoothLevel = paramInt;
    setParameterDic(this.mBeautyParam.getSmoothMap(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.PTSmoothBeauty
 * JD-Core Version:    0.7.0.1
 */