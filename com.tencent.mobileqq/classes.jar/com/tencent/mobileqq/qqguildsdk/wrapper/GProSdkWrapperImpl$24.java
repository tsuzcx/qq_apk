package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.GProUser;
import com.tencent.gprosdk.IGProFetchChannelMemberListCallback;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.IFetchChannelMemberListCallback;
import java.util.ArrayList;

class GProSdkWrapperImpl$24
  implements IGProFetchChannelMemberListCallback
{
  GProSdkWrapperImpl$24(GProSdkWrapperImpl paramGProSdkWrapperImpl, int paramInt, IFetchChannelMemberListCallback paramIFetchChannelMemberListCallback) {}
  
  public void onFetchChannelMemberList(int paramInt, String paramString, long paramLong, boolean paramBoolean, ArrayList<GProUser> paramArrayList1, ArrayList<GProUser> paramArrayList2)
  {
    GProSdkWrapperImpl.b(this.c).post(new GProSdkWrapperImpl.24.1(this, paramArrayList1, paramArrayList2, paramInt, paramString, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.24
 * JD-Core Version:    0.7.0.1
 */