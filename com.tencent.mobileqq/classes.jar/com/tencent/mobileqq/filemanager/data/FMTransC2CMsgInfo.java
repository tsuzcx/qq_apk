package com.tencent.mobileqq.filemanager.data;

import atib;
import java.io.Serializable;

public class FMTransC2CMsgInfo
  implements Serializable
{
  public int busiType;
  public int cmd;
  public FileManagerEntity entity;
  public atib fileTransferObserver = null;
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
    return "msgSeq[" + this.msgSeq + "] msgUid[" + this.msgUid + "] subCmd[" + this.subCmd + "] sessionId[" + this.sessionId + "] uuid[" + this.uuid + "] busiType[" + this.busiType + "] uniseq" + this.uniseq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.FMTransC2CMsgInfo
 * JD-Core Version:    0.7.0.1
 */