package com.tencent.mobileqq.troop.utils.api.impl;

import com.tencent.mobileqq.troop.roamsetting.api.impl.RoamSettingDataServiceImpl;
import java.util.List;

class BizTroopDBUtilsApiImpl$1
  implements Runnable
{
  BizTroopDBUtilsApiImpl$1(BizTroopDBUtilsApiImpl paramBizTroopDBUtilsApiImpl, RoamSettingDataServiceImpl paramRoamSettingDataServiceImpl, List paramList) {}
  
  public void run()
  {
    this.a.saveRoamSettingToDB(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.api.impl.BizTroopDBUtilsApiImpl.1
 * JD-Core Version:    0.7.0.1
 */