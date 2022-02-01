package com.tencent.mobileqq.qqlive.anchor.prepare;

import com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorRoomCallbackWrapper;
import com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorThirdPushChecker;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomThirdPushCallback;
import com.tencent.mobileqq.qqlive.data.anchor.params.QQLiveAnchorAutoCheckPullPlayParams;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPullInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataThirdPushCheck;
import com.tencent.qphone.base.util.QLog;

class QQLiveAnchorPrepareThirdPush$1
  extends QQLiveAnchorRoomCallbackWrapper
{
  QQLiveAnchorPrepareThirdPush$1(QQLiveAnchorPrepareThirdPush paramQQLiveAnchorPrepareThirdPush, IQQLiveAnchorRoomThirdPushCallback paramIQQLiveAnchorRoomThirdPushCallback, QQLiveAnchorAutoCheckPullPlayParams paramQQLiveAnchorAutoCheckPullPlayParams)
  {
    super(paramIQQLiveAnchorRoomThirdPushCallback);
  }
  
  public void a(QQLiveAnchorDataPullInfo paramQQLiveAnchorDataPullInfo)
  {
    super.a(paramQQLiveAnchorDataPullInfo);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetPullInfo, isDestory:");
      localStringBuilder.append(QQLiveAnchorPrepareThirdPush.a(this.b));
      QLog.d("QQLiveAnchor_PT", 1, localStringBuilder.toString());
    }
    if (QQLiveAnchorPrepareThirdPush.a(this.b)) {
      return;
    }
    if (this.a.autoCheckPullPlay) {
      this.b.startCheck(paramQQLiveAnchorDataPullInfo.defaultPlayUrl, this.a, this);
    }
  }
  
  public void a(QQLiveAnchorDataThirdPushCheck paramQQLiveAnchorDataThirdPushCheck)
  {
    super.a(paramQQLiveAnchorDataThirdPushCheck);
    if (QLog.isColorLevel())
    {
      paramQQLiveAnchorDataThirdPushCheck = new StringBuilder();
      paramQQLiveAnchorDataThirdPushCheck.append("onThirdPushChecked, isDestory:");
      paramQQLiveAnchorDataThirdPushCheck.append(QQLiveAnchorPrepareThirdPush.a(this.b));
      QLog.d("QQLiveAnchor_PT", 1, paramQQLiveAnchorDataThirdPushCheck.toString());
    }
    if (QQLiveAnchorPrepareThirdPush.a(this.b)) {
      return;
    }
    if (QQLiveAnchorPrepareThirdPush.b(this.b) != null)
    {
      QQLiveAnchorPrepareThirdPush.b(this.b).b(true);
      QQLiveAnchorPrepareThirdPush.a(this.b, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.prepare.QQLiveAnchorPrepareThirdPush.1
 * JD-Core Version:    0.7.0.1
 */