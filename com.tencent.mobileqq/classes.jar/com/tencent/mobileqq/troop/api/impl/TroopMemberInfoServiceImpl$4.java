package com.tencent.mobileqq.troop.api.impl;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import mqq.os.MqqHandler;

class TroopMemberInfoServiceImpl$4
  implements Runnable
{
  TroopMemberInfoServiceImpl$4(TroopMemberInfoServiceImpl paramTroopMemberInfoServiceImpl, String paramString1, String paramString2) {}
  
  public void run()
  {
    TroopMemberInfo localTroopMemberInfo = this.this$0.getTroopMemberInfoFromDb(this.a, this.b);
    ThreadManager.getUIHandler().post(new TroopMemberInfoServiceImpl.4.1(this, localTroopMemberInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.TroopMemberInfoServiceImpl.4
 * JD-Core Version:    0.7.0.1
 */