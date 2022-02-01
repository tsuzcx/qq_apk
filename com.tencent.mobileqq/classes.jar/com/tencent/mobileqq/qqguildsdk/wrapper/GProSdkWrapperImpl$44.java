package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.GProGuildJoin;
import com.tencent.gprosdk.GProSecurityResult;
import com.tencent.gprosdk.IGProFetchGuildInfoByAppIdentityCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchGuildInfoByAppIdentityCallback;

class GProSdkWrapperImpl$44
  implements IGProFetchGuildInfoByAppIdentityCallback
{
  GProSdkWrapperImpl$44(GProSdkWrapperImpl paramGProSdkWrapperImpl, IFetchGuildInfoByAppIdentityCallback paramIFetchGuildInfoByAppIdentityCallback) {}
  
  public void onFetchGuildInfoByAppIdentity(int paramInt, String paramString, GProGuildJoin paramGProGuildJoin, GProSecurityResult paramGProSecurityResult)
  {
    GProSdkWrapperImpl.b(this.b).post(new GProSdkWrapperImpl.44.1(this, paramInt, paramString, paramGProGuildJoin, paramGProSecurityResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.44
 * JD-Core Version:    0.7.0.1
 */