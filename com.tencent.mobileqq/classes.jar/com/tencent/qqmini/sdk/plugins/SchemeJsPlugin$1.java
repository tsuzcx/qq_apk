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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceiveResult resultCode : ");
    localStringBuilder.append(paramInt);
    QMLog.d("SchemeJsPlugin", localStringBuilder.toString());
    if (paramInt == 1)
    {
      this.val$req.ok();
      return;
    }
    if (paramBundle != null) {
      paramBundle = paramBundle.getString("errMsg");
    } else {
      paramBundle = "";
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.val$scheme);
    localStringBuilder.append(" failed, errMsg : ");
    localStringBuilder.append(paramBundle);
    QMLog.d("SchemeJsPlugin", localStringBuilder.toString());
    this.val$req.fail(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.SchemeJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */