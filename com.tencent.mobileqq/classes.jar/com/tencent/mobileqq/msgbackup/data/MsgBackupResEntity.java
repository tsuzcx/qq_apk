package com.tencent.mobileqq.msgbackup.data;

import android.text.TextUtils;
import com.tencent.mobileqq.msgbackup.util.MsgBackupUtil;
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
  
  protected void postRead()
  {
    super.postRead();
    MsgBackupUtil.b(this);
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
    MsgBackupUtil.a(this);
    this.filePath = MsgBackupUtil.c(this.filePath);
  }
  
  public String toLogString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MsgBackupResEntity{msgSeq=");
    localStringBuilder.append(this.msgSeq);
    localStringBuilder.append(", msgRandom=");
    localStringBuilder.append(this.msgRandom);
    localStringBuilder.append(", msgType=");
    localStringBuilder.append(this.msgType);
    localStringBuilder.append(", msgSubType=");
    localStringBuilder.append(this.msgSubType);
    localStringBuilder.append(", filePath='");
    localStringBuilder.append(this.filePath);
    localStringBuilder.append('\'');
    localStringBuilder.append(", extraDataStr='");
    localStringBuilder.append(this.extraDataStr);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity
 * JD-Core Version:    0.7.0.1
 */