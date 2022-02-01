package com.tencent.mobileqq.mini.entry;

import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.tianshu.TianShuManager;
import mqq.app.AppRuntime;

public class MiniAppExposureManager$TianShuExposureData
  extends MiniAppExposureManager.BaseExposureReport
{
  private int actionId;
  private String appId;
  private String itemId;
  private String pageId;
  
  public MiniAppExposureManager$TianShuExposureData(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.appId = paramString1;
    this.pageId = paramString2;
    this.itemId = paramString3;
    this.actionId = paramInt;
  }
  
  public void report()
  {
    try
    {
      localObject2 = new TianShuReportData();
      Object localObject3 = BaseApplicationImpl.getApplication().getRuntime();
      Object localObject1 = "";
      if (localObject3 != null) {
        localObject1 = ((AppRuntime)localObject3).getAccount();
      }
      long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append("_");
      ((StringBuilder)localObject3).append(l);
      ((TianShuReportData)localObject2).b = ((StringBuilder)localObject3).toString();
      ((TianShuReportData)localObject2).c = 1;
      ((TianShuReportData)localObject2).f = this.appId;
      ((TianShuReportData)localObject2).g = this.pageId;
      ((TianShuReportData)localObject2).h = this.itemId;
      ((TianShuReportData)localObject2).p = this.actionId;
      ((TianShuReportData)localObject2).q = 1;
      ((TianShuReportData)localObject2).o = l;
      TianShuManager.getInstance().report((TianShuReportData)localObject2);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("TianShuExposureData, report itemId: ");
        ((StringBuilder)localObject1).append(this.itemId);
        QLog.i("MiniAppExposureManager", 2, ((StringBuilder)localObject1).toString());
        return;
      }
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("TianShuExposureData, report exception: ");
      ((StringBuilder)localObject2).append(Log.getStackTraceString(localException));
      QLog.e("MiniAppExposureManager", 1, ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppExposureManager.TianShuExposureData
 * JD-Core Version:    0.7.0.1
 */