package com.tencent.mobileqq.troop.activity;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;

class JoinTroopUtil$1
  extends TroopMngObserver
{
  JoinTroopUtil$1(JoinTroopUtil paramJoinTroopUtil) {}
  
  protected void a(int paramInt1, int paramInt2)
  {
    JoinTroopUtil.a(this.a, false, paramInt1, paramInt2, null);
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    JoinTroopUtil.a(this.a, true, paramInt1, paramInt2, paramString);
  }
  
  protected void a(String paramString)
  {
    JoinTroopUtil.a(this.a, paramString);
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    JoinTroopUtil.a(this.a, paramBoolean, paramLong, paramTroopInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.JoinTroopUtil.1
 * JD-Core Version:    0.7.0.1
 */