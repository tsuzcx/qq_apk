package com.tencent.qqlive.module.videoreport.data;

import android.support.annotation.Nullable;
import android.util.SparseArray;
import java.util.HashMap;
import java.util.Map;

public class DataEntity
{
  @Nullable
  IElementDynamicParams dynamicParams;
  String elementId;
  Map<String, Object> elementParams;
  SparseArray<ElementDataEntity> elementVirtualParentParams;
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
    if (paramElementDataEntity.elementParams == null) {}
    for (paramElementDataEntity = localObject;; paramElementDataEntity = new HashMap(paramElementDataEntity.elementParams))
    {
      localElementDataEntity.elementParams = paramElementDataEntity;
      return localElementDataEntity;
    }
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
    Object localObject2 = null;
    DataEntity localDataEntity = new DataEntity();
    localDataEntity.elementId = this.elementId;
    if (this.elementParams == null)
    {
      localObject1 = null;
      localDataEntity.elementParams = ((Map)localObject1);
      localDataEntity.dynamicParams = this.dynamicParams;
      localDataEntity.elementVirtualParentParams = copyVirtualParentParams(this.elementVirtualParentParams);
      localDataEntity.pageId = this.pageId;
      localDataEntity.pageContentId = this.pageContentId;
      if (this.pageParams != null) {
        break label127;
      }
      localObject1 = null;
      label77:
      localDataEntity.pageParams = ((Map)localObject1);
      if (this.innerParams != null) {
        break label142;
      }
      localObject1 = null;
      label91:
      localDataEntity.innerParams = ((Map)localObject1);
      if (this.parentEntity != null) {
        break label157;
      }
    }
    label142:
    label157:
    for (Object localObject1 = localObject2;; localObject1 = this.parentEntity.copy())
    {
      localDataEntity.parentEntity = ((DataEntity)localObject1);
      return localDataEntity;
      localObject1 = new HashMap(this.elementParams);
      break;
      label127:
      localObject1 = new HashMap(this.pageParams);
      break label77;
      localObject1 = new HashMap(this.innerParams);
      break label91;
    }
  }
  
  public String toString()
  {
    return "DataEntity{elementId='" + this.elementId + '\'' + ", elementParams=" + this.elementParams + ", pageId='" + this.pageId + '\'' + ", pageContentId='" + this.pageContentId + '\'' + ", pageParams=" + this.pageParams + ", innerParams=" + this.innerParams + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.data.DataEntity
 * JD-Core Version:    0.7.0.1
 */