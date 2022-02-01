package com.tencent.mobileqq.nearby.now.view;

import android.text.TextUtils;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.nearby.now.utils.NowVideoReporter;
import com.tencent.mobileqq.statistics.ReportTask;

class ShortVideoCommentsView$19
  implements Runnable
{
  ShortVideoCommentsView$19(ShortVideoCommentsView paramShortVideoCommentsView, NearbyCardManager paramNearbyCardManager) {}
  
  public void run()
  {
    ReportTask localReportTask = new ReportTask(this.this$0.a).a("dc00899").b("grp_lbs").c("video").d("playpage_com_suc").e(NowVideoReporter.d);
    int i = this.a.b();
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
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView.19
 * JD-Core Version:    0.7.0.1
 */