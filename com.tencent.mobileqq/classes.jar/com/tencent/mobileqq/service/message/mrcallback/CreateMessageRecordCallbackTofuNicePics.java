package com.tencent.mobileqq.service.message.mrcallback;

import com.tencent.imcore.message.core.CreateMessageRecordCallback;
import com.tencent.mobileqq.data.MessageForTofuNicePics;
import com.tencent.mobileqq.data.MessageRecord;

public class CreateMessageRecordCallbackTofuNicePics
  implements CreateMessageRecordCallback
{
  public MessageRecord a(int paramInt)
  {
    if (paramInt == -7011) {
      return new MessageForTofuNicePics();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.mrcallback.CreateMessageRecordCallbackTofuNicePics
 * JD-Core Version:    0.7.0.1
 */