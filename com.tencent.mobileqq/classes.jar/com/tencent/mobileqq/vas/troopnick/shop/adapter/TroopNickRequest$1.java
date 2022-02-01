package com.tencent.mobileqq.vas.troopnick.shop.adapter;

import QC.CGetChiefRsp;
import QC.UniBusiGetUserInfoRsp;
import java.util.Comparator;

class TroopNickRequest$1
  implements Comparator<Object>
{
  TroopNickRequest$1(TroopNickRequest paramTroopNickRequest) {}
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 instanceof UniBusiGetUserInfoRsp)) {}
    do
    {
      return -1;
      if ((paramObject2 instanceof UniBusiGetUserInfoRsp)) {
        return 1;
      }
    } while ((paramObject1 instanceof CGetChiefRsp));
    if ((paramObject2 instanceof CGetChiefRsp)) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopnick.shop.adapter.TroopNickRequest.1
 * JD-Core Version:    0.7.0.1
 */