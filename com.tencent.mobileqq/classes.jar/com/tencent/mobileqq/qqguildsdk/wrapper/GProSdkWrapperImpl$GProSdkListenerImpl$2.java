package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.gprosdk.GProCategoryChannelIdList;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import java.util.ArrayList;
import java.util.HashMap;

class GProSdkWrapperImpl$GProSdkListenerImpl$2
  implements Runnable
{
  GProSdkWrapperImpl$GProSdkListenerImpl$2(GProSdkWrapperImpl.GProSdkListenerImpl paramGProSdkListenerImpl, int paramInt, String paramString, HashMap paramHashMap, long paramLong, GProCategoryChannelIdList paramGProCategoryChannelIdList, ArrayList paramArrayList) {}
  
  public void run()
  {
    int j = this.a;
    String str = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("size : ");
    HashMap localHashMap = this.c;
    int i;
    if (localHashMap != null) {
      i = localHashMap.size();
    } else {
      i = 0;
    }
    localStringBuilder.append(i);
    GProLog.b("GProSdkWrapperImpl", false, "system notify", "onChannelListUpdated", "notify", j, str, localStringBuilder.toString());
    this.g.a.a(this.a, GProConvert.a(this.d), GProConvert.a(this.c), GProConvert.a(this.e), GProConvert.f(this.f));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.2
 * JD-Core Version:    0.7.0.1
 */