package com.tencent.qqmini.miniapp.action;

import com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.CoverView.JsRuntimeListener;

public class GetJsRuntimeListener
  implements Action<CoverView.JsRuntimeListener>
{
  public static CoverView.JsRuntimeListener get(IMiniAppContext paramIMiniAppContext)
  {
    return (CoverView.JsRuntimeListener)paramIMiniAppContext.performAction(new GetJsRuntimeListener());
  }
  
  public CoverView.JsRuntimeListener perform(BaseRuntime paramBaseRuntime)
  {
    paramBaseRuntime = paramBaseRuntime.getPage();
    if (!(paramBaseRuntime instanceof AppBrandPageContainer))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Excepted AppBrandPageContainer, but is ");
      localStringBuilder.append(paramBaseRuntime);
      QMLog.w("Action", localStringBuilder.toString());
      return null;
    }
    return ((AppBrandPageContainer)paramBaseRuntime).getJsRuntimeListener();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.action.GetJsRuntimeListener
 * JD-Core Version:    0.7.0.1
 */