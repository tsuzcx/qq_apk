import com.tencent.qphone.base.util.QLog;

public class lcg
{
  @Deprecated
  public static void a(String paramString1, String paramString2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(paramString1, 4, paramString2);
    }
  }
  
  @Deprecated
  public static void b(String paramString1, String paramString2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.e(paramString1, 4, paramString2);
    }
  }
  
  @Deprecated
  public static void c(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(paramString1, 2, paramString2);
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    QLog.i(paramString1, 1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    QLog.e(paramString1, 1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lcg
 * JD-Core Version:    0.7.0.1
 */