package com.tencent.qqmini.sdk.runtime;

import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class BaseUIProxy$2
  implements Runnable
{
  BaseUIProxy$2(BaseUIProxy paramBaseUIProxy) {}
  
  public void run()
  {
    if (this.this$0.mCurrRuntimeLoader != null)
    {
      this.this$0.mCurrRuntimeLoader.startLoadMiniAppContent(false);
      this.this$0.mCurrRuntimeLoader.onAttachActivity(this.this$0.mActivity, null, this.this$0.mRootLayout);
    }
    this.this$0.hideLoading();
    ChannelProxy localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    if ((localChannelProxy != null) && (this.this$0.mCurrRuntimeLoader.getMiniAppInfo() != null)) {
      localChannelProxy.syncForceGroundAndRefreshBadge(this.this$0.mActivity, this.this$0.mCurrRuntimeLoader.getMiniAppInfo().appId, AppLoaderFactory.g().getProcessName());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.BaseUIProxy.2
 * JD-Core Version:    0.7.0.1
 */