package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.gprosdk.GProCategoryChannelIdList;
import com.tencent.gprosdk.GProChannel;
import com.tencent.gprosdk.GProSecurityResult;
import com.tencent.gprosdk.IGProCreateChannelCallback;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.IGetChannelInfoCallback;
import java.util.ArrayList;
import java.util.HashMap;

class GProSdkWrapperImpl$5
  implements IGProCreateChannelCallback
{
  GProSdkWrapperImpl$5(GProSdkWrapperImpl paramGProSdkWrapperImpl, String paramString, int paramInt, IGetChannelInfoCallback paramIGetChannelInfoCallback) {}
  
  public void onCreateChannelResult(int paramInt, String paramString, GProSecurityResult paramGProSecurityResult, GProChannel paramGProChannel, HashMap<Long, GProChannel> paramHashMap, GProCategoryChannelIdList paramGProCategoryChannelIdList, ArrayList<GProCategoryChannelIdList> paramArrayList)
  {
    GProSdkWrapperImpl.b(this.d).post(new GProSdkWrapperImpl.5.1(this, paramInt, paramString, paramGProChannel, paramGProSecurityResult, paramGProCategoryChannelIdList, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.5
 * JD-Core Version:    0.7.0.1
 */