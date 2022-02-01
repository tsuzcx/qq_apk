package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.GProGuild;
import com.tencent.gprosdk.GProGuildInit;
import com.tencent.gprosdk.IGProLoadGuildAndChnListCallback;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.ILoadGuildAndChnListCallback;
import java.util.ArrayList;
import java.util.List;

class GProSdkWrapperImpl$32
  implements IGProLoadGuildAndChnListCallback
{
  GProSdkWrapperImpl$32(GProSdkWrapperImpl paramGProSdkWrapperImpl, int paramInt, ILoadGuildAndChnListCallback paramILoadGuildAndChnListCallback, List paramList) {}
  
  public void onLoadGuildAndChannelList(ArrayList<GProGuild> paramArrayList, ArrayList<GProGuildInit> paramArrayList1, byte[] paramArrayOfByte)
  {
    GProSdkWrapperImpl.b(this.d).post(new GProSdkWrapperImpl.32.1(this, paramArrayList, paramArrayList1, paramArrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.32
 * JD-Core Version:    0.7.0.1
 */