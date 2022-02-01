package com.tencent.open.agent.report;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings.Secure;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.APNUtil;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.open.business.base.OpenConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.TimeZone;

class ReportCenter$2
  implements Runnable
{
  ReportCenter$2(ReportCenter paramReportCenter, String paramString, boolean paramBoolean1, Bundle paramBundle, boolean paramBoolean2) {}
  
  public void run()
  {
    try
    {
      Object localObject2 = new Bundle();
      ((Bundle)localObject2).putString("uin", this.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_Boolean) {
        ??? = "";
      }
      label51:
      label71:
      label91:
      int i;
      for (;;)
      {
        ((Bundle)localObject2).putString("imei", (String)???);
        if (this.jdField_a_of_type_Boolean)
        {
          ??? = "";
          ((Bundle)localObject2).putString("imsi", (String)???);
          if (!this.jdField_a_of_type_Boolean) {
            break label425;
          }
          ??? = "";
          ((Bundle)localObject2).putString("android_id", (String)???);
          if (!this.jdField_a_of_type_Boolean) {
            break label444;
          }
          ??? = "";
          ((Bundle)localObject2).putString("mac", (String)???);
          ((Bundle)localObject2).putString("platform", "4");
          ((Bundle)localObject2).putString("os_ver", Build.VERSION.RELEASE);
          if (!this.jdField_a_of_type_Boolean) {
            break label452;
          }
          ??? = "";
          label130:
          ((Bundle)localObject2).putString("position", (String)???);
          ((Bundle)localObject2).putString("network", APNUtil.a(CommonDataAdapter.a().a()));
          ((Bundle)localObject2).putString("language", MobileInfoUtil.b());
          ((Bundle)localObject2).putString("resolution", MobileInfoUtil.e());
          if (!this.jdField_a_of_type_Boolean) {
            break label460;
          }
          ??? = "";
          ((Bundle)localObject2).putString("apn", (String)???);
          ((Bundle)localObject2).putString("model_name", Build.MODEL);
          ((Bundle)localObject2).putString("timezone", TimeZone.getDefault().getID());
          ((Bundle)localObject2).putString("qq_ver", CommonDataAdapter.a().c());
          ((Bundle)localObject2).putString("qua", CommonDataAdapter.a().f());
          ((Bundle)localObject2).putString("via", "2");
          ((Bundle)localObject2).putString("result", "0");
          if (this.jdField_a_of_type_AndroidOsBundle != null) {
            ((Bundle)localObject2).putAll(this.jdField_a_of_type_AndroidOsBundle);
          }
          localObject2 = new BaseData((Bundle)localObject2);
        }
        synchronized (this.this$0)
        {
          this.this$0.b.add(localObject2);
          int k = this.this$0.b.size();
          int m = ReportDatabaseHelper.a().a("report_via");
          int j = OpenConfig.a(CommonDataAdapter.a().a(), null).a("Agent_ReportTimeInterval");
          i = j;
          if (j == 0) {
            i = 10000;
          }
          if ((this.this$0.a("report_via", m + k)) || (this.b))
          {
            this.this$0.a(this.jdField_a_of_type_Boolean);
            this.this$0.a.removeMessages(1001);
            return;
            ??? = MobileInfoUtil.c();
            continue;
            ??? = MobileInfoUtil.d();
            break label51;
            label425:
            ??? = Settings.Secure.getString(CommonDataAdapter.a().a().getContentResolver(), "android_id");
            break label71;
            label444:
            ??? = MobileInfoUtil.a();
            break label91;
            label452:
            ??? = MobileInfoUtil.f();
            break label130;
            label460:
            ??? = APNUtil.b(CommonDataAdapter.a().a());
          }
        }
      }
      Message localMessage;
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("ReportCenter", 2, "-->reportVia, exception in sub thread.", localException);
        return;
        if (!this.this$0.a.hasMessages(1001))
        {
          localMessage = Message.obtain();
          localMessage.what = 1001;
          localMessage.obj = Boolean.valueOf(this.jdField_a_of_type_Boolean);
          this.this$0.a.sendMessageDelayed(localMessage, i);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.report.ReportCenter.2
 * JD-Core Version:    0.7.0.1
 */