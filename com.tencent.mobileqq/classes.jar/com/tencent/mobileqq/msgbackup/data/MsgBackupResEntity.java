package com.tencent.mobileqq.msgbackup.data;

import android.text.TextUtils;
import axjn;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;

public class MsgBackupResEntity
  extends Entity
{
  public static final String TABLE_NAME = "res";
  public byte[] extraData;
  @notColumn
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
    axjn.b(this);
    try
    {
      if (this.extraData != null) {
        this.extraDataStr = new String(this.extraData, "utf-8");
      }
      return;
    }
    catch (Exception localException)
    {
      axjn.b("MsgBackup", "MsgBackupMsgEntity  postRead is called error!", new Object[0]);
      this.extraDataStr = "";
    }
  }
  
  public void prewrite()
  {
    super.prewrite();
    if (!TextUtils.isEmpty(this.extraDataStr)) {
      this.extraData = this.extraDataStr.getBytes();
    }
    axjn.a(this);
    this.filePath = axjn.c(this.filePath);
  }
  
  public String toLogString()
  {
    return "MsgBackupResEntity{msgSeq=" + this.msgSeq + ", msgRandom=" + this.msgRandom + ", msgType=" + this.msgType + ", msgSubType=" + this.msgSubType + ", filePath='" + this.filePath + '\'' + ", extraDataStr='" + this.extraDataStr + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity
 * JD-Core Version:    0.7.0.1
 */