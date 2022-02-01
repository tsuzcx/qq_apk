package com.tencent.xweb.extension.video;

import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;

public class c
{
  private c.a a;
  private ImageView b;
  private ImageView c;
  private ImageView d = null;
  private ImageView e = null;
  private boolean f = false;
  private float g = 0.0F;
  private float h;
  private float i;
  
  public c(FrameLayout paramFrameLayout, c.a parama)
  {
    this.a = parama;
    this.b = ((ImageView)paramFrameLayout.findViewById(2131440414));
    this.d = ((ImageView)paramFrameLayout.findViewById(2131440415));
    this.c = ((ImageView)paramFrameLayout.findViewById(2131440413));
    this.e = ((ImageView)paramFrameLayout.findViewById(2131440416));
    this.e.setOnTouchListener(new c.1(this));
  }
  
  public float a()
  {
    return this.i;
  }
  
  public void a(double paramDouble, double[] paramArrayOfDouble)
  {
    double d1 = 0.0D;
    int j = 0;
    while (j < paramArrayOfDouble.length)
    {
      int k = paramArrayOfDouble.length;
      int m = j + 1;
      double d2 = d1;
      if (k > m)
      {
        double d3 = paramArrayOfDouble[j] / paramDouble;
        float f1 = this.i;
        d2 = d1;
        if (d3 * 100.0D <= f1)
        {
          d2 = d1;
          if (paramArrayOfDouble[m] / paramDouble * 100.0D > f1) {
            d2 = paramArrayOfDouble[m] / paramDouble * 100.0D;
          }
        }
      }
      j += 2;
      d1 = d2;
    }
    paramArrayOfDouble = (FrameLayout.LayoutParams)this.d.getLayoutParams();
    paramDouble = d1 / 100.0D;
    d1 = this.c.getWidth();
    Double.isNaN(d1);
    paramArrayOfDouble.width = ((int)(paramDouble * d1));
    this.d.setLayoutParams(paramArrayOfDouble);
    this.d.requestLayout();
  }
  
  public void a(float paramFloat, boolean paramBoolean)
  {
    if ((this.f) && (!paramBoolean)) {
      return;
    }
    float f1;
    if (paramFloat < 0.0F)
    {
      f1 = 0.0F;
    }
    else
    {
      f1 = paramFloat;
      if (paramFloat > 100.0F) {
        f1 = 100.0F;
      }
    }
    this.i = f1;
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.e.getLayoutParams();
    paramFloat = f1 / 100.0F;
    localLayoutParams.leftMargin = ((int)(this.c.getWidth() * paramFloat - this.e.getWidth() / 2));
    this.e.setLayoutParams(localLayoutParams);
    this.e.requestLayout();
    localLayoutParams = (FrameLayout.LayoutParams)this.b.getLayoutParams();
    localLayoutParams.width = ((int)(paramFloat * this.c.getWidth()));
    this.b.setLayoutParams(localLayoutParams);
    this.b.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.extension.video.c
 * JD-Core Version:    0.7.0.1
 */