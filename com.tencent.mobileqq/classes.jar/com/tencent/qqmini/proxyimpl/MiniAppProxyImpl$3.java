package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class MiniAppProxyImpl$3
  implements EIPCResultCallback
{
  MiniAppProxyImpl$3(MiniAppProxyImpl paramMiniAppProxyImpl, MiniAppInfo paramMiniAppInfo) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.code == -100))
    {
      AppBrandTask.runTaskOnUiThread(new MiniAppProxyImpl.3.1(this));
      return;
    }
    MiniAppProxyImpl.access$500(this.this$0, this.val$miniAppInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.3
 * JD-Core Version:    0.7.0.1
 */