package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class EmbeddedLivePlayerJsPlugin$2
  implements Action<Void>
{
  EmbeddedLivePlayerJsPlugin$2(EmbeddedLivePlayerJsPlugin paramEmbeddedLivePlayerJsPlugin, RequestEvent paramRequestEvent) {}
  
  public Void perform(BaseRuntime paramBaseRuntime)
  {
    paramBaseRuntime = paramBaseRuntime.getPage();
    if (!(paramBaseRuntime instanceof AppBrandPageContainer))
    {
      QMLog.d("Action", "Page is invalid");
      return null;
    }
    paramBaseRuntime = ((AppBrandPageContainer)paramBaseRuntime).getShowingPage();
    if (paramBaseRuntime != null)
    {
      AppBrandTask.runTaskOnUiThread(new EmbeddedLivePlayerJsPlugin.2.1(this, paramBaseRuntime));
      return null;
    }
    this.val$req.fail();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.EmbeddedLivePlayerJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */