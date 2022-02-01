package com.tencent.qqlive.module.videoreport.reportdata;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.data.DataEntity;
import com.tencent.qqlive.module.videoreport.data.DataEntityOperator;

public class PathDataUtils
{
  public static boolean canCollect(@Nullable DataEntity paramDataEntity)
  {
    if (paramDataEntity == null) {
      return false;
    }
    return isExistElementId(paramDataEntity);
  }
  
  private static boolean isExistElementId(@Nullable DataEntity paramDataEntity)
  {
    if (paramDataEntity == null) {
      return false;
    }
    return TextUtils.isEmpty(DataEntityOperator.getElementId(paramDataEntity)) ^ true;
  }
  
  public static boolean shouldStop(@Nullable DataEntity paramDataEntity)
  {
    if (paramDataEntity == null) {
      return false;
    }
    return TextUtils.isEmpty(DataEntityOperator.getPageId(paramDataEntity)) ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.reportdata.PathDataUtils
 * JD-Core Version:    0.7.0.1
 */