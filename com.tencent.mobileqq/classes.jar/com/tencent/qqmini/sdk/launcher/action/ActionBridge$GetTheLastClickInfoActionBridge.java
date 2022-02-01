package com.tencent.qqmini.sdk.launcher.action;

public class ActionBridge$GetTheLastClickInfoActionBridge
  extends ActionBridge<String>
{
  public static GetTheLastClickInfoActionBridge obtain()
  {
    GetTheLastClickInfoActionBridge localGetTheLastClickInfoActionBridge = new GetTheLastClickInfoActionBridge();
    localGetTheLastClickInfoActionBridge.setRealAction(obtain("GetTheLastClickInfoAction", 0, null));
    return localGetTheLastClickInfoActionBridge;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.action.ActionBridge.GetTheLastClickInfoActionBridge
 * JD-Core Version:    0.7.0.1
 */