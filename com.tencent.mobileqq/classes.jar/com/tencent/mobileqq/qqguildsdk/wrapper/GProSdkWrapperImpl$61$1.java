package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.callback.IDealNoticeCallback;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;

class GProSdkWrapperImpl$61$1
  implements Runnable
{
  GProSdkWrapperImpl$61$1(GProSdkWrapperImpl.61 param61, int paramInt1, String paramString1, int paramInt2, String paramString2, boolean paramBoolean) {}
  
  public void run()
  {
    int i = this.a;
    String str = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dealCode:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" dealWording:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" removeNotice:");
    localStringBuilder.append(this.e);
    GProLog.b("GProSdkWrapperImpl", true, "sdkWrapper callback", "on dealNotice", "", i, str, localStringBuilder.toString(), this.f.a);
    int j = this.a;
    i = j;
    if (j == 0)
    {
      int k = this.c;
      i = j;
      if (k != 0) {
        i = k;
      }
    }
    this.f.b.a(i, this.d, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.61.1
 * JD-Core Version:    0.7.0.1
 */