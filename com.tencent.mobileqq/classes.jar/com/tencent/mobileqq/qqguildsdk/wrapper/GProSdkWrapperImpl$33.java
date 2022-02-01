package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.GProEnterChannleInfoResult;
import com.tencent.gprosdk.GProSecurityResult;
import com.tencent.gprosdk.IGProEnterAudioChannelCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IEnterAudioChannelCallback;

class GProSdkWrapperImpl$33
  implements IGProEnterAudioChannelCallback
{
  GProSdkWrapperImpl$33(GProSdkWrapperImpl paramGProSdkWrapperImpl, String paramString1, String paramString2, int paramInt, IEnterAudioChannelCallback paramIEnterAudioChannelCallback) {}
  
  public void onEnterAudioChannel(int paramInt, String paramString, GProSecurityResult paramGProSecurityResult, GProEnterChannleInfoResult paramGProEnterChannleInfoResult)
  {
    GProSdkWrapperImpl.b(this.e).post(new GProSdkWrapperImpl.33.1(this, paramInt, paramString, paramGProSecurityResult, paramGProEnterChannleInfoResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.33
 * JD-Core Version:    0.7.0.1
 */