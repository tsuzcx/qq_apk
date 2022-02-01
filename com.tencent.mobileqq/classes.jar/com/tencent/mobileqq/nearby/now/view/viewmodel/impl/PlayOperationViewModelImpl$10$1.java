package com.tencent.mobileqq.nearby.now.view.viewmodel.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.nearby.now.utils.INowVideoReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportTask;

class PlayOperationViewModelImpl$10$1
  implements Runnable
{
  PlayOperationViewModelImpl$10$1(PlayOperationViewModelImpl.10 param10, INearbyCardManager paramINearbyCardManager) {}
  
  public void run()
  {
    ReportTask localReportTask = new ReportTask(this.b.a.app).a("dc00899").b("grp_lbs").c("video").d("playpage_fw_click").e(((INowVideoReporter)QRoute.api(INowVideoReporter.class)).getAnchorUin());
    String str1 = "";
    int i = this.a.c();
    String str2 = ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).getFrom();
    if (TextUtils.equals(((INowVideoReporter)QRoute.api(INowVideoReporter.class)).getFrom(), "2")) {
      str1 = ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).getFeedId();
    }
    localReportTask.a(new String[] { "", String.valueOf(i), str2, str1 }).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.viewmodel.impl.PlayOperationViewModelImpl.10.1
 * JD-Core Version:    0.7.0.1
 */