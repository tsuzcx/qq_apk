package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class ExternalElementJsPlugin$1
  implements Action<EmbeddedWidgetClientFactory>
{
  ExternalElementJsPlugin$1(ExternalElementJsPlugin paramExternalElementJsPlugin) {}
  
  public EmbeddedWidgetClientFactory perform(BaseRuntime paramBaseRuntime)
  {
    paramBaseRuntime = paramBaseRuntime.getPage();
    if (!(paramBaseRuntime instanceof AppBrandPageContainer))
    {
      QMLog.d("Action", "Page is invalid");
      return null;
    }
    return ((AppBrandPageContainer)paramBaseRuntime).getCurrentX5EmbeddedWidgetClientFactory();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.ExternalElementJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */