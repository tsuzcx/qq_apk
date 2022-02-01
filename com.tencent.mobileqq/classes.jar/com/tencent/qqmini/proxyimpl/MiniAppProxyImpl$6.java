package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class MiniAppProxyImpl$6
  implements EIPCResultCallback
{
  MiniAppProxyImpl$6(MiniAppProxyImpl paramMiniAppProxyImpl, MiniAppInfo paramMiniAppInfo) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.code == -100))
    {
      AppBrandTask.runTaskOnUiThread(new MiniAppProxyImpl.6.1(this));
      return;
    }
    MiniAppProxyImpl.b(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniAppProxyImpl, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.6
 * JD-Core Version:    0.7.0.1
 */