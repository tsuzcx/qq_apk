package com.tencent.qqmini.proxyimpl;

import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;

class MiniAppProxyImpl$12
  implements ShortcutUtils.AddShortcutCallback
{
  MiniAppProxyImpl$12(MiniAppProxyImpl paramMiniAppProxyImpl, AsyncResult paramAsyncResult) {}
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAsyncResult.onReceiveResult(true, null);
      return;
    }
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAsyncResult.onReceiveResult(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.12
 * JD-Core Version:    0.7.0.1
 */