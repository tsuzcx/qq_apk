package com.tencent.qqlive.module.videoreport.data;

import android.support.annotation.Nullable;
import java.util.Map;

public class DataRWProxy
{
  public static String getContentId(Object paramObject)
  {
    return DataEntityOperator.getContentId(getDataEntity(paramObject, false));
  }
  
  public static DataEntity getDataEntity(Object paramObject, boolean paramBoolean)
  {
    DataEntity localDataEntity2 = DataBinder.getDataEntity(paramObject);
    DataEntity localDataEntity1 = localDataEntity2;
    if (localDataEntity2 == null)
    {
      localDataEntity1 = localDataEntity2;
      if (paramBoolean)
      {
        localDataEntity1 = new DataEntity();
        DataBinder.setDataEntity(paramObject, localDataEntity1);
      }
    }
    return localDataEntity1;
  }
  
  public static String getElementId(Object paramObject)
  {
    return DataEntityOperator.getElementId(getDataEntity(paramObject, false));
  }
  
  public static Map<String, ?> getElementParams(Object paramObject)
  {
    return DataEntityOperator.getElementParams(getDataEntity(paramObject, false));
  }
  
  public static Object getExtendParam(DataEntity paramDataEntity, String paramString)
  {
    return DataEntityOperator.getExtendParam(paramDataEntity, paramString);
  }
  
  public static Object getExtendParam(Object paramObject, String paramString)
  {
    return getExtendParam(getDataEntity(paramObject, true), paramString);
  }
  
  @Nullable
  public static Object getInnerParam(Object paramObject, String paramString)
  {
    return DataEntityOperator.getInnerParam(getDataEntity(paramObject, true), paramString);
  }
  
  public static String getPageId(Object paramObject)
  {
    return DataEntityOperator.getPageId(getDataEntity(paramObject, false));
  }
  
  public static Map<String, ?> getPageParams(Object paramObject)
  {
    return DataEntityOperator.getPageParams(getDataEntity(paramObject, false));
  }
  
  public static void putExtendParam(DataEntity paramDataEntity, String paramString, Object paramObject)
  {
    DataEntityOperator.putExtendParam(paramDataEntity, paramString, paramObject);
  }
  
  public static void putExtendParam(Object paramObject1, String paramString, Object paramObject2)
  {
    putExtendParam(getDataEntity(paramObject1, true), paramString, paramObject2);
  }
  
  public static void removeAllElementParams(Object paramObject)
  {
    DataEntityOperator.removeAllElementParams(getDataEntity(paramObject, false));
  }
  
  public static void removeAllPageParams(Object paramObject)
  {
    DataEntityOperator.removeAllPageParams(getDataEntity(paramObject, false));
  }
  
  public static void removeElementParam(Object paramObject, String paramString)
  {
    DataEntityOperator.removeElementParam(getDataEntity(paramObject, false), paramString);
  }
  
  public static void removeInnerParam(Object paramObject, String paramString)
  {
    DataEntityOperator.removeInnerParam(getDataEntity(paramObject, true), paramString);
  }
  
  public static void removePageParam(Object paramObject, String paramString)
  {
    DataEntityOperator.removePageParam(getDataEntity(paramObject, false), paramString);
  }
  
  @Deprecated
  public static void setElementDynamicParam(Object paramObject, IElementDynamicParams paramIElementDynamicParams)
  {
    DataEntityOperator.setElementParams(getDataEntity(paramObject, true), paramIElementDynamicParams);
  }
  
  public static void setElementId(Object paramObject, String paramString)
  {
    DataEntityOperator.setElementId(getDataEntity(paramObject, true), paramString);
  }
  
  public static void setElementParam(Object paramObject1, String paramString, Object paramObject2)
  {
    DataEntityOperator.setElementParams(getDataEntity(paramObject1, true), paramString, paramObject2);
  }
  
  public static void setElementParams(Object paramObject, Map<String, ?> paramMap)
  {
    DataEntityOperator.setElementParams(getDataEntity(paramObject, true), paramMap);
  }
  
  public static void setElementVirtualParentParams(Object paramObject, int paramInt, String paramString, Map<String, Object> paramMap)
  {
    DataEntityOperator.setElementVirtualParentParams(getDataEntity(paramObject, false), paramInt, paramString, paramMap);
  }
  
  public static void setEventDynamicParam(Object paramObject, @Nullable IDynamicParams paramIDynamicParams)
  {
    DataEntityOperator.setEventDynamicParams(getDataEntity(paramObject, true), paramIDynamicParams);
  }
  
  public static void setInnerParam(Object paramObject1, String paramString, Object paramObject2)
  {
    DataEntityOperator.putInnerParam(getDataEntity(paramObject1, true), paramString, paramObject2);
  }
  
  public static void setPageContentId(Object paramObject, String paramString)
  {
    DataEntityOperator.setPageContentId(getDataEntity(paramObject, true), paramString);
  }
  
  public static void setPageId(Object paramObject, String paramString)
  {
    DataEntityOperator.setPageId(getDataEntity(paramObject, true), paramString);
  }
  
  public static void setPageParams(Object paramObject1, String paramString, Object paramObject2)
  {
    DataEntityOperator.setPageParams(getDataEntity(paramObject1, true), paramString, paramObject2);
  }
  
  public static void setPageParams(Object paramObject, Map<String, ?> paramMap)
  {
    DataEntityOperator.setPageParams(getDataEntity(paramObject, true), paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.data.DataRWProxy
 * JD-Core Version:    0.7.0.1
 */