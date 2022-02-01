package com.tencent.qqlive.module.videoreport.reportdata;

import com.tencent.qqlive.module.videoreport.data.DataEntity;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class PathData
{
  private WeakReference<Object> mPageRef;
  private final Deque<DataEntity> mPathPackages = new ArrayDeque();
  
  public void addFirst(DataEntity paramDataEntity)
  {
    this.mPathPackages.addFirst(paramDataEntity);
  }
  
  public void addLast(DataEntity paramDataEntity)
  {
    this.mPathPackages.addLast(paramDataEntity);
  }
  
  public PathData copy()
  {
    PathData localPathData = new PathData();
    localPathData.mPageRef = this.mPageRef;
    Iterator localIterator = this.mPathPackages.iterator();
    while (localIterator.hasNext())
    {
      DataEntity localDataEntity = (DataEntity)localIterator.next();
      localPathData.mPathPackages.addLast(localDataEntity);
    }
    return localPathData;
  }
  
  public Iterator<DataEntity> descendingIterator()
  {
    return this.mPathPackages.descendingIterator();
  }
  
  public Object getPage()
  {
    WeakReference localWeakReference = this.mPageRef;
    if (localWeakReference != null) {
      return localWeakReference.get();
    }
    return null;
  }
  
  public boolean isEmpty()
  {
    return this.mPathPackages.isEmpty();
  }
  
  public Iterator<DataEntity> iterator()
  {
    return this.mPathPackages.iterator();
  }
  
  public void removeFirst()
  {
    if (!this.mPathPackages.isEmpty()) {
      this.mPathPackages.removeFirst();
    }
  }
  
  public void setPage(Object paramObject)
  {
    this.mPageRef = new WeakReference(paramObject);
  }
  
  public int size()
  {
    return this.mPathPackages.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.reportdata.PathData
 * JD-Core Version:    0.7.0.1
 */