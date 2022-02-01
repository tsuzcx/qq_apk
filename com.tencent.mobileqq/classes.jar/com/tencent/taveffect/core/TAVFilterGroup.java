package com.tencent.taveffect.core;

import android.graphics.Matrix;
import com.tencent.taveffect.effects.LookupFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class TAVFilterGroup
  extends TAVBaseFilter
{
  private LinkedList<TAVBaseFilter> filterLinkedList = new LinkedList();
  private TAVRendererFilter rendererFilter;
  private TextureMatrixFilter textureMatrixFilter = new TextureMatrixFilter();
  
  public TAVFilterGroup()
  {
    this(false);
  }
  
  public TAVFilterGroup(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.rendererFilter = new TAVRendererFilter();
    }
  }
  
  private TAVTextureInfo applyTexture(int paramInt, TAVTextureInfo paramTAVTextureInfo)
  {
    try
    {
      int i = this.filterLinkedList.size();
      if (paramInt >= i) {
        return paramTAVTextureInfo;
      }
      TAVBaseFilter localTAVBaseFilter = (TAVBaseFilter)this.filterLinkedList.get(paramInt);
      TAVTextureInfo localTAVTextureInfo = paramTAVTextureInfo;
      if (localTAVBaseFilter != null) {
        localTAVTextureInfo = localTAVBaseFilter.applyFilter(paramTAVTextureInfo);
      }
      paramTAVTextureInfo = applyTexture(paramInt + 1, localTAVTextureInfo);
      return paramTAVTextureInfo;
    }
    finally {}
  }
  
  private void updateTimeRange(TAVBaseFilter paramTAVBaseFilter)
  {
    TAVTimeRange localTAVTimeRange1 = paramTAVBaseFilter.getTimeRange();
    if (localTAVTimeRange1 == null) {
      return;
    }
    ListIterator localListIterator = this.filterLinkedList.listIterator();
    while (localListIterator.hasNext())
    {
      TAVBaseFilter localTAVBaseFilter = (TAVBaseFilter)localListIterator.next();
      if ((localTAVBaseFilter != paramTAVBaseFilter) && (!(localTAVBaseFilter instanceof LookupFilter)))
      {
        TAVTimeRange localTAVTimeRange2 = localTAVBaseFilter.getTimeRange();
        if ((localTAVTimeRange2 != null) && (localTAVTimeRange2.duration() > 0L))
        {
          if ((localTAVTimeRange1.start() > localTAVTimeRange2.end()) && (localTAVTimeRange1.start() <= localTAVTimeRange2.end() + 10000L)) {
            localTAVTimeRange1.update(localTAVTimeRange2.end(), localTAVTimeRange1.end() - localTAVTimeRange2.end());
          }
          if ((localTAVTimeRange1.end() < localTAVTimeRange2.start()) && (localTAVTimeRange1.end() >= localTAVTimeRange2.start() - 10000L)) {
            localTAVTimeRange1.update(localTAVTimeRange1.start(), localTAVTimeRange2.start() - localTAVTimeRange1.start());
          }
          if ((localTAVTimeRange1.start() > localTAVTimeRange2.start()) && (localTAVTimeRange1.start() < localTAVTimeRange2.end()) && (localTAVTimeRange1.end() >= localTAVTimeRange2.end()))
          {
            localTAVTimeRange2.update(localTAVTimeRange2.start(), localTAVTimeRange1.start() - localTAVTimeRange2.start());
          }
          else if ((localTAVTimeRange1.end() > localTAVTimeRange2.start()) && (localTAVTimeRange1.end() < localTAVTimeRange2.end()) && (localTAVTimeRange1.start() <= localTAVTimeRange2.start()))
          {
            localTAVTimeRange2.update(localTAVTimeRange1.end(), localTAVTimeRange2.end() - localTAVTimeRange1.end());
          }
          else if ((localTAVTimeRange1.start() > localTAVTimeRange2.start()) && (localTAVTimeRange1.end() < localTAVTimeRange2.end()))
          {
            localTAVBaseFilter = localTAVBaseFilter.clone();
            localTAVBaseFilter.getTimeRange().update(localTAVTimeRange2.start(), localTAVTimeRange1.start() - localTAVTimeRange2.start());
            localListIterator.add(localTAVBaseFilter);
            localTAVTimeRange2.update(localTAVTimeRange1.end(), localTAVTimeRange2.end() - localTAVTimeRange1.start());
          }
          else if ((localTAVTimeRange1.start() <= localTAVTimeRange2.start()) && (localTAVTimeRange1.end() >= localTAVTimeRange2.end()))
          {
            localTAVTimeRange2.update(localTAVTimeRange2.start(), 0L);
          }
        }
        else
        {
          localTAVBaseFilter.release();
          localListIterator.remove();
        }
      }
    }
  }
  
  public void add(TAVBaseFilter paramTAVBaseFilter)
  {
    if (paramTAVBaseFilter == null) {
      return;
    }
    try
    {
      boolean bool = this.filterLinkedList.contains(paramTAVBaseFilter);
      if (bool) {
        return;
      }
      this.filterLinkedList.add(paramTAVBaseFilter);
      return;
    }
    finally {}
  }
  
  public void addAll(List<TAVBaseFilter> paramList)
  {
    if (paramList != null) {
      try
      {
        if (!paramList.isEmpty())
        {
          this.filterLinkedList.addAll(paramList);
          return;
        }
      }
      finally {}
    }
  }
  
  public TAVTextureInfo applyFilter(TAVTextureInfo paramTAVTextureInfo)
  {
    Object localObject = this.textureMatrixFilter;
    TAVTextureInfo localTAVTextureInfo = paramTAVTextureInfo;
    if (localObject != null) {
      localTAVTextureInfo = ((TextureMatrixFilter)localObject).applyFilter(paramTAVTextureInfo);
    }
    localTAVTextureInfo = applyTexture(0, localTAVTextureInfo);
    localObject = this.rendererFilter;
    paramTAVTextureInfo = localTAVTextureInfo;
    if (localObject != null) {
      paramTAVTextureInfo = ((TAVRendererFilter)localObject).applyFilter(localTAVTextureInfo);
    }
    return paramTAVTextureInfo;
  }
  
  public TAVTextureInfo applyNewTexture(TAVTextureInfo paramTAVTextureInfo)
  {
    return paramTAVTextureInfo;
  }
  
  public TAVFilterGroup clone()
  {
    TAVFilterGroup localTAVFilterGroup = new TAVFilterGroup();
    Object localObject = this.textureMatrixFilter;
    if (localObject != null) {
      localTAVFilterGroup.textureMatrixFilter = ((TextureMatrixFilter)localObject).clone();
    }
    localObject = this.rendererFilter;
    if (localObject != null) {
      localTAVFilterGroup.rendererFilter = ((TAVRendererFilter)localObject).clone();
    }
    localObject = this.filterLinkedList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      TAVBaseFilter localTAVBaseFilter = (TAVBaseFilter)((Iterator)localObject).next();
      if (localTAVBaseFilter != null) {
        localTAVFilterGroup.add(localTAVBaseFilter.clone());
      }
    }
    return localTAVFilterGroup;
  }
  
  public boolean contains(TAVBaseFilter paramTAVBaseFilter)
  {
    try
    {
      boolean bool = this.filterLinkedList.contains(paramTAVBaseFilter);
      return bool;
    }
    finally
    {
      paramTAVBaseFilter = finally;
      throw paramTAVBaseFilter;
    }
  }
  
  public TAVBaseFilter getByFilterId(long paramLong)
  {
    Iterator localIterator = this.filterLinkedList.iterator();
    while (localIterator.hasNext())
    {
      TAVBaseFilter localTAVBaseFilter = (TAVBaseFilter)localIterator.next();
      if ((localTAVBaseFilter != null) && (localTAVBaseFilter.id == paramLong)) {
        return localTAVBaseFilter;
      }
    }
    return null;
  }
  
  public TAVBaseFilter getByTimeRange(TAVTimeRange paramTAVTimeRange)
  {
    Iterator localIterator = this.filterLinkedList.iterator();
    while (localIterator.hasNext())
    {
      TAVBaseFilter localTAVBaseFilter = (TAVBaseFilter)localIterator.next();
      if ((localTAVBaseFilter != null) && (localTAVBaseFilter.getTimeRange().equals(paramTAVTimeRange))) {
        return localTAVBaseFilter;
      }
    }
    return null;
  }
  
  public List<TAVBaseFilter> getCloneFilterGroup()
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.filterLinkedList.iterator();
      while (localIterator.hasNext())
      {
        TAVBaseFilter localTAVBaseFilter = (TAVBaseFilter)localIterator.next();
        if (localTAVBaseFilter != null) {
          localArrayList.add(localTAVBaseFilter.clone());
        }
      }
      return localArrayList;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public List<TAVBaseFilter> getFilterGroup()
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.filterLinkedList.iterator();
      while (localIterator.hasNext())
      {
        TAVBaseFilter localTAVBaseFilter = (TAVBaseFilter)localIterator.next();
        if (localTAVBaseFilter != null) {
          localArrayList.add(localTAVBaseFilter);
        }
      }
      return localArrayList;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public boolean hasRender()
  {
    try
    {
      TAVRendererFilter localTAVRendererFilter = this.rendererFilter;
      boolean bool;
      if (localTAVRendererFilter != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void release()
  {
    try
    {
      Iterator localIterator = this.filterLinkedList.iterator();
      while (localIterator.hasNext())
      {
        TAVBaseFilter localTAVBaseFilter = (TAVBaseFilter)localIterator.next();
        if (localTAVBaseFilter != null) {
          localTAVBaseFilter.release();
        }
      }
      if (this.textureMatrixFilter != null) {
        this.textureMatrixFilter.release();
      }
      if (this.rendererFilter != null) {
        this.rendererFilter.release();
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void releaseFilterGroup()
  {
    try
    {
      Iterator localIterator = this.filterLinkedList.iterator();
      while (localIterator.hasNext())
      {
        TAVBaseFilter localTAVBaseFilter = (TAVBaseFilter)localIterator.next();
        if (localTAVBaseFilter != null) {
          localTAVBaseFilter.release();
        }
      }
      this.filterLinkedList.clear();
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void remove(TAVBaseFilter paramTAVBaseFilter)
  {
    try
    {
      if (this.filterLinkedList.remove(paramTAVBaseFilter)) {
        paramTAVBaseFilter.release();
      }
      return;
    }
    finally
    {
      paramTAVBaseFilter = finally;
      throw paramTAVBaseFilter;
    }
  }
  
  public void remove(Class<? extends TAVBaseFilter> paramClass)
  {
    try
    {
      Iterator localIterator = this.filterLinkedList.iterator();
      while (localIterator.hasNext())
      {
        TAVBaseFilter localTAVBaseFilter = (TAVBaseFilter)localIterator.next();
        if (localTAVBaseFilter.getClass() == paramClass)
        {
          localIterator.remove();
          localTAVBaseFilter.release();
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramClass;
    }
  }
  
  public void removeLast()
  {
    try
    {
      if (this.filterLinkedList.size() > 0) {
        this.filterLinkedList.removeLast();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void reset()
  {
    try
    {
      this.filterLinkedList.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setOverlay(boolean paramBoolean)
  {
    try
    {
      Iterator localIterator = this.filterLinkedList.iterator();
      while (localIterator.hasNext())
      {
        TAVBaseFilter localTAVBaseFilter = (TAVBaseFilter)localIterator.next();
        if (localTAVBaseFilter != null) {
          localTAVBaseFilter.setOverlay(paramBoolean);
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void setParams(Matrix paramMatrix1, Matrix paramMatrix2, TAVRectangle paramTAVRectangle, float paramFloat)
  {
    Object localObject = this.textureMatrixFilter;
    if (localObject != null) {
      ((TextureMatrixFilter)localObject).setParams(paramMatrix1, paramMatrix2, paramTAVRectangle, paramFloat);
    }
    localObject = this.rendererFilter;
    if (localObject != null) {
      ((TAVRendererFilter)localObject).setParams(paramMatrix1, paramMatrix2, paramTAVRectangle, paramFloat);
    }
    localObject = this.filterLinkedList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((TAVBaseFilter)((Iterator)localObject).next()).setParams(paramMatrix1, paramMatrix2, paramTAVRectangle, paramFloat);
    }
  }
  
  public void setRendererHeight(int paramInt)
  {
    try
    {
      if (this.textureMatrixFilter != null) {
        this.textureMatrixFilter.setRendererHeight(paramInt);
      }
      if (this.rendererFilter != null) {
        this.rendererFilter.setRendererHeight(paramInt);
      }
      Iterator localIterator = this.filterLinkedList.iterator();
      while (localIterator.hasNext())
      {
        TAVBaseFilter localTAVBaseFilter = (TAVBaseFilter)localIterator.next();
        if (localTAVBaseFilter != null) {
          localTAVBaseFilter.setRendererHeight(paramInt);
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void setRendererWidth(int paramInt)
  {
    try
    {
      if (this.textureMatrixFilter != null) {
        this.textureMatrixFilter.setRendererWidth(paramInt);
      }
      if (this.rendererFilter != null) {
        this.rendererFilter.setRendererWidth(paramInt);
      }
      Iterator localIterator = this.filterLinkedList.iterator();
      while (localIterator.hasNext())
      {
        TAVBaseFilter localTAVBaseFilter = (TAVBaseFilter)localIterator.next();
        if (localTAVBaseFilter != null) {
          localTAVBaseFilter.setRendererWidth(paramInt);
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void setTimeRange(TAVTimeRange paramTAVTimeRange)
  {
    try
    {
      Iterator localIterator = this.filterLinkedList.iterator();
      while (localIterator.hasNext())
      {
        TAVBaseFilter localTAVBaseFilter = (TAVBaseFilter)localIterator.next();
        if (localTAVBaseFilter != null) {
          localTAVBaseFilter.setTimeRange(paramTAVTimeRange);
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramTAVTimeRange;
    }
  }
  
  public int size()
  {
    try
    {
      int i = this.filterLinkedList.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void update(TAVBaseFilter paramTAVBaseFilter)
  {
    try
    {
      int i = this.filterLinkedList.indexOf(paramTAVBaseFilter);
      if (i != -1)
      {
        this.filterLinkedList.set(i, paramTAVBaseFilter);
        updateTimeRange(paramTAVBaseFilter);
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.taveffect.core.TAVFilterGroup
 * JD-Core Version:    0.7.0.1
 */