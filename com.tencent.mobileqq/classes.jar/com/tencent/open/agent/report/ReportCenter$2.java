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
      } else {
        ??? = MobileInfoUtil.getImei();
      }
      ((Bundle)localObject2).putString("imei", (String)???);
      if (this.jdField_a_of_type_Boolean) {
        ??? = "";
      } else {
        ??? = MobileInfoUtil.getImsi();
      }
      ((Bundle)localObject2).putString("imsi", (String)???);
      if (this.jdField_a_of_type_Boolean) {
        ??? = "";
      } else {
        ??? = Settings.Secure.getString(CommonDataAdapter.a().a().getContentResolver(), "android_id");
      }
      ((Bundle)localObject2).putString("android_id", (String)???);
      if (this.jdField_a_of_type_Boolean) {
        ??? = "";
      } else {
        ??? = MobileInfoUtil.getLocalMacAddress();
      }
      ((Bundle)localObject2).putString("mac", (String)???);
      ((Bundle)localObject2).putString("platform", "4");
      ((Bundle)localObject2).putString("os_ver", Build.VERSION.RELEASE);
      if (this.jdField_a_of_type_Boolean) {
        ??? = "";
      } else {
        ??? = MobileInfoUtil.getLocation();
      }
      ((Bundle)localObject2).putString("position", (String)???);
      ((Bundle)localObject2).putString("network", APNUtil.a(CommonDataAdapter.a().a()));
      ((Bundle)localObject2).putString("language", MobileInfoUtil.getLanguage());
      ((Bundle)localObject2).putString("resolution", MobileInfoUtil.getResolution());
      if (this.jdField_a_of_type_Boolean) {
        ??? = "";
      } else {
        ??? = APNUtil.b(CommonDataAdapter.a().a());
      }
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
      synchronized (this.this$0)
      {
        this.this$0.b.add(localObject2);
        int k = this.this$0.b.size();
        int m = ReportDatabaseHelper.a().a("report_via");
        int j = OpenConfig.a(CommonDataAdapter.a().a(), null).b("Agent_ReportTimeInterval");
        int i = j;
        if (j == 0) {
          i = 10000;
        }
        if ((!this.this$0.a("report_via", k + m)) && (!this.b))
        {
          if (!this.this$0.a.hasMessages(1001))
          {
            ??? = Message.obtain();
            ((Message)???).what = 1001;
            ((Message)???).obj = Boolean.valueOf(this.jdField_a_of_type_Boolean);
            this.this$0.a.sendMessageDelayed((Message)???, i);
          }
        }
        else
        {
          this.this$0.a(this.jdField_a_of_type_Boolean);
          this.this$0.a.removeMessages(1001);
          return;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReportCenter", 2, "-->reportVia, exception in sub thread.", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.report.ReportCenter.2
 * JD-Core Version:    0.7.0.1
 */