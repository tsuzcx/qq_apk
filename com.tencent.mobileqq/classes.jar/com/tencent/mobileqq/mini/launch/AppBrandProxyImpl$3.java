package com.tencent.mobileqq.mini.launch;

import android.app.Activity;
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
    if (paramInt == 1)
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      try
      {
        paramBundle = (Intent)paramBundle.getParcelable("LAUNCH_ACTIVITY_INTENT");
        if (paramBundle == null)
        {
          QLog.e("miniapp-process_AppBrandProxy", 1, "startMiniApp failed, intent = null");
          return;
        }
        paramBundle.setExtrasClassLoader(getClass().getClassLoader());
        paramBundle.putExtra("receiver", this.val$resultReceiver);
        if (this.val$activity != null) {
          this.val$activity.startActivity(paramBundle);
        } else {
          BaseApplicationImpl.getApplication().startActivity(paramBundle);
        }
        if ((this.val$appConfig != null) && (this.val$appConfig.isEngineTypeMiniGame()))
        {
          AnimUtil.clearAnim(this.val$activity);
          return;
        }
        AnimUtil.setOpenAnim(this.val$activity);
        return;
      }
      catch (Throwable paramBundle)
      {
        QLog.e("miniapp-process_AppBrandProxy", 1, "startMiniApp exception.", paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandProxyImpl.3
 * JD-Core Version:    0.7.0.1
 */