package com.tencent.mobileqq.guild.api.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.guild.api.IGuildPtvPanelApi;
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.qroute.QRoute;

public class GuildPtvPanelApiImpl
  implements IGuildPtvPanelApi
{
  public void doShowPtvGuild(Context paramContext, boolean paramBoolean, Bundle paramBundle, String paramString1, String paramString2)
  {
    paramString1 = new LaunchGuildChatPieParam().a(paramString1).b(paramString2).a(null).b(true).c(false).d(true).b();
    paramBundle.putAll(((ILaunchGuildChatPieApi)QRoute.api(ILaunchGuildChatPieApi.class)).getGuildChatPieIntent(paramContext, paramString1).getExtras());
    int i;
    if (paramBoolean) {
      i = 200;
    } else {
      i = 204;
    }
    paramBundle.putInt("AECAMERA_MODE", i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.impl.GuildPtvPanelApiImpl
 * JD-Core Version:    0.7.0.1
 */