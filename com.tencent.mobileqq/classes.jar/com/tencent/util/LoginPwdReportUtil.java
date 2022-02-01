package com.tencent.util;

import android.content.Context;
import android.text.TextUtils;
import android.widget.AutoCompleteTextView;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;

public class LoginPwdReportUtil
{
  public static void a(Context paramContext, int paramInt)
  {
    if ((paramContext != null) && ((paramContext instanceof LoginActivity)) && (paramInt == 16908322))
    {
      paramContext = ((LoginActivity)paramContext).getCurrentView();
      if ((paramContext != null) && ((paramContext instanceof LoginView)))
      {
        paramContext = ((LoginView)paramContext).l();
        if (paramContext == null)
        {
          QLog.e("LoginPwdReportUtil", 1, "reportForLoginView fail: autoCompleteTextView == null");
          return;
        }
        paramContext = paramContext.getText();
        if (paramContext == null)
        {
          QLog.e("LoginPwdReportUtil", 1, "reportForLoginView fail: editable null");
          return;
        }
        paramContext = paramContext.toString();
        if ((!TextUtils.isEmpty(paramContext)) && (a(paramContext)) && (Utils.j(paramContext)))
        {
          ReportController.a(null, "dc00898", "", paramContext, "0X800B29A", "0X800B29A", 1, 0, "", "", "", "");
          return;
        }
        QLog.e("LoginPwdReportUtil", 1, "reportForLoginView fail: uin error");
        return;
      }
      QLog.e("LoginPwdReportUtil", 1, "reportForLoginView fail: fragment wrong");
      return;
    }
    QLog.e("LoginPwdReportUtil", 1, "reportForLoginView fail: params wrong");
  }
  
  public static boolean a(String paramString)
  {
    boolean bool = false;
    try
    {
      long l = Long.valueOf(Long.parseLong(paramString)).longValue();
      if (l > 10000L) {
        bool = true;
      }
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.util.LoginPwdReportUtil
 * JD-Core Version:    0.7.0.1
 */