package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.GProGuildUserSimpleProfile;
import com.tencent.gprosdk.IGProLoadGuildUserSimpleProfileCallback;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.ILoadSimpleProfilesCallback;
import java.util.ArrayList;

class GProSdkWrapperImpl$31
  implements IGProLoadGuildUserSimpleProfileCallback
{
  GProSdkWrapperImpl$31(GProSdkWrapperImpl paramGProSdkWrapperImpl, int paramInt, ILoadSimpleProfilesCallback paramILoadSimpleProfilesCallback) {}
  
  public void onLoadGuildUserSimpleProfileInfo(int paramInt, String paramString, long paramLong1, long paramLong2, ArrayList<GProGuildUserSimpleProfile> paramArrayList)
  {
    GProSdkWrapperImpl.b(this.c).post(new GProSdkWrapperImpl.31.1(this, paramInt, paramString, paramLong1, paramLong2, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.31
 * JD-Core Version:    0.7.0.1
 */