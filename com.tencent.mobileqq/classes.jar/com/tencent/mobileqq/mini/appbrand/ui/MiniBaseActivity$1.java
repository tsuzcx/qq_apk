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
    if (paramEIPCResult.data == null) {
      return;
    }
    if (paramEIPCResult.data.getInt("param_cmd") != 0) {
      return;
    }
    if (paramEIPCResult.code == 0)
    {
      paramEIPCResult = paramEIPCResult.data;
      if (QLog.isDevelopLevel())
      {
        int i = paramEIPCResult.getInt("param_proc_badge_count");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doRefreshMiniBadge COUNT = ");
        localStringBuilder.append(i);
        QLog.i("MiniMsgIPCServer", 2, localStringBuilder.toString());
      }
      this.this$0.doRefreshMiniBadge(paramEIPCResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.MiniBaseActivity.1
 * JD-Core Version:    0.7.0.1
 */