package com.tencent.mobileqq.qqlive.anchor.prepare;

import com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorRoomCallbackWrapper;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomThirdPushCallback;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;

class QQLiveAnchorPrepareWrapper$1
  extends QQLiveAnchorRoomCallbackWrapper
{
  QQLiveAnchorPrepareWrapper$1(QQLiveAnchorPrepareWrapper paramQQLiveAnchorPrepareWrapper, IQQLiveAnchorRoomThirdPushCallback paramIQQLiveAnchorRoomThirdPushCallback)
  {
    super(paramIQQLiveAnchorRoomThirdPushCallback);
  }
  
  public void a(QQLiveAnchorDataPrepare paramQQLiveAnchorDataPrepare)
  {
    if (paramQQLiveAnchorDataPrepare.isSuccess)
    {
      QQLiveAnchorPrepareWrapper.a(this.a).roomData = paramQQLiveAnchorDataPrepare.roomInfo;
      QQLiveAnchorPrepareWrapper.a(this.a).roomAttr = paramQQLiveAnchorDataPrepare.roomAttr;
    }
    super.a(paramQQLiveAnchorDataPrepare);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.prepare.QQLiveAnchorPrepareWrapper.1
 * JD-Core Version:    0.7.0.1
 */