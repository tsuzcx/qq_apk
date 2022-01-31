import com.tencent.qphone.base.util.QLog;

public class sne
{
  private static final String a = "weishi" + "8.2.8".replaceAll("\\.", "");
  
  public static void a(String paramString)
  {
    b(a, 4, paramString);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    QLog.i(paramString1, paramInt, paramString2);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a(a + "-" + paramString1, 4, paramString2);
  }
  
  public static void b(String paramString)
  {
    d(a, 1, paramString);
  }
  
  public static void b(String paramString1, int paramInt, String paramString2)
  {
    QLog.d(paramString1, paramInt, paramString2);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    b(a + "-" + paramString1, 4, paramString2);
  }
  
  public static void c(String paramString1, int paramInt, String paramString2)
  {
    QLog.w(paramString1, paramInt, paramString2);
  }
  
  public static void c(String paramString1, String paramString2)
  {
    c(a + "-" + paramString1, 4, paramString2);
  }
  
  public static void d(String paramString1, int paramInt, String paramString2)
  {
    QLog.e(paramString1, paramInt, paramString2);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    d(a + "-" + paramString1, 1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sne
 * JD-Core Version:    0.7.0.1
 */