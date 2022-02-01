package com.tencent.tkd.topicsdk.ucrop.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import com.tencent.tkd.topicsdk.ucrop.R.color;
import com.tencent.tkd.topicsdk.ucrop.R.dimen;
import com.tencent.tkd.topicsdk.ucrop.R.styleable;
import com.tencent.tkd.topicsdk.ucrop.callback.OverlayViewChangeListener;
import com.tencent.tkd.topicsdk.ucrop.util.RectUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/ucrop/view/OverlayView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "circleDimmedLayer", "", "getCircleDimmedLayer", "()Z", "setCircleDimmedLayer", "(Z)V", "value", "cropGridColumnCount", "getCropGridColumnCount", "()I", "setCropGridColumnCount", "(I)V", "cropGridRowCount", "getCropGridRowCount", "setCropGridRowCount", "cropViewRect", "Landroid/graphics/RectF;", "getCropViewRect", "()Landroid/graphics/RectF;", "mFreestyleCropMode", "freestyleCropMode", "getFreestyleCropMode", "setFreestyleCropMode", "gridPoints", "", "mCircularPath", "Landroid/graphics/Path;", "mCropFrameCornersPaint", "Landroid/graphics/Paint;", "mCropFramePaint", "mCropGridCenter", "mCropGridCorners", "mCropGridPaint", "mCropRectCornerTouchAreaLineLength", "mCropRectMinSize", "mCurrentTouchCornerIndex", "mDimmedColor", "getMDimmedColor", "setMDimmedColor", "mDimmedStrokePaint", "mFreestyleCropMode$annotations", "()V", "mPreviousTouchX", "", "mPreviousTouchY", "mTempRect", "mThisHeight", "mThisWidth", "mTouchPointThreshold", "overlayViewChangeListener", "Lcom/tencent/tkd/topicsdk/ucrop/callback/OverlayViewChangeListener;", "getOverlayViewChangeListener", "()Lcom/tencent/tkd/topicsdk/ucrop/callback/OverlayViewChangeListener;", "setOverlayViewChangeListener", "(Lcom/tencent/tkd/topicsdk/ucrop/callback/OverlayViewChangeListener;)V", "shouldSetupCropBounds", "getShouldSetupCropBounds", "setShouldSetupCropBounds", "showCropFrame", "getShowCropFrame", "setShowCropFrame", "showCropGrid", "getShowCropGrid", "setShowCropGrid", "targetAspectRatio", "drawCanvasCropGrid", "", "canvas", "Landroid/graphics/Canvas;", "drawCanvasCropViewRect", "drawCropGrid", "drawDimmedLayer", "getCurrentTouchIndex", "touchX", "touchY", "init", "initCropFrameStyle", "a", "Landroid/content/res/TypedArray;", "initCropGridStyle", "onDraw", "onLayout", "changed", "left", "top", "right", "bottom", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "processStyledAttributes", "setCropFrameColor", "color", "setCropFrameStrokeWidth", "width", "setCropGridColor", "setCropGridCornerColor", "setCropGridStrokeWidth", "setTargetAspectRatio", "setupCropBounds", "updateCropViewRect", "updateGridPoints", "Companion", "FreestyleMode", "topicsdk-ucrop_release"}, k=1, mv={1, 1, 16})
public final class OverlayView
  extends View
{
  public static final OverlayView.Companion a = new OverlayView.Companion(null);
  private int A = getResources().getDimensionPixelSize(R.dimen.c);
  @Nullable
  private OverlayViewChangeListener B;
  private boolean C;
  @NotNull
  private final RectF b = new RectF();
  private final RectF c = new RectF();
  private int d;
  private int e;
  private float[] f;
  private float[] g;
  private boolean h;
  private float[] i;
  @IntRange(from=0L)
  private int j;
  @IntRange(from=0L)
  private int k;
  private float l;
  private boolean m;
  private boolean n;
  @ColorInt
  private int o;
  private final Path p = new Path();
  private final Paint q = new Paint(1);
  private final Paint r = new Paint(1);
  private final Paint s = new Paint(1);
  private final Paint t = new Paint(1);
  private int u;
  private float v = -1.0F;
  private float w = -1.0F;
  private int x = -1;
  private int y = getResources().getDimensionPixelSize(R.dimen.d);
  private int z = getResources().getDimensionPixelSize(R.dimen.e);
  
  @JvmOverloads
  public OverlayView(@Nullable Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public OverlayView(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public OverlayView(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private final void a()
  {
    int i1 = this.d;
    float f1 = i1;
    float f2 = this.l;
    int i2 = (int)(f1 / f2);
    int i3 = this.e;
    if (i2 > i3)
    {
      i2 = (int)(i3 * f2);
      i1 = (i1 - i2) / 2;
      localObject = this.b;
      f1 = getPaddingLeft();
      f2 = i1;
      ((RectF)localObject).set(f1 + f2, getPaddingTop(), getPaddingLeft() + i2 + f2, getPaddingTop() + this.e);
    }
    else
    {
      i1 = (i3 - i2) / 2;
      localObject = this.b;
      f1 = getPaddingLeft();
      f2 = getPaddingTop();
      float f3 = i1;
      ((RectF)localObject).set(f1, f2 + f3, getPaddingLeft() + this.d, getPaddingTop() + i2 + f3);
    }
    Object localObject = this.B;
    if (localObject != null) {
      ((OverlayViewChangeListener)localObject).a(this.b);
    }
    b();
  }
  
  private final void a(float paramFloat1, float paramFloat2)
  {
    this.c.set(this.b);
    int i1 = this.x;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if (i1 == 4)
            {
              this.c.offset(paramFloat1 - this.v, paramFloat2 - this.w);
              if ((this.c.left > getLeft()) && (this.c.top > getTop()) && (this.c.right < getRight()) && (this.c.bottom < getBottom()))
              {
                this.b.set(this.c);
                b();
                postInvalidate();
              }
            }
          }
          else {
            this.c.set(paramFloat1, this.b.top, this.b.right, paramFloat2);
          }
        }
        else {
          this.c.set(this.b.left, this.b.top, paramFloat1, paramFloat2);
        }
      }
      else {
        this.c.set(this.b.left, paramFloat2, paramFloat1, this.b.bottom);
      }
    }
    else {
      this.c.set(paramFloat1, paramFloat2, this.b.right, this.b.bottom);
    }
    paramFloat1 = this.c.height();
    paramFloat2 = this.z;
    int i2 = 0;
    if (paramFloat1 >= paramFloat2) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (this.c.width() >= this.z) {
      i2 = 1;
    }
    RectF localRectF2 = this.b;
    if (i2 != 0) {
      paramFloat1 = this.c.left;
    } else {
      paramFloat1 = localRectF2.left;
    }
    RectF localRectF1;
    if (i1 != 0) {
      localRectF1 = this.c;
    } else {
      localRectF1 = this.b;
    }
    paramFloat2 = localRectF1.top;
    if (i2 != 0) {
      localRectF1 = this.c;
    } else {
      localRectF1 = this.b;
    }
    float f1 = localRectF1.right;
    if (i1 != 0) {
      localRectF1 = this.c;
    } else {
      localRectF1 = this.b;
    }
    localRectF2.set(paramFloat1, paramFloat2, f1, localRectF1.bottom);
    if ((i1 != 0) || (i2 != 0))
    {
      b();
      postInvalidate();
    }
  }
  
  private final void a(Canvas paramCanvas)
  {
    paramCanvas.save();
    if (this.n) {
      paramCanvas.clipPath(this.p, Region.Op.DIFFERENCE);
    } else {
      paramCanvas.clipRect(this.b, Region.Op.DIFFERENCE);
    }
    paramCanvas.drawColor(this.o);
    paramCanvas.restore();
    if (this.n) {
      paramCanvas.drawCircle(this.b.centerX(), this.b.centerY(), Math.min(this.b.width(), this.b.height()) / 2.0F, this.q);
    }
  }
  
  private final int b(float paramFloat1, float paramFloat2)
  {
    double d1 = this.y;
    int i1 = -1;
    int i2 = 0;
    while (i2 < 8)
    {
      double d2 = paramFloat1;
      float[] arrayOfFloat = this.f;
      if (arrayOfFloat == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mCropGridCorners");
      }
      double d3 = arrayOfFloat[i2];
      Double.isNaN(d2);
      Double.isNaN(d3);
      d2 = Math.pow(d2 - d3, 2.0D);
      d3 = paramFloat2;
      arrayOfFloat = this.f;
      if (arrayOfFloat == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mCropGridCorners");
      }
      double d4 = arrayOfFloat[(i2 + 1)];
      Double.isNaN(d3);
      Double.isNaN(d4);
      d3 = Math.sqrt(d2 + Math.pow(d3 - d4, 2.0D));
      d2 = d1;
      if (d3 < d1)
      {
        i1 = i2 / 2;
        d2 = d3;
      }
      i2 += 2;
      d1 = d2;
    }
    i2 = i1;
    if (this.u == 1)
    {
      i2 = i1;
      if (i1 < 0)
      {
        i2 = i1;
        if (this.b.contains(paramFloat1, paramFloat2)) {
          i2 = 4;
        }
      }
    }
    return i2;
  }
  
  private final void b()
  {
    this.f = RectUtils.a(this.b);
    this.g = RectUtils.b(this.b);
    this.i = ((float[])null);
    this.p.reset();
    this.p.addCircle(this.b.centerX(), this.b.centerY(), Math.min(this.b.width(), this.b.height()) / 2.0F, Path.Direction.CW);
  }
  
  private final void b(TypedArray paramTypedArray)
  {
    int i1 = paramTypedArray.getDimensionPixelSize(R.styleable.h, getResources().getDimensionPixelSize(R.dimen.a));
    int i2 = paramTypedArray.getColor(R.styleable.g, getResources().getColor(R.color.a));
    paramTypedArray = this.s;
    float f1 = i1;
    paramTypedArray.setStrokeWidth(f1);
    this.s.setColor(i2);
    this.s.setStyle(Paint.Style.STROKE);
    this.t.setStrokeWidth(f1 * 3);
    this.t.setColor(i2);
    this.t.setStyle(Paint.Style.STROKE);
  }
  
  private final void b(Canvas paramCanvas)
  {
    if (this.h) {
      c(paramCanvas);
    }
    if (this.m) {
      paramCanvas.drawRect(this.b, this.s);
    }
    if (this.u != 0) {
      d(paramCanvas);
    }
  }
  
  private final void c()
  {
    if (Build.VERSION.SDK_INT < 18) {
      setLayerType(1, null);
    }
  }
  
  private final void c(TypedArray paramTypedArray)
  {
    int i1 = paramTypedArray.getDimensionPixelSize(R.styleable.l, getResources().getDimensionPixelSize(R.dimen.b));
    int i2 = paramTypedArray.getColor(R.styleable.i, getResources().getColor(R.color.b));
    this.r.setStrokeWidth(i1);
    this.r.setColor(i2);
    setCropGridRowCount(paramTypedArray.getInt(R.styleable.k, 2));
    setCropGridColumnCount(paramTypedArray.getInt(R.styleable.j, 2));
  }
  
  private final void c(Canvas paramCanvas)
  {
    if ((this.i == null) && (!this.b.isEmpty()))
    {
      int i4 = this.j;
      arrayOfFloat = new float[i4 * 4 + this.k * 4];
      int i3 = 0;
      int i2 = 0;
      int i1 = 0;
      float f1;
      while (i2 < i4)
      {
        f1 = this.b.height() * ((i2 + 1.0F) / (this.j + 1)) + this.b.top;
        int i5 = i1 + 1;
        arrayOfFloat[i1] = this.b.left;
        i1 = i5 + 1;
        arrayOfFloat[i5] = f1;
        i5 = i1 + 1;
        arrayOfFloat[i1] = this.b.right;
        i1 = i5 + 1;
        arrayOfFloat[i5] = f1;
        i2 += 1;
      }
      i4 = this.k;
      i2 = i1;
      i1 = i3;
      while (i1 < i4)
      {
        f1 = this.b.width() * ((i1 + 1.0F) / (this.k + 1)) + this.b.left;
        i3 = i2 + 1;
        arrayOfFloat[i2] = f1;
        i2 = i3 + 1;
        arrayOfFloat[i3] = this.b.top;
        i3 = i2 + 1;
        arrayOfFloat[i2] = f1;
        i2 = i3 + 1;
        arrayOfFloat[i3] = this.b.bottom;
        i1 += 1;
      }
      this.i = arrayOfFloat;
    }
    float[] arrayOfFloat = this.i;
    if ((arrayOfFloat != null) && (arrayOfFloat != null)) {
      paramCanvas.drawLines(arrayOfFloat, this.r);
    }
  }
  
  private final void d(Canvas paramCanvas)
  {
    paramCanvas.save();
    this.c.set(this.b);
    RectF localRectF = this.c;
    int i1 = this.A;
    localRectF.inset(i1, -i1);
    paramCanvas.clipRect(this.c, Region.Op.DIFFERENCE);
    this.c.set(this.b);
    localRectF = this.c;
    i1 = this.A;
    localRectF.inset(-i1, i1);
    paramCanvas.clipRect(this.c, Region.Op.DIFFERENCE);
    paramCanvas.drawRect(this.b, this.t);
    paramCanvas.restore();
  }
  
  public final void a(@NotNull TypedArray paramTypedArray)
  {
    Intrinsics.checkParameterIsNotNull(paramTypedArray, "a");
    this.n = paramTypedArray.getBoolean(R.styleable.e, false);
    this.o = paramTypedArray.getColor(R.styleable.f, getResources().getColor(R.color.c));
    this.q.setColor(this.o);
    this.q.setStyle(Paint.Style.STROKE);
    this.q.setStrokeWidth(1.0F);
    b(paramTypedArray);
    this.m = paramTypedArray.getBoolean(R.styleable.m, true);
    c(paramTypedArray);
    this.h = paramTypedArray.getBoolean(R.styleable.n, true);
  }
  
  public final boolean getCircleDimmedLayer()
  {
    return this.n;
  }
  
  public final int getCropGridColumnCount()
  {
    return this.k;
  }
  
  public final int getCropGridRowCount()
  {
    return this.j;
  }
  
  @NotNull
  public final RectF getCropViewRect()
  {
    return this.b;
  }
  
  public final int getFreestyleCropMode()
  {
    return this.u;
  }
  
  public final int getMDimmedColor()
  {
    return this.o;
  }
  
  @Nullable
  public final OverlayViewChangeListener getOverlayViewChangeListener()
  {
    return this.B;
  }
  
  public final boolean getShouldSetupCropBounds()
  {
    return this.C;
  }
  
  public final boolean getShowCropFrame()
  {
    return this.m;
  }
  
  public final boolean getShowCropGrid()
  {
    return this.h;
  }
  
  protected void onDraw(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    a(paramCanvas);
    b(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) || (this.C))
    {
      paramInt1 = getPaddingLeft();
      paramInt2 = getPaddingTop();
      paramInt3 = getWidth();
      paramInt4 = getPaddingRight();
      int i1 = getHeight();
      int i2 = getPaddingBottom();
      this.d = (paramInt3 - paramInt4 - paramInt1);
      this.e = (i1 - i2 - paramInt2);
      if (this.C)
      {
        this.C = false;
        setTargetAspectRatio(this.l);
      }
    }
  }
  
  public boolean onTouchEvent(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "event");
    if (!this.b.isEmpty())
    {
      if (this.u == 0) {
        return false;
      }
      float f2 = paramMotionEvent.getX();
      float f1 = paramMotionEvent.getY();
      int i1 = paramMotionEvent.getAction();
      boolean bool = true;
      if ((i1 & 0xFF) == 0)
      {
        this.x = b(f2, f1);
        if (this.x == -1) {
          bool = false;
        }
        if (!bool)
        {
          this.v = -1.0F;
          this.w = -1.0F;
          return bool;
        }
        if (this.v < 0)
        {
          this.v = f2;
          this.w = f1;
        }
        return bool;
      }
      if (((paramMotionEvent.getAction() & 0xFF) == 2) && (paramMotionEvent.getPointerCount() == 1) && (this.x != -1))
      {
        f2 = Math.min(Math.max(f2, getPaddingLeft()), getWidth() - getPaddingRight());
        f1 = Math.min(Math.max(f1, getPaddingTop()), getHeight() - getPaddingBottom());
        a(f2, f1);
        this.v = f2;
        this.w = f1;
        return true;
      }
      if ((paramMotionEvent.getAction() & 0xFF) == 1)
      {
        this.v = -1.0F;
        this.w = -1.0F;
        this.x = -1;
        paramMotionEvent = this.B;
        if (paramMotionEvent != null) {
          paramMotionEvent.a(this.b);
        }
      }
    }
    return false;
  }
  
  public final void setCircleDimmedLayer(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public final void setCropFrameColor(@ColorInt int paramInt)
  {
    this.s.setColor(paramInt);
  }
  
  public final void setCropFrameStrokeWidth(@IntRange(from=0L) int paramInt)
  {
    this.s.setStrokeWidth(paramInt);
  }
  
  public final void setCropGridColor(@ColorInt int paramInt)
  {
    this.r.setColor(paramInt);
  }
  
  public final void setCropGridColumnCount(int paramInt)
  {
    this.k = paramInt;
    this.i = ((float[])null);
  }
  
  public final void setCropGridCornerColor(@ColorInt int paramInt)
  {
    this.t.setColor(paramInt);
  }
  
  public final void setCropGridRowCount(int paramInt)
  {
    this.j = paramInt;
    this.i = ((float[])null);
  }
  
  public final void setCropGridStrokeWidth(@IntRange(from=0L) int paramInt)
  {
    this.r.setStrokeWidth(paramInt);
  }
  
  public final void setFreestyleCropMode(int paramInt)
  {
    this.u = paramInt;
    postInvalidate();
  }
  
  public final void setMDimmedColor(int paramInt)
  {
    this.o = paramInt;
  }
  
  public final void setOverlayViewChangeListener(@Nullable OverlayViewChangeListener paramOverlayViewChangeListener)
  {
    this.B = paramOverlayViewChangeListener;
  }
  
  public final void setShouldSetupCropBounds(boolean paramBoolean)
  {
    this.C = paramBoolean;
  }
  
  public final void setShowCropFrame(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public final void setShowCropGrid(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public final void setTargetAspectRatio(float paramFloat)
  {
    this.l = paramFloat;
    if (this.d > 0)
    {
      a();
      postInvalidate();
      return;
    }
    this.C = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.ucrop.view.OverlayView
 * JD-Core Version:    0.7.0.1
 */