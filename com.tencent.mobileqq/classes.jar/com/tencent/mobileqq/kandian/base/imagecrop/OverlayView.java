package com.tencent.mobileqq.kandian.base.imagecrop;

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
import android.support.annotation.ColorInt;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.kandian.base.imagecrop.callback.OverlayViewChangeListener;
import com.tencent.mobileqq.kandian.base.imagecrop.util.RectUtils;

public class OverlayView
  extends View
{
  private OverlayViewChangeListener A;
  private boolean B;
  protected int a;
  protected int b;
  protected float[] c;
  protected float[] d;
  private final RectF e = new RectF();
  private final RectF f = new RectF();
  private int g;
  private int h;
  private float i;
  private float[] j = null;
  private boolean k;
  private boolean l;
  private boolean m;
  private int n;
  private Path o = new Path();
  private Paint p = new Paint(1);
  private Paint q = new Paint(1);
  private Paint r = new Paint(1);
  private Paint s = new Paint(1);
  private int t = 0;
  private float u = -1.0F;
  private float v = -1.0F;
  private int w = -1;
  private int x = getResources().getDimensionPixelSize(2131300004);
  private int y = getResources().getDimensionPixelSize(2131300005);
  private int z = getResources().getDimensionPixelSize(2131300003);
  
  public OverlayView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public OverlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public OverlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    this.f.set(this.e);
    int i1 = this.w;
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
              this.f.offset(paramFloat1 - this.u, paramFloat2 - this.v);
              if ((this.f.left > getLeft()) && (this.f.top > getTop()) && (this.f.right < getRight()) && (this.f.bottom < getBottom()))
              {
                this.e.set(this.f);
                b();
                postInvalidate();
              }
            }
          }
          else {
            this.f.set(paramFloat1, this.e.top, this.e.right, paramFloat2);
          }
        }
        else {
          this.f.set(this.e.left, this.e.top, paramFloat1, paramFloat2);
        }
      }
      else {
        this.f.set(this.e.left, paramFloat2, paramFloat1, this.e.bottom);
      }
    }
    else {
      this.f.set(paramFloat1, paramFloat2, this.e.right, this.e.bottom);
    }
    paramFloat1 = this.f.height();
    paramFloat2 = this.y;
    int i2 = 0;
    if (paramFloat1 >= paramFloat2) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (this.f.width() >= this.y) {
      i2 = 1;
    }
    RectF localRectF2 = this.e;
    if (i2 != 0) {
      paramFloat1 = this.f.left;
    } else {
      paramFloat1 = localRectF2.left;
    }
    RectF localRectF1;
    if (i1 != 0) {
      localRectF1 = this.f;
    } else {
      localRectF1 = this.e;
    }
    paramFloat2 = localRectF1.top;
    if (i2 != 0) {
      localRectF1 = this.f;
    } else {
      localRectF1 = this.e;
    }
    float f1 = localRectF1.right;
    if (i1 != 0) {
      localRectF1 = this.f;
    } else {
      localRectF1 = this.e;
    }
    localRectF2.set(paramFloat1, paramFloat2, f1, localRectF1.bottom);
    if ((i1 != 0) || (i2 != 0))
    {
      b();
      postInvalidate();
    }
  }
  
  private int b(float paramFloat1, float paramFloat2)
  {
    double d1 = this.x;
    int i2 = -1;
    int i1 = 0;
    while (i1 < 8)
    {
      double d3 = Math.sqrt(Math.pow(paramFloat1 - this.c[i1], 2.0D) + Math.pow(paramFloat2 - this.c[(i1 + 1)], 2.0D));
      double d2 = d1;
      if (d3 < d1)
      {
        i2 = i1 / 2;
        d2 = d3;
      }
      i1 += 2;
      d1 = d2;
    }
    if ((this.t == 1) && (i2 < 0) && (this.e.contains(paramFloat1, paramFloat2))) {
      return 4;
    }
    return i2;
  }
  
  private void b()
  {
    this.c = RectUtils.a(this.e);
    this.d = RectUtils.b(this.e);
    this.j = null;
    this.o.reset();
    this.o.addCircle(this.e.centerX(), this.e.centerY(), Math.min(this.e.width(), this.e.height()) / 2.0F, Path.Direction.CW);
  }
  
  private void b(@NonNull TypedArray paramTypedArray)
  {
    int i1 = paramTypedArray.getDimensionPixelSize(5, getResources().getDimensionPixelSize(2131300000));
    int i2 = paramTypedArray.getColor(4, getResources().getColor(2131168409));
    this.r.setStrokeWidth(i1);
    this.r.setColor(i2);
    this.r.setStyle(Paint.Style.STROKE);
    this.s.setStrokeWidth(i1 * 3);
    this.s.setColor(i2);
    this.s.setStyle(Paint.Style.STROKE);
  }
  
  private void c(@NonNull TypedArray paramTypedArray)
  {
    int i1 = paramTypedArray.getDimensionPixelSize(9, getResources().getDimensionPixelSize(2131300001));
    int i2 = paramTypedArray.getColor(6, getResources().getColor(2131168410));
    this.q.setStrokeWidth(i1);
    this.q.setColor(i2);
    this.g = paramTypedArray.getInt(8, 2);
    this.h = paramTypedArray.getInt(7, 2);
  }
  
  protected void a()
  {
    if (Build.VERSION.SDK_INT < 18) {
      setLayerType(1, null);
    }
  }
  
  protected void a(@NonNull TypedArray paramTypedArray)
  {
    this.m = paramTypedArray.getBoolean(2, false);
    this.n = paramTypedArray.getColor(3, getResources().getColor(2131168411));
    this.p.setColor(this.n);
    this.p.setStyle(Paint.Style.STROKE);
    this.p.setStrokeWidth(1.0F);
    b(paramTypedArray);
    this.k = paramTypedArray.getBoolean(10, true);
    c(paramTypedArray);
    this.l = paramTypedArray.getBoolean(11, true);
  }
  
  protected void a(@NonNull Canvas paramCanvas)
  {
    paramCanvas.save();
    if (this.m) {
      paramCanvas.clipPath(this.o, Region.Op.DIFFERENCE);
    } else {
      paramCanvas.clipRect(this.e, Region.Op.DIFFERENCE);
    }
    paramCanvas.drawColor(this.n);
    paramCanvas.restore();
    if (this.m) {
      paramCanvas.drawCircle(this.e.centerX(), this.e.centerY(), Math.min(this.e.width(), this.e.height()) / 2.0F, this.p);
    }
  }
  
  protected void b(@NonNull Canvas paramCanvas)
  {
    int i1;
    Object localObject;
    if (this.l)
    {
      if ((this.j == null) && (!this.e.isEmpty()))
      {
        this.j = new float[this.g * 4 + this.h * 4];
        int i5 = 0;
        int i2 = 0;
        int i3;
        int i4;
        float f1;
        float f2;
        for (i1 = 0;; i1 = i3 + 1)
        {
          i3 = i5;
          i4 = i1;
          if (i2 >= this.g) {
            break;
          }
          localObject = this.j;
          i3 = i1 + 1;
          localObject[i1] = this.e.left;
          localObject = this.j;
          i1 = i3 + 1;
          f1 = this.e.height();
          f2 = i2 + 1.0F;
          localObject[i3] = (f1 * (f2 / (this.g + 1)) + this.e.top);
          localObject = this.j;
          i3 = i1 + 1;
          localObject[i1] = this.e.right;
          this.j[i3] = (this.e.height() * (f2 / (this.g + 1)) + this.e.top);
          i2 += 1;
        }
        while (i3 < this.h)
        {
          localObject = this.j;
          i1 = i4 + 1;
          f1 = this.e.width();
          f2 = i3 + 1.0F;
          localObject[i4] = (f1 * (f2 / (this.h + 1)) + this.e.left);
          localObject = this.j;
          i2 = i1 + 1;
          localObject[i1] = this.e.top;
          localObject = this.j;
          i1 = i2 + 1;
          localObject[i2] = (this.e.width() * (f2 / (this.h + 1)) + this.e.left);
          localObject = this.j;
          i4 = i1 + 1;
          localObject[i1] = this.e.bottom;
          i3 += 1;
        }
      }
      localObject = this.j;
      if (localObject != null) {
        paramCanvas.drawLines((float[])localObject, this.q);
      }
    }
    if (this.k) {
      paramCanvas.drawRect(this.e, this.r);
    }
    if (this.t != 0)
    {
      paramCanvas.save();
      this.f.set(this.e);
      localObject = this.f;
      i1 = this.z;
      ((RectF)localObject).inset(i1, -i1);
      paramCanvas.clipRect(this.f, Region.Op.DIFFERENCE);
      this.f.set(this.e);
      localObject = this.f;
      i1 = this.z;
      ((RectF)localObject).inset(-i1, i1);
      paramCanvas.clipRect(this.f, Region.Op.DIFFERENCE);
      paramCanvas.drawRect(this.e, this.s);
      paramCanvas.restore();
    }
  }
  
  @NonNull
  public RectF getCropViewRect()
  {
    return this.e;
  }
  
  public int getFreestyleCropMode()
  {
    return this.t;
  }
  
  public OverlayViewChangeListener getOverlayViewChangeListener()
  {
    return this.A;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    a(paramCanvas);
    b(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      paramInt1 = getPaddingLeft();
      paramInt2 = getPaddingTop();
      paramInt3 = getWidth();
      paramInt4 = getPaddingRight();
      int i1 = getHeight();
      int i2 = getPaddingBottom();
      this.a = (paramInt3 - paramInt4 - paramInt1);
      this.b = (i1 - i2 - paramInt2);
      if (this.B)
      {
        this.B = false;
        setTargetAspectRatio(this.i);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = this.e.isEmpty();
    boolean bool1 = false;
    if (!bool2)
    {
      if (this.t == 0) {
        return false;
      }
      float f2 = paramMotionEvent.getX();
      float f1 = paramMotionEvent.getY();
      if ((paramMotionEvent.getAction() & 0xFF) == 0)
      {
        this.w = b(f2, f1);
        if (this.w != -1) {
          bool1 = true;
        }
        if (!bool1)
        {
          this.u = -1.0F;
          this.v = -1.0F;
          return bool1;
        }
        if (this.u < 0.0F)
        {
          this.u = f2;
          this.v = f1;
        }
        return bool1;
      }
      if (((paramMotionEvent.getAction() & 0xFF) == 2) && (paramMotionEvent.getPointerCount() == 1) && (this.w != -1))
      {
        f2 = Math.min(Math.max(f2, getPaddingLeft()), getWidth() - getPaddingRight());
        f1 = Math.min(Math.max(f1, getPaddingTop()), getHeight() - getPaddingBottom());
        a(f2, f1);
        this.u = f2;
        this.v = f1;
        return true;
      }
      if ((paramMotionEvent.getAction() & 0xFF) == 1)
      {
        this.u = -1.0F;
        this.v = -1.0F;
        this.w = -1;
        paramMotionEvent = this.A;
        if (paramMotionEvent != null) {
          paramMotionEvent.a(this.e);
        }
      }
    }
    return false;
  }
  
  public void setCircleDimmedLayer(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public void setCropFrameColor(@ColorInt int paramInt)
  {
    this.r.setColor(paramInt);
  }
  
  public void setCropFrameStrokeWidth(@IntRange(from=0L) int paramInt)
  {
    this.r.setStrokeWidth(paramInt);
  }
  
  public void setCropGridColor(@ColorInt int paramInt)
  {
    this.q.setColor(paramInt);
  }
  
  public void setCropGridColumnCount(@IntRange(from=0L) int paramInt)
  {
    this.h = paramInt;
    this.j = null;
  }
  
  public void setCropGridRowCount(@IntRange(from=0L) int paramInt)
  {
    this.g = paramInt;
    this.j = null;
  }
  
  public void setCropGridStrokeWidth(@IntRange(from=0L) int paramInt)
  {
    this.q.setStrokeWidth(paramInt);
  }
  
  public void setDimmedColor(@ColorInt int paramInt)
  {
    this.n = paramInt;
  }
  
  @Deprecated
  public void setFreestyleCropEnabled(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void setFreestyleCropMode(int paramInt)
  {
    this.t = paramInt;
    postInvalidate();
  }
  
  public void setOverlayViewChangeListener(OverlayViewChangeListener paramOverlayViewChangeListener)
  {
    this.A = paramOverlayViewChangeListener;
  }
  
  public void setShowCropFrame(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public void setShowCropGrid(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void setTargetAspectRatio(float paramFloat)
  {
    this.i = paramFloat;
    if (this.a > 0)
    {
      setupCropBounds();
      postInvalidate();
      return;
    }
    this.B = true;
  }
  
  public void setupCropBounds()
  {
    int i1 = this.a;
    float f1 = i1;
    float f2 = this.i;
    int i2 = (int)(f1 / f2);
    int i3 = this.b;
    if (i2 > i3)
    {
      i2 = (int)(i3 * f2);
      i1 = (i1 - i2) / 2;
      this.e.set(getPaddingLeft() + i1, getPaddingTop(), getPaddingLeft() + i2 + i1, getPaddingTop() + this.b);
    }
    else
    {
      i1 = (i3 - i2) / 2;
      this.e.set(getPaddingLeft(), getPaddingTop() + i1, getPaddingLeft() + this.a, getPaddingTop() + i2 + i1);
    }
    OverlayViewChangeListener localOverlayViewChangeListener = this.A;
    if (localOverlayViewChangeListener != null) {
      localOverlayViewChangeListener.a(this.e);
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.imagecrop.OverlayView
 * JD-Core Version:    0.7.0.1
 */