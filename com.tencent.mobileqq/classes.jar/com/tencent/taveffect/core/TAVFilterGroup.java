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
  
  /* Error */
  private TAVTextureInfo applyTexture(int paramInt, TAVTextureInfo paramTAVTextureInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 24	com/tencent/taveffect/core/TAVFilterGroup:filterLinkedList	Ljava/util/LinkedList;
    //   6: invokevirtual 40	java/util/LinkedList:size	()I
    //   9: istore_3
    //   10: iload_1
    //   11: iload_3
    //   12: if_icmplt +7 -> 19
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_2
    //   18: areturn
    //   19: aload_0
    //   20: getfield 24	com/tencent/taveffect/core/TAVFilterGroup:filterLinkedList	Ljava/util/LinkedList;
    //   23: iload_1
    //   24: invokevirtual 44	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   27: checkcast 4	com/tencent/taveffect/core/TAVBaseFilter
    //   30: astore 5
    //   32: aload_2
    //   33: astore 4
    //   35: aload 5
    //   37: ifnull +11 -> 48
    //   40: aload 5
    //   42: aload_2
    //   43: invokevirtual 48	com/tencent/taveffect/core/TAVBaseFilter:applyFilter	(Lcom/tencent/taveffect/core/TAVTextureInfo;)Lcom/tencent/taveffect/core/TAVTextureInfo;
    //   46: astore 4
    //   48: aload_0
    //   49: iload_1
    //   50: iconst_1
    //   51: iadd
    //   52: aload 4
    //   54: invokespecial 50	com/tencent/taveffect/core/TAVFilterGroup:applyTexture	(ILcom/tencent/taveffect/core/TAVTextureInfo;)Lcom/tencent/taveffect/core/TAVTextureInfo;
    //   57: astore_2
    //   58: goto -43 -> 15
    //   61: astore_2
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_2
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	TAVFilterGroup
    //   0	66	1	paramInt	int
    //   0	66	2	paramTAVTextureInfo	TAVTextureInfo
    //   9	4	3	i	int
    //   33	20	4	localTAVTextureInfo	TAVTextureInfo
    //   30	11	5	localTAVBaseFilter	TAVBaseFilter
    // Exception table:
    //   from	to	target	type
    //   2	10	61	finally
    //   19	32	61	finally
    //   40	48	61	finally
    //   48	58	61	finally
  }
  
  private void updateTimeRange(TAVBaseFilter paramTAVBaseFilter)
  {
    TAVTimeRange localTAVTimeRange1 = paramTAVBaseFilter.getTimeRange();
    if (localTAVTimeRange1 == null) {}
    for (;;)
    {
      return;
      ListIterator localListIterator = this.filterLinkedList.listIterator();
      while (localListIterator.hasNext())
      {
        TAVBaseFilter localTAVBaseFilter = (TAVBaseFilter)localListIterator.next();
        if ((localTAVBaseFilter != paramTAVBaseFilter) && (!(localTAVBaseFilter instanceof LookupFilter)))
        {
          TAVTimeRange localTAVTimeRange2 = localTAVBaseFilter.getTimeRange();
          if ((localTAVTimeRange2 == null) || (localTAVTimeRange2.duration() <= 0L))
          {
            localTAVBaseFilter.release();
            localListIterator.remove();
          }
          else
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
        }
      }
    }
  }
  
  public void add(TAVBaseFilter paramTAVBaseFilter)
  {
    if (paramTAVBaseFilter == null) {}
    for (;;)
    {
      return;
      try
      {
        if (this.filterLinkedList.contains(paramTAVBaseFilter)) {
          continue;
        }
        this.filterLinkedList.add(paramTAVBaseFilter);
      }
      finally {}
    }
  }
  
  /* Error */
  public void addAll(List<TAVBaseFilter> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +14 -> 17
    //   6: aload_1
    //   7: invokeinterface 117 1 0
    //   12: istore_2
    //   13: iload_2
    //   14: ifeq +6 -> 20
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: getfield 24	com/tencent/taveffect/core/TAVFilterGroup:filterLinkedList	Ljava/util/LinkedList;
    //   24: aload_1
    //   25: invokevirtual 120	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
    //   28: pop
    //   29: goto -12 -> 17
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	TAVFilterGroup
    //   0	37	1	paramList	List<TAVBaseFilter>
    //   12	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   6	13	32	finally
    //   20	29	32	finally
  }
  
  public TAVTextureInfo applyFilter(TAVTextureInfo paramTAVTextureInfo)
  {
    TAVTextureInfo localTAVTextureInfo = paramTAVTextureInfo;
    if (this.textureMatrixFilter != null) {
      localTAVTextureInfo = this.textureMatrixFilter.applyFilter(paramTAVTextureInfo);
    }
    localTAVTextureInfo = applyTexture(0, localTAVTextureInfo);
    paramTAVTextureInfo = localTAVTextureInfo;
    if (this.rendererFilter != null) {
      paramTAVTextureInfo = this.rendererFilter.applyFilter(localTAVTextureInfo);
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
    if (this.textureMatrixFilter != null) {
      localTAVFilterGroup.textureMatrixFilter = this.textureMatrixFilter.clone();
    }
    if (this.rendererFilter != null) {
      localTAVFilterGroup.rendererFilter = this.rendererFilter.clone();
    }
    Iterator localIterator = this.filterLinkedList.iterator();
    while (localIterator.hasNext())
    {
      TAVBaseFilter localTAVBaseFilter = (TAVBaseFilter)localIterator.next();
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
    }
    finally {}
    return localList;
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
    }
    finally {}
    return localList;
  }
  
  /* Error */
  public boolean hasRender()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 34	com/tencent/taveffect/core/TAVFilterGroup:rendererFilter	Lcom/tencent/taveffect/core/TAVRendererFilter;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +9 -> 17
    //   11: iconst_1
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_1
    //   19: goto -6 -> 13
    //   22: astore_2
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_2
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	TAVFilterGroup
    //   12	7	1	bool	boolean
    //   6	2	2	localTAVRendererFilter	TAVRendererFilter
    //   22	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
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
      if (this.textureMatrixFilter == null) {
        break label59;
      }
    }
    finally {}
    this.textureMatrixFilter.release();
    label59:
    if (this.rendererFilter != null) {
      this.rendererFilter.release();
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
    }
    finally {}
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
    }
    finally {}
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
    }
    finally {}
  }
  
  public void setParams(Matrix paramMatrix1, Matrix paramMatrix2, TAVRectangle paramTAVRectangle, float paramFloat)
  {
    if (this.textureMatrixFilter != null) {
      this.textureMatrixFilter.setParams(paramMatrix1, paramMatrix2, paramTAVRectangle, paramFloat);
    }
    if (this.rendererFilter != null) {
      this.rendererFilter.setParams(paramMatrix1, paramMatrix2, paramTAVRectangle, paramFloat);
    }
    Iterator localIterator = this.filterLinkedList.iterator();
    while (localIterator.hasNext()) {
      ((TAVBaseFilter)localIterator.next()).setParams(paramMatrix1, paramMatrix2, paramTAVRectangle, paramFloat);
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
    }
    finally {}
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
    }
    finally {}
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
    }
    finally {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.taveffect.core.TAVFilterGroup
 * JD-Core Version:    0.7.0.1
 */