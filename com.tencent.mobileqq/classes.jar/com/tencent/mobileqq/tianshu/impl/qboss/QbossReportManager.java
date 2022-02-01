package com.tencent.mobileqq.tianshu.impl.qboss;

import NS_MOBILE_QBOSS_PROTO.MobileQbossReportRsp;
import android.os.Bundle;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.ITianshuTempApi;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

public class QbossReportManager
  extends QZoneObserver
{
  private static QbossReportManager a;
  
  public static QbossReportManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new QbossReportManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  private AppRuntime b()
  {
    return MobileQQ.sMobileQQ.waitAppRuntime(null);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Type:sendErrorReport, code:");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append(" errorMessage = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("QbossReportManager", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = b();
    if (localObject == null) {
      QLog.e("QbossReportManager", 1, "send report error with runtime null ");
    }
    NewIntent localNewIntent = new NewIntent(MobileQQ.sMobileQQ.getApplicationContext(), QbossErrorReportServlet.class);
    try
    {
      localNewIntent.putExtra("uin", Long.parseLong(((AppRuntime)localObject).getAccount()));
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    localNewIntent.putExtra("code", paramInt3);
    localNewIntent.putExtra("appId", paramInt1);
    localNewIntent.putExtra("taskId", paramInt2);
    localNewIntent.putExtra("message", paramString);
    ((AppRuntime)localObject).startServlet(localNewIntent);
  }
  
  public void a(String paramString1, String paramString2)
  {
    b(paramString1, paramString2, 3);
    if (QLog.isDevelopLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("Type:reportClose, sQBosstrace:");
      paramString2.append(paramString1);
      QLog.d("QbossReportManager", 4, paramString2.toString());
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    a(paramString1, paramString2, 9, paramInt);
    if (QLog.isDevelopLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("Type:reportExpose, sQBosstrace:");
      paramString2.append(paramString1);
      QLog.d("QbossReportManager", 4, paramString2.toString());
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppRuntime localAppRuntime = b();
    if (localAppRuntime == null) {
      QLog.e("QbossReportManager", 1, "send report error with runtime null ");
    }
    NewIntent localNewIntent = new NewIntent(MobileQQ.sMobileQQ.getApplicationContext(), QbossReportServlet.class);
    try
    {
      localNewIntent.putExtra("uin", Long.parseLong(localAppRuntime.getAccount()));
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("send report error ");
      localStringBuilder.append(localException);
      QLog.e("QbossReportManager", 1, localStringBuilder.toString());
    }
    localNewIntent.putExtra("qua", ((ITianshuTempApi)QRoute.api(ITianshuTempApi.class)).getQua());
    localNewIntent.putExtra("sQBosstrace", paramString1);
    localNewIntent.putExtra("iOperType", paramInt1);
    localNewIntent.putExtra("sUserID", paramString2);
    localNewIntent.putExtra("times", paramInt2);
    localAppRuntime.registObserver(this);
    localAppRuntime.startServlet(localNewIntent);
  }
  
  public void b(String paramString1, String paramString2)
  {
    b(paramString1, paramString2, 2);
    if (QLog.isDevelopLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("Type:reportClick, sQBosstrace:");
      paramString2.append(paramString1);
      QLog.d("QbossReportManager", 4, paramString2.toString());
    }
  }
  
  public void b(String paramString1, String paramString2, int paramInt)
  {
    a(paramString1, paramString2, paramInt, 1);
  }
  
  public void c(String paramString1, String paramString2)
  {
    b(paramString1, paramString2, 1);
    if (QLog.isDevelopLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("Type:reportExpose, sQBosstrace:");
      paramString2.append(paramString1);
      QLog.d("QbossReportManager", 4, paramString2.toString());
    }
  }
  
  public void d(String paramString1, String paramString2)
  {
    b(paramString1, paramString2, 8);
    if (QLog.isDevelopLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("Type:reportUrlClick, sQBosstrace:");
      paramString2.append(paramString1);
      QLog.d("QbossReportManager", 4, paramString2.toString());
    }
  }
  
  public void e(String paramString1, String paramString2)
  {
    b(paramString1, paramString2, 11);
    if (QLog.isDevelopLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("Type:reportExpose, sQBosstrace:");
      paramString2.append(paramString1);
      QLog.d("QbossReportManager", 4, paramString2.toString());
    }
  }
  
  protected void i(boolean paramBoolean, Bundle paramBundle)
  {
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      paramBundle = paramBundle.getSerializable("data");
      if ((paramBundle != null) && ((paramBundle instanceof MobileQbossReportRsp)))
      {
        paramBundle = (MobileQbossReportRsp)paramBundle;
        if (paramBundle != null) {
          if (paramBundle.iRet == 0)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(" onReportQbossResponse success:");
            localStringBuilder.append(paramBundle.sMsg);
            QLog.i("QbossReportManager", 4, localStringBuilder.toString());
          }
          else
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("onReportQbossResponse fail:");
            localStringBuilder.append(paramBundle.sMsg);
            QLog.i("QbossReportManager", 4, localStringBuilder.toString());
          }
        }
      }
      else
      {
        QLog.i("QbossReportManager", 4, "onReportQbossResponse fail: rsp == null || not instanceof MobileQbossReportRsp");
      }
    }
    else
    {
      int i = paramBundle.getInt("ret", 0);
      paramBundle = paramBundle.getString("msg");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReportQbossResponse fail: ret = ");
      localStringBuilder.append(i);
      localStringBuilder.append(" msg = ");
      localStringBuilder.append(paramBundle);
      QLog.i("QbossReportManager", 1, localStringBuilder.toString());
    }
    paramBundle = b();
    if (paramBundle != null) {
      paramBundle.unRegistObserver(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.impl.qboss.QbossReportManager
 * JD-Core Version:    0.7.0.1
 */