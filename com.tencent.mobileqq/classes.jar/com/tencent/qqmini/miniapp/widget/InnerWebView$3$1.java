package com.tencent.qqmini.miniapp.widget;

import com.tencent.qqmini.miniapp.core.page.AppBrandPage;
import com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.NavigationBar;

class InnerWebView$3$1
  implements Action<Void>
{
  InnerWebView$3$1(InnerWebView.3 param3) {}
  
  public Void perform(BaseRuntime paramBaseRuntime)
  {
    paramBaseRuntime = paramBaseRuntime.getPage();
    if (!(paramBaseRuntime instanceof AppBrandPageContainer)) {
      QMLog.d("Action", "Page is invalid");
    }
    int i;
    do
    {
      return null;
      paramBaseRuntime = (AppBrandPageContainer)paramBaseRuntime;
      i = paramBaseRuntime.getPageCount();
      bool = paramBaseRuntime.isCurrentTabBarPage();
      paramBaseRuntime = paramBaseRuntime.getShowingPage();
    } while ((paramBaseRuntime == null) || (paramBaseRuntime.getNavBar() == null));
    paramBaseRuntime = paramBaseRuntime.getNavBar();
    if ((!bool) && ((i > 1) || (this.this$1.this$0.canGoBack()))) {}
    for (boolean bool = true;; bool = false)
    {
      paramBaseRuntime.setEnableBackIcon(bool).setTitleText(this.this$1.val$title);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.InnerWebView.3.1
 * JD-Core Version:    0.7.0.1
 */