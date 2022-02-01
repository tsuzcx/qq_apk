package com.tencent.securemodule;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class o
  extends JceStruct
  implements Cloneable
{
  static ArrayList<Integer> g;
  static m h;
  public int a = 0;
  public int b = 0;
  public String c = "";
  public ArrayList<Integer> d = null;
  public String e = "";
  public m f = null;
  
  static
  {
    if (!o.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      i = bool;
      return;
    }
  }
  
  public o()
  {
    a(this.a);
    b(this.b);
    a(this.c);
    a(this.d);
    b(this.e);
    a(this.f);
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(m paramm)
  {
    this.f = paramm;
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public void a(ArrayList<Integer> paramArrayList)
  {
    this.d = paramArrayList;
  }
  
  public void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void b(String paramString)
  {
    this.e = paramString;
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
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.a, "id");
    paramStringBuilder.display(this.b, "time");
    paramStringBuilder.display(this.c, "desc");
    paramStringBuilder.display(this.d, "ivalues");
    paramStringBuilder.display(this.e, "paramvalues");
    paramStringBuilder.display(this.f, "pluginInfo");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (o)paramObject;
    } while ((!JceUtil.equals(this.a, paramObject.a)) || (!JceUtil.equals(this.b, paramObject.b)) || (!JceUtil.equals(this.c, paramObject.c)) || (!JceUtil.equals(this.d, paramObject.d)) || (!JceUtil.equals(this.e, paramObject.e)) || (!JceUtil.equals(this.f, paramObject.f)));
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
    a(paramJceInputStream.read(this.a, 0, true));
    b(paramJceInputStream.read(this.b, 1, true));
    a(paramJceInputStream.readString(2, true));
    if (g == null)
    {
      g = new ArrayList();
      g.add(Integer.valueOf(0));
    }
    a((ArrayList)paramJceInputStream.read(g, 3, false));
    b(paramJceInputStream.readString(4, false));
    if (h == null) {
      h = new m();
    }
    a((m)paramJceInputStream.read(h, 5, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    paramJceOutputStream.write(this.c, 2);
    if (this.d != null) {
      paramJceOutputStream.write(this.d, 3);
    }
    if (this.e != null) {
      paramJceOutputStream.write(this.e, 4);
    }
    if (this.f != null) {
      paramJceOutputStream.write(this.f, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.securemodule.o
 * JD-Core Version:    0.7.0.1
 */