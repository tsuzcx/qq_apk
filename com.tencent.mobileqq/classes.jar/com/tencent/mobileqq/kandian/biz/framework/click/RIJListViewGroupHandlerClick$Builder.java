package com.tencent.mobileqq.kandian.biz.framework.click;

import android.app.Activity;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

public final class RIJListViewGroupHandlerClick$Builder
{
  Activity a;
  int b;
  ReadInJoyBaseAdapter c;
  int d;
  AbsBaseArticleInfo e;
  long f;
  
  public long a()
  {
    return this.f;
  }
  
  public Builder a(int paramInt)
  {
    this.b = paramInt;
    return this;
  }
  
  public Builder a(long paramLong)
  {
    this.f = paramLong;
    return this;
  }
  
  public Builder a(Activity paramActivity)
  {
    this.a = paramActivity;
    return this;
  }
  
  public Builder a(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    this.c = paramReadInJoyBaseAdapter;
    return this;
  }
  
  public Builder a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.e = paramAbsBaseArticleInfo;
    return this;
  }
  
  public Builder b(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
  
  public AbsBaseArticleInfo b()
  {
    return this.e;
  }
  
  public int c()
  {
    return this.d;
  }
  
  public ReadInJoyBaseAdapter d()
  {
    return this.c;
  }
  
  public Activity e()
  {
    return this.a;
  }
  
  public int f()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.click.RIJListViewGroupHandlerClick.Builder
 * JD-Core Version:    0.7.0.1
 */