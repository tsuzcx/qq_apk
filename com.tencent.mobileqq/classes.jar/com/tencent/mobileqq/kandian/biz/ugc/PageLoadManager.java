package com.tencent.mobileqq.kandian.biz.ugc;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class PageLoadManager<T>
{
  private int a = 0;
  private int b = 100;
  private boolean c = true;
  private boolean d = false;
  private PageLoadManager.QueryProvider<T> e = null;
  
  public void a()
  {
    PageLoadManager.QueryProvider localQueryProvider = this.e;
    if (localQueryProvider == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PageLoadManager", 2, "mQueryProvider is not registered, can't query data...");
      }
      return;
    }
    if (!this.c)
    {
      if (QLog.isColorLevel()) {
        QLog.w("PageLoadManager", 2, "requestNextPage cancel for mHasMore is false");
      }
      return;
    }
    this.d = true;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestNextPage mOffset:");
      localStringBuilder.append(this.a);
      localStringBuilder.append(" mPageSize:$mPageSize");
      QLog.i("PageLoadManager", 2, localStringBuilder.toString());
    }
    ThreadManager.executeOnSubThread(new PageLoadManager.1(this, localQueryProvider));
  }
  
  public void a(int paramInt)
  {
    if (!this.c)
    {
      if (QLog.isColorLevel()) {
        QLog.w("PageLoadManager", 2, "onPositionShow return for mHasMore is false");
      }
      return;
    }
    if (this.d)
    {
      if (QLog.isColorLevel()) {
        QLog.w("PageLoadManager", 2, "query is doing...");
      }
      return;
    }
    int i = this.a;
    if (paramInt >= (i - this.b + i) / 2) {
      a();
    }
  }
  
  public void a(PageLoadManager.QueryProvider<T> paramQueryProvider)
  {
    this.e = paramQueryProvider;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.PageLoadManager
 * JD-Core Version:    0.7.0.1
 */