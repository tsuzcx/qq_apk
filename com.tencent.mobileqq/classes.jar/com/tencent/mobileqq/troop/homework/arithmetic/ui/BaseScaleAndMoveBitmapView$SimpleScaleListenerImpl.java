package com.tencent.mobileqq.troop.homework.arithmetic.ui;

import android.graphics.Bitmap;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import com.tencent.biz.qqstory.support.logging.SLog;

class BaseScaleAndMoveBitmapView$SimpleScaleListenerImpl
  extends ScaleGestureDetector.SimpleOnScaleGestureListener
{
  private BaseScaleAndMoveBitmapView$SimpleScaleListenerImpl(BaseScaleAndMoveBitmapView paramBaseScaleAndMoveBitmapView) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    BaseScaleAndMoveBitmapView.a(this.a, false);
    BaseScaleAndMoveBitmapView localBaseScaleAndMoveBitmapView = this.a;
    localBaseScaleAndMoveBitmapView.c *= paramScaleGestureDetector.getScaleFactor();
    this.a.c = Math.max(BaseScaleAndMoveBitmapView.a(this.a), Math.min(this.a.c, BaseScaleAndMoveBitmapView.b(this.a)));
    if (this.a.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * this.a.c <= this.a.getHeight())
    {
      this.a.b = ((this.a.getHeight() - this.a.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * this.a.c) / 2.0F / this.a.c);
      if (this.a.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * this.a.c > this.a.getWidth()) {
        break label323;
      }
      this.a.jdField_a_of_type_Float = ((this.a.getWidth() - this.a.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * this.a.c) / 2.0F);
    }
    for (;;)
    {
      SLog.a("QQ.Troop.homework.BaseScaleAndMoveBitmapView", "onScale %f", Float.valueOf(this.a.c));
      this.a.invalidate();
      return true;
      if (this.a.b(0.0F) >= 0.0F)
      {
        this.a.b = 0.0F;
        break;
      }
      if (this.a.b(this.a.jdField_a_of_type_AndroidGraphicsBitmap.getHeight()) > this.a.getHeight()) {
        break;
      }
      this.a.b = (this.a.getHeight() / this.a.c - this.a.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
      break;
      label323:
      if (this.a.a(0.0F) >= 0.0F) {
        this.a.jdField_a_of_type_Float = 0.0F;
      } else if (this.a.a(this.a.jdField_a_of_type_AndroidGraphicsBitmap.getWidth()) <= this.a.getWidth()) {
        this.a.jdField_a_of_type_Float = (this.a.getWidth() / this.a.c - this.a.jdField_a_of_type_AndroidGraphicsBitmap.getWidth());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.arithmetic.ui.BaseScaleAndMoveBitmapView.SimpleScaleListenerImpl
 * JD-Core Version:    0.7.0.1
 */