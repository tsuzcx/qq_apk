package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.IGProFetchLiveSecurityTipsCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchLiveSecurityTipsCallback;

class GProSdkWrapperImpl$74
  implements IGProFetchLiveSecurityTipsCallback
{
  GProSdkWrapperImpl$74(GProSdkWrapperImpl paramGProSdkWrapperImpl, int paramInt, IFetchLiveSecurityTipsCallback paramIFetchLiveSecurityTipsCallback) {}
  
  public void onFetchLiveSecurityTipsCallback(int paramInt, String paramString1, String paramString2)
  {
    GProSdkWrapperImpl.b(this.c).post(new GProSdkWrapperImpl.74.1(this, paramInt, paramString1, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.74
 * JD-Core Version:    0.7.0.1
 */