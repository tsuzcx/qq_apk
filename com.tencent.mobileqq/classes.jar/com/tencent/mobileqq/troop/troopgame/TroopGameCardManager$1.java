package com.tencent.mobileqq.troop.troopgame;

import bgfx;
import bgfy;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class TroopGameCardManager$1
  implements Runnable
{
  public TroopGameCardManager$1(bgfx parambgfx, String paramString, bgfy parambgfy) {}
  
  public void run()
  {
    MemberGradeLevelInfo localMemberGradeLevelInfo = bgfx.a(this.this$0, this.jdField_a_of_type_JavaLangString);
    ThreadManager.getUIHandler().post(new TroopGameCardManager.1.1(this, localMemberGradeLevelInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgame.TroopGameCardManager.1
 * JD-Core Version:    0.7.0.1
 */