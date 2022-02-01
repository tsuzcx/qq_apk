package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqHead
  extends JceStruct
{
  static Net cache_net;
  static RomInfo cache_romInfo;
  static SdkInfo cache_sdkInfo;
  static Terminal cache_terminal = new Terminal();
  static TerminalExtra cache_terminalExtra = new TerminalExtra();
  static Ticket cache_ticket;
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
  public TerminalExtra terminalExtra = null;
  public Ticket ticket = null;
  public int yybVersion = 0;
  
  static
  {
    cache_net = new Net();
    cache_sdkInfo = new SdkInfo();
    cache_romInfo = new RomInfo();
    cache_ticket = new Ticket();
  }
  
  public ReqHead() {}
  
  public ReqHead(int paramInt1, int paramInt2, String paramString1, String paramString2, byte paramByte, Terminal paramTerminal, int paramInt3, int paramInt4, Net paramNet, String paramString3, int paramInt5, SdkInfo paramSdkInfo, RomInfo paramRomInfo, Ticket paramTicket, TerminalExtra paramTerminalExtra, int paramInt6)
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
    this.terminalExtra = paramTerminalExtra;
    this.yybVersion = paramInt6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.requestId = paramJceInputStream.read(this.requestId, 0, true);
    this.cmdId = paramJceInputStream.read(this.cmdId, 1, true);
    this.phoneGuid = paramJceInputStream.readString(2, true);
    this.qua = paramJceInputStream.readString(3, true);
    this.encryptWithPack = paramJceInputStream.read(this.encryptWithPack, 4, false);
    this.terminal = ((Terminal)paramJceInputStream.read(cache_terminal, 5, false));
    this.assistantAPILevel = paramJceInputStream.read(this.assistantAPILevel, 6, false);
    this.assistantVersionCode = paramJceInputStream.read(this.assistantVersionCode, 7, false);
    this.net = ((Net)paramJceInputStream.read(cache_net, 8, false));
    this.hostPackageName = paramJceInputStream.readString(9, false);
    this.hostVersionCode = paramJceInputStream.read(this.hostVersionCode, 10, false);
    this.sdkInfo = ((SdkInfo)paramJceInputStream.read(cache_sdkInfo, 11, false));
    this.romInfo = ((RomInfo)paramJceInputStream.read(cache_romInfo, 12, false));
    this.ticket = ((Ticket)paramJceInputStream.read(cache_ticket, 13, false));
    this.terminalExtra = ((TerminalExtra)paramJceInputStream.read(cache_terminalExtra, 14, false));
    this.yybVersion = paramJceInputStream.read(this.yybVersion, 15, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.requestId, 0);
    paramJceOutputStream.write(this.cmdId, 1);
    paramJceOutputStream.write(this.phoneGuid, 2);
    paramJceOutputStream.write(this.qua, 3);
    paramJceOutputStream.write(this.encryptWithPack, 4);
    Object localObject = this.terminal;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 5);
    }
    paramJceOutputStream.write(this.assistantAPILevel, 6);
    paramJceOutputStream.write(this.assistantVersionCode, 7);
    localObject = this.net;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 8);
    }
    localObject = this.hostPackageName;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 9);
    }
    paramJceOutputStream.write(this.hostVersionCode, 10);
    localObject = this.sdkInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 11);
    }
    localObject = this.romInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 12);
    }
    localObject = this.ticket;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 13);
    }
    localObject = this.terminalExtra;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 14);
    }
    paramJceOutputStream.write(this.yybVersion, 15);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistant.common.jce.ReqHead
 * JD-Core Version:    0.7.0.1
 */