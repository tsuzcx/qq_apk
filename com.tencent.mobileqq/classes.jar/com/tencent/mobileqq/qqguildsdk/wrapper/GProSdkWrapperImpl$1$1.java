package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.callback.IFetchRemainAtAllCountSink;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

class GProSdkWrapperImpl$1$1
  implements Runnable
{
  GProSdkWrapperImpl$1$1(GProSdkWrapperImpl.1 param1, int paramInt1, String paramString, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    int i = this.a;
    String str = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("remainCount ：");
    localStringBuilder.append(this.c);
    localStringBuilder.append("totalCount");
    localStringBuilder.append(this.d);
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper callback", "fetchRemainAtAllCount", "Get @ times", i, str, localStringBuilder.toString(), this.e.a);
    this.e.b.onFetchRemainAtAllCountResult(this.a, this.b, this.e.c, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.1.1
 * JD-Core Version:    0.7.0.1
 */