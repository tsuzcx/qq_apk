package com.tencent.qqmini.miniapp.core.page;

import android.support.v4.widget.SwipeRefreshLayout;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class PageWebviewContainer$6
  implements Runnable
{
  PageWebviewContainer$6(PageWebviewContainer paramPageWebviewContainer, boolean paramBoolean, NativeViewRequestEvent paramNativeViewRequestEvent) {}
  
  public void run()
  {
    boolean bool2 = true;
    Object localObject;
    if ((PageWebviewContainer.access$500(this.this$0)) && (PageWebviewContainer.access$300(this.this$0) != null) && (!PageWebviewContainer.access$300(this.this$0).isRefreshing()))
    {
      localObject = PageWebviewContainer.access$300(this.this$0);
      if (this.val$disableRefresh) {
        break label101;
      }
      bool1 = true;
      ((SwipeRefreshLayout)localObject).setEnabled(bool1);
      localObject = new StringBuilder().append("setDisablePullDownRefresh !disable ");
      if (this.val$disableRefresh) {
        break label106;
      }
    }
    label101:
    label106:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      QMLog.d("PageWebviewContainer", bool1);
      this.val$req.ok();
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.PageWebviewContainer.6
 * JD-Core Version:    0.7.0.1
 */