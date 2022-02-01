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
    AppCenterReporter.b(ClickDataBuilder.a().a("200").l(ApkFileDownloadFragment.b(this.a).e).k("1").m("0").n(ApkFileDownloadFragment.b(this.a).d).b(ApkFileDownloadFragment.a(this.a).i).c(ApkFileDownloadFragment.a(this.a).f).h(ApkFileDownloadFragment.a(this.a).e));
    ApkFileDownloadFragment.c(this.a).finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.filedownload.ApkFileDownloadFragment.1
 * JD-Core Version:    0.7.0.1
 */