package com.tencent.securemodule;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class u
  extends JceStruct
  implements Cloneable
{
  public String a = "";
  public String b = "";
  public int c = 0;
  public int d = 0;
  
  public u()
  {
    a(this.a);
    b(this.b);
    a(this.c);
    b(this.d);
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
  
  public int c()
  {
    return this.c;
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
    if (e) {
      return null;
    }
    throw new AssertionError();
  }
  
  public int d()
  {
    return this.d;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (u)paramObject;
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
          if (JceUtil.equals(this.d, paramObject.d)) {
            bool1 = true;
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
    b(paramJceInputStream.readString(1, true));
    a(paramJceInputStream.read(this.c, 2, true));
    b(paramJceInputStream.read(this.d, 3, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    paramJceOutputStream.write(this.c, 2);
    paramJceOutputStream.write(this.d, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.securemodule.u
 * JD-Core Version:    0.7.0.1
 */