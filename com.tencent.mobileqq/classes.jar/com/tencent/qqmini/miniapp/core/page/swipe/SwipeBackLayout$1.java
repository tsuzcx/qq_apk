package com.tencent.qqmini.miniapp.core.page.swipe;

import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy;

class SwipeBackLayout$1
  implements Runnable
{
  SwipeBackLayout$1(SwipeBackLayout paramSwipeBackLayout) {}
  
  public void run()
  {
    if (this.this$0.mPageGuestProxy == null) {
      this.this$0.mPageGuestProxy = ((PageGestureProxy)ProxyManager.get(PageGestureProxy.class));
    }
    if (this.this$0.mPageGuestProxy != null) {
      this.this$0.mPageGuestProxy.onPageWebViewInit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.swipe.SwipeBackLayout.1
 * JD-Core Version:    0.7.0.1
 */