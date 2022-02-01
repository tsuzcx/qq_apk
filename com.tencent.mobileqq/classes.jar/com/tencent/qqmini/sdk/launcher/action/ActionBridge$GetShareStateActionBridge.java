package com.tencent.qqmini.sdk.launcher.action;

import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.model.ShareState;

public class ActionBridge$GetShareStateActionBridge
  extends ActionBridge<ShareState>
{
  public static GetShareStateActionBridge obtain()
  {
    GetShareStateActionBridge localGetShareStateActionBridge = new GetShareStateActionBridge();
    localGetShareStateActionBridge.setRealAction(obtain("GetShareState", 0, null));
    return localGetShareStateActionBridge;
  }
  
  public ShareState perform(BaseRuntime paramBaseRuntime)
  {
    return (ShareState)super.perform(paramBaseRuntime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.action.ActionBridge.GetShareStateActionBridge
 * JD-Core Version:    0.7.0.1
 */