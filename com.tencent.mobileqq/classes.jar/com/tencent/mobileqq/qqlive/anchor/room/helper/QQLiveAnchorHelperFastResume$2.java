package com.tencent.mobileqq.qqlive.anchor.room.helper;

import com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomThirdPushCallback;
import com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataEnter;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataFastResume;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataInit;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPublishStream;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataThirdPushCheck;
import com.tencent.qphone.base.util.QLog;

class QQLiveAnchorHelperFastResume$2
  extends QQLiveAnchorRoomThirdPushBaseCallback
{
  QQLiveAnchorHelperFastResume$2(QQLiveAnchorHelperFastResume paramQQLiveAnchorHelperFastResume, QQLiveAnchorRoom paramQQLiveAnchorRoom, IQQLiveAnchorRoomThirdPushCallback paramIQQLiveAnchorRoomThirdPushCallback) {}
  
  public void a(QQLiveAnchorDataEnter paramQQLiveAnchorDataEnter)
  {
    if (!this.a.isDestroyed())
    {
      if (this.a.isExitRoom()) {
        return;
      }
      super.a(paramQQLiveAnchorDataEnter);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onEnter:");
        localStringBuilder.append(paramQQLiveAnchorDataEnter.isSuccess);
        QLog.i("QQLiveAnchor_fastResume", 1, localStringBuilder.toString());
      }
      if (paramQQLiveAnchorDataEnter.isSuccess)
      {
        this.a.startPublishStream();
        return;
      }
      this.b.a(new QQLiveAnchorDataFastResume(paramQQLiveAnchorDataEnter));
    }
  }
  
  public void a(QQLiveAnchorDataInit paramQQLiveAnchorDataInit)
  {
    if (!this.a.isDestroyed())
    {
      if (this.a.isExitRoom()) {
        return;
      }
      if (paramQQLiveAnchorDataInit.isSuccess)
      {
        this.c.b(this.a, this.b);
        return;
      }
      this.b.a(new QQLiveAnchorDataFastResume(paramQQLiveAnchorDataInit));
    }
  }
  
  public void a(QQLiveAnchorDataPublishStream paramQQLiveAnchorDataPublishStream)
  {
    super.a(paramQQLiveAnchorDataPublishStream);
    this.b.a(new QQLiveAnchorDataFastResume(paramQQLiveAnchorDataPublishStream));
  }
  
  public void a(QQLiveAnchorDataThirdPushCheck paramQQLiveAnchorDataThirdPushCheck)
  {
    if (!this.a.isDestroyed())
    {
      if (this.a.isExitRoom()) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onGetPullInfo:");
        localStringBuilder.append(paramQQLiveAnchorDataThirdPushCheck.isSuccess);
        QLog.i("QQLiveAnchor_fastResume", 1, localStringBuilder.toString());
      }
      if (paramQQLiveAnchorDataThirdPushCheck.isSuccess)
      {
        this.a.enterRoom();
        return;
      }
      this.b.a(new QQLiveAnchorDataFastResume(paramQQLiveAnchorDataThirdPushCheck));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperFastResume.2
 * JD-Core Version:    0.7.0.1
 */