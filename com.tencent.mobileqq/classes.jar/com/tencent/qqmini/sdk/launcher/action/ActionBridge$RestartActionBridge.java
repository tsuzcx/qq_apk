package com.tencent.qqmini.sdk.launcher.action;

public class ActionBridge$RestartActionBridge
  extends ActionBridge<Boolean>
{
  public static RestartActionBridge obtain()
  {
    RestartActionBridge localRestartActionBridge = new RestartActionBridge();
    localRestartActionBridge.setRealAction(obtain("RestartAction", 0, null));
    return localRestartActionBridge;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.action.ActionBridge.RestartActionBridge
 * JD-Core Version:    0.7.0.1
 */