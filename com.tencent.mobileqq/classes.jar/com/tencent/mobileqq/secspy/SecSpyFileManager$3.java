package com.tencent.mobileqq.secspy;

import android.os.Handler;
import bbit;
import bbiu;
import bfmf;

public class SecSpyFileManager$3
  implements Runnable
{
  public SecSpyFileManager$3(bbit parambbit, bbiu parambbiu, long paramLong) {}
  
  public void run()
  {
    if (bbiu.a(this.jdField_a_of_type_Bbiu)) {
      return;
    }
    float f = bbiu.a(this.jdField_a_of_type_Bbiu) / bbiu.b(this.jdField_a_of_type_Bbiu);
    this.this$0.a(this.jdField_a_of_type_Long, 3, new Object[] { Integer.valueOf((int)(f * 100.0F)) });
    this.this$0.a.a().postDelayed(this, 20000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.secspy.SecSpyFileManager.3
 * JD-Core Version:    0.7.0.1
 */