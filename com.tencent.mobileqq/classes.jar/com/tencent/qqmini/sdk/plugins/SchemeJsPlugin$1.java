package com.tencent.qqmini.sdk.plugins;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class SchemeJsPlugin$1
  extends ResultReceiver
{
  SchemeJsPlugin$1(SchemeJsPlugin paramSchemeJsPlugin, Handler paramHandler, RequestEvent paramRequestEvent, String paramString)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    QMLog.d("SchemeJsPlugin", "onReceiveResult resultCode : " + paramInt);
    if (paramInt == 1)
    {
      this.val$req.ok();
      return;
    }
    String str = "";
    if (paramBundle != null) {
      str = paramBundle.getString("errMsg");
    }
    QMLog.d("SchemeJsPlugin", this.val$scheme + " failed, errMsg : " + str);
    this.val$req.fail(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.SchemeJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */