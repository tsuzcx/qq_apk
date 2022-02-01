package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.callback.IResultCallback;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

class GProSdkWrapperImpl$88$1
  implements Runnable
{
  GProSdkWrapperImpl$88$1(GProSdkWrapperImpl.88 param88, int paramInt, String paramString) {}
  
  public void run()
  {
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper callback", "setFocusChannel", "", this.a, this.b, "", this.c.a);
    this.c.b.onResult(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.88.1
 * JD-Core Version:    0.7.0.1
 */