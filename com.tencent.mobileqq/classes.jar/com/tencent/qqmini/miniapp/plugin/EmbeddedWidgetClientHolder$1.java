package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidget;

class EmbeddedWidgetClientHolder$1
  implements Action<Boolean>
{
  EmbeddedWidgetClientHolder$1(EmbeddedWidgetClientHolder paramEmbeddedWidgetClientHolder) {}
  
  public Boolean perform(BaseRuntime paramBaseRuntime)
  {
    paramBaseRuntime = paramBaseRuntime.getPage();
    if (!(paramBaseRuntime instanceof AppBrandPageContainer))
    {
      QMLog.d("Action", "Page is invalid");
      return Boolean.valueOf(false);
    }
    paramBaseRuntime = ((AppBrandPageContainer)paramBaseRuntime).getCurrentX5EmbeddedWidgetClientFactory();
    if (paramBaseRuntime == null)
    {
      QMLog.d("Action", "factory is null");
      return Boolean.valueOf(false);
    }
    if (EmbeddedWidgetClientHolder.access$000(this.this$0) == null) {
      return Boolean.valueOf(false);
    }
    return Boolean.valueOf(paramBaseRuntime.handleEmbeddedWidgetDestory(EmbeddedWidgetClientHolder.access$000(this.this$0).getWidgetId()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.EmbeddedWidgetClientHolder.1
 * JD-Core Version:    0.7.0.1
 */