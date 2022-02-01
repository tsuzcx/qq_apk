package com.tencent.securemodule;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class v
  extends JceStruct
  implements Cloneable
{
  static n s;
  public String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public int h = 0;
  public int i = 0;
  public n j = null;
  public String k = "";
  public String l = "";
  public int m = 0;
  public int n = 0;
  public int o = 0;
  public int p = 0;
  public String q = "";
  public short r = 0;
  
  public v()
  {
    a(this.a);
    b(this.b);
    c(this.c);
    d(this.d);
    e(this.e);
    f(this.f);
    g(this.g);
    a(this.h);
    b(this.i);
    a(this.j);
    h(this.k);
    i(this.l);
    c(this.m);
    d(this.n);
    e(this.o);
    f(this.p);
    j(this.q);
    a(this.r);
  }
  
  public void a(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void a(n paramn)
  {
    this.j = paramn;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(short paramShort)
  {
    this.r = paramShort;
  }
  
  public void b(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
  
  public void c(int paramInt)
  {
    this.m = paramInt;
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
    if (t) {
      return null;
    }
    throw new AssertionError();
  }
  
  public void d(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void d(String paramString)
  {
    this.d = paramString;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public void e(int paramInt)
  {
    this.o = paramInt;
  }
  
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
    paramObject = (v)paramObject;
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
                      if (JceUtil.equals(this.j, paramObject.j))
                      {
                        bool1 = bool2;
                        if (JceUtil.equals(this.k, paramObject.k))
                        {
                          bool1 = bool2;
                          if (JceUtil.equals(this.l, paramObject.l))
                          {
                            bool1 = bool2;
                            if (JceUtil.equals(this.m, paramObject.m))
                            {
                              bool1 = bool2;
                              if (JceUtil.equals(this.n, paramObject.n))
                              {
                                bool1 = bool2;
                                if (JceUtil.equals(this.o, paramObject.o))
                                {
                                  bool1 = bool2;
                                  if (JceUtil.equals(this.p, paramObject.p))
                                  {
                                    bool1 = bool2;
                                    if (JceUtil.equals(this.q, paramObject.q))
                                    {
                                      bool1 = bool2;
                                      if (JceUtil.equals(this.r, paramObject.r)) {
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
  
  public void f(int paramInt)
  {
    this.p = paramInt;
  }
  
  public void f(String paramString)
  {
    this.f = paramString;
  }
  
  public void g(String paramString)
  {
    this.g = paramString;
  }
  
  public void h(String paramString)
  {
    this.k = paramString;
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
    this.l = paramString;
  }
  
  public void j(String paramString)
  {
    this.q = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    a(paramJceInputStream.readString(0, true));
    b(paramJceInputStream.readString(1, false));
    c(paramJceInputStream.readString(2, false));
    d(paramJceInputStream.readString(3, false));
    e(paramJceInputStream.readString(4, false));
    f(paramJceInputStream.readString(5, false));
    g(paramJceInputStream.readString(6, false));
    a(paramJceInputStream.read(this.h, 7, false));
    b(paramJceInputStream.read(this.i, 8, false));
    if (s == null) {
      s = new n();
    }
    a((n)paramJceInputStream.read(s, 9, false));
    h(paramJceInputStream.readString(10, false));
    i(paramJceInputStream.readString(11, false));
    c(paramJceInputStream.read(this.m, 12, false));
    d(paramJceInputStream.read(this.n, 13, false));
    e(paramJceInputStream.read(this.o, 14, false));
    f(paramJceInputStream.read(this.p, 15, false));
    j(paramJceInputStream.readString(16, false));
    a(paramJceInputStream.read(this.r, 17, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    Object localObject = this.b;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.c;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.d;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.e;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.f;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    localObject = this.g;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    paramJceOutputStream.write(this.h, 7);
    paramJceOutputStream.write(this.i, 8);
    localObject = this.j;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 9);
    }
    localObject = this.k;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 10);
    }
    localObject = this.l;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 11);
    }
    paramJceOutputStream.write(this.m, 12);
    paramJceOutputStream.write(this.n, 13);
    paramJceOutputStream.write(this.o, 14);
    paramJceOutputStream.write(this.p, 15);
    localObject = this.q;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 16);
    }
    paramJceOutputStream.write(this.r, 17);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.securemodule.v
 * JD-Core Version:    0.7.0.1
 */