package com.tencent.mobileqq.mini.appbrand.ui;

import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class CapsuleButton$5
  implements EIPCResultCallback
{
  CapsuleButton$5(CapsuleButton paramCapsuleButton, MiniAppInfo paramMiniAppInfo) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.code == -100))
    {
      AppBrandTask.runTaskOnUiThread(new CapsuleButton.5.1(this));
      return;
    }
    CapsuleButton.access$700(this.this$0, this.val$miniAppInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.CapsuleButton.5
 * JD-Core Version:    0.7.0.1
 */