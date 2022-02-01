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
    ReportCenter.a().a(paramDownloadTask.c, 100, paramDownloadTask.jdField_a_of_type_Int, String.valueOf(paramDownloadTask.jdField_a_of_type_ComTencentMobileqqVipDownloadTask$ReportInfo.jdField_a_of_type_Long), paramDownloadTask.jdField_a_of_type_ComTencentMobileqqVipDownloadTask$ReportInfo.jdField_a_of_type_Int, HardCodeUtil.a(2131703653), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.download.api.impl.DownloadAdapterImpl
 * JD-Core Version:    0.7.0.1
 */