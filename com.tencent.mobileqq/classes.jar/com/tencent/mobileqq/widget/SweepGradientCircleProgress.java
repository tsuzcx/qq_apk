package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/widget/SweepGradientCircleProgress;", "Lcom/tencent/mobileqq/widget/CircleProgress;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mEndProgressColor", "", "getMEndProgressColor", "()I", "setMEndProgressColor", "(I)V", "mMatrixForSweepGradient", "Landroid/graphics/Matrix;", "getMMatrixForSweepGradient", "()Landroid/graphics/Matrix;", "setMMatrixForSweepGradient", "(Landroid/graphics/Matrix;)V", "mStartProgressColor", "getMStartProgressColor", "setMStartProgressColor", "mSweepGradient", "Landroid/graphics/SweepGradient;", "getMSweepGradient", "()Landroid/graphics/SweepGradient;", "setMSweepGradient", "(Landroid/graphics/SweepGradient;)V", "needSweepGradient", "", "getNeedSweepGradient", "()Z", "setNeedSweepGradient", "(Z)V", "doDraw", "", "canvas", "Landroid/graphics/Canvas;", "startColor", "endColor", "setUpSweepGradient", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class SweepGradientCircleProgress
  extends CircleProgress
{
  @Nullable
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix;
  @Nullable
  private SweepGradient jdField_a_of_type_AndroidGraphicsSweepGradient;
  private boolean c;
  private int j;
  private int k;
  
  public SweepGradientCircleProgress(@Nullable Context paramContext)
  {
    super(paramContext);
  }
  
  public SweepGradientCircleProgress(@Nullable Context paramContext, @NotNull AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private final void a()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      if (this.jdField_a_of_type_AndroidGraphicsSweepGradient == null) {
        this.jdField_a_of_type_AndroidGraphicsSweepGradient = new SweepGradient(this.jdField_a_of_type_AndroidGraphicsRectF.centerX(), this.jdField_a_of_type_AndroidGraphicsRectF.centerY(), this.j, this.k);
      }
      if (this.jdField_a_of_type_AndroidGraphicsMatrix == null) {
        this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
      }
      Object localObject = this.jdField_a_of_type_AndroidGraphicsMatrix;
      if (localObject != null) {
        ((Matrix)localObject).reset();
      }
      if (this.jdField_b_of_type_Float > 0) {}
      for (float f = (float)(3.6D * this.jdField_b_of_type_Float + 270);; f = 270.0F)
      {
        localObject = this.jdField_a_of_type_AndroidGraphicsMatrix;
        if (localObject != null) {
          ((Matrix)localObject).setRotate(f, this.jdField_a_of_type_AndroidGraphicsRectF.centerX(), this.jdField_a_of_type_AndroidGraphicsRectF.centerY());
        }
        localObject = this.jdField_a_of_type_AndroidGraphicsSweepGradient;
        if (localObject != null) {
          ((SweepGradient)localObject).setLocalMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
        }
        return;
      }
    }
    this.jdField_a_of_type_AndroidGraphicsSweepGradient = ((SweepGradient)null);
  }
  
  protected void a(@Nullable Canvas paramCanvas)
  {
    Paint localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
    Intrinsics.checkExpressionValueIsNotNull(localPaint, "mPaint");
    localPaint.setColor(this.jdField_b_of_type_Int);
    if (this.jdField_a_of_type_Boolean)
    {
      localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
      Intrinsics.checkExpressionValueIsNotNull(localPaint, "mPaint");
      localPaint.setAlpha(this.e * 255 / 100);
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setShadowLayer(this.d, 0.0F, 0.0F, this.jdField_c_of_type_Int);
    if (paramCanvas != null) {
      paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, -90.0F, 360.0F, false, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
    Intrinsics.checkExpressionValueIsNotNull(localPaint, "mPaint");
    localPaint.setColor(this.f);
    if (this.jdField_b_of_type_Boolean)
    {
      localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
      Intrinsics.checkExpressionValueIsNotNull(localPaint, "mPaint");
      localPaint.setAlpha(this.g * 255 / 100);
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setShadowLayer(this.d, 0.0F, 0.0F, this.jdField_c_of_type_Int);
    a();
    localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
    Intrinsics.checkExpressionValueIsNotNull(localPaint, "mPaint");
    localPaint.setShader((Shader)this.jdField_a_of_type_AndroidGraphicsSweepGradient);
    if (paramCanvas != null) {
      paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, -90.0F, (float)(3.6D * this.jdField_b_of_type_Float), false, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    paramCanvas = this.jdField_a_of_type_AndroidGraphicsPaint;
    Intrinsics.checkExpressionValueIsNotNull(paramCanvas, "mPaint");
    paramCanvas.setShader((Shader)null);
  }
  
  public final void setMEndProgressColor(int paramInt)
  {
    this.k = paramInt;
  }
  
  public final void setMMatrixForSweepGradient(@Nullable Matrix paramMatrix)
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix = paramMatrix;
  }
  
  public final void setMStartProgressColor(int paramInt)
  {
    this.j = paramInt;
  }
  
  public final void setMSweepGradient(@Nullable SweepGradient paramSweepGradient)
  {
    this.jdField_a_of_type_AndroidGraphicsSweepGradient = paramSweepGradient;
  }
  
  public final void setNeedSweepGradient(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public final void setNeedSweepGradient(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      this.j = paramInt1;
      this.k = paramInt2;
    }
    this.jdField_a_of_type_AndroidGraphicsSweepGradient = ((SweepGradient)null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SweepGradientCircleProgress
 * JD-Core Version:    0.7.0.1
 */