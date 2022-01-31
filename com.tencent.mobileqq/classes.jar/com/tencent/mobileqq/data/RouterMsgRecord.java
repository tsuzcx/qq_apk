package com.tencent.mobileqq.data;

import awge;
import awhp;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="time,msgid,uSessionID")
public class RouterMsgRecord
  extends MessageRecord
  implements Cloneable
{
  public static final int MSG_TYPE_DATALINE_APP = -2335;
  public static final int MSG_TYPE_DATALINE_FILE = -2005;
  public static final int MSG_TYPE_DATALINE_PIC = -2000;
  public static final int MSG_TYPE_DATALINE_PROMPT = -2334;
  public static final int MSG_TYPE_DATALINE_TEXT = -1000;
  public static final int MSG_TYPE_DATALINE_VIDEO = -2009;
  public static final int oppositestatus_Fail = 3;
  public static final int oppositestatus_FileDel = 5;
  public static final int oppositestatus_MsgDel = 4;
  public static final int oppositestatus_Suc = 2;
  public static final int oppositestatus_Unknown = 1;
  public static String sBasicTableName = "mr_dataline_router_";
  public static final int status_New = 1;
  public static final int status_transfer_fail = 4;
  public static final int status_transfer_pause = 5;
  public static final int status_transfer_suc = 3;
  public static final int status_transfering = 2;
  @awhp
  public long entityID;
  public long fileSize;
  public String filename;
  public int oppositestatus = 1;
  public long peerDin;
  public double progress;
  public String sTableName;
  public int status = 1;
  public long uSessionID;
  
  public RouterMsgRecord()
  {
    this.versionCode = 0;
  }
  
  public RouterMsgRecord(long paramLong)
  {
    this.versionCode = 0;
    this.msgId = paramLong;
  }
  
  public static String tableBasicName()
  {
    return sBasicTableName;
  }
  
  public RouterMsgRecord clone()
  {
    try
    {
      RouterMsgRecord localRouterMsgRecord = (RouterMsgRecord)super.clone();
      return localRouterMsgRecord;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
  
  public Class<? extends awge> getClassForTable()
  {
    return RouterMsgRecord.class;
  }
  
  public String getTableName()
  {
    return this.sTableName;
  }
  
  public void postRead() {}
  
  public void setTableName(String paramString)
  {
    this.sTableName = (sBasicTableName + paramString);
    this.peerDin = Long.parseLong(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.RouterMsgRecord
 * JD-Core Version:    0.7.0.1
 */