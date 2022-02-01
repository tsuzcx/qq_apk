package com.tencent.mobileqq.troop.activity;

import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;

class JoinTroopUtil$1
  extends TroopBusinessObserver
{
  JoinTroopUtil$1(JoinTroopUtil paramJoinTroopUtil) {}
  
  public void onGetAddTroopWebInfo(String paramString)
  {
    JoinTroopUtil.a(this.a, paramString);
  }
  
  public void onOIDB0X88D_1_Ret(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    JoinTroopUtil.a(this.a, paramBoolean, paramLong, paramTroopInfo);
  }
  
  public void onTroopManagerFailed(int paramInt1, int paramInt2)
  {
    JoinTroopUtil.a(this.a, false, paramInt1, paramInt2, null);
  }
  
  public void onTroopManagerSuccess(int paramInt1, int paramInt2, String paramString)
  {
    JoinTroopUtil.a(this.a, true, paramInt1, paramInt2, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.JoinTroopUtil.1
 * JD-Core Version:    0.7.0.1
 */