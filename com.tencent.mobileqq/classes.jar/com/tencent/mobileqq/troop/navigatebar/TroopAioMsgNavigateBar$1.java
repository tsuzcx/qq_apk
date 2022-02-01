package com.tencent.mobileqq.troop.navigatebar;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class TroopAioMsgNavigateBar$1
  implements Runnable
{
  TroopAioMsgNavigateBar$1(TroopAioMsgNavigateBar paramTroopAioMsgNavigateBar) {}
  
  public void run()
  {
    this.this$0.h();
    ThreadManager.getUIHandler().post(new TroopAioMsgNavigateBar.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateBar.1
 * JD-Core Version:    0.7.0.1
 */