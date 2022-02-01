package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.GProCategoryChannelIdList;
import com.tencent.gprosdk.GProChannel;
import com.tencent.gprosdk.GProSecurityResult;
import com.tencent.gprosdk.IGProSetChannelCategoryInfoCallback;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.IGetChannelCategoryWithListCallback;
import java.util.ArrayList;
import java.util.HashMap;

class GProSdkWrapperImpl$49
  implements IGProSetChannelCategoryInfoCallback
{
  GProSdkWrapperImpl$49(GProSdkWrapperImpl paramGProSdkWrapperImpl, int paramInt, IGetChannelCategoryWithListCallback paramIGetChannelCategoryWithListCallback) {}
  
  public void onSetChannelCategoryInfo(int paramInt, String paramString, GProSecurityResult paramGProSecurityResult, HashMap<Long, GProChannel> paramHashMap, GProCategoryChannelIdList paramGProCategoryChannelIdList, ArrayList<GProCategoryChannelIdList> paramArrayList)
  {
    GProSdkWrapperImpl.b(this.c).post(new GProSdkWrapperImpl.49.1(this, paramInt, paramString, paramGProSecurityResult, paramGProCategoryChannelIdList, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.49
 * JD-Core Version:    0.7.0.1
 */