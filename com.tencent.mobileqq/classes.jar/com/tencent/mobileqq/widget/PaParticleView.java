package com.tencent.mobileqq.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import bizs;
import java.util.ArrayList;
import java.util.Random;

public class PaParticleView
  extends View
{
  int jdField_a_of_type_Int;
  protected Paint a;
  ArrayList<bizs> jdField_a_of_type_JavaUtilArrayList;
  Random jdField_a_of_type_JavaUtilRandom;
  public int b;
  public int c;
  protected int d;
  public int e;
  
  private void a(bizs parambizs)
  {
    if (this.e == 0) {
      if ((parambizs.jdField_a_of_type_Float > this.b) || (parambizs.b > this.c)) {
        parambizs.b = 0.0F;
      }
    }
    for (parambizs.jdField_a_of_type_Float = (this.jdField_a_of_type_JavaUtilRandom.nextFloat() * this.b);; parambizs.jdField_a_of_type_Float = (this.jdField_a_of_type_JavaUtilRandom.nextFloat() * this.b))
    {
      do
      {
        parambizs.jdField_a_of_type_Float += parambizs.d;
        parambizs.b += parambizs.c;
        return;
      } while ((parambizs.jdField_a_of_type_Float <= this.b) && (parambizs.b >= this.e));
      parambizs.b = this.c;
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
        bizs localbizs = (bizs)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        a(localbizs);
        paramCanvas.drawBitmap(localbizs.jdField_a_of_type_AndroidGraphicsBitmap, localbizs.jdField_a_of_type_Float, localbizs.b, this.jdField_a_of_type_AndroidGraphicsPaint);
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