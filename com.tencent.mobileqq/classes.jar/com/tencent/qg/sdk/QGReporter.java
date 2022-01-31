package com.tencent.qg.sdk;

import android.util.Log;

public class QGReporter
{
  private static QGReporter.QGReporterImpl sReporterInstance;
  
  public static void reportEvent(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    if (sReporterInstance == null)
    {
      Log.v("QG", "reportEvent. tag=" + paramString1 + ", mainAction=" + paramString2 + ", op_type=" + paramString3 + ", op_name=" + paramString4 + ", op_in=" + paramInt1 + ", op_result=" + paramInt2 + ", d1=" + paramString5 + ", d2=" + paramString6 + ", d3=" + paramString7 + ", d4=" + paramString8);
      return;
    }
    sReporterInstance.reportEvent(paramString1, paramString2, paramString3, paramString4, paramInt1, paramInt2, paramString5, paramString6, paramString7, paramString8);
  }
  
  public static void setReporter(QGReporter.QGReporterImpl paramQGReporterImpl)
  {
    sReporterInstance = paramQGReporterImpl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qg.sdk.QGReporter
 * JD-Core Version:    0.7.0.1
 */