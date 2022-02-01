package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.gprosdk.GProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchShareInfoCallback;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

class GProSdkWrapperImpl$29$1
  implements Runnable
{
  GProSdkWrapperImpl$29$1(GProSdkWrapperImpl.29 param29, int paramInt, String paramString1, String paramString2, String paramString3, GProSecurityResult paramGProSecurityResult) {}
  
  public void run()
  {
    int i = this.a;
    String str = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("shareUrl ：");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", shareInfo ：");
    localStringBuilder.append(this.d);
    localStringBuilder.append(GProSdkWrapperImpl.a(this.f.c, this.e));
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchShareInfo", "ui-for Invite Url", i, str, localStringBuilder.toString(), this.f.a);
    this.f.b.a(this.a, this.b, this.c, this.d, GProSdkWrapperImpl.b(this.f.c, this.e));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.29.1
 * JD-Core Version:    0.7.0.1
 */