package com.tencent.mobileqq.qqgift.api.impl.service;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.gift.gift_info_svr.nano.GetGiftListRsp;
import com.tencent.mobileqq.qqgift.callback.service.IQQGiftListCallback;
import com.tencent.mobileqq.qqgift.data.service.GiftListData;
import com.tencent.mobileqq.qqgift.sso.QQGiftBusinessObserver;
import com.tencent.mobileqq.qqgift.sso.QQGiftRspData;
import com.tencent.qphone.base.util.QLog;

class QQGiftServiceModuleImpl$2
  extends QQGiftBusinessObserver
{
  QQGiftServiceModuleImpl$2(QQGiftServiceModuleImpl paramQQGiftServiceModuleImpl, IQQGiftListCallback paramIQQGiftListCallback, GiftListData paramGiftListData) {}
  
  public void a(int paramInt, boolean paramBoolean, QQGiftRspData paramQQGiftRspData)
  {
    if (paramBoolean)
    {
      if ((paramQQGiftRspData != null) && (paramQQGiftRspData.a() != null))
      {
        if (paramQQGiftRspData.c() != 0)
        {
          QQGiftServiceModuleImpl.a(this.c, this.a, paramQQGiftRspData.c(), paramQQGiftRspData.e());
          return;
        }
        try
        {
          paramQQGiftRspData = GetGiftListRsp.a(paramQQGiftRspData.a());
          QQGiftServiceModuleImpl.a(this.c, this.a, paramQQGiftRspData, this.b);
          return;
        }
        catch (InvalidProtocolBufferNanoException paramQQGiftRspData)
        {
          QQGiftServiceModuleImpl.a(this.c, this.a, -1, "GetGiftListRsp get open info fail");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("GetGiftListRsp error:");
          localStringBuilder.append(paramQQGiftRspData.getMessage());
          QLog.e("QQGiftServiceModuleImpl", 1, localStringBuilder.toString());
          return;
        }
      }
      QQGiftServiceModuleImpl.a(this.c, this.a, -1, "the data is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.api.impl.service.QQGiftServiceModuleImpl.2
 * JD-Core Version:    0.7.0.1
 */