package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.GProInviteInfo;
import com.tencent.gprosdk.GProSecurityResult;
import com.tencent.gprosdk.IGProFetchInviteInfoCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchInviteInfoCallback;

class GProSdkWrapperImpl$30
  implements IGProFetchInviteInfoCallback
{
  GProSdkWrapperImpl$30(GProSdkWrapperImpl paramGProSdkWrapperImpl, int paramInt, IFetchInviteInfoCallback paramIFetchInviteInfoCallback) {}
  
  public void onFetchInviteInfo(int paramInt, String paramString, GProSecurityResult paramGProSecurityResult, GProInviteInfo paramGProInviteInfo)
  {
    GProSdkWrapperImpl.b(this.c).post(new GProSdkWrapperImpl.30.1(this, paramInt, paramString, paramGProInviteInfo, paramGProSecurityResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.30
 * JD-Core Version:    0.7.0.1
 */