package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.IGProDealNoticeCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IDealNoticeCallback;

class GProSdkWrapperImpl$61
  implements IGProDealNoticeCallback
{
  GProSdkWrapperImpl$61(GProSdkWrapperImpl paramGProSdkWrapperImpl, int paramInt, IDealNoticeCallback paramIDealNoticeCallback) {}
  
  public void onDealNoticeResult(int paramInt1, String paramString1, int paramInt2, String paramString2, boolean paramBoolean)
  {
    GProSdkWrapperImpl.b(this.c).post(new GProSdkWrapperImpl.61.1(this, paramInt1, paramString1, paramInt2, paramString2, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.61
 * JD-Core Version:    0.7.0.1
 */