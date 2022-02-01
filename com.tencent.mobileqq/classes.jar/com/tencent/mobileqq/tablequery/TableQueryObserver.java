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
    if ((paramQueryData != null) && (paramQueryData.b != null))
    {
      if (paramQueryData.a == null) {
        return false;
      }
      return (!paramQueryData.a.equals("")) || (!paramQueryData.b.equals(""));
    }
    return false;
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
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cast:");
      ((StringBuilder)localObject).append(0L);
      QLog.d("TableQueryObserver", 1, ((StringBuilder)localObject).toString(), localException);
    }
    paramBundle.getByteArray("msg");
    String str2 = paramBundle.getString("reqReportId");
    String str3 = paramBundle.getString("reportId");
    long l2 = paramBundle.getLong("pv");
    String str4 = paramBundle.getString("pv_day_earlier");
    String str5 = paramBundle.getString("pv_month_earlier");
    long l3 = paramBundle.getLong("uv");
    String str6 = paramBundle.getString("uv_day_earlier");
    String str7 = paramBundle.getString("uv_month_earlier");
    String str1 = paramBundle.getString("time");
    String str8 = paramBundle.getString("param");
    Object localObject = "";
    try
    {
      paramBundle = paramBundle.getString("description");
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getBytes();
        try
        {
          paramBundle = new String(paramBundle, "UTF-8");
        }
        catch (Exception paramBundle)
        {
          break label189;
        }
      }
      else
      {
        paramBundle = (Bundle)localObject;
      }
    }
    catch (Exception paramBundle)
    {
      label189:
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("description decode failed");
      localStringBuilder.append(paramBundle);
      QLog.e("TableQueryObserver", 1, localStringBuilder.toString());
      paramBundle = (Bundle)localObject;
    }
    if (this.a == null) {
      this.a = TableQueryController.a();
    }
    localObject = new QueryData();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str3);
    localStringBuilder.append("\n");
    localStringBuilder.append(str2);
    localStringBuilder.append("\n");
    ((QueryData)localObject).b = localStringBuilder.toString();
    ((QueryData)localObject).a = str2;
    ((QueryData)localObject).k = paramBundle;
    ((QueryData)localObject).j = str8;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(NumberFormat.getNumberInstance().format(l2));
    localStringBuilder.append("\n同比:");
    localStringBuilder.append(str4);
    localStringBuilder.append("\n环比:");
    localStringBuilder.append(str5);
    localStringBuilder.append("\n");
    ((QueryData)localObject).c = localStringBuilder.toString();
    ((QueryData)localObject).d = str4;
    ((QueryData)localObject).e = str5;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(NumberFormat.getNumberInstance().format(l3));
    localStringBuilder.append("\n同比:");
    localStringBuilder.append(str6);
    localStringBuilder.append("\n环比:");
    localStringBuilder.append(str7);
    localStringBuilder.append("\n");
    ((QueryData)localObject).f = localStringBuilder.toString();
    ((QueryData)localObject).g = str6;
    ((QueryData)localObject).h = str7;
    ((QueryData)localObject).i = str1;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("编码All data: \n ret: ");
    localStringBuilder.append(l1);
    localStringBuilder.append("\n msg: \n reqReportId");
    localStringBuilder.append(str2);
    localStringBuilder.append("\n reportId: ");
    localStringBuilder.append(str3);
    localStringBuilder.append("\n pv: ");
    localStringBuilder.append(l2);
    localStringBuilder.append("\n pv_day: ");
    localStringBuilder.append(str4);
    localStringBuilder.append("\n pv_month: ");
    localStringBuilder.append(str5);
    localStringBuilder.append("\n uv: ");
    localStringBuilder.append(l3);
    localStringBuilder.append("\n uv_day");
    localStringBuilder.append(str6);
    localStringBuilder.append("\n uv_month: ");
    localStringBuilder.append(str7);
    localStringBuilder.append("\n time: ");
    localStringBuilder.append(str1);
    localStringBuilder.append("\n param: ");
    localStringBuilder.append(str8);
    localStringBuilder.append("\n description: ");
    localStringBuilder.append(paramBundle);
    localStringBuilder.append("\n");
    QLog.d("TableQueryObserver", 1, localStringBuilder.toString());
    if (!TableQueryController.b)
    {
      if (a((QueryData)localObject)) {
        this.a.a((QueryData)localObject);
      }
    }
    else if (a((QueryData)localObject)) {
      this.a.b((QueryData)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.tablequery.TableQueryObserver
 * JD-Core Version:    0.7.0.1
 */