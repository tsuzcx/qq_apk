package com.tencent.mobileqq.util;

import android.os.Bundle;

public class FetchInfoReq
{
  public int a;
  public String b;
  public String c;
  public Object d;
  public Bundle e;
  public long f;
  
  public FetchInfoReq() {}
  
  public FetchInfoReq(int paramInt, String paramString1, String paramString2, Object paramObject, Bundle paramBundle)
  {
    this.a = paramInt;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramObject;
    this.e = paramBundle;
  }
  
  public boolean a()
  {
    int i = this.a;
    if (i >= 1)
    {
      if (i > 4) {
        return false;
      }
      Object localObject = this.b;
      if (localObject != null)
      {
        if ("".equals(((String)localObject).trim())) {
          return false;
        }
        if (this.a == 3)
        {
          localObject = this.c;
          if ((localObject == null) || ("".equals(localObject)))
          {
            localObject = this.d;
            if ((localObject == null) || ("".equals(localObject))) {
              return false;
            }
          }
        }
        return true;
      }
    }
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = paramObject instanceof FetchInfoReq;
    boolean bool1 = true;
    if (bool2)
    {
      paramObject = (FetchInfoReq)paramObject;
      if ((paramObject.a == this.a) && (Utils.a(this.b, paramObject.b)))
      {
        if (3 != this.a) {
          return bool1;
        }
        if ((Utils.a(this.c, paramObject.c)) && (Utils.a(this.d, paramObject.d)) && (Utils.a(this.e, paramObject.e))) {
          return true;
        }
      }
    }
    bool1 = false;
    return bool1;
  }
  
  public int hashCode()
  {
    int n = this.a;
    Object localObject = this.b;
    int m = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((String)localObject).hashCode();
    }
    localObject = this.c;
    int j;
    if (localObject == null) {
      j = 0;
    } else {
      j = ((String)localObject).hashCode();
    }
    localObject = this.d;
    int k;
    if (localObject == null) {
      k = 0;
    } else {
      k = localObject.hashCode();
    }
    localObject = this.e;
    if (localObject != null) {
      m = localObject.hashCode();
    }
    return n + i + j + k + m;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[iType = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", strKey = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", strSubKey = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", obj = ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", extraUpdateTargetParams = ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.FetchInfoReq
 * JD-Core Version:    0.7.0.1
 */