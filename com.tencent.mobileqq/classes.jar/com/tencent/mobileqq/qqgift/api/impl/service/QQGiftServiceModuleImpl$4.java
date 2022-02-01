package com.tencent.mobileqq.qqgift.api.impl.service;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.gift.gift_trans_svr.gift_trans_svr.nano.SendGiftRsp;
import com.tencent.mobileqq.qqgift.callback.service.IQQGiftSendCallback;
import com.tencent.mobileqq.qqgift.sso.QQGiftBusinessObserver;
import com.tencent.mobileqq.qqgift.sso.QQGiftRspData;
import com.tencent.qphone.base.util.QLog;

class QQGiftServiceModuleImpl$4
  extends QQGiftBusinessObserver
{
  QQGiftServiceModuleImpl$4(QQGiftServiceModuleImpl paramQQGiftServiceModuleImpl, IQQGiftSendCallback paramIQQGiftSendCallback) {}
  
  public void a(int paramInt, boolean paramBoolean, QQGiftRspData paramQQGiftRspData)
  {
    if (paramBoolean)
    {
      if ((paramQQGiftRspData != null) && (paramQQGiftRspData.a() != null))
      {
        if (paramQQGiftRspData.c() != 0)
        {
          if (paramQQGiftRspData.c() == -11008)
          {
            QQGiftServiceModuleImpl.a(this.b, this.a, -11008, paramQQGiftRspData.e());
            return;
          }
          QQGiftServiceModuleImpl.a(this.b, this.a, paramQQGiftRspData.c(), paramQQGiftRspData.e());
          return;
        }
        try
        {
          paramQQGiftRspData = SendGiftRsp.a(paramQQGiftRspData.a());
          QQGiftServiceModuleImpl.a(this.b, this.a, paramQQGiftRspData);
          return;
        }
        catch (InvalidProtocolBufferNanoException paramQQGiftRspData)
        {
          QQGiftServiceModuleImpl.a(this.b, this.a, -1, "SendGiftRsp get open info fail");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("SendGiftRsp error:");
          localStringBuilder.append(paramQQGiftRspData.getMessage());
          QLog.e("QQGiftServiceModuleImpl", 1, localStringBuilder.toString());
          return;
        }
      }
      QQGiftServiceModuleImpl.a(this.b, this.a, -1, "the data is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.api.impl.service.QQGiftServiceModuleImpl.4
 * JD-Core Version:    0.7.0.1
 */