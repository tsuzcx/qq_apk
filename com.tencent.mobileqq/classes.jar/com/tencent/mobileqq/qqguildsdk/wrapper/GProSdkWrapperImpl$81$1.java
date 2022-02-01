package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.callback.IAppAuthorizationCallback;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

class GProSdkWrapperImpl$81$1
  implements Runnable
{
  GProSdkWrapperImpl$81$1(GProSdkWrapperImpl.81 param81, int paramInt1, String paramString, int paramInt2) {}
  
  public void run()
  {
    int i = this.a;
    String str = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("clientId: ");
    localStringBuilder.append(this.c);
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper callback", "appAuthorization", "", i, str, localStringBuilder.toString(), this.d.a);
    this.d.b.a(this.a, this.b, GProConvert.a(this.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.81.1
 * JD-Core Version:    0.7.0.1
 */