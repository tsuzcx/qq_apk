package com.tencent.tkd.topicsdk.ucrop.handler;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import androidx.annotation.IntRange;
import com.tencent.tkd.topicsdk.ucrop.util.RectUtils;
import com.tencent.tkd.topicsdk.ucrop.view.IGestureCropView;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/ucrop/handler/TransformHandler;", "", "gestureCropView", "Lcom/tencent/tkd/topicsdk/ucrop/view/IGestureCropView;", "(Lcom/tencent/tkd/topicsdk/ucrop/view/IGestureCropView;)V", "context", "getContext", "()Lcom/tencent/tkd/topicsdk/ucrop/view/IGestureCropView;", "currentAngle", "", "getCurrentAngle", "()F", "currentScale", "getCurrentScale", "getGestureCropView", "imageInputPath", "", "getImageInputPath", "()Ljava/lang/String;", "imageOutputPath", "getImageOutputPath", "mBitmapDecoded", "", "mBitmapLaidOut", "mCurrentImageCenter", "", "mCurrentImageCorners", "mCurrentImageMatrix", "Landroid/graphics/Matrix;", "mInitialImageCenter", "mInitialImageCorners", "mMatrixValues", "mMaxBitmapSize", "", "mThisHeight", "mThisWidth", "mTransformImageListener", "Lcom/tencent/tkd/topicsdk/ucrop/handler/TransformHandler$TransformImageListener;", "maxBitmapSize", "getMaxBitmapSize", "()I", "setMaxBitmapSize", "(I)V", "viewBitmap", "Landroid/graphics/Bitmap;", "getViewBitmap", "()Landroid/graphics/Bitmap;", "getMatrixAngle", "matrix", "getMatrixScale", "getMatrixValue", "valueIndex", "onImageLaidOut", "", "onLayout", "changed", "left", "top", "right", "bottom", "postRotate", "deltaAngle", "px", "py", "postScale", "deltaScale", "postTranslate", "deltaX", "deltaY", "printMatrix", "logPrefix", "setImageMatrix", "setTransformImageListener", "transformImageListener", "updateCurrentImagePoints", "Companion", "TransformImageListener", "topicsdk-ucrop_release"}, k=1, mv={1, 1, 16})
@SuppressLint({"AppCompatCustomView"})
public class TransformHandler
{
  public static final TransformHandler.Companion i = new TransformHandler.Companion(null);
  @JvmField
  @NotNull
  protected final float[] a;
  @JvmField
  @NotNull
  protected final float[] b;
  @JvmField
  @NotNull
  protected Matrix c;
  @JvmField
  protected int d;
  @JvmField
  protected int e;
  @JvmField
  @Nullable
  protected TransformHandler.TransformImageListener f;
  @JvmField
  protected boolean g;
  @JvmField
  protected boolean h;
  private final float[] j;
  private float[] k;
  private float[] l;
  @NotNull
  private final IGestureCropView m;
  @NotNull
  private final IGestureCropView n;
  
  public TransformHandler(@NotNull IGestureCropView paramIGestureCropView)
  {
    this.n = paramIGestureCropView;
    this.a = new float[8];
    this.b = new float[2];
    this.j = new float[9];
    this.c = new Matrix();
    this.m = this.n;
  }
  
  private final float a(Matrix paramMatrix, @IntRange(from=0L, to=9L) int paramInt)
  {
    paramMatrix.getValues(this.j);
    return this.j[paramInt];
  }
  
  private final void a()
  {
    Matrix localMatrix = this.c;
    float[] arrayOfFloat1 = this.a;
    float[] arrayOfFloat2 = this.k;
    if (arrayOfFloat2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mInitialImageCorners");
    }
    localMatrix.mapPoints(arrayOfFloat1, arrayOfFloat2);
    localMatrix = this.c;
    arrayOfFloat1 = this.b;
    arrayOfFloat2 = this.l;
    if (arrayOfFloat2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mInitialImageCenter");
    }
    localMatrix.mapPoints(arrayOfFloat1, arrayOfFloat2);
  }
  
  private final float b(Matrix paramMatrix)
  {
    return (float)Math.sqrt(Math.pow(a(paramMatrix, 0), 2.0D) + Math.pow(a(paramMatrix, 3), 2.0D));
  }
  
  private final float c(Matrix paramMatrix)
  {
    return (float)-(Math.atan2(a(paramMatrix, 1), a(paramMatrix, 0)) * 57.295779513082323D);
  }
  
  public final void a(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 != 0.0F) || (paramFloat2 != 0.0F))
    {
      this.c.postTranslate(paramFloat1, paramFloat2);
      a(this.c);
    }
  }
  
  public final void a(@NotNull Matrix paramMatrix)
  {
    Intrinsics.checkParameterIsNotNull(paramMatrix, "matrix");
    this.n.a(paramMatrix);
    a();
  }
  
  public final void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = this.n.getView();
    if ((paramBoolean) || ((this.g) && (!this.h)))
    {
      paramInt1 = localView.getPaddingLeft();
      paramInt2 = localView.getPaddingTop();
      paramInt3 = localView.getWidth();
      paramInt4 = localView.getPaddingRight();
      int i1 = localView.getHeight();
      int i2 = localView.getPaddingBottom();
      this.d = (paramInt3 - paramInt4 - paramInt1);
      this.e = (i1 - i2 - paramInt2);
      e();
    }
  }
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 != 0.0F)
    {
      this.c.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
      a(this.c);
      TransformHandler.TransformImageListener localTransformImageListener = this.f;
      if (localTransformImageListener != null) {
        localTransformImageListener.b(b(this.c));
      }
    }
  }
  
  public final void c(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 != 0.0F)
    {
      this.c.postRotate(paramFloat1, paramFloat2, paramFloat3);
      a(this.c);
      TransformHandler.TransformImageListener localTransformImageListener = this.f;
      if (localTransformImageListener != null) {
        localTransformImageListener.a(c(this.c));
      }
    }
  }
  
  protected void e()
  {
    int i1 = this.n.getBitmapWidth();
    int i2 = this.n.getBitmapHeight();
    Object localObject = StringCompanionObject.INSTANCE;
    localObject = new Object[2];
    localObject[0] = Integer.valueOf(i1);
    localObject[1] = Integer.valueOf(i2);
    localObject = String.format("Image size: [%d:%d]", Arrays.copyOf((Object[])localObject, localObject.length));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "java.lang.String.format(format, *args)");
    Log.d("TransformImageView", (String)localObject);
    if (i1 > 0)
    {
      if (i2 <= 0) {
        return;
      }
      this.k = RectUtils.a(this.n.getInitialBitmapRectF());
      this.l = RectUtils.b(this.n.getInitialBitmapRectF());
      this.h = true;
      localObject = this.f;
      if (localObject != null) {
        ((TransformHandler.TransformImageListener)localObject).a();
      }
    }
  }
  
  public final float h()
  {
    return b(this.c);
  }
  
  public final float i()
  {
    return c(this.c);
  }
  
  @Nullable
  public final Bitmap j()
  {
    return this.n.getBitmapForCrop();
  }
  
  @NotNull
  public final IGestureCropView k()
  {
    return this.n;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.ucrop.handler.TransformHandler
 * JD-Core Version:    0.7.0.1
 */