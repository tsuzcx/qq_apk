package com.tencent.mobileqq.widget;

import android.os.Handler;

class ImageViewTouchBase$2
  implements Runnable
{
  ImageViewTouchBase$2(ImageViewTouchBase paramImageViewTouchBase, float paramFloat1, long paramLong, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    float f1 = Math.min(this.jdField_a_of_type_Float, (float)(l - this.jdField_a_of_type_Long));
    float f2 = this.b;
    float f3 = this.c;
    this.this$0.zoomTo(f2 + f3 * f1, this.d, this.e);
    if (f1 < this.jdField_a_of_type_Float) {
      this.this$0.mHandler.post(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ImageViewTouchBase.2
 * JD-Core Version:    0.7.0.1
 */