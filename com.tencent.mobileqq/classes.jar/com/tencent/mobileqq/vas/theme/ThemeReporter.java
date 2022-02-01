package com.tencent.mobileqq.vas.theme;

import android.text.TextUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class ThemeReporter
{
  public static final String a = String.valueOf(153);
  public static final String b = String.valueOf(153);
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if (paramInt2 < 0) {
      NetworkUtil.getSystemNetwork(null);
    }
    paramAppRuntime = paramString4;
    try
    {
      if (TextUtils.isEmpty(paramString4)) {
        paramAppRuntime = "1";
      }
      if ((QLog.isColorLevel()) && (paramInt3 < 0))
      {
        paramString4 = new StringBuilder();
        paramString4.append(paramString1);
        paramString4.append("|step:");
        paramString4.append(paramInt1);
        paramString4.append("|from:");
        paramString4.append(paramString2);
        paramString4.append("|resultCode:");
        paramString4.append(paramInt3);
        paramString4.append("|id:");
        paramString4.append(paramString3);
        paramString4.append("|version:");
        paramString4.append(paramAppRuntime);
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("ThemeReporterreportTheme Error data::");
        paramAppRuntime.append(paramString4.toString());
        QLog.i("ThemeReporter", 2, paramAppRuntime.toString());
        return;
      }
    }
    catch (Exception paramAppRuntime)
    {
      paramString1 = new StringBuilder();
      paramString1.append("ThemeReporter reportTheme Exception:");
      paramString1.append(paramAppRuntime.getMessage());
      QLog.e("ThemeReporter", 1, paramString1.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.ThemeReporter
 * JD-Core Version:    0.7.0.1
 */