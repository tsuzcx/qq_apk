package com.tencent.qqmini.sdk.action;

import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.action.Action;

public class GetPageStringAction
  implements Action<String>
{
  private static final int GET_PAGE_ORIENTATION = 1;
  private int action = -1;
  private IMiniAppContext miniAppContext;
  
  public static GetPageStringAction obtain(IMiniAppContext paramIMiniAppContext)
  {
    GetPageStringAction localGetPageStringAction = new GetPageStringAction();
    localGetPageStringAction.miniAppContext = paramIMiniAppContext;
    return localGetPageStringAction;
  }
  
  public String getPageOrientation()
  {
    this.action = 1;
    return (String)this.miniAppContext.performAction(this);
  }
  
  public String perform(BaseRuntime paramBaseRuntime)
  {
    paramBaseRuntime = paramBaseRuntime.getPage();
    if (paramBaseRuntime == null) {
      return null;
    }
    if (this.action != 1) {
      return "";
    }
    return paramBaseRuntime.getPageOrientation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.action.GetPageStringAction
 * JD-Core Version:    0.7.0.1
 */