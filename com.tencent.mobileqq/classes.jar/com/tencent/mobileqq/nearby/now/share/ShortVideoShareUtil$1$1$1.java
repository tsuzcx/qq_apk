package com.tencent.mobileqq.nearby.now.share;

import android.text.TextUtils;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.nearby.now.utils.INowVideoReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportTask;

class ShortVideoShareUtil$1$1$1
  implements Runnable
{
  ShortVideoShareUtil$1$1$1(ShortVideoShareUtil.1.1 param1, INearbyCardManager paramINearbyCardManager) {}
  
  public void run()
  {
    ReportTask localReportTask = new ReportTask(this.b.a.h).a("dc00899").b("grp_lbs").c("video").d("playpage_fw_suc").e(((INowVideoReporter)QRoute.api(INowVideoReporter.class)).getAnchorUin());
    int i = this.a.c();
    String str2 = ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).getFrom();
    String str1;
    if (TextUtils.equals(((INowVideoReporter)QRoute.api(INowVideoReporter.class)).getFrom(), "2")) {
      str1 = ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).getFeedId();
    } else {
      str1 = "";
    }
    localReportTask.a(new String[] { "1", String.valueOf(i), str2, str1 }).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.share.ShortVideoShareUtil.1.1.1
 * JD-Core Version:    0.7.0.1
 */