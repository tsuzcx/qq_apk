package com.tencent.mobileqq.comment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DanmuDataHolder$CacheHolder
{
  DanmuDataIPCClient.DanmuPullCallback a;
  public DanmuDataContext b;
  public boolean c = false;
  int d = 0;
  int e = 30;
  List<Long> f;
  List<Long> g = new ArrayList();
  List<DanmuItemBean> h;
  List<DanmuItemBean> i = new ArrayList();
  int j = 0;
  int k = 0;
  int l = 0;
  int m = 60;
  
  public DanmuDataHolder$CacheHolder(DanmuDataHolder paramDanmuDataHolder) {}
  
  public CacheHolder a(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
  
  public CacheHolder a(DanmuDataContext paramDanmuDataContext)
  {
    this.b = paramDanmuDataContext;
    return this;
  }
  
  public CacheHolder a(DanmuDataIPCClient.DanmuPullCallback paramDanmuPullCallback)
  {
    this.a = paramDanmuPullCallback;
    return this;
  }
  
  public CacheHolder a(List<DanmuItemBean> paramList)
  {
    this.h = paramList;
    return this;
  }
  
  public CacheHolder a(boolean paramBoolean)
  {
    this.c = paramBoolean;
    return this;
  }
  
  public String a()
  {
    return String.format("CacheHolder - topicUin:%s, groupUin:%s, msgType:%s, peakCached:%s, videoStartTime:%s, videoEndTime:%s, nextStartIdx:%s, count:%s", new Object[] { Long.valueOf(this.b.a), Long.valueOf(this.b.b), Integer.valueOf(this.b.c), Boolean.valueOf(this.b.d), Integer.valueOf(this.j), Integer.valueOf(this.k), Integer.valueOf(this.l), Integer.valueOf(this.m) });
  }
  
  public boolean a(long paramLong1, long paramLong2)
  {
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext())
    {
      DanmuItemBean localDanmuItemBean = (DanmuItemBean)localIterator.next();
      if ((localDanmuItemBean.a == paramLong1) && (localDanmuItemBean.b == paramLong2)) {
        return true;
      }
    }
    return false;
  }
  
  public CacheHolder b()
  {
    DanmuDataHolder.a().a(DanmuDataHolder.a().a(this.b.b, this.b.a), this);
    return this;
  }
  
  public CacheHolder b(int paramInt)
  {
    if (paramInt > 0) {
      this.e = paramInt;
    }
    return this;
  }
  
  public CacheHolder b(List<Long> paramList)
  {
    this.f = paramList;
    return this;
  }
  
  public CacheHolder c(int paramInt)
  {
    this.l = paramInt;
    return this;
  }
  
  public void c()
  {
    Object localObject = this.i.iterator();
    DanmuItemBean localDanmuItemBean;
    while (((Iterator)localObject).hasNext())
    {
      localDanmuItemBean = (DanmuItemBean)((Iterator)localObject).next();
      if (this.f.contains(Long.valueOf(localDanmuItemBean.b))) {
        ((Iterator)localObject).remove();
      }
    }
    localObject = this.f;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = this.f.iterator();
      while (((Iterator)localObject).hasNext())
      {
        long l1 = ((Long)((Iterator)localObject).next()).longValue();
        if (!this.g.contains(Long.valueOf(l1))) {
          this.g.add(Long.valueOf(l1));
        }
      }
    }
    localObject = this.h;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = this.h.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localDanmuItemBean = (DanmuItemBean)((Iterator)localObject).next();
        if (!a(localDanmuItemBean.a, localDanmuItemBean.b)) {
          this.i.add(localDanmuItemBean);
        }
      }
    }
  }
  
  public CacheHolder d(int paramInt)
  {
    this.j = paramInt;
    return this;
  }
  
  public CacheHolder e(int paramInt)
  {
    this.k = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.comment.DanmuDataHolder.CacheHolder
 * JD-Core Version:    0.7.0.1
 */