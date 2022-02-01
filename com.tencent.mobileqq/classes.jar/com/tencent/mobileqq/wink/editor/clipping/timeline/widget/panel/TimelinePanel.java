package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.config.CommonConfig;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.config.LayoutConfig;
import com.tencent.videocut.utils.DensityUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/TimelinePanel;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "contentLayout", "Landroid/widget/LinearLayout;", "getContentLayout", "()Landroid/widget/LinearLayout;", "contentLayout$delegate", "Lkotlin/Lazy;", "courseView", "Landroid/view/View;", "getCourseView", "()Landroid/view/View;", "courseView$delegate", "layoutConfig", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/config/LayoutConfig;", "getLayoutConfig", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/config/LayoutConfig;", "onScaleGestureListener", "Landroid/view/ScaleGestureDetector$OnScaleGestureListener;", "scaleGestureDetector", "Landroid/view/ScaleGestureDetector;", "getScaleGestureDetector", "()Landroid/view/ScaleGestureDetector;", "scaleGestureDetector$delegate", "timelinePanelViewController", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/TimelinePanelViewController;", "addComponent", "", "view", "bindController", "controller", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "hookMinSpan", "detector", "onInterceptTouchEvent", "onTouchEvent", "event", "updateCourseView", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
@RequiresApi(21)
public final class TimelinePanel
  extends ConstraintLayout
{
  public static final TimelinePanel.Companion a = new TimelinePanel.Companion(null);
  private TimelinePanelViewController b;
  private final ScaleGestureDetector.OnScaleGestureListener c = (ScaleGestureDetector.OnScaleGestureListener)new TimelinePanel.onScaleGestureListener.1(this);
  private final Lazy d;
  private final Lazy e;
  @NotNull
  private final Lazy f;
  
  @JvmOverloads
  public TimelinePanel(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public TimelinePanel(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public TimelinePanel(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.d = LazyKt.lazy((Function0)new TimelinePanel.scaleGestureDetector.2(this, paramContext));
    this.e = LazyKt.lazy((Function0)new TimelinePanel.contentLayout.2(paramContext));
    this.f = LazyKt.lazy((Function0)new TimelinePanel.courseView.2(paramContext));
    addView((View)getContentLayout());
    addView(getCourseView());
    paramContext = getLayoutConfig();
    if (paramContext == null) {
      paramContext = new LayoutConfig(0, 0.0F, 0.0F, 0.0F, 0, 31, null);
    }
    a(paramContext);
  }
  
  private final void a(ScaleGestureDetector paramScaleGestureDetector)
  {
    TimelinePanelKt.a(paramScaleGestureDetector, "mMinSpan", (Function1)new TimelinePanel.hookMinSpan.1(paramScaleGestureDetector));
  }
  
  private final LinearLayout getContentLayout()
  {
    return (LinearLayout)this.e.getValue();
  }
  
  private final LayoutConfig getLayoutConfig()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((TimelinePanelViewController)localObject).g();
      if (localObject != null) {
        return ((CommonConfig)localObject).b();
      }
    }
    return null;
  }
  
  private final ScaleGestureDetector getScaleGestureDetector()
  {
    return (ScaleGestureDetector)this.d.getValue();
  }
  
  public final void a(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    getContentLayout().addView(paramView);
  }
  
  @RequiresApi(21)
  public final void a(@NotNull LayoutConfig paramLayoutConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutConfig, "layoutConfig");
    View localView = getCourseView();
    Object localObject = new ConstraintLayout.LayoutParams(DensityUtils.a.a(paramLayoutConfig.c()), DensityUtils.a.a(68.0F));
    ((ConstraintLayout.LayoutParams)localObject).leftToLeft = 0;
    ((ConstraintLayout.LayoutParams)localObject).rightToRight = 0;
    ((ConstraintLayout.LayoutParams)localObject).topMargin = DensityUtils.a.a(paramLayoutConfig.b());
    localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localView.setElevation(DensityUtils.a.a(paramLayoutConfig.d()));
    localObject = localView.getResources().getDrawable(2130853641);
    if (localObject != null) {
      ((Drawable)localObject).setColorFilter(paramLayoutConfig.e(), PorterDuff.Mode.SRC_ATOP);
    }
    if (localObject != null)
    {
      localView.setBackgroundDrawable((Drawable)localObject);
      return;
    }
    localView.setBackgroundColor(paramLayoutConfig.e());
  }
  
  public final void a(@NotNull TimelinePanelViewController paramTimelinePanelViewController)
  {
    Intrinsics.checkParameterIsNotNull(paramTimelinePanelViewController, "controller");
    this.b = paramTimelinePanelViewController;
  }
  
  public boolean dispatchTouchEvent(@Nullable MotionEvent paramMotionEvent)
  {
    TimelinePanelViewController localTimelinePanelViewController = this.b;
    if (localTimelinePanelViewController != null) {
      localTimelinePanelViewController.a(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  @NotNull
  public final View getCourseView()
  {
    return (View)this.f.getValue();
  }
  
  public boolean onInterceptTouchEvent(@Nullable MotionEvent paramMotionEvent)
  {
    int i;
    if (paramMotionEvent != null) {
      i = paramMotionEvent.getPointerCount();
    } else {
      i = 0;
    }
    if (i > 1) {
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(@Nullable MotionEvent paramMotionEvent)
  {
    getScaleGestureDetector().onTouchEvent(paramMotionEvent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.TimelinePanel
 * JD-Core Version:    0.7.0.1
 */