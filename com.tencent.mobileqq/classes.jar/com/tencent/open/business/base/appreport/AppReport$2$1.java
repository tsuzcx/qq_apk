package com.tencent.open.business.base.appreport;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import bcxm;
import bdho;
import bdht;
import bdio;
import bdiw;
import bdjd;
import bdje;
import bdjg;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

class AppReport$2$1
  implements Runnable
{
  AppReport$2$1(AppReport.2 param2) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        bdht.b("AppReport", "<AppReport> begin doFullReport ...");
        if (this.this$0.jdField_a_of_type_AndroidContentContext == null)
        {
          bdht.e("AppReport", "<AppReport> fullReport context is null !");
          return;
        }
        if (bdjd.jdField_a_of_type_Boolean)
        {
          if ((this.this$0.jdField_a_of_type_JavaLangString != null) && (this.this$0.jdField_a_of_type_ComTencentSmttSdkWebView != null))
          {
            boolean bool = bdjd.jdField_a_of_type_Boolean;
            if (bool)
            {
              try
              {
                bdht.c("AppReport", "<AppReport>Wait 100 milliseconds for another full report finished,before getUpdateAppRequest");
                Thread.sleep(new Random().nextInt(50) + 50L);
              }
              catch (InterruptedException localInterruptedException)
              {
                bdht.e("AppReport", "<AppReport> fullReport context is null !");
              }
              continue;
            }
            if (this.this$0.jdField_a_of_type_AndroidContentContext.getSharedPreferences("appcenter_app_report", 0).getBoolean("is_app_last_fullReport_success", false))
            {
              bdjg.a(this.this$0.jdField_a_of_type_AndroidContentContext, this.this$0.jdField_a_of_type_ComTencentSmttSdkWebView, this.this$0.jdField_a_of_type_JavaLangString, true, this.this$0.b);
              return;
            }
            bdjg.a(this.this$0.jdField_a_of_type_AndroidContentContext, this.this$0.jdField_a_of_type_ComTencentSmttSdkWebView, this.this$0.jdField_a_of_type_JavaLangString, false, this.this$0.b);
            return;
          }
          bdht.c("AppReport", "<AppReport>Another full report running, fullReport will not continue !!!");
          return;
        }
        bdjd.jdField_a_of_type_Boolean = true;
        if ((this.this$0.jdField_a_of_type_JavaLangString != null) && (this.this$0.jdField_a_of_type_ComTencentSmttSdkWebView != null))
        {
          bdht.c("AppReport", "<AppReport> onResult get app update list without full report");
          if ((!bdjd.a()) || (!bdjd.a(this.this$0.jdField_a_of_type_AndroidContentContext)))
          {
            bdht.c("AppReport", "doFullReport get app update list without full report, because : full report switch off, or Over max full report times a day");
            bdjd.jdField_a_of_type_Boolean = false;
            bdjg.a(this.this$0.jdField_a_of_type_AndroidContentContext, this.this$0.jdField_a_of_type_ComTencentSmttSdkWebView, this.this$0.jdField_a_of_type_JavaLangString, false, this.this$0.b);
            return;
          }
          if (!bdiw.a(this.this$0.jdField_a_of_type_AndroidContentContext))
          {
            bdht.c("AppReport", "<AppReport> doFullReport get app update list without full report, because : packageScan is not allowed");
            bdjd.jdField_a_of_type_Boolean = false;
            bdjg.a(this.this$0.jdField_a_of_type_AndroidContentContext, this.this$0.jdField_a_of_type_ComTencentSmttSdkWebView, this.this$0.jdField_a_of_type_JavaLangString, true, this.this$0.b);
          }
        }
        else if (!bdiw.a(this.this$0.jdField_a_of_type_AndroidContentContext))
        {
          bdht.c("AppReport", "<AppReport> doFullReport will not continue , because : packageScan is not allowed");
          bdjd.jdField_a_of_type_Boolean = false;
          return;
        }
        Object localObject2 = bdiw.a(this.this$0.jdField_a_of_type_AndroidContentContext);
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          Object localObject1 = new HashMap();
          localObject2 = ((List)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            PackageInfo localPackageInfo = (PackageInfo)((Iterator)localObject2).next();
            if ((localPackageInfo.applicationInfo.flags & 0x1) != 0) {
              break label813;
            }
            if ((localPackageInfo.applicationInfo.flags & 0x80) != 0)
            {
              break label813;
              ((Map)localObject1).put(localPackageInfo.packageName, bdjd.a(localPackageInfo.packageName, localPackageInfo.versionCode, localPackageInfo.versionName, i, bdiw.a(this.this$0.jdField_a_of_type_AndroidContentContext, localPackageInfo.packageName)));
            }
          }
          else
          {
            localObject1 = bdjd.a(this.this$0.jdField_a_of_type_AndroidContentContext, (Map)localObject1, "ALL", this.this$0.b);
            bdht.b("AppReport", "<AppReport> incremental report params : " + ((Bundle)localObject1).toString());
            if ((!bdho.b(this.this$0.jdField_a_of_type_AndroidContentContext)) || (((Bundle)localObject1).getString("sid").equals("")))
            {
              localObject1 = this.this$0.jdField_a_of_type_AndroidContentContext.getSharedPreferences("appcenter_app_report", 0).edit();
              ((SharedPreferences.Editor)localObject1).putBoolean("is_app_last_fullReport_success", false);
              ((SharedPreferences.Editor)localObject1).commit();
              bdht.b("AppReport", "<AppReport> full report stoped !!! because network is unavaliable or get sid error");
              bdjd.jdField_a_of_type_Boolean = false;
              if ((!this.this$0.jdField_a_of_type_Boolean) || (this.this$0.jdField_a_of_type_ComTencentSmttSdkWebView == null)) {
                continue;
              }
              bcxm.a().a("{\"guid\":1,\"method\":\"POST\"}", this.this$0.jdField_a_of_type_AndroidContentContext, this.this$0.jdField_a_of_type_ComTencentSmttSdkWebView);
              return;
            }
            bdht.b("AppReport", "<AppReport> do full report to server !!!");
            new bdio("http://fusionbase.qq.com/cgi-bin/appstage/sdk_update", "POST", new bdje(this.this$0.jdField_a_of_type_AndroidContentContext, this.this$0.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentSmttSdkWebView)).execute(new Bundle[] { localObject1 });
            continue;
          }
        }
        else
        {
          if ((this.this$0.jdField_a_of_type_JavaLangString == null) || (this.this$0.jdField_a_of_type_ComTencentSmttSdkWebView == null)) {
            continue;
          }
          bdjg.a(this.this$0.jdField_a_of_type_AndroidContentContext, this.this$0.jdField_a_of_type_ComTencentSmttSdkWebView, this.this$0.jdField_a_of_type_JavaLangString, true, this.this$0.b);
          bdjd.jdField_a_of_type_Boolean = false;
          continue;
        }
        i = 0;
        continue;
        return;
      }
      catch (Throwable localThrowable)
      {
        return;
      }
      label813:
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.business.base.appreport.AppReport.2.1
 * JD-Core Version:    0.7.0.1
 */