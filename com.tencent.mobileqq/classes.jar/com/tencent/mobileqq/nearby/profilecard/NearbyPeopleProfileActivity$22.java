package com.tencent.mobileqq.nearby.profilecard;

import awgf;
import awgg;
import bdnn;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;

class NearbyPeopleProfileActivity$22
  implements Runnable
{
  NearbyPeopleProfileActivity$22(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void run()
  {
    if (!bdnn.a(NearbyPeopleProfileActivity.a(this.this$0).uin)) {
      this.this$0.app.a(NearbyPeopleProfileActivity.a(this.this$0).uin, 200, false);
    }
    if (this.this$0.a > 0L) {
      this.this$0.app.a(String.valueOf(this.this$0.a), 202, false);
    }
    awgf localawgf;
    do
    {
      do
      {
        return;
      } while (bdnn.a(NearbyPeopleProfileActivity.a(this.this$0).uin));
      localawgf = this.this$0.app.getEntityManagerFactory().createEntityManager();
    } while (localawgf == null);
    NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)localawgf.a(NearbyPeopleCard.class, "uin=?", new String[] { NearbyPeopleProfileActivity.a(this.this$0).uin });
    if ((localNearbyPeopleCard != null) && (localNearbyPeopleCard.tinyId > 0L)) {
      this.this$0.app.a(String.valueOf(localNearbyPeopleCard.tinyId), 202, false);
    }
    localawgf.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.22
 * JD-Core Version:    0.7.0.1
 */