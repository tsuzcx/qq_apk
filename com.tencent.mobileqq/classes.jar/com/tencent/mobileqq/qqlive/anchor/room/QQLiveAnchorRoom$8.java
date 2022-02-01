package com.tencent.mobileqq.qqlive.anchor.room;

import com.tencent.mobileqq.qqlive.anchor.report.QQLiveAnchorTechReport;
import com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;

class QQLiveAnchorRoom$8
  implements ExitRoomCallback
{
  QQLiveAnchorRoom$8(QQLiveAnchorRoom paramQQLiveAnchorRoom) {}
  
  public void onComplete(int paramInt, String paramString)
  {
    if (this.a.k != null)
    {
      QQLiveErrorMsg localQQLiveErrorMsg = new QQLiveErrorMsg();
      localQQLiveErrorMsg.bizModule = 2;
      localQQLiveErrorMsg.bizErrCode = paramInt;
      localQQLiveErrorMsg.bizErrMsg = paramString;
      paramString = this.a.k;
      boolean bool;
      if (paramInt == 0) {
        bool = true;
      } else {
        bool = false;
      }
      paramString.f(bool, localQQLiveErrorMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorRoom.8
 * JD-Core Version:    0.7.0.1
 */