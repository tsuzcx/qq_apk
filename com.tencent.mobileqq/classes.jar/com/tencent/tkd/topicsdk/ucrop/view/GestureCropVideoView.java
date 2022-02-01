package com.tencent.tkd.topicsdk.ucrop.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.tkd.topicsdk.ucrop.handler.GestureCropHandler;
import com.tencent.tkd.topicsdk.ucrop.util.MatrixExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/ucrop/view/GestureCropVideoView;", "Lcom/tencent/tkd/topicsdk/ucrop/view/StaticTextureVideoView;", "Lcom/tencent/tkd/topicsdk/ucrop/view/IGestureCropView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gestureCropHandler", "Lcom/tencent/tkd/topicsdk/ucrop/handler/GestureCropHandler;", "getGestureCropHandler", "()Lcom/tencent/tkd/topicsdk/ucrop/handler/GestureCropHandler;", "initMatrix", "Landroid/graphics/Matrix;", "getInitMatrix", "()Landroid/graphics/Matrix;", "initScaleX", "", "initScaleY", "videoHeight", "getVideoHeight", "()I", "setVideoHeight", "(I)V", "videoWidth", "getVideoWidth", "setVideoWidth", "getBitmapForCrop", "Landroid/graphics/Bitmap;", "getBitmapHeight", "getBitmapWidth", "getInitialBitmapRectF", "Landroid/graphics/RectF;", "getView", "Landroid/view/View;", "onLayout", "", "changed", "", "left", "top", "right", "bottom", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "updateMatrix", "matrix", "topicsdk-ucrop_release"}, k=1, mv={1, 1, 16})
public final class GestureCropVideoView
  extends StaticTextureVideoView
  implements IGestureCropView
{
  private int a;
  private int b;
  private float c = 1.0F;
  private float d = 1.0F;
  @NotNull
  private final GestureCropHandler e = new GestureCropHandler((IGestureCropView)this);
  
  public GestureCropVideoView(@NotNull Context paramContext)
  {
    super(paramContext);
  }
  
  public GestureCropVideoView(@NotNull Context paramContext, @NotNull AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public GestureCropVideoView(@NotNull Context paramContext, @NotNull AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(@NotNull Matrix paramMatrix)
  {
    Intrinsics.checkParameterIsNotNull(paramMatrix, "matrix");
    Matrix localMatrix = new Matrix(getMatrix());
    localMatrix.set(paramMatrix);
    setTransform(localMatrix);
    invalidate();
  }
  
  @Nullable
  public Bitmap getBitmapForCrop()
  {
    float f = MatrixExtKt.a(getInitMatrix());
    return getBitmap(Bitmap.createBitmap((int)(getBitmapWidth() / f), (int)(getBitmapHeight() / f), Bitmap.Config.RGB_565));
  }
  
  public int getBitmapHeight()
  {
    return (int)(getHeight() * this.d);
  }
  
  public int getBitmapWidth()
  {
    return (int)(getWidth() * this.c);
  }
  
  @NotNull
  public GestureCropHandler getGestureCropHandler()
  {
    return this.e;
  }
  
  @NotNull
  public Matrix getInitMatrix()
  {
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(this.c, this.d);
    return localMatrix;
  }
  
  @NotNull
  public RectF getInitialBitmapRectF()
  {
    return new RectF(0.0F, 0.0F, getWidth(), getHeight());
  }
  
  public final int getVideoHeight()
  {
    return this.b;
  }
  
  public final int getVideoWidth()
  {
    return this.a;
  }
  
  @NotNull
  public View getView()
  {
    return (View)this;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    int i = this.a;
    if ((i > 0) && (i > 0))
    {
      float f1 = getWidth() / getHeight();
      i = this.a;
      if (f1 > i / this.b)
      {
        this.c = (i / getWidth() * getWidth() / this.a);
        this.d = (this.b / getHeight() * getWidth() / this.a);
      }
      else
      {
        f1 = i / getWidth();
        float f2 = getHeight();
        i = this.b;
        this.c = (f1 * f2 / i);
        this.d = (i / getHeight() * getHeight() / this.b);
      }
    }
    getGestureCropHandler().a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onTouchEvent(@Nullable MotionEvent paramMotionEvent)
  {
    getGestureCropHandler().a(paramMotionEvent);
    return true;
  }
  
  public final void setVideoHeight(int paramInt)
  {
    this.b = paramInt;
  }
  
  public final void setVideoWidth(int paramInt)
  {
    this.a = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.ucrop.view.GestureCropVideoView
 * JD-Core Version:    0.7.0.1
 */