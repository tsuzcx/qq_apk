package com.tencent.mobileqq.minigame.publicaccount.utils;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.SpecialProxy.EventCallback;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "result", "Leipc/EIPCResult;", "kotlin.jvm.PlatformType", "onCallback"}, k=3, mv={1, 1, 16})
final class AuthDialogPAUtil$followMiniGamePA$callback$1
  implements EIPCResultCallback
{
  AuthDialogPAUtil$followMiniGamePA$callback$1(SpecialProxy.EventCallback paramEventCallback) {}
  
  public final void onCallback(EIPCResult paramEIPCResult)
  {
    int i = paramEIPCResult.code;
    int j = paramEIPCResult.code;
    boolean bool = false;
    if (j == 0) {
      if (paramEIPCResult.data.getBoolean("pa_result_code"))
      {
        i = 0;
      }
      else
      {
        i = -1;
        QLog.e("AuthDialogPAUtil", 1, "[followPublicAccount] followPA error");
      }
    }
    if (QLog.isColorLevel())
    {
      paramEIPCResult = new StringBuilder();
      paramEIPCResult.append("[followPublicAccount] onCallback errCode");
      paramEIPCResult.append(i);
      QLog.d("AuthDialogPAUtil", 2, paramEIPCResult.toString());
    }
    paramEIPCResult = this.$eventCallback;
    if (paramEIPCResult != null)
    {
      if (i == 0) {
        bool = true;
      }
      paramEIPCResult.onResult(bool, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.utils.AuthDialogPAUtil.followMiniGamePA.callback.1
 * JD-Core Version:    0.7.0.1
 */