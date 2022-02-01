package com.tencent.mobileqq.troop.troopgame;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.troopgame.api.ITroopGameCardService.CallbackInMainThread;
import mqq.os.MqqHandler;

class TroopGameCardManager$1
  implements Runnable
{
  TroopGameCardManager$1(TroopGameCardManager paramTroopGameCardManager, String paramString, ITroopGameCardService.CallbackInMainThread paramCallbackInMainThread) {}
  
  public void run()
  {
    MemberGradeLevelInfo localMemberGradeLevelInfo = TroopGameCardManager.a(this.this$0, this.jdField_a_of_type_JavaLangString);
    ThreadManager.getUIHandler().post(new TroopGameCardManager.1.1(this, localMemberGradeLevelInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgame.TroopGameCardManager.1
 * JD-Core Version:    0.7.0.1
 */