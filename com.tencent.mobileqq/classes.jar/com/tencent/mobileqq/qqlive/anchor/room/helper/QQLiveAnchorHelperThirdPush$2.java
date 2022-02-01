package com.tencent.mobileqq.qqlive.anchor.room.helper;

import com.tencent.mobileqq.qqlive.anchor.room.sso.QQLiveAnchorSSO.Callback;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomThirdPushCallback;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPullInfo;

class QQLiveAnchorHelperThirdPush$2
  implements QQLiveAnchorSSO.Callback<QQLiveAnchorDataPullInfo>
{
  QQLiveAnchorHelperThirdPush$2(QQLiveAnchorHelperThirdPush paramQQLiveAnchorHelperThirdPush, QQLiveAnchorRoomInfo paramQQLiveAnchorRoomInfo, IQQLiveAnchorRoomThirdPushCallback paramIQQLiveAnchorRoomThirdPushCallback) {}
  
  public void a(QQLiveAnchorDataPullInfo paramQQLiveAnchorDataPullInfo)
  {
    if (paramQQLiveAnchorDataPullInfo.isSuccess) {
      this.a.thirdPullInfo = new QQLiveAnchorDataPullInfo(paramQQLiveAnchorDataPullInfo);
    }
    this.b.a(new QQLiveAnchorDataPullInfo(paramQQLiveAnchorDataPullInfo));
    QQLiveAnchorHelperThirdPush.b(this.c, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperThirdPush.2
 * JD-Core Version:    0.7.0.1
 */