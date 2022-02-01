package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class EmbeddedVideoJsPlugin$4
  implements Action<EmbeddedWidgetClientFactory>
{
  EmbeddedVideoJsPlugin$4(EmbeddedVideoJsPlugin paramEmbeddedVideoJsPlugin) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.EmbeddedVideoJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */