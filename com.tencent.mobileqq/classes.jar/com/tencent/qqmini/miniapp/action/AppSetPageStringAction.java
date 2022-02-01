package com.tencent.qqmini.miniapp.action;

import com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.Action;

public class AppSetPageStringAction
  implements Action<Void>
{
  private static final int SET_NAVIBAR_STYLE = 1;
  private int action = -1;
  private IMiniAppContext miniAppContext;
  private String value;
  
  public static AppSetPageStringAction obtain(IMiniAppContext paramIMiniAppContext)
  {
    AppSetPageStringAction localAppSetPageStringAction = new AppSetPageStringAction();
    localAppSetPageStringAction.miniAppContext = paramIMiniAppContext;
    return localAppSetPageStringAction;
  }
  
  public Void perform(BaseRuntime paramBaseRuntime)
  {
    paramBaseRuntime = paramBaseRuntime.getPage();
    if (!(paramBaseRuntime instanceof AppBrandPageContainer)) {
      return null;
    }
    paramBaseRuntime = (AppBrandPageContainer)paramBaseRuntime;
    switch (this.action)
    {
    default: 
      return null;
    }
    paramBaseRuntime.setNaviBarStyle(this.value);
    return null;
  }
  
  public void setNaviBarStyle(String paramString)
  {
    this.action = 1;
    this.miniAppContext.performAction(this);
    this.value = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.action.AppSetPageStringAction
 * JD-Core Version:    0.7.0.1
 */