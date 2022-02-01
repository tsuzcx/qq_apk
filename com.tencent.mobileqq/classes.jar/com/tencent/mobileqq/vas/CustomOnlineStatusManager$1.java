package com.tencent.mobileqq.vas;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

class CustomOnlineStatusManager$1
  implements Runnable
{
  CustomOnlineStatusManager$1(CustomOnlineStatusManager paramCustomOnlineStatusManager) {}
  
  public void run()
  {
    Iterator localIterator = CustomOnlineStatusManager.a(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      Runnable localRunnable = (Runnable)((WeakReference)localIterator.next()).get();
      if (localRunnable == null) {
        localIterator.remove();
      } else {
        localRunnable.run();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.CustomOnlineStatusManager.1
 * JD-Core Version:    0.7.0.1
 */