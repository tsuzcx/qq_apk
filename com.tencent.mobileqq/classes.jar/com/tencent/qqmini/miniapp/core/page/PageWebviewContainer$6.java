package com.tencent.qqmini.miniapp.core.page;

import com.tencent.qqmini.miniapp.core.page.widget.MiniSwipeRefreshLayout;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class PageWebviewContainer$6
  implements Runnable
{
  PageWebviewContainer$6(PageWebviewContainer paramPageWebviewContainer, boolean paramBoolean, NativeViewRequestEvent paramNativeViewRequestEvent) {}
  
  public void run()
  {
    if ((PageWebviewContainer.access$500(this.this$0)) && (PageWebviewContainer.access$300(this.this$0) != null) && (!PageWebviewContainer.access$300(this.this$0).isRefreshing()))
    {
      PageWebviewContainer.access$300(this.this$0).setEnabled(this.val$disableRefresh ^ true);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setDisablePullDownRefresh !disable ");
      localStringBuilder.append(this.val$disableRefresh ^ true);
      QMLog.d("PageWebviewContainer", localStringBuilder.toString());
    }
    this.val$req.ok();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.PageWebviewContainer.6
 * JD-Core Version:    0.7.0.1
 */