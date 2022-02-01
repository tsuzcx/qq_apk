package com.tencent.mobileqq.extendfriend;

import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;

class ExtendFriendManager$1
  extends ProfileCardObserver
{
  ExtendFriendManager$1(ExtendFriendManager paramExtendFriendManager) {}
  
  public void onSetProfileDetail(boolean paramBoolean, int paramInt, Card paramCard)
  {
    if ((paramBoolean) && (paramInt == 0)) {
      ExtendFriendManager.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendFriendManager.1
 * JD-Core Version:    0.7.0.1
 */