package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.GProSecurityResult;
import com.tencent.gprosdk.IGProResultCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ISetChannelMsgNotifyTypeCallback;

class GProSdkWrapperImpl$20
  implements IGProResultCallback
{
  GProSdkWrapperImpl$20(GProSdkWrapperImpl paramGProSdkWrapperImpl, int paramInt, ISetChannelMsgNotifyTypeCallback paramISetChannelMsgNotifyTypeCallback) {}
  
  public void onResult(int paramInt, String paramString, GProSecurityResult paramGProSecurityResult)
  {
    GProSdkWrapperImpl.b(this.c).post(new GProSdkWrapperImpl.20.1(this, paramInt, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.20
 * JD-Core Version:    0.7.0.1
 */