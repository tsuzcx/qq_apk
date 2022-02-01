package cooperation.vip.vipcomponent.util;

import cooperation.qzone.util.QZLog;

public class VLog
{
  public static int a = 2;
  public static int b = 1;
  public static int c = 4;
  
  public static void a(String paramString1, String paramString2)
  {
    QZLog.d(paramString1, c, paramString2);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    QZLog.d(paramString1, b, paramString2);
  }
  
  public static void c(String paramString1, String paramString2)
  {
    QZLog.e(paramString1, paramString2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.vipcomponent.util.VLog
 * JD-Core Version:    0.7.0.1
 */