package com.tencent.mobileqq.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import bene;
import java.util.ArrayList;
import java.util.Random;

public class PaParticleView
  extends View
{
  int jdField_a_of_type_Int;
  protected Paint a;
  ArrayList<bene> jdField_a_of_type_JavaUtilArrayList;
  Random jdField_a_of_type_JavaUtilRandom;
  public int b;
  public int c;
  protected int d;
  public int e;
  
  private void a(bene parambene)
  {
    if (this.e == 0) {
      if ((parambene.jdField_a_of_type_Float > this.b) || (parambene.b > this.c)) {
        parambene.b = 0.0F;
      }
    }
    for (parambene.jdField_a_of_type_Float = (this.jdField_a_of_type_JavaUtilRandom.nextFloat() * this.b);; parambene.jdField_a_of_type_Float = (this.jdField_a_of_type_JavaUtilRandom.nextFloat() * this.b))
    {
      do
      {
        parambene.jdField_a_of_type_Float += parambene.d;
        parambene.b += parambene.c;
        return;
      } while ((parambene.jdField_a_of_type_Float <= this.b) && (parambene.b >= this.e));
      parambene.b = this.c;
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
        bene localbene = (bene)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        a(localbene);
        paramCanvas.drawBitmap(localbene.jdField_a_of_type_AndroidGraphicsBitmap, localbene.jdField_a_of_type_Float, localbene.b, this.jdField_a_of_type_AndroidGraphicsPaint);
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