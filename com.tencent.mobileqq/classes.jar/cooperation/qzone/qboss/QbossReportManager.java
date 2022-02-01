package cooperation.qzone.qboss;

import NS_MOBILE_QBOSS_PROTO.MobileQbossReportRsp;
import android.os.Bundle;
import ayrb;
import bcvx;
import bcvy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QUA;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class QbossReportManager
  extends ayrb
{
  private static final String TAG = "QbossReportManager";
  private static QbossReportManager instance;
  
  public static QbossReportManager getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new QbossReportManager();
      }
      return instance;
    }
    finally {}
  }
  
  public void onReportQbossResponse(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      paramBundle = paramBundle.getSerializable("data");
      if ((paramBundle != null) && ((paramBundle instanceof MobileQbossReportRsp)))
      {
        paramBundle = (MobileQbossReportRsp)paramBundle;
        if (paramBundle != null)
        {
          if (paramBundle.iRet != 0) {
            break label77;
          }
          QLog.i("QbossReportManager", 4, " onReportQbossResponse success:" + paramBundle.sMsg);
        }
      }
    }
    for (;;)
    {
      BaseApplicationImpl.getApplication().getRuntime().unRegistObserver(this);
      return;
      label77:
      QLog.i("QbossReportManager", 4, "onReportQbossResponse fail:" + paramBundle.sMsg);
      continue;
      QLog.i("QbossReportManager", 4, "onReportQbossResponse fail: rsp == null || not instanceof MobileQbossReportRsp");
      continue;
      int i = paramBundle.getInt("ret", 0);
      paramBundle = paramBundle.getString("msg");
      QLog.i("QbossReportManager", 1, "onReportQbossResponse fail: ret = " + i + " msg = " + paramBundle);
    }
  }
  
  public void reportClick(String paramString1, String paramString2)
  {
    sendReport(paramString1, paramString2, 2);
    if (QLog.isDevelopLevel()) {
      QLog.d("QbossReportManager", 4, "Type:reportClick, sQBosstrace:" + paramString1);
    }
  }
  
  public void reportClose(String paramString1, String paramString2)
  {
    sendReport(paramString1, paramString2, 3);
    if (QLog.isDevelopLevel()) {
      QLog.d("QbossReportManager", 4, "Type:reportClose, sQBosstrace:" + paramString1);
    }
  }
  
  public void reportExpose(String paramString1, String paramString2)
  {
    sendReport(paramString1, paramString2, 1);
    if (QLog.isDevelopLevel()) {
      QLog.d("QbossReportManager", 4, "Type:reportExpose, sQBosstrace:" + paramString1);
    }
  }
  
  public void reportIntercept(String paramString1, String paramString2)
  {
    sendReport(paramString1, paramString2, 11);
    if (QLog.isDevelopLevel()) {
      QLog.d("QbossReportManager", 4, "Type:reportExpose, sQBosstrace:" + paramString1);
    }
  }
  
  public void reportUrlClick(String paramString1, String paramString2)
  {
    sendReport(paramString1, paramString2, 8);
    if (QLog.isDevelopLevel()) {
      QLog.d("QbossReportManager", 4, "Type:reportUrlClick, sQBosstrace:" + paramString1);
    }
  }
  
  public void sendErrorReport(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QbossReportManager", 1, "Type:sendErrorReport, code:" + paramInt3 + " errorMessage = " + paramString);
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getApplication(), bcvx.class);
    try
    {
      localNewIntent.putExtra("uin", Long.parseLong(localAppRuntime.getAccount()));
      localNewIntent.putExtra("code", paramInt3);
      localNewIntent.putExtra("appId", paramInt1);
      localNewIntent.putExtra("taskId", paramInt2);
      localNewIntent.putExtra("message", paramString);
      localAppRuntime.startServlet(localNewIntent);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void sendReport(String paramString1, String paramString2, int paramInt)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getApplication(), bcvy.class);
    try
    {
      localNewIntent.putExtra("uin", Long.parseLong(localAppRuntime.getAccount()));
      localNewIntent.putExtra("qua", QUA.getQUA3());
      localNewIntent.putExtra("sQBosstrace", paramString1);
      localNewIntent.putExtra("iOperType", paramInt);
      localNewIntent.putExtra("sUserID", paramString2);
      localAppRuntime.registObserver(this);
      localAppRuntime.startServlet(localNewIntent);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.qboss.QbossReportManager
 * JD-Core Version:    0.7.0.1
 */