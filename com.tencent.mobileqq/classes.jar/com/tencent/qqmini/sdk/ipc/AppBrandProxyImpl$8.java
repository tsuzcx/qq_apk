package com.tencent.qqmini.sdk.ipc;

import android.os.Bundle;
import bgtv;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.ipc.IAppMainService;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;
import com.tencent.qqmini.sdk.log.QMLog;

public class AppBrandProxyImpl$8
  implements Runnable
{
  public AppBrandProxyImpl$8(bgtv parambgtv, String paramString, MiniCmdCallback paramMiniCmdCallback, Bundle paramBundle) {}
  
  public void run()
  {
    if (this.this$0.a() == null)
    {
      QMLog.e("minisdk-start_AppBrandProxy", "sendCmd IAppBrandService Connection is Null 1. cmd=" + this.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherIpcMiniCmdCallback != null) {}
      try
      {
        this.jdField_a_of_type_ComTencentQqminiSdkLauncherIpcMiniCmdCallback.onCmdResult(false, new Bundle());
        return;
      }
      catch (Throwable localThrowable1)
      {
        QMLog.e("minisdk-start_AppBrandProxy", "sendCmd exception.", localThrowable1);
        return;
      }
    }
    try
    {
      bgtv.a(this.this$0).sendCmd(this.jdField_a_of_type_JavaLangString, AppLoaderFactory.g().getCurrentProcessName(), this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_ComTencentQqminiSdkLauncherIpcMiniCmdCallback);
      return;
    }
    catch (Throwable localThrowable2)
    {
      QMLog.e("minisdk-start_AppBrandProxy", "sendCmd exception.", localThrowable2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ipc.AppBrandProxyImpl.8
 * JD-Core Version:    0.7.0.1
 */