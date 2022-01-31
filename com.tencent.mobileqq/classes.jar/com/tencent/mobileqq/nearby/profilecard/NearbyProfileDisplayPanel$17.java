package com.tencent.mobileqq.nearby.profilecard;

import avgk;
import awbw;
import awbx;
import com.tencent.mobileqq.app.QQAppInterface;

public class NearbyProfileDisplayPanel$17
  implements Runnable
{
  public void run()
  {
    awbw localawbw = this.this$0.a.app.getEntityManagerFactory().createEntityManager();
    if (localawbw != null)
    {
      localawbw.a(avgk.a(this.this$0));
      localawbw.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.17
 * JD-Core Version:    0.7.0.1
 */