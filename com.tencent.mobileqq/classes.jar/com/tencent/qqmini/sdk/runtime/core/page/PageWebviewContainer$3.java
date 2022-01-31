package com.tencent.qqmini.sdk.runtime.core.page;

import android.support.v4.widget.SwipeRefreshLayout;
import bgid;
import com.tencent.qqmini.sdk.log.QMLog;

class PageWebviewContainer$3
  implements Runnable
{
  PageWebviewContainer$3(PageWebviewContainer paramPageWebviewContainer, bgid parambgid) {}
  
  public void run()
  {
    if (PageWebviewContainer.a(this.this$0) != null)
    {
      PageWebviewContainer.a(this.this$0).setRefreshing(true);
      this.this$0.onRefresh();
      this.a.a();
      return;
    }
    QMLog.e("PageWebviewContainer", "EVENT_START_PULLDOWN_REFRESH mSwipeRefreshLayout is null.");
    this.a.a("refresh layout error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.page.PageWebviewContainer.3
 * JD-Core Version:    0.7.0.1
 */