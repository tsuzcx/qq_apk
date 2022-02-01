package com.tencent.mobileqq.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import biql;
import java.util.ArrayList;
import java.util.Random;

public class PaParticleView
  extends View
{
  int jdField_a_of_type_Int;
  protected Paint a;
  ArrayList<biql> jdField_a_of_type_JavaUtilArrayList;
  Random jdField_a_of_type_JavaUtilRandom;
  public int b;
  public int c;
  protected int d;
  public int e;
  
  private void a(biql parambiql)
  {
    if (this.e == 0) {
      if ((parambiql.jdField_a_of_type_Float > this.b) || (parambiql.b > this.c)) {
        parambiql.b = 0.0F;
      }
    }
    for (parambiql.jdField_a_of_type_Float = (this.jdField_a_of_type_JavaUtilRandom.nextFloat() * this.b);; parambiql.jdField_a_of_type_Float = (this.jdField_a_of_type_JavaUtilRandom.nextFloat() * this.b))
    {
      do
      {
        parambiql.jdField_a_of_type_Float += parambiql.d;
        parambiql.b += parambiql.c;
        return;
      } while ((parambiql.jdField_a_of_type_Float <= this.b) && (parambiql.b >= this.e));
      parambiql.b = this.c;
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
        biql localbiql = (biql)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        a(localbiql);
        paramCanvas.drawBitmap(localbiql.jdField_a_of_type_AndroidGraphicsBitmap, localbiql.jdField_a_of_type_Float, localbiql.b, this.jdField_a_of_type_AndroidGraphicsPaint);
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