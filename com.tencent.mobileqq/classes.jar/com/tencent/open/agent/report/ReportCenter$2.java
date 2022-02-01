package com.tencent.open.agent.report;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings.Secure;
import bizw;
import bjgx;
import bjgz;
import bjkj;
import bjls;
import bjlt;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.TimeZone;

public class ReportCenter$2
  implements Runnable
{
  public ReportCenter$2(bjgx parambjgx, String paramString, boolean paramBoolean1, Bundle paramBundle, boolean paramBoolean2) {}
  
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
          ((Bundle)localObject2).putString("network", bjkj.a(bizw.a().a()));
          ((Bundle)localObject2).putString("language", bjls.b());
          ((Bundle)localObject2).putString("resolution", bjls.e());
          if (!this.jdField_a_of_type_Boolean) {
            break label460;
          }
          ??? = "";
          ((Bundle)localObject2).putString("apn", (String)???);
          ((Bundle)localObject2).putString("model_name", Build.MODEL);
          ((Bundle)localObject2).putString("timezone", TimeZone.getDefault().getID());
          ((Bundle)localObject2).putString("qq_ver", bizw.a().c());
          ((Bundle)localObject2).putString("qua", bizw.a().f());
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
          int m = bjgz.a().a("report_via");
          int j = bjlt.a(bizw.a().a(), null).a("Agent_ReportTimeInterval");
          i = j;
          if (j == 0) {
            i = 10000;
          }
          if ((this.this$0.a("report_via", m + k)) || (this.b))
          {
            this.this$0.a(this.jdField_a_of_type_Boolean);
            this.this$0.a.removeMessages(1001);
            return;
            ??? = bjls.c();
            continue;
            ??? = bjls.d();
            break label51;
            label425:
            ??? = Settings.Secure.getString(bizw.a().a().getContentResolver(), "android_id");
            break label71;
            label444:
            ??? = bjls.a();
            break label91;
            label452:
            ??? = bjls.f();
            break label130;
            label460:
            ??? = bjkj.b(bizw.a().a());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.agent.report.ReportCenter.2
 * JD-Core Version:    0.7.0.1
 */