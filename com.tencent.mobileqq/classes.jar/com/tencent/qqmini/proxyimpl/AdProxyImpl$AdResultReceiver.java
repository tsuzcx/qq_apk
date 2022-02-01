package com.tencent.qqmini.proxyimpl;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import bjvl;
import com.tencent.qphone.base.util.QLog;

public class AdProxyImpl$AdResultReceiver
  extends ResultReceiver
{
  private bjvl a;
  
  public AdProxyImpl$AdResultReceiver(Handler paramHandler, bjvl parambjvl)
  {
    super(paramHandler);
    this.a = parambjvl;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.AdResultReceiver
 * JD-Core Version:    0.7.0.1
 */