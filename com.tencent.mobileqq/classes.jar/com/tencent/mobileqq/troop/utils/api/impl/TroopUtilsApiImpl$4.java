package com.tencent.mobileqq.troop.utils.api.impl;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import mqq.app.AppRuntime;

class TroopUtilsApiImpl$4
  implements Runnable
{
  TroopUtilsApiImpl$4(TroopUtilsApiImpl paramTroopUtilsApiImpl, AppRuntime paramAppRuntime, TroopInfo paramTroopInfo) {}
  
  public void run()
  {
    AppRuntime localAppRuntime = this.a;
    if (localAppRuntime != null) {
      ((ITroopInfoService)localAppRuntime.getRuntimeService(ITroopInfoService.class, "")).saveTroopInfo(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.api.impl.TroopUtilsApiImpl.4
 * JD-Core Version:    0.7.0.1
 */