package com.tencent.mobileqq.qqlive.anchor.room.helper;

import com.tencent.mobileqq.qqlive.anchor.util.QQLiveAnchorSSOHelper;
import com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback;
import com.tencent.mobileqq.qqlive.sso.QQLiveBusinessObserver;
import com.tencent.mobileqq.qqlive.sso.QQLiveRspData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano.EndNewRsp;

final class QQLiveAnchorHelperExit$3
  extends QQLiveBusinessObserver
{
  QQLiveAnchorHelperExit$3(ExitRoomCallback paramExitRoomCallback) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, QQLiveRspData paramQQLiveRspData)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("endnewreq, type:");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(", success:");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("QQLiveAnchor_Exit", 1, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      QQLiveAnchorSSOHelper.a(paramInt, paramBoolean, paramQQLiveRspData);
      localObject1 = localObject2;
      paramQQLiveRspData = EndNewRsp.a(paramQQLiveRspData.a());
      localObject1 = paramQQLiveRspData;
      localObject2 = paramQQLiveRspData;
      if (QLog.isColorLevel())
      {
        localObject1 = paramQQLiveRspData;
        localObject2 = new StringBuilder();
        localObject1 = paramQQLiveRspData;
        ((StringBuilder)localObject2).append("endnewreq, result: ");
        localObject1 = paramQQLiveRspData;
        ((StringBuilder)localObject2).append(paramQQLiveRspData.a);
        localObject1 = paramQQLiveRspData;
        QLog.d("QQLiveAnchor_Exit", 1, ((StringBuilder)localObject2).toString());
        localObject2 = paramQQLiveRspData;
      }
    }
    catch (Throwable paramQQLiveRspData)
    {
      QLog.e("QQLiveAnchor_Exit", 1, "endnewreq error: ", paramQQLiveRspData);
      localObject2 = localObject1;
    }
    if (localObject2 == null)
    {
      paramQQLiveRspData = this.a;
      if (paramQQLiveRspData != null) {
        paramQQLiveRspData.onComplete(5108, "response is null");
      }
    }
    else
    {
      paramQQLiveRspData = this.a;
      if (paramQQLiveRspData != null) {
        paramQQLiveRspData.onComplete(((EndNewRsp)localObject2).a, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperExit.3
 * JD-Core Version:    0.7.0.1
 */