package com.tencent.qqmini.sdk.runtime;

import com.tencent.qqmini.sdk.launcher.log.QMLog;

class AppRuntimeLoaderManager$3
  implements BaseRuntimeLoader.OnAppRuntimeLoadListener
{
  AppRuntimeLoaderManager$3(AppRuntimeLoaderManager paramAppRuntimeLoaderManager, BaseRuntimeLoader.OnAppRuntimeLoadListener paramOnAppRuntimeLoadListener) {}
  
  public void onResult(int paramInt, String paramString, BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    try
    {
      if (this.val$listener != null) {
        this.val$listener.onResult(paramInt, paramString, paramBaseRuntimeLoader);
      }
      if (paramInt != 0)
      {
        paramString = new StringBuilder();
        paramString.append("runtime load result error! remove it. retCode = ");
        paramString.append(paramInt);
        QMLog.e("minisdk-start_AppRuntimeLoaderManager", paramString.toString());
        this.this$0.removeRuntimeLoader(paramBaseRuntimeLoader);
        return;
      }
    }
    catch (Throwable paramString)
    {
      QMLog.e("minisdk-start_AppRuntimeLoaderManager", "runtime load result exception! remove it. ", paramString);
      this.this$0.removeRuntimeLoader(paramBaseRuntimeLoader);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.AppRuntimeLoaderManager.3
 * JD-Core Version:    0.7.0.1
 */