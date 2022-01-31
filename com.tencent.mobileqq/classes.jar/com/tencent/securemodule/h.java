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
  
  static
  {
    if (!h.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      k = bool;
      return;
    }
  }
  
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
    Object localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while (k) {}
      throw new AssertionError();
    }
    return localObject1;
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
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (h)paramObject;
    } while ((!JceUtil.equals(this.a, paramObject.a)) || (!JceUtil.equals(this.b, paramObject.b)) || (!JceUtil.equals(this.c, paramObject.c)) || (!JceUtil.equals(this.d, paramObject.d)) || (!JceUtil.equals(this.e, paramObject.e)) || (!JceUtil.equals(this.f, paramObject.f)) || (!JceUtil.equals(this.g, paramObject.g)) || (!JceUtil.equals(this.h, paramObject.h)) || (!JceUtil.equals(this.i, paramObject.i)) || (!JceUtil.equals(this.j, paramObject.j)));
    return true;
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
    if (this.b != null) {
      paramJceOutputStream.write(this.b, 1);
    }
    if (this.c != null) {
      paramJceOutputStream.write(this.c, 2);
    }
    if (this.d != null) {
      paramJceOutputStream.write(this.d, 3);
    }
    if (this.e != null) {
      paramJceOutputStream.write(this.e, 4);
    }
    paramJceOutputStream.write(this.f, 5);
    if (this.g != null) {
      paramJceOutputStream.write(this.g, 6);
    }
    if (this.h != null) {
      paramJceOutputStream.write(this.h, 7);
    }
    if (this.i != null) {
      paramJceOutputStream.write(this.i, 8);
    }
    if (this.j != null) {
      paramJceOutputStream.write(this.j, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.securemodule.h
 * JD-Core Version:    0.7.0.1
 */