package com.tencent.qqlive.module.videoreport.data;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import com.tencent.qqlive.module.videoreport.utils.DynamicEventUtils;
import java.util.HashMap;
import java.util.Map;

public class DataEntityOperator
{
  public static DataEntity copy(@NonNull DataEntity paramDataEntity)
  {
    return paramDataEntity.copy();
  }
  
  public static String getContentId(@Nullable DataEntity paramDataEntity)
  {
    if (paramDataEntity == null) {
      return null;
    }
    return paramDataEntity.pageContentId;
  }
  
  @Nullable
  public static Map<String, Object> getDynamicElementParams(String paramString, @Nullable DataEntity paramDataEntity)
  {
    Object localObject = null;
    if (paramDataEntity == null) {
      return null;
    }
    if (!DynamicEventUtils.filterDynamicEvent(paramString)) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    if (paramDataEntity.getEventDynamicParams() == null) {
      paramString = localObject;
    } else {
      paramString = paramDataEntity.getEventDynamicParams().getDynamicParams(paramString);
    }
    if (!BaseUtils.isEmpty(paramString)) {
      localHashMap.putAll(paramString);
    }
    return localHashMap;
  }
  
  public static String getElementId(@Nullable DataEntity paramDataEntity)
  {
    if (paramDataEntity == null) {
      return null;
    }
    return paramDataEntity.elementId;
  }
  
  @Nullable
  public static Map<String, ?> getElementParams(@Nullable DataEntity paramDataEntity)
  {
    Object localObject = null;
    if (paramDataEntity == null) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    if (!BaseUtils.isEmpty(paramDataEntity.elementParams)) {
      localHashMap.putAll(paramDataEntity.elementParams);
    }
    if (paramDataEntity.elementDynamicParams == null) {
      paramDataEntity = localObject;
    } else {
      paramDataEntity = paramDataEntity.elementDynamicParams.getElementDynamicParams();
    }
    if (!BaseUtils.isEmpty(paramDataEntity)) {
      localHashMap.putAll(paramDataEntity);
    }
    return localHashMap;
  }
  
  public static Object getExtendParam(DataEntity paramDataEntity, String paramString)
  {
    if ((paramDataEntity != null) && (!TextUtils.isEmpty(paramString)) && (paramDataEntity.extendMap != null)) {
      return paramDataEntity.extendMap.get(paramString);
    }
    return null;
  }
  
  @Nullable
  public static Object getInnerParam(DataEntity paramDataEntity, String paramString)
  {
    if ((paramDataEntity != null) && (paramDataEntity.innerParams != null)) {
      return paramDataEntity.innerParams.get(paramString);
    }
    return null;
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
  
  public static DataEntity getParentEntity(DataEntity paramDataEntity)
  {
    if (paramDataEntity != null) {
      return paramDataEntity.parentEntity;
    }
    return null;
  }
  
  @Nullable
  public static SparseArray<ElementDataEntity> getVirtualElementParentParams(@Nullable DataEntity paramDataEntity)
  {
    if (paramDataEntity == null) {
      return null;
    }
    return paramDataEntity.elementVirtualParentParams;
  }
  
  public static void putExtendParam(DataEntity paramDataEntity, String paramString, Object paramObject)
  {
    if (paramDataEntity != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (paramDataEntity.extendMap == null) {
        paramDataEntity.extendMap = new HashMap(1);
      }
      paramDataEntity.extendMap.put(paramString, paramObject);
    }
  }
  
  public static void putInnerParam(DataEntity paramDataEntity, String paramString, Object paramObject)
  {
    if (paramDataEntity != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (paramDataEntity.innerParams == null) {
        paramDataEntity.innerParams = new HashMap(1);
      }
      paramDataEntity.innerParams.put(paramString, paramObject);
    }
  }
  
  static void removeAllElementParams(DataEntity paramDataEntity)
  {
    if (paramDataEntity == null) {
      return;
    }
    if (paramDataEntity.elementParams != null) {
      paramDataEntity.elementParams.clear();
    }
    paramDataEntity.elementDynamicParams = null;
    if (paramDataEntity.elementVirtualParentParams != null) {
      paramDataEntity.elementVirtualParentParams.clear();
    }
    paramDataEntity.elementVirtualParentParams = null;
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
  
  public static void removeInnerParam(DataEntity paramDataEntity, String paramString)
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
  
  public static void setElementParams(DataEntity paramDataEntity, IElementDynamicParams paramIElementDynamicParams)
  {
    if (paramDataEntity == null) {
      return;
    }
    paramDataEntity.elementDynamicParams = paramIElementDynamicParams;
  }
  
  public static void setElementParams(DataEntity paramDataEntity, String paramString, Object paramObject)
  {
    if (paramDataEntity != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (paramDataEntity.elementParams == null) {
        paramDataEntity.elementParams = new HashMap(1);
      }
      paramDataEntity.elementParams.put(paramString, paramObject);
    }
  }
  
  public static void setElementParams(DataEntity paramDataEntity, Map<String, ?> paramMap)
  {
    if (paramDataEntity != null)
    {
      if (paramMap == null) {
        return;
      }
      if (paramDataEntity.elementParams == null) {
        paramDataEntity.elementParams = new HashMap(1);
      }
      paramDataEntity.elementParams.putAll(paramMap);
    }
  }
  
  public static void setElementVirtualParentParams(DataEntity paramDataEntity, int paramInt, String paramString, @Nullable Map<String, Object> paramMap)
  {
    if (paramDataEntity != null)
    {
      if (paramInt <= 0) {
        return;
      }
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (paramDataEntity.elementVirtualParentParams == null) {
        paramDataEntity.elementVirtualParentParams = new SparseArray();
      }
      ElementDataEntity localElementDataEntity = new ElementDataEntity();
      localElementDataEntity.elementId = paramString;
      localElementDataEntity.elementParams = paramMap;
      paramDataEntity.elementVirtualParentParams.put(paramInt, localElementDataEntity);
    }
  }
  
  public static void setEventDynamicParams(DataEntity paramDataEntity, @Nullable IDynamicParams paramIDynamicParams)
  {
    if (paramDataEntity == null) {
      return;
    }
    paramDataEntity.eventDynamicParams = paramIDynamicParams;
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
  
  public static void setPageParams(DataEntity paramDataEntity, String paramString, Object paramObject)
  {
    if (paramDataEntity != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (paramDataEntity.pageParams == null) {
        paramDataEntity.pageParams = new HashMap(1);
      }
      paramDataEntity.pageParams.put(paramString, paramObject);
    }
  }
  
  static void setPageParams(DataEntity paramDataEntity, Map<String, ?> paramMap)
  {
    if (paramDataEntity != null)
    {
      if (paramMap == null) {
        return;
      }
      if (paramDataEntity.pageParams == null) {
        paramDataEntity.pageParams = new HashMap(1);
      }
      paramDataEntity.pageParams.putAll(paramMap);
    }
  }
  
  public static void setParentEntity(DataEntity paramDataEntity1, DataEntity paramDataEntity2)
  {
    if (paramDataEntity1 != null) {
      paramDataEntity1.parentEntity = paramDataEntity2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.data.DataEntityOperator
 * JD-Core Version:    0.7.0.1
 */