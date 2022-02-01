package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.ILoadSimpleProfilesCallback;
import java.util.ArrayList;

class GProSdkWrapperImpl$31$1
  implements Runnable
{
  GProSdkWrapperImpl$31$1(GProSdkWrapperImpl.31 param31, int paramInt, String paramString, long paramLong1, long paramLong2, ArrayList paramArrayList) {}
  
  public void run()
  {
    int i = this.a;
    String str = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("guildId ：");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", tinyId ：");
    localStringBuilder.append(this.d);
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper callback", "loadSimpleProfiles", "sdk-init", i, str, localStringBuilder.toString(), this.f.a);
    this.f.b.a(this.a, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.31.1
 * JD-Core Version:    0.7.0.1
 */