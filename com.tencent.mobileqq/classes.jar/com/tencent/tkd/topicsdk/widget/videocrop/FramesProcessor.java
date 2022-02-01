package com.tencent.tkd.topicsdk.widget.videocrop;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.Scroller;
import com.tencent.tkd.topicsdk.common.DisplayUtils;
import com.tencent.tkd.topicsdk.framework.TLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/videocrop/FramesProcessor;", "Lcom/tencent/tkd/topicsdk/widget/videocrop/FrameAdapter$DataSetChangeListener;", "parent", "Lcom/tencent/tkd/topicsdk/widget/videocrop/FrameParent;", "videoPath", "", "videoDuration", "", "frameWidth", "", "frameHeight", "paddingLeft", "milliSecPerFrame", "(Lcom/tencent/tkd/topicsdk/widget/videocrop/FrameParent;Ljava/lang/String;IFFFI)V", "adapter", "Lcom/tencent/tkd/topicsdk/widget/videocrop/FrameAdapter;", "dstRect", "Landroid/graphics/Rect;", "grayMatrix", "", "mBitmap", "Landroid/graphics/Bitmap;", "mCanvas", "Landroid/graphics/Canvas;", "mGestureDetector", "Landroid/view/GestureDetector;", "mGestureListener", "Landroid/view/GestureDetector$OnGestureListener;", "mGrayPaint", "Landroid/graphics/Paint;", "mInitialRightFrameIndex", "mLastMovedDistance", "mLeftFrameIndex", "mLeftRect", "mOnFetchFrameListener", "Lcom/tencent/tkd/topicsdk/widget/videocrop/FramesProcessor$OnFetchFrameListener;", "mOnMoveListener", "Lcom/tencent/tkd/topicsdk/widget/videocrop/FramesProcessor$OnMoveListener;", "mPaint", "mRightFrameIndex", "mRightRect", "mScroller", "Landroid/widget/Scroller;", "mTotalRange", "maxMovedDistance", "minMovedDistance", "movedDistance", "getPaddingLeft", "()F", "getParent", "()Lcom/tencent/tkd/topicsdk/widget/videocrop/FrameParent;", "processorWidth", "srcRect", "computeFrameIndex", "", "computeScroll", "destroy", "draw", "canvas", "floatEqualsZero", "", "a", "hasChanged", "onChanged", "processTouchEvent", "event", "Landroid/view/MotionEvent;", "setLeftMaskBound", "left", "setOnMoveListener", "listener", "setRightMaskBound", "right", "setRightPosition", "Companion", "Frame", "OnFetchFrameListener", "OnMoveListener", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class FramesProcessor
  implements FrameAdapter.DataSetChangeListener
{
  public static final FramesProcessor.Companion a = new FramesProcessor.Companion(null);
  private final float A;
  private final float B;
  private final float C;
  private final int b;
  private float c;
  private float d;
  private int e;
  private int f;
  private final int g;
  private final float h;
  private float i;
  private float j;
  private FramesProcessor.OnMoveListener k;
  private FrameAdapter l;
  private FramesProcessor.OnFetchFrameListener m;
  private Scroller n;
  private GestureDetector o;
  private final GestureDetector.OnGestureListener p;
  private final Canvas q;
  private final Bitmap r;
  private final Paint s;
  private final Paint t;
  private final Rect u;
  private final Rect v;
  private final Rect w;
  private final Rect x;
  private final float[] y;
  @NotNull
  private final FrameParent z;
  
  public FramesProcessor(@NotNull FrameParent paramFrameParent, @NotNull String paramString, int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt2)
  {
    this.z = paramFrameParent;
    this.A = paramFloat1;
    this.B = paramFloat2;
    this.C = paramFloat3;
    this.b = (DisplayUtils.a.a(this.z.getContext()) - DisplayUtils.a.a(this.z.getContext(), 39.0F));
    paramFloat1 = 12;
    this.h = (this.A * paramFloat1);
    this.p = ((GestureDetector.OnGestureListener)new FramesProcessor.mGestureListener.1(this));
    this.s = new Paint();
    this.t = new Paint();
    this.w = new Rect();
    this.x = new Rect();
    this.y = new float[] { 0.33F, 0.5F, 0.11F, 0.0F, -50.0F, 0.33F, 0.5F, 0.11F, 0.0F, -50.0F, 0.33F, 0.5F, 0.11F, 0.0F, -50.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    this.i = Math.max(this.h - this.A * paramFloat1, 0.0F);
    this.j = 0.0F;
    paramFrameParent = new StringBuilder();
    paramFrameParent.append("mTotalRange=");
    paramFrameParent.append(this.h);
    paramFrameParent.append(", mMaxMovedDistance=");
    paramFrameParent.append(this.i);
    TLog.b("FramesProcessor", paramFrameParent.toString());
    this.c = 0.0F;
    paramFrameParent = Bitmap.createBitmap(this.b, (int)this.B, Bitmap.Config.RGB_565);
    Intrinsics.checkExpressionValueIsNotNull(paramFrameParent, "Bitmap.createBitmap(proc…), Bitmap.Config.RGB_565)");
    this.r = paramFrameParent;
    this.q = new Canvas(this.r);
    this.t.setColorFilter((ColorFilter)new ColorMatrixColorFilter(this.y));
    this.u = new Rect(0, 0, (int)this.C, (int)this.B);
    this.v = new Rect((int)(this.C + this.A * paramFloat1), 0, this.b, (int)this.B);
    this.n = new Scroller(this.z.getContext());
    this.o = new GestureDetector(this.z.getContext(), this.p);
    this.l = new FrameAdapter((FrameAdapter.DataSetChangeListener)this);
    double d1 = this.b * 1.0F;
    double d2 = this.A;
    Double.isNaN(d1);
    Double.isNaN(d2);
    this.f = ((int)Math.ceil(d1 / d2));
    this.f = Math.min(this.f, 12);
    this.g = this.f;
    this.e = 0;
    this.m = ((FramesProcessor.OnFetchFrameListener)new VideoFramesRetriever(paramString, this.A));
    paramFrameParent = this.m;
    if (paramFrameParent != null) {
      paramFrameParent.a(paramInt2, paramInt1, this.l);
    }
    paramFrameParent = this.m;
    if (paramFrameParent != null) {
      paramFrameParent.a(this.e, this.f);
    }
  }
  
  private final boolean a(float paramFloat)
  {
    return Math.abs(paramFloat - 0.0F) == 0.0F;
  }
  
  private final void e()
  {
    if (this.l.a()) {
      return;
    }
    int i1 = (int)(this.c / this.A);
    this.e = Math.max(i1, 0);
    int i2 = this.g;
    if (i2 >= 12) {
      this.f = Math.min(i2 + i1, 12);
    }
  }
  
  private final void f()
  {
    this.q.drawColor(-16777216);
    Object localObject = this.n;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mScroller");
    }
    if (((Scroller)localObject).computeScrollOffset())
    {
      localObject = this.n;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mScroller");
      }
      this.c = ((Scroller)localObject).getCurrX();
      f1 = this.c;
      f2 = this.j;
      if (f1 < f2)
      {
        this.c = f2;
        localObject = this.n;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mScroller");
        }
        ((Scroller)localObject).forceFinished(true);
      }
      f1 = this.c;
      f2 = this.i;
      if (f1 > f2)
      {
        this.c = f2;
        localObject = this.n;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mScroller");
        }
        ((Scroller)localObject).forceFinished(true);
      }
      e();
      this.z.invalidate();
    }
    else
    {
      localObject = this.m;
      if (localObject != null) {
        ((FramesProcessor.OnFetchFrameListener)localObject).a(this.e, this.f);
      }
    }
    float f1 = this.c;
    float f2 = this.d;
    this.d = f1;
    if (a(f1 - f2)) {
      return;
    }
    localObject = this.k;
    if (localObject != null)
    {
      f1 = this.c;
      ((FramesProcessor.OnMoveListener)localObject).a(f1, -f1, this.h - f1);
    }
  }
  
  public void a()
  {
    this.z.postInvalidate();
  }
  
  public final void a(int paramInt)
  {
    int i1 = this.u.right;
    this.j += i1 - paramInt;
    this.u.right = paramInt;
    this.z.invalidate();
  }
  
  public final void a(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    f();
    int i1 = Math.max(this.e - 1, 0);
    float f1 = i1 * this.A;
    this.q.translate(f1 - this.c + this.C, 0.0F);
    int i4 = Math.min(this.f + 3, 12);
    int i2 = (int)this.A;
    while (i1 < i4)
    {
      localObject = this.l.a(i1);
      if (localObject != null)
      {
        int i3 = (int)Math.min(this.h - f1, this.A);
        localObject = ((FramesProcessor.Frame)localObject).a();
        i2 = i3;
        if (localObject != null)
        {
          this.w.set(0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
          this.x.set(0, 0, i3, (int)this.B);
          this.q.drawBitmap((Bitmap)localObject, this.w, this.x, this.s);
          i2 = i3;
        }
      }
      localObject = this.q;
      float f2 = i2;
      ((Canvas)localObject).translate(f2, 0.0F);
      f1 += f2;
      i1 += 1;
    }
    this.q.translate(-f1 + this.c - this.C, 0.0F);
    paramCanvas.drawBitmap(this.r, 0.0F, 0.0F, this.s);
    Object localObject = this.r;
    Rect localRect = this.u;
    paramCanvas.drawBitmap((Bitmap)localObject, localRect, localRect, this.t);
    localObject = this.r;
    localRect = this.v;
    paramCanvas.drawBitmap((Bitmap)localObject, localRect, localRect, this.t);
  }
  
  public final void a(@Nullable MotionEvent paramMotionEvent)
  {
    this.o.onTouchEvent(paramMotionEvent);
  }
  
  public final void a(@Nullable FramesProcessor.OnMoveListener paramOnMoveListener)
  {
    this.k = paramOnMoveListener;
  }
  
  public final void b(int paramInt)
  {
    int i1 = this.v.left;
    this.i += i1 - paramInt;
    this.v.left = paramInt;
    this.z.invalidate();
  }
  
  public final boolean b()
  {
    return a(this.c) ^ true;
  }
  
  public final void c()
  {
    this.k = ((FramesProcessor.OnMoveListener)null);
    FramesProcessor.OnFetchFrameListener localOnFetchFrameListener = this.m;
    if (localOnFetchFrameListener != null) {
      localOnFetchFrameListener.a();
    }
    this.l.b();
  }
  
  @NotNull
  public final FrameParent d()
  {
    return this.z;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.videocrop.FramesProcessor
 * JD-Core Version:    0.7.0.1
 */