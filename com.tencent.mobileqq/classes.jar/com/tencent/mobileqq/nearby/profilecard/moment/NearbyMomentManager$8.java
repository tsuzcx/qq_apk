package com.tencent.mobileqq.nearby.profilecard.moment;

import ayrf;
import ayrm;
import java.util.Iterator;
import java.util.List;

public class NearbyMomentManager$8
  implements Runnable
{
  public NearbyMomentManager$8(ayrf paramayrf, String paramString, int paramInt) {}
  
  public void run()
  {
    Iterator localIterator = ayrf.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((ayrm)localIterator.next()).b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.8
 * JD-Core Version:    0.7.0.1
 */