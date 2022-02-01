package com.tencent.mobileqq.qwallet.report;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;

@QAPI(process={"all"})
public abstract interface IReportApi
  extends QRouteApi
{
  public abstract void report(String paramString1, String paramString2, Map<String, String> paramMap);
  
  public abstract void reportHongbaoTo644(BaseQQAppInterface paramBaseQQAppInterface, String paramString, BaseSessionInfo paramBaseSessionInfo);
  
  public abstract void reportNetworkStack();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.report.IReportApi
 * JD-Core Version:    0.7.0.1
 */