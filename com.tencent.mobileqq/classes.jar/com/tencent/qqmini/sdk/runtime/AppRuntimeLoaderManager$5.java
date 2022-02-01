package com.tencent.qqmini.sdk.runtime;

import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback.Stub;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class AppRuntimeLoaderManager$5
  extends MiniCmdCallback.Stub
{
  AppRuntimeLoaderManager$5(AppRuntimeLoaderManager paramAppRuntimeLoaderManager) {}
  
  public void onCmdResult(boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = new StringBuilder();
    paramBundle.append("notifyRuntime runtime info result ");
    paramBundle.append(paramBoolean);
    QMLog.i("minisdk-start_AppRuntimeLoaderManager", paramBundle.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.AppRuntimeLoaderManager.5
 * JD-Core Version:    0.7.0.1
 */