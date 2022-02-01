package com.tencent.open.agent.util;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.data.SharedPrefs;

public class AuthReporter
{
  public static void a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.equals(SharedPrefs.a()))) {
      ReportController.b(null, "dc00898", "", paramString1, paramString2, paramString2, 0, 0, "", "", "", "");
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = paramString3;
    if (paramString3 == null) {
      str = "";
    }
    paramString3 = paramString4;
    if (paramString4 == null) {
      paramString3 = "";
    }
    paramString4 = new Bundle();
    paramString4.putString("uin", paramString1);
    paramString4.putString("openid", "");
    paramString4.putString("report_type", "1");
    paramString4.putString("act_type", "7");
    paramString4.putString("via", "2");
    paramString4.putString("app_id", paramString2);
    paramString4.putString("packagename", str);
    paramString4.putString("stringext_1", paramString3);
    paramString4.putString("result", "0");
    ReportCenter.a().a(paramString4, paramString2, paramString1, false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.util.AuthReporter
 * JD-Core Version:    0.7.0.1
 */