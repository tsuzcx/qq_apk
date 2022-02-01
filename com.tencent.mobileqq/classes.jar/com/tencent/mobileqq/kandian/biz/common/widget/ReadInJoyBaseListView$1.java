package com.tencent.mobileqq.kandian.biz.common.widget;

import com.tencent.mobileqq.kandian.biz.framework.PrefetchListener;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyRefreshOptimizeUtil;
import com.tencent.mobileqq.kandian.glue.report.api.IReadInJoyReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyBaseListView$1
  implements PrefetchListener
{
  ReadInJoyBaseListView$1(ReadInJoyBaseListView paramReadInJoyBaseListView) {}
  
  public void a()
  {
    long l = ((IReadInJoyRefreshOptimizeUtil)QRoute.api(IReadInJoyRefreshOptimizeUtil.class)).getOptimizeId();
    if (((IReadInJoyRefreshOptimizeUtil)QRoute.api(IReadInJoyRefreshOptimizeUtil.class)).isPreloadOptimizeEnable(l))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseListView", 2, new Object[] { "preloadOptimize switch ON, mCurrentStatus = ", Integer.valueOf(this.a.f) });
      }
      if ((this.a.f == 0) && ((!((IReadInJoyReportUtils)QRoute.api(IReadInJoyReportUtils.class)).isKanDianSubscribe(this.a.i)) || (!this.a.j)))
      {
        this.a.a(4);
        QLog.d("ReadInJoyBaseListView", 2, "preloadOptimize switch ON, loadingMore()");
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseListView", 2, new Object[] { "preloadOptimize switch OFF, mCurrentStatus = ", Integer.valueOf(this.a.f) });
      }
      if ((!((IReadInJoyReportUtils)QRoute.api(IReadInJoyReportUtils.class)).isKanDianSubscribe(this.a.i)) || ((this.a.f == 0) && (!this.a.j)))
      {
        this.a.a(4);
        QLog.d("ReadInJoyBaseListView", 2, "preloadOptimize switch OFF, loadingMore()");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListView.1
 * JD-Core Version:    0.7.0.1
 */