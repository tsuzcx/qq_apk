package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.gprosdk.GProAppChnnPreInfo;
import com.tencent.gprosdk.IGProFetchAppChnnPreInfoListCallback;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.IFetchAppChnnPreInfoListCallback;
import java.util.ArrayList;

class GProSdkWrapperImpl$79
  implements IGProFetchAppChnnPreInfoListCallback
{
  GProSdkWrapperImpl$79(GProSdkWrapperImpl paramGProSdkWrapperImpl, int paramInt, IFetchAppChnnPreInfoListCallback paramIFetchAppChnnPreInfoListCallback) {}
  
  public void onFetchAppChnnPreInfoList(int paramInt, String paramString, ArrayList<GProAppChnnPreInfo> paramArrayList, ArrayList<Long> paramArrayList1, ArrayList<Long> paramArrayList2, ArrayList<Long> paramArrayList3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("preList size:");
    localStringBuilder.append(paramArrayList.size());
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchAppChnnPreInfoList", "", paramInt, paramString, localStringBuilder.toString(), this.a);
    this.b.a(paramInt, paramString, GProConvert.h(paramArrayList), GProConvert.b(paramArrayList1), GProConvert.b(paramArrayList2), GProConvert.b(paramArrayList3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.79
 * JD-Core Version:    0.7.0.1
 */