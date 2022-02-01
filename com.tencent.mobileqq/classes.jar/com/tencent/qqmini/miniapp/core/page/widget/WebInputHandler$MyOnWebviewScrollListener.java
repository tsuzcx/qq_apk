package com.tencent.qqmini.miniapp.core.page.widget;

import com.tencent.qqmini.miniapp.core.page.PageWebview;
import com.tencent.qqmini.miniapp.core.page.PageWebview.OnWebviewScrollListener;

class WebInputHandler$MyOnWebviewScrollListener
  implements PageWebview.OnWebviewScrollListener
{
  private final PageWebview pageWebview;
  
  public WebInputHandler$MyOnWebviewScrollListener(PageWebview paramPageWebview)
  {
    this.pageWebview = paramPageWebview;
  }
  
  public void onVerticalScroll(int paramInt)
  {
    this.pageWebview.scrollY = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.widget.WebInputHandler.MyOnWebviewScrollListener
 * JD-Core Version:    0.7.0.1
 */