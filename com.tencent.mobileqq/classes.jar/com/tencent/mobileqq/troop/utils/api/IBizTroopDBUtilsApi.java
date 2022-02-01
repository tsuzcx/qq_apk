package com.tencent.mobileqq.troop.utils.api;

import GeneralSettings.Setting;
import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@QAPI(process={"all"})
public abstract interface IBizTroopDBUtilsApi
  extends QRouteApi
{
  public abstract Map<String, Integer> getTroopMsgFilter(List<String> paramList, int paramInt, AppInterface paramAppInterface);
  
  public abstract void removeToopMsgFilter(AppInterface paramAppInterface, String paramString1, String paramString2, Context paramContext);
  
  public abstract void saveGeneralSettings(ArrayList<Setting> paramArrayList, AppInterface paramAppInterface);
  
  public abstract void saveGeneralSettingsRevision(int paramInt, AppInterface paramAppInterface);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.api.IBizTroopDBUtilsApi
 * JD-Core Version:    0.7.0.1
 */