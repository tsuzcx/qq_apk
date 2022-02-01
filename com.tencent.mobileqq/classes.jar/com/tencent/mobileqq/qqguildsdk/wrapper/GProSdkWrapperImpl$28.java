package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.GProSecurityResult;
import com.tencent.gprosdk.GProUser;
import com.tencent.gprosdk.IGProSetGuildAdminResultCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;

class GProSdkWrapperImpl$28
  implements IGProSetGuildAdminResultCallback
{
  GProSdkWrapperImpl$28(GProSdkWrapperImpl paramGProSdkWrapperImpl, int paramInt, IResultWithSecurityCallback paramIResultWithSecurityCallback) {}
  
  public void onSetGuildAdminResult(int paramInt, String paramString, GProSecurityResult paramGProSecurityResult, GProUser paramGProUser)
  {
    GProSdkWrapperImpl.b(this.c).post(new GProSdkWrapperImpl.28.1(this, paramInt, paramString, paramGProSecurityResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.28
 * JD-Core Version:    0.7.0.1
 */