package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.GProEnterChannelPermission;
import com.tencent.gprosdk.IGProFetchEnterChannelPermissionCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchEnterChannelPermissionCallback;

class GProSdkWrapperImpl$66
  implements IGProFetchEnterChannelPermissionCallback
{
  GProSdkWrapperImpl$66(GProSdkWrapperImpl paramGProSdkWrapperImpl, int paramInt, IFetchEnterChannelPermissionCallback paramIFetchEnterChannelPermissionCallback) {}
  
  public void onFetchEnterChannelPermissionCallback(int paramInt, String paramString, GProEnterChannelPermission paramGProEnterChannelPermission)
  {
    GProSdkWrapperImpl.b(this.c).post(new GProSdkWrapperImpl.66.1(this, paramInt, paramString, paramGProEnterChannelPermission));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.66
 * JD-Core Version:    0.7.0.1
 */