package com.tencent.mobileqq.profilecard.base.container;

import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;

class ProfileLogicContainer$3
  extends CardObserver
{
  ProfileLogicContainer$3(ProfileLogicContainer paramProfileLogicContainer) {}
  
  protected void onGetLocationDescription(boolean paramBoolean, String paramString, Card paramCard)
  {
    if ((paramBoolean) && (paramCard != null) && (((ProfileCardInfo)ProfileLogicContainer.access$1000(this.this$0)).allInOne.uin.equals(paramCard.uin)) && (ProfileLogicContainer.access$1100(this.this$0) != null)) {
      ProfileLogicContainer.access$1200(this.this$0).notifyCardUpdate(paramCard);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.container.ProfileLogicContainer.3
 * JD-Core Version:    0.7.0.1
 */