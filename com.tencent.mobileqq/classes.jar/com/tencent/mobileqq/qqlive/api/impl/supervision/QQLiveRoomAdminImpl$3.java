package com.tencent.mobileqq.qqlive.api.impl.supervision;

import com.tencent.mobileqq.qqlive.callback.room.SetAdminCallback;
import com.tencent.mobileqq.qqlive.sso.BaseSsoCallback;
import com.tencent.mobileqq.qqlive.sso.QQLiveRspData;
import com.tencent.qqlive.iliveRoomAdminSvr.nano.SetRoomAdminRsp;

class QQLiveRoomAdminImpl$3
  extends BaseSsoCallback
{
  QQLiveRoomAdminImpl$3(QQLiveRoomAdminImpl paramQQLiveRoomAdminImpl, SetAdminCallback paramSetAdminCallback, long paramLong) {}
  
  public void onBusinessFailed(int paramInt, String paramString)
  {
    super.onBusinessFailed(paramInt, paramString);
    this.val$callback.onFailed(paramInt, paramString);
  }
  
  public void onProxyRequestSuccess(int paramInt, QQLiveRspData paramQQLiveRspData)
  {
    paramQQLiveRspData = SetRoomAdminRsp.a(paramQQLiveRspData.a());
    if (paramQQLiveRspData.a == 1)
    {
      this.val$callback.a(this.val$targetUserUid, paramQQLiveRspData.c);
      return;
    }
    this.val$callback.onFailed(paramQQLiveRspData.a, "setAdmin fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.supervision.QQLiveRoomAdminImpl.3
 * JD-Core Version:    0.7.0.1
 */