package com.tencent.mobileqq.qqlive.push;

import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.sso.QQLiveBusinessObserver;
import com.tencent.mobileqq.qqlive.sso.QQLiveRspData;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.ilive.roomMsgReadSvr.roomMsgReadSvr.nano.PullMsgRsp;

class LiveRoomPushManager$2
  extends QQLiveBusinessObserver
{
  LiveRoomPushManager$2(LiveRoomPushManager paramLiveRoomPushManager) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, QQLiveRspData paramQQLiveRspData)
  {
    if (LiveRoomPushManager.b(this.a).isDestroyed()) {
      return;
    }
    if (paramBoolean) {
      if (paramQQLiveRspData == null) {
        return;
      }
    }
    try
    {
      if (paramQQLiveRspData.a() == null) {
        return;
      }
      paramQQLiveRspData = PullMsgRsp.a(paramQQLiveRspData.a());
      LiveRoomPushManager.a(this.a, paramQQLiveRspData);
      return;
    }
    catch (Exception paramQQLiveRspData)
    {
      label50:
      StringBuilder localStringBuilder;
      break label50;
    }
    QLog.e("LiveRoomPushManager", 4, "pushToPull onErrorInvalidProtocolBufferException");
    return;
    if (paramQQLiveRspData == null) {
      return;
    }
    if (paramQQLiveRspData.b() == null) {
      return;
    }
    if ((paramQQLiveRspData.b().getResultCode() != 1002) && (paramQQLiveRspData.b().getResultCode() != 1003))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("push2Pull onError at ");
      localStringBuilder.append(paramQQLiveRspData.b().toString());
      QLog.e("LiveRoomPushManager", 4, localStringBuilder.toString());
      return;
    }
    QLog.e("LiveRoomPushManager", 4, "QQLive push message onError Time out");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.push.LiveRoomPushManager.2
 * JD-Core Version:    0.7.0.1
 */