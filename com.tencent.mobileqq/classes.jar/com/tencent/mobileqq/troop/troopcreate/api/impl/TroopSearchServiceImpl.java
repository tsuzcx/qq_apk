package com.tencent.mobileqq.troop.troopcreate.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.troopcreate.TroopCreateUtils;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopSearchService;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopSearchService.TroopSearchCallback;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class TroopSearchServiceImpl
  implements ITroopSearchService
{
  private AppInterface mApp;
  ITroopInfoService troopInfoService;
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = ((AppInterface)paramAppRuntime);
    this.troopInfoService = ((ITroopInfoService)this.mApp.getRuntimeService(ITroopInfoService.class, ""));
  }
  
  public void onDestroy() {}
  
  public void search(ArrayList<ResultRecord> paramArrayList, boolean paramBoolean, ITroopSearchService.TroopSearchCallback paramTroopSearchCallback)
  {
    if (paramBoolean) {
      TroopCreateUtils.b(this.mApp, paramArrayList);
    }
    ThreadManager.postImmediately(new TroopSearchServiceImpl.TroopSearchTask(this, paramTroopSearchCallback, paramArrayList), null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.api.impl.TroopSearchServiceImpl
 * JD-Core Version:    0.7.0.1
 */