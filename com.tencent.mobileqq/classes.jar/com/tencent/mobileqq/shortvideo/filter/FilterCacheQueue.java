package com.tencent.mobileqq.shortvideo.filter;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

final class FilterCacheQueue
{
  private ConcurrentHashMap<Integer, QQBaseFilter> mFilterList = new ConcurrentHashMap(15);
  
  void clearAll()
  {
    this.mFilterList.clear();
  }
  
  int countFilter()
  {
    return this.mFilterList.size();
  }
  
  QQBaseFilter getFilterByType(int paramInt)
  {
    Object localObject = (QQBaseFilter)this.mFilterList.get(Integer.valueOf(paramInt));
    if (localObject != null) {
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getFilterByType failed type=");
    ((StringBuilder)localObject).append(paramInt);
    throw new RuntimeException(((StringBuilder)localObject).toString());
  }
  
  QQBaseFilter getFilterByTypeWithCreate(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    QQBaseFilter localQQBaseFilter = (QQBaseFilter)this.mFilterList.get(Integer.valueOf(paramInt));
    if (localQQBaseFilter == null)
    {
      paramQQFilterRenderManager = FilterCreateFactory.createFilter(paramInt, paramQQFilterRenderManager);
      if (paramQQFilterRenderManager != null)
      {
        this.mFilterList.put(Integer.valueOf(paramInt), paramQQFilterRenderManager);
        return paramQQFilterRenderManager;
      }
      paramQQFilterRenderManager = new StringBuilder();
      paramQQFilterRenderManager.append("createFilter failed type=");
      paramQQFilterRenderManager.append(paramInt);
      throw new RuntimeException(paramQQFilterRenderManager.toString());
    }
    return localQQBaseFilter;
  }
  
  Collection<QQBaseFilter> getFilterList()
  {
    return this.mFilterList.values();
  }
  
  boolean hasFilter(int paramInt)
  {
    return this.mFilterList.get(Integer.valueOf(paramInt)) != null;
  }
  
  void removeFilter(int paramInt)
  {
    this.mFilterList.remove(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.FilterCacheQueue
 * JD-Core Version:    0.7.0.1
 */