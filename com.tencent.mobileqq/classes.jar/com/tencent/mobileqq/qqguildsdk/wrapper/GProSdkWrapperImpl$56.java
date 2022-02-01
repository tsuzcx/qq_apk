package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.IGProFetchAddGuildOptionCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetAddGuildOptionCallback;

class GProSdkWrapperImpl$56
  implements IGProFetchAddGuildOptionCallback
{
  GProSdkWrapperImpl$56(GProSdkWrapperImpl paramGProSdkWrapperImpl, String paramString, int paramInt, IGetAddGuildOptionCallback paramIGetAddGuildOptionCallback) {}
  
  public void onFetchAddGuildOptionResult(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3)
  {
    GProSdkWrapperImpl.b(this.d).post(new GProSdkWrapperImpl.56.1(this, paramInt1, paramString1, paramInt2, paramString2, paramString3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.56
 * JD-Core Version:    0.7.0.1
 */