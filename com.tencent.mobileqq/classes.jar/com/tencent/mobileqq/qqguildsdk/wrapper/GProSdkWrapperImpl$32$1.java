package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.ILoadGuildAndChnListCallback;
import java.util.ArrayList;

class GProSdkWrapperImpl$32$1
  implements Runnable
{
  GProSdkWrapperImpl$32$1(GProSdkWrapperImpl.32 param32, ArrayList paramArrayList1, ArrayList paramArrayList2, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("guildList size ：");
    Object localObject = this.a;
    String str = "0";
    if (localObject != null) {
      localObject = Integer.valueOf(((ArrayList)localObject).size());
    } else {
      localObject = "0";
    }
    localStringBuilder.append(localObject);
    localStringBuilder.append(", map2GuildInit size ：");
    ArrayList localArrayList = this.b;
    localObject = str;
    if (localArrayList != null) {
      localObject = Integer.valueOf(localArrayList.size());
    }
    localStringBuilder.append(localObject);
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper callback", "initGuildAndChannelListWithId", "sdk-init", localStringBuilder.toString(), this.d.a);
    this.d.b.a(this.c, GProConvert.e(this.a), GProConvert.f(this.b), this.d.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.32.1
 * JD-Core Version:    0.7.0.1
 */