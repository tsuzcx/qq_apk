package com.tencent.qqmini.miniapp.widget;

import com.tencent.qqmini.miniapp.core.page.AppBrandPage;
import com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.NavigationBar;

class InnerWebView$4
  implements Action<Void>
{
  InnerWebView$4(InnerWebView paramInnerWebView, int paramInt) {}
  
  public Void perform(BaseRuntime paramBaseRuntime)
  {
    paramBaseRuntime = paramBaseRuntime.getPage();
    if (!(paramBaseRuntime instanceof AppBrandPageContainer)) {
      QMLog.d("Action", "Page is invalid");
    }
    do
    {
      do
      {
        return null;
        paramBaseRuntime = ((AppBrandPageContainer)paramBaseRuntime).getShowingPage();
      } while ((paramBaseRuntime == null) || (paramBaseRuntime.getNavBar() == null));
      paramBaseRuntime.getNavBar().updateProgress((byte)1);
    } while (this.val$progress != 100);
    paramBaseRuntime.getNavBar().updateProgress((byte)2);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.InnerWebView.4
 * JD-Core Version:    0.7.0.1
 */