package com.tencent.mobileqq.troop.util.api;

import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ITroopMemberInfoUtilsApi
  extends QRouteApi
{
  public abstract boolean isValidTroopMemberInfo(TroopMemberInfo paramTroopMemberInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.util.api.ITroopMemberInfoUtilsApi
 * JD-Core Version:    0.7.0.1
 */