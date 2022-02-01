package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.GProPopupConfig;
import com.tencent.gprosdk.GProRole;
import com.tencent.gprosdk.IGProGetAppAuthorizationInfo;
import com.tencent.mobileqq.qqguildsdk.callback.IGetAppAuthorizationInfoCallback;

class GProSdkWrapperImpl$80
  implements IGProGetAppAuthorizationInfo
{
  GProSdkWrapperImpl$80(GProSdkWrapperImpl paramGProSdkWrapperImpl, int paramInt1, int paramInt2, IGetAppAuthorizationInfoCallback paramIGetAppAuthorizationInfoCallback) {}
  
  public void onGetAppAuthorizationInfo(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean, GProPopupConfig paramGProPopupConfig, GProRole paramGProRole)
  {
    GProSdkWrapperImpl.b(this.d).post(new GProSdkWrapperImpl.80.1(this, paramInt1, paramString, paramInt2, paramBoolean, paramGProPopupConfig, paramGProRole));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.80
 * JD-Core Version:    0.7.0.1
 */