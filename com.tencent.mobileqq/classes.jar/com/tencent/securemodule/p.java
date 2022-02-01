package com.tencent.securemodule;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class p
  extends JceStruct
  implements Cloneable
{
  public String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public int h = 0;
  public String i = "";
  public String j = "";
  public String k = "";
  public String l = "";
  public int m = 0;
  public String n = "";
  public int o = 0;
  public String p = "";
  public short q = 0;
  public String r = "";
  public String s = "";
  public String t = "";
  public String u = "";
  
  public p()
  {
    a(this.a);
    b(this.b);
    c(this.c);
    d(this.d);
    e(this.e);
    f(this.f);
    g(this.g);
    a(this.h);
    h(this.i);
    i(this.j);
    j(this.k);
    k(this.l);
    b(this.m);
    l(this.n);
    c(this.o);
    m(this.p);
    a(this.q);
    n(this.r);
    o(this.s);
    p(this.t);
    q(this.u);
  }
  
  public void a(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(short paramShort)
  {
    this.q = paramShort;
  }
  
  public void b(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
  
  public void c(int paramInt)
  {
    this.o = paramInt;
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
    if (v) {
      return null;
    }
    throw new AssertionError();
  }
  
  public void d(String paramString)
  {
    this.d = paramString;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.a, "lc");
    paramStringBuilder.display(this.b, "name");
    paramStringBuilder.display(this.c, "version");
    paramStringBuilder.display(this.d, "imei");
    paramStringBuilder.display(this.e, "imsi");
    paramStringBuilder.display(this.f, "qq");
    paramStringBuilder.display(this.g, "ip");
    paramStringBuilder.display(this.h, "type");
    paramStringBuilder.display(this.i, "osversion");
    paramStringBuilder.display(this.j, "machineuid");
    paramStringBuilder.display(this.k, "machineconf");
    paramStringBuilder.display(this.l, "phone");
    paramStringBuilder.display(this.m, "subplatform");
    paramStringBuilder.display(this.n, "channelid");
    paramStringBuilder.display(this.o, "isbuildin");
    paramStringBuilder.display(this.p, "uuid");
    paramStringBuilder.display(this.q, "lang");
    paramStringBuilder.display(this.r, "guid");
    paramStringBuilder.display(this.s, "sdk");
    paramStringBuilder.display(this.t, "sid");
    paramStringBuilder.display(this.u, "newguid");
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
    paramObject = (p)paramObject;
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
                                      if (JceUtil.equals(this.r, paramObject.r))
                                      {
                                        bool1 = bool2;
                                        if (JceUtil.equals(this.s, paramObject.s))
                                        {
                                          bool1 = bool2;
                                          if (JceUtil.equals(this.t, paramObject.t))
                                          {
                                            bool1 = bool2;
                                            if (JceUtil.equals(this.u, paramObject.u)) {
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
        }
      }
    }
    return bool1;
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
  
  public void j(String paramString)
  {
    this.k = paramString;
  }
  
  public void k(String paramString)
  {
    this.l = paramString;
  }
  
  public void l(String paramString)
  {
    this.n = paramString;
  }
  
  public void m(String paramString)
  {
    this.p = paramString;
  }
  
  public void n(String paramString)
  {
    this.r = paramString;
  }
  
  public void o(String paramString)
  {
    this.s = paramString;
  }
  
  public void p(String paramString)
  {
    this.t = paramString;
  }
  
  public void q(String paramString)
  {
    this.u = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    a(paramJceInputStream.readString(0, true));
    b(paramJceInputStream.readString(1, true));
    c(paramJceInputStream.readString(2, true));
    d(paramJceInputStream.readString(3, true));
    e(paramJceInputStream.readString(4, true));
    f(paramJceInputStream.readString(5, false));
    g(paramJceInputStream.readString(6, false));
    a(paramJceInputStream.read(this.h, 7, false));
    h(paramJceInputStream.readString(8, false));
    i(paramJceInputStream.readString(9, false));
    j(paramJceInputStream.readString(10, false));
    k(paramJceInputStream.readString(11, false));
    b(paramJceInputStream.read(this.m, 12, false));
    l(paramJceInputStream.readString(13, false));
    c(paramJceInputStream.read(this.o, 14, false));
    m(paramJceInputStream.readString(15, false));
    a(paramJceInputStream.read(this.q, 16, false));
    n(paramJceInputStream.readString(17, false));
    o(paramJceInputStream.readString(18, false));
    p(paramJceInputStream.readString(19, false));
    q(paramJceInputStream.readString(20, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    paramJceOutputStream.write(this.c, 2);
    paramJceOutputStream.write(this.d, 3);
    paramJceOutputStream.write(this.e, 4);
    String str = this.f;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
    str = this.g;
    if (str != null) {
      paramJceOutputStream.write(str, 6);
    }
    paramJceOutputStream.write(this.h, 7);
    str = this.i;
    if (str != null) {
      paramJceOutputStream.write(str, 8);
    }
    str = this.j;
    if (str != null) {
      paramJceOutputStream.write(str, 9);
    }
    str = this.k;
    if (str != null) {
      paramJceOutputStream.write(str, 10);
    }
    str = this.l;
    if (str != null) {
      paramJceOutputStream.write(str, 11);
    }
    paramJceOutputStream.write(this.m, 12);
    str = this.n;
    if (str != null) {
      paramJceOutputStream.write(str, 13);
    }
    paramJceOutputStream.write(this.o, 14);
    str = this.p;
    if (str != null) {
      paramJceOutputStream.write(str, 15);
    }
    paramJceOutputStream.write(this.q, 16);
    str = this.r;
    if (str != null) {
      paramJceOutputStream.write(str, 17);
    }
    str = this.s;
    if (str != null) {
      paramJceOutputStream.write(str, 18);
    }
    str = this.t;
    if (str != null) {
      paramJceOutputStream.write(str, 19);
    }
    str = this.u;
    if (str != null) {
      paramJceOutputStream.write(str, 20);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.securemodule.p
 * JD-Core Version:    0.7.0.1
 */