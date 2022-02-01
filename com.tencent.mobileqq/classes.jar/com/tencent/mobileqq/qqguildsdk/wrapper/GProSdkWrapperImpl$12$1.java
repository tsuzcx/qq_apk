package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.callback.IResultCallback;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

class GProSdkWrapperImpl$12$1
  implements Runnable
{
  GProSdkWrapperImpl$12$1(GProSdkWrapperImpl.12 param12, int paramInt, String paramString) {}
  
  public void run()
  {
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper callback", "destroyGuild", "ui", this.a, this.b, null, this.c.a);
    this.c.b.onResult(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.12.1
 * JD-Core Version:    0.7.0.1
 */