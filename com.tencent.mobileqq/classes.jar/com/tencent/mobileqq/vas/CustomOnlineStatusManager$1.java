package com.tencent.mobileqq.vas;

import bbpm;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class CustomOnlineStatusManager$1
  implements Runnable
{
  public CustomOnlineStatusManager$1(bbpm parambbpm) {}
  
  public void run()
  {
    Iterator localIterator = bbpm.a(this.this$0).iterator();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.vas.CustomOnlineStatusManager.1
 * JD-Core Version:    0.7.0.1
 */