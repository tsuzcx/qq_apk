package com.tencent.tmassistantbase.util.b;

public class b
{
  static boolean a = true;
  
  public static void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, false);
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a) {
      a.a().a(paramString1).b(paramString2).a(paramThrowable);
    }
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (a)
    {
      if (paramBoolean) {
        a.a().a(paramString1).b(paramString2).d().b();
      }
    }
    else {
      return;
    }
    a.a().a(paramString1).b(paramString2).b();
  }
  
  public static void b(String paramString1, String paramString2)
  {
    b(paramString1, paramString2, false);
  }
  
  public static void b(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (a)
    {
      if (paramBoolean) {
        a.a().a(paramString1).b(paramString2).d().c();
      }
    }
    else {
      return;
    }
    a.a().a(paramString1).b(paramString2).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.b.b
 * JD-Core Version:    0.7.0.1
 */