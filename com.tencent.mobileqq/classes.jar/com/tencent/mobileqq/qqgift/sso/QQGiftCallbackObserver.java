package com.tencent.mobileqq.qqgift.sso;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class QQGiftCallbackObserver
  extends QQGiftBusinessObserver
{
  private final GiftBaseSsoCallBack a;
  
  public void a(int paramInt, boolean paramBoolean, QQGiftRspData paramQQGiftRspData)
  {
    if (this.a == null)
    {
      QLog.e("BaseSsoCallback", 1, "the callback is null");
      return;
    }
    Object localObject;
    StringBuilder localStringBuilder;
    if (paramBoolean) {
      if ((paramQQGiftRspData != null) && (paramQQGiftRspData.a() != null))
      {
        if (paramQQGiftRspData.c() != 0)
        {
          localObject = this.a;
          paramInt = paramQQGiftRspData.c();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("business error ");
          localStringBuilder.append(paramQQGiftRspData.e());
          ((GiftBaseSsoCallBack)localObject).b(paramInt, localStringBuilder.toString());
          return;
        }
        if (paramQQGiftRspData.d() != 0)
        {
          localObject = this.a;
          paramInt = paramQQGiftRspData.d();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("business error ");
          localStringBuilder.append(paramQQGiftRspData.e());
          ((GiftBaseSsoCallBack)localObject).a(paramInt, localStringBuilder.toString());
          return;
        }
      }
    }
    try
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onProxyRequestSuccess method:");
        ((StringBuilder)localObject).append(paramQQGiftRspData.b().getServiceCmd());
        QLog.d("BaseSsoCallback", 2, ((StringBuilder)localObject).toString());
      }
      this.a.a(paramInt, paramQQGiftRspData);
      return;
    }
    catch (InvalidProtocolBufferNanoException paramQQGiftRspData)
    {
      label205:
      break label205;
    }
    this.a.a(-1, " transform error: InvalidProtocolBufferNanoException ");
    return;
    this.a.a(-1, "the data is null");
    return;
    if (paramQQGiftRspData.b() != null)
    {
      localObject = this.a;
      paramInt = paramQQGiftRspData.b().getResultCode();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("sso fail request: ");
      localStringBuilder.append(paramQQGiftRspData.b().getServiceCmd());
      ((GiftBaseSsoCallBack)localObject).a(paramInt, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.sso.QQGiftCallbackObserver
 * JD-Core Version:    0.7.0.1
 */