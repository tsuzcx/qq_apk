package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

import com.tencent.commonsdk.util.HexUtil;

public class ExcitingTransferUploadBizInfo
{
  public boolean bUseMediaPlatform = false;
  public byte[] bufBusinessExt;
  public byte[] bufSig;
  public byte[] bufUploadKey;
  public byte[] bufUuid;
  public int businessType = 0;
  public int chateType = 4;
  public int clientType = 0;
  public String clientVer;
  public int commandId = 0;
  public int dangerLevel = 0;
  public long groupCode = 0L;
  public long receiverUin = 0L;
  public long senderUin = 0L;
  public int terminalType = 0;
  public String terminalVer;
  public long totalSpace = 0L;
  public ExcitingTransferHostInfo[] vecFtnLanIpV4AndPorts;
  public ExcitingTransferHostInfo[] vecFtnLanIpV6AndPorts;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("commandId:");
    localStringBuilder.append(this.commandId);
    localStringBuilder.append(" businessType:");
    localStringBuilder.append(this.businessType);
    localStringBuilder.append(" chateType:");
    localStringBuilder.append(this.chateType);
    localStringBuilder.append(" senderUin:");
    localStringBuilder.append(this.senderUin);
    localStringBuilder.append(" receiverUin:");
    localStringBuilder.append(this.receiverUin);
    localStringBuilder.append(" groupCode:");
    localStringBuilder.append(this.groupCode);
    localStringBuilder.append(" client_type:");
    localStringBuilder.append(this.clientType);
    localStringBuilder.append(" client_ver:");
    localStringBuilder.append(this.clientVer);
    localStringBuilder.append(" bUseMediaPlatform:");
    localStringBuilder.append(this.bUseMediaPlatform);
    localStringBuilder.append(" bufSig:");
    localStringBuilder.append(HexUtil.bytes2HexStr(this.bufSig));
    localStringBuilder.append(" bufUuid:");
    localStringBuilder.append(HexUtil.bytes2HexStr(this.bufUuid));
    localStringBuilder.append(" bufUploadKey:");
    localStringBuilder.append(HexUtil.bytes2HexStr(this.bufUploadKey));
    localStringBuilder.append(" bufBusinessExt_l:");
    byte[] arrayOfByte = this.bufBusinessExt;
    int i;
    if (arrayOfByte != null) {
      i = arrayOfByte.length;
    } else {
      i = 0;
    }
    localStringBuilder.append(i);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadBizInfo
 * JD-Core Version:    0.7.0.1
 */