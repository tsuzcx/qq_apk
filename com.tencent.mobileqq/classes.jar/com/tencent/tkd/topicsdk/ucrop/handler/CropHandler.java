package com.tencent.tkd.topicsdk.ucrop.handler;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.tkd.topicsdk.ucrop.callback.BitmapCropCallback;
import com.tencent.tkd.topicsdk.ucrop.callback.CropBoundsChangeListener;
import com.tencent.tkd.topicsdk.ucrop.model.ImageState;
import com.tencent.tkd.topicsdk.ucrop.util.RectUtils;
import com.tencent.tkd.topicsdk.ucrop.view.IGestureCropView;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.jetbrains.annotations.NotNull;

public class CropHandler
  extends TransformHandler
{
  private final RectF j = new RectF();
  private final Matrix k = new Matrix();
  private float l;
  private float m = 10.0F;
  private CropBoundsChangeListener n;
  private Runnable o = null;
  private Runnable p = null;
  private float q;
  private float r;
  private long s = 500L;
  
  public CropHandler(IGestureCropView paramIGestureCropView)
  {
    super(paramIGestureCropView);
  }
  
  private void a(String paramString, boolean paramBoolean, @Nullable BitmapCropCallback paramBitmapCropCallback)
  {
    if (paramBitmapCropCallback == null) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(new CropHandler.2(this, paramBoolean, paramBitmapCropCallback, paramString));
  }
  
  private void b(float paramFloat1, float paramFloat2)
  {
    this.r = Math.min(Math.min(this.j.width() / paramFloat1, this.j.width() / paramFloat2), Math.min(this.j.height() / paramFloat2, this.j.height() / paramFloat1));
    this.q = (this.r * this.m);
  }
  
  private void c(float paramFloat1, float paramFloat2)
  {
    float f3 = this.j.width();
    float f2 = this.j.height();
    float f1 = Math.max(this.j.width() / paramFloat1, this.j.height() / paramFloat2);
    paramFloat1 = (f3 - paramFloat1 * f1) / 2.0F;
    f3 = this.j.left;
    paramFloat2 = (f2 - paramFloat2 * f1) / 2.0F;
    f2 = this.j.top;
    this.c.reset();
    this.c.set(k().getInitMatrix());
    this.c.postScale(f1, f1);
    this.c.postTranslate(paramFloat1 + f3, paramFloat2 + f2);
    a(this.c);
  }
  
  private float[] g()
  {
    this.k.reset();
    this.k.setRotate(-i());
    Object localObject2 = Arrays.copyOf(this.a, this.a.length);
    Object localObject1 = RectUtils.a(this.j);
    this.k.mapPoints((float[])localObject2);
    this.k.mapPoints((float[])localObject1);
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
    this.k.reset();
    this.k.setRotate(i());
    this.k.mapPoints((float[])localObject1);
    return localObject1;
  }
  
  private void l()
  {
    int i = k().getBitmapWidth();
    int i1 = k().getBitmapHeight();
    if (i > 0)
    {
      if (i1 <= 0) {
        return;
      }
      b(i, i1);
    }
  }
  
  public float a()
  {
    return this.q;
  }
  
  public void a(float paramFloat)
  {
    int i = k().getBitmapWidth();
    int i1 = k().getBitmapHeight();
    if ((i > 0) && (i1 > 0))
    {
      if (paramFloat == 0.0F) {
        this.l = (i / i1);
      } else {
        this.l = paramFloat;
      }
      CropBoundsChangeListener localCropBoundsChangeListener = this.n;
      if (localCropBoundsChangeListener != null) {
        localCropBoundsChangeListener.a(this.l);
      }
      return;
    }
    this.l = paramFloat;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 <= a()) {
      b(paramFloat1 / h(), paramFloat2, paramFloat3);
    }
  }
  
  protected void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    float f = paramFloat1;
    if (paramFloat1 > a()) {
      f = a();
    }
    paramFloat1 = h();
    View localView = k().getView();
    CropHandler.ZoomImageToPosition localZoomImageToPosition = new CropHandler.ZoomImageToPosition(this, paramLong, paramFloat1, f - paramFloat1, paramFloat2, paramFloat3);
    this.p = localZoomImageToPosition;
    localView.post(localZoomImageToPosition);
  }
  
  public void a(@NotNull Bitmap.CompressFormat paramCompressFormat, int paramInt, String paramString, @Nullable BitmapCropCallback paramBitmapCropCallback)
  {
    c();
    a(false);
    Bitmap localBitmap = j();
    if (localBitmap == null)
    {
      if (paramBitmapCropCallback != null) {
        paramBitmapCropCallback.a();
      }
      return;
    }
    ImageState localImageState = new ImageState(this.j, RectUtils.b(this.a), h(), i());
    Executors.newSingleThreadExecutor().execute(new CropHandler.1(this, localBitmap, localImageState, paramString, paramCompressFormat, paramInt, paramBitmapCropCallback));
  }
  
  public void a(RectF paramRectF)
  {
    View localView = k().getView();
    this.l = (paramRectF.width() / paramRectF.height());
    this.j.set(paramRectF.left - localView.getPaddingLeft(), paramRectF.top - localView.getPaddingTop(), paramRectF.right - localView.getPaddingRight(), paramRectF.bottom - localView.getPaddingBottom());
    l();
    d();
  }
  
  public void a(@Nullable CropBoundsChangeListener paramCropBoundsChangeListener)
  {
    this.n = paramCropBoundsChangeListener;
  }
  
  public void a(Object paramObject)
  {
    if (paramObject != null) {
      this.g = true;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.h) && (!f()))
    {
      float f4 = this.b[0];
      float f5 = this.b[1];
      float f6 = h();
      float f1 = this.j.centerX() - f4;
      float f2 = this.j.centerY() - f5;
      this.k.reset();
      this.k.setTranslate(f1, f2);
      Object localObject1 = Arrays.copyOf(this.a, this.a.length);
      this.k.mapPoints((float[])localObject1);
      boolean bool = a((float[])localObject1);
      float f3;
      Object localObject2;
      if (bool)
      {
        localObject1 = g();
        f1 = -(localObject1[0] + localObject1[2]);
        f2 = -(localObject1[1] + localObject1[3]);
        f3 = 0.0F;
      }
      else
      {
        localObject1 = new RectF(this.j);
        this.k.reset();
        this.k.setRotate(i());
        this.k.mapRect((RectF)localObject1);
        localObject2 = RectUtils.a(this.a);
        f3 = Math.max(((RectF)localObject1).width() / localObject2[0], ((RectF)localObject1).height() / localObject2[1]);
        f3 = f3 * f6 - f6;
      }
      if (paramBoolean)
      {
        localObject1 = k().getView();
        localObject2 = new CropHandler.WrapCropBoundsRunnable(this, this.s, f4, f5, f1, f2, f6, f3, bool);
        this.o = ((Runnable)localObject2);
        ((View)localObject1).post((Runnable)localObject2);
        return;
      }
      a(f1, f2);
      if (!bool) {
        a(f6 + f3, this.j.centerX(), this.j.centerY());
      }
    }
  }
  
  protected boolean a(float[] paramArrayOfFloat)
  {
    this.k.reset();
    this.k.setRotate(-i());
    paramArrayOfFloat = Arrays.copyOf(paramArrayOfFloat, paramArrayOfFloat.length);
    this.k.mapPoints(paramArrayOfFloat);
    float[] arrayOfFloat = RectUtils.a(this.j);
    this.k.mapPoints(arrayOfFloat);
    return RectUtils.b(paramArrayOfFloat).contains(RectUtils.b(arrayOfFloat));
  }
  
  public float b()
  {
    return this.r;
  }
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if ((paramFloat1 > 1.0F) && (h() * paramFloat1 <= a()))
    {
      super.b(paramFloat1, paramFloat2, paramFloat3);
      return;
    }
    if ((paramFloat1 < 1.0F) && (h() * paramFloat1 >= b())) {
      super.b(paramFloat1, paramFloat2, paramFloat3);
    }
  }
  
  public void c()
  {
    k().getView().removeCallbacks(this.o);
    k().getView().removeCallbacks(this.p);
  }
  
  public void d()
  {
    a(true);
  }
  
  protected void e()
  {
    super.e();
    float f1 = k().getBitmapWidth();
    float f2 = k().getBitmapHeight();
    if (f2 > 0.0F)
    {
      if (f1 <= 0.0F) {
        return;
      }
      if (this.l == 0.0F) {
        this.l = (f1 / f2);
      }
      int i = (int)(this.d / this.l);
      int i1;
      if (i > this.e)
      {
        i = (int)(this.e * this.l);
        i1 = (this.d - i) / 2;
        this.j.set(i1, 0.0F, i + i1, this.e);
      }
      else
      {
        i1 = (this.e - i) / 2;
        this.j.set(0.0F, i1, this.d, i + i1);
      }
      b(f1, f2);
      c(f1, f2);
      CropBoundsChangeListener localCropBoundsChangeListener = this.n;
      if (localCropBoundsChangeListener != null) {
        localCropBoundsChangeListener.a(this.l);
      }
      if (this.f != null)
      {
        this.f.b(h());
        this.f.a(i());
      }
    }
  }
  
  protected boolean f()
  {
    return a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.ucrop.handler.CropHandler
 * JD-Core Version:    0.7.0.1
 */