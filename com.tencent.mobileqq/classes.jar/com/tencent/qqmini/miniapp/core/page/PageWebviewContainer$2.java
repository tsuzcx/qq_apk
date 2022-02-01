package com.tencent.qqmini.miniapp.core.page;

import android.view.View;

class PageWebviewContainer$2
  implements PageWebview.OnWebviewScrollListener
{
  PageWebviewContainer$2(PageWebviewContainer paramPageWebviewContainer) {}
  
  public void onVerticalScroll(int paramInt)
  {
    if ((PageWebviewContainer.access$100(this.this$0) != null) && (!PageWebviewContainer.access$100(this.this$0).isVideoFullScreen()) && (!PageWebviewContainer.access$100(this.this$0).isTextAreaFocused()))
    {
      Object localObject = this.this$0;
      ((PageWebviewContainer)localObject).mNaitveViewScrollY = paramInt;
      localObject = PageWebviewContainer.access$100((PageWebviewContainer)localObject);
      if (PageWebviewContainer.access$200(this.this$0)) {
        paramInt = 0;
      }
      ((NativeViewContainer)localObject).scrollTo(0, paramInt);
      return;
    }
    if ((PageWebviewContainer.access$100(this.this$0) != null) && (PageWebviewContainer.access$100(this.this$0).isTextAreaFocused())) {
      PageWebviewContainer.access$100(this.this$0).getCurrentPageWebview().getView().scrollTo(0, this.this$0.mNaitveViewScrollY);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.PageWebviewContainer.2
 * JD-Core Version:    0.7.0.1
 */