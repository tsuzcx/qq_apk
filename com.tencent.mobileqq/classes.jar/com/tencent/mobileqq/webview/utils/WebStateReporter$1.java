package com.tencent.mobileqq.webview.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class WebStateReporter$1
  implements Runnable
{
  WebStateReporter$1(WebStateReporter paramWebStateReporter, boolean paramBoolean, String paramString1, Context paramContext, long paramLong, String paramString2) {}
  
  public void run()
  {
    boolean bool3 = this.jdField_a_of_type_Boolean;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      boolean bool2 = bool3;
      boolean bool1;
      try
      {
        localObject2 = Uri.parse(this.jdField_a_of_type_JavaLangString);
        bool2 = bool3;
        String str = ((Uri)localObject2).getQueryParameter("hasRedDot");
        bool1 = bool3;
        bool2 = bool3;
        if (!TextUtils.isEmpty(str))
        {
          bool2 = bool3;
          bool1 = str.equalsIgnoreCase("1");
        }
        bool2 = bool1;
        localObject2 = ((Uri)localObject2).getQueryParameter("crashFrom");
        bool2 = bool1;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          bool2 = bool1;
          i = Integer.parseInt((String)localObject2);
        }
        else
        {
          i = -1;
        }
        bool2 = bool1;
        j = i;
        try
        {
          if (!QLog.isColorLevel()) {
            break label215;
          }
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("parse url, redDot : ");
          ((StringBuilder)localObject3).append(str);
          ((StringBuilder)localObject3).append(", urlFromType : ");
          ((StringBuilder)localObject3).append((String)localObject2);
          QLog.d("WebStateReporter_report", 2, ((StringBuilder)localObject3).toString());
          bool2 = bool1;
          j = i;
        }
        catch (Exception localException1) {}
        bool2 = bool1;
      }
      catch (Exception localException2)
      {
        i = -1;
        bool1 = bool2;
      }
      int j = i;
      if (QLog.isColorLevel())
      {
        QLog.e("WebStateReporter_report", 2, "parse url got some problem!", localException2);
        j = i;
        bool2 = bool1;
      }
      label215:
      int i = this.jdField_a_of_type_JavaLangString.indexOf("?");
      Object localObject2 = this.jdField_a_of_type_JavaLangString;
      Object localObject1 = localObject2;
      if (i != -1) {
        localObject1 = ((String)localObject2).substring(0, i);
      }
      if (WebStateReporter.jdField_a_of_type_JavaUtilHashMap.isEmpty())
      {
        this.this$0.a(this.jdField_a_of_type_AndroidContentContext);
        if (WebStateReporter.jdField_a_of_type_JavaUtilHashMap.isEmpty()) {
          WebStateReporter.jdField_a_of_type_JavaUtilHashMap.put("sample_rate", Integer.valueOf(10));
        }
      }
      if (WebStateReporter.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject1)) {
        localObject2 = WebStateReporter.jdField_a_of_type_JavaUtilHashMap.get(localObject1);
      } else {
        localObject2 = WebStateReporter.jdField_a_of_type_JavaUtilHashMap.get("sample_rate");
      }
      i = ((Integer)localObject2).intValue();
      if ((1 != i) && (this.jdField_a_of_type_Long % i != WebStateReporter.jdField_c_of_type_Int)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0) {
        return;
      }
      localObject2 = localObject1;
      if (j != -1)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("?type=");
        ((StringBuilder)localObject2).append(j);
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("try report web status,  step: ");
        ((StringBuilder)localObject1).append(this.this$0.jdField_b_of_type_Int);
        ((StringBuilder)localObject1).append(", hasRedDot : ");
        ((StringBuilder)localObject1).append(bool2);
        ((StringBuilder)localObject1).append(", crashFrom : ");
        ((StringBuilder)localObject1).append(j);
        ((StringBuilder)localObject1).append(", stepTime: ");
        ((StringBuilder)localObject1).append(this.this$0.jdField_c_of_type_Long - this.this$0.jdField_b_of_type_Long);
        ((StringBuilder)localObject1).append(", totalTime: ");
        ((StringBuilder)localObject1).append(System.currentTimeMillis() - this.this$0.jdField_b_of_type_Long);
        ((StringBuilder)localObject1).append("\n");
        ((StringBuilder)localObject1).append((String)localObject2);
        QLog.d("WebStateReporter_report", 2, ((StringBuilder)localObject1).toString());
      }
      if (!TextUtils.isEmpty(this.this$0.jdField_a_of_type_JavaLangString)) {
        localObject1 = this.this$0.jdField_a_of_type_JavaLangString;
      } else {
        localObject1 = "unknown";
      }
      Object localObject3 = this.b;
      if (bool2) {
        i = 1;
      } else {
        i = 0;
      }
      ReportController.b(null, "P_CliOper", "WebStatusReport", "", (String)localObject1, (String)localObject3, i, 1, this.this$0.jdField_b_of_type_Int, (String)localObject2, Build.VERSION.RELEASE, String.valueOf(this.this$0.jdField_c_of_type_Long - this.this$0.jdField_b_of_type_Long), String.valueOf(System.currentTimeMillis() - this.this$0.jdField_b_of_type_Long));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.utils.WebStateReporter.1
 * JD-Core Version:    0.7.0.1
 */