package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.IGProCheckUserBannedSpeakInChannelCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ICheckUserBannedSpeakInChannelCallback;

class GProSdkWrapperImpl$75
  implements IGProCheckUserBannedSpeakInChannelCallback
{
  GProSdkWrapperImpl$75(GProSdkWrapperImpl paramGProSdkWrapperImpl, int paramInt, ICheckUserBannedSpeakInChannelCallback paramICheckUserBannedSpeakInChannelCallback) {}
  
  public void onRequestCheckUserBannedSpeakInChannel(int paramInt1, String paramString, int paramInt2)
  {
    GProSdkWrapperImpl.b(this.c).post(new GProSdkWrapperImpl.75.1(this, paramInt1, paramString, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.75
 * JD-Core Version:    0.7.0.1
 */