package com.tencent.mobileqq.vas.download.api.impl;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.vas.download.api.IDownloadAdapter;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloadTask.ReportInfo;
import com.tencent.open.agent.report.ReportCenter;

public class DownloadAdapterImpl
  implements IDownloadAdapter
{
  public void vipReportCgi(DownloadTask paramDownloadTask)
  {
    ReportCenter.a().a(paramDownloadTask.h, 100, paramDownloadTask.c, String.valueOf(paramDownloadTask.S.b), paramDownloadTask.S.a, HardCodeUtil.a(2131901602), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.download.api.impl.DownloadAdapterImpl
 * JD-Core Version:    0.7.0.1
 */