package com.tencent.mobileqq.intervideo.now;

public class NowPerfUtil
{
  private static long a;
  private static long b;
  private static long c;
  private static long d;
  private static long e;
  private static long f;
  private static long g;
  private static long h;
  
  public static void a()
  {
    a = System.currentTimeMillis();
  }
  
  public static void b()
  {
    b = System.currentTimeMillis();
  }
  
  public static void c()
  {
    c = System.currentTimeMillis();
    f = c - b;
  }
  
  public static void d()
  {
    d = System.currentTimeMillis();
    g = d - c;
  }
  
  public static void e()
  {
    e = System.currentTimeMillis();
    h = e - d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.NowPerfUtil
 * JD-Core Version:    0.7.0.1
 */