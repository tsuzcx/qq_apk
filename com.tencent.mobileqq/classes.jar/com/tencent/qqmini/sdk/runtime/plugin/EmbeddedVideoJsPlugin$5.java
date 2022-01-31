package com.tencent.qqmini.sdk.runtime.plugin;

import bghl;
import bghv;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;

class EmbeddedVideoJsPlugin$5
  implements bghv<EmbeddedWidgetClientFactory>
{
  EmbeddedVideoJsPlugin$5(EmbeddedVideoJsPlugin paramEmbeddedVideoJsPlugin) {}
  
  public EmbeddedWidgetClientFactory perform(bghl parambghl)
  {
    parambghl = parambghl.a();
    if (!(parambghl instanceof AppBrandPageContainer))
    {
      QMLog.d("Action", "Page is invalid");
      return null;
    }
    return ((AppBrandPageContainer)parambghl).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.EmbeddedVideoJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */