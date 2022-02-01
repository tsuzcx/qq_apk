package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.callback.IGetClientInfoListCallback;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import java.util.ArrayList;

class GProSdkWrapperImpl$84$1
  implements Runnable
{
  GProSdkWrapperImpl$84$1(GProSdkWrapperImpl.84 param84, int paramInt1, String paramString, ArrayList paramArrayList, int paramInt2) {}
  
  public void run()
  {
    int i = this.a;
    String str = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("clientInfoList: ");
    localStringBuilder.append(this.c);
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper callback", "getClientInfoList", "", i, str, localStringBuilder.toString(), this.e.a);
    this.e.b.a(this.a, this.b, this.d, GProConvert.e(this.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.84.1
 * JD-Core Version:    0.7.0.1
 */