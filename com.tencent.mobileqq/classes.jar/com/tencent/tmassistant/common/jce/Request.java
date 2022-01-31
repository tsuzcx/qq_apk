package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class Request
  extends JceStruct
  implements Cloneable
{
  static ReqHead a;
  static byte[] b;
  public byte[] body = null;
  public ReqHead head = null;
  
  static
  {
    if (!Request.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      c = bool;
      a = new ReqHead();
      b = (byte[])new byte[1];
      ((byte[])b)[0] = 0;
      return;
    }
  }
  
  public Request() {}
  
  public Request(ReqHead paramReqHead, byte[] paramArrayOfByte)
  {
    this.head = paramReqHead;
    this.body = paramArrayOfByte;
  }
  
  public String className()
  {
    return "jce.Request";
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
      while (c) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.head, "head");
    paramStringBuilder.display(this.body, "body");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.head, true);
    paramStringBuilder.displaySimple(this.body, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (Request)paramObject;
    } while ((!JceUtil.equals(this.head, paramObject.head)) || (!JceUtil.equals(this.body, paramObject.body)));
    return true;
  }
  
  public String fullClassName()
  {
    return "com.tencent.tmassistant.common.jce.Request";
  }
  
  public byte[] getBody()
  {
    return this.body;
  }
  
  public ReqHead getHead()
  {
    return this.head;
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
    this.head = ((ReqHead)paramJceInputStream.read(a, 0, true));
    this.body = ((byte[])paramJceInputStream.read(b, 1, false));
  }
  
  public void setBody(byte[] paramArrayOfByte)
  {
    this.body = paramArrayOfByte;
  }
  
  public void setHead(ReqHead paramReqHead)
  {
    this.head = paramReqHead;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.head, 0);
    if (this.body != null) {
      paramJceOutputStream.write(this.body, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmassistant.common.jce.Request
 * JD-Core Version:    0.7.0.1
 */