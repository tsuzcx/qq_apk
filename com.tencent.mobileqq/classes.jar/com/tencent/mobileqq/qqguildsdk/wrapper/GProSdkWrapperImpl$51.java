package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.GProGuildInit;
import com.tencent.gprosdk.IGProFetchChannelListForGuestCallback;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.IFetchChannelListWithGuildInitForGuestCallback;
import java.util.ArrayList;

class GProSdkWrapperImpl$51
  implements IGProFetchChannelListForGuestCallback
{
  GProSdkWrapperImpl$51(GProSdkWrapperImpl paramGProSdkWrapperImpl, int paramInt, IFetchChannelListWithGuildInitForGuestCallback paramIFetchChannelListWithGuildInitForGuestCallback) {}
  
  public void onFetchChannelListForGuest(int paramInt, String paramString, ArrayList<GProGuildInit> paramArrayList)
  {
    GProSdkWrapperImpl.b(this.c).post(new GProSdkWrapperImpl.51.1(this, paramInt, paramString, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.51
 * JD-Core Version:    0.7.0.1
 */