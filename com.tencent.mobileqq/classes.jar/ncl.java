public class ncl
{
  protected static ncq a;
  
  public static void a(String paramString1, String paramString2)
  {
    if (a != null) {
      a.a(paramString1, paramString2);
    }
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a != null) {
      a.a(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void a(ncq paramncq)
  {
    a = paramncq;
  }
  
  public static boolean a()
  {
    return a != null;
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if (a != null) {
      a.b(paramString1, paramString2);
    }
  }
  
  public static boolean b()
  {
    return (a != null) && (a.a());
  }
  
  public static void c(String paramString1, String paramString2)
  {
    if (a != null) {
      a.c(paramString1, paramString2);
    }
  }
  
  public static boolean c()
  {
    return (a != null) && (a.b());
  }
  
  @Deprecated
  public static void d(String paramString1, String paramString2)
  {
    if (a != null) {
      a.d(paramString1, paramString2);
    }
  }
  
  @Deprecated
  public static void e(String paramString1, String paramString2)
  {
    if (a != null) {
      a.e(paramString1, paramString2);
    }
  }
  
  @Deprecated
  public static void f(String paramString1, String paramString2)
  {
    if (a != null) {
      a.f(paramString1, paramString2);
    }
  }
  
  public static void g(String paramString1, String paramString2)
  {
    if (a != null) {
      a.g(paramString1, paramString2);
    }
  }
  
  public static void h(String paramString1, String paramString2)
  {
    if (a != null) {
      a.h(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ncl
 * JD-Core Version:    0.7.0.1
 */