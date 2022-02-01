package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.IGProAppAuthorization;
import com.tencent.mobileqq.qqguildsdk.callback.IAppAuthorizationCallback;

class GProSdkWrapperImpl$81
  implements IGProAppAuthorization
{
  GProSdkWrapperImpl$81(GProSdkWrapperImpl paramGProSdkWrapperImpl, int paramInt, IAppAuthorizationCallback paramIAppAuthorizationCallback) {}
  
  public void onAppAuthorization(int paramInt1, String paramString, int paramInt2)
  {
    GProSdkWrapperImpl.b(this.c).post(new GProSdkWrapperImpl.81.1(this, paramInt1, paramString, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.81
 * JD-Core Version:    0.7.0.1
 */