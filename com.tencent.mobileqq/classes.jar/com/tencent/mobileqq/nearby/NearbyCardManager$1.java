package com.tencent.mobileqq.nearby;

import auwq;
import awgf;
import awgg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;

public final class NearbyCardManager$1
  implements Runnable
{
  public NearbyCardManager$1(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    this.a.a(this.a.getCurrentAccountUin(), 200, true);
    long l1 = ((Long)auwq.a(this.a.getAccount(), "self_tinnyid", Long.valueOf(0L))).longValue();
    long l2 = l1;
    awgf localawgf;
    if (l1 == 0L)
    {
      localawgf = this.a.getEntityManagerFactory(this.a.getAccount()).createEntityManager();
      l2 = l1;
      if (localawgf != null)
      {
        NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)localawgf.a(NearbyPeopleCard.class, "uin=?", new String[] { this.a.getCurrentAccountUin() });
        if (localNearbyPeopleCard == null) {
          break label143;
        }
        l1 = localNearbyPeopleCard.tinyId;
      }
    }
    label143:
    for (;;)
    {
      localawgf.a();
      l2 = l1;
      if (l2 != 0L) {
        this.a.a(String.valueOf(l2), 202, true);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyCardManager.1
 * JD-Core Version:    0.7.0.1
 */