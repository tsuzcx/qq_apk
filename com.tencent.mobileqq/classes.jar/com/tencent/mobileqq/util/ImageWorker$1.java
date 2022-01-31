package com.tencent.mobileqq.util;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import bcyf;
import bcyh;

public class ImageWorker$1
  implements Runnable
{
  public void run()
  {
    Drawable localDrawable = this.jdField_a_of_type_Bcyh.a(new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bcyd, Boolean.valueOf(true) });
    bcyf.a(this.this$0).post(new ImageWorker.1.1(this, localDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.ImageWorker.1
 * JD-Core Version:    0.7.0.1
 */