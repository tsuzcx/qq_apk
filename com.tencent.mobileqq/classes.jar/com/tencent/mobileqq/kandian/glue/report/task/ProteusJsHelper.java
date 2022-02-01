package com.tencent.mobileqq.kandian.glue.report.task;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class ProteusJsHelper
{
  private static Map<String, JSContext> a = new HashMap();
  
  public static Object a(String paramString1, String paramString2, String paramString3, @NonNull StringBuffer paramStringBuffer)
  {
    try
    {
      long l = System.currentTimeMillis();
      QLog.d("kandianreport.ProteusJsHelper", 1, "evaluateJS, begin.");
      paramString1 = (JSContext)a.get(paramString1);
      QLog.d("kandianreport.ProteusJsHelper", 1, new Object[] { "evaluateJS, get js context time cost = ", Long.valueOf(System.currentTimeMillis() - l) });
      if (paramString1 != null) {
        try
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString2);
          localStringBuilder.append("(");
          localStringBuilder.append(paramString3);
          localStringBuilder.append(")");
          paramString3 = localStringBuilder.toString();
          paramString1 = paramString1.a(paramString3, paramStringBuffer);
          QLog.d("kandianreport.ProteusJsHelper", 1, new Object[] { "evaluateStringWithException, time cost = ", Long.valueOf(System.currentTimeMillis() - l) });
          if (!TextUtils.isEmpty(paramStringBuffer))
          {
            paramString1 = new StringBuilder();
            paramString1.append("evalute js: ");
            paramString1.append(paramString3);
            paramString1.append(" exception: ");
            paramString1.append(paramStringBuffer);
            QLog.d("kandianreport.ProteusJsHelper", 1, paramString1.toString());
            return null;
          }
          return paramString1;
        }
        catch (Throwable paramString1)
        {
          paramString3 = new StringBuilder();
          paramString3.append("evalute js: ");
          paramString3.append(paramString2);
          paramString3.append(" exception: ");
          paramString3.append(paramString1.getMessage());
          QLog.d("kandianreport.ProteusJsHelper", 1, paramString3.toString());
        }
      }
      return null;
    }
    finally {}
  }
  
  public static void a()
  {
    try
    {
      QLog.d("kandianreport.ProteusJsHelper", 1, "prepare to load.");
      KandianReportSoLoader.b();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("kandianreport.ProteusJsHelper", 1, "prepare error, t = ", localThrowable);
    }
  }
  
  public static boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (!KandianReportSoLoader.c())
      {
        bool1 = bool2;
        KandianReportSoLoader.a(new ProteusJsHelper.1());
        return false;
      }
      bool1 = bool2;
      bool2 = KandianReportSoLoader.a();
      bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        KandianReportSoLoader.b();
        return bool2;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.d("kandianreport.ProteusJsHelper", 2, "preLoadSo, t = ", localThrowable);
    }
    return bool1;
  }
  
  private static void c(String paramString1, String paramString2)
  {
    if (!KandianReportSoLoader.a())
    {
      QLog.d("kandianreport.ProteusJsHelper", 1, "so not loaded, now load");
      KandianReportSoLoader.b(new ProteusJsHelper.3(paramString1, paramString2));
      return;
    }
    d(paramString1, paramString2);
  }
  
  private static void d(String paramString1, String paramString2)
  {
    JSContext localJSContext = new JSContext();
    StringBuffer localStringBuffer = new StringBuffer();
    localJSContext.a(paramString1, localStringBuffer);
    if (!TextUtils.isEmpty(localStringBuffer))
    {
      paramString1 = new StringBuilder();
      paramString1.append("create js context failed id: ");
      paramString1.append(paramString2);
      paramString1.append(" exception: ");
      paramString1.append(localStringBuffer);
      QLog.d("kandianreport.ProteusJsHelper", 1, paramString1.toString());
      return;
    }
    a.put(paramString2, localJSContext);
    paramString1 = new StringBuilder();
    paramString1.append("create js context success: ");
    paramString1.append(paramString2);
    QLog.d("kandianreport.ProteusJsHelper", 1, paramString1.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.task.ProteusJsHelper
 * JD-Core Version:    0.7.0.1
 */