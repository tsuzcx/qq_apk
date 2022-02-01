package com.tencent.mobileqq.qqexpand.manager;

import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;

class ExpandManager$1
  extends ProfileCardObserver
{
  ExpandManager$1(ExpandManager paramExpandManager) {}
  
  protected void onSetProfileDetail(boolean paramBoolean, int paramInt, Card paramCard)
  {
    if ((paramBoolean) && (paramInt == 0)) {
      ExpandManager.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.manager.ExpandManager.1
 * JD-Core Version:    0.7.0.1
 */