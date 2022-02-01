package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.mini.widget.MiniLoadingAdLayout.OnDismissListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener;

class AdProxyImpl$4
  implements MiniLoadingAdLayout.OnDismissListener
{
  AdProxyImpl$4(AdProxyImpl paramAdProxyImpl, AdProxy.ILoadingAdListener paramILoadingAdListener) {}
  
  public void onDismiss(boolean paramBoolean)
  {
    AdProxy.ILoadingAdListener localILoadingAdListener = this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$ILoadingAdListener;
    if (localILoadingAdListener != null) {
      localILoadingAdListener.onAdDismiss(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.4
 * JD-Core Version:    0.7.0.1
 */