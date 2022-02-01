package com.tencent.securemodule;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class b
  extends JceStruct
  implements Cloneable
{
  public int a = 0;
  public int b = 0;
  public String c = "";
  public String d = "";
  
  public b()
  {
    a(this.a);
    b(this.b);
    a(this.c);
    b(this.d);
  }
  
  public b(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    a(paramInt1);
    b(paramInt2);
    a(paramString1);
    b(paramString2);
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void b(String paramString)
  {
    this.d = paramString;
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
    paramObject = (b)paramObject;
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
    a(paramJceInputStream.read(this.a, 0, true));
    b(paramJceInputStream.read(this.b, 1, true));
    a(paramJceInputStream.readString(2, false));
    b(paramJceInputStream.readString(3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    String str = this.c;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.d;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.securemodule.b
 * JD-Core Version:    0.7.0.1
 */