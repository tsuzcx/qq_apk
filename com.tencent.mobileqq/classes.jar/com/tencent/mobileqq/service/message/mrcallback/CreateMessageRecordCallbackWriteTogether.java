package com.tencent.mobileqq.service.message.mrcallback;

import com.tencent.imcore.message.core.CreateMessageRecordCallback;
import com.tencent.mobileqq.data.MessageForWriteTogether;
import com.tencent.mobileqq.data.MessageRecord;

public class CreateMessageRecordCallbackWriteTogether
  implements CreateMessageRecordCallback
{
  public MessageRecord a(int paramInt)
  {
    if (paramInt == -7014) {
      return new MessageForWriteTogether();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.mrcallback.CreateMessageRecordCallbackWriteTogether
 * JD-Core Version:    0.7.0.1
 */