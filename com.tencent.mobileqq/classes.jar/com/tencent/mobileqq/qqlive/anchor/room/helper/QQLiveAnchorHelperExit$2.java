package com.tencent.mobileqq.qqlive.anchor.room.helper;

import com.tencent.mobileqq.qqlive.anchor.util.QQLiveAnchorSSOHelper;
import com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback;
import com.tencent.mobileqq.qqlive.sso.QQLiveBusinessObserver;
import com.tencent.mobileqq.qqlive.sso.QQLiveRspData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.protobuf.iliveRoomPlay.nano.ShutLiveRsp;

final class QQLiveAnchorHelperExit$2
  extends QQLiveBusinessObserver
{
  QQLiveAnchorHelperExit$2(ExitRoomCallback paramExitRoomCallback) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, QQLiveRspData paramQQLiveRspData)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("shutlive, type:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", success:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("QQLiveAnchor_Exit", 1, ((StringBuilder)localObject).toString());
    }
    try
    {
      QQLiveAnchorSSOHelper.a(paramInt, paramBoolean, paramQQLiveRspData);
      paramQQLiveRspData = ShutLiveRsp.a(paramQQLiveRspData.a());
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("shutlive, result: ");
        ((StringBuilder)localObject).append(paramQQLiveRspData.a);
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(paramQQLiveRspData.b);
        QLog.d("QQLiveAnchor_Exit", 1, ((StringBuilder)localObject).toString());
      }
      if (this.a != null)
      {
        this.a.onComplete(0, "");
        return;
      }
    }
    catch (Throwable paramQQLiveRspData)
    {
      QLog.e("QQLiveAnchor_Exit", 1, "shutlive error: ", paramQQLiveRspData);
      localObject = this.a;
      if (localObject != null) {
        ((ExitRoomCallback)localObject).onComplete(-1, paramQQLiveRspData.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperExit.2
 * JD-Core Version:    0.7.0.1
 */