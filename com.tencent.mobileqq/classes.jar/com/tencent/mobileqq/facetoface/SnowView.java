package com.tencent.mobileqq.facetoface;

import aciy;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import anwt;
import java.util.Random;

public class SnowView
  extends View
{
  private static final Random jdField_a_of_type_JavaUtilRandom = new Random();
  int jdField_a_of_type_Int = 40;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Point jdField_a_of_type_AndroidGraphicsPoint;
  private anwt[] jdField_a_of_type_ArrayOfAnwt = new anwt[this.jdField_a_of_type_Int];
  int b = 10;
  
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
  
  private void b(anwt paramanwt)
  {
    paramanwt.e = (jdField_a_of_type_JavaUtilRandom.nextFloat() - 0.45F);
    paramanwt.d += paramanwt.e;
    if ((paramanwt.d > 10.0F) && (paramanwt.e > 0.0F))
    {
      paramanwt.e = 0.0F;
      paramanwt.d = 10.0F;
    }
    if ((paramanwt.d < 2.0F) && (paramanwt.e < 0.0F)) {
      paramanwt.e = 0.0F;
    }
    paramanwt.b += paramanwt.d + jdField_a_of_type_JavaUtilRandom.nextFloat() * 10.0F;
    paramanwt.c += (jdField_a_of_type_JavaUtilRandom.nextFloat() - 0.5F) * 0.5F;
    if (Math.abs(paramanwt.c) > 3.0F) {
      paramanwt.c = (0.96F * paramanwt.c);
    }
    paramanwt.jdField_a_of_type_Float += paramanwt.c;
    if (paramanwt.jdField_a_of_type_Float > this.jdField_a_of_type_AndroidGraphicsPoint.x) {
      paramanwt.jdField_a_of_type_Float = 5.0F;
    }
    if (paramanwt.jdField_a_of_type_Float < 5.0F) {
      paramanwt.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidGraphicsPoint.x;
    }
    if (paramanwt.b > this.jdField_a_of_type_AndroidGraphicsPoint.y) {
      a(paramanwt);
    }
  }
  
  public void a()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_ArrayOfAnwt[i] = new anwt(jdField_a_of_type_JavaUtilRandom.nextInt(this.jdField_a_of_type_AndroidGraphicsPoint.x), jdField_a_of_type_JavaUtilRandom.nextInt(this.jdField_a_of_type_AndroidGraphicsPoint.y), jdField_a_of_type_JavaUtilRandom.nextInt(this.b), jdField_a_of_type_JavaUtilRandom.nextInt(this.b), 0, 0.0F);
      i += 1;
    }
  }
  
  public void a(anwt paramanwt)
  {
    paramanwt.jdField_a_of_type_Float = (jdField_a_of_type_JavaUtilRandom.nextInt(this.jdField_a_of_type_AndroidGraphicsPoint.x) + 5.0F);
    paramanwt.b = 0.0F;
    paramanwt.d = (2.0F + jdField_a_of_type_JavaUtilRandom.nextFloat() * 5.0F);
    paramanwt.jdField_a_of_type_Int = jdField_a_of_type_JavaUtilRandom.nextInt(255);
    paramanwt.f = (jdField_a_of_type_JavaUtilRandom.nextFloat() - 0.5F);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = 0;
    if (i < this.jdField_a_of_type_Int)
    {
      b(this.jdField_a_of_type_ArrayOfAnwt[i]);
      if (i % 2 == 0) {
        this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(127);
      }
      for (;;)
      {
        paramCanvas.drawCircle(this.jdField_a_of_type_ArrayOfAnwt[i].jdField_a_of_type_Float, this.jdField_a_of_type_ArrayOfAnwt[i].b, aciy.a(1.0F, getResources()), this.jdField_a_of_type_AndroidGraphicsPaint);
        i += 1;
        break;
        this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(51);
      }
    }
  }
  
  public void setSnowView(Point paramPoint)
  {
    this.jdField_a_of_type_AndroidGraphicsPoint = paramPoint;
    a();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.SnowView
 * JD-Core Version:    0.7.0.1
 */