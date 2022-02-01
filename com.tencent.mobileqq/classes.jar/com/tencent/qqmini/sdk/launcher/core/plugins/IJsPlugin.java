package com.tencent.qqmini.sdk.launcher.core.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

public abstract interface IJsPlugin
  extends ILifeCycle
{
  public abstract boolean onInterceptJsEvent(RequestEvent paramRequestEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.plugins.IJsPlugin
 * JD-Core Version:    0.7.0.1
 */