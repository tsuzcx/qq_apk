package com.tencent.mobileqq.msf.core.a;

import java.util.concurrent.ConcurrentHashMap;

public class c$a
{
  private static ConcurrentHashMap d = new ConcurrentHashMap();
  private String a;
  private String b;
  private String c;
  
  private c$a(String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }
  
  public static a a(String paramString1, String paramString2, String paramString3)
  {
    String str = paramString1 + paramString2 + paramString3;
    if (d.containsKey(str)) {
      return (a)d.get(str);
    }
    paramString1 = new a(paramString1, paramString2, paramString3);
    d.put(str, paramString1);
    return paramString1;
  }
  
  public String a()
  {
    return "sso" + toString() + "_";
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof a)) {
        return false;
      }
      paramObject = (a)paramObject;
      if (this.a != null)
      {
        if (this.a.equals(paramObject.a)) {}
      }
      else {
        while (paramObject.a != null) {
          return false;
        }
      }
      if (this.b != null)
      {
        if (this.b.equals(paramObject.b)) {}
      }
      else {
        while (paramObject.b != null) {
          return false;
        }
      }
      if (this.c == null) {
        break;
      }
    } while (this.c.equals(paramObject.c));
    for (;;)
    {
      return false;
      if (paramObject.c == null) {
        break;
      }
    }
  }
  
  public int hashCode()
  {
    int k = 0;
    int i;
    if (this.a != null)
    {
      i = this.a.hashCode();
      if (this.b == null) {
        break label68;
      }
    }
    label68:
    for (int j = this.b.hashCode();; j = 0)
    {
      if (this.c != null) {
        k = this.c.hashCode();
      }
      return (j + (i + 527) * 31) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public String toString()
  {
    return this.a + this.b + this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.a.c.a
 * JD-Core Version:    0.7.0.1
 */