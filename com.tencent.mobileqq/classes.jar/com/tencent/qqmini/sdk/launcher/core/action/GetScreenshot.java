package com.tencent.qqmini.sdk.launcher.core.action;

import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;

public class GetScreenshot
  implements Action<Void>
{
  private GetScreenshot.Callback callback;
  
  public static void obtain(IMiniAppContext paramIMiniAppContext, GetScreenshot.Callback paramCallback)
  {
    GetScreenshot localGetScreenshot = new GetScreenshot();
    localGetScreenshot.callback = paramCallback;
    paramIMiniAppContext.performAction(localGetScreenshot);
  }
  
  public Void perform(BaseRuntime paramBaseRuntime)
  {
    paramBaseRuntime.getScreenshot(this.callback);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.action.GetScreenshot
 * JD-Core Version:    0.7.0.1
 */