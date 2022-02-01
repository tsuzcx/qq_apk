package com.tencent.mobileqq.troop.utils;

import android.os.Handler;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import bgpz;
import bgqb;
import java.util.LinkedList;

public class RollangleImageView$ImageCache$1
  implements Runnable
{
  public RollangleImageView$ImageCache$1(bgpz parambgpz) {}
  
  public void run()
  {
    Object localObject1 = null;
    for (;;)
    {
      if (this.this$0.a) {
        return;
      }
      try
      {
        Thread.sleep(100L);
        label19:
        synchronized (this.this$0)
        {
          if (bgpz.a(this.this$0) == null) {
            return;
          }
        }
        if (localObject2 != null) {
          bgpz.a(this.this$0).poll();
        }
        if (bgpz.a(this.this$0).isEmpty()) {
          return;
        }
        bgqb localbgqb = (bgqb)bgpz.a(this.this$0).peek();
        ??? = RollangleImageView.a(localbgqb.jdField_a_of_type_JavaLangString);
        Object localObject3 = localbgqb;
        if (??? == null) {
          continue;
        }
        RollangleImageView.a.put("troopfileimage://" + localbgqb.jdField_a_of_type_JavaLangString, ???);
        bgpz.a(this.this$0).obtainMessage(0, new Object[] { localbgqb.jdField_a_of_type_ComTencentMobileqqTroopUtilsRollangleImageView, localbgqb.jdField_a_of_type_JavaLangString, ??? }).sendToTarget();
        localObject3 = localbgqb;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label19;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.RollangleImageView.ImageCache.1
 * JD-Core Version:    0.7.0.1
 */