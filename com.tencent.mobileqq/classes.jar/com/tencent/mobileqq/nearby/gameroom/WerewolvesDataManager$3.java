package com.tencent.mobileqq.nearby.gameroom;

import com.tencent.mobileqq.persistence.EntityManager;

class WerewolvesDataManager$3
  implements Runnable
{
  WerewolvesDataManager$3(WerewolvesDataManager paramWerewolvesDataManager, RecentInviteUser paramRecentInviteUser) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.WerewolvesDataManager.3
 * JD-Core Version:    0.7.0.1
 */