package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.GProGuild;
import com.tencent.gprosdk.IGProFetchGuildInfoCallback;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.IFetchGuildInfoForImplCallback;

class GProSdkWrapperImpl$52
  implements IGProFetchGuildInfoCallback
{
  GProSdkWrapperImpl$52(GProSdkWrapperImpl paramGProSdkWrapperImpl, int paramInt, IFetchGuildInfoForImplCallback paramIFetchGuildInfoForImplCallback) {}
  
  public void onFetchGuildInfo(int paramInt, String paramString, GProGuild paramGProGuild)
  {
    GProSdkWrapperImpl.b(this.c).post(new GProSdkWrapperImpl.52.1(this, paramInt, paramString, paramGProGuild));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.52
 * JD-Core Version:    0.7.0.1
 */