package com.tencent.mobileqq.nearby;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.api.NearbySPUtil;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;

final class NearbyCardManager$1
  implements Runnable
{
  NearbyCardManager$1(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject = this.a;
    ((QQAppInterface)localObject).refreshStrangerFace(((QQAppInterface)localObject).getCurrentAccountUin(), 200, true);
    long l1 = ((Long)NearbySPUtil.a(this.a.getAccount(), "self_tinnyid", Long.valueOf(0L))).longValue();
    long l2 = l1;
    if (l1 == 0L)
    {
      localObject = this.a;
      localObject = ((QQAppInterface)localObject).getEntityManagerFactory(((QQAppInterface)localObject).getAccount()).createEntityManager();
      l2 = l1;
      if (localObject != null)
      {
        NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)((EntityManager)localObject).find(NearbyPeopleCard.class, "uin=?", new String[] { this.a.getCurrentAccountUin() });
        if (localNearbyPeopleCard != null) {
          l1 = localNearbyPeopleCard.tinyId;
        }
        ((EntityManager)localObject).close();
        l2 = l1;
      }
    }
    if (l2 != 0L) {
      this.a.refreshStrangerFace(String.valueOf(l2), 202, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyCardManager.1
 * JD-Core Version:    0.7.0.1
 */