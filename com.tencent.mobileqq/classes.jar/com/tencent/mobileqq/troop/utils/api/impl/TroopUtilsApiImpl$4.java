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
    AppRuntime localAppRuntime = this.jdField_a_of_type_MqqAppAppRuntime;
    if (localAppRuntime != null) {
      ((ITroopInfoService)localAppRuntime.getRuntimeService(ITroopInfoService.class, "")).saveTroopInfo(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.api.impl.TroopUtilsApiImpl.4
 * JD-Core Version:    0.7.0.1
 */