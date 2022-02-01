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
    if (!(paramBaseRuntime instanceof AppBrandPageContainer))
    {
      QMLog.d("Action", "Page is invalid");
      return null;
    }
    paramBaseRuntime = (AppBrandPageContainer)paramBaseRuntime;
    int i = paramBaseRuntime.getPageCount();
    boolean bool1 = paramBaseRuntime.isCurrentTabBarPage();
    paramBaseRuntime = paramBaseRuntime.getShowingPage();
    if ((paramBaseRuntime != null) && (paramBaseRuntime.getNavBar() != null))
    {
      paramBaseRuntime = paramBaseRuntime.getNavBar();
      boolean bool2 = true;
      if (!bool1)
      {
        bool1 = bool2;
        if (i > 1) {
          break label93;
        }
        if (this.this$1.this$0.canGoBack())
        {
          bool1 = bool2;
          break label93;
        }
      }
      bool1 = false;
      label93:
      paramBaseRuntime.setEnableBackIcon(bool1).setTitleText(this.this$1.val$title);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.InnerWebView.3.1
 * JD-Core Version:    0.7.0.1
 */