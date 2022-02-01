package com.tencent.mobileqq.nearby.profilecard;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.utils.StringUtil;

class NearbyPeopleProfileActivity$24
  implements Runnable
{
  NearbyPeopleProfileActivity$24(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void run()
  {
    if (!StringUtil.isEmpty(this.this$0.mCard.uin)) {
      this.this$0.app.refreshStrangerFace(this.this$0.mCard.uin, 200, false);
    }
    if (this.this$0.mTinyId > 0L)
    {
      this.this$0.app.refreshStrangerFace(String.valueOf(this.this$0.mTinyId), 202, false);
      return;
    }
    if (!StringUtil.isEmpty(this.this$0.mCard.uin))
    {
      EntityManager localEntityManager = this.this$0.app.getEntityManagerFactory().createEntityManager();
      if (localEntityManager != null)
      {
        NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)localEntityManager.find(NearbyPeopleCard.class, "uin=?", new String[] { this.this$0.mCard.uin });
        if ((localNearbyPeopleCard != null) && (localNearbyPeopleCard.tinyId > 0L)) {
          this.this$0.app.refreshStrangerFace(String.valueOf(localNearbyPeopleCard.tinyId), 202, false);
        }
        localEntityManager.close();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.24
 * JD-Core Version:    0.7.0.1
 */