package com.tencent.xaction.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.base.DecorView;
import com.tencent.xaction.api.util.ScreenUnit;
import com.tencent.xaction.api.util.ScreenUnit.Companion;
import com.tencent.xaction.log.QLog;
import com.tencent.xaction.openapi.api.IXAEngine;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/view/XAScratchView;", "Landroid/view/View;", "Lcom/tencent/xaction/api/IView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "COVER_MARGIN_CENTER", "", "STROKE_WIDTH", "", "TAG", "", "decor", "Lcom/tencent/xaction/api/base/DecorView;", "getDecor", "()Lcom/tencent/xaction/api/base/DecorView;", "setDecor", "(Lcom/tencent/xaction/api/base/DecorView;)V", "mPaint", "Landroid/graphics/Paint;", "mPath", "Landroid/graphics/Path;", "mProgress", "mScratchListener", "Lcom/tencent/xaction/view/XAScratchView$OnScratchListener;", "computeProgress", "init", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "setOnScratchListener", "listener", "OnScratchListener", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class XAScratchView
  extends View
  implements IView
{
  @NotNull
  private DecorView a = (DecorView)new XAScratchView.decor.1(this, (IView)this);
  private final String b = "XAScratchView";
  private final float c = 200.0F;
  private Path d;
  private Paint e;
  private XAScratchView.OnScratchListener f;
  private float g = 1.0F;
  private final int h = 315;
  
  public XAScratchView(@Nullable Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  private final void a()
  {
    setLayerType(1, null);
    this.e = new Paint();
    Paint localPaint = this.e;
    if (localPaint == null) {
      Intrinsics.throwNpe();
    }
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint = this.e;
    if (localPaint == null) {
      Intrinsics.throwNpe();
    }
    localPaint.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    localPaint = this.e;
    if (localPaint == null) {
      Intrinsics.throwNpe();
    }
    localPaint.setAntiAlias(true);
    localPaint = this.e;
    if (localPaint == null) {
      Intrinsics.throwNpe();
    }
    localPaint.setDither(true);
    localPaint = this.e;
    if (localPaint == null) {
      Intrinsics.throwNpe();
    }
    localPaint.setStrokeJoin(Paint.Join.ROUND);
    localPaint = this.e;
    if (localPaint == null) {
      Intrinsics.throwNpe();
    }
    localPaint.setStrokeCap(Paint.Cap.ROUND);
    localPaint = this.e;
    if (localPaint == null) {
      Intrinsics.throwNpe();
    }
    localPaint.setStrokeWidth(this.c);
    this.d = new Path();
  }
  
  private final float b()
  {
    Object localObject1 = new RectF();
    Object localObject2 = this.d;
    if (localObject2 != null) {
      ((Path)localObject2).computeBounds((RectF)localObject1, true);
    }
    float f1 = (((RectF)localObject1).height() + this.c) * (((RectF)localObject1).width() + this.c);
    int i = getMeasuredWidth() * getMeasuredHeight();
    float f2 = f1 / i;
    localObject1 = this.b;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("rate=");
    ((StringBuilder)localObject2).append(f2);
    ((StringBuilder)localObject2).append(" drawArea=");
    ((StringBuilder)localObject2).append(f1);
    ((StringBuilder)localObject2).append(",totalArea=");
    ((StringBuilder)localObject2).append(i);
    QLog.a((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    return f2;
  }
  
  @NotNull
  public DecorView getDecor()
  {
    return this.a;
  }
  
  protected void onDraw(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    Path localPath = this.d;
    if (localPath == null) {
      Intrinsics.throwNpe();
    }
    Paint localPaint = this.e;
    if (localPaint == null) {
      Intrinsics.throwNpe();
    }
    paramCanvas.drawPath(localPath, localPaint);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    Object localObject = getLayoutParams();
    if (localObject != null)
    {
      localObject = (RelativeLayout.LayoutParams)localObject;
      ViewParent localViewParent = getParent();
      if (localViewParent != null)
      {
        ((RelativeLayout.LayoutParams)localObject).topMargin = (((ViewGroup)localViewParent).getHeight() / 2 - ScreenUnit.a.a(this.h));
        invalidate();
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
    }
    throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
  }
  
  public boolean onTouchEvent(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "event");
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (paramMotionEvent.getAction() == 0)
    {
      paramMotionEvent = this.d;
      if (paramMotionEvent == null) {
        Intrinsics.throwNpe();
      }
      paramMotionEvent.moveTo(f1, f2);
      invalidate();
      return true;
    }
    if (paramMotionEvent.getAction() == 2)
    {
      paramMotionEvent = this.d;
      if (paramMotionEvent == null) {
        Intrinsics.throwNpe();
      }
      paramMotionEvent.lineTo(f1, f2);
      invalidate();
      return true;
    }
    if ((paramMotionEvent.getAction() == 1) && (b() >= this.g))
    {
      IXAEngine localIXAEngine = getDecor().d();
      if (localIXAEngine != null) {
        localIXAEngine.notifyMonitor("$GIFT_OVER_ANIM", "start");
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setDecor(@NotNull DecorView paramDecorView)
  {
    Intrinsics.checkParameterIsNotNull(paramDecorView, "<set-?>");
    this.a = paramDecorView;
  }
  
  public final void setOnScratchListener(@NotNull XAScratchView.OnScratchListener paramOnScratchListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnScratchListener, "listener");
    this.f = paramOnScratchListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.view.XAScratchView
 * JD-Core Version:    0.7.0.1
 */