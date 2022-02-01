package com.tencent.mobileqq.nearby.profilecard;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;

class NearbyProfileDisplayTribePanel$20
  implements Runnable
{
  NearbyProfileDisplayTribePanel$20(NearbyProfileDisplayTribePanel paramNearbyProfileDisplayTribePanel) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.this$0.a.app.getEntityManagerFactory().createEntityManager();
    if (localEntityManager != null)
    {
      localEntityManager.update(NearbyProfileDisplayTribePanel.a(this.this$0));
      localEntityManager.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.20
 * JD-Core Version:    0.7.0.1
 */