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

class AppBrandProxyImpl$2$1
  extends ResultReceiver
{
  AppBrandProxyImpl$2$1(AppBrandProxyImpl.2 param2, Handler paramHandler)
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
      paramBundle.putParcelable("receiver", this.this$1.val$resultReceiver);
      localIntent.putExtras(paramBundle);
    }
    try
    {
      if (this.this$1.val$activity != null) {
        this.this$1.val$activity.startActivity(localIntent);
      }
      while ((this.this$1.val$appConfig != null) && (this.this$1.val$appConfig.isEngineTypeMiniGame()))
      {
        AnimUtil.clearAnim(this.this$1.val$activity);
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
      AnimUtil.setOpenAnim(this.this$1.val$activity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandProxyImpl.2.1
 * JD-Core Version:    0.7.0.1
 */