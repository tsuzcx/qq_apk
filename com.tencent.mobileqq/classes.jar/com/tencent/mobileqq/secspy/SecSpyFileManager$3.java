package com.tencent.mobileqq.secspy;

import android.os.Handler;
import bbxa;
import bbxb;
import bgcs;

public class SecSpyFileManager$3
  implements Runnable
{
  public SecSpyFileManager$3(bbxa parambbxa, bbxb parambbxb, long paramLong) {}
  
  public void run()
  {
    if (bbxb.a(this.jdField_a_of_type_Bbxb)) {
      return;
    }
    float f = bbxb.a(this.jdField_a_of_type_Bbxb) / bbxb.b(this.jdField_a_of_type_Bbxb);
    this.this$0.a(this.jdField_a_of_type_Long, 3, new Object[] { Integer.valueOf((int)(f * 100.0F)) });
    this.this$0.a.a().postDelayed(this, 20000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.secspy.SecSpyFileManager.3
 * JD-Core Version:    0.7.0.1
 */