package com.tencent.securemodule;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class c
  extends JceStruct
  implements Cloneable
{
  static byte[] d;
  public int a = 0;
  public byte[] b = null;
  public int c = 0;
  
  public c()
  {
    a(this.a);
    a(this.b);
    b(this.c);
  }
  
  public int a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.b = paramArrayOfByte;
  }
  
  public void b(int paramInt)
  {
    this.c = paramInt;
  }
  
  public byte[] b()
  {
    return this.b;
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
  
  public void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (c)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.a, paramObject.a))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.b, paramObject.b))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.c, paramObject.c)) {
          bool1 = true;
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
    a(paramJceInputStream.read(this.a, 0, true));
    if (d == null)
    {
      d = (byte[])new byte[1];
      ((byte[])d)[0] = 0;
    }
    a((byte[])paramJceInputStream.read(d, 1, true));
    b(paramJceInputStream.read(this.c, 2, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    paramJceOutputStream.write(this.c, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.securemodule.c
 * JD-Core Version:    0.7.0.1
 */