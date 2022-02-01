package com.tencent.mobileqq.tablequery;

import android.os.Bundle;
import com.tencent.TMG.utils.QLog;
import java.text.NumberFormat;
import mqq.observer.BusinessObserver;

public class TableQueryObserver
  implements BusinessObserver
{
  TableQueryController a;
  
  private boolean a(QueryData paramQueryData)
  {
    if ((paramQueryData == null) || (paramQueryData.b == null) || (paramQueryData.a == null)) {}
    while ((paramQueryData.a.equals("")) && (paramQueryData.b.equals(""))) {
      return false;
    }
    return true;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    long l1 = 0L;
    try
    {
      l2 = paramBundle.getLong("ret");
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l2;
        String str1;
        String str2;
        String str3;
        String str4;
        long l3;
        String str5;
        String str6;
        String str7;
        String str8;
        QLog.d("TableQueryObserver", 1, "cast:" + 0L, localException);
      }
    }
    paramBundle.getByteArray("msg");
    str1 = paramBundle.getString("reqReportId");
    str2 = paramBundle.getString("reportId");
    l2 = paramBundle.getLong("pv");
    str3 = paramBundle.getString("pv_day_earlier");
    str4 = paramBundle.getString("pv_month_earlier");
    l3 = paramBundle.getLong("uv");
    str5 = paramBundle.getString("uv_day_earlier");
    str6 = paramBundle.getString("uv_month_earlier");
    str7 = paramBundle.getString("time");
    str8 = paramBundle.getString("param");
    try
    {
      paramBundle = paramBundle.getString("description");
      if (paramBundle == null) {
        break label566;
      }
      paramBundle = new String(paramBundle.getBytes(), "UTF-8");
    }
    catch (Exception paramBundle)
    {
      QueryData localQueryData;
      do
      {
        for (;;)
        {
          QLog.e("TableQueryObserver", 1, "description decode failed" + paramBundle);
          paramBundle = "";
        }
      } while (!a(localQueryData));
      this.a.a(localQueryData);
    }
    if (this.a == null) {
      this.a = TableQueryController.a();
    }
    localQueryData = new QueryData();
    localQueryData.b = (str2 + "\n" + str1 + "\n");
    localQueryData.a = str1;
    localQueryData.k = paramBundle;
    localQueryData.j = str8;
    localQueryData.c = (NumberFormat.getNumberInstance().format(l2) + "\n同比:" + str3 + "\n环比:" + str4 + "\n");
    localQueryData.d = str3;
    localQueryData.e = str4;
    localQueryData.f = (NumberFormat.getNumberInstance().format(l3) + "\n同比:" + str5 + "\n环比:" + str6 + "\n");
    localQueryData.g = str5;
    localQueryData.h = str6;
    localQueryData.i = str7;
    QLog.d("TableQueryObserver", 1, "编码All data: \n ret: " + l1 + "\n msg: \n reqReportId" + str1 + "\n reportId: " + str2 + "\n pv: " + l2 + "\n pv_day: " + str3 + "\n pv_month: " + str4 + "\n uv: " + l3 + "\n uv_day" + str5 + "\n uv_month: " + str6 + "\n time: " + str7 + "\n param: " + str8 + "\n description: " + paramBundle + "\n");
    if (!TableQueryController.b)
    {
      if (a(localQueryData)) {
        this.a.a(localQueryData);
      }
      return;
    }
    label566:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tablequery.TableQueryObserver
 * JD-Core Version:    0.7.0.1
 */