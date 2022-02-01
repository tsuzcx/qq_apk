package com.tencent.mobileqq.troop.troopcreate.ui;

import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.troopmanager.api.TroopManagerBizObserver;

class TroopCreateLogicActivity$2
  extends TroopManagerBizObserver
{
  TroopCreateLogicActivity$2(TroopCreateLogicActivity paramTroopCreateLogicActivity) {}
  
  protected void onEditTroopLocationRet(long paramLong, int paramInt1, boolean paramBoolean, String paramString, int paramInt2, int paramInt3)
  {
    this.a.a.removeObserver(this);
    if (paramInt1 == 0)
    {
      ITroopInfoService localITroopInfoService = (ITroopInfoService)this.a.a.getRuntimeService(ITroopInfoService.class, "");
      localObject = null;
      if (localITroopInfoService != null) {
        localObject = localITroopInfoService.findTroopInfo(Long.toString(paramLong));
      }
      if (localObject != null)
      {
        ((TroopInfo)localObject).troopLat = paramInt2;
        ((TroopInfo)localObject).troopLon = paramInt3;
        localITroopInfoService.saveTroopInfo((TroopInfo)localObject);
      }
    }
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("troopUin", paramLong);
    ((Intent)localObject).putExtra("errCode", paramInt1);
    ((Intent)localObject).putExtra("isClear", paramBoolean);
    ((Intent)localObject).putExtra("location", paramString);
    ((Intent)localObject).putExtra("lat", paramInt2);
    ((Intent)localObject).putExtra("lon", paramInt3);
    this.a.setResult(-1, (Intent)localObject);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.TroopCreateLogicActivity.2
 * JD-Core Version:    0.7.0.1
 */