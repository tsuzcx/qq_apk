package com.tencent.mobileqq.nearby.profilecard.moment;

import atvq;
import atvx;
import java.util.Iterator;
import java.util.List;

public class NearbyMomentManager$7
  implements Runnable
{
  public NearbyMomentManager$7(atvq paramatvq, String paramString, long paramLong) {}
  
  public void run()
  {
    Iterator localIterator = atvq.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((atvx)localIterator.next()).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.7
 * JD-Core Version:    0.7.0.1
 */