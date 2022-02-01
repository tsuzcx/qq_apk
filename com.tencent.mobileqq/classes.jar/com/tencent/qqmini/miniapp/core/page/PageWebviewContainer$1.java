package com.tencent.qqmini.miniapp.core.page;

import android.view.View;
import android.view.ViewTreeObserver.OnScrollChangedListener;

class PageWebviewContainer$1
  implements ViewTreeObserver.OnScrollChangedListener
{
  PageWebviewContainer$1(PageWebviewContainer paramPageWebviewContainer) {}
  
  public void onScrollChanged()
  {
    PageWebviewContainer.access$000(this.this$0).getRealView().getView().scrollTo(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.PageWebviewContainer.1
 * JD-Core Version:    0.7.0.1
 */