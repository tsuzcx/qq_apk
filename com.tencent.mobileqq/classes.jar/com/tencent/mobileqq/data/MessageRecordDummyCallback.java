package com.tencent.mobileqq.data;

import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;

public class MessageRecordDummyCallback
  implements MessageRecord.Callback
{
  public String a(MessageRecord paramMessageRecord)
  {
    return MessageRecord.getTableName(paramMessageRecord.frienduin, paramMessageRecord.istroop);
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    return MessageRecordInfo.a(paramMessageRecord.issend);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageRecordDummyCallback
 * JD-Core Version:    0.7.0.1
 */