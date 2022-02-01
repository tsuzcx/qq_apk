package com.tencent.mobileqq.qqlive.api.impl.message;

import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback;
import com.tencent.mobileqq.qqlive.sso.QQLiveBusinessObserver;
import com.tencent.mobileqq.qqlive.sso.QQLiveRspData;
import com.tencent.qphone.base.util.QLog;

class QQLiveFollowMsgServiceImpl$2
  extends QQLiveBusinessObserver
{
  QQLiveFollowMsgServiceImpl$2(QQLiveFollowMsgServiceImpl paramQQLiveFollowMsgServiceImpl, IQQLiveFollowCallback paramIQQLiveFollowCallback) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, QQLiveRspData paramQQLiveRspData)
  {
    if (paramBoolean)
    {
      if (QQLiveFollowMsgServiceImpl.access$100(this.this$0, this.val$followCallback, paramQQLiveRspData))
      {
        QLog.e("IQQLiveFollowMsgService", 4, "onFollowAnchorFail fail");
        return;
      }
      this.val$followCallback.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.message.QQLiveFollowMsgServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */