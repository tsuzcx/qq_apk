package com.tencent.qqmini.sdk.action;

import android.view.View;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.action.Action;

public class HideInputAction
  implements Action
{
  public static void hideInput(IMiniAppContext paramIMiniAppContext)
  {
    paramIMiniAppContext.performAction(obtain());
  }
  
  public static HideInputAction obtain()
  {
    return new HideInputAction();
  }
  
  public Object perform(BaseRuntime paramBaseRuntime)
  {
    paramBaseRuntime = paramBaseRuntime.getPage();
    if (paramBaseRuntime == null) {
      return null;
    }
    paramBaseRuntime.hideSoftInput((View)paramBaseRuntime.getCapsuleButton());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.action.HideInputAction
 * JD-Core Version:    0.7.0.1
 */