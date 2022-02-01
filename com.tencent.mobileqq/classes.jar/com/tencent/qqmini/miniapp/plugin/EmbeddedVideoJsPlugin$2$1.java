package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.miniapp.core.page.AppBrandPage;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.widget.NavigationBar;
import com.tencent.qqmini.sdk.widget.TabBar;

class EmbeddedVideoJsPlugin$2$1
  implements Runnable
{
  EmbeddedVideoJsPlugin$2$1(EmbeddedVideoJsPlugin.2 param2, AppBrandPage paramAppBrandPage) {}
  
  public void run()
  {
    this.val$showingPage.getNavBar().setVisibility(EmbeddedVideoJsPlugin.access$000(this.this$1.this$0));
    this.val$showingPage.getTabBar().setVisibility(EmbeddedVideoJsPlugin.access$100(this.this$1.this$0));
    EmbeddedVideoJsPlugin.access$400(this.this$1.this$0);
    this.this$1.val$req.ok();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.EmbeddedVideoJsPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */