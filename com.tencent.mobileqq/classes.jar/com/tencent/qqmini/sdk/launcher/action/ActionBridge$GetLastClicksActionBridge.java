package com.tencent.qqmini.sdk.launcher.action;

public class ActionBridge$GetLastClicksActionBridge
  extends ActionBridge<String>
{
  public static GetLastClicksActionBridge obtain()
  {
    GetLastClicksActionBridge localGetLastClicksActionBridge = new GetLastClicksActionBridge();
    localGetLastClicksActionBridge.setRealAction(obtain("GetLastClickAction", 0, null));
    return localGetLastClicksActionBridge;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.action.ActionBridge.GetLastClicksActionBridge
 * JD-Core Version:    0.7.0.1
 */