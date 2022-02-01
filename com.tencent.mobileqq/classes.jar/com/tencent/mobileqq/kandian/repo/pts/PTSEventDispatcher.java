package com.tencent.mobileqq.kandian.repo.pts;

import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PTSEventDispatcher
{
  private static PTSEventDispatcher a;
  private final List<PTSEventDispatcher.PTSObserver> b = new ArrayList();
  
  public static PTSEventDispatcher a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new PTSEventDispatcher();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(int paramInt, List<Long> paramList, long paramLong)
  {
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        ((PTSEventDispatcher.PTSObserver)localIterator.next()).a(paramInt, paramList, paramLong);
      }
      return;
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void a(int paramInt, List<Long> paramList, boolean paramBoolean1, boolean paramBoolean2, ToServiceMsg paramToServiceMsg)
  {
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        ((PTSEventDispatcher.PTSObserver)localIterator.next()).a(paramInt, paramList, paramBoolean1, paramBoolean2, paramToServiceMsg);
      }
      return;
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void a(PTSEventDispatcher.PTSObserver paramPTSObserver)
  {
    if (paramPTSObserver == null) {
      return;
    }
    synchronized (this.b)
    {
      if (!this.b.contains(paramPTSObserver)) {
        this.b.add(paramPTSObserver);
      }
      return;
    }
  }
  
  public void b()
  {
    synchronized (this.b)
    {
      this.b.clear();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.pts.PTSEventDispatcher
 * JD-Core Version:    0.7.0.1
 */