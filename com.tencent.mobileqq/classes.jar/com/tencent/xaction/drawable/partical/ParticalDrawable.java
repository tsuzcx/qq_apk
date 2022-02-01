package com.tencent.xaction.drawable.partical;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import com.tencent.xaction.api.IDrawable;
import com.tencent.xaction.api.util.ScreenUnit;
import com.tencent.xaction.api.util.ScreenUnit.Companion;
import com.tencent.xaction.openapi.api.IPublicDecorDrawable;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/drawable/partical/ParticalDrawable;", "Landroid/graphics/drawable/Drawable;", "Lcom/tencent/xaction/api/IDrawable;", "()V", "cursor", "", "decor", "Lcom/tencent/xaction/openapi/api/IPublicDecorDrawable;", "paint", "Landroid/graphics/Paint;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "drawPartical", "getDecor", "getOpacity", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "setDecor", "decorDrawable", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class ParticalDrawable
  extends Drawable
  implements IDrawable
{
  private int jdField_a_of_type_Int;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private IPublicDecorDrawable jdField_a_of_type_ComTencentXactionOpenapiApiIPublicDecorDrawable;
  
  private final void a(Canvas paramCanvas)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentXactionOpenapiApiIPublicDecorDrawable;
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    if (localObject1 != null)
    {
      ParticalDecorDrawable localParticalDecorDrawable = (ParticalDecorDrawable)localObject1;
      localObject1 = (ParticalDecorDrawable.ParticalDecorDrawableState)null;
      if (!(localParticalDecorDrawable.getDecorState() instanceof ParticalDecorDrawable.ParticalDecorDrawableState)) {
        return;
      }
      localObject1 = localParticalDecorDrawable.getDecorState();
      if (localObject1 != null)
      {
        localObject1 = (ParticalDecorDrawable.ParticalDecorDrawableState)localObject1;
        this.jdField_a_of_type_Int += 1;
        this.jdField_a_of_type_Int %= ((ParticalDecorDrawable.ParticalDecorDrawableState)localObject1).getRoundPI();
        if (localParticalDecorDrawable.a() != null)
        {
          Particle[] arrayOfParticle = localParticalDecorDrawable.a();
          if (arrayOfParticle == null) {
            Intrinsics.throwNpe();
          }
          int i = arrayOfParticle.length;
          int j = 0;
          while (j < i)
          {
            Particle localParticle = arrayOfParticle[j];
            float f1 = (this.jdField_a_of_type_Int + localParticle.getCursor()) % ((ParticalDecorDrawable.ParticalDecorDrawableState)localObject1).getRoundPI();
            float f3 = ((ParticalDecorDrawable.ParticalDecorDrawableState)localObject1).getSpeed();
            float f4 = 10;
            double d1 = ((ParticalDecorDrawable.ParticalDecorDrawableState)localObject1).getRadius();
            Double.isNaN(d1);
            double d2 = d1 * 3.141592653589793D;
            float f2 = ((ParticalDecorDrawable.ParticalDecorDrawableState)localObject1).getDistance() * localParticalDecorDrawable.a();
            d1 = f3 * f1 + f4;
            Double.isNaN(d1);
            double d3 = d1 / d2;
            f3 = (float)Math.cos(d3) * f2 + localParticle.getX() * 1.3F;
            f4 = (float)Math.sin(d3);
            float f5 = localParticle.getY() / 2;
            f2 = ScreenUnit.a.a(localParticle.getY() + (int)(f4 * f2 + f5));
            this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(255 - (int)(f1 * 1.0F / ((ParticalDecorDrawable.ParticalDecorDrawableState)localObject1).getRoundPI() * 'ÿ'));
            if ((localParticalDecorDrawable.getDecorState() instanceof ParticalDecorDrawable.ParticalDecorDrawableState))
            {
              Object localObject2 = localParticalDecorDrawable.getDecorState();
              if (localObject2 != null)
              {
                localObject2 = ((ParticalDecorDrawable.ParticalDecorDrawableState)localObject2).getTexture();
                if (localObject2 != null)
                {
                  localParticle.getMatrix().reset();
                  localParticle.getMatrix().setTranslate(f3, f2);
                  d3 = 2;
                  Double.isNaN(d3);
                  d2 /= d3;
                  Double.isNaN(d1);
                  f1 = (float)Math.sin(d1 / d2) * localParticle.getScale();
                  localParticle.getMatrix().postScale(Math.abs(f1), Math.abs(f1), f3, f2);
                  paramCanvas.drawBitmap((Bitmap)localObject2, localParticle.getMatrix(), this.jdField_a_of_type_AndroidGraphicsPaint);
                }
              }
              else
              {
                throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.drawable.partical.ParticalDecorDrawable.ParticalDecorDrawableState");
              }
            }
            j += 1;
          }
        }
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.drawable.partical.ParticalDecorDrawable.ParticalDecorDrawableState");
    }
    paramCanvas = new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.drawable.partical.ParticalDecorDrawable");
    for (;;)
    {
      throw paramCanvas;
    }
  }
  
  public void draw(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(40.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(2.0F);
    if ((this.jdField_a_of_type_ComTencentXactionOpenapiApiIPublicDecorDrawable instanceof ParticalDecorDrawable)) {
      a(paramCanvas);
    }
  }
  
  @Nullable
  public IPublicDecorDrawable getDecor()
  {
    return this.jdField_a_of_type_ComTencentXactionOpenapiApiIPublicDecorDrawable;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter) {}
  
  public void setDecor(@NotNull IPublicDecorDrawable paramIPublicDecorDrawable)
  {
    Intrinsics.checkParameterIsNotNull(paramIPublicDecorDrawable, "decorDrawable");
    this.jdField_a_of_type_ComTencentXactionOpenapiApiIPublicDecorDrawable = paramIPublicDecorDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.drawable.partical.ParticalDrawable
 * JD-Core Version:    0.7.0.1
 */