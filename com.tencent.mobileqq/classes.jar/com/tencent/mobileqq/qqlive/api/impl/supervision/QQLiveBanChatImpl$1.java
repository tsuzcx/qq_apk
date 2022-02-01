package com.tencent.mobileqq.qqlive.api.impl.supervision;

import com.tencent.mobileqq.qqlive.callback.supervision.QueryIsBanedChatCallback;
import com.tencent.mobileqq.qqlive.sso.BaseSsoCallback;
import com.tencent.mobileqq.qqlive.sso.QQLiveRspData;
import com.tencent.qqlive.iliveRoomAdminSvr.nano.GetChatStatusRsp;

class QQLiveBanChatImpl$1
  extends BaseSsoCallback
{
  QQLiveBanChatImpl$1(QQLiveBanChatImpl paramQQLiveBanChatImpl, long paramLong, QueryIsBanedChatCallback paramQueryIsBanedChatCallback) {}
  
  public void onBusinessFailed(int paramInt, String paramString)
  {
    super.onBusinessFailed(paramInt, paramString);
    this.val$callback.onFailed(paramInt, paramString);
  }
  
  public void onProxyRequestSuccess(int paramInt, QQLiveRspData paramQQLiveRspData)
  {
    paramQQLiveRspData = GetChatStatusRsp.a(paramQQLiveRspData.a()).c;
    int i = paramQQLiveRspData.length;
    paramInt = 0;
    boolean bool = false;
    while (paramInt < i)
    {
      if (paramQQLiveRspData[paramInt] == this.val$targetUserUid) {
        bool = true;
      } else {
        bool = false;
      }
      paramInt += 1;
    }
    this.val$callback.a(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.supervision.QQLiveBanChatImpl.1
 * JD-Core Version:    0.7.0.1
 */