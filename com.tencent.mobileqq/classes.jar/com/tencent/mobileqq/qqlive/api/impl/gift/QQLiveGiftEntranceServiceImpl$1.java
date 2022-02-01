package com.tencent.mobileqq.qqlive.api.impl.gift;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.mobileqq.qqlive.callback.gift.OnQueryGiftIconCallback;
import com.tencent.mobileqq.qqlive.sso.QQLiveBusinessObserver;
import com.tencent.mobileqq.qqlive.sso.QQLiveRspData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.qlive.config_center_svr.config_center_svr.nano.VerifyGiftRsp;

class QQLiveGiftEntranceServiceImpl$1
  extends QQLiveBusinessObserver
{
  QQLiveGiftEntranceServiceImpl$1(QQLiveGiftEntranceServiceImpl paramQQLiveGiftEntranceServiceImpl, OnQueryGiftIconCallback paramOnQueryGiftIconCallback) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, QQLiveRspData paramQQLiveRspData)
  {
    if (paramBoolean)
    {
      if ((paramQQLiveRspData != null) && (paramQQLiveRspData.a() != null)) {
        try
        {
          paramQQLiveRspData = VerifyGiftRsp.a(paramQQLiveRspData.a());
          this.val$callback.onSuccess(paramQQLiveRspData.a, paramQQLiveRspData.b);
          return;
        }
        catch (InvalidProtocolBufferNanoException paramQQLiveRspData)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("needShowGiftIcon onReceive e:");
          localStringBuilder.append(paramQQLiveRspData.getMessage());
          QLog.e("QQLiveGiftEntranceServiceImpl", 1, localStringBuilder.toString());
          return;
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("needShowGiftIcon data error, data:");
      localStringBuilder.append(paramQQLiveRspData);
      QLog.e("QQLiveGiftEntranceServiceImpl", 1, localStringBuilder.toString());
      this.val$callback.onFailed(-1, "data is null");
      return;
    }
    QLog.e("QQLiveGiftEntranceServiceImpl", 1, "needShowGiftIcon onReceive error");
    this.val$callback.onFailed(-1, "query needShowGiftIcon fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.gift.QQLiveGiftEntranceServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */