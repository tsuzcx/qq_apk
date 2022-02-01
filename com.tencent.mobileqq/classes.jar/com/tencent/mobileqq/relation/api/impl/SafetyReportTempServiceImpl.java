package com.tencent.mobileqq.relation.api.impl;

import android.os.Bundle;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.relation.api.ISafetyReportTempService;
import mqq.app.AppRuntime;

public class SafetyReportTempServiceImpl
  implements ISafetyReportTempService
{
  public String encrypt(String paramString1, String paramString2)
  {
    return NewReportPlugin.b(paramString1, paramString2);
  }
  
  public String getKeyForMode(int paramInt)
  {
    return NewReportPlugin.c(paramInt);
  }
  
  public void onCreate(AppRuntime paramAppRuntime) {}
  
  public void onDestroy() {}
  
  public void safetyNewReport(QBaseActivity paramQBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, Bundle paramBundle)
  {
    NewReportPlugin.a(paramQBaseActivity, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt, paramString6, paramBundle);
  }
  
  public void safetyReport(QBaseActivity paramQBaseActivity, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    NewReportPlugin.a(paramQBaseActivity, paramString1, paramString2, paramString3, paramInt, paramString4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relation.api.impl.SafetyReportTempServiceImpl
 * JD-Core Version:    0.7.0.1
 */