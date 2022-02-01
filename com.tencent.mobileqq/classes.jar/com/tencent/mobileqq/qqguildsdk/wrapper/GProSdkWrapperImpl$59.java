package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.GProNotice;
import com.tencent.gprosdk.IGProInitGetNoticeListCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IInitGetNoticeListCallback;
import java.util.ArrayList;

class GProSdkWrapperImpl$59
  implements IGProInitGetNoticeListCallback
{
  GProSdkWrapperImpl$59(GProSdkWrapperImpl paramGProSdkWrapperImpl, int paramInt, IInitGetNoticeListCallback paramIInitGetNoticeListCallback) {}
  
  public void onInitGetNoticeList(int paramInt1, String paramString, ArrayList<GProNotice> paramArrayList, int paramInt2, boolean paramBoolean)
  {
    GProSdkWrapperImpl.b(this.c).post(new GProSdkWrapperImpl.59.1(this, paramInt1, paramString, paramArrayList, paramInt2, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.59
 * JD-Core Version:    0.7.0.1
 */