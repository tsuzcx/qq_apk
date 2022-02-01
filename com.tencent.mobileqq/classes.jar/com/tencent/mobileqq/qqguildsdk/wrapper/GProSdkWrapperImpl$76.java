package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.IGProQueryTinyIdByLiveUIDCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IQueryTinyIdByLiveUIDCallback;
import java.util.HashMap;

class GProSdkWrapperImpl$76
  implements IGProQueryTinyIdByLiveUIDCallback
{
  GProSdkWrapperImpl$76(GProSdkWrapperImpl paramGProSdkWrapperImpl, int paramInt, IQueryTinyIdByLiveUIDCallback paramIQueryTinyIdByLiveUIDCallback) {}
  
  public void onQueryTinyIdByLiveUIDCallback(int paramInt, String paramString, HashMap<Long, Long> paramHashMap)
  {
    GProSdkWrapperImpl.b(this.c).post(new GProSdkWrapperImpl.76.1(this, paramInt, paramString, paramHashMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.76
 * JD-Core Version:    0.7.0.1
 */