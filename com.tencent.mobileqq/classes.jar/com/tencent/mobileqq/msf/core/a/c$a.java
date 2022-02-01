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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(paramString3);
    localObject = ((StringBuilder)localObject).toString();
    if (d.containsKey(localObject)) {
      return (a)d.get(localObject);
    }
    paramString1 = new a(paramString1, paramString2, paramString3);
    d.put(localObject, paramString1);
    return paramString1;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sso");
    localStringBuilder.append(toString());
    localStringBuilder.append("_");
    return localStringBuilder.toString();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof a)) {
      return false;
    }
    paramObject = (a)paramObject;
    String str = this.a;
    if (str != null)
    {
      if (!str.equals(paramObject.a)) {
        return false;
      }
    }
    else if (paramObject.a != null) {
      return false;
    }
    str = this.b;
    if (str != null)
    {
      if (!str.equals(paramObject.b)) {
        return false;
      }
    }
    else if (paramObject.b != null) {
      return false;
    }
    str = this.c;
    if (str != null)
    {
      if (!str.equals(paramObject.c)) {
        return false;
      }
    }
    else if (paramObject.c != null) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    String str = this.a;
    int k = 0;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    str = this.b;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.c;
    if (str != null) {
      k = str.hashCode();
    }
    return ((527 + i) * 31 + j) * 31 + k;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append(this.b);
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.a.c.a
 * JD-Core Version:    0.7.0.1
 */