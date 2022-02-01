package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.GProNoticeRedPoint;
import com.tencent.gprosdk.IGProFetchNoticeRedPointCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchNoticeRedPointCallback;
import java.util.ArrayList;

class GProSdkWrapperImpl$62
  implements IGProFetchNoticeRedPointCallback
{
  GProSdkWrapperImpl$62(GProSdkWrapperImpl paramGProSdkWrapperImpl, int paramInt, IFetchNoticeRedPointCallback paramIFetchNoticeRedPointCallback) {}
  
  public void onFetchNoticeRedPointResult(int paramInt, String paramString, ArrayList<GProNoticeRedPoint> paramArrayList)
  {
    GProSdkWrapperImpl.b(this.c).post(new GProSdkWrapperImpl.62.1(this, paramArrayList, paramInt, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.62
 * JD-Core Version:    0.7.0.1
 */