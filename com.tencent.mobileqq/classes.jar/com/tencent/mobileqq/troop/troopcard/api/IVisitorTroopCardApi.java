package com.tencent.mobileqq.troop.troopcard.api;

import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IVisitorTroopCardApi
  extends QRouteApi
{
  public abstract Class<? extends QPublicBaseFragment> getVisitorTroopCardFragmentClass();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.api.IVisitorTroopCardApi
 * JD-Core Version:    0.7.0.1
 */