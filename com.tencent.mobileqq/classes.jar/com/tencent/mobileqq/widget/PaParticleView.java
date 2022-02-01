package com.tencent.mobileqq.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import bhft;
import java.util.ArrayList;
import java.util.Random;

public class PaParticleView
  extends View
{
  int jdField_a_of_type_Int;
  protected Paint a;
  ArrayList<bhft> jdField_a_of_type_JavaUtilArrayList;
  Random jdField_a_of_type_JavaUtilRandom;
  public int b;
  public int c;
  protected int d;
  public int e;
  
  private void a(bhft parambhft)
  {
    if (this.e == 0) {
      if ((parambhft.jdField_a_of_type_Float > this.b) || (parambhft.b > this.c)) {
        parambhft.b = 0.0F;
      }
    }
    for (parambhft.jdField_a_of_type_Float = (this.jdField_a_of_type_JavaUtilRandom.nextFloat() * this.b);; parambhft.jdField_a_of_type_Float = (this.jdField_a_of_type_JavaUtilRandom.nextFloat() * this.b))
    {
      do
      {
        parambhft.jdField_a_of_type_Float += parambhft.d;
        parambhft.b += parambhft.c;
        return;
      } while ((parambhft.jdField_a_of_type_Float <= this.b) && (parambhft.b >= this.e));
      parambhft.b = this.c;
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
        bhft localbhft = (bhft)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        a(localbhft);
        paramCanvas.drawBitmap(localbhft.jdField_a_of_type_AndroidGraphicsBitmap, localbhft.jdField_a_of_type_Float, localbhft.b, this.jdField_a_of_type_AndroidGraphicsPaint);
        i += 1;
      }
    }
    postInvalidateDelayed(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PaParticleView
 * JD-Core Version:    0.7.0.1
 */