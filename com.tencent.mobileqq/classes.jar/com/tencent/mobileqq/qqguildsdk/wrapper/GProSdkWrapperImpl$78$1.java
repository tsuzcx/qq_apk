package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.IFetchAppInfoListCallback;
import java.util.ArrayList;

class GProSdkWrapperImpl$78$1
  implements Runnable
{
  GProSdkWrapperImpl$78$1(GProSdkWrapperImpl.78 param78, int paramInt, String paramString, boolean paramBoolean, ArrayList paramArrayList) {}
  
  public void run()
  {
    int i = this.a;
    String str = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isChange :");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", appInfoList size:");
    localStringBuilder.append(this.d.size());
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchAppInfoList", "", i, str, localStringBuilder.toString(), this.e.a);
    this.e.b.a(this.a, this.b, this.c, GProConvert.g(this.d));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.78.1
 * JD-Core Version:    0.7.0.1
 */