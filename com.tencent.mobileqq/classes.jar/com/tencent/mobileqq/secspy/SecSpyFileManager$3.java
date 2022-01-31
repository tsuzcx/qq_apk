package com.tencent.mobileqq.secspy;

import android.os.Handler;
import ayto;
import aytp;
import bcua;

public class SecSpyFileManager$3
  implements Runnable
{
  public SecSpyFileManager$3(ayto paramayto, aytp paramaytp, long paramLong) {}
  
  public void run()
  {
    if (aytp.a(this.jdField_a_of_type_Aytp)) {
      return;
    }
    float f = aytp.a(this.jdField_a_of_type_Aytp) / aytp.b(this.jdField_a_of_type_Aytp);
    this.this$0.a(this.jdField_a_of_type_Long, 3, new Object[] { Integer.valueOf((int)(f * 100.0F)) });
    this.this$0.a.a().postDelayed(this, 20000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.secspy.SecSpyFileManager.3
 * JD-Core Version:    0.7.0.1
 */