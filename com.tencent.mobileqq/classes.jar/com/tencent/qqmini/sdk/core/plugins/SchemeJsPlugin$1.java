package com.tencent.qqmini.sdk.core.plugins;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import bekr;
import betc;

class SchemeJsPlugin$1
  extends ResultReceiver
{
  SchemeJsPlugin$1(SchemeJsPlugin paramSchemeJsPlugin, Handler paramHandler, bekr parambekr, String paramString)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    betc.a("SchemeJsPlugin", "onReceiveResult resultCode : " + paramInt);
    if (paramInt == 1)
    {
      this.val$req.a();
      return;
    }
    String str = "";
    if (paramBundle != null) {
      str = paramBundle.getString("errMsg");
    }
    betc.a("SchemeJsPlugin", this.val$scheme + " failed, errMsg : " + str);
    this.val$req.a(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.SchemeJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */