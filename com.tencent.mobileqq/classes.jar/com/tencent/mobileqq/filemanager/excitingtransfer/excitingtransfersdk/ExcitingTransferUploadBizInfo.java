package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

import android.support.annotation.NonNull;
import com.tencent.commonsdk.util.HexUtil;

public class ExcitingTransferUploadBizInfo
{
  public boolean bUseMediaPlatform;
  public byte[] bufBusinessExt;
  public byte[] bufSig;
  public byte[] bufUploadKey;
  public byte[] bufUuid;
  public int businessType;
  public int chateType = 4;
  public int client_type = 0;
  public String client_ver;
  public int commandId;
  public int danger_level;
  public long groupCode;
  public long receiverUin;
  public long senderUin;
  public int terminal_type = 0;
  public String terminal_ver;
  public long total_space;
  public ExcitingTransferHostInfo[] vecFtnLanIpV4AndPorts;
  public ExcitingTransferHostInfo[] vecFtnLanIpV6AndPorts;
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("commandId:").append(this.commandId).append(" businessType:").append(this.businessType).append(" chateType:").append(this.chateType).append(" senderUin:").append(this.senderUin).append(" receiverUin:").append(this.receiverUin).append(" groupCode:").append(this.groupCode).append(" client_type:").append(this.client_type).append(" client_ver:").append(this.client_ver).append(" bUseMediaPlatform:").append(this.bUseMediaPlatform).append(" bufSig:").append(HexUtil.bytes2HexStr(this.bufSig)).append(" bufUuid:").append(HexUtil.bytes2HexStr(this.bufUuid)).append(" bufUploadKey:").append(HexUtil.bytes2HexStr(this.bufUploadKey)).append(" bufBusinessExt_l:");
    if (this.bufBusinessExt != null) {}
    for (int i = this.bufBusinessExt.length;; i = 0) {
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadBizInfo
 * JD-Core Version:    0.7.0.1
 */