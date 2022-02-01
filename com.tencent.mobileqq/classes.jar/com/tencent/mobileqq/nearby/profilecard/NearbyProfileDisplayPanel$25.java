package com.tencent.mobileqq.nearby.profilecard;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;

class NearbyProfileDisplayPanel$25
  implements Runnable
{
  NearbyProfileDisplayPanel$25(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.this$0.a.app.getEntityManagerFactory().createEntityManager();
    if (localEntityManager != null)
    {
      localEntityManager.update(NearbyProfileDisplayPanel.a(this.this$0));
      localEntityManager.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.25
 * JD-Core Version:    0.7.0.1
 */