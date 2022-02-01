package com.tencent.mobileqq.facetoface;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import asxr;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.Random;

public class SnowView
  extends View
{
  private static final Random jdField_a_of_type_JavaUtilRandom = new Random();
  int jdField_a_of_type_Int = 40;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Point jdField_a_of_type_AndroidGraphicsPoint;
  private asxr[] jdField_a_of_type_ArrayOfAsxr = new asxr[this.jdField_a_of_type_Int];
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
  
  private void b(asxr paramasxr)
  {
    paramasxr.e = (jdField_a_of_type_JavaUtilRandom.nextFloat() - 0.45F);
    paramasxr.d += paramasxr.e;
    if ((paramasxr.d > 10.0F) && (paramasxr.e > 0.0F))
    {
      paramasxr.e = 0.0F;
      paramasxr.d = 10.0F;
    }
    if ((paramasxr.d < 2.0F) && (paramasxr.e < 0.0F)) {
      paramasxr.e = 0.0F;
    }
    paramasxr.b += paramasxr.d + jdField_a_of_type_JavaUtilRandom.nextFloat() * 10.0F;
    paramasxr.c += (jdField_a_of_type_JavaUtilRandom.nextFloat() - 0.5F) * 0.5F;
    if (Math.abs(paramasxr.c) > 3.0F) {
      paramasxr.c = (0.96F * paramasxr.c);
    }
    paramasxr.jdField_a_of_type_Float += paramasxr.c;
    if (paramasxr.jdField_a_of_type_Float > this.jdField_a_of_type_AndroidGraphicsPoint.x) {
      paramasxr.jdField_a_of_type_Float = 5.0F;
    }
    if (paramasxr.jdField_a_of_type_Float < 5.0F) {
      paramasxr.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidGraphicsPoint.x;
    }
    if (paramasxr.b > this.jdField_a_of_type_AndroidGraphicsPoint.y) {
      a(paramasxr);
    }
  }
  
  public void a()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_ArrayOfAsxr[i] = new asxr(jdField_a_of_type_JavaUtilRandom.nextInt(this.jdField_a_of_type_AndroidGraphicsPoint.x), jdField_a_of_type_JavaUtilRandom.nextInt(this.jdField_a_of_type_AndroidGraphicsPoint.y), jdField_a_of_type_JavaUtilRandom.nextInt(this.b), jdField_a_of_type_JavaUtilRandom.nextInt(this.b), 0, 0.0F);
      i += 1;
    }
  }
  
  public void a(asxr paramasxr)
  {
    paramasxr.jdField_a_of_type_Float = (jdField_a_of_type_JavaUtilRandom.nextInt(this.jdField_a_of_type_AndroidGraphicsPoint.x) + 5.0F);
    paramasxr.b = 0.0F;
    paramasxr.d = (2.0F + jdField_a_of_type_JavaUtilRandom.nextFloat() * 5.0F);
    paramasxr.jdField_a_of_type_Int = jdField_a_of_type_JavaUtilRandom.nextInt(255);
    paramasxr.f = (jdField_a_of_type_JavaUtilRandom.nextFloat() - 0.5F);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = 0;
    if (i < this.jdField_a_of_type_Int)
    {
      b(this.jdField_a_of_type_ArrayOfAsxr[i]);
      if (i % 2 == 0) {
        this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(127);
      }
      for (;;)
      {
        paramCanvas.drawCircle(this.jdField_a_of_type_ArrayOfAsxr[i].jdField_a_of_type_Float, this.jdField_a_of_type_ArrayOfAsxr[i].b, AIOUtils.dp2px(1.0F, getResources()), this.jdField_a_of_type_AndroidGraphicsPaint);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.SnowView
 * JD-Core Version:    0.7.0.1
 */