package com.tencent.mobileqq.msgbackup.data;

import android.text.TextUtils;
import aujq;
import awge;
import awhp;

public class MsgBackupMsgEntity
  extends awge
{
  public static final String TABLE_NAME = "msg";
  public int chatType;
  public String chatUin;
  public byte[] extensionData;
  public byte[] extraData;
  @awhp
  public String extraDataStr;
  public long msgRandom;
  public long msgSeq;
  public long msgTime;
  public int msgType;
  
  public String getTableName()
  {
    return "msg";
  }
  
  public void postRead()
  {
    super.postRead();
    aujq.a(this);
    try
    {
      if (this.extraData != null) {
        this.extraDataStr = new String(this.extraData, "utf-8");
      }
      return;
    }
    catch (Exception localException)
    {
      aujq.b("MsgBackup", "MsgBackupMsgEntity  postRead is called error!", new Object[0]);
      this.extraDataStr = "";
    }
  }
  
  public void prewrite()
  {
    super.prewrite();
    if (!TextUtils.isEmpty(this.extraDataStr)) {
      this.extraData = this.extraDataStr.getBytes();
    }
    aujq.b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.data.MsgBackupMsgEntity
 * JD-Core Version:    0.7.0.1
 */