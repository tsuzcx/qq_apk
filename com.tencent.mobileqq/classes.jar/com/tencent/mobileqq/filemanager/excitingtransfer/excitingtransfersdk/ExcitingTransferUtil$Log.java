package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

import com.tencent.qphone.base.util.QLog;

public class ExcitingTransferUtil$Log
{
  public static int CLR = 1;
  public static int DEV = 2;
  public static String LG_HEAD = "ExcitingT.";
  public static int USR;
  
  public static void d(String paramString1, int paramInt, String paramString2)
  {
    paramInt = qlogLevelOf(paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(LG_HEAD);
    localStringBuilder.append(paramString2);
    QLog.d(paramString1, paramInt, localStringBuilder.toString());
  }
  
  public static void e(String paramString1, int paramInt, String paramString2)
  {
    paramInt = qlogLevelOf(paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(LG_HEAD);
    localStringBuilder.append(paramString2);
    QLog.e(paramString1, paramInt, localStringBuilder.toString());
  }
  
  public static void i(String paramString1, int paramInt, String paramString2)
  {
    paramInt = qlogLevelOf(paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(LG_HEAD);
    localStringBuilder.append(paramString2);
    QLog.i(paramString1, paramInt, localStringBuilder.toString());
  }
  
  public static boolean isDevelopLevel()
  {
    return QLog.isDevelopLevel();
  }
  
  private static int qlogLevelOf(int paramInt)
  {
    if (USR == paramInt) {
      return 1;
    }
    if (CLR == paramInt) {
      return 2;
    }
    if (DEV == paramInt) {
      return 4;
    }
    return 2;
  }
  
  public static void w(String paramString1, int paramInt, String paramString2)
  {
    paramInt = qlogLevelOf(paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(LG_HEAD);
    localStringBuilder.append(paramString2);
    QLog.w(paramString1, paramInt, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUtil.Log
 * JD-Core Version:    0.7.0.1
 */