package com.tencent.mobileqq.nearby.profilecard;

import ayfx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;

public class NearbyProfileDisplayTribePanel$17
  implements Runnable
{
  public void run()
  {
    EntityManager localEntityManager = this.this$0.a.app.getEntityManagerFactory().createEntityManager();
    if (localEntityManager != null)
    {
      localEntityManager.update(ayfx.a(this.this$0));
      localEntityManager.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.17
 * JD-Core Version:    0.7.0.1
 */