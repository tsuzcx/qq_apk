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
    QQBaseFilter localQQBaseFilter = (QQBaseFilter)this.mFilterList.get(Integer.valueOf(paramInt));
    if (localQQBaseFilter == null) {
      throw new RuntimeException("getFilterByType failed type=" + paramInt);
    }
    return localQQBaseFilter;
  }
  
  QQBaseFilter getFilterByTypeWithCreate(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    QQBaseFilter localQQBaseFilter2 = (QQBaseFilter)this.mFilterList.get(Integer.valueOf(paramInt));
    QQBaseFilter localQQBaseFilter1 = localQQBaseFilter2;
    if (localQQBaseFilter2 == null)
    {
      localQQBaseFilter1 = FilterCreateFactory.createFilter(paramInt, paramQQFilterRenderManager);
      if (localQQBaseFilter1 == null) {
        throw new RuntimeException("createFilter failed type=" + paramInt);
      }
      this.mFilterList.put(Integer.valueOf(paramInt), localQQBaseFilter1);
    }
    return localQQBaseFilter1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.FilterCacheQueue
 * JD-Core Version:    0.7.0.1
 */