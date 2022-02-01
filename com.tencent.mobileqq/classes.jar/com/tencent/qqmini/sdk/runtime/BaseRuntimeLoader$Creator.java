package com.tencent.qqmini.sdk.runtime;

import android.content.Context;
import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public abstract interface BaseRuntimeLoader$Creator<T>
{
  public abstract T create(Context paramContext, Bundle paramBundle);
  
  public abstract void doPrepareEngine(Bundle paramBundle);
  
  public abstract boolean isEnginePrepared(Bundle paramBundle);
  
  public abstract boolean support(MiniAppInfo paramMiniAppInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader.Creator
 * JD-Core Version:    0.7.0.1
 */