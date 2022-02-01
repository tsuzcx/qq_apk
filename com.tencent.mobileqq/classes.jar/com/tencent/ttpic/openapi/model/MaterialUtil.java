package com.tencent.ttpic.openapi.model;

import android.text.TextUtils;

public class MaterialUtil
{
  public static MaterialUtil.FILTER_TYPE getFilterType(String paramString)
  {
    if (paramString.equalsIgnoreCase("cpu")) {
      return MaterialUtil.FILTER_TYPE.CPU;
    }
    if (paramString.equalsIgnoreCase("gpu")) {
      return MaterialUtil.FILTER_TYPE.GPU;
    }
    return null;
  }
  
  public static boolean isValid(BaseFilterMaterial paramBaseFilterMaterial)
  {
    return (paramBaseFilterMaterial != null) && (!TextUtils.isEmpty(paramBaseFilterMaterial.name));
  }
  
  public static boolean isValid(FilterParam paramFilterParam)
  {
    return (paramFilterParam != null) && (!TextUtils.isEmpty(paramFilterParam.name));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.MaterialUtil
 * JD-Core Version:    0.7.0.1
 */