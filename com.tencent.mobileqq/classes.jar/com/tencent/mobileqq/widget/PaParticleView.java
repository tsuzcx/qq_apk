package com.tencent.mobileqq.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import bhyu;
import java.util.ArrayList;
import java.util.Random;

public class PaParticleView
  extends View
{
  int jdField_a_of_type_Int;
  protected Paint a;
  ArrayList<bhyu> jdField_a_of_type_JavaUtilArrayList;
  Random jdField_a_of_type_JavaUtilRandom;
  public int b;
  public int c;
  protected int d;
  public int e;
  
  private void a(bhyu parambhyu)
  {
    if (this.e == 0) {
      if ((parambhyu.jdField_a_of_type_Float > this.b) || (parambhyu.b > this.c)) {
        parambhyu.b = 0.0F;
      }
    }
    for (parambhyu.jdField_a_of_type_Float = (this.jdField_a_of_type_JavaUtilRandom.nextFloat() * this.b);; parambhyu.jdField_a_of_type_Float = (this.jdField_a_of_type_JavaUtilRandom.nextFloat() * this.b))
    {
      do
      {
        parambhyu.jdField_a_of_type_Float += parambhyu.d;
        parambhyu.b += parambhyu.c;
        return;
      } while ((parambhyu.jdField_a_of_type_Float <= this.b) && (parambhyu.b >= this.e));
      parambhyu.b = this.c;
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
        bhyu localbhyu = (bhyu)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        a(localbhyu);
        paramCanvas.drawBitmap(localbhyu.jdField_a_of_type_AndroidGraphicsBitmap, localbhyu.jdField_a_of_type_Float, localbhyu.b, this.jdField_a_of_type_AndroidGraphicsPaint);
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