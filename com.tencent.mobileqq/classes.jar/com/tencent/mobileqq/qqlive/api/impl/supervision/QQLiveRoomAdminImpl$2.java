package com.tencent.mobileqq.qqlive.api.impl.supervision;

import com.tencent.mobileqq.qqlive.callback.room.IsAdminCallback;
import com.tencent.mobileqq.qqlive.sso.BaseSsoCallback;
import com.tencent.mobileqq.qqlive.sso.QQLiveRspData;
import com.tencent.qqlive.iliveRoomAdminSvr.nano.IsRoomAdminRsp;

class QQLiveRoomAdminImpl$2
  extends BaseSsoCallback
{
  QQLiveRoomAdminImpl$2(QQLiveRoomAdminImpl paramQQLiveRoomAdminImpl, IsAdminCallback paramIsAdminCallback, long paramLong) {}
  
  public void onBusinessFailed(int paramInt, String paramString)
  {
    super.onBusinessFailed(paramInt, paramString);
    this.val$callback.onFailed(paramInt, paramString);
  }
  
  public void onFailed(int paramInt, String paramString)
  {
    super.onFailed(paramInt, paramString);
  }
  
  public void onProxyRequestSuccess(int paramInt, QQLiveRspData paramQQLiveRspData)
  {
    paramQQLiveRspData = IsRoomAdminRsp.a(paramQQLiveRspData.a());
    IsAdminCallback localIsAdminCallback = this.val$callback;
    long l = this.val$targetUserUid;
    paramInt = paramQQLiveRspData.c;
    boolean bool = true;
    if (paramInt != 1) {
      bool = false;
    }
    localIsAdminCallback.a(l, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.supervision.QQLiveRoomAdminImpl.2
 * JD-Core Version:    0.7.0.1
 */