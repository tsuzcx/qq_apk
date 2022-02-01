package com.tencent.qqmini.sdk.launcher.core.plugins.engine;

import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle;

public abstract interface IJsPluginEngine
  extends ILifeCycle
{
  public abstract String handleNativeRequest(String paramString1, String paramString2, IJsService paramIJsService, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.plugins.engine.IJsPluginEngine
 * JD-Core Version:    0.7.0.1
 */