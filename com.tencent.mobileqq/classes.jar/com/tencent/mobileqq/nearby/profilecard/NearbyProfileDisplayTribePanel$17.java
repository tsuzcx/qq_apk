package com.tencent.mobileqq.nearby.profilecard;

import axtp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;

public class NearbyProfileDisplayTribePanel$17
  implements Runnable
{
  public void run()
  {
    EntityManager localEntityManager = this.this$0.a.app.a().createEntityManager();
    if (localEntityManager != null)
    {
      localEntityManager.update(axtp.a(this.this$0));
      localEntityManager.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.17
 * JD-Core Version:    0.7.0.1
 */