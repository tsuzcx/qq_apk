package com.tencent.mobileqq.service.message.mrcallback;

import com.tencent.imcore.message.core.CreateMessageRecordCallback;
import com.tencent.mobileqq.data.MessageForBeancurd;
import com.tencent.mobileqq.data.MessageRecord;

public class CreateMessageRecordCallbackForBeancurd
  implements CreateMessageRecordCallback
{
  public MessageRecord a(int paramInt)
  {
    if (paramInt == -7016) {
      return new MessageForBeancurd();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.mrcallback.CreateMessageRecordCallbackForBeancurd
 * JD-Core Version:    0.7.0.1
 */