package com.tencent.mobileqq.qqlive.anchor.room.helper;

import com.tencent.mobileqq.qqlive.anchor.util.QQLiveAnchorSSOHelper;
import com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback;
import com.tencent.mobileqq.qqlive.sso.QQLiveBusinessObserver;
import com.tencent.mobileqq.qqlive.sso.QQLiveRspData;
import com.tencent.qphone.base.util.QLog;

final class QQLiveAnchorHelperExit$1
  extends QQLiveBusinessObserver
{
  QQLiveAnchorHelperExit$1(ExitRoomCallback paramExitRoomCallback) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, QQLiveRspData paramQQLiveRspData)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("leavelive recieve, type:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", success:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("QQLiveAnchor_Exit", 1, ((StringBuilder)localObject).toString());
    }
    try
    {
      QQLiveAnchorSSOHelper.a(paramInt, paramBoolean, paramQQLiveRspData);
      if (this.a != null)
      {
        this.a.onComplete(0, "");
        return;
      }
    }
    catch (Throwable paramQQLiveRspData)
    {
      localObject = this.a;
      if (localObject != null) {
        ((ExitRoomCallback)localObject).onComplete(-1, paramQQLiveRspData.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperExit.1
 * JD-Core Version:    0.7.0.1
 */