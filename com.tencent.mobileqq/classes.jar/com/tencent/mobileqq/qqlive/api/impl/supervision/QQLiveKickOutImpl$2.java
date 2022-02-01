package com.tencent.mobileqq.qqlive.api.impl.supervision;

import com.tencent.mobileqq.qqlive.callback.supervision.KickOutUserCallback;
import com.tencent.mobileqq.qqlive.sso.BaseSsoCallback;
import com.tencent.mobileqq.qqlive.sso.QQLiveRspData;
import com.tencent.qqlive.iliveRoomAdminSvr.nano.KickOutSomebodyRsp;

class QQLiveKickOutImpl$2
  extends BaseSsoCallback
{
  QQLiveKickOutImpl$2(QQLiveKickOutImpl paramQQLiveKickOutImpl, KickOutUserCallback paramKickOutUserCallback, long paramLong) {}
  
  public void onBusinessFailed(int paramInt, String paramString)
  {
    super.onBusinessFailed(paramInt, paramString);
    this.val$callback.onFailed(paramInt, paramString);
  }
  
  public void onProxyRequestSuccess(int paramInt, QQLiveRspData paramQQLiveRspData)
  {
    paramQQLiveRspData = KickOutSomebodyRsp.a(paramQQLiveRspData.a());
    if (paramQQLiveRspData.a == 0)
    {
      this.val$callback.a(this.val$targetUserUid);
      return;
    }
    this.val$callback.onFailed(paramQQLiveRspData.a, paramQQLiveRspData.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.supervision.QQLiveKickOutImpl.2
 * JD-Core Version:    0.7.0.1
 */