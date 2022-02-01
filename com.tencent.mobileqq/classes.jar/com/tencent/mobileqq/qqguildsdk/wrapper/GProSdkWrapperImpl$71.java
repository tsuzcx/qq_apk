package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.IGProFetchBannedUserListCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchLiveChannelBannedUserListCallback;
import java.util.ArrayList;

class GProSdkWrapperImpl$71
  implements IGProFetchBannedUserListCallback
{
  GProSdkWrapperImpl$71(GProSdkWrapperImpl paramGProSdkWrapperImpl, int paramInt, IFetchLiveChannelBannedUserListCallback paramIFetchLiveChannelBannedUserListCallback) {}
  
  public void onFetchBannedUserList(int paramInt, String paramString, ArrayList<Long> paramArrayList)
  {
    GProSdkWrapperImpl.b(this.c).post(new GProSdkWrapperImpl.71.1(this, paramInt, paramString, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.71
 * JD-Core Version:    0.7.0.1
 */