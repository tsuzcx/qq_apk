package com.tencent.mobileqq.nearby.profilecard;

import aukn;
import auko;
import bbjw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;

class NearbyPeopleProfileActivity$22
  implements Runnable
{
  NearbyPeopleProfileActivity$22(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void run()
  {
    if (!bbjw.a(NearbyPeopleProfileActivity.a(this.this$0).uin)) {
      this.this$0.app.a(NearbyPeopleProfileActivity.a(this.this$0).uin, 200, false);
    }
    if (this.this$0.a > 0L) {
      this.this$0.app.a(String.valueOf(this.this$0.a), 202, false);
    }
    aukn localaukn;
    do
    {
      do
      {
        return;
      } while (bbjw.a(NearbyPeopleProfileActivity.a(this.this$0).uin));
      localaukn = this.this$0.app.getEntityManagerFactory().createEntityManager();
    } while (localaukn == null);
    NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)localaukn.a(NearbyPeopleCard.class, "uin=?", new String[] { NearbyPeopleProfileActivity.a(this.this$0).uin });
    if ((localNearbyPeopleCard != null) && (localNearbyPeopleCard.tinyId > 0L)) {
      this.this$0.app.a(String.valueOf(localNearbyPeopleCard.tinyId), 202, false);
    }
    localaukn.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.22
 * JD-Core Version:    0.7.0.1
 */