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
    QLog.d(paramString1, qlogLevelOf(paramInt), LG_HEAD + paramString2);
  }
  
  public static void e(String paramString1, int paramInt, String paramString2)
  {
    QLog.e(paramString1, qlogLevelOf(paramInt), LG_HEAD + paramString2);
  }
  
  public static void i(String paramString1, int paramInt, String paramString2)
  {
    QLog.i(paramString1, qlogLevelOf(paramInt), LG_HEAD + paramString2);
  }
  
  public static boolean isDevelopLevel()
  {
    return QLog.isDevelopLevel();
  }
  
  private static int qlogLevelOf(int paramInt)
  {
    int j = 2;
    int i;
    if (USR == paramInt) {
      i = 1;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (CLR == paramInt);
      i = j;
    } while (DEV != paramInt);
    return 4;
  }
  
  public static void w(String paramString1, int paramInt, String paramString2)
  {
    QLog.w(paramString1, qlogLevelOf(paramInt), LG_HEAD + paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUtil.Log
 * JD-Core Version:    0.7.0.1
 */