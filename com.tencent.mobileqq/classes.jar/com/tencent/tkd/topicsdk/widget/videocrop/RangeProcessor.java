package com.tencent.tkd.topicsdk.widget.videocrop;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.tencent.tkd.R.color;
import com.tencent.tkd.R.drawable;
import com.tencent.tkd.topicsdk.common.DisplayUtils;
import com.tencent.tkd.topicsdk.framework.TLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/videocrop/RangeProcessor;", "", "parent", "Lcom/tencent/tkd/topicsdk/widget/videocrop/FrameParent;", "frameWidth", "", "frameHeight", "milliSecPerFrame", "", "(Lcom/tencent/tkd/topicsdk/widget/videocrop/FrameParent;FFI)V", "lastX", "leftBarrier", "lineHeight", "maxRange", "minRange", "paint", "Landroid/graphics/Paint;", "getParent", "()Lcom/tencent/tkd/topicsdk/widget/videocrop/FrameParent;", "pressedThumb", "rangeChangeListener", "Lcom/tencent/tkd/topicsdk/widget/videocrop/RangeProcessor$OnRangeChangeListener;", "getRangeChangeListener", "()Lcom/tencent/tkd/topicsdk/widget/videocrop/RangeProcessor$OnRangeChangeListener;", "setRangeChangeListener", "(Lcom/tencent/tkd/topicsdk/widget/videocrop/RangeProcessor$OnRangeChangeListener;)V", "rangeDistance", "getRangeDistance", "()F", "rightBarrier", "screenMaxCoord", "screenMinCoord", "screenWidth", "thumbColor", "thumbHalfWidth", "getThumbHalfWidth", "thumbHeight", "getThumbHeight", "thumbMaxImage", "Landroid/graphics/Bitmap;", "thumbMinImage", "thumbWidth", "getThumbWidth", "calculateInSampleSize", "options", "Landroid/graphics/BitmapFactory$Options;", "reqWidth", "reqHeight", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "drawMaxImage", "thumbDrawable", "Landroid/graphics/drawable/Drawable;", "drawMinImage", "floatEquals", "", "a", "b", "getBitmapFromResource", "resources", "Landroid/content/res/Resources;", "resId", "hasChanged", "isInThumbRange", "touchX", "touchY", "cursorX", "isPressedThumb", "processTouchEvent", "event", "Landroid/view/MotionEvent;", "reset", "setBarrier", "left", "right", "setLimitRange", "minVideoLength", "maxVideoLength", "updateScreenMaxCoordInMove", "dx", "updateScreenMinCoordInMove", "Companion", "OnRangeChangeListener", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class RangeProcessor
{
  public static final RangeProcessor.Companion a = new RangeProcessor.Companion(null);
  private final int b;
  private final Paint c;
  private final float d;
  private Bitmap e;
  private Bitmap f;
  private final float g;
  private final float h;
  private float i;
  private float j;
  private float k;
  private float l;
  private float m;
  private float n;
  private int o;
  private float p;
  private final int q;
  @Nullable
  private RangeProcessor.OnRangeChangeListener r;
  @NotNull
  private final FrameParent s;
  private final float t;
  private final float u;
  private final int v;
  
  public RangeProcessor(@NotNull FrameParent paramFrameParent, float paramFloat1, float paramFloat2, int paramInt)
  {
    this.s = paramFrameParent;
    this.t = paramFloat1;
    this.u = paramFloat2;
    this.v = paramInt;
    this.b = DisplayUtils.a.a(this.s.getContext());
    this.c = new Paint(1);
    this.d = DisplayUtils.a.a(this.s.getContext(), 2.0F);
    this.g = DisplayUtils.a.a(this.s.getContext(), 18.0F);
    this.h = (this.u + this.d * 2);
    this.o = -1;
    this.q = this.s.getContext().getResources().getColor(R.color.c);
    paramFrameParent = (Drawable)new ColorDrawable(this.q);
    paramFrameParent.setBounds(0, 0, (int)this.g, (int)this.h);
    b(paramFrameParent);
    a(paramFrameParent);
    paramFloat1 = this.g;
    this.m = paramFloat1;
    this.n = (12 * this.t + paramFloat1);
  }
  
  private final int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i3 = paramOptions.outHeight;
    int i4 = paramOptions.outWidth;
    int i2 = 1;
    int i1 = 1;
    if ((i3 > paramInt2) || (i4 > paramInt1))
    {
      i3 /= 2;
      i4 /= 2;
      for (;;)
      {
        i2 = i1;
        if (i3 / i1 <= paramInt2) {
          break;
        }
        i2 = i1;
        if (i4 / i1 <= paramInt1) {
          break;
        }
        i1 *= 2;
      }
    }
    return i2;
  }
  
  private final Bitmap a(Resources paramResources, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramResources == null) {
      return null;
    }
    if (paramInt1 <= 0) {
      return null;
    }
    try
    {
      localObject = new BitmapFactory.Options();
      int i1 = 1;
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapFactory.decodeResource(paramResources, paramInt1, (BitmapFactory.Options)localObject);
      if ((paramInt2 <= 0) && (paramInt3 <= 0)) {
        paramInt2 = i1;
      } else {
        paramInt2 = a((BitmapFactory.Options)localObject, paramInt2, paramInt3);
      }
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      ((BitmapFactory.Options)localObject).inSampleSize = paramInt2;
      paramResources = BitmapFactory.decodeResource(paramResources, paramInt1, (BitmapFactory.Options)localObject);
      return paramResources;
    }
    catch (OutOfMemoryError paramResources)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getBitmapFromResource: ");
      ((StringBuilder)localObject).append(paramResources);
      TLog.d("RangeProcessor", ((StringBuilder)localObject).toString());
      return (Bitmap)null;
    }
    catch (Exception paramResources)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getBitmapFromResource: ");
      ((StringBuilder)localObject).append(paramResources);
      TLog.d("RangeProcessor", ((StringBuilder)localObject).toString());
    }
    return (Bitmap)null;
  }
  
  private final void a(Drawable paramDrawable)
  {
    Bitmap localBitmap = a(this.s.getContext().getResources(), R.drawable.b, (int)this.g, (int)this.h);
    Object localObject = Bitmap.createBitmap((int)this.g, (int)this.h, Bitmap.Config.RGB_565);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Bitmap.createBitmap(thum…), Bitmap.Config.RGB_565)");
    this.f = ((Bitmap)localObject);
    localObject = this.f;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("thumbMaxImage");
    }
    localObject = new Canvas((Bitmap)localObject);
    paramDrawable.draw((Canvas)localObject);
    if (localBitmap != null) {
      ((Canvas)localObject).drawBitmap(localBitmap, DisplayUtils.a.a(this.s.getContext(), 2.0F), (this.h - localBitmap.getHeight()) / 2, this.c);
    }
  }
  
  private final boolean a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramFloat1 = Math.abs(paramFloat1 - paramFloat3);
    paramFloat3 = this.g;
    float f1 = 2;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramFloat1 <= paramFloat3 * f1)
    {
      bool1 = bool2;
      if (paramFloat2 > 0)
      {
        bool1 = bool2;
        if (paramFloat2 < this.h) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private final void b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if ((paramFloat1 >= 0) || (this.i + paramFloat1 > this.g))
    {
      paramFloat1 = this.j;
      paramFloat2 = this.k;
      if (paramFloat1 - paramFloat3 < paramFloat2) {
        paramFloat2 = paramFloat1 - paramFloat2;
      } else {
        paramFloat2 = paramFloat3;
      }
    }
    this.i = paramFloat2;
  }
  
  private final void b(Drawable paramDrawable)
  {
    Bitmap localBitmap = a(this.s.getContext().getResources(), R.drawable.a, (int)this.g, (int)this.h);
    Object localObject = Bitmap.createBitmap((int)this.g, (int)this.h, Bitmap.Config.RGB_565);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Bitmap.createBitmap(thum…), Bitmap.Config.RGB_565)");
    this.e = ((Bitmap)localObject);
    localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("thumbMinImage");
    }
    localObject = new Canvas((Bitmap)localObject);
    paramDrawable.draw((Canvas)localObject);
    if (localBitmap != null) {
      ((Canvas)localObject).drawBitmap(localBitmap, DisplayUtils.a.a(this.s.getContext(), 5.0F), (this.h - localBitmap.getHeight()) / 2, this.c);
    }
  }
  
  private final void c(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if ((paramFloat1 <= 0) || (this.j + paramFloat1 < this.l))
    {
      paramFloat1 = this.i;
      paramFloat2 = this.k;
      if (paramFloat3 - paramFloat1 < paramFloat2) {
        paramFloat2 = paramFloat1 + paramFloat2;
      } else {
        paramFloat2 = paramFloat3;
      }
    }
    this.j = paramFloat2;
  }
  
  private final boolean c(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1 - paramFloat2) == 0.0F;
  }
  
  private final float f()
  {
    return this.g / 2;
  }
  
  public final float a()
  {
    return this.g;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    float f1 = paramInt2 * 1.0F / this.v;
    float f2 = this.t;
    this.l = Math.min(f1 * f2, 12 * f2 + this.g);
    this.k = Math.max(paramInt1 * 1.0F / this.v * this.t, 0.0F);
    f1 = this.g;
    this.i = f1;
    this.j = (this.l + f1);
  }
  
  public final void a(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    paramCanvas.save();
    this.c.setColor(this.q);
    paramCanvas.drawRect(this.i, -this.d, this.j, 0.0F, this.c);
    float f1 = this.i;
    float f2 = this.h;
    float f3 = this.d;
    paramCanvas.drawRect(f1, f2 - 2 * f3, this.j, f2 - f3, this.c);
    Bitmap localBitmap = this.e;
    if (localBitmap == null) {
      Intrinsics.throwUninitializedPropertyAccessException("thumbMinImage");
    }
    paramCanvas.drawBitmap(localBitmap, this.i - this.g, -this.d, this.c);
    localBitmap = this.f;
    if (localBitmap == null) {
      Intrinsics.throwUninitializedPropertyAccessException("thumbMaxImage");
    }
    paramCanvas.drawBitmap(localBitmap, this.j, -this.d, this.c);
    paramCanvas.restore();
  }
  
  public final void a(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "event");
    float f1 = paramMotionEvent.getX();
    if (paramMotionEvent.getAction() == 1) {
      this.o = -1;
    }
    if (paramMotionEvent.getAction() == 0)
    {
      this.p = paramMotionEvent.getX();
      return;
    }
    if (paramMotionEvent.getAction() == 2)
    {
      float f2 = f1 - this.p;
      int i1 = this.o;
      float f3;
      if (i1 == 0)
      {
        f3 = Math.max(this.j - this.l, this.m);
        if (f1 < f3)
        {
          this.i = f3;
          return;
        }
        b(f2, f3, f1);
      }
      else if (i1 == 1)
      {
        f3 = Math.min(this.i + this.l, this.n);
        if (f1 > f3)
        {
          this.j = f3;
          return;
        }
        c(f2, f3, f1);
      }
    }
    this.s.invalidate();
    paramMotionEvent = this.r;
    if (paramMotionEvent != null) {
      paramMotionEvent.a(this.i, this.j);
    }
  }
  
  public final void a(@Nullable RangeProcessor.OnRangeChangeListener paramOnRangeChangeListener)
  {
    this.r = paramOnRangeChangeListener;
  }
  
  public final boolean a(float paramFloat1, float paramFloat2)
  {
    boolean bool1 = a(paramFloat1, paramFloat2, this.i - f());
    boolean bool2 = a(paramFloat1, paramFloat2, this.j + f());
    if (bool1)
    {
      this.o = 0;
      return true;
    }
    if (bool2)
    {
      this.o = 1;
      return true;
    }
    return false;
  }
  
  public final float b()
  {
    return this.h;
  }
  
  public final void b(float paramFloat1, float paramFloat2)
  {
    float f1 = 0;
    if (paramFloat1 >= f1) {
      paramFloat1 += this.g;
    } else {
      paramFloat1 = this.g;
    }
    this.m = paramFloat1;
    if (paramFloat2 >= f1)
    {
      paramFloat1 = this.g;
      this.n = Math.min(paramFloat2 + paramFloat1, this.b - paramFloat1);
    }
  }
  
  public final float c()
  {
    return this.j - this.i;
  }
  
  public final boolean d()
  {
    return (!c(this.i, this.g)) || (!c(this.j, this.l));
  }
  
  public final void e()
  {
    this.r = ((RangeProcessor.OnRangeChangeListener)null);
    Bitmap localBitmap = this.e;
    if (localBitmap == null) {
      Intrinsics.throwUninitializedPropertyAccessException("thumbMinImage");
    }
    localBitmap.recycle();
    localBitmap = this.f;
    if (localBitmap == null) {
      Intrinsics.throwUninitializedPropertyAccessException("thumbMaxImage");
    }
    localBitmap.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.videocrop.RangeProcessor
 * JD-Core Version:    0.7.0.1
 */