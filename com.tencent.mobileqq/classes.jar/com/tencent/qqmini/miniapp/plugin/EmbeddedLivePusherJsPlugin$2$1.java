package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.miniapp.core.page.AppBrandPage;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.widget.NavigationBar;
import com.tencent.qqmini.sdk.widget.TabBar;

class EmbeddedLivePusherJsPlugin$2$1
  implements Runnable
{
  EmbeddedLivePusherJsPlugin$2$1(EmbeddedLivePusherJsPlugin.2 param2, AppBrandPage paramAppBrandPage) {}
  
  public void run()
  {
    this.val$showingPage.getNavBar().setVisibility(EmbeddedLivePusherJsPlugin.access$000(this.this$1.this$0));
    this.val$showingPage.getTabBar().setVisibility(EmbeddedLivePusherJsPlugin.access$100(this.this$1.this$0));
    EmbeddedLivePusherJsPlugin.access$200(this.this$1.this$0);
    this.this$1.val$req.ok();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.EmbeddedLivePusherJsPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */