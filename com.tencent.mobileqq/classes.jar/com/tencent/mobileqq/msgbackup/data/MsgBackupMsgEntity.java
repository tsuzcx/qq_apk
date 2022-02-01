package com.tencent.mobileqq.msgbackup.data;

import android.text.TextUtils;
import com.tencent.mobileqq.msgbackup.util.MsgBackupUtil;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;

public class MsgBackupMsgEntity
  extends Entity
{
  public static final String TABLE_NAME = "msg";
  public int chatType;
  public String chatUin;
  public byte[] extensionData;
  public byte[] extraData;
  @notColumn
  public String extraDataStr;
  public long msgRandom;
  public long msgSeq;
  public long msgTime;
  public int msgType;
  
  public String getTableName()
  {
    return "msg";
  }
  
  protected void postRead()
  {
    super.postRead();
    MsgBackupUtil.a(this);
    try
    {
      if (this.extraData == null) {
        break label50;
      }
      this.extraDataStr = new String(this.extraData, "utf-8");
      return;
    }
    catch (Exception localException)
    {
      label33:
      label50:
      break label33;
    }
    MsgBackupUtil.b("MsgBackup", "MsgBackupMsgEntity  postRead is called error!", new Object[0]);
    this.extraDataStr = "";
  }
  
  protected void prewrite()
  {
    super.prewrite();
    if (!TextUtils.isEmpty(this.extraDataStr)) {
      this.extraData = this.extraDataStr.getBytes();
    }
    MsgBackupUtil.b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.data.MsgBackupMsgEntity
 * JD-Core Version:    0.7.0.1
 */