package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel;

import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.BaseTimelineViewController;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.config.CommonConfig;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.config.ScrollConfig;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.config.TimeBarConfig;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.PanelEvent;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.PanelEventHandler;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.PanelScrollEvent;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.VideoScaleEvent;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scale.ScaleCalculator;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scale.ScaleCalculator.IScaleView;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scroll.FlingHelper;
import com.tencent.videocut.utils.DensityUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/TimelinePanelViewController;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scale/ScaleCalculator$IScaleView;", "()V", "childViewModelList", "", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/BaseTimelineViewController;", "config", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/config/CommonConfig;", "currentScrollX", "", "flingHelper", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scroll/FlingHelper;", "isUserTouching", "", "minClipDuration", "", "panel", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/TimelinePanel;", "panelEventHandler", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/PanelEventHandler;", "presetX", "scaleCalculator", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scale/ScaleCalculator;", "getScaleCalculator", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scale/ScaleCalculator;", "scrollRunnable", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/TimelinePanelViewController$ScrollRunnable;", "abortScrollRunnable", "", "addChildController", "timelineViewController", "addChildView", "controller", "addChildView$qq_wink_impl_release", "bindPanel", "view", "getConfig", "getCurrentScrollX", "getFlingHelper", "getMinWidth", "getPanelEventHandler", "notifyAttractPointSetChanged", "notifyAttractPointSetChanged$qq_wink_impl_release", "notifyConfigChange", "notifyWidthRefresh", "scaleAllChildView", "scaleFactor", "", "scrollAllChildTo", "position", "caller", "", "scrollXTo", "x", "setConfig", "setMinClipDuration", "smoothScrollTo", "timeUs", "startScroll", "stopScroll", "updateCourseVisibility", "visible", "updateCurrentTime", "updateMaxEndTime", "endTimeUs", "updateUseTouching", "ev", "Landroid/view/MotionEvent;", "updateUseTouching$qq_wink_impl_release", "Companion", "ScrollRunnable", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class TimelinePanelViewController
  implements ScaleCalculator.IScaleView
{
  public static final TimelinePanelViewController.Companion a = new TimelinePanelViewController.Companion(null);
  private CommonConfig b = new CommonConfig(null, null, null, null, 15, null);
  private TimelinePanel c;
  @NotNull
  private final ScaleCalculator d;
  private final List<BaseTimelineViewController<?>> e;
  private int f;
  private int g;
  private final PanelEventHandler h;
  private boolean i;
  private final FlingHelper j;
  private final TimelinePanelViewController.ScrollRunnable k;
  private long l;
  
  public TimelinePanelViewController()
  {
    ScaleCalculator localScaleCalculator = new ScaleCalculator();
    localScaleCalculator.a((ScaleCalculator.IScaleView)this);
    this.d = localScaleCalculator;
    this.e = ((List)new ArrayList());
    this.g = -1;
    this.h = new PanelEventHandler();
    this.j = new FlingHelper();
    this.k = new TimelinePanelViewController.ScrollRunnable(this);
    f();
  }
  
  private final void b(int paramInt)
  {
    TimelinePanel localTimelinePanel = this.c;
    if (localTimelinePanel != null)
    {
      localTimelinePanel.removeCallbacks((Runnable)this.k);
      if (paramInt > 0) {
        this.k.a(paramInt);
      }
      ViewCompat.postOnAnimationDelayed((View)localTimelinePanel, (Runnable)this.k, 10L);
    }
  }
  
  private final void j()
  {
    TimelinePanel localTimelinePanel = this.c;
    if (localTimelinePanel != null) {
      localTimelinePanel.removeCallbacks((Runnable)this.k);
    }
    a(this.g);
  }
  
  @NotNull
  public final ScaleCalculator a()
  {
    return this.d;
  }
  
  public final void a(float paramFloat)
  {
    this.d.e(paramFloat * paramFloat);
    Iterator localIterator = ((Iterable)this.e).iterator();
    while (localIterator.hasNext()) {
      ((BaseTimelineViewController)localIterator.next()).j();
    }
    this.h.a((PanelEvent)new VideoScaleEvent());
  }
  
  public void a(int paramInt)
  {
    a(paramInt, this);
  }
  
  public final void a(int paramInt, @Nullable Object paramObject)
  {
    if (this.f == paramInt) {
      return;
    }
    this.f = paramInt;
    e();
    Object localObject2 = (Iterable)this.e;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    boolean bool1;
    for (;;)
    {
      boolean bool2 = ((Iterator)localObject2).hasNext();
      bool1 = true;
      paramInt = 1;
      if (!bool2) {
        break;
      }
      Object localObject3 = ((Iterator)localObject2).next();
      if ((BaseTimelineViewController)localObject3 == paramObject) {
        paramInt = 0;
      }
      if (paramInt != 0) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((BaseTimelineViewController)((Iterator)localObject1).next()).a(this.f);
    }
    localObject1 = this.h;
    long l1 = this.d.e();
    if (paramObject == (TimelinePanelViewController)this) {
      bool1 = false;
    }
    ((PanelEventHandler)localObject1).a((PanelEvent)new PanelScrollEvent(l1, bool1));
  }
  
  public final void a(long paramLong)
  {
    if (!this.i)
    {
      if (this.j.a()) {
        return;
      }
      int m = this.d.b(paramLong);
      int n = this.f;
      if (n == m) {
        return;
      }
      if (n < this.g)
      {
        j();
        this.f = this.g;
      }
      this.g = m;
      n = this.f;
      int i1 = this.g;
      if (n < i1)
      {
        b(m - n);
        return;
      }
      if (n > i1) {
        a(i1);
      }
    }
  }
  
  public final void a(@Nullable MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent != null) {
      paramMotionEvent = Integer.valueOf(paramMotionEvent.getActionMasked());
    } else {
      paramMotionEvent = null;
    }
    if ((paramMotionEvent != null) && (paramMotionEvent.intValue() == 0))
    {
      this.j.b();
      this.i = true;
      return;
    }
    if ((paramMotionEvent == null) || (paramMotionEvent.intValue() != 3))
    {
      if (paramMotionEvent == null) {
        return;
      }
      if (paramMotionEvent.intValue() != 1) {}
    }
    else
    {
      this.i = false;
    }
  }
  
  public final void a(@NotNull BaseTimelineViewController<?> paramBaseTimelineViewController)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseTimelineViewController, "timelineViewController");
    this.e.add(paramBaseTimelineViewController);
    paramBaseTimelineViewController.a((TimelinePanelViewController)this);
  }
  
  public final void a(@NotNull CommonConfig paramCommonConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramCommonConfig, "config");
    this.b = paramCommonConfig;
  }
  
  @RequiresApi(21)
  public final void a(@NotNull TimelinePanel paramTimelinePanel)
  {
    Intrinsics.checkParameterIsNotNull(paramTimelinePanel, "view");
    this.c = paramTimelinePanel;
    paramTimelinePanel.a(this);
  }
  
  public final void a(boolean paramBoolean)
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = ((TimelinePanel)localObject).getCourseView();
      if (localObject != null)
      {
        int m;
        if (paramBoolean) {
          m = 0;
        } else {
          m = 4;
        }
        ((View)localObject).setVisibility(m);
      }
    }
  }
  
  public int b()
  {
    return this.f;
  }
  
  public final void b(long paramLong)
  {
    if (this.d.c() == paramLong) {
      return;
    }
    if (paramLong >= 60000000)
    {
      long l1 = this.l;
      if (l1 != 0L) {
        if ((l1 > 2000000) && (l1 < 5000000)) {
          this.d.a(8);
        } else if (this.l >= 5000000) {
          this.d.a(9);
        }
      }
    }
    this.d.a(paramLong);
    Iterator localIterator = ((Iterable)this.e).iterator();
    while (localIterator.hasNext()) {
      ((BaseTimelineViewController)localIterator.next()).h();
    }
  }
  
  @RequiresApi(21)
  public final void b(@NotNull BaseTimelineViewController<?> paramBaseTimelineViewController)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseTimelineViewController, "controller");
    paramBaseTimelineViewController = paramBaseTimelineViewController.d();
    if (paramBaseTimelineViewController != null)
    {
      TimelinePanel localTimelinePanel = this.c;
      if (localTimelinePanel != null) {
        localTimelinePanel.a(paramBaseTimelineViewController);
      }
    }
  }
  
  public final void c()
  {
    int m = d();
    Iterator localIterator = ((Iterable)this.e).iterator();
    while (localIterator.hasNext()) {
      ((BaseTimelineViewController)localIterator.next()).c(m);
    }
  }
  
  public final void c(long paramLong)
  {
    this.l = paramLong;
  }
  
  public final int d()
  {
    Iterator localIterator = ((Iterable)this.e).iterator();
    if (!localIterator.hasNext())
    {
      localObject1 = null;
    }
    else
    {
      localObject1 = localIterator.next();
      if (localIterator.hasNext())
      {
        int m = ((BaseTimelineViewController)localObject1).k();
        Object localObject2 = localObject1;
        do
        {
          Object localObject3 = localIterator.next();
          int i1 = ((BaseTimelineViewController)localObject3).k();
          localObject1 = localObject2;
          int n = m;
          if (m < i1)
          {
            localObject1 = localObject3;
            n = i1;
          }
          localObject2 = localObject1;
          m = n;
        } while (localIterator.hasNext());
      }
    }
    Object localObject1 = (BaseTimelineViewController)localObject1;
    if (localObject1 != null) {
      return ((BaseTimelineViewController)localObject1).k();
    }
    return 0;
  }
  
  public final void e()
  {
    HashSet localHashSet = SetsKt.hashSetOf(new Integer[] { Integer.valueOf(this.f) });
    Iterator localIterator = ((Iterable)this.e).iterator();
    while (localIterator.hasNext()) {
      localHashSet.addAll((Collection)((BaseTimelineViewController)localIterator.next()).l());
    }
    localIterator = ((Iterable)this.e).iterator();
    while (localIterator.hasNext()) {
      ((BaseTimelineViewController)localIterator.next()).a((Set)localHashSet);
    }
  }
  
  @RequiresApi(21)
  public final void f()
  {
    Object localObject = this.d;
    ((ScaleCalculator)localObject).c(DensityUtils.a.a(this.b.d().a()));
    ((ScaleCalculator)localObject).d(DensityUtils.a.a(this.b.d().b()));
    this.j.a(this.b.a().a());
    localObject = this.c;
    if (localObject != null) {
      ((TimelinePanel)localObject).a(this.b.b());
    }
    localObject = ((Iterable)this.e).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((BaseTimelineViewController)((Iterator)localObject).next()).h();
    }
  }
  
  @NotNull
  public final CommonConfig g()
  {
    return this.b;
  }
  
  @NotNull
  public final FlingHelper h()
  {
    return this.j;
  }
  
  @NotNull
  public final PanelEventHandler i()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.TimelinePanelViewController
 * JD-Core Version:    0.7.0.1
 */