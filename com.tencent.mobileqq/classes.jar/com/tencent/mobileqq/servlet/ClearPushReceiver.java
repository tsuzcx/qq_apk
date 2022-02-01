package com.tencent.mobileqq.servlet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_dc00420;
import java.util.HashMap;

public class ClearPushReceiver
  extends BroadcastReceiver
{
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (paramQQAppInterface != null)
    {
      if (paramInt <= 0) {
        return;
      }
      LpReportInfo_dc00420.report(4, 0, null, paramString, paramInt);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("EXPOSE: uin: ");
        ((StringBuilder)localObject).append(paramQQAppInterface.getAccount());
        ((StringBuilder)localObject).append(" pushstatkey: ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("pushReport", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new HashMap();
      ((HashMap)localObject).put("actiontype", "4");
      ((HashMap)localObject).put("pushstatkey", paramString);
      paramString = new StringBuilder();
      paramString.append(paramInt);
      paramString.append("");
      ((HashMap)localObject).put("mergenum", paramString.toString());
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(paramQQAppInterface.getAccount(), "actQZPushDataReport", true, 0L, 0L, (HashMap)localObject, null);
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    paramContext = paramIntent.getStringExtra("pushstatkey");
    int i = paramIntent.getIntExtra("mergenum", 0);
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = (QQAppInterface)((BaseApplicationImpl)localObject).getRuntime();
      int j = paramIntent.getIntExtra("pushtype", 0);
      if ((j == 1) || (j == 300))
      {
        paramIntent = (QZoneManagerImp)((QQAppInterface)localObject).getManager(QQManagerFactory.QZONE_MANAGER);
        if (paramIntent != null) {
          paramIntent.a(1, 0);
        }
      }
      a((QQAppInterface)localObject, paramContext, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.ClearPushReceiver
 * JD-Core Version:    0.7.0.1
 */