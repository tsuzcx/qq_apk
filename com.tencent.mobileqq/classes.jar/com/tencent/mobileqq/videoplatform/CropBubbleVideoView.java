package com.tencent.mobileqq.videoplatform;

import acum;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import bbvs;
import java.util.Arrays;

public class CropBubbleVideoView
  extends BaseVideoView
  implements acum
{
  float jdField_a_of_type_Float = this.jdField_a_of_type_ArrayOfFloat[0];
  private Path jdField_a_of_type_AndroidGraphicsPath;
  public boolean a;
  float[] jdField_a_of_type_ArrayOfFloat = { 7.0F, 9.0F, 0.0F, 6.0F, 2.5F, 9.0F, 5.5F, 15.0F, 0.5F, 13.0F };
  float b = this.jdField_a_of_type_ArrayOfFloat[1];
  float c = this.jdField_a_of_type_ArrayOfFloat[2];
  float d = this.jdField_a_of_type_ArrayOfFloat[3];
  float e = this.jdField_a_of_type_ArrayOfFloat[4];
  float f = this.jdField_a_of_type_ArrayOfFloat[5];
  float g = this.jdField_a_of_type_ArrayOfFloat[6];
  float h = this.jdField_a_of_type_ArrayOfFloat[7];
  float i = this.jdField_a_of_type_ArrayOfFloat[8];
  float j = this.jdField_a_of_type_ArrayOfFloat[9];
  public float k = Math.abs(this.c - this.g);
  
  public CropBubbleVideoView(Context paramContext, long paramLong, bbvs parambbvs, boolean paramBoolean)
  {
    super(paramContext, paramLong, parambbvs);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static int a(float paramFloat, Resources paramResources)
  {
    return (int)(paramResources.getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private void a(boolean paramBoolean, int paramInt1, int paramInt2, Resources paramResources, float paramFloat)
  {
    RectF localRectF;
    float f1;
    label53:
    float[] arrayOfFloat;
    float f2;
    float f3;
    if (this.jdField_a_of_type_AndroidGraphicsPath != null)
    {
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
      localRectF = new RectF();
      f1 = a(this.k, paramResources);
      if (!paramBoolean) {
        break label292;
      }
      localRectF.set(0.0F, 0.0F, paramInt1 - f1, paramInt2);
      f1 = a(this.d, paramResources);
      arrayOfFloat = new float[8];
      paramFloat = a(paramFloat, paramResources);
      if (arrayOfFloat != null) {
        Arrays.fill(arrayOfFloat, paramFloat);
      }
      if (!paramBoolean) {
        break label307;
      }
      this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(localRectF, arrayOfFloat, Path.Direction.CW);
      paramFloat = paramInt1 - a(this.jdField_a_of_type_Float, paramResources);
      f2 = a(this.b, paramResources);
      this.jdField_a_of_type_AndroidGraphicsPath.moveTo(paramFloat, f2);
      paramFloat = paramInt1 - a(this.c, paramResources);
      f2 = paramInt1 - a(this.e, paramResources);
      f3 = a(this.f, paramResources);
      this.jdField_a_of_type_AndroidGraphicsPath.quadTo(f2, f3, paramFloat, f1);
      paramFloat = paramInt1 - a(this.g, paramResources);
      f1 = a(this.h, paramResources);
      f2 = paramInt1 - a(this.i, paramResources);
      f3 = a(this.j, paramResources);
      this.jdField_a_of_type_AndroidGraphicsPath.quadTo(f2, f3, paramFloat, f1);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsPath.close();
      return;
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
      break;
      label292:
      localRectF.set(f1, 0.0F, paramInt1, paramInt2);
      break label53;
      label307:
      this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(localRectF, arrayOfFloat, Path.Direction.CCW);
      paramFloat = a(this.jdField_a_of_type_Float, paramResources);
      f2 = a(this.b, paramResources);
      this.jdField_a_of_type_AndroidGraphicsPath.moveTo(paramFloat, f2);
      paramFloat = this.c;
      f2 = a(this.e, paramResources);
      f3 = a(this.f, paramResources);
      this.jdField_a_of_type_AndroidGraphicsPath.quadTo(f2, f3, paramFloat, f1);
      paramFloat = a(this.g, paramResources);
      f1 = a(this.h, paramResources);
      f2 = a(this.i, paramResources);
      f3 = a(this.j, paramResources);
      this.jdField_a_of_type_AndroidGraphicsPath.quadTo(f2, f3, paramFloat, f1);
    }
  }
  
  public float a()
  {
    return this.k;
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent) {}
  
  public void a(View paramView, boolean paramBoolean) {}
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    int m = getWidth();
    int n = getHeight();
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    a(this.jdField_a_of_type_Boolean, m, n, localResources, 15.0F);
    if (this.jdField_a_of_type_AndroidGraphicsPath != null) {
      paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
    }
    super.dispatchDraw(paramCanvas);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (Build.VERSION.SDK_INT < 18)
    {
      setLayerType(1, null);
      return;
    }
    setLayerType(2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.CropBubbleVideoView
 * JD-Core Version:    0.7.0.1
 */