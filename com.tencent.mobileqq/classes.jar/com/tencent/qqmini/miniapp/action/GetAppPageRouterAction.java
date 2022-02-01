package com.tencent.qqmini.miniapp.action;

import com.tencent.qqmini.miniapp.core.page.IAppBrandPageContainer;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IAppPageRouter;
import com.tencent.qqmini.sdk.launcher.core.action.Action;

@MiniKeep
public class GetAppPageRouterAction
  implements Action<IAppPageRouter>
{
  private static final int EMPTY_CALLBACK_ID = -1;
  
  public IAppPageRouter perform(BaseRuntime paramBaseRuntime)
  {
    paramBaseRuntime = paramBaseRuntime.getPage();
    if ((paramBaseRuntime instanceof IAppBrandPageContainer)) {
      return new GetAppPageRouterAction.AppPageRouterImpl((IAppBrandPageContainer)paramBaseRuntime);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.action.GetAppPageRouterAction
 * JD-Core Version:    0.7.0.1
 */