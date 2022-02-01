package com.tencent.mobileqq.qqlive.api.impl.message;

import com.tencent.mobileqq.qqlive.callback.announce.IQQLiveSetAnnounceCallback;
import com.tencent.mobileqq.qqlive.sso.QQLiveBusinessObserver;
import com.tencent.mobileqq.qqlive.sso.QQLiveRspData;
import com.tencent.qphone.base.util.QLog;

class QQLiveAnnounceMsgServiceImpl$3
  extends QQLiveBusinessObserver
{
  QQLiveAnnounceMsgServiceImpl$3(QQLiveAnnounceMsgServiceImpl paramQQLiveAnnounceMsgServiceImpl, IQQLiveSetAnnounceCallback paramIQQLiveSetAnnounceCallback) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, QQLiveRspData paramQQLiveRspData)
  {
    if (paramBoolean)
    {
      if (QQLiveAnnounceMsgServiceImpl.access$100(this.this$0, this.val$callback, paramQQLiveRspData))
      {
        QLog.e("IQQLiveAnnounceMsgService", 4, "onFollowAnchorFail fail");
        return;
      }
      this.val$callback.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.message.QQLiveAnnounceMsgServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */