package com.tencent.mobileqq.qqpermission.util;

import com.tencent.qphone.base.util.QLog;

public class QPLog
{
  public static void a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQPermission.");
    localStringBuilder.append(paramString1);
    QLog.i(localStringBuilder.toString(), 1, paramString2);
  }
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQPermission.");
    localStringBuilder.append(paramString);
    QLog.d(localStringBuilder.toString(), 1, paramVarArgs);
  }
  
  public static void b(String paramString, Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQPermission.");
    localStringBuilder.append(paramString);
    QLog.e(localStringBuilder.toString(), 1, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqpermission.util.QPLog
 * JD-Core Version:    0.7.0.1
 */