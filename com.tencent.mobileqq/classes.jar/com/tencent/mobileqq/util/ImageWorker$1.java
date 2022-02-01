package com.tencent.mobileqq.util;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import bhhm;
import bhho;

public class ImageWorker$1
  implements Runnable
{
  public void run()
  {
    Drawable localDrawable = this.jdField_a_of_type_Bhho.a(new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bhhk, Boolean.valueOf(true) });
    bhhm.a(this.this$0).post(new ImageWorker.1.1(this, localDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.ImageWorker.1
 * JD-Core Version:    0.7.0.1
 */