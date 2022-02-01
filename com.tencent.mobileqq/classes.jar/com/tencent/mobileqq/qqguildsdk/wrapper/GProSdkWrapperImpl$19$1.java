package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.gprosdk.GProGuildUserProfile;
import com.tencent.mobileqq.qqguildsdk.callback.ILoadUserProfileInfoCallback;
import com.tencent.mobileqq.qqguildsdk.data.GProUserProfileInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserProfileInfo;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

class GProSdkWrapperImpl$19$1
  implements Runnable
{
  GProSdkWrapperImpl$19$1(GProSdkWrapperImpl.19 param19, int paramInt, String paramString, GProGuildUserProfile paramGProGuildUserProfile) {}
  
  public void run()
  {
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper callback", "loadGProUserProfileInfo", "ui", this.a, this.b, null, this.d.a);
    ILoadUserProfileInfoCallback localILoadUserProfileInfoCallback = this.d.b;
    int i = this.a;
    String str = this.b;
    Object localObject = this.c;
    if (localObject != null) {
      localObject = new GProUserProfileInfo((GProGuildUserProfile)localObject);
    } else {
      localObject = null;
    }
    localILoadUserProfileInfoCallback.onLoadUserProfileInfo(i, str, (IGProUserProfileInfo)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.19.1
 * JD-Core Version:    0.7.0.1
 */