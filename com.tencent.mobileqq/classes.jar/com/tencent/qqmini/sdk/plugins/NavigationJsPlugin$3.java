package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class NavigationJsPlugin$3
  extends ResultReceiver
{
  NavigationJsPlugin$3(NavigationJsPlugin paramNavigationJsPlugin, Handler paramHandler, RequestEvent paramRequestEvent)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    if (paramInt == 0)
    {
      this.val$req.ok();
      if ((NavigationJsPlugin.access$000(this.this$0).getAttachedActivity() != null) && (!NavigationJsPlugin.access$100(this.this$0).getAttachedActivity().isFinishing())) {
        NavigationJsPlugin.access$200(this.this$0).getAttachedActivity().finish();
      }
      return;
    }
    this.val$req.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.NavigationJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */