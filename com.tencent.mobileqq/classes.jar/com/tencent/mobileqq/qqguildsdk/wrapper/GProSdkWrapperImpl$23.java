package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.GProUser;
import com.tencent.gprosdk.IGProFetchVisibleMemberListCallback;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.IFetchVisibleMemberListCallback;
import java.util.ArrayList;

class GProSdkWrapperImpl$23
  implements IGProFetchVisibleMemberListCallback
{
  GProSdkWrapperImpl$23(GProSdkWrapperImpl paramGProSdkWrapperImpl, int paramInt, IFetchVisibleMemberListCallback paramIFetchVisibleMemberListCallback) {}
  
  public void onFetchVisibleMemberList(int paramInt1, String paramString, int paramInt2, long paramLong, boolean paramBoolean, ArrayList<GProUser> paramArrayList)
  {
    GProSdkWrapperImpl.b(this.c).post(new GProSdkWrapperImpl.23.1(this, paramInt2, paramLong, paramArrayList, paramInt1, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.23
 * JD-Core Version:    0.7.0.1
 */