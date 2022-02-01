package com.tencent.tkd.topicsdk.ucrop.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import androidx.annotation.IntRange;
import com.tencent.tkd.topicsdk.ucrop.util.FastBitmapDrawable;
import com.tencent.tkd.topicsdk.ucrop.util.RectUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/ucrop/view/TransformImageView;", "Landroid/widget/ImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "currentAngle", "", "getCurrentAngle", "()F", "currentScale", "getCurrentScale", "exifInfo", "Lcom/tencent/tkd/topicsdk/ucrop/model/ExifInfo;", "getExifInfo", "()Lcom/tencent/tkd/topicsdk/ucrop/model/ExifInfo;", "imageInputPath", "", "getImageInputPath", "()Ljava/lang/String;", "imageOutputPath", "getImageOutputPath", "mBitmapDecoded", "", "mBitmapLaidOut", "mCurrentImageCenter", "", "mCurrentImageCorners", "mCurrentImageMatrix", "Landroid/graphics/Matrix;", "mInitialImageCenter", "mInitialImageCorners", "mMatrixValues", "mMaxBitmapSize", "mThisHeight", "mThisWidth", "mTransformImageListener", "Lcom/tencent/tkd/topicsdk/ucrop/view/TransformImageView$TransformImageListener;", "maxBitmapSize", "getMaxBitmapSize", "()I", "setMaxBitmapSize", "(I)V", "viewBitmap", "Landroid/graphics/Bitmap;", "getViewBitmap", "()Landroid/graphics/Bitmap;", "getMatrixAngle", "matrix", "getMatrixScale", "getMatrixValue", "valueIndex", "init", "", "onImageLaidOut", "onLayout", "changed", "left", "top", "right", "bottom", "postRotate", "deltaAngle", "px", "py", "postScale", "deltaScale", "postTranslate", "deltaX", "deltaY", "printMatrix", "logPrefix", "setImageBitmap", "bitmap", "setImageMatrix", "setScaleType", "scaleType", "Landroid/widget/ImageView$ScaleType;", "setTransformImageListener", "transformImageListener", "updateCurrentImagePoints", "Companion", "TransformImageListener", "topicsdk-ucrop_release"}, k=1, mv={1, 1, 16})
@SuppressLint({"AppCompatCustomView"})
public class TransformImageView
  extends ImageView
{
  public static final TransformImageView.Companion a;
  @JvmField
  protected int a;
  @JvmField
  @NotNull
  protected Matrix a;
  @JvmField
  @Nullable
  protected TransformImageView.TransformImageListener a;
  @JvmField
  protected boolean a;
  @JvmField
  @NotNull
  protected final float[] a;
  @JvmField
  protected int b;
  @JvmField
  protected boolean b;
  @JvmField
  @NotNull
  protected final float[] b;
  private int jdField_c_of_type_Int;
  private final float[] jdField_c_of_type_ArrayOfFloat = new float[9];
  private float[] d;
  private float[] e;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkUcropViewTransformImageView$Companion = new TransformImageView.Companion(null);
  }
  
  @JvmOverloads
  public TransformImageView(@Nullable Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public TransformImageView(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public TransformImageView(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_ArrayOfFloat = new float[8];
    this.jdField_b_of_type_ArrayOfFloat = new float[2];
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
    c();
  }
  
  private final float a(Matrix paramMatrix)
  {
    return (float)Math.sqrt(Math.pow(a(paramMatrix, 0), 2.0D) + Math.pow(a(paramMatrix, 3), 2.0D));
  }
  
  private final float a(Matrix paramMatrix, @IntRange(from=0L, to=9L) int paramInt)
  {
    paramMatrix.getValues(this.jdField_c_of_type_ArrayOfFloat);
    return this.jdField_c_of_type_ArrayOfFloat[paramInt];
  }
  
  private final void a()
  {
    Matrix localMatrix = this.jdField_a_of_type_AndroidGraphicsMatrix;
    float[] arrayOfFloat1 = this.jdField_a_of_type_ArrayOfFloat;
    float[] arrayOfFloat2 = this.d;
    if (arrayOfFloat2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mInitialImageCorners");
    }
    localMatrix.mapPoints(arrayOfFloat1, arrayOfFloat2);
    localMatrix = this.jdField_a_of_type_AndroidGraphicsMatrix;
    arrayOfFloat1 = this.jdField_b_of_type_ArrayOfFloat;
    arrayOfFloat2 = this.e;
    if (arrayOfFloat2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mInitialImageCenter");
    }
    localMatrix.mapPoints(arrayOfFloat1, arrayOfFloat2);
  }
  
  private final float b(Matrix paramMatrix)
  {
    return (float)-(Math.atan2(a(paramMatrix, 1), a(paramMatrix, 0)) * 57.295779513082323D);
  }
  
  @Nullable
  public final Bitmap a()
  {
    if (!(getDrawable() instanceof FastBitmapDrawable)) {
      return null;
    }
    Drawable localDrawable = getDrawable();
    if (localDrawable != null) {
      return ((FastBitmapDrawable)localDrawable).a();
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.tkd.topicsdk.ucrop.util.FastBitmapDrawable");
  }
  
  public final void a(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 != 0.0F) || (paramFloat2 != 0.0F))
    {
      this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(paramFloat1, paramFloat2);
      setImageMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
    }
  }
  
  protected void b()
  {
    Object localObject = getDrawable();
    if (localObject != null)
    {
      float f1 = ((Drawable)localObject).getIntrinsicWidth();
      float f2 = ((Drawable)localObject).getIntrinsicHeight();
      localObject = StringCompanionObject.INSTANCE;
      localObject = new Object[2];
      localObject[0] = Integer.valueOf((int)f1);
      localObject[1] = Integer.valueOf((int)f2);
      localObject = String.format("Image size: [%d:%d]", Arrays.copyOf((Object[])localObject, localObject.length));
      Intrinsics.checkExpressionValueIsNotNull(localObject, "java.lang.String.format(format, *args)");
      Log.d("TransformImageView", (String)localObject);
      localObject = new RectF(0.0F, 0.0F, f1, f2);
      this.d = RectUtils.a((RectF)localObject);
      this.e = RectUtils.b((RectF)localObject);
      this.jdField_b_of_type_Boolean = true;
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkUcropViewTransformImageView$TransformImageListener;
      if (localObject != null) {
        ((TransformImageView.TransformImageListener)localObject).a();
      }
    }
  }
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 != 0.0F)
    {
      this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
      setImageMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
      TransformImageView.TransformImageListener localTransformImageListener = this.jdField_a_of_type_ComTencentTkdTopicsdkUcropViewTransformImageView$TransformImageListener;
      if (localTransformImageListener != null) {
        localTransformImageListener.b(a(this.jdField_a_of_type_AndroidGraphicsMatrix));
      }
    }
  }
  
  protected void c()
  {
    setScaleType(ImageView.ScaleType.MATRIX);
  }
  
  public final void c(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 != 0.0F)
    {
      this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(paramFloat1, paramFloat2, paramFloat3);
      setImageMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
      TransformImageView.TransformImageListener localTransformImageListener = this.jdField_a_of_type_ComTencentTkdTopicsdkUcropViewTransformImageView$TransformImageListener;
      if (localTransformImageListener != null) {
        localTransformImageListener.a(b(this.jdField_a_of_type_AndroidGraphicsMatrix));
      }
    }
  }
  
  public final float d()
  {
    return a(this.jdField_a_of_type_AndroidGraphicsMatrix);
  }
  
  public final float e()
  {
    return b(this.jdField_a_of_type_AndroidGraphicsMatrix);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) || ((this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean)))
    {
      paramInt1 = getPaddingLeft();
      paramInt2 = getPaddingTop();
      paramInt3 = getWidth();
      paramInt4 = getPaddingRight();
      int i = getHeight();
      int j = getPaddingBottom();
      this.jdField_a_of_type_Int = (paramInt3 - paramInt4 - paramInt1);
      this.jdField_b_of_type_Int = (i - j - paramInt2);
      b();
    }
  }
  
  public void setImageBitmap(@NotNull Bitmap paramBitmap)
  {
    Intrinsics.checkParameterIsNotNull(paramBitmap, "bitmap");
    FastBitmapDrawable localFastBitmapDrawable = new FastBitmapDrawable();
    localFastBitmapDrawable.a(paramBitmap);
    setImageDrawable((Drawable)localFastBitmapDrawable);
  }
  
  public void setImageMatrix(@NotNull Matrix paramMatrix)
  {
    Intrinsics.checkParameterIsNotNull(paramMatrix, "matrix");
    super.setImageMatrix(paramMatrix);
    this.jdField_a_of_type_AndroidGraphicsMatrix.set(paramMatrix);
    a();
  }
  
  public final void setMaxBitmapSize(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void setScaleType(@NotNull ImageView.ScaleType paramScaleType)
  {
    Intrinsics.checkParameterIsNotNull(paramScaleType, "scaleType");
    if (paramScaleType == ImageView.ScaleType.MATRIX)
    {
      super.setScaleType(paramScaleType);
      return;
    }
    Log.w("TransformImageView", "Invalid ScaleType. Only ScaleType.MATRIX can be used");
  }
  
  public final void setTransformImageListener(@Nullable TransformImageView.TransformImageListener paramTransformImageListener)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkUcropViewTransformImageView$TransformImageListener = paramTransformImageListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.ucrop.view.TransformImageView
 * JD-Core Version:    0.7.0.1
 */