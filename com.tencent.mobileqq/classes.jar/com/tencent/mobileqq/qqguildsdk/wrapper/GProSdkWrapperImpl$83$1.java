package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.callback.IBindAppRoleCallback;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

class GProSdkWrapperImpl$83$1
  implements Runnable
{
  GProSdkWrapperImpl$83$1(GProSdkWrapperImpl.83 param83, int paramInt1, String paramString, int paramInt2) {}
  
  public void run()
  {
    int i = this.a;
    String str = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("clientId: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", roleId: ");
    localStringBuilder.append(this.d.a);
    localStringBuilder.append(", type: ");
    localStringBuilder.append(this.d.b);
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper callback", "bindAppRole", "", i, str, localStringBuilder.toString(), this.d.c);
    this.d.d.a(this.a, this.b, GProConvert.a(this.c), this.d.a, this.d.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.83.1
 * JD-Core Version:    0.7.0.1
 */