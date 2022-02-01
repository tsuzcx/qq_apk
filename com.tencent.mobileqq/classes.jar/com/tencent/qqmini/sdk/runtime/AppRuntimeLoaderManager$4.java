package com.tencent.qqmini.sdk.runtime;

import com.tencent.qqmini.sdk.launcher.log.QMLog;

class AppRuntimeLoaderManager$4
  implements BaseRuntimeLoader.OnAppRuntimeLoadListener
{
  AppRuntimeLoaderManager$4(AppRuntimeLoaderManager paramAppRuntimeLoaderManager, BaseRuntimeLoader.OnAppRuntimeLoadListener paramOnAppRuntimeLoadListener) {}
  
  public void onResult(int paramInt, String paramString, BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    try
    {
      if (this.val$listener != null) {
        this.val$listener.onResult(paramInt, paramString, paramBaseRuntimeLoader);
      }
      if (paramInt != 0)
      {
        this.this$0.removeRuntimeLoader(paramBaseRuntimeLoader);
        return;
      }
    }
    catch (Throwable paramString)
    {
      QMLog.e("minisdk-start_AppRuntimeLoaderManager", "runtime load result exception!", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.AppRuntimeLoaderManager.4
 * JD-Core Version:    0.7.0.1
 */