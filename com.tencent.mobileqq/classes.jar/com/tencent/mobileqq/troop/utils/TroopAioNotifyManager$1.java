package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.observer.TroopAioNotifyObserver;
import com.tencent.mobileqq.troop.troopnotification.api.ITroopAioNotifyHandler;
import java.util.ArrayList;
import java.util.List;

final class TroopAioNotifyManager$1
  implements Runnable
{
  TroopAioNotifyManager$1(QQAppInterface paramQQAppInterface, String paramString, ITroopAioNotifyHandler paramITroopAioNotifyHandler) {}
  
  public void run()
  {
    List localList = TroopAioNotifyManager.b(this.a, this.b);
    localList = TroopAioNotifyManager.a(this.a, new ArrayList(), localList);
    this.c.a(TroopAioNotifyObserver.b, true, new Object[] { this.b, localList });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopAioNotifyManager.1
 * JD-Core Version:    0.7.0.1
 */