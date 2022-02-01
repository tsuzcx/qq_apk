package com.tencent.mobileqq.service.message.mrcallback;

import com.tencent.imcore.message.core.CreateMessageRecordCallback;
import com.tencent.mobileqq.data.MessageForTofuIntimateAnniversary;
import com.tencent.mobileqq.data.MessageRecord;

public class CreateMessageRecordCallbackTofuIntimateAnniversary
  implements CreateMessageRecordCallback
{
  public MessageRecord a(int paramInt)
  {
    if (paramInt == -7009) {
      return new MessageForTofuIntimateAnniversary();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.mrcallback.CreateMessageRecordCallbackTofuIntimateAnniversary
 * JD-Core Version:    0.7.0.1
 */