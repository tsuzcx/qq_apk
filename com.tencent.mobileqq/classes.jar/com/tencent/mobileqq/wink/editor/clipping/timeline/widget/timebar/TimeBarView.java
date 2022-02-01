package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timebar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;
import androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.BaseTimelineViewController;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.ITimelineView;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scale.ScaleCalculator;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scale.ScalePoint;
import com.tencent.videocut.utils.DensityUtils;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/timebar/TimeBarView;", "Landroid/view/View;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/ITimelineView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "listener", "Landroidx/dynamicanimation/animation/DynamicAnimation$OnAnimationUpdateListener;", "maxDurationLimit", "", "getMaxDurationLimit", "()J", "setMaxDurationLimit", "(J)V", "maxDurationLimitTip", "", "getMaxDurationLimitTip", "()Ljava/lang/String;", "setMaxDurationLimitTip", "(Ljava/lang/String;)V", "onScrollGestureListener", "Landroid/view/GestureDetector$OnGestureListener;", "paint", "Landroid/graphics/Paint;", "pointSize", "redPaint", "scrollGestureDetector", "Landroid/view/GestureDetector;", "getScrollGestureDetector", "()Landroid/view/GestureDetector;", "scrollGestureDetector$delegate", "Lkotlin/Lazy;", "scroller", "Landroid/widget/Scroller;", "singleTextSize", "", "textColor", "textSize", "timeBarStatX", "timelineViewController", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/timebar/TimeBarViewController;", "tipPaint", "bindController", "", "controller", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/BaseTimelineViewController;", "computeScroll", "drawText", "canvas", "Landroid/graphics/Canvas;", "scaleCalculator", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scale/ScaleCalculator;", "getTimeBarStatX", "maxCanScrollX", "onDraw", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "resetPaint", "setTextColor", "setTextSize", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class TimeBarView
  extends View
  implements ITimelineView
{
  public static final TimeBarView.Companion a = new TimeBarView.Companion(null);
  private int b;
  private float c;
  private int d = 3;
  private int e = getResources().getDimensionPixelSize(2131299832);
  private int f = -1;
  private final Paint g = new Paint();
  private final Paint h = new Paint();
  private final Paint i = new Paint();
  private Scroller j;
  private TimeBarViewController k;
  private long l = 2147483647;
  @NotNull
  private String m = "";
  private final DynamicAnimation.OnAnimationUpdateListener n;
  private final GestureDetector.OnGestureListener o;
  private final Lazy p;
  
  @JvmOverloads
  public TimeBarView(@Nullable Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public TimeBarView(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public TimeBarView(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.j = new Scroller(paramContext);
    this.n = ((DynamicAnimation.OnAnimationUpdateListener)new TimeBarView.listener.1(this));
    this.o = ((GestureDetector.OnGestureListener)new TimeBarView.onScrollGestureListener.1(this));
    this.p = LazyKt.lazy((Function0)new TimeBarView.scrollGestureDetector.2(this, paramContext));
  }
  
  private final void a()
  {
    this.g.setColor(this.f);
    this.g.setStrokeWidth(1.0F);
    this.g.setTextSize(this.e);
    this.g.setAntiAlias(true);
    this.h.setColor(getResources().getColor(2131165775));
    this.h.setStrokeWidth(1.0F);
    this.h.setTextSize(this.e);
    this.h.setAntiAlias(true);
    this.i.setColor(getResources().getColor(2131165775));
    this.i.setStrokeWidth(1.0F);
    this.i.setTextSize(this.e);
    this.i.setAntiAlias(true);
  }
  
  private final void a(Canvas paramCanvas, ScaleCalculator paramScaleCalculator)
  {
    int i2 = paramScaleCalculator.a().size();
    int i1 = getHeight() / 2;
    Object localObject = this.g.getFontMetrics();
    float f2 = i1;
    float f1 = ((Paint.FontMetrics)localObject).bottom;
    float f4 = ((Paint.FontMetrics)localObject).top;
    float f3 = 2;
    f1 = (f1 - f4) / f3 + f2 - ((Paint.FontMetrics)localObject).bottom;
    localObject = (ScalePoint)null;
    i1 = 0;
    float f5;
    while (i1 < i2)
    {
      ScalePoint localScalePoint = (ScalePoint)paramScaleCalculator.a().get(i1);
      f4 = this.b + paramScaleCalculator.b() * localScalePoint.a();
      if (this.c == 0.0F) {
        this.c = this.g.measureText("M");
      }
      f5 = this.c * 5;
      if ((f4 >= getScrollX() - f5) && (f4 <= getScrollX() + getWidth() + f5)) {
        if (localScalePoint.b() == 1)
        {
          paramCanvas.drawCircle(f4, f2, this.d, this.g);
        }
        else if (localScalePoint.b() == 0)
        {
          String str = paramScaleCalculator.a(localScalePoint);
          if (!TextUtils.isEmpty((CharSequence)str))
          {
            f5 = this.g.measureText(str);
            if (paramScaleCalculator.b(localScalePoint) == this.l)
            {
              if (i1 < i2 - 1) {
                localObject = (ScalePoint)paramScaleCalculator.a().get(i1);
              }
              paramCanvas.drawText(str, 0, str.length(), f4 - f5 / f3, f1, this.h);
              break;
            }
            paramCanvas.drawText(str, 0, str.length(), f4 - f5 / f3, f1, this.g);
          }
        }
      }
      i1 += 1;
    }
    if (localObject != null)
    {
      f2 = this.b;
      f3 = paramScaleCalculator.b();
      f4 = ((ScalePoint)localObject).a();
      f5 = DensityUtils.a.a(18.0F);
      if (!TextUtils.isEmpty((CharSequence)this.m))
      {
        i1 = this.m.length();
        paramCanvas.drawText(this.m, 0, i1, f2 + f3 * f4 + f5, f1, this.i);
      }
    }
  }
  
  private final int b()
  {
    Object localObject = this.k;
    if (localObject != null)
    {
      localObject = ((TimeBarViewController)localObject).a();
      if (localObject != null) {
        return ((ScaleCalculator)localObject).d();
      }
    }
    return 0;
  }
  
  private final GestureDetector getScrollGestureDetector()
  {
    return (GestureDetector)this.p.getValue();
  }
  
  private final int getTimeBarStatX()
  {
    return getMeasuredWidth() / 2;
  }
  
  public void a(@NotNull BaseTimelineViewController<?> paramBaseTimelineViewController)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseTimelineViewController, "controller");
    BaseTimelineViewController<?> localBaseTimelineViewController = paramBaseTimelineViewController;
    if (!(paramBaseTimelineViewController instanceof TimeBarViewController)) {
      localBaseTimelineViewController = null;
    }
    this.k = ((TimeBarViewController)localBaseTimelineViewController);
  }
  
  public void computeScroll()
  {
    Scroller localScroller = this.j;
    if ((localScroller != null) && (localScroller.computeScrollOffset()))
    {
      scrollTo(localScroller.getCurrX(), localScroller.getCurrY());
      postInvalidate();
    }
    super.computeScroll();
  }
  
  public final long getMaxDurationLimit()
  {
    return this.l;
  }
  
  @NotNull
  public final String getMaxDurationLimitTip()
  {
    return this.m;
  }
  
  protected void onDraw(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    Object localObject = this.k;
    if (localObject != null)
    {
      localObject = ((TimeBarViewController)localObject).a();
      if (localObject != null)
      {
        a();
        if (this.b == 0) {
          this.b = getTimeBarStatX();
        }
        a(paramCanvas, (ScaleCalculator)localObject);
      }
    }
  }
  
  public boolean onTouchEvent(@Nullable MotionEvent paramMotionEvent)
  {
    return getScrollGestureDetector().onTouchEvent(paramMotionEvent);
  }
  
  public final void setMaxDurationLimit(long paramLong)
  {
    this.l = paramLong;
  }
  
  public final void setMaxDurationLimitTip(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.m = paramString;
  }
  
  public final void setTextColor(int paramInt)
  {
    this.f = paramInt;
  }
  
  public final void setTextSize(int paramInt)
  {
    this.e = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timebar.TimeBarView
 * JD-Core Version:    0.7.0.1
 */