package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.IGetGProUserCallback;
import java.util.ArrayList;

class GProSdkWrapperImpl$3$1
  implements Runnable
{
  GProSdkWrapperImpl$3$1(GProSdkWrapperImpl.3 param3, int paramInt, String paramString, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public void run()
  {
    int j = this.a;
    String str = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sucList size : ");
    ArrayList localArrayList = this.c;
    int i;
    if (localArrayList != null) {
      i = localArrayList.size();
    } else {
      i = 0;
    }
    localStringBuilder.append(i);
    localStringBuilder.append(", failList ：");
    localStringBuilder.append(this.d);
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper callback", "loadUserInfo", "Get DB member list", j, str, localStringBuilder.toString(), this.e.a);
    this.e.b.a(this.a, this.b, GProConvert.d(this.c), GProConvert.b(this.d));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.3.1
 * JD-Core Version:    0.7.0.1
 */