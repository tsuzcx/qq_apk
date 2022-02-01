package com.tencent.mobileqq.nearby.now;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.nearby.now.utils.INowVideoReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportTask;

class SmallVideoFragment$5
  implements Runnable
{
  SmallVideoFragment$5(SmallVideoFragment paramSmallVideoFragment, INearbyCardManager paramINearbyCardManager) {}
  
  public void run()
  {
    ReportTask localReportTask = new ReportTask(SmallVideoFragment.a(this.this$0).app).a("dc00899").b("grp_lbs").c("video").d("playpage_fw_suc").e(((INowVideoReporter)QRoute.api(INowVideoReporter.class)).getAnchorUin());
    int i = this.a.b();
    String str2 = ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).getFrom();
    String str1;
    if (TextUtils.equals(((INowVideoReporter)QRoute.api(INowVideoReporter.class)).getFrom(), "2")) {
      str1 = ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).getFeedId();
    } else {
      str1 = "";
    }
    localReportTask.a(new String[] { "4", String.valueOf(i), str2, str1 }).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.SmallVideoFragment.5
 * JD-Core Version:    0.7.0.1
 */