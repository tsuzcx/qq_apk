package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import java.util.ArrayList;

class GProSdkWrapperImpl$GProSdkListenerImpl$1
  implements Runnable
{
  GProSdkWrapperImpl$GProSdkListenerImpl$1(GProSdkWrapperImpl.GProSdkListenerImpl paramGProSdkListenerImpl, int paramInt, String paramString, boolean paramBoolean, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public void run()
  {
    int j = this.a;
    String str = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isChanged : ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", size : ");
    ArrayList localArrayList = this.d;
    int i;
    if (localArrayList != null) {
      i = localArrayList.size();
    } else {
      i = 0;
    }
    localStringBuilder.append(i);
    GProLog.b("GProSdkWrapperImpl", false, "system notify", "onGuildListUpdated", "notify", j, str, localStringBuilder.toString());
    this.f.a.a(this.a, this.c, GProConvert.b(this.e), GProConvert.e(this.d));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl.1
 * JD-Core Version:    0.7.0.1
 */