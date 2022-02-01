package com.tencent.qqmini.sdk.launcher.core;

import android.content.Context;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public abstract interface IRuntimeLifecycleListener
{
  public abstract void onDestroy(Context paramContext, MiniAppInfo paramMiniAppInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.IRuntimeLifecycleListener
 * JD-Core Version:    0.7.0.1
 */