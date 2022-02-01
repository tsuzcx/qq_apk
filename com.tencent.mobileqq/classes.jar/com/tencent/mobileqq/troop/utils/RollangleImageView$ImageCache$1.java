package com.tencent.mobileqq.troop.utils;

import android.os.Handler;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import bght;
import bghv;
import java.util.LinkedList;

public class RollangleImageView$ImageCache$1
  implements Runnable
{
  public RollangleImageView$ImageCache$1(bght parambght) {}
  
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
          if (bght.a(this.this$0) == null) {
            return;
          }
        }
        if (localObject2 != null) {
          bght.a(this.this$0).poll();
        }
        if (bght.a(this.this$0).isEmpty()) {
          return;
        }
        bghv localbghv = (bghv)bght.a(this.this$0).peek();
        ??? = RollangleImageView.a(localbghv.jdField_a_of_type_JavaLangString);
        Object localObject3 = localbghv;
        if (??? == null) {
          continue;
        }
        RollangleImageView.a.put("troopfileimage://" + localbghv.jdField_a_of_type_JavaLangString, ???);
        bght.a(this.this$0).obtainMessage(0, new Object[] { localbghv.jdField_a_of_type_ComTencentMobileqqTroopUtilsRollangleImageView, localbghv.jdField_a_of_type_JavaLangString, ??? }).sendToTarget();
        localObject3 = localbghv;
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