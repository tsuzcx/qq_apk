package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.GProNotice;
import com.tencent.gprosdk.IGProGetMoreNoticeListCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetMoreNoticeListCallback;
import java.util.ArrayList;

class GProSdkWrapperImpl$60
  implements IGProGetMoreNoticeListCallback
{
  GProSdkWrapperImpl$60(GProSdkWrapperImpl paramGProSdkWrapperImpl, int paramInt, IGetMoreNoticeListCallback paramIGetMoreNoticeListCallback) {}
  
  public void onGetMoreNoticeList(int paramInt1, String paramString, boolean paramBoolean1, ArrayList<GProNotice> paramArrayList, int paramInt2, boolean paramBoolean2)
  {
    GProSdkWrapperImpl.b(this.c).post(new GProSdkWrapperImpl.60.1(this, paramInt1, paramString, paramArrayList, paramInt2, paramBoolean2, paramBoolean1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.60
 * JD-Core Version:    0.7.0.1
 */