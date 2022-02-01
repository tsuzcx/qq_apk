package com.tencent.mobileqq.troop.utils;

import android.os.Handler;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import bezn;
import bezp;
import java.util.LinkedList;

public class RollangleImageView$ImageCache$1
  implements Runnable
{
  public RollangleImageView$ImageCache$1(bezn parambezn) {}
  
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
          if (bezn.a(this.this$0) == null) {
            return;
          }
        }
        if (localObject2 != null) {
          bezn.a(this.this$0).poll();
        }
        if (bezn.a(this.this$0).isEmpty()) {
          return;
        }
        bezp localbezp = (bezp)bezn.a(this.this$0).peek();
        ??? = RollangleImageView.a(localbezp.jdField_a_of_type_JavaLangString);
        Object localObject3 = localbezp;
        if (??? == null) {
          continue;
        }
        RollangleImageView.a.put("troopfileimage://" + localbezp.jdField_a_of_type_JavaLangString, ???);
        bezn.a(this.this$0).obtainMessage(0, new Object[] { localbezp.jdField_a_of_type_ComTencentMobileqqTroopUtilsRollangleImageView, localbezp.jdField_a_of_type_JavaLangString, ??? }).sendToTarget();
        localObject3 = localbezp;
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