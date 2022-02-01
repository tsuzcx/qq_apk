package com.tencent.mobileqq.ecshop.temp.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.ecshop.temp.api.IEcshopOtherApi;
import mqq.os.MqqHandler;

public class EcshopOtherApiImpl
  implements IEcshopOtherApi
{
  public void updateRecentList(AppInterface paramAppInterface)
  {
    paramAppInterface = paramAppInterface.getHandler(Conversation.class);
    if (paramAppInterface != null) {
      paramAppInterface.sendEmptyMessage(1009);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.temp.api.impl.EcshopOtherApiImpl
 * JD-Core Version:    0.7.0.1
 */