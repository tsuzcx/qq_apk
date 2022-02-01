package com.tencent.mobileqq.guild.util;

import android.app.Activity;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.qroute.QRoute;

public class GuildProfileUtils
{
  public static void a(Activity paramActivity, GuildProfileData paramGuildProfileData)
  {
    ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).openGuildProfileDialog(paramActivity, paramGuildProfileData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.GuildProfileUtils
 * JD-Core Version:    0.7.0.1
 */