package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.IGProFetchIsVoiceChannelOpenCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchIsVoiceChannelOpenCallback;

class GProSdkWrapperImpl$38
  implements IGProFetchIsVoiceChannelOpenCallback
{
  GProSdkWrapperImpl$38(GProSdkWrapperImpl paramGProSdkWrapperImpl, int paramInt, IFetchIsVoiceChannelOpenCallback paramIFetchIsVoiceChannelOpenCallback) {}
  
  public void onRequestFetchIsVoiceChannelOpenCallback(int paramInt1, String paramString, int paramInt2)
  {
    GProSdkWrapperImpl.b(this.c).post(new GProSdkWrapperImpl.38.1(this, paramInt1, paramString, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.38
 * JD-Core Version:    0.7.0.1
 */