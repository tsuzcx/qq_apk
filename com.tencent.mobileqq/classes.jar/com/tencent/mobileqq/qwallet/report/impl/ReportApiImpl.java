package com.tencent.mobileqq.qwallet.report.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.qwallet.report.IReportApi;

public class ReportApiImpl
  implements IReportApi
{
  public void reportHongbaoTo644(BaseQQAppInterface paramBaseQQAppInterface, String paramString, BaseSessionInfo paramBaseSessionInfo)
  {
    ReportUtils.a(paramBaseQQAppInterface, paramString, paramBaseSessionInfo);
  }
  
  public void reportNetworkStack() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.report.impl.ReportApiImpl
 * JD-Core Version:    0.7.0.1
 */