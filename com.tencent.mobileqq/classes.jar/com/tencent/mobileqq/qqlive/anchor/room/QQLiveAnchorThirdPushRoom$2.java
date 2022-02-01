package com.tencent.mobileqq.qqlive.anchor.room;

import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomThirdPushCallback;
import com.tencent.mobileqq.qqlive.data.anchor.params.QQLiveAnchorAutoCheckPullPlayParams;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPullInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataThirdPushCheck;

class QQLiveAnchorThirdPushRoom$2
  extends QQLiveAnchorRoomCallbackWrapper
{
  QQLiveAnchorThirdPushRoom$2(QQLiveAnchorThirdPushRoom paramQQLiveAnchorThirdPushRoom, IQQLiveAnchorRoomThirdPushCallback paramIQQLiveAnchorRoomThirdPushCallback, QQLiveAnchorAutoCheckPullPlayParams paramQQLiveAnchorAutoCheckPullPlayParams)
  {
    super(paramIQQLiveAnchorRoomThirdPushCallback);
  }
  
  public void a(QQLiveAnchorDataPullInfo paramQQLiveAnchorDataPullInfo)
  {
    super.a(paramQQLiveAnchorDataPullInfo);
    QQLiveAnchorThirdPushRoom.a(this.b, this.a, paramQQLiveAnchorDataPullInfo.defaultPlayUrl, this);
  }
  
  public void a(QQLiveAnchorDataThirdPushCheck paramQQLiveAnchorDataThirdPushCheck)
  {
    super.a(paramQQLiveAnchorDataThirdPushCheck);
    QQLiveAnchorThirdPushRoom.c(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorThirdPushRoom.2
 * JD-Core Version:    0.7.0.1
 */