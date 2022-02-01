package com.tencent.mobileqq.troop.troopsetting.activity;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAppService;
import com.tencent.mobileqq.troop.troopapps.api.ITroopCardAppInfoHelperApi.IGetAppInfoCB;
import com.tencent.mobileqq.troop.troopapps.data.TroopAppInfo;
import java.util.ArrayList;
import java.util.Iterator;

class TroopSettingActivity$20
  implements ITroopCardAppInfoHelperApi.IGetAppInfoCB
{
  TroopSettingActivity$20(TroopSettingActivity paramTroopSettingActivity) {}
  
  public void a() {}
  
  public void a(ArrayList<TroopAppInfo> paramArrayList)
  {
    if ((!this.a.isFinishing()) && (paramArrayList != null))
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      ITroopAppService localITroopAppService = (ITroopAppService)TroopSettingActivity.a(this.a).getRuntimeService(ITroopAppService.class, "all");
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        TroopAppInfo localTroopAppInfo = (TroopAppInfo)paramArrayList.next();
        localITroopAppService.addTroopAppInfo(Long.valueOf(localTroopAppInfo.appId), localTroopAppInfo);
        localArrayList.add(Long.valueOf(localTroopAppInfo.appId));
      }
      localITroopAppService.setTroopCardAppListCache(this.a.a.troopUin, localArrayList);
      boolean bool = this.a.j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.20
 * JD-Core Version:    0.7.0.1
 */