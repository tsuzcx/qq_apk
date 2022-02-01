package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.miniapp.core.page.AppBrandPage;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.widget.NavigationBar;
import com.tencent.qqmini.sdk.widget.TabBar;

class EmbeddedLivePusherJsPlugin$3$1
  implements Runnable
{
  EmbeddedLivePusherJsPlugin$3$1(EmbeddedLivePusherJsPlugin.3 param3, AppBrandPage paramAppBrandPage) {}
  
  public void run()
  {
    EmbeddedLivePusherJsPlugin.access$002(this.this$1.this$0, this.val$showingPage.getNavBar().getVisibility());
    this.val$showingPage.getNavBar().setVisibility(8);
    EmbeddedLivePusherJsPlugin.access$102(this.this$1.this$0, this.val$showingPage.getTabBar().getVisibility());
    this.val$showingPage.getTabBar().setVisibility(8);
    EmbeddedLivePusherJsPlugin.access$400(this.this$1.this$0, EmbeddedLivePusherJsPlugin.access$300(this.this$1.this$0).getAttachedActivity());
    this.this$1.val$req.ok();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.EmbeddedLivePusherJsPlugin.3.1
 * JD-Core Version:    0.7.0.1
 */