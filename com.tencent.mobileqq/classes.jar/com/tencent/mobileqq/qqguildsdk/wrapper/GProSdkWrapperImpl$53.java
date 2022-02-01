package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.GProGuild;
import com.tencent.gprosdk.GProGuildInit;
import com.tencent.gprosdk.IGProFetchGuestGuildCallback;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.IFetchGuestGuildForImplCallback;

class GProSdkWrapperImpl$53
  implements IGProFetchGuestGuildCallback
{
  GProSdkWrapperImpl$53(GProSdkWrapperImpl paramGProSdkWrapperImpl, int paramInt, IFetchGuestGuildForImplCallback paramIFetchGuestGuildForImplCallback) {}
  
  public void onFetchGuestGuild(int paramInt, String paramString, GProGuild paramGProGuild, GProGuildInit paramGProGuildInit)
  {
    GProSdkWrapperImpl.b(this.c).post(new GProSdkWrapperImpl.53.1(this, paramInt, paramString, paramGProGuild, paramGProGuildInit));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.53
 * JD-Core Version:    0.7.0.1
 */