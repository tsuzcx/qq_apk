package com.tencent.securemodule;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class e
  extends JceStruct
  implements Cloneable
{
  static a e;
  static t f;
  static u g;
  static ArrayList<c> h;
  public a a = null;
  public t b = null;
  public u c = null;
  public ArrayList<c> d = null;
  
  static
  {
    if (!e.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      i = bool;
      return;
    }
  }
  
  public e()
  {
    a(this.a);
    a(this.b);
    a(this.c);
    a(this.d);
  }
  
  public t a()
  {
    return this.b;
  }
  
  public void a(a parama)
  {
    this.a = parama;
  }
  
  public void a(t paramt)
  {
    this.b = paramt;
  }
  
  public void a(u paramu)
  {
    this.c = paramu;
  }
  
  public void a(ArrayList<c> paramArrayList)
  {
    this.d = paramArrayList;
  }
  
  public u b()
  {
    return this.c;
  }
  
  public ArrayList<c> c()
  {
    return this.d;
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
      while (i) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (e)paramObject;
    } while ((!JceUtil.equals(this.a, paramObject.a)) || (!JceUtil.equals(this.b, paramObject.b)) || (!JceUtil.equals(this.c, paramObject.c)) || (!JceUtil.equals(this.d, paramObject.d)));
    return true;
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
    if (e == null) {
      e = new a();
    }
    a((a)paramJceInputStream.read(e, 0, true));
    if (f == null) {
      f = new t();
    }
    a((t)paramJceInputStream.read(f, 1, true));
    if (g == null) {
      g = new u();
    }
    a((u)paramJceInputStream.read(g, 2, false));
    if (h == null)
    {
      h = new ArrayList();
      c localc = new c();
      h.add(localc);
    }
    a((ArrayList)paramJceInputStream.read(h, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    if (this.c != null) {
      paramJceOutputStream.write(this.c, 2);
    }
    if (this.d != null) {
      paramJceOutputStream.write(this.d, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.securemodule.e
 * JD-Core Version:    0.7.0.1
 */