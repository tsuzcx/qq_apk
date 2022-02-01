package com.tencent.mobileqq.qqlive.anchor.room;

import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomThirdPushCallback;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomAttr;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomInfo;

class QQLiveAnchorRoom$3
  extends QQLiveAnchorRoomCallbackWrapper
{
  QQLiveAnchorRoom$3(QQLiveAnchorRoom paramQQLiveAnchorRoom, IQQLiveAnchorRoomThirdPushCallback paramIQQLiveAnchorRoomThirdPushCallback)
  {
    super(paramIQQLiveAnchorRoomThirdPushCallback);
  }
  
  public void a(QQLiveAnchorDataPrepare paramQQLiveAnchorDataPrepare)
  {
    this.a.c.roomAttr = new QQLiveAnchorDataRoomAttr(paramQQLiveAnchorDataPrepare.roomAttr);
    this.a.c.roomData = new QQLiveAnchorDataRoomInfo(paramQQLiveAnchorDataPrepare.roomInfo);
    super.a(paramQQLiveAnchorDataPrepare);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorRoom.3
 * JD-Core Version:    0.7.0.1
 */