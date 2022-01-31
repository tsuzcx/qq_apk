package com.tencent.mobileqq.mini.appbrand.page;

import android.widget.FrameLayout;

class WebviewContainer$2
  implements PageWebview.OnWebviewScrollListener
{
  WebviewContainer$2(WebviewContainer paramWebviewContainer) {}
  
  public void onVerticalScroll(int paramInt)
  {
    if (!WebviewContainer.access$000(this.this$0))
    {
      FrameLayout localFrameLayout = WebviewContainer.access$200(this.this$0);
      if (WebviewContainer.access$100(this.this$0)) {
        paramInt = 0;
      }
      localFrameLayout.scrollTo(0, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.WebviewContainer.2
 * JD-Core Version:    0.7.0.1
 */