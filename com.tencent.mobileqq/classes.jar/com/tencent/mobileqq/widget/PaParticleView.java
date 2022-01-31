package com.tencent.mobileqq.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import bern;
import java.util.ArrayList;
import java.util.Random;

public class PaParticleView
  extends View
{
  int jdField_a_of_type_Int;
  protected Paint a;
  ArrayList<bern> jdField_a_of_type_JavaUtilArrayList;
  Random jdField_a_of_type_JavaUtilRandom;
  public int b;
  public int c;
  protected int d;
  public int e;
  
  private void a(bern parambern)
  {
    if (this.e == 0) {
      if ((parambern.jdField_a_of_type_Float > this.b) || (parambern.b > this.c)) {
        parambern.b = 0.0F;
      }
    }
    for (parambern.jdField_a_of_type_Float = (this.jdField_a_of_type_JavaUtilRandom.nextFloat() * this.b);; parambern.jdField_a_of_type_Float = (this.jdField_a_of_type_JavaUtilRandom.nextFloat() * this.b))
    {
      do
      {
        parambern.jdField_a_of_type_Float += parambern.d;
        parambern.b += parambern.c;
        return;
      } while ((parambern.jdField_a_of_type_Float <= this.b) && (parambern.b >= this.e));
      parambern.b = this.c;
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
        bern localbern = (bern)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        a(localbern);
        paramCanvas.drawBitmap(localbern.jdField_a_of_type_AndroidGraphicsBitmap, localbern.jdField_a_of_type_Float, localbern.b, this.jdField_a_of_type_AndroidGraphicsPaint);
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