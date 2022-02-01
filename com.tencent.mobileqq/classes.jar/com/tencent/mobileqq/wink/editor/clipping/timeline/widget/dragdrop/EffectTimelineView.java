package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scale.ScaleCalculator;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timeline.ITimelineListener;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timeline.TimelineView;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/EffectTimelineView;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/timeline/TimelineView;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/IDragView;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/timeline/ITimelineListener;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/IDragDropScrollListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "dragModel", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragModel;", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragModel;)V", "currentScrollDistance", "downEndPosition", "dragViewModel", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragViewModel;", "getDragViewModel", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragViewModel;", "setDragViewModel", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragViewModel;)V", "innerScaleCalculator", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scale/ScaleCalculator;", "getInnerScaleCalculator", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scale/ScaleCalculator;", "setInnerScaleCalculator", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scale/ScaleCalculator;)V", "isDragging", "", "()Z", "setDragging", "(Z)V", "lastEndPosition", "lastMoveX", "", "lastStartPosition", "minDuration", "", "selectedState", "startTouchPoint", "Landroid/graphics/PointF;", "getStartTouchPoint", "()Landroid/graphics/PointF;", "setStartTouchPoint", "(Landroid/graphics/PointF;)V", "timelineViewListener", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/TimelineViewListener;", "getTimelineViewListener", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/TimelineViewListener;", "setTimelineViewListener", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/TimelineViewListener;)V", "valueChangeListener", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/IValueChangeListener;", "allowOverLap", "calMinDistance", "canEndPositionOverMaxSpace", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "getEndPosition", "getMaxEndPosition", "getMaxEndPositionForDrag", "getMaxEndTime", "getMaxEndTimeForDrag", "getMinDistance", "getMinStartPosition", "getMinStartTime", "getStartPosition", "handleChangeSlideDirectionWhenScrolling", "", "listener", "moveX", "handleLeftSliderMove", "handleRightSliderMove", "handleSliderMoveEnd", "isLeft", "leftSpace", "needBringToFrontOnSelected", "needChangePositionOnDrop", "onPositionChanged", "onScrollChanged", "scrollView", "Landroid/view/View;", "x", "y", "oldX", "oldY", "onScrollStopped", "onSliderDown", "rawX", "onSliderMoveEnd", "onSliderMoving", "startEvent", "endEvent", "left", "rightSpace", "setScaleCalculator", "scaleCalculator", "setSelected", "selected", "setValueChangeListener", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
@SuppressLint({"ViewConstructor"})
public class EffectTimelineView
  extends TimelineView
  implements IDragDropScrollListener, IDragView, ITimelineListener
{
  public static final EffectTimelineView.Companion a = new EffectTimelineView.Companion(null);
  private static long p = 100000L;
  private int c;
  private int d;
  private int e;
  @Nullable
  private ScaleCalculator f;
  private IValueChangeListener g;
  @Nullable
  private TimelineViewListener h;
  private boolean i;
  private float j;
  private int k;
  private long l = p;
  @Nullable
  private PointF m;
  @NotNull
  private DragViewModel n = new DragViewModel(paramDragModel.a(), 0, 0, 0L, 0, paramDragModel.f(), this.f, 30, null);
  private boolean o;
  
  @JvmOverloads
  public EffectTimelineView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt, @NotNull DragModel paramDragModel)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setTimelineListener((ITimelineListener)this);
  }
  
  private final void a(IValueChangeListener paramIValueChangeListener, float paramFloat)
  {
    paramIValueChangeListener.a(this.n.c() - this.e, false, (View)this, false);
    this.j = paramFloat;
  }
  
  private final boolean h()
  {
    return true;
  }
  
  private final int i()
  {
    ScaleCalculator localScaleCalculator = this.f;
    if (localScaleCalculator != null) {
      return localScaleCalculator.b(this.l);
    }
    return 0;
  }
  
  public int a()
  {
    return getContentMargin();
  }
  
  protected void a(float paramFloat)
  {
    super.a(paramFloat);
    setDragging(true);
    IValueChangeListener localIValueChangeListener = this.g;
    if (localIValueChangeListener != null)
    {
      if ((paramFloat < this.j) && (localIValueChangeListener.a()))
      {
        a(localIValueChangeListener, paramFloat);
        return;
      }
      if ((paramFloat > this.j) && (localIValueChangeListener.b()))
      {
        a(localIValueChangeListener, paramFloat);
        return;
      }
      int i1 = MathKt.roundToInt(paramFloat - this.j);
      this.k += i1;
      Pair localPair = localIValueChangeListener.a((View)this, this.c + this.k, i1);
      if (((Boolean)localPair.getFirst()).booleanValue())
      {
        this.n = DragViewModel.a(this.n, null, ((Number)localPair.getSecond()).intValue(), 0, 0L, 0, null, null, 125, null);
        localIValueChangeListener.a((IDragView)this);
      }
      this.j = paramFloat;
    }
  }
  
  public void a(float paramFloat, boolean paramBoolean) {}
  
  public void a(@Nullable View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void a(@NotNull DragModel paramDragModel)
  {
    Intrinsics.checkParameterIsNotNull(paramDragModel, "dragModel");
    IDragView.DefaultImpls.a(this, paramDragModel);
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    this.j = 0.0F;
  }
  
  public int b()
  {
    return getContentMargin();
  }
  
  protected void b(float paramFloat)
  {
    super.b(paramFloat);
    setDragging(true);
    IValueChangeListener localIValueChangeListener = this.g;
    if (localIValueChangeListener != null)
    {
      if ((paramFloat < this.j) && (localIValueChangeListener.a()))
      {
        a(localIValueChangeListener, paramFloat);
        return;
      }
      if ((paramFloat > this.j) && (localIValueChangeListener.b()))
      {
        a(localIValueChangeListener, paramFloat);
        return;
      }
      int i1 = MathKt.roundToInt(paramFloat - this.j);
      this.k += i1;
      i1 = localIValueChangeListener.b((View)this, this.d + this.k, i1);
      if (i1 >= 0)
      {
        this.n = DragViewModel.a(this.n, null, 0, i1, 0L, 0, null, null, 123, null);
        localIValueChangeListener.a((IDragView)this);
      }
      this.j = paramFloat;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject = this.g;
    if (localObject != null) {
      ((IValueChangeListener)localObject).a(this.n.c() - this.e, true, (View)this, paramBoolean);
    }
    localObject = this.h;
    if (localObject != null) {
      ((TimelineViewListener)localObject).a(this.n.a(), paramBoolean);
    }
    if (h()) {
      bringToFront();
    }
    setDragging(false);
    this.e = 0;
  }
  
  public void c()
  {
    this.c = this.n.b();
    this.d = this.n.c();
    this.k = 0;
  }
  
  public void c(float paramFloat)
  {
    this.c = this.n.b();
    this.d = this.n.c();
    this.e = this.n.c();
    this.k = 0;
    this.j = paramFloat;
    IValueChangeListener localIValueChangeListener = this.g;
    if (localIValueChangeListener != null) {
      localIValueChangeListener.c();
    }
  }
  
  public void d()
  {
    TimelineViewListener localTimelineViewListener = this.h;
    if (localTimelineViewListener != null) {
      localTimelineViewListener.a(this.n.a());
    }
  }
  
  public boolean dispatchTouchEvent(@Nullable MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent != null) && (paramMotionEvent.getAction() == 0)) {
      setStartTouchPoint(new PointF(paramMotionEvent.getX(), paramMotionEvent.getY()));
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean e()
  {
    return true;
  }
  
  public boolean f()
  {
    return true;
  }
  
  public int g()
  {
    return IDragView.DefaultImpls.a(this);
  }
  
  @NotNull
  public final DragViewModel getDragViewModel()
  {
    return this.n;
  }
  
  public int getEndPosition()
  {
    return this.n.c();
  }
  
  @Nullable
  protected final ScaleCalculator getInnerScaleCalculator()
  {
    return this.f;
  }
  
  public int getLength()
  {
    return IDragView.DefaultImpls.b(this);
  }
  
  public int getMaxEndPosition()
  {
    ScaleCalculator localScaleCalculator = this.f;
    if (localScaleCalculator != null) {
      return localScaleCalculator.b(getMaxEndTime());
    }
    return -1;
  }
  
  public int getMaxEndPositionForDrag()
  {
    ScaleCalculator localScaleCalculator = this.f;
    if (localScaleCalculator != null) {
      return localScaleCalculator.b(getMaxEndTimeForDrag());
    }
    return -1;
  }
  
  public long getMaxEndTime()
  {
    return -1L;
  }
  
  public long getMaxEndTimeForDrag()
  {
    return getMaxEndTime();
  }
  
  public int getMinDistance()
  {
    return i();
  }
  
  public int getMinStartPosition()
  {
    ScaleCalculator localScaleCalculator = this.f;
    if (localScaleCalculator != null) {
      return localScaleCalculator.b(getMinStartTime());
    }
    return -1;
  }
  
  public long getMinStartTime()
  {
    return -1L;
  }
  
  public int getStartPosition()
  {
    return this.n.b();
  }
  
  @Nullable
  public PointF getStartTouchPoint()
  {
    return this.m;
  }
  
  @Nullable
  public final TimelineViewListener getTimelineViewListener()
  {
    return this.h;
  }
  
  public int getTrackType()
  {
    return IDragView.DefaultImpls.c(this);
  }
  
  public final void setDragViewModel(@NotNull DragViewModel paramDragViewModel)
  {
    Intrinsics.checkParameterIsNotNull(paramDragViewModel, "<set-?>");
    this.n = paramDragViewModel;
  }
  
  public void setDragging(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  protected final void setInnerScaleCalculator(@Nullable ScaleCalculator paramScaleCalculator)
  {
    this.f = paramScaleCalculator;
  }
  
  public void setScaleCalculator(@Nullable ScaleCalculator paramScaleCalculator)
  {
    this.f = paramScaleCalculator;
  }
  
  public void setSelected(boolean paramBoolean)
  {
    super.setSelected(paramBoolean);
    if ((paramBoolean) && (h())) {
      bringToFront();
    }
    if (this.i == paramBoolean) {
      return;
    }
    this.i = paramBoolean;
    Object localObject = this.g;
    if (localObject != null) {
      ((IValueChangeListener)localObject).a((IDragView)this, paramBoolean);
    }
    localObject = this.h;
    if (localObject != null) {
      ((TimelineViewListener)localObject).a(paramBoolean, (View)this);
    }
  }
  
  public void setStartTouchPoint(@Nullable PointF paramPointF)
  {
    this.m = paramPointF;
  }
  
  public final void setTimelineViewListener(@Nullable TimelineViewListener paramTimelineViewListener)
  {
    this.h = paramTimelineViewListener;
  }
  
  public void setValueChangeListener(@Nullable IValueChangeListener paramIValueChangeListener)
  {
    this.g = paramIValueChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.EffectTimelineView
 * JD-Core Version:    0.7.0.1
 */