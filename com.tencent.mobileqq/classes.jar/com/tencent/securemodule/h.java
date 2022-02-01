package com.tencent.securemodule;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class h
  extends JceStruct
  implements Cloneable
{
  public String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public int f = 0;
  public String g = "";
  public String h = "";
  public String i = "";
  public String j = "";
  
  public h()
  {
    a(this.a);
    b(this.b);
    c(this.c);
    d(this.d);
    e(this.e);
    a(this.f);
    f(this.g);
    g(this.h);
    h(this.i);
    i(this.j);
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
  
  public void c(String paramString)
  {
    this.c = paramString;
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
    if (k) {
      return null;
    }
    throw new AssertionError();
  }
  
  public void d(String paramString)
  {
    this.d = paramString;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public void e(String paramString)
  {
    this.e = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (h)paramObject;
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
                    if (JceUtil.equals(this.i, paramObject.i))
                    {
                      bool1 = bool2;
                      if (JceUtil.equals(this.j, paramObject.j)) {
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
    }
    return bool1;
  }
  
  public void f(String paramString)
  {
    this.g = paramString;
  }
  
  public void g(String paramString)
  {
    this.h = paramString;
  }
  
  public void h(String paramString)
  {
    this.i = paramString;
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
  
  public void i(String paramString)
  {
    this.j = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    a(paramJceInputStream.readString(0, true));
    b(paramJceInputStream.readString(1, false));
    c(paramJceInputStream.readString(2, false));
    d(paramJceInputStream.readString(3, false));
    e(paramJceInputStream.readString(4, false));
    a(paramJceInputStream.read(this.f, 5, false));
    f(paramJceInputStream.readString(6, false));
    g(paramJceInputStream.readString(7, false));
    h(paramJceInputStream.readString(8, false));
    i(paramJceInputStream.readString(9, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    String str = this.b;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.c;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.d;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.e;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    paramJceOutputStream.write(this.f, 5);
    str = this.g;
    if (str != null) {
      paramJceOutputStream.write(str, 6);
    }
    str = this.h;
    if (str != null) {
      paramJceOutputStream.write(str, 7);
    }
    str = this.i;
    if (str != null) {
      paramJceOutputStream.write(str, 8);
    }
    str = this.j;
    if (str != null) {
      paramJceOutputStream.write(str, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.securemodule.h
 * JD-Core Version:    0.7.0.1
 */