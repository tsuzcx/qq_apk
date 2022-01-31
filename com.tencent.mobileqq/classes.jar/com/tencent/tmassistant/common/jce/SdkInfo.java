package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class SdkInfo
  extends JceStruct
  implements Cloneable
{
  public String builderNum = "";
  public String channel = "";
  public String name = "";
  public String subChannel = "";
  public int versionCode = 0;
  public String versionName = "";
  
  static
  {
    if (!SdkInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public SdkInfo() {}
  
  public SdkInfo(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5)
  {
    this.name = paramString1;
    this.versionName = paramString2;
    this.versionCode = paramInt;
    this.channel = paramString3;
    this.subChannel = paramString4;
    this.builderNum = paramString5;
  }
  
  public String className()
  {
    return "jce.SdkInfo";
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
    paramStringBuilder.display(this.name, "name");
    paramStringBuilder.display(this.versionName, "versionName");
    paramStringBuilder.display(this.versionCode, "versionCode");
    paramStringBuilder.display(this.channel, "channel");
    paramStringBuilder.display(this.subChannel, "subChannel");
    paramStringBuilder.display(this.builderNum, "builderNum");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.name, true);
    paramStringBuilder.displaySimple(this.versionName, true);
    paramStringBuilder.displaySimple(this.versionCode, true);
    paramStringBuilder.displaySimple(this.channel, true);
    paramStringBuilder.displaySimple(this.subChannel, true);
    paramStringBuilder.displaySimple(this.builderNum, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (SdkInfo)paramObject;
    } while ((!JceUtil.equals(this.name, paramObject.name)) || (!JceUtil.equals(this.versionName, paramObject.versionName)) || (!JceUtil.equals(this.versionCode, paramObject.versionCode)) || (!JceUtil.equals(this.channel, paramObject.channel)) || (!JceUtil.equals(this.subChannel, paramObject.subChannel)) || (!JceUtil.equals(this.builderNum, paramObject.builderNum)));
    return true;
  }
  
  public String fullClassName()
  {
    return "com.tencent.tmassistant.common.jce.SdkInfo";
  }
  
  public String getBuilderNum()
  {
    return this.builderNum;
  }
  
  public String getChannel()
  {
    return this.channel;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getSubChannel()
  {
    return this.subChannel;
  }
  
  public int getVersionCode()
  {
    return this.versionCode;
  }
  
  public String getVersionName()
  {
    return this.versionName;
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
    this.name = paramJceInputStream.readString(0, false);
    this.versionName = paramJceInputStream.readString(1, false);
    this.versionCode = paramJceInputStream.read(this.versionCode, 2, false);
    this.channel = paramJceInputStream.readString(3, false);
    this.subChannel = paramJceInputStream.readString(4, false);
    this.builderNum = paramJceInputStream.readString(5, false);
  }
  
  public void setBuilderNum(String paramString)
  {
    this.builderNum = paramString;
  }
  
  public void setChannel(String paramString)
  {
    this.channel = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setSubChannel(String paramString)
  {
    this.subChannel = paramString;
  }
  
  public void setVersionCode(int paramInt)
  {
    this.versionCode = paramInt;
  }
  
  public void setVersionName(String paramString)
  {
    this.versionName = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.name != null) {
      paramJceOutputStream.write(this.name, 0);
    }
    if (this.versionName != null) {
      paramJceOutputStream.write(this.versionName, 1);
    }
    paramJceOutputStream.write(this.versionCode, 2);
    if (this.channel != null) {
      paramJceOutputStream.write(this.channel, 3);
    }
    if (this.subChannel != null) {
      paramJceOutputStream.write(this.subChannel, 4);
    }
    if (this.builderNum != null) {
      paramJceOutputStream.write(this.builderNum, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmassistant.common.jce.SdkInfo
 * JD-Core Version:    0.7.0.1
 */