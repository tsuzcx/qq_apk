package com.tencent.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.openapi.filter.FaceBeautysRealAutoFilter;
import com.tencent.ttpic.openapi.model.CameraFilterParamSDK;
import java.util.Map;

public class PTFilter$PTSmoothSkin
  extends PTFilter
{
  private CameraFilterParamSDK mBeautyParam = new CameraFilterParamSDK();
  
  public PTFilter$PTSmoothSkin()
  {
    this.mFilter = new FaceBeautysRealAutoFilter();
    setBeautyLevel(1);
  }
  
  public int getBeautyLevel()
  {
    return this.mBeautyParam.smoothLevel;
  }
  
  public void setBeautyLevel(int paramInt)
  {
    Object localObject = this.mBeautyParam;
    ((CameraFilterParamSDK)localObject).smoothLevel = paramInt;
    localObject = ((CameraFilterParamSDK)localObject).getSmoothMap();
    this.mFilter.setParameterDic((Map)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.PTFilter.PTSmoothSkin
 * JD-Core Version:    0.7.0.1
 */