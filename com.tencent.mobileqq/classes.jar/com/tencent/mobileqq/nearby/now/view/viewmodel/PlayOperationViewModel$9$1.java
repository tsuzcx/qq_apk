package com.tencent.mobileqq.nearby.now.view.viewmodel;

import android.text.TextUtils;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.nearby.now.utils.NowVideoReporter;
import com.tencent.mobileqq.statistics.ReportTask;

class PlayOperationViewModel$9$1
  implements Runnable
{
  PlayOperationViewModel$9$1(PlayOperationViewModel.9 param9, NearbyCardManager paramNearbyCardManager) {}
  
  public void run()
  {
    ReportTask localReportTask = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel$9.a.a).a("dc00899").b("grp_lbs").c("video").d("playpage_like_click").e(NowVideoReporter.d);
    int i = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyCardManager.b();
    String str2 = NowVideoReporter.a;
    if (TextUtils.equals(NowVideoReporter.a, "2")) {}
    for (String str1 = NowVideoReporter.c;; str1 = "")
    {
      localReportTask.a(new String[] { "", String.valueOf(i), str2, str1 }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel.9.1
 * JD-Core Version:    0.7.0.1
 */