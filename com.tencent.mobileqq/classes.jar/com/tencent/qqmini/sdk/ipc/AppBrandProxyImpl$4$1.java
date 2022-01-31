package com.tencent.qqmini.sdk.ipc;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.log.QMLog;

class AppBrandProxyImpl$4$1
  extends ResultReceiver
{
  AppBrandProxyImpl$4$1(AppBrandProxyImpl.4 param4, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    if (paramInt == 1)
    {
      Intent localIntent = new Intent();
      localIntent.addFlags(805371904);
      paramBundle.setClassLoader(getClass().getClassLoader());
      localIntent.setComponent((ComponentName)paramBundle.getParcelable("Activity"));
      paramBundle.remove("receiver");
      paramBundle.putParcelable("receiver", this.a.jdField_a_of_type_AndroidOsResultReceiver);
      localIntent.putExtras(paramBundle);
      try
      {
        if (this.a.jdField_a_of_type_AndroidAppActivity != null)
        {
          this.a.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
          return;
        }
        AppLoaderFactory.g().getMiniAppEnv().getContext().startActivity(localIntent);
        return;
      }
      catch (Throwable paramBundle)
      {
        QMLog.e("minisdk-start_AppBrandProxy", "startMiniApp startActivity exception!", paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ipc.AppBrandProxyImpl.4.1
 * JD-Core Version:    0.7.0.1
 */