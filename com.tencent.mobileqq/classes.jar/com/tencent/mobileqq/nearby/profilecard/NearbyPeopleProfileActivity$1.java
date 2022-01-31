package com.tencent.mobileqq.nearby.profilecard;

import atxb;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;

class NearbyPeopleProfileActivity$1
  implements Runnable
{
  NearbyPeopleProfileActivity$1(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void run()
  {
    if ((this.this$0.a.a != null) && (this.this$0.a.a.equals(this.this$0.app.getCurrentAccountUin()))) {
      ((atxb)this.this$0.app.getManager(160)).a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.1
 * JD-Core Version:    0.7.0.1
 */