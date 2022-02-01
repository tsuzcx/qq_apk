package com.tencent.qqmini.sdk.action;

import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.action.Action;

public class SetViewVisibilityAction
  implements Action<Void>
{
  private static final int SET_NAVIBAR_VISIBILITY = 2;
  private static final int SET_TABBAR_VISIBILITY = 1;
  private int action = -1;
  private int mVisibility;
  private IMiniAppContext miniAppContext;
  
  public static SetViewVisibilityAction obtain(IMiniAppContext paramIMiniAppContext)
  {
    SetViewVisibilityAction localSetViewVisibilityAction = new SetViewVisibilityAction();
    localSetViewVisibilityAction.miniAppContext = paramIMiniAppContext;
    return localSetViewVisibilityAction;
  }
  
  public Void perform(BaseRuntime paramBaseRuntime)
  {
    paramBaseRuntime = paramBaseRuntime.getPage();
    if (paramBaseRuntime == null) {
      return null;
    }
    switch (this.action)
    {
    default: 
      return null;
    case 1: 
      paramBaseRuntime.setTabBarVisibility(this.mVisibility);
      return null;
    }
    paramBaseRuntime.setNaviVisibility(this.mVisibility);
    return null;
  }
  
  public void setNaviBarVisibility(int paramInt)
  {
    this.action = 2;
    this.mVisibility = paramInt;
    this.miniAppContext.performAction(this);
  }
  
  public void setTabBarVisibility(int paramInt)
  {
    this.action = 1;
    this.mVisibility = paramInt;
    this.miniAppContext.performAction(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.action.SetViewVisibilityAction
 * JD-Core Version:    0.7.0.1
 */