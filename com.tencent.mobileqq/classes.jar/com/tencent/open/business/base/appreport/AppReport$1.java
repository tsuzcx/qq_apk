package com.tencent.open.business.base.appreport;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import bdid;
import bdii;
import bdjd;
import bdjl;
import bdjs;
import bdju;
import bdjv;
import com.tencent.smtt.sdk.WebView;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;

public final class AppReport$1
  implements Runnable
{
  public AppReport$1(String paramString1, int paramInt, Context paramContext, String paramString2, WebView paramWebView, String paramString3) {}
  
  public void run()
  {
    int m = 0;
    for (;;)
    {
      try
      {
        bdii.b("AppReport", "<AppReport> begin incrementalReport,packageName : " + this.jdField_a_of_type_JavaLangString + ", packageType :" + this.jdField_a_of_type_Int);
        if (this.jdField_a_of_type_AndroidContentContext == null)
        {
          bdii.e("AppReport", "<AppReport> incrementalReport context is null !");
          return;
        }
        HashMap localHashMap = new HashMap();
        Object localObject2;
        Object localObject3;
        int k;
        if ((this.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_JavaLangString.equals("com.tencent.android.qqdownloader")) || (this.jdField_a_of_type_Int != 8))
        {
          Object localObject1 = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("appcenter_app_report", 0);
          boolean bool1 = ((SharedPreferences)localObject1).getBoolean("is_app_last_fullReport_success", false);
          if (!bdjl.a(this.jdField_a_of_type_AndroidContentContext))
          {
            bdii.c("AppReport", "<AppReport> Package scan is closed !!!!");
            if (bool1)
            {
              j = this.jdField_a_of_type_Int;
              i = j;
            }
            try
            {
              if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
              {
                localObject1 = this.jdField_a_of_type_AndroidContentContext.getPackageManager().getPackageInfo(this.jdField_a_of_type_JavaLangString, 0);
                if ((((PackageInfo)localObject1).applicationInfo.flags & 0x1) != 0) {
                  continue;
                }
                i = j;
                if ((((PackageInfo)localObject1).applicationInfo.flags & 0x80) != 0) {
                  continue;
                }
              }
              bdjs.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, i);
            }
            catch (PackageManager.NameNotFoundException localNameNotFoundException1)
            {
              bdii.c("AppReport", "<AppReport> Package scan is closed, get packageinfo error : " + localNameNotFoundException1.toString());
              continue;
            }
            if ((this.b != null) && (this.jdField_a_of_type_ComTencentSmttSdkWebView != null)) {
              bdjv.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentSmttSdkWebView, this.b, true, this.c);
            }
          }
          else
          {
            long l = localNameNotFoundException1.getLong("app_last_fullReport_success_time", 0L);
            boolean bool2 = localNameNotFoundException1.getBoolean("is_incremental_report_overflow", false);
            if (l != 0L)
            {
              if (!bool1)
              {
                bdii.c("AppReport", "last full report failed , do incremental report !!!");
                bdjs.a(this.jdField_a_of_type_AndroidContentContext, this.b, this.jdField_a_of_type_ComTencentSmttSdkWebView, this.c, true);
                return;
              }
              if (bool2)
              {
                bdii.c("AppReport", "last incremental report overflow , do full report !!!");
                bdjs.a(this.jdField_a_of_type_AndroidContentContext, this.b, this.jdField_a_of_type_ComTencentSmttSdkWebView, this.c, true);
                return;
              }
              localObject2 = bdjs.a(this.jdField_a_of_type_AndroidContentContext);
              if ((localObject2 != null) && (((Map)localObject2).size() >= 70))
              {
                bdjs.a.lock();
                this.jdField_a_of_type_AndroidContentContext.deleteFile("appcenter_app_report_storage_file.txt");
                bdjs.a.unlock();
                localObject2 = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("appcenter_app_report", 0).edit();
                ((SharedPreferences.Editor)localObject2).putBoolean("is_incremental_report_overflow", true);
                ((SharedPreferences.Editor)localObject2).commit();
                bdjs.a(this.jdField_a_of_type_AndroidContentContext, this.b, this.jdField_a_of_type_ComTencentSmttSdkWebView, this.c, true);
                return;
              }
              if ((localObject2 != null) && (((Map)localObject2).size() > 0)) {
                localHashMap.putAll((Map)localObject2);
              }
              localObject3 = new StringBuilder().append("<AppReport> increamental report package local size :");
              if (localObject2 == null) {
                break label1165;
              }
              i = ((Map)localObject2).size();
              bdii.b("AppReport", i);
            }
          }
        }
        else
        {
          k = this.jdField_a_of_type_Int;
          j = k;
          String str1;
          String str2;
          if (this.b == null)
          {
            j = k;
            if (this.jdField_a_of_type_JavaLangString != null)
            {
              str1 = "0";
              str2 = " ";
              localObject2 = str2;
              localObject3 = str1;
              i = m;
            }
          }
          try
          {
            localObject4 = this.jdField_a_of_type_AndroidContentContext.getPackageManager().getPackageInfo(this.jdField_a_of_type_JavaLangString, 0);
            localObject2 = str2;
            localObject3 = str1;
            i = m;
            m = ((PackageInfo)localObject4).versionCode;
            localObject2 = str2;
            localObject3 = str1;
            i = m;
            str1 = ((PackageInfo)localObject4).versionName;
            localObject2 = str2;
            localObject3 = str1;
            i = m;
            str2 = bdjl.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
            localObject2 = str2;
            localObject3 = str1;
            i = m;
            if ((((PackageInfo)localObject4).applicationInfo.flags & 0x1) == 0)
            {
              localObject2 = str2;
              localObject3 = str1;
              i = m;
              int i1 = ((PackageInfo)localObject4).applicationInfo.flags;
              j = k;
              localObject4 = str2;
              localObject5 = str1;
              n = m;
              if ((i1 & 0x80) == 0) {}
            }
            else
            {
              j = k | 0x1;
              n = m;
              localObject5 = str1;
              localObject4 = str2;
            }
          }
          catch (PackageManager.NameNotFoundException localNameNotFoundException2)
          {
            j = k;
            Object localObject4 = localObject2;
            Object localObject5 = localObject3;
            int n = i;
            if (this.jdField_a_of_type_Int == 8) {
              continue;
            }
            bdii.e("AppReport", "<AppReport> get Package info form package <" + this.jdField_a_of_type_JavaLangString + "> error : " + localNameNotFoundException2.toString());
            j = k;
            localObject4 = localObject2;
            localObject5 = localObject3;
            n = i;
            continue;
            bdii.b("AppReport", "<AppReport> increamental report package size : " + localHashMap.size());
            localObject2 = bdjs.a(this.jdField_a_of_type_AndroidContentContext, localHashMap, "INC", this.c);
            bdii.b("AppReport", "<AppReport> incremental report params : " + ((Bundle)localObject2).toString());
            if (bdid.b(this.jdField_a_of_type_AndroidContentContext)) {
              continue;
            }
            bdjs.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, j);
            return;
            if (!TextUtils.isEmpty(((Bundle)localObject2).getString("sid"))) {
              continue;
            }
            if ((this.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_JavaLangString.equals("com.tencent.android.qqdownloader")) || (this.jdField_a_of_type_Int != 8)) {
              continue;
            }
            bdii.b("AppReport", "<AppReport> incremental report sid is null but still report myapp uninstall event");
            ((Bundle)localObject2).putString("sid", "fakesid");
            new bdjd("http://fusionbase.qq.com/cgi-bin/appstage/sdk_update", "POST", new bdju(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, j, this.b, this.jdField_a_of_type_ComTencentSmttSdkWebView)).execute(new Bundle[] { localObject2 });
            return;
            bdjs.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, j);
            return;
            new bdjd("http://fusionbase.qq.com/cgi-bin/appstage/sdk_update", "POST", new bdju(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, j, this.b, this.jdField_a_of_type_ComTencentSmttSdkWebView)).execute(new Bundle[] { localObject2 });
          }
          localHashMap.put(this.jdField_a_of_type_JavaLangString, bdjs.a(this.jdField_a_of_type_JavaLangString, n, (String)localObject5, j, (String)localObject4));
          if (localHashMap.size() <= 0)
          {
            bdii.b("AppReport", "<AppReport> Nothing to report, Incremental report finished !");
            return;
          }
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        int j;
        return;
      }
      int i = j | 0x1;
      continue;
      label1165:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.business.base.appreport.AppReport.1
 * JD-Core Version:    0.7.0.1
 */