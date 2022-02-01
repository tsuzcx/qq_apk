package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.IGProFetchIsLiveChannelOpenCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchIsLiveChannelOpenCallback;

class GProSdkWrapperImpl$73
  implements IGProFetchIsLiveChannelOpenCallback
{
  GProSdkWrapperImpl$73(GProSdkWrapperImpl paramGProSdkWrapperImpl, int paramInt, IFetchIsLiveChannelOpenCallback paramIFetchIsLiveChannelOpenCallback) {}
  
  public void onRequestFetchIsLiveChannelOpenCallback(int paramInt1, String paramString, int paramInt2)
  {
    GProSdkWrapperImpl.b(this.c).post(new GProSdkWrapperImpl.73.1(this, paramInt1, paramString, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.73
 * JD-Core Version:    0.7.0.1
 */