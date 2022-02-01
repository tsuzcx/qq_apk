package com.tencent.mobileqq.qwallet.report.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.qwallet.report.IReportApi;
import java.util.Map;

public class ReportApiImpl
  implements IReportApi
{
  public void report(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    ReportUtils.a(paramString1, paramString2, paramMap);
  }
  
  public void reportHongbaoTo644(BaseQQAppInterface paramBaseQQAppInterface, String paramString, BaseSessionInfo paramBaseSessionInfo)
  {
    ReportUtils.a(paramBaseQQAppInterface, paramString, paramBaseSessionInfo);
  }
  
  public void reportNetworkStack() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.report.impl.ReportApiImpl
 * JD-Core Version:    0.7.0.1
 */