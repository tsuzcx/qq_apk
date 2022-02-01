package com.tencent.mobileqq.facetoface;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.Random;

public class SnowView
  extends View
{
  private static final Random d = new Random();
  int a = 40;
  int b = 10;
  private final Paint c = new Paint();
  private Snow[] e = new Snow[this.a];
  private Point f;
  
  public SnowView(Context paramContext)
  {
    super(paramContext);
  }
  
  public SnowView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SnowView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void b(Snow paramSnow)
  {
    paramSnow.e = (d.nextFloat() - 0.45F);
    paramSnow.d += paramSnow.e;
    if ((paramSnow.d > 10.0F) && (paramSnow.e > 0.0F))
    {
      paramSnow.e = 0.0F;
      paramSnow.d = 10.0F;
    }
    if ((paramSnow.d < 2.0F) && (paramSnow.e < 0.0F)) {
      paramSnow.e = 0.0F;
    }
    paramSnow.b += paramSnow.d + d.nextFloat() * 10.0F;
    paramSnow.c += (d.nextFloat() - 0.5F) * 0.5F;
    if (Math.abs(paramSnow.c) > 3.0F) {
      paramSnow.c *= 0.96F;
    }
    paramSnow.a += paramSnow.c;
    if (paramSnow.a > this.f.x) {
      paramSnow.a = 5.0F;
    }
    if (paramSnow.a < 5.0F) {
      paramSnow.a = this.f.x;
    }
    if (paramSnow.b > this.f.y) {
      a(paramSnow);
    }
  }
  
  public void a()
  {
    int i = 0;
    while (i < this.a)
    {
      this.e[i] = new Snow(d.nextInt(this.f.x), d.nextInt(this.f.y), d.nextInt(this.b), d.nextInt(this.b), 0, 0.0F);
      i += 1;
    }
  }
  
  public void a(Snow paramSnow)
  {
    paramSnow.a = (d.nextInt(this.f.x) + 5.0F);
    paramSnow.b = 0.0F;
    paramSnow.d = (d.nextFloat() * 5.0F + 2.0F);
    paramSnow.f = d.nextInt(255);
    paramSnow.g = (d.nextFloat() - 0.5F);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = 0;
    while (i < this.a)
    {
      b(this.e[i]);
      if (i % 2 == 0) {
        this.c.setAlpha(127);
      } else {
        this.c.setAlpha(51);
      }
      paramCanvas.drawCircle(this.e[i].a, this.e[i].b, AIOUtils.b(1.0F, getResources()), this.c);
      i += 1;
    }
  }
  
  public void setSnowView(Point paramPoint)
  {
    this.f = paramPoint;
    a();
    this.c.setColor(-1);
    this.c.setDither(true);
    this.c.setAntiAlias(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.SnowView
 * JD-Core Version:    0.7.0.1
 */