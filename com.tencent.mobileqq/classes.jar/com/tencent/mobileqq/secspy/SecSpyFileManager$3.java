package com.tencent.mobileqq.secspy;

import android.os.Handler;
import awyl;
import awym;
import bavg;

public class SecSpyFileManager$3
  implements Runnable
{
  public SecSpyFileManager$3(awyl paramawyl, awym paramawym, long paramLong) {}
  
  public void run()
  {
    if (awym.a(this.jdField_a_of_type_Awym)) {
      return;
    }
    float f = awym.a(this.jdField_a_of_type_Awym) / awym.b(this.jdField_a_of_type_Awym);
    this.this$0.a(this.jdField_a_of_type_Long, 3, new Object[] { Integer.valueOf((int)(f * 100.0F)) });
    this.this$0.a.a().postDelayed(this, 20000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.secspy.SecSpyFileManager.3
 * JD-Core Version:    0.7.0.1
 */