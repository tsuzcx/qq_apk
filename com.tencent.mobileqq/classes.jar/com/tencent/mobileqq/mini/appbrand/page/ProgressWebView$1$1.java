package com.tencent.mobileqq.mini.appbrand.page;

import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.ui.NavigationBar;

class ProgressWebView$1$1
  implements Runnable
{
  ProgressWebView$1$1(ProgressWebView.1 param1, String paramString) {}
  
  public void run()
  {
    boolean bool2 = true;
    NavigationBar localNavigationBar;
    if ((ProgressWebView.access$100(this.this$1.this$0) != null) && (ProgressWebView.access$100(this.this$1.this$0).pageContainer != null) && (ProgressWebView.access$100(this.this$1.this$0).pageContainer.getCurrentPage() != null) && (ProgressWebView.access$100(this.this$1.this$0).pageContainer.getCurrentPage().getNavBar() != null))
    {
      int i = ProgressWebView.access$100(this.this$1.this$0).pageContainer.getPageCount();
      bool1 = ProgressWebView.access$100(this.this$1.this$0).pageContainer.getCurrentPage().isTabPage();
      localNavigationBar = ProgressWebView.access$100(this.this$1.this$0).pageContainer.getCurrentPage().getNavBar();
      if (bool1) {
        break label171;
      }
      bool1 = bool2;
      if (i <= 1) {
        if (!this.this$1.this$0.canGoBack()) {
          break label171;
        }
      }
    }
    label171:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localNavigationBar.setEnableBackIcon(bool1).setTitleText(this.val$title);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ProgressWebView.1.1
 * JD-Core Version:    0.7.0.1
 */