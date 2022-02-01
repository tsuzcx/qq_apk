package com.tencent.mobileqq.nearby.gameroom;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class WerewolvesDataManager$1
  implements Runnable
{
  WerewolvesDataManager$1(WerewolvesDataManager paramWerewolvesDataManager, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    this.this$0.b = this.a.getEntityManagerFactory().createEntityManager();
    Object localObject2 = this.this$0.b.query(RecentInviteUser.class);
    Object localObject1 = this.this$0.c;
    if (localObject2 != null) {}
    try
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        RecentInviteUser localRecentInviteUser = (RecentInviteUser)((Iterator)localObject2).next();
        this.this$0.e.put(localRecentInviteUser.uniKey, localRecentInviteUser);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.WerewolvesDataManager.1
 * JD-Core Version:    0.7.0.1
 */