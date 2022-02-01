package com.tencent.mobileqq.guild.api;

import android.content.Context;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IGuildInfoUtilsApi
  extends QRouteApi
{
  public abstract boolean canTalkinChannel(AppRuntime paramAppRuntime, String paramString1, String paramString2);
  
  public abstract boolean checkSecurityValid(IGProSecurityResult paramIGProSecurityResult);
  
  public abstract int getGuildSettingDrawable();
  
  public abstract boolean isCreatorOrAdmin(AppRuntime paramAppRuntime, String paramString);
  
  public abstract boolean isHomePage(AppRuntime paramAppRuntime, String paramString);
  
  public abstract void toastErrorAndSecurity(Context paramContext, int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi
 * JD-Core Version:    0.7.0.1
 */