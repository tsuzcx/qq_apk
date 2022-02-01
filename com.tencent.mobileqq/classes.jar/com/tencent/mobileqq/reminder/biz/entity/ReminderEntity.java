package com.tencent.mobileqq.reminder.biz.entity;

import Wallet.AcsMsg;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.reminder.util.QQReminderUtil;

public class ReminderEntity
  extends Entity
  implements IReminderEntity
{
  public static final String TAG = "ReminderEntity.class";
  private boolean hasReminded;
  @notColumn
  private AcsMsg mAcsMsg;
  @unique
  public String mKey;
  public byte[] mMsgDate;
  public String mMsgId;
  public long mReminderTime;
  
  private void acsMsgExtract()
  {
    this.mMsgId = this.mAcsMsg.msg_id;
    this.mReminderTime = this.mAcsMsg.notice_time;
    this.mKey = QQReminderUtil.a(this.mAcsMsg);
  }
  
  private void acsMsgPack()
  {
    this.mAcsMsg.msg_id = this.mMsgId;
    this.mAcsMsg.notice_time = this.mReminderTime;
  }
  
  public AcsMsg getAcsMsg()
  {
    return this.mAcsMsg;
  }
  
  public void postRead()
  {
    super.postRead();
    JceInputStream localJceInputStream = new JceInputStream(this.mMsgDate);
    localJceInputStream.setServerEncoding("utf-8");
    this.mAcsMsg = new AcsMsg();
    this.mAcsMsg.readFrom(localJceInputStream);
    acsMsgPack();
  }
  
  public void prewrite()
  {
    super.prewrite();
    JceOutputStream localJceOutputStream = new JceOutputStream();
    localJceOutputStream.setServerEncoding("utf-8");
    acsMsgExtract();
    this.mAcsMsg.writeTo(localJceOutputStream);
    this.mMsgDate = localJceOutputStream.toByteArray();
  }
  
  public void setAcsMsg(AcsMsg paramAcsMsg)
  {
    this.mAcsMsg = paramAcsMsg;
    acsMsgExtract();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.reminder.biz.entity.ReminderEntity
 * JD-Core Version:    0.7.0.1
 */