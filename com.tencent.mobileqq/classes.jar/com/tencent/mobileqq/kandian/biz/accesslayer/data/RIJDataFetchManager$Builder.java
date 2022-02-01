package com.tencent.mobileqq.kandian.biz.accesslayer.data;

import android.app.Activity;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyPageItemCache;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyListViewGroup;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView;
import com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyBaseViewController;
import com.tencent.mobileqq.kandian.biz.framework.RIJFrameworkHeaderManager;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

public class RIJDataFetchManager$Builder
{
  ReadInJoyPageItemCache a;
  boolean b = false;
  boolean c = false;
  int d;
  Activity e;
  ReadInJoyBaseAdapter f;
  long g;
  ReadInJoyXListView h;
  int i;
  int j = 1;
  int k;
  ReadInJoyBaseViewController l;
  boolean m;
  boolean n;
  boolean o = false;
  boolean p = false;
  long q;
  AbsBaseArticleInfo r;
  RIJFrameworkHeaderManager s;
  boolean t;
  ReadInJoyListViewGroup u;
  
  public Builder a(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
  
  public Builder a(long paramLong)
  {
    this.g = paramLong;
    return this;
  }
  
  public Builder a(Activity paramActivity)
  {
    this.e = paramActivity;
    return this;
  }
  
  public Builder a(ReadInJoyPageItemCache paramReadInJoyPageItemCache)
  {
    this.a = paramReadInJoyPageItemCache;
    return this;
  }
  
  public Builder a(ReadInJoyListViewGroup paramReadInJoyListViewGroup)
  {
    this.u = paramReadInJoyListViewGroup;
    return this;
  }
  
  public Builder a(ReadInJoyXListView paramReadInJoyXListView)
  {
    this.h = paramReadInJoyXListView;
    return this;
  }
  
  public Builder a(ReadInJoyBaseViewController paramReadInJoyBaseViewController)
  {
    this.l = paramReadInJoyBaseViewController;
    return this;
  }
  
  public Builder a(RIJFrameworkHeaderManager paramRIJFrameworkHeaderManager)
  {
    this.s = paramRIJFrameworkHeaderManager;
    return this;
  }
  
  public Builder a(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    this.f = paramReadInJoyBaseAdapter;
    return this;
  }
  
  public Builder a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.r = paramAbsBaseArticleInfo;
    return this;
  }
  
  public Builder a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    return this;
  }
  
  public ReadInJoyListViewGroup a()
  {
    return this.u;
  }
  
  public Builder b(int paramInt)
  {
    this.i = paramInt;
    return this;
  }
  
  public Builder b(long paramLong)
  {
    this.q = paramLong;
    return this;
  }
  
  public Builder b(boolean paramBoolean)
  {
    this.c = paramBoolean;
    return this;
  }
  
  public boolean b()
  {
    return this.t;
  }
  
  public Builder c(int paramInt)
  {
    this.j = paramInt;
    return this;
  }
  
  public Builder c(boolean paramBoolean)
  {
    this.m = paramBoolean;
    return this;
  }
  
  public RIJFrameworkHeaderManager c()
  {
    return this.s;
  }
  
  public Builder d(int paramInt)
  {
    this.k = paramInt;
    return this;
  }
  
  public Builder d(boolean paramBoolean)
  {
    this.n = paramBoolean;
    return this;
  }
  
  public AbsBaseArticleInfo d()
  {
    return this.r;
  }
  
  public long e()
  {
    return this.q;
  }
  
  public Builder e(boolean paramBoolean)
  {
    this.o = paramBoolean;
    return this;
  }
  
  public Builder f(boolean paramBoolean)
  {
    this.p = paramBoolean;
    return this;
  }
  
  public boolean f()
  {
    return this.p;
  }
  
  public Builder g(boolean paramBoolean)
  {
    this.t = paramBoolean;
    return this;
  }
  
  public boolean g()
  {
    return this.o;
  }
  
  public boolean h()
  {
    return this.n;
  }
  
  public boolean i()
  {
    return this.m;
  }
  
  public ReadInJoyBaseViewController j()
  {
    return this.l;
  }
  
  public int k()
  {
    return this.k;
  }
  
  public int l()
  {
    return this.j;
  }
  
  public int m()
  {
    return this.i;
  }
  
  public ReadInJoyXListView n()
  {
    return this.h;
  }
  
  public long o()
  {
    return this.g;
  }
  
  public ReadInJoyBaseAdapter p()
  {
    return this.f;
  }
  
  public Activity q()
  {
    return this.e;
  }
  
  public int r()
  {
    return this.d;
  }
  
  public ReadInJoyPageItemCache s()
  {
    return this.a;
  }
  
  public boolean t()
  {
    return this.c;
  }
  
  public boolean u()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataFetchManager.Builder
 * JD-Core Version:    0.7.0.1
 */