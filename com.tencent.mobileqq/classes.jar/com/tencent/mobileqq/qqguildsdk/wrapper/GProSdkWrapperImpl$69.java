package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.GProLiveRoomInfo;
import com.tencent.gprosdk.IGProFetchLiveChannelInfoListCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchLiveRoomInfoCallback;
import java.util.ArrayList;

class GProSdkWrapperImpl$69
  implements IGProFetchLiveChannelInfoListCallback
{
  GProSdkWrapperImpl$69(GProSdkWrapperImpl paramGProSdkWrapperImpl, int paramInt, IFetchLiveRoomInfoCallback paramIFetchLiveRoomInfoCallback) {}
  
  public void onFetchLiveRoomInfoList(int paramInt1, String paramString, ArrayList<GProLiveRoomInfo> paramArrayList, ArrayList<Long> paramArrayList1, int paramInt2)
  {
    GProSdkWrapperImpl.b(this.c).post(new GProSdkWrapperImpl.69.1(this, paramInt1, paramString, paramArrayList, paramArrayList1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.69
 * JD-Core Version:    0.7.0.1
 */