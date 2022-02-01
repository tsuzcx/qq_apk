package com.tencent.mobileqq.filemanager.proto;

import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.io.Serializable;

public class FMTransC2CMsgInfo
  implements Serializable
{
  public int busiType;
  public int cmd;
  public FileManagerEntity entity;
  public FileTransferObserver fileTransferObserver = null;
  public long msgSeq = -1L;
  public long msgUid = -1L;
  public long observerSeq = -1L;
  public long queueSeq = -1L;
  public long sessionId = 0L;
  public int subCmd;
  public String toUin = "";
  public long uniseq = 0L;
  public String uuid = "";
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("msgSeq[");
    localStringBuilder.append(this.msgSeq);
    localStringBuilder.append("] msgUid[");
    localStringBuilder.append(this.msgUid);
    localStringBuilder.append("] subCmd[");
    localStringBuilder.append(this.subCmd);
    localStringBuilder.append("] sessionId[");
    localStringBuilder.append(this.sessionId);
    localStringBuilder.append("] uuid[");
    localStringBuilder.append(this.uuid);
    localStringBuilder.append("] busiType[");
    localStringBuilder.append(this.busiType);
    localStringBuilder.append("] uniseq");
    localStringBuilder.append(this.uniseq);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.proto.FMTransC2CMsgInfo
 * JD-Core Version:    0.7.0.1
 */