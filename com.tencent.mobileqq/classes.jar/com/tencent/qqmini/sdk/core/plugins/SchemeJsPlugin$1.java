package com.tencent.qqmini.sdk.core.plugins;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import bgok;
import com.tencent.qqmini.sdk.log.QMLog;

class SchemeJsPlugin$1
  extends ResultReceiver
{
  SchemeJsPlugin$1(SchemeJsPlugin paramSchemeJsPlugin, Handler paramHandler, bgok parambgok, String paramString)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    QMLog.d("SchemeJsPlugin", "onReceiveResult resultCode : " + paramInt);
    if (paramInt == 1)
    {
      this.val$req.a();
      return;
    }
    String str = "";
    if (paramBundle != null) {
      str = paramBundle.getString("errMsg");
    }
    QMLog.d("SchemeJsPlugin", this.val$scheme + " failed, errMsg : " + str);
    this.val$req.a(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.SchemeJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */