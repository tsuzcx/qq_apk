package com.tencent.mobileqq.mini.appbrand.ui;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class MiniBaseActivity$1
  implements EIPCResultCallback
{
  MiniBaseActivity$1(MiniBaseActivity paramMiniBaseActivity) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.data == null) {}
    do
    {
      return;
      switch (paramEIPCResult.data.getInt("param_cmd"))
      {
      default: 
        return;
      }
    } while (paramEIPCResult.code != 0);
    paramEIPCResult = paramEIPCResult.data;
    if (QLog.isDevelopLevel())
    {
      int i = paramEIPCResult.getInt("param_proc_badge_count");
      QLog.i("MiniMsgIPCServer", 2, "doRefreshMiniBadge COUNT = " + i);
    }
    this.this$0.doRefreshMiniBadge(paramEIPCResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.MiniBaseActivity.1
 * JD-Core Version:    0.7.0.1
 */