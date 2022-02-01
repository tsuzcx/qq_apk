package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.GProGuildUserProfile;
import com.tencent.gprosdk.IGProLoadGuildUserProfileCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ILoadUserProfileInfoCallback;

class GProSdkWrapperImpl$19
  implements IGProLoadGuildUserProfileCallback
{
  GProSdkWrapperImpl$19(GProSdkWrapperImpl paramGProSdkWrapperImpl, int paramInt, ILoadUserProfileInfoCallback paramILoadUserProfileInfoCallback) {}
  
  public void onLoadGuildUserProfileInfo(int paramInt, String paramString, long paramLong1, long paramLong2, GProGuildUserProfile paramGProGuildUserProfile)
  {
    GProSdkWrapperImpl.b(this.c).post(new GProSdkWrapperImpl.19.1(this, paramInt, paramString, paramGProGuildUserProfile));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.19
 * JD-Core Version:    0.7.0.1
 */