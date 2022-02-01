package com.tencent.mobileqq.qqlive.anchor.room;

import com.tencent.mobileqq.qqlive.anchor.report.QQLiveAnchorTechReport;
import com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;

class QQLiveAnchorRoom$9
  implements ExitRoomCallback
{
  QQLiveAnchorRoom$9(QQLiveAnchorRoom paramQQLiveAnchorRoom, ExitRoomCallback paramExitRoomCallback) {}
  
  public void onComplete(int paramInt, String paramString)
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((ExitRoomCallback)localObject).onComplete(paramInt, paramString);
    }
    if (this.b.k != null)
    {
      localObject = new QQLiveErrorMsg();
      ((QQLiveErrorMsg)localObject).bizModule = 2;
      ((QQLiveErrorMsg)localObject).bizErrCode = paramInt;
      ((QQLiveErrorMsg)localObject).bizErrMsg = paramString;
      paramString = this.b.k;
      boolean bool;
      if (paramInt == 0) {
        bool = true;
      } else {
        bool = false;
      }
      paramString.e(bool, (QQLiveErrorMsg)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorRoom.9
 * JD-Core Version:    0.7.0.1
 */