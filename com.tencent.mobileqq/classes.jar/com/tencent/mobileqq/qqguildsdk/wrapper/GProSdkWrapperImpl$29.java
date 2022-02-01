package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.GProSecurityResult;
import com.tencent.gprosdk.IGProFetchShareInfoCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchShareInfoCallback;

class GProSdkWrapperImpl$29
  implements IGProFetchShareInfoCallback
{
  GProSdkWrapperImpl$29(GProSdkWrapperImpl paramGProSdkWrapperImpl, int paramInt, IFetchShareInfoCallback paramIFetchShareInfoCallback) {}
  
  public void onFetchShareInfo(int paramInt, String paramString1, GProSecurityResult paramGProSecurityResult, String paramString2, String paramString3)
  {
    GProSdkWrapperImpl.b(this.c).post(new GProSdkWrapperImpl.29.1(this, paramInt, paramString1, paramString2, paramString3, paramGProSecurityResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.29
 * JD-Core Version:    0.7.0.1
 */