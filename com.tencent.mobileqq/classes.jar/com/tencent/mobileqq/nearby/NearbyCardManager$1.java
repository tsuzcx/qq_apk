package com.tencent.mobileqq.nearby;

import asfc;
import atmp;
import atmq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;

public final class NearbyCardManager$1
  implements Runnable
{
  public NearbyCardManager$1(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    this.a.a(this.a.getCurrentAccountUin(), 200, true);
    long l1 = ((Long)asfc.a(this.a.getAccount(), "self_tinnyid", Long.valueOf(0L))).longValue();
    long l2 = l1;
    atmp localatmp;
    if (l1 == 0L)
    {
      localatmp = this.a.getEntityManagerFactory(this.a.getAccount()).createEntityManager();
      l2 = l1;
      if (localatmp != null)
      {
        NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)localatmp.a(NearbyPeopleCard.class, "uin=?", new String[] { this.a.getCurrentAccountUin() });
        if (localNearbyPeopleCard == null) {
          break label143;
        }
        l1 = localNearbyPeopleCard.tinyId;
      }
    }
    label143:
    for (;;)
    {
      localatmp.a();
      l2 = l1;
      if (l2 != 0L) {
        this.a.a(String.valueOf(l2), 202, true);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyCardManager.1
 * JD-Core Version:    0.7.0.1
 */