package com.tencent.mobileqq.guild.message.eventflow;

import android.text.TextUtils;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi.GuildAioInfo;
import com.tencent.mobileqq.qroute.QRoute;

class GuildEventFlowHandler$1
  implements Runnable
{
  GuildEventFlowHandler$1(GuildEventFlowHandler paramGuildEventFlowHandler) {}
  
  public void run()
  {
    IGuildMessageUtilsApi.GuildAioInfo localGuildAioInfo = ((IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class)).checkIfInGuildAio();
    if ((localGuildAioInfo != null) && (!TextUtils.isEmpty(localGuildAioInfo.a)) && (!TextUtils.isEmpty(localGuildAioInfo.b))) {
      this.this$0.a(localGuildAioInfo.a, localGuildAioInfo.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.eventflow.GuildEventFlowHandler.1
 * JD-Core Version:    0.7.0.1
 */