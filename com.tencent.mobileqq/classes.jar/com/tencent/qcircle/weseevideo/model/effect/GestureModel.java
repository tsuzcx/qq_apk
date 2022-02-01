package com.tencent.qcircle.weseevideo.model.effect;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.qcircle.tavcut.view.TAVCutImageViewKt;
import com.tencent.tav.coremedia.CGSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qcircle/weseevideo/model/effect/GestureModel;", "", "()V", "corners", "", "Landroid/graphics/PointF;", "currentCenter", "getCurrentCenter", "()Landroid/graphics/PointF;", "setCurrentCenter", "(Landroid/graphics/PointF;)V", "gMatrix", "Landroid/graphics/Matrix;", "getGMatrix", "()Landroid/graphics/Matrix;", "originCenter", "getOriginCenter", "setOriginCenter", "rotate", "", "getRotate", "()F", "setRotate", "(F)V", "scale", "getScale", "setScale", "screenSize", "Lcom/tencent/tav/coremedia/CGSize;", "getScreenSize", "()Lcom/tencent/tav/coremedia/CGSize;", "setScreenSize", "(Lcom/tencent/tav/coremedia/CGSize;)V", "clearCorners", "", "postRotate", "degree", "focusX", "focusY", "postScale", "postTranslate", "dx", "dy", "rectF", "Landroid/graphics/RectF;", "reset", "resetCurrentCenter", "setCorner", "Companion", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class GestureModel
{
  public static final GestureModel.Companion Companion = new GestureModel.Companion(null);
  private static float MAX_SCALE = 2.0F;
  private static float MIN_SCALE = 0.25F;
  private List<? extends PointF> corners;
  @Nullable
  private PointF currentCenter;
  @NotNull
  private final Matrix gMatrix = new Matrix();
  @Nullable
  private PointF originCenter;
  private float rotate;
  private float scale = 1.0F;
  @Nullable
  private CGSize screenSize;
  
  private final void clearCorners()
  {
    this.corners = ((List)null);
  }
  
  @Nullable
  public final PointF getCurrentCenter()
  {
    return this.currentCenter;
  }
  
  @NotNull
  public final Matrix getGMatrix()
  {
    return this.gMatrix;
  }
  
  @Nullable
  public final PointF getOriginCenter()
  {
    return this.originCenter;
  }
  
  public final float getRotate()
  {
    return this.rotate;
  }
  
  public final float getScale()
  {
    return this.scale;
  }
  
  @Nullable
  public final CGSize getScreenSize()
  {
    return this.screenSize;
  }
  
  public final void postRotate(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.rotate += paramFloat1;
    this.gMatrix.postRotate(paramFloat1, paramFloat2, paramFloat3);
    resetCurrentCenter();
  }
  
  public final void postScale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f2 = this.scale;
    float f3 = MAX_SCALE;
    float f1 = paramFloat1;
    if (paramFloat1 * f2 > f3) {
      f1 = f3 / f2;
    }
    f2 = this.scale;
    f3 = MIN_SCALE;
    paramFloat1 = f1;
    if (f1 * f2 < f3) {
      paramFloat1 = f3 / f2;
    }
    this.scale *= paramFloat1;
    this.gMatrix.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
    resetCurrentCenter();
  }
  
  public final void postTranslate(float paramFloat1, float paramFloat2, @NotNull RectF paramRectF)
  {
    Intrinsics.checkParameterIsNotNull(paramRectF, "rectF");
    PointF localPointF = this.currentCenter;
    float f2 = paramFloat1;
    float f1 = paramFloat2;
    if (localPointF != null)
    {
      if (localPointF.x + paramFloat1 < paramRectF.left) {
        f1 = paramRectF.left - localPointF.x;
      } else {
        f1 = paramFloat1;
      }
      if (localPointF.x + paramFloat1 > paramRectF.right) {
        paramFloat1 = paramRectF.right - localPointF.x;
      } else {
        paramFloat1 = f1;
      }
      if (localPointF.y + paramFloat2 < paramRectF.top) {
        f1 = paramRectF.top - localPointF.y;
      } else {
        f1 = paramFloat2;
      }
      if (localPointF.y + paramFloat2 > paramRectF.bottom)
      {
        f1 = paramRectF.bottom - localPointF.y;
        f2 = paramFloat1;
      }
      else
      {
        f2 = paramFloat1;
      }
    }
    paramRectF = new StringBuilder();
    paramRectF.append("x = ");
    paramRectF.append(f2);
    Logger.e("GestureModel", paramRectF.toString());
    paramRectF = new StringBuilder();
    paramRectF.append("y = ");
    paramRectF.append(f1);
    Logger.e("GestureModel", paramRectF.toString());
    this.gMatrix.postTranslate(f2, f1);
    resetCurrentCenter();
  }
  
  public final void reset()
  {
    this.gMatrix.reset();
    this.rotate = 0.0F;
    this.scale = 1.0F;
    PointF localPointF = (PointF)null;
    this.originCenter = localPointF;
    this.currentCenter = localPointF;
    clearCorners();
  }
  
  public final void resetCurrentCenter()
  {
    Object localObject = this.originCenter;
    if (localObject != null)
    {
      float[] arrayOfFloat = new float[2];
      int i = 0;
      while (i < 2)
      {
        float f;
        if (i == 0) {
          f = ((PointF)localObject).x;
        } else {
          f = ((PointF)localObject).y;
        }
        arrayOfFloat[i] = f;
        i += 1;
      }
      this.gMatrix.mapPoints(arrayOfFloat);
      if (this.currentCenter == null)
      {
        localObject = (GestureModel)this;
        this.currentCenter = new PointF();
        localObject = Unit.INSTANCE;
      }
      localObject = this.currentCenter;
      if (localObject != null)
      {
        ((PointF)localObject).x = arrayOfFloat[0];
        ((PointF)localObject).y = arrayOfFloat[1];
      }
    }
  }
  
  public final void setCorner(@Nullable List<? extends PointF> paramList)
  {
    if ((paramList != null) && (this.corners == null) && (paramList.size() >= 4))
    {
      this.corners = paramList;
      float f1 = 0.0F;
      int j = -1;
      int i = 1;
      while (i <= 3)
      {
        f3 = TAVCutImageViewKt.calcDistance((PointF)paramList.get(0), (PointF)paramList.get(i));
        f2 = f1;
        if (f3 > f1)
        {
          j = i;
          f2 = f3;
        }
        i += 1;
        f1 = f2;
      }
      f1 = ((PointF)paramList.get(0)).x;
      float f2 = ((PointF)paramList.get(j)).x;
      float f3 = 2;
      this.originCenter = new PointF((f1 + f2) / f3, (((PointF)paramList.get(0)).y + ((PointF)paramList.get(j)).y) / f3);
    }
  }
  
  public final void setCurrentCenter(@Nullable PointF paramPointF)
  {
    this.currentCenter = paramPointF;
  }
  
  public final void setOriginCenter(@Nullable PointF paramPointF)
  {
    this.originCenter = paramPointF;
  }
  
  public final void setRotate(float paramFloat)
  {
    this.rotate = paramFloat;
  }
  
  public final void setScale(float paramFloat)
  {
    this.scale = paramFloat;
  }
  
  public final void setScreenSize(@Nullable CGSize paramCGSize)
  {
    this.screenSize = paramCGSize;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.model.effect.GestureModel
 * JD-Core Version:    0.7.0.1
 */