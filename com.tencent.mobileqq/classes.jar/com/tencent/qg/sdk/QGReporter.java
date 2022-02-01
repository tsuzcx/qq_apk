package com.tencent.qg.sdk;

import android.util.Log;

public class QGReporter
{
  private static QGReporter.QGReporterImpl sReporterInstance;
  
  public static void reportEvent(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    Object localObject = sReporterInstance;
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportEvent. tag=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", mainAction=");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", op_type=");
      ((StringBuilder)localObject).append(paramString3);
      ((StringBuilder)localObject).append(", op_name=");
      ((StringBuilder)localObject).append(paramString4);
      ((StringBuilder)localObject).append(", op_in=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", op_result=");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", d1=");
      ((StringBuilder)localObject).append(paramString5);
      ((StringBuilder)localObject).append(", d2=");
      ((StringBuilder)localObject).append(paramString6);
      ((StringBuilder)localObject).append(", d3=");
      ((StringBuilder)localObject).append(paramString7);
      ((StringBuilder)localObject).append(", d4=");
      ((StringBuilder)localObject).append(paramString8);
      Log.v("QG", ((StringBuilder)localObject).toString());
      return;
    }
    ((QGReporter.QGReporterImpl)localObject).reportEvent(paramString1, paramString2, paramString3, paramString4, paramInt1, paramInt2, paramString5, paramString6, paramString7, paramString8);
  }
  
  public static void setReporter(QGReporter.QGReporterImpl paramQGReporterImpl)
  {
    sReporterInstance = paramQGReporterImpl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qg.sdk.QGReporter
 * JD-Core Version:    0.7.0.1
 */