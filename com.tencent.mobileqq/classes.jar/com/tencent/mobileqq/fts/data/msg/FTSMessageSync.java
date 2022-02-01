package com.tencent.mobileqq.fts.data.msg;

import com.tencent.mobileqq.fts.v1.FTSOptSync;
import com.tencent.mobileqq.fts.v1.utils.MsgExts;
import com.tencent.mobileqq.persistence.notColumn;

public class FTSMessageSync
  extends FTSOptSync
{
  public int istroop;
  @notColumn
  public MsgExts msgExts;
  public byte[] msgExtsData;
  public int msgtype;
  public String senderuin;
  public long uin;
  
  public String getTableName()
  {
    return "msg_sync_log";
  }
  
  protected void postRead()
  {
    this.msgExts = ((MsgExts)MsgExts.unserialize(this.msgExtsData, 1));
  }
  
  protected void prewrite()
  {
    this.msgExtsData = MsgExts.serialize(this.msgExts, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fts.data.msg.FTSMessageSync
 * JD-Core Version:    0.7.0.1
 */