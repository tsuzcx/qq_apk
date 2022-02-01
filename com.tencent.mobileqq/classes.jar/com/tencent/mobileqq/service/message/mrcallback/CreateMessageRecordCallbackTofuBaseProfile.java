package com.tencent.mobileqq.service.message.mrcallback;

import com.tencent.imcore.message.core.CreateMessageRecordCallback;
import com.tencent.mobileqq.data.MessageForTofuBaseProfile;
import com.tencent.mobileqq.data.MessageRecord;

public class CreateMessageRecordCallbackTofuBaseProfile
  implements CreateMessageRecordCallback
{
  public MessageRecord a(int paramInt)
  {
    if (paramInt == -7010) {
      return new MessageForTofuBaseProfile();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.mrcallback.CreateMessageRecordCallbackTofuBaseProfile
 * JD-Core Version:    0.7.0.1
 */