package com.tencent.mobileqq.qqlive.api.impl.supervision;

import com.tencent.mobileqq.qqlive.callback.supervision.SetBanChatCallback;
import com.tencent.mobileqq.qqlive.sso.BaseSsoCallback;
import com.tencent.mobileqq.qqlive.sso.QQLiveRspData;
import com.tencent.qqlive.iliveRoomAdminSvr.nano.SetChatStatusRsp;

class QQLiveBanChatImpl$3
  extends BaseSsoCallback
{
  QQLiveBanChatImpl$3(QQLiveBanChatImpl paramQQLiveBanChatImpl, SetBanChatCallback paramSetBanChatCallback, long paramLong) {}
  
  public void onBusinessFailed(int paramInt, String paramString)
  {
    super.onBusinessFailed(paramInt, paramString);
    this.val$callback.onFailed(paramInt, paramString);
  }
  
  public void onProxyRequestSuccess(int paramInt, QQLiveRspData paramQQLiveRspData)
  {
    paramQQLiveRspData = SetChatStatusRsp.a(paramQQLiveRspData.a());
    if (paramQQLiveRspData.a == 0)
    {
      this.val$callback.a(false, this.val$targetUserUid);
      return;
    }
    this.val$callback.onFailed(paramQQLiveRspData.a, paramQQLiveRspData.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.supervision.QQLiveBanChatImpl.3
 * JD-Core Version:    0.7.0.1
 */