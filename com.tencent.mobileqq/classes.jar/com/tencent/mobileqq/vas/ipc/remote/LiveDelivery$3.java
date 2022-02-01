package com.tencent.mobileqq.vas.ipc.remote;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver.OnCallback;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import eipc.EIPCModule;
import eipc.EIPCResult;

class LiveDelivery$3
  extends IPublicAccountObserver.OnCallback
{
  LiveDelivery$3(LiveDelivery paramLiveDelivery, EIPCModule paramEIPCModule, int paramInt, QQAppInterface paramQQAppInterface) {}
  
  public void onFollowPublicAccount(boolean paramBoolean, String paramString)
  {
    super.onFollowPublicAccount(paramBoolean, paramString);
    EIPCResult localEIPCResult = new EIPCResult();
    localEIPCResult.data = new Bundle();
    localEIPCResult.data.putBoolean("isSuccess", paramBoolean);
    localEIPCResult.data.putString("uin", paramString);
    this.val$moudle.callbackResult(this.val$callbackId, localEIPCResult);
    if ((paramBoolean) && (TextUtils.isEmpty(TroopBarAssistantManager.a().a(paramString))))
    {
      paramString = (IPublicAccountHandler)this.val$app.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
      if (paramString != null) {
        paramString.getUserFollowList();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ipc.remote.LiveDelivery.3
 * JD-Core Version:    0.7.0.1
 */