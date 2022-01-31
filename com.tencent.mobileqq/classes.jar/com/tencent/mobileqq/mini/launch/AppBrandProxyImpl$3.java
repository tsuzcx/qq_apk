package com.tencent.mobileqq.mini.launch;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.util.AnimUtil;
import com.tencent.qphone.base.util.QLog;

class AppBrandProxyImpl$3
  extends ResultReceiver
{
  AppBrandProxyImpl$3(AppBrandProxyImpl paramAppBrandProxyImpl, Handler paramHandler, ResultReceiver paramResultReceiver, Activity paramActivity, MiniAppConfig paramMiniAppConfig)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    Intent localIntent;
    if (paramInt == 1)
    {
      localIntent = new Intent();
      localIntent.addFlags(805371904);
      paramBundle.setClassLoader(getClass().getClassLoader());
      localIntent.setComponent((ComponentName)paramBundle.getParcelable("Activity"));
      paramBundle.remove("receiver");
      paramBundle.putParcelable("receiver", this.val$resultReceiver);
      localIntent.putExtras(paramBundle);
    }
    try
    {
      if (this.val$activity != null) {
        this.val$activity.startActivity(localIntent);
      }
      while ((this.val$appConfig != null) && (this.val$appConfig.isEngineTypeMiniGame()))
      {
        AnimUtil.clearAnim(this.val$activity);
        return;
        BaseApplicationImpl.getApplication().startActivity(localIntent);
      }
    }
    catch (Throwable paramBundle)
    {
      for (;;)
      {
        QLog.e("miniapp-process_AppBrandProxy", 1, "startMiniApp startActivity exception!", paramBundle);
      }
      AnimUtil.setOpenAnim(this.val$activity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandProxyImpl.3
 * JD-Core Version:    0.7.0.1
 */