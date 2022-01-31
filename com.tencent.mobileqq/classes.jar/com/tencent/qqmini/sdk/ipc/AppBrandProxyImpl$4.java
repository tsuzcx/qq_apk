package com.tencent.qqmini.sdk.ipc;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import bdkr;
import bdnw;
import com.tencent.qqmini.sdk.core.MiniAppEnv;

public class AppBrandProxyImpl$4
  extends ResultReceiver
{
  public AppBrandProxyImpl$4(bdkr parambdkr, Handler paramHandler, ResultReceiver paramResultReceiver, Activity paramActivity)
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
      paramBundle.putParcelable("receiver", this.jdField_a_of_type_AndroidOsResultReceiver);
      localIntent.putExtras(paramBundle);
      try
      {
        if (this.jdField_a_of_type_AndroidAppActivity != null)
        {
          this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
          return;
        }
        MiniAppEnv.g().getContext().startActivity(localIntent);
        return;
      }
      catch (Throwable paramBundle)
      {
        bdnw.d("minisdk-start_AppBrandProxy", "startMiniApp startActivity exception!", paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ipc.AppBrandProxyImpl.4
 * JD-Core Version:    0.7.0.1
 */