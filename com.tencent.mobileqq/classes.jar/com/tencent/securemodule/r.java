package com.tencent.securemodule;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class r
  extends JceStruct
  implements Cloneable
{
  static n j;
  static k k;
  public String a = "";
  public int b = 0;
  public n c = null;
  public int d = 0;
  public int e = 0;
  public String f = "";
  public String g = "";
  public k h = null;
  public String i = "";
  
  public r()
  {
    a(this.a);
    a(this.b);
    a(this.c);
    b(this.d);
    c(this.e);
    b(this.f);
    c(this.g);
    a(this.h);
    d(this.i);
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(k paramk)
  {
    this.h = paramk;
  }
  
  public void a(n paramn)
  {
    this.c = paramn;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void b(String paramString)
  {
    this.f = paramString;
  }
  
  public void c(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void c(String paramString)
  {
    this.g = paramString;
  }
  
  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label7:
      break label7;
    }
    if (l) {
      return null;
    }
    throw new AssertionError();
  }
  
  public void d(String paramString)
  {
    this.i = paramString;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (r)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.a, paramObject.a))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.b, paramObject.b))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.c, paramObject.c))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.d, paramObject.d))
          {
            bool1 = bool2;
            if (JceUtil.equals(this.e, paramObject.e))
            {
              bool1 = bool2;
              if (JceUtil.equals(this.f, paramObject.f))
              {
                bool1 = bool2;
                if (JceUtil.equals(this.g, paramObject.g))
                {
                  bool1 = bool2;
                  if (JceUtil.equals(this.h, paramObject.h))
                  {
                    bool1 = bool2;
                    if (JceUtil.equals(this.i, paramObject.i)) {
                      bool1 = true;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    a(paramJceInputStream.readString(0, true));
    a(paramJceInputStream.read(this.b, 1, false));
    if (j == null) {
      j = new n();
    }
    a((n)paramJceInputStream.read(j, 2, false));
    b(paramJceInputStream.read(this.d, 3, false));
    c(paramJceInputStream.read(this.e, 4, false));
    b(paramJceInputStream.readString(5, false));
    c(paramJceInputStream.readString(6, false));
    if (k == null) {
      k = new k();
    }
    a((k)paramJceInputStream.read(k, 7, false));
    d(paramJceInputStream.readString(8, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    Object localObject = this.c;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 2);
    }
    paramJceOutputStream.write(this.d, 3);
    paramJceOutputStream.write(this.e, 4);
    localObject = this.f;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    localObject = this.g;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    localObject = this.h;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 7);
    }
    localObject = this.i;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.securemodule.r
 * JD-Core Version:    0.7.0.1
 */