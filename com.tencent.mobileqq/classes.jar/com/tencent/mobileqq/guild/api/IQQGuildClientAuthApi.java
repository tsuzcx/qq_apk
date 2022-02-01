package com.tencent.mobileqq.guild.api;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.client.GuildClientParams;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={""})
public abstract interface IQQGuildClientAuthApi
  extends QRouteApi
{
  public abstract void clientAuthorizationForAIOPlus(QBaseActivity paramQBaseActivity, GuildClientParams paramGuildClientParams);
  
  public abstract void clientAuthorizationForArk(QBaseActivity paramQBaseActivity, GuildClientParams paramGuildClientParams);
  
  public abstract void showClientGuideAuthDialog(QBaseActivity paramQBaseActivity, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.IQQGuildClientAuthApi
 * JD-Core Version:    0.7.0.1
 */