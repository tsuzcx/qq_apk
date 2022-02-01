package com.tencent.qqmini.miniapp.core.page;

import com.tencent.qqmini.miniapp.core.BaseAppBrandRuntime;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.runtime.AppStateManager;

class AppBrandPageContainer$5
  implements Action<Boolean>
{
  AppBrandPageContainer$5(AppBrandPageContainer paramAppBrandPageContainer) {}
  
  public Boolean perform(BaseRuntime paramBaseRuntime)
  {
    if ((paramBaseRuntime instanceof BaseAppBrandRuntime)) {
      paramBaseRuntime = (BaseAppBrandRuntime)paramBaseRuntime;
    } else {
      paramBaseRuntime = null;
    }
    boolean bool;
    if ((paramBaseRuntime != null) && (paramBaseRuntime.getAppStateManager() != null) && (paramBaseRuntime.getAppStateManager().isFromPrelaunch)) {
      bool = true;
    } else {
      bool = false;
    }
    return Boolean.valueOf(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer.5
 * JD-Core Version:    0.7.0.1
 */