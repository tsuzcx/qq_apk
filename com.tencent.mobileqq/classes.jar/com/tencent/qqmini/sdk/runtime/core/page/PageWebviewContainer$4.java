package com.tencent.qqmini.sdk.runtime.core.page;

import android.support.v4.widget.SwipeRefreshLayout;
import bdfs;
import bdnw;

class PageWebviewContainer$4
  implements Runnable
{
  PageWebviewContainer$4(PageWebviewContainer paramPageWebviewContainer, bdfs parambdfs) {}
  
  public void run()
  {
    if ((PageWebviewContainer.a(this.this$0) != null) && (PageWebviewContainer.a(this.this$0).isRefreshing()))
    {
      PageWebviewContainer.a(this.this$0).setRefreshing(false);
      PageWebviewContainer.a(this.this$0).setEnabled(PageWebviewContainer.b(this.this$0));
      this.a.a();
      return;
    }
    bdnw.d("PageWebviewContainer", "EVENT_STOP_PULLDOWN_REFRESH mSwipeRefreshLayout is null.");
    this.a.a("refresh layout error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.page.PageWebviewContainer.4
 * JD-Core Version:    0.7.0.1
 */