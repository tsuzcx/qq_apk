package com.tencent.mobileqq.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import java.util.ArrayList;
import java.util.Random;

public class PaParticleView
  extends View
{
  int a;
  public int b;
  public int c;
  protected int d;
  public int e;
  Random f;
  protected Paint g;
  ArrayList<PaWeatherPaticle> h;
  
  private void a(PaWeatherPaticle paramPaWeatherPaticle)
  {
    if (this.e == 0)
    {
      if ((paramPaWeatherPaticle.b > this.b) || (paramPaWeatherPaticle.c > this.c))
      {
        paramPaWeatherPaticle.c = 0.0F;
        paramPaWeatherPaticle.b = (this.f.nextFloat() * this.b);
      }
    }
    else if ((paramPaWeatherPaticle.b > this.b) || (paramPaWeatherPaticle.c < this.e))
    {
      paramPaWeatherPaticle.c = this.c;
      paramPaWeatherPaticle.b = (this.f.nextFloat() * this.b);
    }
    paramPaWeatherPaticle.b += paramPaWeatherPaticle.e;
    paramPaWeatherPaticle.c += paramPaWeatherPaticle.d;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject = this.h;
    if ((localObject != null) && (((ArrayList)localObject).size() >= this.a))
    {
      int i = 0;
      while (i < this.a)
      {
        localObject = (PaWeatherPaticle)this.h.get(i);
        a((PaWeatherPaticle)localObject);
        paramCanvas.drawBitmap(((PaWeatherPaticle)localObject).a, ((PaWeatherPaticle)localObject).b, ((PaWeatherPaticle)localObject).c, this.g);
        i += 1;
      }
    }
    postInvalidateDelayed(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PaParticleView
 * JD-Core Version:    0.7.0.1
 */