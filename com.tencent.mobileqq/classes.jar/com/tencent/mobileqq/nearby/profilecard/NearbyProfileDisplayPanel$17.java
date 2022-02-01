package com.tencent.mobileqq.nearby.profilecard;

import aykx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;

public class NearbyProfileDisplayPanel$17
  implements Runnable
{
  public void run()
  {
    EntityManager localEntityManager = this.this$0.a.app.a().createEntityManager();
    if (localEntityManager != null)
    {
      localEntityManager.update(aykx.a(this.this$0));
      localEntityManager.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.17
 * JD-Core Version:    0.7.0.1
 */