package com.tencent.mobileqq.msgbackup.controller;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;

public class ResDownloadObject
{
  public String a;
  public boolean a;
  
  public String a(IMsgBackupRichProcessor paramIMsgBackupRichProcessor, MessageRecord paramMessageRecord, MsgBackupResEntity paramMsgBackupResEntity)
  {
    if (this.jdField_a_of_type_JavaLangString == null) {
      return paramIMsgBackupRichProcessor.a(paramMessageRecord, paramMsgBackupResEntity);
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.controller.ResDownloadObject
 * JD-Core Version:    0.7.0.1
 */