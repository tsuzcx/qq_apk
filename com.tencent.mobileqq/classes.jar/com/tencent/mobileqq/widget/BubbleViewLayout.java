package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout;
import java.util.Arrays;

public class BubbleViewLayout
  extends RelativeLayout
{
  private float jdField_a_of_type_Float = 30.0F;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  Path jdField_a_of_type_AndroidGraphicsPath;
  RectF jdField_a_of_type_AndroidGraphicsRectF;
  public boolean a;
  float[] jdField_a_of_type_ArrayOfFloat;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private boolean jdField_b_of_type_Boolean = true;
  private boolean c = true;
  
  public BubbleViewLayout(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = true;
    a();
  }
  
  public BubbleViewLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
    a();
  }
  
  public static int a(float paramFloat, Resources paramResources)
  {
    return (int)(paramResources.getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setXfermode(null);
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_a_of_type_ArrayOfFloat = new float[8];
    this.jdField_a_of_type_AndroidContentResResources = getResources();
    setRadius(15.0F);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, paramFloat1, paramFloat2);
      if (this.c)
      {
        this.jdField_a_of_type_AndroidGraphicsPath.reset();
        this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_ArrayOfFloat, Path.Direction.CW);
      }
      return;
    }
    Resources localResources = this.jdField_a_of_type_AndroidContentResResources;
    float f1 = a(10.0F, localResources);
    float f2;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, paramFloat1 - f1, paramFloat2);
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
      paramFloat2 = a(5.0F, localResources);
      if (!this.jdField_a_of_type_Boolean) {
        break label267;
      }
      this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_ArrayOfFloat, Path.Direction.CW);
      f1 = a(14.0F, localResources);
      f2 = a(8.0F, localResources);
      this.jdField_a_of_type_AndroidGraphicsPath.moveTo(paramFloat1 - f1, f2);
      f1 = a(4.0F, localResources);
      f2 = a(10.0F, localResources);
      this.jdField_a_of_type_AndroidGraphicsPath.quadTo(paramFloat1 - f1, f2, paramFloat1, paramFloat2);
      paramFloat2 = a(10.0F, localResources);
      f1 = a(16.0F, localResources);
      f2 = a(1.0F, localResources);
      float f3 = a(14.0F, localResources);
      this.jdField_a_of_type_AndroidGraphicsPath.quadTo(paramFloat1 - f2, f3, paramFloat1 - paramFloat2, f1);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsPath.close();
      return;
      this.jdField_a_of_type_AndroidGraphicsRectF.set(f1, 0.0F, paramFloat1, paramFloat2);
      break;
      label267:
      this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_ArrayOfFloat, Path.Direction.CCW);
      paramFloat1 = a(14.0F, localResources);
      f1 = a(8.0F, localResources);
      this.jdField_a_of_type_AndroidGraphicsPath.moveTo(paramFloat1, f1);
      paramFloat1 = a(4.0F, localResources);
      f1 = a(10.0F, localResources);
      this.jdField_a_of_type_AndroidGraphicsPath.quadTo(paramFloat1, f1, 0.0F, paramFloat2);
      paramFloat1 = a(10.0F, localResources);
      paramFloat2 = a(16.0F, localResources);
      f1 = a(1.0F, localResources);
      f2 = a(14.0F, localResources);
      this.jdField_a_of_type_AndroidGraphicsPath.quadTo(f1, f2, paramFloat1, paramFloat2);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    paramCanvas.saveLayer(new RectF(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight()), this.jdField_b_of_type_AndroidGraphicsPaint, 31);
    super.dispatchDraw(paramCanvas);
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.restore();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean) {
      a(getWidth(), getHeight());
    }
  }
  
  public void setRadius(float paramFloat)
  {
    this.jdField_a_of_type_Float = a(paramFloat, this.jdField_a_of_type_AndroidContentResResources);
    if (this.jdField_a_of_type_ArrayOfFloat != null) {
      Arrays.fill(this.jdField_a_of_type_ArrayOfFloat, this.jdField_a_of_type_Float);
    }
  }
  
  public void setRadiusTop(float paramFloat)
  {
    this.jdField_a_of_type_Float = a(paramFloat, this.jdField_a_of_type_AndroidContentResResources);
    if (this.jdField_a_of_type_ArrayOfFloat != null)
    {
      Arrays.fill(this.jdField_a_of_type_ArrayOfFloat, 0, 4, this.jdField_a_of_type_Float);
      Arrays.fill(this.jdField_a_of_type_ArrayOfFloat, 4, 8, 0.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.widget.BubbleViewLayout
 * JD-Core Version:    0.7.0.1
 */