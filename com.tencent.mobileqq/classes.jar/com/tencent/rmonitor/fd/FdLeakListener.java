package com.tencent.rmonitor.fd;

import com.tencent.rmonitor.fd.analysis.data.FdLeakIssueResult;
import com.tencent.rmonitor.fd.dump.FdLeakDumpResult;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class FdLeakListener
  implements IFdLeakListener
{
  private final List<IFdLeakListener> a;
  
  FdLeakListener(List<IFdLeakListener> paramList)
  {
    if (paramList == null)
    {
      this.a = Collections.emptyList();
      return;
    }
    this.a = paramList;
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      IFdLeakListener localIFdLeakListener = (IFdLeakListener)localIterator.next();
      if (localIFdLeakListener != null) {
        localIFdLeakListener.a(paramInt);
      }
    }
  }
  
  public void a(int paramInt, FdLeakDumpResult paramFdLeakDumpResult)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      IFdLeakListener localIFdLeakListener = (IFdLeakListener)localIterator.next();
      if (localIFdLeakListener != null) {
        localIFdLeakListener.a(paramInt, paramFdLeakDumpResult);
      }
    }
  }
  
  public void a(FdLeakIssueResult paramFdLeakIssueResult)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      IFdLeakListener localIFdLeakListener = (IFdLeakListener)localIterator.next();
      if (localIFdLeakListener != null) {
        localIFdLeakListener.a(paramFdLeakIssueResult);
      }
    }
  }
  
  public void b()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      IFdLeakListener localIFdLeakListener = (IFdLeakListener)localIterator.next();
      if (localIFdLeakListener != null) {
        localIFdLeakListener.b();
      }
    }
  }
  
  public void dI_()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      IFdLeakListener localIFdLeakListener = (IFdLeakListener)localIterator.next();
      if (localIFdLeakListener != null) {
        localIFdLeakListener.dI_();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.FdLeakListener
 * JD-Core Version:    0.7.0.1
 */