package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.gprosdk.GProPopupConfig;
import com.tencent.gprosdk.GProRole;
import com.tencent.mobileqq.qqguildsdk.callback.IGetAppAuthorizationInfoCallback;
import com.tencent.mobileqq.qqguildsdk.data.GProPopupConfigInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProRoleInfo;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

class GProSdkWrapperImpl$80$1
  implements Runnable
{
  GProSdkWrapperImpl$80$1(GProSdkWrapperImpl.80 param80, int paramInt1, String paramString, int paramInt2, boolean paramBoolean, GProPopupConfig paramGProPopupConfig, GProRole paramGProRole) {}
  
  public void run()
  {
    int i = this.a;
    String str = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("clientId: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", type: ");
    localStringBuilder.append(this.g.a);
    localStringBuilder.append(", bAuthorization: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", popupConfig: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", role: ");
    localStringBuilder.append(this.f);
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper callback", "getAppAuthorizationInfo", "", i, str, localStringBuilder.toString(), this.g.b);
    this.g.c.a(this.a, this.b, GProConvert.a(this.c), this.g.a, this.d, new GProPopupConfigInfo(this.e), new GProRoleInfo(this.f));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.80.1
 * JD-Core Version:    0.7.0.1
 */