package com.tencent.qapmsdk.dns.c;

import android.support.annotation.NonNull;
import java.util.List;

public abstract class a
{
  public static final a a = new a.a(null);
  public static final a b = new a.c(null);
  public static final a c = new a.b(null);
  private static a d = b;
  
  @NonNull
  public static a a()
  {
    return d;
  }
  
  public abstract List<String> a(String paramString, List<String> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.c.a
 * JD-Core Version:    0.7.0.1
 */