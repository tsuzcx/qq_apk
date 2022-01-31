package com.tencent.mobileqq.facetoface;

import actj;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import aons;
import java.util.Random;

public class SnowView
  extends View
{
  private static final Random jdField_a_of_type_JavaUtilRandom = new Random();
  int jdField_a_of_type_Int = 40;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Point jdField_a_of_type_AndroidGraphicsPoint;
  private aons[] jdField_a_of_type_ArrayOfAons = new aons[this.jdField_a_of_type_Int];
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
  
  private void b(aons paramaons)
  {
    paramaons.e = (jdField_a_of_type_JavaUtilRandom.nextFloat() - 0.45F);
    paramaons.d += paramaons.e;
    if ((paramaons.d > 10.0F) && (paramaons.e > 0.0F))
    {
      paramaons.e = 0.0F;
      paramaons.d = 10.0F;
    }
    if ((paramaons.d < 2.0F) && (paramaons.e < 0.0F)) {
      paramaons.e = 0.0F;
    }
    paramaons.b += paramaons.d + jdField_a_of_type_JavaUtilRandom.nextFloat() * 10.0F;
    paramaons.c += (jdField_a_of_type_JavaUtilRandom.nextFloat() - 0.5F) * 0.5F;
    if (Math.abs(paramaons.c) > 3.0F) {
      paramaons.c = (0.96F * paramaons.c);
    }
    paramaons.jdField_a_of_type_Float += paramaons.c;
    if (paramaons.jdField_a_of_type_Float > this.jdField_a_of_type_AndroidGraphicsPoint.x) {
      paramaons.jdField_a_of_type_Float = 5.0F;
    }
    if (paramaons.jdField_a_of_type_Float < 5.0F) {
      paramaons.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidGraphicsPoint.x;
    }
    if (paramaons.b > this.jdField_a_of_type_AndroidGraphicsPoint.y) {
      a(paramaons);
    }
  }
  
  public void a()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_ArrayOfAons[i] = new aons(jdField_a_of_type_JavaUtilRandom.nextInt(this.jdField_a_of_type_AndroidGraphicsPoint.x), jdField_a_of_type_JavaUtilRandom.nextInt(this.jdField_a_of_type_AndroidGraphicsPoint.y), jdField_a_of_type_JavaUtilRandom.nextInt(this.b), jdField_a_of_type_JavaUtilRandom.nextInt(this.b), 0, 0.0F);
      i += 1;
    }
  }
  
  public void a(aons paramaons)
  {
    paramaons.jdField_a_of_type_Float = (jdField_a_of_type_JavaUtilRandom.nextInt(this.jdField_a_of_type_AndroidGraphicsPoint.x) + 5.0F);
    paramaons.b = 0.0F;
    paramaons.d = (2.0F + jdField_a_of_type_JavaUtilRandom.nextFloat() * 5.0F);
    paramaons.jdField_a_of_type_Int = jdField_a_of_type_JavaUtilRandom.nextInt(255);
    paramaons.f = (jdField_a_of_type_JavaUtilRandom.nextFloat() - 0.5F);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = 0;
    if (i < this.jdField_a_of_type_Int)
    {
      b(this.jdField_a_of_type_ArrayOfAons[i]);
      if (i % 2 == 0) {
        this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(127);
      }
      for (;;)
      {
        paramCanvas.drawCircle(this.jdField_a_of_type_ArrayOfAons[i].jdField_a_of_type_Float, this.jdField_a_of_type_ArrayOfAons[i].b, actj.a(1.0F, getResources()), this.jdField_a_of_type_AndroidGraphicsPaint);
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