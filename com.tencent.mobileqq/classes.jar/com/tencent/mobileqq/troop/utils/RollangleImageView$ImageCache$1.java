package com.tencent.mobileqq.troop.utils;

import android.os.Handler;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import bcgy;
import bcha;
import java.util.LinkedList;

public class RollangleImageView$ImageCache$1
  implements Runnable
{
  public RollangleImageView$ImageCache$1(bcgy parambcgy) {}
  
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
          if (bcgy.a(this.this$0) == null) {
            return;
          }
        }
        if (localObject2 != null) {
          bcgy.a(this.this$0).poll();
        }
        if (bcgy.a(this.this$0).isEmpty()) {
          return;
        }
        bcha localbcha = (bcha)bcgy.a(this.this$0).peek();
        ??? = RollangleImageView.a(localbcha.jdField_a_of_type_JavaLangString);
        Object localObject3 = localbcha;
        if (??? == null) {
          continue;
        }
        RollangleImageView.a.put("troopfileimage://" + localbcha.jdField_a_of_type_JavaLangString, ???);
        bcgy.a(this.this$0).obtainMessage(0, new Object[] { localbcha.jdField_a_of_type_ComTencentMobileqqTroopUtilsRollangleImageView, localbcha.jdField_a_of_type_JavaLangString, ??? }).sendToTarget();
        localObject3 = localbcha;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label19;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.RollangleImageView.ImageCache.1
 * JD-Core Version:    0.7.0.1
 */