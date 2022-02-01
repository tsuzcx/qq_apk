package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.GProClientInfo;
import com.tencent.gprosdk.IGProGetClientInfoList;
import com.tencent.mobileqq.qqguildsdk.callback.IGetClientInfoListCallback;
import java.util.ArrayList;

class GProSdkWrapperImpl$84
  implements IGProGetClientInfoList
{
  GProSdkWrapperImpl$84(GProSdkWrapperImpl paramGProSdkWrapperImpl, int paramInt, IGetClientInfoListCallback paramIGetClientInfoListCallback) {}
  
  public void onGetClientInfoList(int paramInt1, String paramString, int paramInt2, ArrayList<GProClientInfo> paramArrayList)
  {
    GProSdkWrapperImpl.b(this.c).post(new GProSdkWrapperImpl.84.1(this, paramInt1, paramString, paramArrayList, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.84
 * JD-Core Version:    0.7.0.1
 */