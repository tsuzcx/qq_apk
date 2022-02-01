package com.tencent.mobileqq.selectmember;

import com.tencent.mobileqq.app.BaseMessageObserver;

public class TroopDiscussionTroop$MyMessageObserver
  extends BaseMessageObserver
{
  protected TroopDiscussionTroop$MyMessageObserver(TroopDiscussionTroop paramTroopDiscussionTroop) {}
  
  protected void a()
  {
    this.a.c();
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 2001) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopDiscussionTroop.MyMessageObserver
 * JD-Core Version:    0.7.0.1
 */