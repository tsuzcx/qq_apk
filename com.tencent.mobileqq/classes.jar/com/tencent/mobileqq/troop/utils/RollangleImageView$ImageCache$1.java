package com.tencent.mobileqq.troop.utils;

import android.os.Handler;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import java.util.LinkedList;

class RollangleImageView$ImageCache$1
  implements Runnable
{
  RollangleImageView$ImageCache$1(RollangleImageView.ImageCache paramImageCache) {}
  
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
          if (RollangleImageView.ImageCache.a(this.this$0) == null) {
            return;
          }
        }
        if (localObject2 != null) {
          RollangleImageView.ImageCache.a(this.this$0).poll();
        }
        if (RollangleImageView.ImageCache.a(this.this$0).isEmpty()) {
          return;
        }
        RollangleImageView.ImageCache.QueueItem localQueueItem = (RollangleImageView.ImageCache.QueueItem)RollangleImageView.ImageCache.a(this.this$0).peek();
        ??? = RollangleImageView.a(localQueueItem.jdField_a_of_type_JavaLangString);
        Object localObject3 = localQueueItem;
        if (??? == null) {
          continue;
        }
        RollangleImageView.a.put("troopfileimage://" + localQueueItem.jdField_a_of_type_JavaLangString, ???);
        RollangleImageView.ImageCache.a(this.this$0).obtainMessage(0, new Object[] { localQueueItem.jdField_a_of_type_ComTencentMobileqqTroopUtilsRollangleImageView, localQueueItem.jdField_a_of_type_JavaLangString, ??? }).sendToTarget();
        localObject3 = localQueueItem;
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