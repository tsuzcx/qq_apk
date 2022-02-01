package com.tencent.mobileqq.qqgift.api.impl.service;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.gift.gift_info_svr.nano.GetGiftDetailRsp;
import com.tencent.mobileqq.qqgift.sso.QQGiftBusinessObserver;
import com.tencent.mobileqq.qqgift.sso.QQGiftRspData;
import com.tencent.qphone.base.util.QLog;

class QQGiftServiceModuleImpl$3
  extends QQGiftBusinessObserver
{
  public void a(int paramInt, boolean paramBoolean, QQGiftRspData paramQQGiftRspData)
  {
    if (paramBoolean)
    {
      if ((paramQQGiftRspData != null) && (paramQQGiftRspData.a() != null))
      {
        if (paramQQGiftRspData.c() != 0)
        {
          QQGiftServiceModuleImpl.a(this.b, this.a, paramQQGiftRspData.c(), paramQQGiftRspData.e());
          return;
        }
        try
        {
          paramQQGiftRspData = GetGiftDetailRsp.a(paramQQGiftRspData.a());
          QQGiftServiceModuleImpl.a(this.b, this.a, paramQQGiftRspData);
          return;
        }
        catch (InvalidProtocolBufferNanoException paramQQGiftRspData)
        {
          QQGiftServiceModuleImpl.a(this.b, this.a, -1, "GetGiftDetailRsp get open info fail");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("GetGiftDetailRsp error:");
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
 * Qualified Name:     com.tencent.mobileqq.qqgift.api.impl.service.QQGiftServiceModuleImpl.3
 * JD-Core Version:    0.7.0.1
 */