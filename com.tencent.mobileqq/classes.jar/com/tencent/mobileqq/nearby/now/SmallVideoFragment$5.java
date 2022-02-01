package com.tencent.mobileqq.nearby.now;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.nearby.now.utils.NowVideoReporter;
import com.tencent.mobileqq.statistics.ReportTask;

class SmallVideoFragment$5
  implements Runnable
{
  SmallVideoFragment$5(SmallVideoFragment paramSmallVideoFragment, NearbyCardManager paramNearbyCardManager) {}
  
  public void run()
  {
    ReportTask localReportTask = new ReportTask(SmallVideoFragment.a(this.this$0).app).a("dc00899").b("grp_lbs").c("video").d("playpage_fw_suc").e(NowVideoReporter.d);
    int i = this.a.b();
    String str2 = NowVideoReporter.a;
    if (TextUtils.equals(NowVideoReporter.a, "2")) {}
    for (String str1 = NowVideoReporter.c;; str1 = "")
    {
      localReportTask.a(new String[] { "4", String.valueOf(i), str2, str1 }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.SmallVideoFragment.5
 * JD-Core Version:    0.7.0.1
 */