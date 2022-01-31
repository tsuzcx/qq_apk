package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class TicketWtLogin
  extends JceStruct
  implements Cloneable
{
  static byte[] a;
  public byte[] A2 = null;
  public long uin = 0L;
  
  static
  {
    if (!TicketWtLogin.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      a = (byte[])new byte[1];
      ((byte[])a)[0] = 0;
      return;
    }
  }
  
  public TicketWtLogin() {}
  
  public TicketWtLogin(byte[] paramArrayOfByte, long paramLong)
  {
    this.A2 = paramArrayOfByte;
    this.uin = paramLong;
  }
  
  public String className()
  {
    return "jce.TicketWtLogin";
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
      while (b) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.A2, "A2");
    paramStringBuilder.display(this.uin, "uin");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.A2, true);
    paramStringBuilder.displaySimple(this.uin, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (TicketWtLogin)paramObject;
    } while ((!JceUtil.equals(this.A2, paramObject.A2)) || (!JceUtil.equals(this.uin, paramObject.uin)));
    return true;
  }
  
  public String fullClassName()
  {
    return "com.tencent.tmassistant.common.jce.TicketWtLogin";
  }
  
  public byte[] getA2()
  {
    return this.A2;
  }
  
  public long getUin()
  {
    return this.uin;
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
    this.A2 = ((byte[])paramJceInputStream.read(a, 0, false));
    this.uin = paramJceInputStream.read(this.uin, 1, false);
  }
  
  public void setA2(byte[] paramArrayOfByte)
  {
    this.A2 = paramArrayOfByte;
  }
  
  public void setUin(long paramLong)
  {
    this.uin = paramLong;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.A2 != null) {
      paramJceOutputStream.write(this.A2, 0);
    }
    paramJceOutputStream.write(this.uin, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmassistant.common.jce.TicketWtLogin
 * JD-Core Version:    0.7.0.1
 */