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
  private SweepGradient p;
  @Nullable
  private Matrix q;
  private boolean r;
  private int s;
  private int t;
  
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
    if (this.r)
    {
      if (this.p == null) {
        this.p = new SweepGradient(this.m.centerX(), this.m.centerY(), this.s, this.t);
      }
      if (this.q == null) {
        this.q = new Matrix();
      }
      Object localObject = this.q;
      if (localObject != null) {
        ((Matrix)localObject).reset();
      }
      float f;
      if (this.l > 0)
      {
        double d1 = this.l;
        Double.isNaN(d1);
        double d2 = 270;
        Double.isNaN(d2);
        f = (float)(d1 * 3.6D + d2);
      }
      else
      {
        f = 270.0F;
      }
      localObject = this.q;
      if (localObject != null) {
        ((Matrix)localObject).setRotate(f, this.m.centerX(), this.m.centerY());
      }
      localObject = this.p;
      if (localObject != null) {
        ((SweepGradient)localObject).setLocalMatrix(this.q);
      }
    }
    else
    {
      this.p = ((SweepGradient)null);
    }
  }
  
  protected void a(@Nullable Canvas paramCanvas)
  {
    Object localObject = this.k;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mPaint");
    ((Paint)localObject).setColor(this.c);
    if (this.n)
    {
      localObject = this.k;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "mPaint");
      ((Paint)localObject).setAlpha(this.f * 255 / 100);
    }
    this.k.setShadowLayer(this.e, 0.0F, 0.0F, this.d);
    if (paramCanvas != null) {
      paramCanvas.drawArc(this.m, -90.0F, 360.0F, false, this.k);
    }
    localObject = this.k;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mPaint");
    ((Paint)localObject).setColor(this.g);
    if (this.o)
    {
      localObject = this.k;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "mPaint");
      ((Paint)localObject).setAlpha(this.h * 255 / 100);
    }
    this.k.setShadowLayer(this.e, 0.0F, 0.0F, this.d);
    a();
    localObject = this.k;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mPaint");
    ((Paint)localObject).setShader((Shader)this.p);
    if (paramCanvas != null)
    {
      localObject = this.m;
      double d = this.l;
      Double.isNaN(d);
      paramCanvas.drawArc((RectF)localObject, -90.0F, (float)(d * 3.6D), false, this.k);
    }
    paramCanvas = this.k;
    Intrinsics.checkExpressionValueIsNotNull(paramCanvas, "mPaint");
    paramCanvas.setShader((Shader)null);
  }
  
  public final int getMEndProgressColor()
  {
    return this.t;
  }
  
  @Nullable
  public final Matrix getMMatrixForSweepGradient()
  {
    return this.q;
  }
  
  public final int getMStartProgressColor()
  {
    return this.s;
  }
  
  @Nullable
  public final SweepGradient getMSweepGradient()
  {
    return this.p;
  }
  
  public final boolean getNeedSweepGradient()
  {
    return this.r;
  }
  
  public final void setMEndProgressColor(int paramInt)
  {
    this.t = paramInt;
  }
  
  public final void setMMatrixForSweepGradient(@Nullable Matrix paramMatrix)
  {
    this.q = paramMatrix;
  }
  
  public final void setMStartProgressColor(int paramInt)
  {
    this.s = paramInt;
  }
  
  public final void setMSweepGradient(@Nullable SweepGradient paramSweepGradient)
  {
    this.p = paramSweepGradient;
  }
  
  public final void setNeedSweepGradient(boolean paramBoolean)
  {
    this.r = paramBoolean;
  }
  
  public final void setNeedSweepGradient(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.r = paramBoolean;
    if (paramBoolean)
    {
      this.s = paramInt1;
      this.t = paramInt2;
    }
    this.p = ((SweepGradient)null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SweepGradientCircleProgress
 * JD-Core Version:    0.7.0.1
 */