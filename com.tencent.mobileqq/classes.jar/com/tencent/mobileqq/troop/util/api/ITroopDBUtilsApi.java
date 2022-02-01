package com.tencent.mobileqq.troop.util.api;

import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import friendlist.stUinInfo;
import java.util.ArrayList;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface ITroopDBUtilsApi
  extends QRouteApi
{
  public abstract TroopMemberCardInfo getTroopMemberCardInfo(AppRuntime paramAppRuntime, String paramString1, String paramString2);
  
  public abstract TroopMemberInfo getTroopMemberInfo(AppRuntime paramAppRuntime, String paramString1, String paramString2);
  
  public abstract ArrayList<TroopMemberCardInfo> modifyTroopMemberCardInfo(AppRuntime paramAppRuntime, String paramString, ArrayList<stUinInfo> paramArrayList);
  
  public abstract boolean saveTroopMemberCardInfo(AppRuntime paramAppRuntime, TroopMemberCardInfo paramTroopMemberCardInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.util.api.ITroopDBUtilsApi
 * JD-Core Version:    0.7.0.1
 */