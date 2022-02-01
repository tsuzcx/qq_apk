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
    Object localObject = paramBaseRuntime.getPage();
    boolean bool = localObject instanceof AppBrandPageContainer;
    paramBaseRuntime = Boolean.valueOf(false);
    if (!bool)
    {
      QMLog.d("Action", "Page is invalid");
      return paramBaseRuntime;
    }
    localObject = ((AppBrandPageContainer)localObject).getCurrentX5EmbeddedWidgetClientFactory();
    if (localObject == null)
    {
      QMLog.d("Action", "factory is null");
      return paramBaseRuntime;
    }
    if (EmbeddedWidgetClientHolder.access$000(this.this$0) == null) {
      return paramBaseRuntime;
    }
    return Boolean.valueOf(((EmbeddedWidgetClientFactory)localObject).handleEmbeddedWidgetDestory(EmbeddedWidgetClientHolder.access$000(this.this$0).getWidgetId()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.EmbeddedWidgetClientHolder.1
 * JD-Core Version:    0.7.0.1
 */