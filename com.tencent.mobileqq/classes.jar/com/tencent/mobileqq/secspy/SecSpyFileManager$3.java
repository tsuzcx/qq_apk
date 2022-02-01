package com.tencent.mobileqq.secspy;

import android.os.Handler;
import bcpr;
import bcps;
import bhct;

public class SecSpyFileManager$3
  implements Runnable
{
  public SecSpyFileManager$3(bcpr parambcpr, bcps parambcps, long paramLong) {}
  
  public void run()
  {
    if (bcps.a(this.jdField_a_of_type_Bcps)) {
      return;
    }
    float f = bcps.a(this.jdField_a_of_type_Bcps) / bcps.b(this.jdField_a_of_type_Bcps);
    this.this$0.a(this.jdField_a_of_type_Long, 3, new Object[] { Integer.valueOf((int)(f * 100.0F)) });
    this.this$0.a.a().postDelayed(this, 20000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.secspy.SecSpyFileManager.3
 * JD-Core Version:    0.7.0.1
 */