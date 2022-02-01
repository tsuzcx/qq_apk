package com.tencent.mobileqq.minigame.publicaccount.utils;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.SpecialProxy.EventCallback;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "result", "Leipc/EIPCResult;", "kotlin.jvm.PlatformType", "onCallback"}, k=3, mv={1, 1, 16})
final class AuthDialogPAUtil$getMiniGamePASubMsg$callback$1
  implements EIPCResultCallback
{
  AuthDialogPAUtil$getMiniGamePASubMsg$callback$1(SpecialProxy.EventCallback paramEventCallback) {}
  
  public final void onCallback(EIPCResult paramEIPCResult)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[isFollow] onCallback=");
      localStringBuilder.append(paramEIPCResult.code);
      QLog.d("AuthDialogPAUtil", 2, localStringBuilder.toString());
    }
    boolean bool;
    if (paramEIPCResult.code == 0) {
      bool = paramEIPCResult.data.getBoolean("pa_is_follow");
    } else {
      bool = false;
    }
    if (!bool)
    {
      paramEIPCResult = new Bundle();
      paramEIPCResult.putByteArray("key_bundle_data", AuthDialogPAUtil.access$getMiniGamePASubMsg(AuthDialogPAUtil.INSTANCE));
      this.$eventCallback.onResult(true, paramEIPCResult);
      return;
    }
    this.$eventCallback.onResult(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.utils.AuthDialogPAUtil.getMiniGamePASubMsg.callback.1
 * JD-Core Version:    0.7.0.1
 */