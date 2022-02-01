package com.tencent.qqmini.miniapp.widget;

import com.tencent.qqmini.miniapp.core.page.AppBrandPage;
import com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer;
import com.tencent.qqmini.miniapp.core.page.BrandPageWebview;
import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class InnerWebView$7
  implements Action<Void>
{
  InnerWebView$7(InnerWebView paramInnerWebView, String paramString) {}
  
  public Void perform(BaseRuntime paramBaseRuntime)
  {
    paramBaseRuntime = paramBaseRuntime.getPage();
    if (!(paramBaseRuntime instanceof AppBrandPageContainer)) {
      QMLog.d("Action", "Page is invalid");
    }
    for (;;)
    {
      return null;
      paramBaseRuntime = (AppBrandPageContainer)paramBaseRuntime;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("htmlId", this.this$0.htmlId);
        localJSONObject.put("src", this.val$url);
        int i = PageAction.obtain(InnerWebView.access$600(this.this$0)).getPageId();
        if ((paramBaseRuntime.getShowingPage() != null) && (paramBaseRuntime.getShowingPage().getBrandPageWebview() != null))
        {
          paramBaseRuntime.getShowingPage().getBrandPageWebview().evaluateSubscribeJS("onWebviewError", localJSONObject.toString(), i);
          return null;
        }
      }
      catch (Exception paramBaseRuntime)
      {
        QMLog.e("Action", "onPageStarted error." + paramBaseRuntime);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.InnerWebView.7
 * JD-Core Version:    0.7.0.1
 */