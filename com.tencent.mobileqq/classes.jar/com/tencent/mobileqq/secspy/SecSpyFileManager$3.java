package com.tencent.mobileqq.secspy;

import android.os.Handler;
import ayxx;
import ayxy;
import bcyj;

public class SecSpyFileManager$3
  implements Runnable
{
  public SecSpyFileManager$3(ayxx paramayxx, ayxy paramayxy, long paramLong) {}
  
  public void run()
  {
    if (ayxy.a(this.jdField_a_of_type_Ayxy)) {
      return;
    }
    float f = ayxy.a(this.jdField_a_of_type_Ayxy) / ayxy.b(this.jdField_a_of_type_Ayxy);
    this.this$0.a(this.jdField_a_of_type_Long, 3, new Object[] { Integer.valueOf((int)(f * 100.0F)) });
    this.this$0.a.a().postDelayed(this, 20000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.secspy.SecSpyFileManager.3
 * JD-Core Version:    0.7.0.1
 */