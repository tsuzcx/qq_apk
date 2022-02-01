package com.tencent.mobileqq.vas.adv.common.data;

import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get.DropList;

public class AlumBasicData$DropData
{
  public int actionType;
  public String content;
  public String jumpUrl;
  public String logoUrl;
  
  public static DropData creatFromPb(vac_adv_get.DropList paramDropList)
  {
    if (paramDropList == null) {
      return null;
    }
    DropData localDropData = new DropData();
    localDropData.actionType = paramDropList.action_type.get();
    localDropData.content = paramDropList.optext.get();
    localDropData.logoUrl = paramDropList.iconurl.get();
    localDropData.jumpUrl = paramDropList.jumpurl.get();
    return localDropData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.common.data.AlumBasicData.DropData
 * JD-Core Version:    0.7.0.1
 */