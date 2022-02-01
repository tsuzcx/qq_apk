package com.tencent.mobileqq.data;

import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;

public class MessageRecordDummyCallback
  implements MessageRecord.Callback
{
  public boolean a(MessageRecord paramMessageRecord)
  {
    return MessageRecordInfo.b(paramMessageRecord.issend);
  }
  
  public String b(MessageRecord paramMessageRecord)
  {
    return MessageRecord.getTableName(paramMessageRecord.frienduin, paramMessageRecord.istroop);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageRecordDummyCallback
 * JD-Core Version:    0.7.0.1
 */