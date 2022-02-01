package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.GProUser;
import com.tencent.gprosdk.IGProFetchVisibleMemberListByTinyIdCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchVisibleMemberListByTinyIdCallback;
import java.util.ArrayList;

class GProSdkWrapperImpl$26
  implements IGProFetchVisibleMemberListByTinyIdCallback
{
  GProSdkWrapperImpl$26(GProSdkWrapperImpl paramGProSdkWrapperImpl, int paramInt, IFetchVisibleMemberListByTinyIdCallback paramIFetchVisibleMemberListByTinyIdCallback) {}
  
  public void onFetchVisibleMemberListByTinyId(int paramInt, String paramString, ArrayList<GProUser> paramArrayList, ArrayList<Long> paramArrayList1)
  {
    GProSdkWrapperImpl.b(this.c).post(new GProSdkWrapperImpl.26.1(this, paramArrayList, paramArrayList1, paramInt, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.26
 * JD-Core Version:    0.7.0.1
 */