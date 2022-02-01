package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.gprosdk.GProCategoryChannelIdList;
import com.tencent.gprosdk.GProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.IGetChannelCategoryWithListCallback;
import java.util.ArrayList;

class GProSdkWrapperImpl$45$1
  implements Runnable
{
  GProSdkWrapperImpl$45$1(GProSdkWrapperImpl.45 param45, int paramInt, String paramString, GProSecurityResult paramGProSecurityResult, GProCategoryChannelIdList paramGProCategoryChannelIdList, ArrayList paramArrayList) {}
  
  public void run()
  {
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper callback", "setChannelCategoryWithId", "", this.a, this.b, GProSdkWrapperImpl.a(this.f.c, this.c, this.d, this.e), this.f.a);
    this.f.b.a(this.a, this.b, GProSdkWrapperImpl.b(this.f.c, this.c), GProConvert.a(this.d), GProConvert.f(this.e));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.45.1
 * JD-Core Version:    0.7.0.1
 */