package com.tencent.mobileqq.nearpeople.api.impl;

import android.content.Context;
import com.tencent.mobileqq.nearpeople.IChatPushCarrier;
import com.tencent.mobileqq.nearpeople.NearbyRecommender.ChatPushCarrierHelper;
import com.tencent.mobileqq.nearpeople.api.IChatPushCarrierHelper;

public class ChatPushCarrierHelperImpl
  implements IChatPushCarrierHelper
{
  public IChatPushCarrier getChatPushCarrier(Context paramContext)
  {
    return new ChatPushCarrierHelper(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearpeople.api.impl.ChatPushCarrierHelperImpl
 * JD-Core Version:    0.7.0.1
 */