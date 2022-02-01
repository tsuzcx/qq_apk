package com.tencent.mobileqq.nearby.profilecard.moment;

import ayks;
import aykz;
import java.util.Iterator;
import java.util.List;

public class NearbyMomentManager$8
  implements Runnable
{
  public NearbyMomentManager$8(ayks paramayks, String paramString, int paramInt) {}
  
  public void run()
  {
    Iterator localIterator = ayks.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((aykz)localIterator.next()).b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.8
 * JD-Core Version:    0.7.0.1
 */