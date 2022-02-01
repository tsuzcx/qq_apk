package com.tencent.mobileqq.relation.api;

import android.os.Bundle;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface ISafetyReportTempService
  extends IRuntimeService
{
  public abstract String encrypt(String paramString1, String paramString2);
  
  public abstract String getKeyForMode(int paramInt);
  
  public abstract void safetyNewReport(QBaseActivity paramQBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, Bundle paramBundle);
  
  public abstract void safetyReport(QBaseActivity paramQBaseActivity, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relation.api.ISafetyReportTempService
 * JD-Core Version:    0.7.0.1
 */