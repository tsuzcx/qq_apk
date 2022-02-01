package com.tencent.open.filedownload;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.open.appstore.report.AppCenterReporter;
import com.tencent.open.appstore.report.ClickDataBuilder;
import com.tencent.open.appstore.report.ReportDataBuilder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ApkFileDownloadFragment$1
  implements View.OnClickListener
{
  ApkFileDownloadFragment$1(ApkFileDownloadFragment paramApkFileDownloadFragment) {}
  
  public void onClick(View paramView)
  {
    AppCenterReporter.b(ClickDataBuilder.a().a("200").k(ApkFileDownloadFragment.a(this.a).b).j("1").l("0").m(ApkFileDownloadFragment.a(this.a).a).a(ApkFileDownloadFragment.a(this.a).h).b(ApkFileDownloadFragment.a(this.a).f).g(ApkFileDownloadFragment.a(this.a).e));
    ApkFileDownloadFragment.a(this.a).finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.filedownload.ApkFileDownloadFragment.1
 * JD-Core Version:    0.7.0.1
 */