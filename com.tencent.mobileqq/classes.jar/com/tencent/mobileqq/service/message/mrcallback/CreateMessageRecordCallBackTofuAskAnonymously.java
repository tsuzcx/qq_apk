package com.tencent.mobileqq.service.message.mrcallback;

import com.tencent.imcore.message.core.CreateMessageRecordCallback;
import com.tencent.mobileqq.data.MessageForTofuAskAnonymously;
import com.tencent.mobileqq.data.MessageRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/service/message/mrcallback/CreateMessageRecordCallBackTofuAskAnonymously;", "Lcom/tencent/imcore/message/core/CreateMessageRecordCallback;", "()V", "create", "Lcom/tencent/mobileqq/data/MessageRecord;", "msgType", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class CreateMessageRecordCallBackTofuAskAnonymously
  implements CreateMessageRecordCallback
{
  @Nullable
  public MessageRecord a(int paramInt)
  {
    if (paramInt == -7015) {
      return (MessageRecord)new MessageForTofuAskAnonymously();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.mrcallback.CreateMessageRecordCallBackTofuAskAnonymously
 * JD-Core Version:    0.7.0.1
 */