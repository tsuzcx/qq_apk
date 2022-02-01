package com.tencent.mobileqq.mini.appbrand.page;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.qphone.base.util.QLog;

class WebviewContainer$2
  implements PageWebview.OnWebviewScrollListener
{
  WebviewContainer$2(WebviewContainer paramWebviewContainer, PageWebview paramPageWebview) {}
  
  public void onVerticalScroll(int paramInt)
  {
    if ((!WebviewContainer.access$000(this.this$0)) && (!WebviewContainer.access$100(this.this$0)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebViewContainer", 2, "onVerticalScroll scrollY=" + paramInt);
      }
      this.this$0.mScrollY = paramInt;
      localFrameLayout = WebviewContainer.access$300(this.this$0);
      if (WebviewContainer.access$200(this.this$0)) {
        paramInt = 0;
      }
      localFrameLayout.scrollTo(0, paramInt);
    }
    while (!WebviewContainer.access$100(this.this$0))
    {
      FrameLayout localFrameLayout;
      return;
    }
    this.val$pageWebview.getView().scrollTo(0, this.this$0.mScrollY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.WebviewContainer.2
 * JD-Core Version:    0.7.0.1
 */