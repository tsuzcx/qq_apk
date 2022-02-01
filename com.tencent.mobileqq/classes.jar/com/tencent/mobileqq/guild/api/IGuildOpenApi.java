package com.tencent.mobileqq.guild.api;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.guild.data.QQGuildOpenData;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IGuildOpenApi
  extends IRuntimeService
{
  public abstract QQGuildOpenData getGuildOpenDataFromApp(String paramString);
  
  public abstract void gotoGuildOpenAddAction(Activity paramActivity, String paramString1, String paramString2, QQGuildOpenData paramQQGuildOpenData);
  
  public abstract void gotoGuildOpenCreateAction(Activity paramActivity, String paramString1, String paramString2, QQGuildOpenData paramQQGuildOpenData);
  
  public abstract void handleBackToAppDialog(Activity paramActivity, String paramString, Bundle paramBundle);
  
  public abstract void handleEnterToTroop(String paramString1, String paramString2);
  
  public abstract void handleGuildOpenResult(String paramString1, String paramString2);
  
  public abstract void handleGuildOpenResult(String paramString1, String paramString2, long paramLong, String paramString3);
  
  public abstract void handleTroopBackToAppDialog(Activity paramActivity, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.IGuildOpenApi
 * JD-Core Version:    0.7.0.1
 */