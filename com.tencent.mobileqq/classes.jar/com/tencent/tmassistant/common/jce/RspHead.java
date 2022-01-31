package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class RspHead
  extends JceStruct
  implements Cloneable
{
  public int cmdId = 0;
  public byte encryptWithPack = 0;
  public String phoneGuid = "";
  public int requestId = 0;
  public int ret = 0;
  
  static
  {
    if (!RspHead.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public RspHead() {}
  
  public RspHead(int paramInt1, int paramInt2, int paramInt3, byte paramByte, String paramString)
  {
    this.requestId = paramInt1;
    this.cmdId = paramInt2;
    this.ret = paramInt3;
    this.encryptWithPack = paramByte;
    this.phoneGuid = paramString;
  }
  
  public String className()
  {
    return "jce.RspHead";
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
      while (a) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.requestId, "requestId");
    paramStringBuilder.display(this.cmdId, "cmdId");
    paramStringBuilder.display(this.ret, "ret");
    paramStringBuilder.display(this.encryptWithPack, "encryptWithPack");
    paramStringBuilder.display(this.phoneGuid, "phoneGuid");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.requestId, true);
    paramStringBuilder.displaySimple(this.cmdId, true);
    paramStringBuilder.displaySimple(this.ret, true);
    paramStringBuilder.displaySimple(this.encryptWithPack, true);
    paramStringBuilder.displaySimple(this.phoneGuid, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (RspHead)paramObject;
    } while ((!JceUtil.equals(this.requestId, paramObject.requestId)) || (!JceUtil.equals(this.cmdId, paramObject.cmdId)) || (!JceUtil.equals(this.ret, paramObject.ret)) || (!JceUtil.equals(this.encryptWithPack, paramObject.encryptWithPack)) || (!JceUtil.equals(this.phoneGuid, paramObject.phoneGuid)));
    return true;
  }
  
  public String fullClassName()
  {
    return "com.tencent.tmassistant.common.jce.RspHead";
  }
  
  public int getCmdId()
  {
    return this.cmdId;
  }
  
  public byte getEncryptWithPack()
  {
    return this.encryptWithPack;
  }
  
  public String getPhoneGuid()
  {
    return this.phoneGuid;
  }
  
  public int getRequestId()
  {
    return this.requestId;
  }
  
  public int getRet()
  {
    return this.ret;
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
    this.requestId = paramJceInputStream.read(this.requestId, 0, true);
    this.cmdId = paramJceInputStream.read(this.cmdId, 1, true);
    this.ret = paramJceInputStream.read(this.ret, 2, true);
    this.encryptWithPack = paramJceInputStream.read(this.encryptWithPack, 3, false);
    this.phoneGuid = paramJceInputStream.readString(4, false);
  }
  
  public void setCmdId(int paramInt)
  {
    this.cmdId = paramInt;
  }
  
  public void setEncryptWithPack(byte paramByte)
  {
    this.encryptWithPack = paramByte;
  }
  
  public void setPhoneGuid(String paramString)
  {
    this.phoneGuid = paramString;
  }
  
  public void setRequestId(int paramInt)
  {
    this.requestId = paramInt;
  }
  
  public void setRet(int paramInt)
  {
    this.ret = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.requestId, 0);
    paramJceOutputStream.write(this.cmdId, 1);
    paramJceOutputStream.write(this.ret, 2);
    paramJceOutputStream.write(this.encryptWithPack, 3);
    if (this.phoneGuid != null) {
      paramJceOutputStream.write(this.phoneGuid, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmassistant.common.jce.RspHead
 * JD-Core Version:    0.7.0.1
 */