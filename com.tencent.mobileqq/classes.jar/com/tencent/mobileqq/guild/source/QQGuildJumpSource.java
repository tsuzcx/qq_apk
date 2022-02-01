package com.tencent.mobileqq.guild.source;

import java.util.HashSet;

public class QQGuildJumpSource
{
  public static boolean a = false;
  public static final HashSet<Integer> b = new QQGuildJumpSource.1();
  private static String c = "undefined";
  private static String d = "undefined";
  private static int e = -2147483648;
  
  public static String a()
  {
    return c;
  }
  
  public static void a(int paramInt)
  {
    e = paramInt;
  }
  
  public static void a(String paramString)
  {
    c = paramString;
  }
  
  public static void a(boolean paramBoolean)
  {
    a = paramBoolean;
  }
  
  public static String b()
  {
    return d;
  }
  
  public static void b(String paramString)
  {
    d = paramString;
  }
  
  public static int c()
  {
    return e;
  }
  
  public static boolean d()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.source.QQGuildJumpSource
 * JD-Core Version:    0.7.0.1
 */