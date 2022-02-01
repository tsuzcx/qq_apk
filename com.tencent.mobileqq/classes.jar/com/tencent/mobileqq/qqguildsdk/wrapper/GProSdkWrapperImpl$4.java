package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.GProUser;
import com.tencent.gprosdk.IGProGetUserInfoCallback;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.IGetGProUserCallback;
import java.util.ArrayList;

class GProSdkWrapperImpl$4
  implements IGProGetUserInfoCallback
{
  GProSdkWrapperImpl$4(GProSdkWrapperImpl paramGProSdkWrapperImpl, int paramInt, IGetGProUserCallback paramIGetGProUserCallback) {}
  
  public void onGetUserInfo(int paramInt, String paramString, ArrayList<GProUser> paramArrayList, ArrayList<Long> paramArrayList1)
  {
    GProSdkWrapperImpl.b(this.c).post(new GProSdkWrapperImpl.4.1(this, paramInt, paramString, paramArrayList, paramArrayList1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.4
 * JD-Core Version:    0.7.0.1
 */