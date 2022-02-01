package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.GProSecurityResult;
import com.tencent.gprosdk.IGProResultCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ISetGuildTopCallback;

class GProSdkWrapperImpl$14
  implements IGProResultCallback
{
  GProSdkWrapperImpl$14(GProSdkWrapperImpl paramGProSdkWrapperImpl, int paramInt, ISetGuildTopCallback paramISetGuildTopCallback) {}
  
  public void onResult(int paramInt, String paramString, GProSecurityResult paramGProSecurityResult)
  {
    GProSdkWrapperImpl.b(this.c).post(new GProSdkWrapperImpl.14.1(this, paramInt, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.14
 * JD-Core Version:    0.7.0.1
 */