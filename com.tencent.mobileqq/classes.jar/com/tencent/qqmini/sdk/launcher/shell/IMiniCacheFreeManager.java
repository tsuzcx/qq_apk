package com.tencent.qqmini.sdk.launcher.shell;

import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public abstract interface IMiniCacheFreeManager
{
  public abstract void freeCache();
  
  public abstract void freeCache(String paramString, MiniAppInfo paramMiniAppInfo, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.shell.IMiniCacheFreeManager
 * JD-Core Version:    0.7.0.1
 */