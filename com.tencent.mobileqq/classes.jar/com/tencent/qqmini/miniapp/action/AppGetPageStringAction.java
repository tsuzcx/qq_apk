package com.tencent.qqmini.miniapp.action;

import com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.Action;

public class AppGetPageStringAction
  implements Action<String>
{
  private static final int GET_NAVIBAR_STYLE = 1;
  private int action = -1;
  private IMiniAppContext miniAppContext;
  
  public static AppGetPageStringAction obtain(IMiniAppContext paramIMiniAppContext)
  {
    AppGetPageStringAction localAppGetPageStringAction = new AppGetPageStringAction();
    localAppGetPageStringAction.miniAppContext = paramIMiniAppContext;
    return localAppGetPageStringAction;
  }
  
  public String getNaviBarStyle()
  {
    this.action = 1;
    return (String)this.miniAppContext.performAction(this);
  }
  
  public String perform(BaseRuntime paramBaseRuntime)
  {
    paramBaseRuntime = paramBaseRuntime.getPage();
    if (!(paramBaseRuntime instanceof AppBrandPageContainer)) {
      return null;
    }
    paramBaseRuntime = (AppBrandPageContainer)paramBaseRuntime;
    if (this.action != 1) {
      return "";
    }
    return paramBaseRuntime.getNaviBarStyle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.action.AppGetPageStringAction
 * JD-Core Version:    0.7.0.1
 */