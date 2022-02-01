package com.tencent.qqmini.miniapp.core.page;

import com.tencent.qqmini.miniapp.core.BaseAppBrandRuntime;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.runtime.AppStateManager;

class AppBrandPageContainer$3
  implements Action<Boolean>
{
  AppBrandPageContainer$3(AppBrandPageContainer paramAppBrandPageContainer) {}
  
  public Boolean perform(BaseRuntime paramBaseRuntime)
  {
    if ((paramBaseRuntime instanceof BaseAppBrandRuntime))
    {
      paramBaseRuntime = (BaseAppBrandRuntime)paramBaseRuntime;
      if ((paramBaseRuntime == null) || (paramBaseRuntime.getAppStateManager() == null) || (!paramBaseRuntime.getAppStateManager().isFromPrelaunch)) {
        break label45;
      }
    }
    label45:
    for (boolean bool = true;; bool = false)
    {
      return Boolean.valueOf(bool);
      paramBaseRuntime = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer.3
 * JD-Core Version:    0.7.0.1
 */