package com.tencent.mobileqq.kandian.repo.handler.sp;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Locale;
import mqq.app.AppRuntime;

public class RIJGetIndividualArticleSp
{
  public static SimpleDateFormat a = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
  
  public static String a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("RIJGetIndividualArticleSp", 1, "failed to get sp IndividualPushDate");
      return "";
    }
    return paramAppRuntime.getString("readinjoy_individual_push_date", "");
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null)
    {
      QLog.d("RIJGetIndividualArticleSp", 1, "failed to update sp IndividualPushDate");
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putString("readinjoy_individual_push_date", a.format(Long.valueOf(System.currentTimeMillis())));
    RIJSPUtils.a(paramAppRuntime, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.handler.sp.RIJGetIndividualArticleSp
 * JD-Core Version:    0.7.0.1
 */