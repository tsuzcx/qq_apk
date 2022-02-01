package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.callback.IGetAppRoleListCallback;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import java.util.ArrayList;

class GProSdkWrapperImpl$82$1
  implements Runnable
{
  GProSdkWrapperImpl$82$1(GProSdkWrapperImpl.82 param82, int paramInt1, String paramString1, int paramInt2, ArrayList paramArrayList, String paramString2, String paramString3) {}
  
  public void run()
  {
    int i = this.a;
    String str = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("clientId: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", roleList: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", title: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", toast: ");
    localStringBuilder.append(this.f);
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper callback", "getAppRoleList", "", i, str, localStringBuilder.toString(), this.g.a);
    this.g.b.a(this.a, this.b, GProConvert.a(this.c), GProConvert.c(this.d), this.e, this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.82.1
 * JD-Core Version:    0.7.0.1
 */