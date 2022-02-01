package com.tencent.mobileqq.relation.api.impl;

import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.relation.api.ISafetyReportTempService;
import mqq.app.AppRuntime;

public class SafetyReportTempServiceImpl
  implements ISafetyReportTempService
{
  public void onCreate(AppRuntime paramAppRuntime) {}
  
  public void onDestroy() {}
  
  public void safetyReport(QBaseActivity paramQBaseActivity, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    NewReportPlugin.a(paramQBaseActivity, paramString1, paramString2, paramString3, paramInt, paramString4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.relation.api.impl.SafetyReportTempServiceImpl
 * JD-Core Version:    0.7.0.1
 */