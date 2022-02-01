package com.tencent.mobileqq.qqlive.anchor.room;

import com.tencent.mobileqq.qqlive.anchor.report.QQLiveAnchorTechReport;
import com.tencent.mobileqq.qqlive.anchor.room.helper.AudienceRoomPlayerBaseListener;
import com.tencent.mobileqq.qqlive.api.anchor.QQLiveAnchorRoomState;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;

class QQLiveAnchorThirdPushRoom$1
  extends AudienceRoomPlayerBaseListener
{
  QQLiveAnchorThirdPushRoom$1(QQLiveAnchorThirdPushRoom paramQQLiveAnchorThirdPushRoom) {}
  
  public void onError(int paramInt, String paramString)
  {
    if (!QQLiveAnchorThirdPushRoom.a(this.a))
    {
      if (QQLiveAnchorThirdPushRoom.b(this.a)) {
        return;
      }
      if (this.a.e.ordinal() >= QQLiveAnchorRoomState.STATE_ENTER_ING.ordinal())
      {
        QQLiveErrorMsg localQQLiveErrorMsg = new QQLiveErrorMsg();
        localQQLiveErrorMsg.bizModule = 2;
        localQQLiveErrorMsg.bizErrCode = 6300;
        localQQLiveErrorMsg.bizErrMsg = "living player error";
        localQQLiveErrorMsg.originErrCode = paramInt;
        localQQLiveErrorMsg.originErrMsg = paramString;
        this.a.d.a(localQQLiveErrorMsg);
        if (this.a.k != null) {
          this.a.k.b(localQQLiveErrorMsg);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorThirdPushRoom.1
 * JD-Core Version:    0.7.0.1
 */