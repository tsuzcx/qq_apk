package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.GProSecurityResult;
import com.tencent.gprosdk.IGProResultCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;

class GProSdkWrapperImpl$6
  implements IGProResultCallback
{
  GProSdkWrapperImpl$6(GProSdkWrapperImpl paramGProSdkWrapperImpl, String paramString, int paramInt, IResultWithSecurityCallback paramIResultWithSecurityCallback) {}
  
  public void onResult(int paramInt, String paramString, GProSecurityResult paramGProSecurityResult)
  {
    GProSdkWrapperImpl.b(this.d).post(new GProSdkWrapperImpl.6.1(this, paramInt, paramString, paramGProSecurityResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.6
 * JD-Core Version:    0.7.0.1
 */