package com.tencent.mobileqq.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import bcoc;
import java.util.ArrayList;
import java.util.Random;

public class PaParticleView
  extends View
{
  int jdField_a_of_type_Int;
  protected Paint a;
  ArrayList<bcoc> jdField_a_of_type_JavaUtilArrayList;
  Random jdField_a_of_type_JavaUtilRandom;
  public int b;
  public int c;
  protected int d;
  public int e;
  
  private void a(bcoc parambcoc)
  {
    if (this.e == 0) {
      if ((parambcoc.jdField_a_of_type_Float > this.b) || (parambcoc.b > this.c)) {
        parambcoc.b = 0.0F;
      }
    }
    for (parambcoc.jdField_a_of_type_Float = (this.jdField_a_of_type_JavaUtilRandom.nextFloat() * this.b);; parambcoc.jdField_a_of_type_Float = (this.jdField_a_of_type_JavaUtilRandom.nextFloat() * this.b))
    {
      do
      {
        parambcoc.jdField_a_of_type_Float += parambcoc.d;
        parambcoc.b += parambcoc.c;
        return;
      } while ((parambcoc.jdField_a_of_type_Float <= this.b) && (parambcoc.b >= this.e));
      parambcoc.b = this.c;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() >= this.jdField_a_of_type_Int))
    {
      int i = 0;
      while (i < this.jdField_a_of_type_Int)
      {
        bcoc localbcoc = (bcoc)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        a(localbcoc);
        paramCanvas.drawBitmap(localbcoc.jdField_a_of_type_AndroidGraphicsBitmap, localbcoc.jdField_a_of_type_Float, localbcoc.b, this.jdField_a_of_type_AndroidGraphicsPaint);
        i += 1;
      }
    }
    postInvalidateDelayed(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PaParticleView
 * JD-Core Version:    0.7.0.1
 */