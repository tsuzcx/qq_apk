package com.tencent.mobileqq.servlet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_dc00420;
import java.util.HashMap;

public class ClearPushReceiver
  extends BroadcastReceiver
{
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramInt <= 0)) {
      return;
    }
    LpReportInfo_dc00420.report(4, 0, null, paramString, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("pushReport", 2, "EXPOSE: uin: " + paramQQAppInterface.getAccount() + " pushstatkey: " + paramString);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("actiontype", "4");
    localHashMap.put("pushstatkey", paramString);
    localHashMap.put("mergenum", paramInt + "");
    StatisticCollector.a(BaseApplicationImpl.getContext()).a(paramQQAppInterface.getAccount(), "actQZPushDataReport", true, 0L, 0L, localHashMap, null);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    int i;
    do
    {
      return;
      paramContext = paramIntent.getStringExtra("pushstatkey");
      i = paramIntent.getIntExtra("mergenum", 0);
      localObject = BaseApplicationImpl.getApplication();
    } while (localObject == null);
    Object localObject = (QQAppInterface)((BaseApplicationImpl)localObject).getRuntime();
    int j = paramIntent.getIntExtra("pushtype", 0);
    if ((j == 1) || (j == 300))
    {
      paramIntent = (QZoneManagerImp)((QQAppInterface)localObject).getManager(9);
      if (paramIntent != null) {
        paramIntent.a(1, 0);
      }
    }
    a((QQAppInterface)localObject, paramContext, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.ClearPushReceiver
 * JD-Core Version:    0.7.0.1
 */