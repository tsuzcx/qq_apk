package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.ILoadAllMemberListCallback;
import java.util.ArrayList;

class GProSdkWrapperImpl$90$1
  implements Runnable
{
  GProSdkWrapperImpl$90$1(GProSdkWrapperImpl.90 param90, int paramInt, String paramString, boolean paramBoolean, ArrayList paramArrayList) {}
  
  public void run()
  {
    int i = this.a;
    String str = this.b;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("hasMore:");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append(this.d);
    if (((StringBuilder)localObject).toString() != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(", memberList size: ");
      ((StringBuilder)localObject).append(this.d.size());
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "";
    }
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper callback", "loadAllMemberList", "", i, str, (String)localObject, this.e.a);
    this.e.b.a(this.a, this.b, this.c, GProConvert.d(this.d));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.90.1
 * JD-Core Version:    0.7.0.1
 */