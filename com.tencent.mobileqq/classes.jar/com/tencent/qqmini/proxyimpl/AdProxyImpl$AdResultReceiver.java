package com.tencent.qqmini.proxyimpl;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import bknj;
import com.tencent.qphone.base.util.QLog;

public class AdProxyImpl$AdResultReceiver
  extends ResultReceiver
{
  private bknj a;
  
  public AdProxyImpl$AdResultReceiver(Handler paramHandler, bknj parambknj)
  {
    super(paramHandler);
    this.a = parambknj;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    if (this.a != null)
    {
      this.a.a(paramInt, paramBundle);
      return;
    }
    QLog.d("AdResultReceiver", 1, "adView is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.AdResultReceiver
 * JD-Core Version:    0.7.0.1
 */