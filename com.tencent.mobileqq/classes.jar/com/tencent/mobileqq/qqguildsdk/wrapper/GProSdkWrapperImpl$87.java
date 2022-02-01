package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.IGProSetGuildClientIdCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ISetGuildClientIdCallback;

class GProSdkWrapperImpl$87
  implements IGProSetGuildClientIdCallback
{
  GProSdkWrapperImpl$87(GProSdkWrapperImpl paramGProSdkWrapperImpl, int paramInt, ISetGuildClientIdCallback paramISetGuildClientIdCallback) {}
  
  public void onSetGuildClientId(int paramInt1, String paramString, long paramLong, int paramInt2)
  {
    GProSdkWrapperImpl.b(this.c).post(new GProSdkWrapperImpl.87.1(this, paramInt1, paramString, paramLong, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.87
 * JD-Core Version:    0.7.0.1
 */