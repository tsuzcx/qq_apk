package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.GProSecurityResult;
import com.tencent.gprosdk.IGProResultCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ISetChannelAdminMsgNotifyTypeCallback;

class GProSdkWrapperImpl$18
  implements IGProResultCallback
{
  GProSdkWrapperImpl$18(GProSdkWrapperImpl paramGProSdkWrapperImpl, int paramInt, ISetChannelAdminMsgNotifyTypeCallback paramISetChannelAdminMsgNotifyTypeCallback) {}
  
  public void onResult(int paramInt, String paramString, GProSecurityResult paramGProSecurityResult)
  {
    GProSdkWrapperImpl.b(this.c).post(new GProSdkWrapperImpl.18.1(this, paramInt, paramString, paramGProSecurityResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.18
 * JD-Core Version:    0.7.0.1
 */