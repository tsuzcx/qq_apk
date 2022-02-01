package com.tencent.mobileqq.troopgift;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;

class TroopInteractGiftAnimationController$5
  implements Runnable
{
  TroopInteractGiftAnimationController$5(TroopInteractGiftAnimationController paramTroopInteractGiftAnimationController) {}
  
  public void run()
  {
    if (this.this$0.a == null) {
      return;
    }
    this.this$0.a.bG.removeView(this.this$0.b);
    if (this.this$0.c != null) {
      this.this$0.d.removeView(this.this$0.c);
    }
    TroopInteractGiftAnimationController localTroopInteractGiftAnimationController = this.this$0;
    localTroopInteractGiftAnimationController.b = null;
    localTroopInteractGiftAnimationController.c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController.5
 * JD-Core Version:    0.7.0.1
 */