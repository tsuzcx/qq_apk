package com.tencent.mobileqq.nearby.now.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.av.utils.api.IUIToolsApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;

public class MetaballView
  extends View
{
  private float jdField_a_of_type_Float = 1.0F;
  private final int jdField_a_of_type_Int = 2;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  private MetaballView.Circle jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetMetaballView$Circle;
  private MetaballView.MoveAnimation jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetMetaballView$MoveAnimation;
  private ArrayList<MetaballView.Circle> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  float[] jdField_a_of_type_ArrayOfFloat = new float[2];
  private float jdField_b_of_type_Float = 10.0F;
  private int jdField_b_of_type_Int = 60;
  float[] jdField_b_of_type_ArrayOfFloat = new float[2];
  private final float jdField_c_of_type_Float = 0.3F;
  float[] jdField_c_of_type_ArrayOfFloat = new float[2];
  private float jdField_d_of_type_Float;
  float[] jdField_d_of_type_ArrayOfFloat = new float[2];
  private float jdField_e_of_type_Float;
  float[] jdField_e_of_type_ArrayOfFloat = new float[2];
  float[] f = new float[2];
  float[] g = new float[2];
  float[] h = new float[2];
  float[] i = new float[2];
  float[] j = new float[2];
  float[] k = new float[2];
  float[] l = new float[2];
  float[] m = new float[2];
  
  public MetaballView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public MetaballView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet, 0);
    a();
  }
  
  public MetaballView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private float a(float[] paramArrayOfFloat)
  {
    return (float)Math.sqrt(paramArrayOfFloat[0] * paramArrayOfFloat[0] + paramArrayOfFloat[1] * paramArrayOfFloat[1]);
  }
  
  private float a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    float f1 = paramArrayOfFloat1[0] - paramArrayOfFloat2[0];
    float f2 = paramArrayOfFloat1[1] - paramArrayOfFloat2[1];
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  private void a()
  {
    this.jdField_b_of_type_Float = a();
    this.jdField_b_of_type_Int = b();
    float f1 = this.jdField_b_of_type_Float * 1.3F;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-16395392);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    MetaballView.Circle localCircle = new MetaballView.Circle(this, null);
    float f2 = this.jdField_b_of_type_Float;
    localCircle.jdField_a_of_type_ArrayOfFloat = new float[] { this.jdField_b_of_type_Int + f2, f1 };
    localCircle.jdField_a_of_type_Float = (f2 / 4.0F * 3.0F);
    this.jdField_a_of_type_JavaUtilArrayList.add(localCircle);
    int n = 1;
    while (n < 2)
    {
      localCircle = new MetaballView.Circle(this, null);
      f2 = this.jdField_b_of_type_Float;
      localCircle.jdField_a_of_type_ArrayOfFloat = new float[] { (2.0F * f2 + this.jdField_b_of_type_Int) * n, f1 };
      localCircle.jdField_a_of_type_Float = f2;
      this.jdField_a_of_type_JavaUtilArrayList.add(localCircle);
      n += 1;
    }
    f1 = this.jdField_b_of_type_Float;
    this.jdField_d_of_type_Float = ((f1 * 2.0F + this.jdField_b_of_type_Int) * 2.0F - f1 * 2.0F);
  }
  
  private void a(float paramFloat1, float paramFloat2, float[] paramArrayOfFloat)
  {
    double d2 = paramFloat1;
    double d3 = Math.cos(d2);
    double d1 = paramFloat2;
    Double.isNaN(d1);
    paramArrayOfFloat[0] = ((float)(d3 * d1));
    d2 = Math.sin(d2);
    Double.isNaN(d1);
    paramArrayOfFloat[1] = ((float)(d2 * d1));
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Object localObject1 = (MetaballView.Circle)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt2);
    Object localObject2 = (MetaballView.Circle)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1);
    float f4 = a(((MetaballView.Circle)localObject1).jdField_a_of_type_ArrayOfFloat, ((MetaballView.Circle)localObject2).jdField_a_of_type_ArrayOfFloat);
    float f3 = ((MetaballView.Circle)localObject1).jdField_a_of_type_Float;
    float f1 = ((MetaballView.Circle)localObject2).jdField_a_of_type_Float;
    if (f4 > paramFloat3)
    {
      paramCanvas.drawCircle(localObject2.jdField_a_of_type_ArrayOfFloat[0], localObject2.jdField_a_of_type_ArrayOfFloat[1], f1, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    else
    {
      f1 *= ((1.0F - f4 / paramFloat3) * 0.3F + 1.0F);
      paramCanvas.drawCircle(localObject2.jdField_a_of_type_ArrayOfFloat[0], localObject2.jdField_a_of_type_ArrayOfFloat[1], f1, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    float f2 = 0.0F;
    if (f3 != 0.0F)
    {
      if (f1 == 0.0F) {
        return;
      }
      if (f4 <= paramFloat3)
      {
        float f6 = f3 - f1;
        if (f4 <= Math.abs(f6)) {
          return;
        }
        float f5 = f3 + f1;
        if (f4 < f5)
        {
          paramFloat3 = f3 * f3;
          f7 = f4 * f4;
          f8 = f1 * f1;
          f2 = (float)Math.acos((paramFloat3 + f7 - f8) / (f3 * 2.0F * f4));
          paramFloat3 = (float)Math.acos((f8 + f7 - paramFloat3) / (f1 * 2.0F * f4));
        }
        else
        {
          paramFloat3 = 0.0F;
        }
        float f7 = (float)Math.atan2(localObject2.jdField_a_of_type_ArrayOfFloat[1] - localObject1.jdField_a_of_type_ArrayOfFloat[1], localObject2.jdField_a_of_type_ArrayOfFloat[0] - localObject1.jdField_a_of_type_ArrayOfFloat[0]);
        float f8 = (float)Math.acos(f6 / f4);
        float f9 = (f8 - f2) * paramFloat1;
        f6 = f7 + f2 + f9;
        f2 = f7 - f2 - f9;
        double d1 = f7;
        Double.isNaN(d1);
        double d2 = paramFloat3;
        Double.isNaN(d2);
        Double.isNaN(d2);
        double d3 = f8;
        Double.isNaN(d3);
        double d4 = paramFloat1;
        Double.isNaN(d4);
        d3 = (3.141592653589793D - d2 - d3) * d4;
        paramFloat3 = (float)(d1 + 3.141592653589793D - d2 - d3);
        Double.isNaN(d1);
        Double.isNaN(d2);
        f7 = (float)(d1 - 3.141592653589793D + d2 + d3);
        a(f6, f3, this.jdField_a_of_type_ArrayOfFloat);
        a(f2, f3, this.jdField_b_of_type_ArrayOfFloat);
        a(paramFloat3, f1, this.jdField_c_of_type_ArrayOfFloat);
        a(f7, f1, this.jdField_d_of_type_ArrayOfFloat);
        this.jdField_e_of_type_ArrayOfFloat[0] = (this.jdField_a_of_type_ArrayOfFloat[0] + localObject1.jdField_a_of_type_ArrayOfFloat[0]);
        this.jdField_e_of_type_ArrayOfFloat[1] = (this.jdField_a_of_type_ArrayOfFloat[1] + localObject1.jdField_a_of_type_ArrayOfFloat[1]);
        this.f[0] = (this.jdField_b_of_type_ArrayOfFloat[0] + localObject1.jdField_a_of_type_ArrayOfFloat[0]);
        this.f[1] = (this.jdField_b_of_type_ArrayOfFloat[1] + localObject1.jdField_a_of_type_ArrayOfFloat[1]);
        this.g[0] = (this.jdField_c_of_type_ArrayOfFloat[0] + localObject2.jdField_a_of_type_ArrayOfFloat[0]);
        this.g[1] = (this.jdField_c_of_type_ArrayOfFloat[1] + localObject2.jdField_a_of_type_ArrayOfFloat[1]);
        this.h[0] = (this.jdField_d_of_type_ArrayOfFloat[0] + localObject2.jdField_a_of_type_ArrayOfFloat[0]);
        this.h[1] = (this.jdField_d_of_type_ArrayOfFloat[1] + localObject2.jdField_a_of_type_ArrayOfFloat[1]);
        localObject1 = this.i;
        localObject2 = this.jdField_e_of_type_ArrayOfFloat;
        f8 = localObject2[0];
        float[] arrayOfFloat = this.g;
        localObject1[0] = (f8 - arrayOfFloat[0]);
        localObject2[1] -= arrayOfFloat[1];
        paramFloat1 = Math.min(paramFloat1 * paramFloat2, a((float[])localObject1) / f5) * Math.min(1.0F, 2.0F * f4 / f5);
        paramFloat2 = f3 * paramFloat1;
        paramFloat1 = f1 * paramFloat1;
        a(f6 - 1.570796F, paramFloat2, this.j);
        a(paramFloat3 + 1.570796F, paramFloat1, this.k);
        a(f7 - 1.570796F, paramFloat1, this.l);
        a(f2 + 1.570796F, paramFloat2, this.m);
        this.jdField_a_of_type_AndroidGraphicsPath.reset();
        localObject1 = this.jdField_a_of_type_AndroidGraphicsPath;
        localObject2 = this.jdField_e_of_type_ArrayOfFloat;
        ((Path)localObject1).moveTo(localObject2[0], localObject2[1]);
        localObject1 = this.jdField_a_of_type_AndroidGraphicsPath;
        localObject2 = this.jdField_e_of_type_ArrayOfFloat;
        paramFloat1 = localObject2[0];
        arrayOfFloat = this.j;
        paramFloat2 = arrayOfFloat[0];
        paramFloat3 = localObject2[1];
        f1 = arrayOfFloat[1];
        localObject2 = this.g;
        f2 = localObject2[0];
        arrayOfFloat = this.k;
        ((Path)localObject1).cubicTo(paramFloat2 + paramFloat1, paramFloat3 + f1, arrayOfFloat[0] + f2, localObject2[1] + arrayOfFloat[1], localObject2[0], localObject2[1]);
        localObject1 = this.jdField_a_of_type_AndroidGraphicsPath;
        localObject2 = this.h;
        ((Path)localObject1).lineTo(localObject2[0], localObject2[1]);
        localObject1 = this.jdField_a_of_type_AndroidGraphicsPath;
        localObject2 = this.h;
        paramFloat1 = localObject2[0];
        arrayOfFloat = this.l;
        paramFloat2 = arrayOfFloat[0];
        paramFloat3 = localObject2[1];
        f1 = arrayOfFloat[1];
        localObject2 = this.f;
        f2 = localObject2[0];
        arrayOfFloat = this.m;
        ((Path)localObject1).cubicTo(paramFloat2 + paramFloat1, paramFloat3 + f1, arrayOfFloat[0] + f2, localObject2[1] + arrayOfFloat[1], localObject2[0], localObject2[1]);
        localObject1 = this.jdField_a_of_type_AndroidGraphicsPath;
        localObject2 = this.jdField_e_of_type_ArrayOfFloat;
        ((Path)localObject1).lineTo(localObject2[0], localObject2[1]);
        this.jdField_a_of_type_AndroidGraphicsPath.close();
        paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
  }
  
  private void b()
  {
    clearAnimation();
    postInvalidate();
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetMetaballView$MoveAnimation = new MetaballView.MoveAnimation(this, null);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetMetaballView$MoveAnimation.setDuration(1000L);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetMetaballView$MoveAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetMetaballView$MoveAnimation.setRepeatCount(-1);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetMetaballView$MoveAnimation.setRepeatMode(2);
    startAnimation(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetMetaballView$MoveAnimation);
  }
  
  protected int a()
  {
    return (int)((IUIToolsApi)QRoute.api(IUIToolsApi.class)).dp2px(getContext(), 10.0F);
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {}
  
  protected int b()
  {
    return (int)((IUIToolsApi)QRoute.api(IUIToolsApi.class)).dp2px(getContext(), 20.0F);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (getVisibility() == 0) {
      c();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    if (getVisibility() == 0) {
      b();
    }
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetMetaballView$Circle = ((MetaballView.Circle)this.jdField_a_of_type_JavaUtilArrayList.get(0));
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetMetaballView$Circle.jdField_a_of_type_ArrayOfFloat[0] = (this.jdField_d_of_type_Float * this.jdField_e_of_type_Float + this.jdField_b_of_type_Float);
    float f1 = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetMetaballView$Circle.jdField_a_of_type_ArrayOfFloat[0];
    float[] arrayOfFloat = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetMetaballView$Circle.jdField_a_of_type_ArrayOfFloat;
    int n = 1;
    paramCanvas.drawCircle(f1, arrayOfFloat[1], this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetMetaballView$Circle.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
    int i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
    while (n < i1)
    {
      a(paramCanvas, n, 0, 0.6F, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float * 2.0F);
      n += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(resolveSizeAndState((int)((this.jdField_b_of_type_Float * 2.0F + this.jdField_b_of_type_Int) * 2.0F), paramInt1, 0), resolveSizeAndState((int)(this.jdField_b_of_type_Float * 2.0F * 1.4F), paramInt2, 0));
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if ((paramInt == 0) && (getVisibility() == 0)) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (paramInt == 0)
    {
      b();
      return;
    }
    c();
  }
  
  public void setPaintMode(int paramInt)
  {
    Paint localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
    Paint.Style localStyle;
    if (paramInt == 0) {
      localStyle = Paint.Style.STROKE;
    } else {
      localStyle = Paint.Style.FILL;
    }
    localPaint.setStyle(localStyle);
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.widget.MetaballView
 * JD-Core Version:    0.7.0.1
 */