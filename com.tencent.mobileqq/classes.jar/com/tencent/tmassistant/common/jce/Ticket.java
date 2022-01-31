package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class Ticket
  extends JceStruct
  implements Cloneable
{
  static byte[] a;
  public byte type = 0;
  public byte[] value = null;
  
  static
  {
    if (!Ticket.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      a = (byte[])new byte[1];
      ((byte[])a)[0] = 0;
      return;
    }
  }
  
  public Ticket() {}
  
  public Ticket(byte paramByte, byte[] paramArrayOfByte)
  {
    this.type = paramByte;
    this.value = paramArrayOfByte;
  }
  
  public String className()
  {
    return "jce.Ticket";
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
    paramStringBuilder.display(this.type, "type");
    paramStringBuilder.display(this.value, "value");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.type, true);
    paramStringBuilder.displaySimple(this.value, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (Ticket)paramObject;
    } while ((!JceUtil.equals(this.type, paramObject.type)) || (!JceUtil.equals(this.value, paramObject.value)));
    return true;
  }
  
  public String fullClassName()
  {
    return "com.tencent.tmassistant.common.jce.Ticket";
  }
  
  public byte getType()
  {
    return this.type;
  }
  
  public byte[] getValue()
  {
    return this.value;
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
    this.type = paramJceInputStream.read(this.type, 0, true);
    this.value = ((byte[])paramJceInputStream.read(a, 1, true));
  }
  
  public void setType(byte paramByte)
  {
    this.type = paramByte;
  }
  
  public void setValue(byte[] paramArrayOfByte)
  {
    this.value = paramArrayOfByte;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    paramJceOutputStream.write(this.value, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmassistant.common.jce.Ticket
 * JD-Core Version:    0.7.0.1
 */