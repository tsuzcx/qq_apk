package com.tencent.mobileqq.qqlive.api.impl.message;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback;
import com.tencent.mobileqq.qqlive.sso.QQLiveBusinessObserver;
import com.tencent.mobileqq.qqlive.sso.QQLiveRspData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.qlive.relationchain_svr.relationchain_svr.nano.ChkFollowRsp;

class QQLiveFollowMsgServiceImpl$4
  extends QQLiveBusinessObserver
{
  QQLiveFollowMsgServiceImpl$4(QQLiveFollowMsgServiceImpl paramQQLiveFollowMsgServiceImpl, IQQLiveCheckFollowCallback paramIQQLiveCheckFollowCallback) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, QQLiveRspData paramQQLiveRspData)
  {
    if (paramBoolean)
    {
      if (QQLiveFollowMsgServiceImpl.access$200(this.this$0, this.val$checkFollowCallback, paramQQLiveRspData))
      {
        QLog.e("IQQLiveFollowMsgService", 4, "onCheckFollowAnchorFail fail");
        return;
      }
      try
      {
        paramQQLiveRspData = ChkFollowRsp.a(paramQQLiveRspData.a());
        this.val$checkFollowCallback.a(paramQQLiveRspData.a);
        return;
      }
      catch (InvalidProtocolBufferNanoException paramQQLiveRspData)
      {
        this.val$checkFollowCallback.a(-1, "ChkFollowRsp parse fail");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ChkFollowRsp error:");
        localStringBuilder.append(paramQQLiveRspData.getMessage());
        QLog.e("IQQLiveFollowMsgService", 4, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.message.QQLiveFollowMsgServiceImpl.4
 * JD-Core Version:    0.7.0.1
 */