package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

class GProSdkWrapperImpl$GProSdkListenerImpl$35
  implements Runnable
{
  GProSdkWrapperImpl$GProSdkListenerImpl$35(GProSdkWrapperImpl.GProSdkListenerImpl paramGProSdkListenerImpl, long paramLong) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("tinyId:");
    ((StringBuilder)localObject).append(this.a);
    GProLog.b("GProSdkWrapperImpl", false, "system notify", "onGetSelfTinyId", "notify", ((StringBuilder)localObject).toString());
    if (this.a == 0L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("tinyId:");
      ((StringBuilder)localObject).append(this.a);
      GProLog.a("GProSdkWrapperImpl", "onGetSelfTinyId", ((StringBuilder)localObject).toString());
      return;
    }
    localObject = this.b.a.m();
    if ((localObject == null) || (!((String)localObject).equals(GProConvert.a(this.a)))) {
      this.b.a.s(GProConvert.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.35
 * JD-Core Version:    0.7.0.1
 */