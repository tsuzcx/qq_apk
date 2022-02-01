package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.IGProCheckSelfRealNameVerifiedCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ICheckSelfRealNameVerifiedCallback;

class GProSdkWrapperImpl$72
  implements IGProCheckSelfRealNameVerifiedCallback
{
  GProSdkWrapperImpl$72(GProSdkWrapperImpl paramGProSdkWrapperImpl, int paramInt, ICheckSelfRealNameVerifiedCallback paramICheckSelfRealNameVerifiedCallback) {}
  
  public void onCheckSelfRealNameVerifiedCallback(int paramInt, String paramString1, long paramLong, String paramString2, String paramString3)
  {
    GProSdkWrapperImpl.b(this.c).post(new GProSdkWrapperImpl.72.1(this, paramInt, paramString1, paramString2, paramLong, paramString3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.72
 * JD-Core Version:    0.7.0.1
 */