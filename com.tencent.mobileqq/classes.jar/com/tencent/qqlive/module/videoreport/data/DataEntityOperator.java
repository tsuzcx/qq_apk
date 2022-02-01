package com.tencent.qqlive.module.videoreport.data;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class DataEntityOperator
{
  public static DataEntity copy(DataEntity paramDataEntity)
  {
    Object localObject = null;
    DataEntity localDataEntity = new DataEntity();
    localDataEntity.elementId = paramDataEntity.elementId;
    localDataEntity.pageId = paramDataEntity.pageId;
    localDataEntity.pageContentId = paramDataEntity.pageContentId;
    HashMap localHashMap;
    if (paramDataEntity.elementParams == null)
    {
      localHashMap = null;
      localDataEntity.elementParams = localHashMap;
      if (paramDataEntity.pageParams != null) {
        break label93;
      }
      localHashMap = null;
      label57:
      localDataEntity.pageParams = localHashMap;
      if (paramDataEntity.innerParams != null) {
        break label108;
      }
    }
    label93:
    label108:
    for (paramDataEntity = localObject;; paramDataEntity = new HashMap(paramDataEntity.innerParams))
    {
      localDataEntity.innerParams = paramDataEntity;
      return localDataEntity;
      localHashMap = new HashMap(paramDataEntity.elementParams);
      break;
      localHashMap = new HashMap(paramDataEntity.pageParams);
      break label57;
    }
  }
  
  public static String getContentId(@Nullable DataEntity paramDataEntity)
  {
    if (paramDataEntity == null) {
      return null;
    }
    return paramDataEntity.pageContentId;
  }
  
  public static String getElementId(@Nullable DataEntity paramDataEntity)
  {
    if (paramDataEntity == null) {
      return null;
    }
    return paramDataEntity.elementId;
  }
  
  public static Map<String, ?> getElementParams(@Nullable DataEntity paramDataEntity)
  {
    if (paramDataEntity == null) {
      return null;
    }
    return paramDataEntity.elementParams;
  }
  
  @Nullable
  public static Object getInnerParam(DataEntity paramDataEntity, String paramString)
  {
    if ((paramDataEntity == null) || (paramDataEntity.innerParams == null)) {
      return null;
    }
    return paramDataEntity.innerParams.get(paramString);
  }
  
  public static String getPageId(@Nullable DataEntity paramDataEntity)
  {
    if (paramDataEntity == null) {
      return null;
    }
    return paramDataEntity.pageId;
  }
  
  public static Map<String, ?> getPageParams(@Nullable DataEntity paramDataEntity)
  {
    if (paramDataEntity == null) {
      return null;
    }
    return paramDataEntity.pageParams;
  }
  
  static void putInnerParam(DataEntity paramDataEntity, String paramString, Object paramObject)
  {
    if ((paramDataEntity == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    if (paramDataEntity.innerParams == null) {
      paramDataEntity.innerParams = new HashMap(1);
    }
    paramDataEntity.innerParams.put(paramString, paramObject);
  }
  
  static void removeAllElementParams(DataEntity paramDataEntity)
  {
    if ((paramDataEntity != null) && (paramDataEntity.elementParams != null)) {
      paramDataEntity.elementParams.clear();
    }
  }
  
  static void removeAllPageParams(DataEntity paramDataEntity)
  {
    if ((paramDataEntity != null) && (paramDataEntity.pageParams != null)) {
      paramDataEntity.pageParams.clear();
    }
  }
  
  static void removeElementParam(DataEntity paramDataEntity, String paramString)
  {
    if ((paramDataEntity != null) && (paramDataEntity.elementParams != null)) {
      paramDataEntity.elementParams.remove(paramString);
    }
  }
  
  static void removeInnerParam(DataEntity paramDataEntity, String paramString)
  {
    if ((paramDataEntity != null) && (paramDataEntity.innerParams != null)) {
      paramDataEntity.innerParams.remove(paramString);
    }
  }
  
  static void removePageParam(DataEntity paramDataEntity, String paramString)
  {
    if ((paramDataEntity != null) && (paramDataEntity.pageParams != null)) {
      paramDataEntity.pageParams.remove(paramString);
    }
  }
  
  public static void setElementId(DataEntity paramDataEntity, String paramString)
  {
    if (paramDataEntity != null) {
      paramDataEntity.elementId = paramString;
    }
  }
  
  public static void setElementParams(DataEntity paramDataEntity, String paramString, Object paramObject)
  {
    if ((paramDataEntity == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    if (paramDataEntity.elementParams == null) {
      paramDataEntity.elementParams = new HashMap(1);
    }
    paramDataEntity.elementParams.put(paramString, paramObject);
  }
  
  public static void setElementParams(DataEntity paramDataEntity, Map<String, ?> paramMap)
  {
    if ((paramDataEntity == null) || (paramMap == null)) {
      return;
    }
    if (paramDataEntity.elementParams == null) {
      paramDataEntity.elementParams = new HashMap(1);
    }
    paramDataEntity.elementParams.putAll(paramMap);
  }
  
  public static void setPageContentId(DataEntity paramDataEntity, String paramString)
  {
    if (paramDataEntity != null) {
      paramDataEntity.pageContentId = paramString;
    }
  }
  
  public static void setPageId(DataEntity paramDataEntity, String paramString)
  {
    if (paramDataEntity != null) {
      paramDataEntity.pageId = paramString;
    }
  }
  
  static void setPageParams(DataEntity paramDataEntity, String paramString, Object paramObject)
  {
    if ((paramDataEntity == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    if (paramDataEntity.pageParams == null) {
      paramDataEntity.pageParams = new HashMap(1);
    }
    paramDataEntity.pageParams.put(paramString, paramObject);
  }
  
  static void setPageParams(DataEntity paramDataEntity, Map<String, ?> paramMap)
  {
    if ((paramDataEntity == null) || (paramMap == null)) {
      return;
    }
    if (paramDataEntity.pageParams == null) {
      paramDataEntity.pageParams = new HashMap(1);
    }
    paramDataEntity.pageParams.putAll(paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.data.DataEntityOperator
 * JD-Core Version:    0.7.0.1
 */