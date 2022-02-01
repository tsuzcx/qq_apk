package com.tencent.mobileqq.qqlive.api.impl.message;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.mobileqq.qqlive.callback.announce.IQQLiveGetAnnounceCallback;
import com.tencent.mobileqq.qqlive.sso.QQLiveBusinessObserver;
import com.tencent.mobileqq.qqlive.sso.QQLiveRspData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.qlive.live_lottery_server.announce.nano.GetAnnounceRsp;

class QQLiveAnnounceMsgServiceImpl$4
  extends QQLiveBusinessObserver
{
  QQLiveAnnounceMsgServiceImpl$4(QQLiveAnnounceMsgServiceImpl paramQQLiveAnnounceMsgServiceImpl, IQQLiveGetAnnounceCallback paramIQQLiveGetAnnounceCallback) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, QQLiveRspData paramQQLiveRspData)
  {
    if (paramBoolean)
    {
      if (QQLiveAnnounceMsgServiceImpl.access$200(this.this$0, this.val$callback, paramQQLiveRspData))
      {
        QLog.e("IQQLiveAnnounceMsgService", 4, "onCheckFollowAnchorFail fail");
        return;
      }
      try
      {
        paramQQLiveRspData = GetAnnounceRsp.a(paramQQLiveRspData.a());
        this.val$callback.a(paramQQLiveRspData.a);
        return;
      }
      catch (InvalidProtocolBufferNanoException paramQQLiveRspData)
      {
        this.val$callback.a(-1, "GetFollowListRsp parse fail");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("GetAnnounceRsp error:");
        localStringBuilder.append(paramQQLiveRspData.getMessage());
        QLog.e("IQQLiveAnnounceMsgService", 4, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.message.QQLiveAnnounceMsgServiceImpl.4
 * JD-Core Version:    0.7.0.1
 */