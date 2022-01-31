package com.tencent.mobileqq.troop.utils;

import android.os.SystemClock;

class TroopFileTransferManager$16
  implements Runnable
{
  TroopFileTransferManager$16(TroopFileTransferManager paramTroopFileTransferManager) {}
  
  public void run()
  {
    for (;;)
    {
      synchronized (this.this$0)
      {
        if (TroopFileTransferManager.a(this.this$0) == 0L) {
          return;
        }
        if (SystemClock.uptimeMillis() > TroopFileTransferManager.a(this.this$0) + 10000L)
        {
          TroopFileTransferManager.a(this.this$0, 0L);
          this.this$0.a();
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.16
 * JD-Core Version:    0.7.0.1
 */