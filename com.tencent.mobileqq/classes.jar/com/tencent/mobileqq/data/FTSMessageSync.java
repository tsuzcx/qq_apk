package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.fts.FTSOptSync;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.utils.fts.FTSMessageCodec;
import com.tencent.mobileqq.utils.fts.FTSMessageCodec.MsgExts;

public class FTSMessageSync
  extends FTSOptSync
{
  public static final String MSG_SYNC_LOG_TABLE = "msg_sync_log";
  public int istroop;
  @notColumn
  public FTSMessageCodec.MsgExts msgExts;
  public byte[] msgExtsData;
  public int msgtype;
  public String senderuin;
  public long uin;
  
  public String getTableName()
  {
    return "msg_sync_log";
  }
  
  public void postRead()
  {
    this.msgExts = ((FTSMessageCodec.MsgExts)FTSMessageCodec.a(this.msgExtsData, 1));
  }
  
  public void prewrite()
  {
    this.msgExtsData = FTSMessageCodec.a(this.msgExts, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.FTSMessageSync
 * JD-Core Version:    0.7.0.1
 */