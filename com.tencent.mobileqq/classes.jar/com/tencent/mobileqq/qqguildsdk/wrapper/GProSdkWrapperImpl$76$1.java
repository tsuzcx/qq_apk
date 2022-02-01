package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.callback.IQueryTinyIdByLiveUIDCallback;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import java.util.HashMap;

class GProSdkWrapperImpl$76$1
  implements Runnable
{
  GProSdkWrapperImpl$76$1(GProSdkWrapperImpl.76 param76, int paramInt, String paramString, HashMap paramHashMap) {}
  
  public void run()
  {
    int i = this.a;
    String str = this.b;
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper callback", "queryTinyIdByLiveUID", "", i, str, str, this.d.a);
    this.d.b.a(this.a, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.76.1
 * JD-Core Version:    0.7.0.1
 */