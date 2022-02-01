package com.tencent.mobileqq.util;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.utils.StringUtil;

final class NearbyProfileUtil$1
  implements Runnable
{
  public void run()
  {
    EntityManager localEntityManager = this.a.getEntityManagerFactory().createEntityManager();
    long l1 = 0L;
    Object localObject1 = null;
    Object localObject3 = null;
    long l2 = l1;
    if (localEntityManager != null)
    {
      l2 = this.b;
      if (l2 > 0L) {
        localObject1 = (NearbyPeopleCard)localEntityManager.find(NearbyPeopleCard.class, "tinyId=?", new String[] { String.valueOf(l2) });
      } else {
        localObject1 = null;
      }
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = localObject1;
        if (!StringUtil.isEmpty(this.c)) {
          localObject2 = (NearbyPeopleCard)localEntityManager.find(NearbyPeopleCard.class, "uin=?", new String[] { this.c });
        }
      }
      localObject1 = localObject3;
      if (localObject2 != null)
      {
        localObject1 = ((NearbyPeopleCard)localObject2).vSeed;
        l1 = ((NearbyPeopleCard)localObject2).feedPreviewTime;
      }
      localEntityManager.close();
      l2 = l1;
    }
    NearbyProfileUtil.a(this.d, this.a, this.b, this.c, this.e, (byte[])localObject1, l2, false, 0L, false, 0L, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.NearbyProfileUtil.1
 * JD-Core Version:    0.7.0.1
 */