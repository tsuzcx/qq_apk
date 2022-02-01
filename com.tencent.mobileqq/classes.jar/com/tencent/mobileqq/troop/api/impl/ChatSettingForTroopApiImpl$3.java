package com.tencent.mobileqq.troop.api.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.mobileqq.troop.utils.TroopBindPubAccountProtocol.RequestPublicAccountObserver;

class ChatSettingForTroopApiImpl$3
  extends TroopBindPubAccountProtocol.RequestPublicAccountObserver
{
  ChatSettingForTroopApiImpl$3(ChatSettingForTroopApiImpl paramChatSettingForTroopApiImpl, int paramInt, Handler paramHandler) {}
  
  protected void a(boolean paramBoolean, long paramLong, IPublicAccountDetail paramIPublicAccountDetail)
  {
    if (paramBoolean)
    {
      Message localMessage = Message.obtain();
      localMessage.what = this.a;
      Bundle localBundle = new Bundle();
      localBundle.putString("uinname", paramIPublicAccountDetail.getName());
      localBundle.putString("extra_type", paramIPublicAccountDetail.getSummary());
      localBundle.putLong("uin", paramLong);
      localMessage.setData(localBundle);
      this.b.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.ChatSettingForTroopApiImpl.3
 * JD-Core Version:    0.7.0.1
 */