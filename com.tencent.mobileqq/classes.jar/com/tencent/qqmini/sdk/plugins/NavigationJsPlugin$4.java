package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class NavigationJsPlugin$4
  extends ResultReceiver
{
  NavigationJsPlugin$4(NavigationJsPlugin paramNavigationJsPlugin, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    if (paramInt == 0)
    {
      if ((NavigationJsPlugin.access$300(this.this$0).getAttachedActivity() != null) && (!NavigationJsPlugin.access$400(this.this$0).getAttachedActivity().isFinishing())) {
        NavigationJsPlugin.access$500(this.this$0).getAttachedActivity().finish();
      }
    }
    else {
      QMLog.e("NavigationJsPlugin", "navigateBackMiniApp failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.NavigationJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */