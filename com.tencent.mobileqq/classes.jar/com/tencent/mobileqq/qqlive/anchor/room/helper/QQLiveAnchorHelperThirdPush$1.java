package com.tencent.mobileqq.qqlive.anchor.room.helper;

import com.tencent.mobileqq.qqlive.anchor.room.sso.QQLiveAnchorSSO.Callback;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomThirdPushCallback;
import com.tencent.mobileqq.qqlive.data.anchor.params.QQLiveAnchorAutoCheckPullPlayParams;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPushInfo;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;

class QQLiveAnchorHelperThirdPush$1
  implements QQLiveAnchorSSO.Callback<QQLiveAnchorDataPushInfo>
{
  QQLiveAnchorHelperThirdPush$1(QQLiveAnchorHelperThirdPush paramQQLiveAnchorHelperThirdPush, QQLiveAnchorRoomInfo paramQQLiveAnchorRoomInfo, IQQLiveAnchorRoomThirdPushCallback paramIQQLiveAnchorRoomThirdPushCallback, QQLiveAnchorAutoCheckPullPlayParams paramQQLiveAnchorAutoCheckPullPlayParams, IQQLiveSDK paramIQQLiveSDK) {}
  
  public void a(QQLiveAnchorDataPushInfo paramQQLiveAnchorDataPushInfo)
  {
    if (paramQQLiveAnchorDataPushInfo.isSuccess)
    {
      this.a.thirdPushInfo = new QQLiveAnchorDataPushInfo(paramQQLiveAnchorDataPushInfo);
      this.b.a(new QQLiveAnchorDataPushInfo(paramQQLiveAnchorDataPushInfo));
      if (this.c.autoCheckPullPlay) {
        this.e.b(this.d, this.a, this.c, this.b);
      }
    }
    else
    {
      this.b.a(new QQLiveAnchorDataPushInfo(paramQQLiveAnchorDataPushInfo));
      this.b.a(new QQLiveErrorMsg(paramQQLiveAnchorDataPushInfo.errorMsg));
    }
    QQLiveAnchorHelperThirdPush.a(this.e, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperThirdPush.1
 * JD-Core Version:    0.7.0.1
 */