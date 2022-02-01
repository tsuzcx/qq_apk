package com.tencent.mobileqq.msf.sdk.utils;

import com.tencent.mobileqq.monitor.NetworkMonitorCallback;
import com.tencent.qphone.base.util.BaseApplication;

class d
  implements Runnable
{
  d(c paramc) {}
  
  public void run()
  {
    BaseApplication.networkMonitorCallback.addHttpInfo(this.a.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.utils.d
 * JD-Core Version:    0.7.0.1
 */