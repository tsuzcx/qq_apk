package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.gprosdk.GProCategoryChannelIdList;
import com.tencent.gprosdk.GProChannel;
import com.tencent.gprosdk.GProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.GProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.IGetChannelInfoCallback;
import java.util.ArrayList;

class GProSdkWrapperImpl$5$1
  implements Runnable
{
  GProSdkWrapperImpl$5$1(GProSdkWrapperImpl.5 param5, int paramInt, String paramString, GProChannel paramGProChannel, GProSecurityResult paramGProSecurityResult, GProCategoryChannelIdList paramGProCategoryChannelIdList, ArrayList paramArrayList) {}
  
  public void run()
  {
    int i = this.a;
    Object localObject1 = this.b;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("guildId ：");
    ((StringBuilder)localObject2).append(this.g.a);
    ((StringBuilder)localObject2).append(", channelId:");
    ((StringBuilder)localObject2).append(this.c.getChannelId());
    ((StringBuilder)localObject2).append(GProSdkWrapperImpl.a(this.g.d, this.d));
    GProLog.b("GProSdkWrapperImpl", false, "sdkWrapper callback", "createChannelWithId", "new id", i, (String)localObject1, ((StringBuilder)localObject2).toString(), this.g.b);
    localObject2 = this.g.c;
    i = this.a;
    String str = this.b;
    localObject1 = this.c;
    if (localObject1 != null) {
      localObject1 = new GProChannelInfo((GProChannel)localObject1);
    } else {
      localObject1 = null;
    }
    ((IGetChannelInfoCallback)localObject2).a(i, str, (GProChannelInfo)localObject1, GProSdkWrapperImpl.b(this.g.d, this.d), GProConvert.a(this.e), GProConvert.f(this.f));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.5.1
 * JD-Core Version:    0.7.0.1
 */