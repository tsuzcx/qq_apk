package com.tencent.mobileqq.troop.trooplink.api;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ITroopLinkApi
  extends QRouteApi
{
  public abstract String getSmartManagerUrl(String paramString1, String paramString2, long paramLong1, long paramLong2);
  
  public abstract String getTroopHonorSettingUrl(String paramString, boolean paramBoolean);
  
  public abstract String getTroopHonorUrl(String paramString, int paramInt);
  
  public abstract String getTroopMemberHonorUrl(String paramString1, String paramString2);
  
  public abstract String getTroopMemberLevelUrl(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
  
  public abstract String getUrl(String paramString);
  
  public abstract String getUrl(String paramString, Bundle paramBundle);
  
  public abstract String replaceParams(String paramString, ITroopLinkApi.LinkParams paramLinkParams);
  
  public abstract boolean saveConfig(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.trooplink.api.ITroopLinkApi
 * JD-Core Version:    0.7.0.1
 */