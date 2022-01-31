package com.tencent.mobileqq.nearby.profilecard.moment;

import avrb;
import avri;
import java.util.Iterator;
import java.util.List;

public class NearbyMomentManager$9
  implements Runnable
{
  public NearbyMomentManager$9(avrb paramavrb, String paramString, int paramInt) {}
  
  public void run()
  {
    Iterator localIterator = avrb.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((avri)localIterator.next()).c(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.9
 * JD-Core Version:    0.7.0.1
 */