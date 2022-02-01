package com.tencent.mobileqq.troop.troopshare.tempapi.impl;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopshare.tempapi.ITroopShareUtility;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troopshare.TroopShareUtility;

public class TroopShareUtilityImpl
  implements ITroopShareUtility
{
  private TroopShareUtility mTroopShare;
  
  public void handleTroopLinkShare(TroopInfoData paramTroopInfoData)
  {
    TroopShareUtility localTroopShareUtility = this.mTroopShare;
    if (localTroopShareUtility != null) {
      localTroopShareUtility.a(paramTroopInfoData);
    }
  }
  
  public void initTroopShareUtility(Activity paramActivity, TroopInfoData paramTroopInfoData)
  {
    if (this.mTroopShare != null) {
      onDestroy();
    }
    if ((paramActivity instanceof QBaseActivity)) {
      this.mTroopShare = new TroopShareUtility((QBaseActivity)paramActivity, paramTroopInfoData);
    }
  }
  
  public void newTroopShareUtility(Activity paramActivity, TroopInfoData paramTroopInfoData)
  {
    this.mTroopShare = new TroopShareUtility((QBaseActivity)paramActivity, paramTroopInfoData);
  }
  
  public void onDestroy()
  {
    TroopShareUtility localTroopShareUtility = this.mTroopShare;
    if (localTroopShareUtility == null) {
      return;
    }
    localTroopShareUtility.e();
    this.mTroopShare = null;
  }
  
  public void startTroop2DCode()
  {
    TroopShareUtility localTroopShareUtility = this.mTroopShare;
    if (localTroopShareUtility != null) {
      localTroopShareUtility.f();
    }
  }
  
  public void troopUtils_shareTroop(Activity paramActivity, TroopInfoData paramTroopInfoData, AppInterface paramAppInterface)
  {
    this.mTroopShare = TroopUtils.a((QBaseActivity)paramActivity, paramTroopInfoData, (QQAppInterface)paramAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopshare.tempapi.impl.TroopShareUtilityImpl
 * JD-Core Version:    0.7.0.1
 */