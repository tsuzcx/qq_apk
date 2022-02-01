package com.tencent.mobileqq.nearby.gameroom;

import awnd;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class WerewolvesDataManager$1
  implements Runnable
{
  public WerewolvesDataManager$1(awnd paramawnd, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.a.getEntityManagerFactory().createEntityManager();
    Object localObject2 = this.this$0.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(RecentInviteUser.class);
    Object localObject1 = this.this$0.jdField_a_of_type_JavaLangObject;
    if (localObject2 != null) {
      try
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          RecentInviteUser localRecentInviteUser = (RecentInviteUser)((Iterator)localObject2).next();
          this.this$0.jdField_a_of_type_JavaUtilMap.put(localRecentInviteUser.uniKey, localRecentInviteUser);
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.WerewolvesDataManager.1
 * JD-Core Version:    0.7.0.1
 */