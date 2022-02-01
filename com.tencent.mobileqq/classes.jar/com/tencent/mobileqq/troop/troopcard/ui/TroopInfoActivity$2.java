package com.tencent.mobileqq.troop.troopcard.ui;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class TroopInfoActivity$2
  implements Runnable
{
  TroopInfoActivity$2(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    localObject = TroopInfoActivity.a((Context)localObject, ((TroopInfoActivity)localObject).f);
    if (localObject != null) {
      ThreadManager.getUIHandler().post(new TroopInfoActivity.2.1(this, (ArrayList)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.TroopInfoActivity.2
 * JD-Core Version:    0.7.0.1
 */