package com.tencent.mobileqq.qqlive.anchor.room.helper;

import android.app.Activity;
import com.tencent.mobileqq.qqlive.anchor.room.sso.QQLiveAnchorSSO;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.verified.IQQLiveVerifyService;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomPrepare;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;
import com.tencent.mobileqq.qqlive.utils.MachineUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.protobuf.iliveRoomPlay.nano.PrepareReq;

public class QQLiveAnchorHelperPrepare
{
  private boolean a = false;
  
  private void a(Activity paramActivity, IQQLiveSDK paramIQQLiveSDK, IQQLiveAnchorRoomPrepare paramIQQLiveAnchorRoomPrepare, QQLiveAnchorDataPrepare paramQQLiveAnchorDataPrepare)
  {
    try
    {
      if (paramQQLiveAnchorDataPrepare.isSuccess)
      {
        paramIQQLiveAnchorRoomPrepare.a(new QQLiveAnchorDataPrepare(paramQQLiveAnchorDataPrepare));
        return;
      }
      if ((paramQQLiveAnchorDataPrepare.errorMsg != null) && (paramQQLiveAnchorDataPrepare.errorMsg.originErrCode == 1004))
      {
        b(paramActivity, paramIQQLiveSDK, paramIQQLiveAnchorRoomPrepare);
        return;
      }
      paramIQQLiveAnchorRoomPrepare.a(new QQLiveAnchorDataPrepare(paramQQLiveAnchorDataPrepare));
      paramIQQLiveAnchorRoomPrepare.a(new QQLiveErrorMsg(paramQQLiveAnchorDataPrepare.errorMsg));
      return;
    }
    catch (Throwable paramActivity)
    {
      QLog.e("QQLiveAnchor_Prepare", 1, paramActivity, new Object[0]);
    }
  }
  
  private void b(Activity paramActivity, IQQLiveSDK paramIQQLiveSDK, IQQLiveAnchorRoomPrepare paramIQQLiveAnchorRoomPrepare)
  {
    try
    {
      paramIQQLiveAnchorRoomPrepare.f();
      paramIQQLiveSDK.getQQLiveVerifyModule().goToVerified(paramActivity, new QQLiveAnchorHelperPrepare.2(this, paramIQQLiveAnchorRoomPrepare, paramActivity, paramIQQLiveSDK));
      return;
    }
    catch (Throwable paramActivity)
    {
      QLog.e("QQLiveAnchor_Prepare", 1, paramActivity, new Object[0]);
    }
  }
  
  public void a(Activity paramActivity, IQQLiveSDK paramIQQLiveSDK, IQQLiveAnchorRoomPrepare paramIQQLiveAnchorRoomPrepare)
  {
    if (this.a)
    {
      QLog.e("QQLiveAnchor_Prepare", 1, "preparing, ignore");
      return;
    }
    this.a = true;
    try
    {
      paramIQQLiveAnchorRoomPrepare.b();
      PrepareReq localPrepareReq = new PrepareReq();
      localPrepareReq.b = MachineUtil.a();
      QQLiveAnchorSSO.a(paramIQQLiveSDK, localPrepareReq, new QQLiveAnchorHelperPrepare.1(this, paramActivity, paramIQQLiveSDK, paramIQQLiveAnchorRoomPrepare));
      return;
    }
    catch (Throwable paramActivity)
    {
      QLog.e("QQLiveAnchor_Prepare", 1, paramActivity, new Object[0]);
      this.a = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperPrepare
 * JD-Core Version:    0.7.0.1
 */