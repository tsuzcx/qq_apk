package com.tencent.qqmini.miniapp.widget;

import com.tencent.qqmini.miniapp.core.page.AppBrandPage;
import com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer;
import com.tencent.qqmini.miniapp.core.page.BrandPageWebview;
import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.NavigationBar;
import org.json.JSONObject;

class InnerWebView$6
  implements Action<Void>
{
  InnerWebView$6(InnerWebView paramInnerWebView, String paramString) {}
  
  public Void perform(BaseRuntime paramBaseRuntime)
  {
    paramBaseRuntime = paramBaseRuntime.getPage();
    if (!(paramBaseRuntime instanceof AppBrandPageContainer))
    {
      QMLog.d("Action", "Page is invalid");
      return null;
    }
    paramBaseRuntime = (AppBrandPageContainer)paramBaseRuntime;
    Object localObject = paramBaseRuntime.getShowingPage();
    if ((localObject != null) && (((AppBrandPage)localObject).getNavBar() != null)) {
      ((AppBrandPage)localObject).getNavBar().updateProgress((byte)2);
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("htmlId", this.this$0.htmlId);
      ((JSONObject)localObject).put("src", this.val$s);
      int i = PageAction.obtain(InnerWebView.access$600(this.this$0)).getPageId();
      if ((paramBaseRuntime.getShowingPage() != null) && (paramBaseRuntime.getShowingPage().getBrandPageWebview() != null))
      {
        paramBaseRuntime.getShowingPage().getBrandPageWebview().evaluateSubscribeJS("onWebviewFinishLoad", ((JSONObject)localObject).toString(), i);
        return null;
      }
    }
    catch (Exception paramBaseRuntime)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPageStarted error.");
      ((StringBuilder)localObject).append(paramBaseRuntime);
      QMLog.e("Action", ((StringBuilder)localObject).toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.InnerWebView.6
 * JD-Core Version:    0.7.0.1
 */