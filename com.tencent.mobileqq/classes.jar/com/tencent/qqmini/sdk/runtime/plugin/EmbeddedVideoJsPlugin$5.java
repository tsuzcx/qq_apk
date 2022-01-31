package com.tencent.qqmini.sdk.runtime.plugin;

import bgls;
import bgmc;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;

class EmbeddedVideoJsPlugin$5
  implements bgmc<EmbeddedWidgetClientFactory>
{
  EmbeddedVideoJsPlugin$5(EmbeddedVideoJsPlugin paramEmbeddedVideoJsPlugin) {}
  
  public EmbeddedWidgetClientFactory perform(bgls parambgls)
  {
    parambgls = parambgls.a();
    if (!(parambgls instanceof AppBrandPageContainer))
    {
      QMLog.d("Action", "Page is invalid");
      return null;
    }
    return ((AppBrandPageContainer)parambgls).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.EmbeddedVideoJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */