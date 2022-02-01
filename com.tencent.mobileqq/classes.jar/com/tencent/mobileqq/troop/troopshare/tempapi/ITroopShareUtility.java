package com.tencent.mobileqq.troop.troopshare.tempapi;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.mobileqq.troop.data.TroopInfoData;

@QAPI(process={""})
@QRouteFactory(singleton=false)
public abstract interface ITroopShareUtility
  extends QRouteApi
{
  public abstract void handleTroopLinkShare(TroopInfoData paramTroopInfoData);
  
  public abstract void initTroopShareUtility(Activity paramActivity, TroopInfoData paramTroopInfoData);
  
  public abstract void newTroopShareUtility(Activity paramActivity, TroopInfoData paramTroopInfoData);
  
  public abstract void onDestroy();
  
  public abstract void startTroop2DCode();
  
  public abstract void troopUtils_shareTroop(Activity paramActivity, TroopInfoData paramTroopInfoData, AppInterface paramAppInterface);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopshare.tempapi.ITroopShareUtility
 * JD-Core Version:    0.7.0.1
 */