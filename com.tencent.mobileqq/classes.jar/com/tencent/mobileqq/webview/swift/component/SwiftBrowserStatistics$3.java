package com.tencent.mobileqq.webview.swift.component;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.injector.ISwiftBrowserStatisticInjector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class SwiftBrowserStatistics$3
  implements Runnable
{
  SwiftBrowserStatistics$3(SwiftBrowserStatistics paramSwiftBrowserStatistics, String paramString1, Intent paramIntent, Context paramContext, long paramLong, String paramString2) {}
  
  public void run()
  {
    for (;;)
    {
      int i;
      int j;
      try
      {
        localObject1 = Uri.parse(this.jdField_a_of_type_JavaLangString);
        int k = 0;
        if (localObject1 != null)
        {
          localObject2 = ((Uri)localObject1).getHost();
          if (((TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject2).endsWith(".qq.com"))) && (this.this$0.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_a_of_type_Int < 11))
          {
            if (!QLog.isColorLevel()) {
              break label725;
            }
            QLog.d("QQBrowser_report", 2, "mUrl is null or url is not from qq.com!");
            return;
          }
          localObject2 = ((Uri)localObject1).getQueryParameter("hasRedDot");
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            this.this$0.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_a_of_type_Boolean = ((String)localObject2).equalsIgnoreCase("1");
          }
          if (!this.this$0.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_a_of_type_Boolean) {
            this.this$0.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("has_red_dot", false);
          }
          localObject1 = ((Uri)localObject1).getQueryParameter("crashFrom");
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            this.this$0.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.b = Integer.parseInt((String)localObject1);
          }
        }
        i = this.jdField_a_of_type_JavaLangString.indexOf("?");
        if (i != -1) {
          localObject1 = this.jdField_a_of_type_JavaLangString.substring(0, i);
        } else {
          localObject1 = this.jdField_a_of_type_JavaLangString;
        }
        boolean bool = SwiftBrowserStatistics.CrashStepStatsEntry.jdField_a_of_type_JavaUtilHashMap.isEmpty();
        i = 10;
        if (bool)
        {
          this.this$0.a(this.jdField_a_of_type_AndroidContentContext, this.this$0.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry);
          if ((SwiftBrowserStatistics.CrashStepStatsEntry.jdField_a_of_type_JavaUtilHashMap.isEmpty()) || (!SwiftBrowserStatistics.CrashStepStatsEntry.jdField_a_of_type_JavaUtilHashMap.containsKey("sample_rate"))) {
            SwiftBrowserStatistics.CrashStepStatsEntry.jdField_a_of_type_JavaUtilHashMap.put("sample_rate", Integer.valueOf(10));
          }
        }
        if (SwiftBrowserStatistics.CrashStepStatsEntry.jdField_a_of_type_JavaUtilHashMap.containsKey("sample_rate")) {
          i = ((Integer)SwiftBrowserStatistics.CrashStepStatsEntry.jdField_a_of_type_JavaUtilHashMap.get("sample_rate")).intValue();
        }
        j = i;
        if (SwiftBrowserStatistics.CrashStepStatsEntry.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject1)) {
          j = ((Integer)SwiftBrowserStatistics.CrashStepStatsEntry.jdField_a_of_type_JavaUtilHashMap.get(localObject1)).intValue();
        }
        localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        i = k;
        if (localAppRuntime == null) {
          break label726;
        }
        i = k;
        if (localAppRuntime.getLongAccountUin() == 0L) {
          break label726;
        }
        i = k;
        if (localAppRuntime.getLongAccountUin() % j != this.this$0.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.c) {
          break label726;
        }
        i = 1;
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        Object localObject2;
        AppRuntime localAppRuntime;
        QLog.e("QQBrowser_report", 1, "report step error!", localThrowable);
      }
      if (i != 0)
      {
        localObject2 = localObject1;
        if (this.this$0.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.b != -1)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("?type=");
          ((StringBuilder)localObject2).append(this.this$0.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.b);
          localObject2 = ((StringBuilder)localObject2).toString();
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("try report web status, onBackEvent,  step: ");
          ((StringBuilder)localObject1).append(this.this$0.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_a_of_type_Int);
          ((StringBuilder)localObject1).append(", hasRedDot : ");
          ((StringBuilder)localObject1).append(this.this$0.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_a_of_type_Boolean);
          ((StringBuilder)localObject1).append(", crashFrom : ");
          ((StringBuilder)localObject1).append(this.this$0.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.b);
          ((StringBuilder)localObject1).append(", stepTime: ");
          ((StringBuilder)localObject1).append(this.this$0.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_a_of_type_Long - this.this$0.b);
          ((StringBuilder)localObject1).append(", totalTime: ");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_Long - this.this$0.b);
          ((StringBuilder)localObject1).append("\n");
          ((StringBuilder)localObject1).append((String)localObject2);
          QLog.d("QQBrowser_report", 2, ((StringBuilder)localObject1).toString());
        }
        this.this$0.a((String)localObject2, this.jdField_a_of_type_Long, localAppRuntime, this.b, "WebStatusReport");
        this.this$0.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.b = -1;
        SwiftBrowserStatistics.CrashStepStatsEntry.d = -1;
      }
      if (SwiftBrowserStatistics.a(this.this$0) != null)
      {
        SwiftBrowserStatistics.a(this.this$0).a(this.this$0.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, localAppRuntime, this.b);
        return;
      }
      return;
      label725:
      return;
      label726:
      if (j == 1) {
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.3
 * JD-Core Version:    0.7.0.1
 */