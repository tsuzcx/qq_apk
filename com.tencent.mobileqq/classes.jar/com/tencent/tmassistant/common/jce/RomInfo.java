package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class RomInfo
  extends JceStruct
  implements Cloneable
{
  public int rootFlag = 0;
  public String sysId = "";
  public String sysVersionCode = "";
  public String sysVersionName = "";
  
  static
  {
    if (!RomInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public RomInfo() {}
  
  public RomInfo(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.sysId = paramString1;
    this.sysVersionName = paramString2;
    this.sysVersionCode = paramString3;
    this.rootFlag = paramInt;
  }
  
  public String className()
  {
    return "jce.RomInfo";
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
    paramStringBuilder.display(this.sysId, "sysId");
    paramStringBuilder.display(this.sysVersionName, "sysVersionName");
    paramStringBuilder.display(this.sysVersionCode, "sysVersionCode");
    paramStringBuilder.display(this.rootFlag, "rootFlag");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.sysId, true);
    paramStringBuilder.displaySimple(this.sysVersionName, true);
    paramStringBuilder.displaySimple(this.sysVersionCode, true);
    paramStringBuilder.displaySimple(this.rootFlag, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (RomInfo)paramObject;
    } while ((!JceUtil.equals(this.sysId, paramObject.sysId)) || (!JceUtil.equals(this.sysVersionName, paramObject.sysVersionName)) || (!JceUtil.equals(this.sysVersionCode, paramObject.sysVersionCode)) || (!JceUtil.equals(this.rootFlag, paramObject.rootFlag)));
    return true;
  }
  
  public String fullClassName()
  {
    return "com.tencent.tmassistant.common.jce.RomInfo";
  }
  
  public int getRootFlag()
  {
    return this.rootFlag;
  }
  
  public String getSysId()
  {
    return this.sysId;
  }
  
  public String getSysVersionCode()
  {
    return this.sysVersionCode;
  }
  
  public String getSysVersionName()
  {
    return this.sysVersionName;
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
    this.sysId = paramJceInputStream.readString(0, false);
    this.sysVersionName = paramJceInputStream.readString(1, false);
    this.sysVersionCode = paramJceInputStream.readString(2, false);
    this.rootFlag = paramJceInputStream.read(this.rootFlag, 3, false);
  }
  
  public void setRootFlag(int paramInt)
  {
    this.rootFlag = paramInt;
  }
  
  public void setSysId(String paramString)
  {
    this.sysId = paramString;
  }
  
  public void setSysVersionCode(String paramString)
  {
    this.sysVersionCode = paramString;
  }
  
  public void setSysVersionName(String paramString)
  {
    this.sysVersionName = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.sysId != null) {
      paramJceOutputStream.write(this.sysId, 0);
    }
    if (this.sysVersionName != null) {
      paramJceOutputStream.write(this.sysVersionName, 1);
    }
    if (this.sysVersionCode != null) {
      paramJceOutputStream.write(this.sysVersionCode, 2);
    }
    paramJceOutputStream.write(this.rootFlag, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmassistant.common.jce.RomInfo
 * JD-Core Version:    0.7.0.1
 */