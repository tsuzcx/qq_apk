package com.tencent.mobileqq.msgbackup.data;

import android.text.TextUtils;
import aufh;
import awbv;
import awdg;

public class MsgBackupResEntity
  extends awbv
{
  public static final String TABLE_NAME = "res";
  public byte[] extraData;
  @awdg
  public String extraDataStr;
  public String filePath;
  public long fileSize;
  public long msgRandom;
  public long msgSeq;
  public int msgSubType;
  public int msgType;
  
  public String getTableName()
  {
    return "res";
  }
  
  public void postRead()
  {
    super.postRead();
    aufh.b(this);
    try
    {
      if (this.extraData != null) {
        this.extraDataStr = new String(this.extraData, "utf-8");
      }
      return;
    }
    catch (Exception localException)
    {
      aufh.b("MsgBackup", "MsgBackupMsgEntity  postRead is called error!", new Object[0]);
      this.extraDataStr = "";
    }
  }
  
  public void prewrite()
  {
    super.prewrite();
    if (!TextUtils.isEmpty(this.extraDataStr)) {
      this.extraData = this.extraDataStr.getBytes();
    }
    aufh.a(this);
    this.filePath = aufh.c(this.filePath);
  }
  
  public String toLogString()
  {
    return "MsgBackupResEntity{msgSeq=" + this.msgSeq + ", msgRandom=" + this.msgRandom + ", msgType=" + this.msgType + ", msgSubType=" + this.msgSubType + ", filePath='" + this.filePath + '\'' + ", extraDataStr='" + this.extraDataStr + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity
 * JD-Core Version:    0.7.0.1
 */