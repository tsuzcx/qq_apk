package com.tencent.xweb;

public class m
{
  static m.a a;
  
  public static void a(String paramString, ClassLoader paramClassLoader)
  {
    m.a locala = a;
    if (locala != null)
    {
      locala.a(paramString, paramClassLoader);
      return;
    }
    System.loadLibrary(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.m
 * JD-Core Version:    0.7.0.1
 */