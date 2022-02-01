package com.tencent.mobileqq.nearby.now.view;

import android.text.TextUtils;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.nearby.now.utils.INowVideoReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportTask;

class ShortVideoCommentsView$19
  implements Runnable
{
  ShortVideoCommentsView$19(ShortVideoCommentsView paramShortVideoCommentsView, INearbyCardManager paramINearbyCardManager) {}
  
  public void run()
  {
    ReportTask localReportTask = new ReportTask(this.this$0.app).a("dc00899").b("grp_lbs").c("video").d("playpage_com_suc").e(((INowVideoReporter)QRoute.api(INowVideoReporter.class)).getAnchorUin());
    String str1 = "";
    int i = this.a.b();
    String str2 = ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).getFrom();
    if (TextUtils.equals(((INowVideoReporter)QRoute.api(INowVideoReporter.class)).getFrom(), "2")) {
      str1 = ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).getFeedId();
    }
    localReportTask.a(new String[] { "", String.valueOf(i), str2, str1 }).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView.19
 * JD-Core Version:    0.7.0.1
 */