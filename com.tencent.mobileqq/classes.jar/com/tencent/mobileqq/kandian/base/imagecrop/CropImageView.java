package com.tencent.mobileqq.kandian.base.imagecrop;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.imagecrop.callback.CropBoundsChangeListener;
import com.tencent.mobileqq.kandian.base.imagecrop.callback.CropCallback;
import com.tencent.mobileqq.kandian.base.imagecrop.model.ImageState;
import com.tencent.mobileqq.kandian.base.imagecrop.util.RectUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import mqq.os.MqqHandler;

public class CropImageView
  extends TransformImageView
{
  private final RectF k = new RectF();
  private final Matrix l = new Matrix();
  private float m;
  private float n = 10.0F;
  private CropBoundsChangeListener o;
  private Runnable p;
  private Runnable q = null;
  private float r;
  private float s;
  private int t = 0;
  private int u = 0;
  private long v = 500L;
  
  public CropImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CropImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CropImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(String paramString, boolean paramBoolean, @Nullable CropCallback paramCropCallback)
  {
    if (paramCropCallback == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new CropImageView.2(this, paramBoolean, paramCropCallback, paramString));
  }
  
  private void b(float paramFloat1, float paramFloat2)
  {
    this.s = Math.min(Math.min(this.k.width() / paramFloat1, this.k.width() / paramFloat2), Math.min(this.k.height() / paramFloat2, this.k.height() / paramFloat1));
    paramFloat1 = this.n;
    if (paramFloat1 != -1.0F) {
      this.r = (this.s * paramFloat1);
    }
  }
  
  private void c(float paramFloat1, float paramFloat2)
  {
    float f3 = this.k.width();
    float f2 = this.k.height();
    float f1 = Math.max(this.k.width() / paramFloat1, this.k.height() / paramFloat2);
    paramFloat1 = (f3 - paramFloat1 * f1) / 2.0F;
    f3 = this.k.left;
    paramFloat2 = (f2 - paramFloat2 * f1) / 2.0F;
    f2 = this.k.top;
    this.c.reset();
    this.c.postScale(f1, f1);
    this.c.postTranslate(paramFloat1 + f3, paramFloat2 + f2);
    setImageMatrix(this.c);
  }
  
  private float[] e()
  {
    this.l.reset();
    this.l.setRotate(-getCurrentAngle());
    Object localObject2 = Arrays.copyOf(this.a, this.a.length);
    Object localObject1 = RectUtils.a(this.k);
    this.l.mapPoints((float[])localObject2);
    this.l.mapPoints((float[])localObject1);
    localObject2 = RectUtils.b((float[])localObject2);
    localObject1 = RectUtils.b((float[])localObject1);
    float f1 = ((RectF)localObject2).left - ((RectF)localObject1).left;
    float f4 = ((RectF)localObject2).top - ((RectF)localObject1).top;
    float f3 = ((RectF)localObject2).right - ((RectF)localObject1).right;
    float f2 = ((RectF)localObject2).bottom - ((RectF)localObject1).bottom;
    localObject1 = new float[4];
    if (f1 <= 0.0F) {
      f1 = 0.0F;
    }
    localObject1[0] = f1;
    if (f4 > 0.0F) {
      f1 = f4;
    } else {
      f1 = 0.0F;
    }
    localObject1[1] = f1;
    if (f3 < 0.0F) {
      f1 = f3;
    } else {
      f1 = 0.0F;
    }
    localObject1[2] = f1;
    if (f2 < 0.0F) {
      f1 = f2;
    } else {
      f1 = 0.0F;
    }
    localObject1[3] = f1;
    this.l.reset();
    this.l.setRotate(getCurrentAngle());
    this.l.mapPoints((float[])localObject1);
    return localObject1;
  }
  
  private void f()
  {
    Drawable localDrawable = getDrawable();
    if (localDrawable == null) {
      return;
    }
    b(localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
  }
  
  private void setBitmapDecoded(Object paramObject)
  {
    if (paramObject != null) {
      this.i = true;
    }
  }
  
  public void a()
  {
    removeCallbacks(this.p);
    removeCallbacks(this.q);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 >= getMinScale()) {
      c(paramFloat1 / getCurrentScale(), paramFloat2, paramFloat3);
    }
  }
  
  protected void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    a(paramFloat1, paramFloat2, paramFloat3, paramLong, false);
  }
  
  protected void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("zoomImageToPosition scale:");
      ((StringBuilder)localObject).append(paramFloat1);
      ((StringBuilder)localObject).append(" ,centerX:");
      ((StringBuilder)localObject).append(paramFloat2);
      ((StringBuilder)localObject).append(" ,centerY:");
      ((StringBuilder)localObject).append(paramFloat3);
      ((StringBuilder)localObject).append(" ,durationMs:");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" ，isZoomOut：");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("CropImageView", 2, ((StringBuilder)localObject).toString());
    }
    float f = paramFloat1;
    if (paramFloat1 > getMaxScale()) {
      f = getMaxScale();
    }
    paramFloat1 = getCurrentScale();
    Object localObject = new CropImageView.ZoomImageToPosition(this, paramLong, paramFloat1, f - paramFloat1, paramFloat2, paramFloat3, paramBoolean);
    this.q = ((Runnable)localObject);
    post((Runnable)localObject);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean)
  {
    if ((paramFloat1 > 1.0F) && ((paramBoolean) || (getCurrentScale() * paramFloat1 <= getMaxScale())))
    {
      super.c(paramFloat1, paramFloat2, paramFloat3);
      return;
    }
    if ((paramFloat1 < 1.0F) && ((paramBoolean) || (getCurrentScale() * paramFloat1 >= getMinScale()))) {
      super.c(paramFloat1, paramFloat2, paramFloat3);
    }
  }
  
  protected void a(@NonNull TypedArray paramTypedArray)
  {
    float f1 = Math.abs(paramTypedArray.getFloat(0, 0.0F));
    float f2 = Math.abs(paramTypedArray.getFloat(1, 0.0F));
    if ((f1 != 0.0F) && (f2 != 0.0F))
    {
      this.m = (f1 / f2);
      return;
    }
    this.m = 0.0F;
  }
  
  public void a(@NonNull Bitmap.CompressFormat paramCompressFormat, int paramInt1, int paramInt2, int paramInt3, @Nullable CropCallback paramCropCallback)
  {
    a();
    setImageToWrapCropBounds(false);
    Bitmap localBitmap = getViewBitmap();
    if (localBitmap == null)
    {
      if (paramCropCallback != null) {
        paramCropCallback.a();
      }
      return;
    }
    ThreadManager.executeOnFileThread(new CropImageView.1(this, localBitmap, new ImageState(this.k, RectUtils.b(this.a), getCurrentScale(), getCurrentAngle()), paramCompressFormat, paramInt1, paramCropCallback));
  }
  
  protected boolean a(float[] paramArrayOfFloat)
  {
    this.l.reset();
    this.l.setRotate(-getCurrentAngle());
    paramArrayOfFloat = Arrays.copyOf(paramArrayOfFloat, paramArrayOfFloat.length);
    this.l.mapPoints(paramArrayOfFloat);
    float[] arrayOfFloat = RectUtils.a(this.k);
    this.l.mapPoints(arrayOfFloat);
    return RectUtils.b(paramArrayOfFloat).contains(RectUtils.b(arrayOfFloat));
  }
  
  protected void b()
  {
    super.b();
    Object localObject = getDrawable();
    if (localObject == null) {
      return;
    }
    float f1 = ((Drawable)localObject).getIntrinsicWidth();
    float f2 = ((Drawable)localObject).getIntrinsicHeight();
    if (this.m == 0.0F) {
      this.m = (f1 / f2);
    }
    int i = (int)(this.f / this.m);
    int j;
    if (i > this.g)
    {
      i = (int)(this.g * this.m);
      j = (this.f - i) / 2;
      this.k.set(j, 0.0F, i + j, this.g);
    }
    else
    {
      j = (this.g - i) / 2;
      this.k.set(0.0F, j, this.f, i + j);
    }
    b(f1, f2);
    c(f1, f2);
    localObject = this.o;
    if (localObject != null) {
      ((CropBoundsChangeListener)localObject).a(this.m);
    }
    if (this.h != null)
    {
      this.h.b(getCurrentScale());
      this.h.a(getCurrentAngle());
    }
  }
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 <= getMaxScale()) {
      c(paramFloat1 / getCurrentScale(), paramFloat2, paramFloat3);
    }
  }
  
  public void c(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    a(paramFloat1, paramFloat2, paramFloat3, false);
  }
  
  protected boolean c()
  {
    return a(this.a);
  }
  
  @Nullable
  public CropBoundsChangeListener getCropBoundsChangeListener()
  {
    return this.o;
  }
  
  public float getMaxScale()
  {
    return this.r;
  }
  
  public float getMinScale()
  {
    return this.s;
  }
  
  public float getTargetAspectRatio()
  {
    return this.m;
  }
  
  public void setCropBoundsChangeListener(@Nullable CropBoundsChangeListener paramCropBoundsChangeListener)
  {
    this.o = paramCropBoundsChangeListener;
  }
  
  public void setCropRect(RectF paramRectF)
  {
    this.m = (paramRectF.width() / paramRectF.height());
    this.k.set(paramRectF.left - getPaddingLeft(), paramRectF.top - getPaddingTop(), paramRectF.right - getPaddingRight(), paramRectF.bottom - getPaddingBottom());
    f();
    setImageToWrapCropBounds();
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    setBitmapDecoded(paramBitmap);
    super.setImageBitmap(paramBitmap);
  }
  
  @Deprecated
  public void setImageDrawable(@Nullable Drawable paramDrawable)
  {
    setBitmapDecoded(paramDrawable);
    super.setImageDrawable(paramDrawable);
  }
  
  public void setImageToLowerMaxScale()
  {
    if (getCurrentScale() > getMaxScale())
    {
      float[] arrayOfFloat = new float[9];
      this.c.getValues(arrayOfFloat);
      a(getMaxScale(), this.d, this.e, 200L, true);
    }
  }
  
  public void setImageToWrapCropBounds()
  {
    setImageToWrapCropBounds(true);
  }
  
  public void setImageToWrapCropBounds(boolean paramBoolean)
  {
    if ((this.j) && (!c()))
    {
      float f4 = this.b[0];
      float f5 = this.b[1];
      float f6 = getCurrentScale();
      float f1 = this.k.centerX() - f4;
      float f2 = this.k.centerY() - f5;
      this.l.reset();
      this.l.setTranslate(f1, f2);
      Object localObject = Arrays.copyOf(this.a, this.a.length);
      this.l.mapPoints((float[])localObject);
      boolean bool = a((float[])localObject);
      float f3;
      if (bool)
      {
        localObject = e();
        f1 = -(localObject[0] + localObject[2]);
        f2 = -(localObject[1] + localObject[3]);
        f3 = 0.0F;
      }
      else
      {
        localObject = new RectF(this.k);
        this.l.reset();
        this.l.setRotate(getCurrentAngle());
        this.l.mapRect((RectF)localObject);
        float[] arrayOfFloat = RectUtils.a(this.a);
        f3 = Math.max(((RectF)localObject).width() / arrayOfFloat[0], ((RectF)localObject).height() / arrayOfFloat[1]);
        f3 = f3 * f6 - f6;
      }
      if (paramBoolean)
      {
        localObject = new CropImageView.WrapCropBoundsRunnable(this, this.v, f4, f5, f1, f2, f6, f3, bool);
        this.p = ((Runnable)localObject);
        post((Runnable)localObject);
        return;
      }
      a(f1, f2);
      if (!bool) {
        b(f6 + f3, this.k.centerX(), this.k.centerY());
      }
    }
  }
  
  public void setImageToWrapCropBoundsAnimDuration(@IntRange(from=100L) long paramLong)
  {
    if (paramLong > 0L)
    {
      this.v = paramLong;
      return;
    }
    throw new IllegalArgumentException("Animation duration cannot be negative value.");
  }
  
  public void setMaxResultImageSizeX(@IntRange(from=10L) int paramInt)
  {
    this.t = paramInt;
  }
  
  public void setMaxResultImageSizeY(@IntRange(from=10L) int paramInt)
  {
    this.u = paramInt;
  }
  
  public void setMaxScale(float paramFloat)
  {
    this.r = paramFloat;
    this.n = -1.0F;
  }
  
  public void setMaxScaleMultiplier(float paramFloat)
  {
    this.n = paramFloat;
  }
  
  public void setTargetAspectRatio(float paramFloat)
  {
    Object localObject = getDrawable();
    if (localObject == null)
    {
      this.m = paramFloat;
      return;
    }
    if (paramFloat == 0.0F) {
      this.m = (((Drawable)localObject).getIntrinsicWidth() / ((Drawable)localObject).getIntrinsicHeight());
    } else {
      this.m = paramFloat;
    }
    localObject = this.o;
    if (localObject != null) {
      ((CropBoundsChangeListener)localObject).a(this.m);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.imagecrop.CropImageView
 * JD-Core Version:    0.7.0.1
 */