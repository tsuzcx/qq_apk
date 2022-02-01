package com.tencent.mobileqq.kandian.biz.daily;

import com.tencent.mobileqq.kandian.biz.framework.PrefetchListener;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyDailyXListView$1
  implements PrefetchListener
{
  ReadInJoyDailyXListView$1(ReadInJoyDailyXListView paramReadInJoyDailyXListView) {}
  
  public void a()
  {
    if (ReadInJoyDailyXListView.a(this.a))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.a.f);
        localStringBuilder.append(" mNoMoreData : ");
        localStringBuilder.append(this.a.j);
        QLog.d("ReadInJoyDailyXListView", 2, new Object[] { "preloadOptimize switch ON, mCurrentStatus = ", localStringBuilder.toString() });
      }
      if ((this.a.f == 0) && ((!ReadinjoyReportUtils.d(ReadInJoyDailyXListView.b(this.a))) || (!this.a.j)))
      {
        this.a.a(4);
        QLog.d("ReadInJoyDailyXListView", 2, "preloadOptimize switch ON, loadingMore()");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailyXListView.1
 * JD-Core Version:    0.7.0.1
 */