package com.tencent.qqmini.sdk.core.plugins.engine;

import bglu;
import com.tencent.qqmini.sdk.core.plugins.ILifeCycle;

public abstract interface IJsPluginEngine
  extends ILifeCycle
{
  public abstract String handleNativeRequest(String paramString1, String paramString2, bglu parambglu, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.engine.IJsPluginEngine
 * JD-Core Version:    0.7.0.1
 */