package com.tencent.mobileqq.secspy;

import android.os.Handler;
import avyq;
import avyr;
import azto;

public class SecSpyFileManager$3
  implements Runnable
{
  public SecSpyFileManager$3(avyq paramavyq, avyr paramavyr, long paramLong) {}
  
  public void run()
  {
    if (avyr.a(this.jdField_a_of_type_Avyr)) {
      return;
    }
    float f = avyr.a(this.jdField_a_of_type_Avyr) / avyr.b(this.jdField_a_of_type_Avyr);
    this.this$0.a(this.jdField_a_of_type_Long, 3, new Object[] { Integer.valueOf((int)(f * 100.0F)) });
    this.this$0.a.a().postDelayed(this, 20000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.secspy.SecSpyFileManager.3
 * JD-Core Version:    0.7.0.1
 */