package com.tencent.mobileqq.kandian.biz.pts.util;

import com.tencent.qphone.base.util.QLog;

public class FluencyLogUtil
{
  public static void a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Class : ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" Scene : ");
    localStringBuilder.append(paramString2);
    QLog.d("FluencyLogUtil", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.FluencyLogUtil
 * JD-Core Version:    0.7.0.1
 */