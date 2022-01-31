package com.tencent.mobileqq.troop.utils;

import android.os.Handler;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import baim;
import baio;
import java.util.LinkedList;

public class RollangleImageView$ImageCache$1
  implements Runnable
{
  public RollangleImageView$ImageCache$1(baim parambaim) {}
  
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
          if (baim.a(this.this$0) == null) {
            return;
          }
        }
        if (localObject2 != null) {
          baim.a(this.this$0).poll();
        }
        if (baim.a(this.this$0).isEmpty()) {
          return;
        }
        baio localbaio = (baio)baim.a(this.this$0).peek();
        ??? = RollangleImageView.a(localbaio.jdField_a_of_type_JavaLangString);
        Object localObject3 = localbaio;
        if (??? == null) {
          continue;
        }
        RollangleImageView.a.put("troopfileimage://" + localbaio.jdField_a_of_type_JavaLangString, ???);
        baim.a(this.this$0).obtainMessage(0, new Object[] { localbaio.jdField_a_of_type_ComTencentMobileqqTroopUtilsRollangleImageView, localbaio.jdField_a_of_type_JavaLangString, ??? }).sendToTarget();
        localObject3 = localbaio;
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