package com.tencent.mobileqq.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import java.util.ArrayList;
import java.util.Random;

public class PaParticleView
  extends View
{
  int jdField_a_of_type_Int;
  protected Paint a;
  ArrayList<PaWeatherPaticle> jdField_a_of_type_JavaUtilArrayList;
  Random jdField_a_of_type_JavaUtilRandom;
  public int b;
  public int c;
  protected int d;
  public int e;
  
  private void a(PaWeatherPaticle paramPaWeatherPaticle)
  {
    if (this.e == 0)
    {
      if ((paramPaWeatherPaticle.jdField_a_of_type_Float > this.b) || (paramPaWeatherPaticle.b > this.c))
      {
        paramPaWeatherPaticle.b = 0.0F;
        paramPaWeatherPaticle.jdField_a_of_type_Float = (this.jdField_a_of_type_JavaUtilRandom.nextFloat() * this.b);
      }
    }
    else if ((paramPaWeatherPaticle.jdField_a_of_type_Float > this.b) || (paramPaWeatherPaticle.b < this.e))
    {
      paramPaWeatherPaticle.b = this.c;
      paramPaWeatherPaticle.jdField_a_of_type_Float = (this.jdField_a_of_type_JavaUtilRandom.nextFloat() * this.b);
    }
    paramPaWeatherPaticle.jdField_a_of_type_Float += paramPaWeatherPaticle.d;
    paramPaWeatherPaticle.b += paramPaWeatherPaticle.c;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localObject != null) && (((ArrayList)localObject).size() >= this.jdField_a_of_type_Int))
    {
      int i = 0;
      while (i < this.jdField_a_of_type_Int)
      {
        localObject = (PaWeatherPaticle)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        a((PaWeatherPaticle)localObject);
        paramCanvas.drawBitmap(((PaWeatherPaticle)localObject).jdField_a_of_type_AndroidGraphicsBitmap, ((PaWeatherPaticle)localObject).jdField_a_of_type_Float, ((PaWeatherPaticle)localObject).b, this.jdField_a_of_type_AndroidGraphicsPaint);
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