package com.tencent.open.agent.report;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings.Secure;
import bfbm;
import bfhz;
import bfib;
import bflk;
import bfmw;
import bfmx;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.TimeZone;

public class ReportCenter$2
  implements Runnable
{
  public ReportCenter$2(bfhz parambfhz, String paramString, Bundle paramBundle, boolean paramBoolean) {}
  
  public void run()
  {
    int i;
    do
    {
      try
      {
        ??? = new Bundle();
        ((Bundle)???).putString("uin", this.jdField_a_of_type_JavaLangString);
        ((Bundle)???).putString("imei", bfmw.c());
        ((Bundle)???).putString("imsi", bfmw.d());
        ((Bundle)???).putString("android_id", Settings.Secure.getString(bfbm.a().a().getContentResolver(), "android_id"));
        ((Bundle)???).putString("mac", bfmw.a());
        ((Bundle)???).putString("platform", "4");
        ((Bundle)???).putString("os_ver", Build.VERSION.RELEASE);
        ((Bundle)???).putString("position", bfmw.f());
        ((Bundle)???).putString("network", bflk.a(bfbm.a().a()));
        ((Bundle)???).putString("language", bfmw.b());
        ((Bundle)???).putString("resolution", bfmw.e());
        ((Bundle)???).putString("apn", bflk.b(bfbm.a().a()));
        ((Bundle)???).putString("model_name", Build.MODEL);
        ((Bundle)???).putString("timezone", TimeZone.getDefault().getID());
        ((Bundle)???).putString("qq_ver", bfbm.a().c());
        ((Bundle)???).putString("qua", bfbm.a().f());
        ((Bundle)???).putString("via", "2");
        ((Bundle)???).putString("result", "0");
        if (this.jdField_a_of_type_AndroidOsBundle != null) {
          ((Bundle)???).putAll(this.jdField_a_of_type_AndroidOsBundle);
        }
        localBaseData = new BaseData((Bundle)???);
      }
      catch (Exception localException)
      {
        BaseData localBaseData;
        int k;
        int m;
        int j;
        while (!QLog.isColorLevel()) {}
        QLog.d("ReportCenter", 2, "-->reportVia, exception in sub thread.", localException);
        return;
      }
      synchronized (this.this$0)
      {
        this.this$0.b.add(localBaseData);
        k = this.this$0.b.size();
        m = bfib.a().a("report_via");
        j = bfmx.a(bfbm.a().a(), null).a("Agent_ReportTimeInterval");
        i = j;
        if (j == 0) {
          i = 10000;
        }
        if ((this.this$0.a("report_via", m + k)) || (this.jdField_a_of_type_Boolean))
        {
          this.this$0.a();
          this.this$0.a.removeMessages(1001);
          return;
        }
      }
    } while (this.this$0.a.hasMessages(1001));
    Message localMessage = Message.obtain();
    localMessage.what = 1001;
    this.this$0.a.sendMessageDelayed(localMessage, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.report.ReportCenter.2
 * JD-Core Version:    0.7.0.1
 */