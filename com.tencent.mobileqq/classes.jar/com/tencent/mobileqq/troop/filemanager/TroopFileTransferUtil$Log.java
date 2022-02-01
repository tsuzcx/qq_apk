package com.tencent.mobileqq.troop.filemanager;

import com.tencent.qphone.base.util.QLog;

public class TroopFileTransferUtil$Log
{
  public static String a = "<TroopFile> ";
  public static int b = 0;
  public static int c = 1;
  public static int d = 2;
  
  private static int a(int paramInt)
  {
    if (b == paramInt) {
      return 1;
    }
    if (c == paramInt) {
      return 2;
    }
    if (d == paramInt) {
      return 4;
    }
    return 2;
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    paramInt = a(paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(paramString2);
    QLog.e(paramString1, paramInt, localStringBuilder.toString());
  }
  
  public static void b(String paramString1, int paramInt, String paramString2)
  {
    paramInt = a(paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(paramString2);
    QLog.w(paramString1, paramInt, localStringBuilder.toString());
  }
  
  public static void c(String paramString1, int paramInt, String paramString2)
  {
    paramInt = a(paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(paramString2);
    QLog.i(paramString1, paramInt, localStringBuilder.toString());
  }
  
  public static void d(String paramString1, int paramInt, String paramString2)
  {
    paramInt = a(paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(paramString2);
    QLog.d(paramString1, paramInt, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log
 * JD-Core Version:    0.7.0.1
 */