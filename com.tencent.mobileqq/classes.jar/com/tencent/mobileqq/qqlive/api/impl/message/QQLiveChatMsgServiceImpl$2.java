package com.tencent.mobileqq.qqlive.api.impl.message;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback;
import com.tencent.mobileqq.qqlive.sso.QQLiveBusinessObserver;
import com.tencent.mobileqq.qqlive.sso.QQLiveRspData;
import com.tencent.protobuf.iliveWordSvr.nano.NewPublicChatRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;

class QQLiveChatMsgServiceImpl$2
  extends QQLiveBusinessObserver
{
  QQLiveChatMsgServiceImpl$2(QQLiveChatMsgServiceImpl paramQQLiveChatMsgServiceImpl, IQQLiveMessageCallback paramIQQLiveMessageCallback) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, QQLiveRspData paramQQLiveRspData)
  {
    if (this.val$callback == null) {
      return;
    }
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQLiveChatMsgService", 4, "sendMessageReq receive");
      }
      if (paramQQLiveRspData == null)
      {
        QLog.e("QQLiveChatMsgService", 4, "QQLive Gift onReceive QQLiveRspData null");
        return;
      }
      if (paramQQLiveRspData.a() == null)
      {
        QLog.e("QQLiveChatMsgService", 4, "QQLive Gift onReceive data null");
        return;
      }
    }
    try
    {
      paramQQLiveRspData = NewPublicChatRsp.a(paramQQLiveRspData.a());
      if (paramQQLiveRspData.a == 0)
      {
        this.val$callback.a(false);
        return;
      }
      if (paramQQLiveRspData.a == 10002)
      {
        this.val$callback.b();
        return;
      }
      if (paramQQLiveRspData.a == 10003)
      {
        this.val$callback.a();
        return;
      }
      this.val$callback.a(paramQQLiveRspData.a, paramQQLiveRspData.b);
      return;
    }
    catch (InvalidProtocolBufferNanoException paramQQLiveRspData)
    {
      label139:
      Object localObject;
      StringBuilder localStringBuilder;
      break label139;
    }
    QLog.e("QQLiveChatMsgService", 4, "QQLive Gift onReceive data parse fail");
    this.val$callback.a(-1, "QQLive Gift onReceive data parse fail");
    return;
    if (paramQQLiveRspData == null)
    {
      QLog.e("QQLiveChatMsgService", 4, "QQLive Send Message onError QQLiveRspData null");
      return;
    }
    if (paramQQLiveRspData.a() == null)
    {
      QLog.e("QQLiveChatMsgService", 4, "QQLive Send Message onError data null");
      return;
    }
    if ((paramQQLiveRspData.b().getResultCode() == 1002) || (paramQQLiveRspData.b().getResultCode() == 1003))
    {
      QLog.e("QQLiveChatMsgService", 4, "QQLive Send Message onError Time out");
      this.val$callback.a(paramQQLiveRspData.b().getResultCode(), "time out");
    }
    if (paramQQLiveRspData.d() != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("QQLive Send Message onError proxy service err ");
      ((StringBuilder)localObject).append(paramQQLiveRspData.d());
      QLog.e("QQLiveChatMsgService", 4, ((StringBuilder)localObject).toString());
      localObject = this.val$callback;
      paramInt = paramQQLiveRspData.d();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("proxy service err ");
      localStringBuilder.append(paramQQLiveRspData.f());
      ((IQQLiveMessageCallback)localObject).a(paramInt, localStringBuilder.toString());
    }
    if (paramQQLiveRspData.c() != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("QQLive Send Message onError business service err ");
      ((StringBuilder)localObject).append(paramQQLiveRspData.c());
      QLog.e("QQLiveChatMsgService", 4, ((StringBuilder)localObject).toString());
      localObject = this.val$callback;
      paramInt = paramQQLiveRspData.c();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("business service err ");
      localStringBuilder.append(paramQQLiveRspData.f());
      ((IQQLiveMessageCallback)localObject).a(paramInt, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.message.QQLiveChatMsgServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */