package com.tencent.qqmini.proxyimpl;

import android.content.Intent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;

class ChannelProxyImpl$7
  implements IActivityResultListener
{
  ChannelProxyImpl$7(ChannelProxyImpl paramChannelProxyImpl, IActivityResultManager paramIActivityResultManager, AsyncResult paramAsyncResult) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = false;
    if (paramInt1 == 9)
    {
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherShellIActivityResultManager.removeActivityResultListener(this);
      paramIntent = this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAsyncResult;
      if (paramInt2 == 0) {
        bool = true;
      }
      paramIntent.onReceiveResult(bool, null);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ChannelProxyImpl.7
 * JD-Core Version:    0.7.0.1
 */