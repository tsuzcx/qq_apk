package com.tencent.mobileqq.selectmember;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.observer.TroopModifyObserver;

public class TroopDiscussionTroop$MyTroopModifyObserver
  extends TroopModifyObserver
{
  protected TroopDiscussionTroop$MyTroopModifyObserver(TroopDiscussionTroop paramTroopDiscussionTroop) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    if (paramBoolean) {
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopDiscussionTroop.MyTroopModifyObserver
 * JD-Core Version:    0.7.0.1
 */