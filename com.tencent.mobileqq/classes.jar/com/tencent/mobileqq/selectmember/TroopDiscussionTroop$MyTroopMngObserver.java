package com.tencent.mobileqq.selectmember;

import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;

public class TroopDiscussionTroop$MyTroopMngObserver
  extends TroopMngObserver
{
  protected TroopDiscussionTroop$MyTroopMngObserver(TroopDiscussionTroop paramTroopDiscussionTroop) {}
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 6)
    {
      if (paramInt2 == 0) {
        this.a.c();
      }
    }
    else if (paramInt1 == 2)
    {
      if (paramInt2 == 0) {
        this.a.c();
      }
    }
    else if ((paramInt1 == 9) && (paramInt2 == 0)) {
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopDiscussionTroop.MyTroopMngObserver
 * JD-Core Version:    0.7.0.1
 */