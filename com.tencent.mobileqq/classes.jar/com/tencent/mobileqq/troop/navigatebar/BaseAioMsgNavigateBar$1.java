package com.tencent.mobileqq.troop.navigatebar;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class BaseAioMsgNavigateBar$1
  implements Runnable
{
  BaseAioMsgNavigateBar$1(BaseAioMsgNavigateBar paramBaseAioMsgNavigateBar) {}
  
  public void run()
  {
    this.this$0.m();
    ThreadManager.getUIHandler().post(new BaseAioMsgNavigateBar.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.navigatebar.BaseAioMsgNavigateBar.1
 * JD-Core Version:    0.7.0.1
 */