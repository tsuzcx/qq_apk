package com.tencent.mobileqq.msgbackup.controller;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;

public class ResDownloadObject
{
  public boolean a;
  public String b;
  
  public String a(IMsgBackupRichProcessor paramIMsgBackupRichProcessor, MessageRecord paramMessageRecord, MsgBackupResEntity paramMsgBackupResEntity)
  {
    String str = this.b;
    if (str == null) {
      return paramIMsgBackupRichProcessor.b(paramMessageRecord, paramMsgBackupResEntity);
    }
    return str;
  }
  
  public boolean a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.controller.ResDownloadObject
 * JD-Core Version:    0.7.0.1
 */