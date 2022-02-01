package com.tencent.qqlive.module.videoreport.data;

import android.support.annotation.Nullable;
import android.util.SparseArray;
import java.util.HashMap;
import java.util.Map;

public class DataEntity
{
  @Nullable
  IElementDynamicParams elementDynamicParams;
  String elementId;
  Map<String, Object> elementParams;
  SparseArray<ElementDataEntity> elementVirtualParentParams;
  @Nullable
  IDynamicParams eventDynamicParams;
  Map<String, Object> innerParams;
  String pageContentId;
  String pageId;
  Map<String, Object> pageParams;
  DataEntity parentEntity;
  
  private ElementDataEntity copyElementDataEntity(ElementDataEntity paramElementDataEntity)
  {
    Object localObject = null;
    if (paramElementDataEntity == null) {
      return null;
    }
    ElementDataEntity localElementDataEntity = new ElementDataEntity();
    localElementDataEntity.elementId = paramElementDataEntity.elementId;
    if (paramElementDataEntity.elementParams == null) {
      paramElementDataEntity = localObject;
    } else {
      paramElementDataEntity = new HashMap(paramElementDataEntity.elementParams);
    }
    localElementDataEntity.elementParams = paramElementDataEntity;
    return localElementDataEntity;
  }
  
  private SparseArray<ElementDataEntity> copyVirtualParentParams(SparseArray<ElementDataEntity> paramSparseArray)
  {
    if (paramSparseArray == null) {
      return null;
    }
    SparseArray localSparseArray = new SparseArray();
    int i = 0;
    while (i < paramSparseArray.size())
    {
      localSparseArray.put(paramSparseArray.keyAt(i), copyElementDataEntity((ElementDataEntity)paramSparseArray.valueAt(i)));
      i += 1;
    }
    return localSparseArray;
  }
  
  DataEntity copy()
  {
    DataEntity localDataEntity = new DataEntity();
    localDataEntity.elementId = this.elementId;
    Object localObject1 = this.elementParams;
    Object localObject2 = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = new HashMap((Map)localObject1);
    }
    localDataEntity.elementParams = ((Map)localObject1);
    localDataEntity.elementDynamicParams = this.elementDynamicParams;
    localDataEntity.elementVirtualParentParams = copyVirtualParentParams(this.elementVirtualParentParams);
    localDataEntity.pageId = this.pageId;
    localDataEntity.pageContentId = this.pageContentId;
    localObject1 = this.pageParams;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = new HashMap((Map)localObject1);
    }
    localDataEntity.pageParams = ((Map)localObject1);
    localObject1 = this.innerParams;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = new HashMap((Map)localObject1);
    }
    localDataEntity.innerParams = ((Map)localObject1);
    localObject1 = this.parentEntity;
    if (localObject1 == null) {
      localObject1 = localObject2;
    } else {
      localObject1 = ((DataEntity)localObject1).copy();
    }
    localDataEntity.parentEntity = ((DataEntity)localObject1);
    localDataEntity.eventDynamicParams = this.eventDynamicParams;
    return localDataEntity;
  }
  
  public IDynamicParams getEventDynamicParams()
  {
    return this.eventDynamicParams;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DataEntity{elementId='");
    localStringBuilder.append(this.elementId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", elementParams=");
    localStringBuilder.append(this.elementParams);
    localStringBuilder.append(", pageId='");
    localStringBuilder.append(this.pageId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", pageContentId='");
    localStringBuilder.append(this.pageContentId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", pageParams=");
    localStringBuilder.append(this.pageParams);
    localStringBuilder.append(", innerParams=");
    localStringBuilder.append(this.innerParams);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.data.DataEntity
 * JD-Core Version:    0.7.0.1
 */