package com.tencent.mobileqq.nearby.profilecard;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.utils.StringUtil;

class NearbyPeopleProfileActivity$22
  implements Runnable
{
  NearbyPeopleProfileActivity$22(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void run()
  {
    if (!StringUtil.a(NearbyPeopleProfileActivity.a(this.this$0).uin)) {
      this.this$0.app.refreshStrangerFace(NearbyPeopleProfileActivity.a(this.this$0).uin, 200, false);
    }
    if (this.this$0.a > 0L) {
      this.this$0.app.refreshStrangerFace(String.valueOf(this.this$0.a), 202, false);
    }
    EntityManager localEntityManager;
    do
    {
      do
      {
        return;
      } while (StringUtil.a(NearbyPeopleProfileActivity.a(this.this$0).uin));
      localEntityManager = this.this$0.app.getEntityManagerFactory().createEntityManager();
    } while (localEntityManager == null);
    NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)localEntityManager.find(NearbyPeopleCard.class, "uin=?", new String[] { NearbyPeopleProfileActivity.a(this.this$0).uin });
    if ((localNearbyPeopleCard != null) && (localNearbyPeopleCard.tinyId > 0L)) {
      this.this$0.app.refreshStrangerFace(String.valueOf(localNearbyPeopleCard.tinyId), 202, false);
    }
    localEntityManager.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.22
 * JD-Core Version:    0.7.0.1
 */