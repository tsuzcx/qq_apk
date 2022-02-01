package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.IGProFetchRemainAtAllCountCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchRemainAtAllCountSink;

class GProSdkWrapperImpl$1
  implements IGProFetchRemainAtAllCountCallback
{
  GProSdkWrapperImpl$1(GProSdkWrapperImpl paramGProSdkWrapperImpl, int paramInt, IFetchRemainAtAllCountSink paramIFetchRemainAtAllCountSink, String paramString) {}
  
  public void onFetchRemainAtAllCount(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    GProSdkWrapperImpl.b(this.d).post(new GProSdkWrapperImpl.1.1(this, paramInt1, paramString, paramInt2, paramInt3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.1
 * JD-Core Version:    0.7.0.1
 */