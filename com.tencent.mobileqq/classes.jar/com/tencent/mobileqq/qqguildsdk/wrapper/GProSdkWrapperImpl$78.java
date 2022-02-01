package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.GProAppInfo;
import com.tencent.gprosdk.IGProFetchAppInfoListCallback;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.IFetchAppInfoListCallback;
import java.util.ArrayList;

class GProSdkWrapperImpl$78
  implements IGProFetchAppInfoListCallback
{
  GProSdkWrapperImpl$78(GProSdkWrapperImpl paramGProSdkWrapperImpl, int paramInt, IFetchAppInfoListCallback paramIFetchAppInfoListCallback) {}
  
  public void onFetchAppInfoList(int paramInt, String paramString, boolean paramBoolean, ArrayList<GProAppInfo> paramArrayList)
  {
    GProSdkWrapperImpl.b(this.c).post(new GProSdkWrapperImpl.78.1(this, paramInt, paramString, paramBoolean, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.78
 * JD-Core Version:    0.7.0.1
 */