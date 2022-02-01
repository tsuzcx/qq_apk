package com.tencent.tkd.topicsdk.ucrop.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.tkd.topicsdk.ucrop.handler.GestureCropHandler;
import com.tencent.tkd.topicsdk.ucrop.util.FastBitmapDrawable;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/ucrop/view/GestureCropImageView;", "Landroid/widget/ImageView;", "Lcom/tencent/tkd/topicsdk/ucrop/view/IGestureCropView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gestureCropHandler", "Lcom/tencent/tkd/topicsdk/ucrop/handler/GestureCropHandler;", "getGestureCropHandler", "()Lcom/tencent/tkd/topicsdk/ucrop/handler/GestureCropHandler;", "getBitmapForCrop", "Landroid/graphics/Bitmap;", "getBitmapHeight", "getBitmapWidth", "getInitialBitmapRectF", "Landroid/graphics/RectF;", "getView", "onLayout", "", "changed", "", "left", "top", "right", "bottom", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setImageBitmap", "bitmap", "setScaleType", "scaleType", "Landroid/widget/ImageView$ScaleType;", "updateMatrix", "matrix", "Landroid/graphics/Matrix;", "Companion", "topicsdk-ucrop_release"}, k=1, mv={1, 1, 16})
public final class GestureCropImageView
  extends ImageView
  implements IGestureCropView
{
  public static final GestureCropImageView.Companion a = new GestureCropImageView.Companion(null);
  @NotNull
  private final GestureCropHandler b = new GestureCropHandler((IGestureCropView)this);
  
  public GestureCropImageView(@NotNull Context paramContext)
  {
    super(paramContext);
    setScaleType(ImageView.ScaleType.MATRIX);
  }
  
  public GestureCropImageView(@NotNull Context paramContext, @NotNull AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setScaleType(ImageView.ScaleType.MATRIX);
  }
  
  public GestureCropImageView(@NotNull Context paramContext, @NotNull AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setScaleType(ImageView.ScaleType.MATRIX);
  }
  
  public void a(@NotNull Matrix paramMatrix)
  {
    Intrinsics.checkParameterIsNotNull(paramMatrix, "matrix");
    setImageMatrix(paramMatrix);
  }
  
  @Nullable
  public Bitmap getBitmapForCrop()
  {
    if ((getDrawable() instanceof FastBitmapDrawable))
    {
      Drawable localDrawable = getDrawable();
      if (localDrawable != null) {
        return ((FastBitmapDrawable)localDrawable).a();
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.tkd.topicsdk.ucrop.util.FastBitmapDrawable");
    }
    return null;
  }
  
  public int getBitmapHeight()
  {
    Drawable localDrawable = getDrawable();
    if (localDrawable != null) {
      return localDrawable.getIntrinsicHeight();
    }
    return 0;
  }
  
  public int getBitmapWidth()
  {
    Drawable localDrawable = getDrawable();
    if (localDrawable != null) {
      return localDrawable.getIntrinsicWidth();
    }
    return 0;
  }
  
  @NotNull
  public GestureCropHandler getGestureCropHandler()
  {
    return this.b;
  }
  
  @NotNull
  public Matrix getInitMatrix()
  {
    return IGestureCropView.DefaultImpls.a(this);
  }
  
  @NotNull
  public RectF getInitialBitmapRectF()
  {
    return new RectF(0.0F, 0.0F, getBitmapWidth(), getBitmapHeight());
  }
  
  @NotNull
  public GestureCropImageView getView()
  {
    return this;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    getGestureCropHandler().a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onTouchEvent(@Nullable MotionEvent paramMotionEvent)
  {
    getGestureCropHandler().a(paramMotionEvent);
    return true;
  }
  
  public void setImageBitmap(@NotNull Bitmap paramBitmap)
  {
    Intrinsics.checkParameterIsNotNull(paramBitmap, "bitmap");
    getGestureCropHandler().a(paramBitmap);
    FastBitmapDrawable localFastBitmapDrawable = new FastBitmapDrawable();
    localFastBitmapDrawable.a(paramBitmap);
    setImageDrawable((Drawable)localFastBitmapDrawable);
  }
  
  public void setScaleType(@NotNull ImageView.ScaleType paramScaleType)
  {
    Intrinsics.checkParameterIsNotNull(paramScaleType, "scaleType");
    if (paramScaleType == ImageView.ScaleType.MATRIX)
    {
      super.setScaleType(paramScaleType);
      return;
    }
    Log.i("GestureCropImageView", "Invalid ScaleType. Only ScaleType.MATRIX can be used");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.ucrop.view.GestureCropImageView
 * JD-Core Version:    0.7.0.1
 */