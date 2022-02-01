package com.tencent.mobileqq.nearby.profilecard;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.profilecard.data.AllInOne;

class NearbyPeopleProfileActivity$1
  implements Runnable
{
  NearbyPeopleProfileActivity$1(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void run()
  {
    if ((this.this$0.allinone.uin != null) && (this.this$0.allinone.uin.equals(this.this$0.app.getCurrentAccountUin()))) {
      ((LocalRedTouchManager)this.this$0.app.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER)).a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.1
 * JD-Core Version:    0.7.0.1
 */