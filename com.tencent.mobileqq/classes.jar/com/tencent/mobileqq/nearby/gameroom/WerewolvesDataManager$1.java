package com.tencent.mobileqq.nearby.gameroom;

import asif;
import atmp;
import atmq;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class WerewolvesDataManager$1
  implements Runnable
{
  public WerewolvesDataManager$1(asif paramasif, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_Atmp = this.a.getEntityManagerFactory().createEntityManager();
    Object localObject2 = this.this$0.jdField_a_of_type_Atmp.a(RecentInviteUser.class);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.WerewolvesDataManager.1
 * JD-Core Version:    0.7.0.1
 */