package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.IGProBindAppRole;
import com.tencent.mobileqq.qqguildsdk.callback.IBindAppRoleCallback;

class GProSdkWrapperImpl$83
  implements IGProBindAppRole
{
  GProSdkWrapperImpl$83(GProSdkWrapperImpl paramGProSdkWrapperImpl, String paramString, int paramInt1, int paramInt2, IBindAppRoleCallback paramIBindAppRoleCallback) {}
  
  public void onBindAppRole(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    GProSdkWrapperImpl.b(this.e).post(new GProSdkWrapperImpl.83.1(this, paramInt1, paramString1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.83
 * JD-Core Version:    0.7.0.1
 */