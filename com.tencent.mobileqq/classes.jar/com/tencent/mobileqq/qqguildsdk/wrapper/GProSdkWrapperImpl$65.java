package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.IGProFetchLiveChannelAnchorListCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchLiveChannelAnchorListCallback;
import java.util.ArrayList;

class GProSdkWrapperImpl$65
  implements IGProFetchLiveChannelAnchorListCallback
{
  GProSdkWrapperImpl$65(GProSdkWrapperImpl paramGProSdkWrapperImpl, int paramInt, IFetchLiveChannelAnchorListCallback paramIFetchLiveChannelAnchorListCallback) {}
  
  public void onFetchLiveChannelAnchorList(int paramInt, String paramString, ArrayList<Long> paramArrayList)
  {
    GProSdkWrapperImpl.b(this.c).post(new GProSdkWrapperImpl.65.1(this, paramInt, paramString, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.65
 * JD-Core Version:    0.7.0.1
 */