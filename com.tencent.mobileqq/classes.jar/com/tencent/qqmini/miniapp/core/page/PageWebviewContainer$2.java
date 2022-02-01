package com.tencent.qqmini.miniapp.core.page;

class PageWebviewContainer$2
  implements PageWebview.OnWebviewScrollListener
{
  PageWebviewContainer$2(PageWebviewContainer paramPageWebviewContainer) {}
  
  public void onVerticalScroll(int paramInt)
  {
    this.this$0.mNaitveViewScrollY = paramInt;
    NativeViewContainer localNativeViewContainer = PageWebviewContainer.access$200(this.this$0);
    if (PageWebviewContainer.access$100(this.this$0)) {
      paramInt = 0;
    }
    localNativeViewContainer.scrollTo(0, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.PageWebviewContainer.2
 * JD-Core Version:    0.7.0.1
 */