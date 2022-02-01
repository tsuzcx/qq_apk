package com.tencent.mobileqq.nearby.profilecard.moment;

import java.util.Iterator;
import java.util.List;

class NearbyMomentManager$7
  implements Runnable
{
  NearbyMomentManager$7(NearbyMomentManager paramNearbyMomentManager, String paramString, long paramLong) {}
  
  public void run()
  {
    Iterator localIterator = NearbyMomentManager.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((NearbyMomentManager.MomentDataChangeObserver)localIterator.next()).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.7
 * JD-Core Version:    0.7.0.1
 */