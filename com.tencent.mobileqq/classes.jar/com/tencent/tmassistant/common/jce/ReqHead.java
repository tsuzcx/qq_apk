package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class ReqHead
  extends JceStruct
  implements Cloneable
{
  static Terminal a;
  static Net b;
  static SdkInfo c;
  static RomInfo d;
  static Ticket e;
  public int assistantAPILevel = 0;
  public int assistantVersionCode = 0;
  public int cmdId = 0;
  public byte encryptWithPack = 0;
  public String hostPackageName = "";
  public int hostVersionCode = 0;
  public Net net = null;
  public String phoneGuid = "";
  public String qua = "";
  public int requestId = 0;
  public RomInfo romInfo = null;
  public SdkInfo sdkInfo = null;
  public Terminal terminal = null;
  public Ticket ticket = null;
  
  static
  {
    if (!ReqHead.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      f = bool;
      a = new Terminal();
      b = new Net();
      c = new SdkInfo();
      d = new RomInfo();
      e = new Ticket();
      return;
    }
  }
  
  public ReqHead() {}
  
  public ReqHead(int paramInt1, int paramInt2, String paramString1, String paramString2, byte paramByte, Terminal paramTerminal, int paramInt3, int paramInt4, Net paramNet, String paramString3, int paramInt5, SdkInfo paramSdkInfo, RomInfo paramRomInfo, Ticket paramTicket)
  {
    this.requestId = paramInt1;
    this.cmdId = paramInt2;
    this.phoneGuid = paramString1;
    this.qua = paramString2;
    this.encryptWithPack = paramByte;
    this.terminal = paramTerminal;
    this.assistantAPILevel = paramInt3;
    this.assistantVersionCode = paramInt4;
    this.net = paramNet;
    this.hostPackageName = paramString3;
    this.hostVersionCode = paramInt5;
    this.sdkInfo = paramSdkInfo;
    this.romInfo = paramRomInfo;
    this.ticket = paramTicket;
  }
  
  public String className()
  {
    return "jce.ReqHead";
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
      while (f) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.requestId, "requestId");
    paramStringBuilder.display(this.cmdId, "cmdId");
    paramStringBuilder.display(this.phoneGuid, "phoneGuid");
    paramStringBuilder.display(this.qua, "qua");
    paramStringBuilder.display(this.encryptWithPack, "encryptWithPack");
    paramStringBuilder.display(this.terminal, "terminal");
    paramStringBuilder.display(this.assistantAPILevel, "assistantAPILevel");
    paramStringBuilder.display(this.assistantVersionCode, "assistantVersionCode");
    paramStringBuilder.display(this.net, "net");
    paramStringBuilder.display(this.hostPackageName, "hostPackageName");
    paramStringBuilder.display(this.hostVersionCode, "hostVersionCode");
    paramStringBuilder.display(this.sdkInfo, "sdkInfo");
    paramStringBuilder.display(this.romInfo, "romInfo");
    paramStringBuilder.display(this.ticket, "ticket");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.requestId, true);
    paramStringBuilder.displaySimple(this.cmdId, true);
    paramStringBuilder.displaySimple(this.phoneGuid, true);
    paramStringBuilder.displaySimple(this.qua, true);
    paramStringBuilder.displaySimple(this.encryptWithPack, true);
    paramStringBuilder.displaySimple(this.terminal, true);
    paramStringBuilder.displaySimple(this.assistantAPILevel, true);
    paramStringBuilder.displaySimple(this.assistantVersionCode, true);
    paramStringBuilder.displaySimple(this.net, true);
    paramStringBuilder.displaySimple(this.hostPackageName, true);
    paramStringBuilder.displaySimple(this.hostVersionCode, true);
    paramStringBuilder.displaySimple(this.sdkInfo, true);
    paramStringBuilder.displaySimple(this.romInfo, true);
    paramStringBuilder.displaySimple(this.ticket, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (ReqHead)paramObject;
    } while ((!JceUtil.equals(this.requestId, paramObject.requestId)) || (!JceUtil.equals(this.cmdId, paramObject.cmdId)) || (!JceUtil.equals(this.phoneGuid, paramObject.phoneGuid)) || (!JceUtil.equals(this.qua, paramObject.qua)) || (!JceUtil.equals(this.encryptWithPack, paramObject.encryptWithPack)) || (!JceUtil.equals(this.terminal, paramObject.terminal)) || (!JceUtil.equals(this.assistantAPILevel, paramObject.assistantAPILevel)) || (!JceUtil.equals(this.assistantVersionCode, paramObject.assistantVersionCode)) || (!JceUtil.equals(this.net, paramObject.net)) || (!JceUtil.equals(this.hostPackageName, paramObject.hostPackageName)) || (!JceUtil.equals(this.hostVersionCode, paramObject.hostVersionCode)) || (!JceUtil.equals(this.sdkInfo, paramObject.sdkInfo)) || (!JceUtil.equals(this.romInfo, paramObject.romInfo)) || (!JceUtil.equals(this.ticket, paramObject.ticket)));
    return true;
  }
  
  public String fullClassName()
  {
    return "com.tencent.tmassistant.common.jce.ReqHead";
  }
  
  public int getAssistantAPILevel()
  {
    return this.assistantAPILevel;
  }
  
  public int getAssistantVersionCode()
  {
    return this.assistantVersionCode;
  }
  
  public int getCmdId()
  {
    return this.cmdId;
  }
  
  public byte getEncryptWithPack()
  {
    return this.encryptWithPack;
  }
  
  public String getHostPackageName()
  {
    return this.hostPackageName;
  }
  
  public int getHostVersionCode()
  {
    return this.hostVersionCode;
  }
  
  public Net getNet()
  {
    return this.net;
  }
  
  public String getPhoneGuid()
  {
    return this.phoneGuid;
  }
  
  public String getQua()
  {
    return this.qua;
  }
  
  public int getRequestId()
  {
    return this.requestId;
  }
  
  public RomInfo getRomInfo()
  {
    return this.romInfo;
  }
  
  public SdkInfo getSdkInfo()
  {
    return this.sdkInfo;
  }
  
  public Terminal getTerminal()
  {
    return this.terminal;
  }
  
  public Ticket getTicket()
  {
    return this.ticket;
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
    this.phoneGuid = paramJceInputStream.readString(2, true);
    this.qua = paramJceInputStream.readString(3, true);
    this.encryptWithPack = paramJceInputStream.read(this.encryptWithPack, 4, false);
    this.terminal = ((Terminal)paramJceInputStream.read(a, 5, false));
    this.assistantAPILevel = paramJceInputStream.read(this.assistantAPILevel, 6, false);
    this.assistantVersionCode = paramJceInputStream.read(this.assistantVersionCode, 7, false);
    this.net = ((Net)paramJceInputStream.read(b, 8, false));
    this.hostPackageName = paramJceInputStream.readString(9, false);
    this.hostVersionCode = paramJceInputStream.read(this.hostVersionCode, 10, false);
    this.sdkInfo = ((SdkInfo)paramJceInputStream.read(c, 11, false));
    this.romInfo = ((RomInfo)paramJceInputStream.read(d, 12, false));
    this.ticket = ((Ticket)paramJceInputStream.read(e, 13, false));
  }
  
  public void setAssistantAPILevel(int paramInt)
  {
    this.assistantAPILevel = paramInt;
  }
  
  public void setAssistantVersionCode(int paramInt)
  {
    this.assistantVersionCode = paramInt;
  }
  
  public void setCmdId(int paramInt)
  {
    this.cmdId = paramInt;
  }
  
  public void setEncryptWithPack(byte paramByte)
  {
    this.encryptWithPack = paramByte;
  }
  
  public void setHostPackageName(String paramString)
  {
    this.hostPackageName = paramString;
  }
  
  public void setHostVersionCode(int paramInt)
  {
    this.hostVersionCode = paramInt;
  }
  
  public void setNet(Net paramNet)
  {
    this.net = paramNet;
  }
  
  public void setPhoneGuid(String paramString)
  {
    this.phoneGuid = paramString;
  }
  
  public void setQua(String paramString)
  {
    this.qua = paramString;
  }
  
  public void setRequestId(int paramInt)
  {
    this.requestId = paramInt;
  }
  
  public void setRomInfo(RomInfo paramRomInfo)
  {
    this.romInfo = paramRomInfo;
  }
  
  public void setSdkInfo(SdkInfo paramSdkInfo)
  {
    this.sdkInfo = paramSdkInfo;
  }
  
  public void setTerminal(Terminal paramTerminal)
  {
    this.terminal = paramTerminal;
  }
  
  public void setTicket(Ticket paramTicket)
  {
    this.ticket = paramTicket;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.requestId, 0);
    paramJceOutputStream.write(this.cmdId, 1);
    paramJceOutputStream.write(this.phoneGuid, 2);
    paramJceOutputStream.write(this.qua, 3);
    paramJceOutputStream.write(this.encryptWithPack, 4);
    if (this.terminal != null) {
      paramJceOutputStream.write(this.terminal, 5);
    }
    paramJceOutputStream.write(this.assistantAPILevel, 6);
    paramJceOutputStream.write(this.assistantVersionCode, 7);
    if (this.net != null) {
      paramJceOutputStream.write(this.net, 8);
    }
    if (this.hostPackageName != null) {
      paramJceOutputStream.write(this.hostPackageName, 9);
    }
    paramJceOutputStream.write(this.hostVersionCode, 10);
    if (this.sdkInfo != null) {
      paramJceOutputStream.write(this.sdkInfo, 11);
    }
    if (this.romInfo != null) {
      paramJceOutputStream.write(this.romInfo, 12);
    }
    if (this.ticket != null) {
      paramJceOutputStream.write(this.ticket, 13);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmassistant.common.jce.ReqHead
 * JD-Core Version:    0.7.0.1
 */