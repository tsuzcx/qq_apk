package com.tencent.qqmini.minigame.manager;

import android.view.ViewGroup;

class PendantManager$7
  implements Runnable
{
  PendantManager$7(PendantManager paramPendantManager) {}
  
  public void run()
  {
    if (PendantManager.access$300(this.this$0) != null) {
      PendantManager.access$600(this.this$0).removeView(PendantManager.access$300(this.this$0));
    }
    PendantManager.access$302(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.PendantManager.7
 * JD-Core Version:    0.7.0.1
 */