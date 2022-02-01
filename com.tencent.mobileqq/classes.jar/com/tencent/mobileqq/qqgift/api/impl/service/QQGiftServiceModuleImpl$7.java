package com.tencent.mobileqq.qqgift.api.impl.service;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.gift.gift_trans_svr.gift_trans_svr.nano.GetBalanceRsp;
import com.tencent.mobileqq.qqgift.callback.service.IQQGiftBalanceCallback;
import com.tencent.mobileqq.qqgift.sso.QQGiftBusinessObserver;
import com.tencent.mobileqq.qqgift.sso.QQGiftRspData;
import com.tencent.qphone.base.util.QLog;

class QQGiftServiceModuleImpl$7
  extends QQGiftBusinessObserver
{
  QQGiftServiceModuleImpl$7(QQGiftServiceModuleImpl paramQQGiftServiceModuleImpl, IQQGiftBalanceCallback paramIQQGiftBalanceCallback) {}
  
  public void a(int paramInt, boolean paramBoolean, QQGiftRspData paramQQGiftRspData)
  {
    if (paramBoolean)
    {
      if ((paramQQGiftRspData != null) && (paramQQGiftRspData.a() != null))
      {
        if (paramQQGiftRspData.c() != 0)
        {
          QQGiftServiceModuleImpl.a(this.b, this.a, paramQQGiftRspData.c(), "business error");
          return;
        }
        try
        {
          localObject = GetBalanceRsp.a(paramQQGiftRspData.a());
          QQGiftServiceModuleImpl.a(this.b, this.a, (GetBalanceRsp)localObject, paramQQGiftRspData.f());
          return;
        }
        catch (InvalidProtocolBufferNanoException paramQQGiftRspData)
        {
          QQGiftServiceModuleImpl.a(this.b, this.a, -1, "GetBalanceRsp get open info fail");
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("GetBalanceRsp error:");
          ((StringBuilder)localObject).append(paramQQGiftRspData.getMessage());
          QLog.e("QQGiftServiceModuleImpl", 1, ((StringBuilder)localObject).toString());
          return;
        }
      }
      QQGiftServiceModuleImpl.a(this.b, this.a, -1, "the data is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.api.impl.service.QQGiftServiceModuleImpl.7
 * JD-Core Version:    0.7.0.1
 */