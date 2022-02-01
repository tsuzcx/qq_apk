package com.tencent.mobileqq.vas.ipc.remote;

import android.os.Bundle;
import android.text.TextUtils;
import aoav;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import eipc.EIPCModule;
import eipc.EIPCResult;
import uqx;

class LiveDelivery$3
  extends aoav
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
    if ((paramBoolean) && (TextUtils.isEmpty(uqx.a().a(paramString))))
    {
      paramString = (PublicAccountHandler)this.val$app.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
      if (paramString != null) {
        paramString.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ipc.remote.LiveDelivery.3
 * JD-Core Version:    0.7.0.1
 */