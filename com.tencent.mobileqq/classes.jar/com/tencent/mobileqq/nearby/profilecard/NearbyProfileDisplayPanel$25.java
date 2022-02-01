package com.tencent.mobileqq.nearby.profilecard;

import axsd;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;

public class NearbyProfileDisplayPanel$25
  implements Runnable
{
  public NearbyProfileDisplayPanel$25(axsd paramaxsd) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.this$0.a.app.a().createEntityManager();
    if (localEntityManager != null)
    {
      localEntityManager.update(axsd.a(this.this$0));
      localEntityManager.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.25
 * JD-Core Version:    0.7.0.1
 */