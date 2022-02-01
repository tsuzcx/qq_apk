package com.tencent.mobileqq.nearby.gameroom;

import awnd;
import com.tencent.mobileqq.persistence.EntityManager;

public class WerewolvesDataManager$3
  implements Runnable
{
  public WerewolvesDataManager$3(awnd paramawnd, RecentInviteUser paramRecentInviteUser) {}
  
  public void run()
  {
    if (this.a.getStatus() == 1000)
    {
      this.this$0.a.persistOrReplace(this.a);
      return;
    }
    this.this$0.a.update(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.WerewolvesDataManager.3
 * JD-Core Version:    0.7.0.1
 */