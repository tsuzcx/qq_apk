package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timeline;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import androidx.annotation.IdRes;
import androidx.annotation.MainThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Group;
import com.tencent.videocut.utils.DensityUtils;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/timeline/TimelineView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "constraintSet", "Landroidx/constraintlayout/widget/ConstraintSet;", "contentHeight", "getContentHeight", "()I", "contentPadding", "getContentPadding", "contentView", "Landroid/view/ViewGroup;", "contentViewId", "getContentViewId", "contentWidth", "getContentWidth", "frameHeight", "getFrameHeight", "group", "Landroidx/constraintlayout/widget/Group;", "leftSliderView", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/timeline/SliderView;", "leftSliderViewId", "getLeftSliderViewId", "rightSliderView", "rightSliderViewId", "getRightSliderViewId", "selectedStyle", "sliderHeight", "getSliderHeight", "sliderWidth", "getSliderWidth", "timelineListener", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/timeline/ITimelineListener;", "addLeftSlider", "", "addRightSlider", "allowChildrenOutSide", "applyConstraintSet", "constraintSetWithChildView", "constraintSetWithContent", "constraintWithLeftSlider", "constraintWithRightSlider", "createContentView", "id", "createLeftSliderView", "createRightSliderView", "getContentMargin", "getContentView", "handSliderDown", "rawX", "", "handleLeftSliderMove", "moveX", "handleRightSliderMove", "handleSliderMoveEnd", "isLeft", "", "init", "initChildView", "initContent", "initGroup", "initSlider", "refreshSelect", "setOnClickListener", "l", "Landroid/view/View$OnClickListener;", "setOnLongClickListener", "Landroid/view/View$OnLongClickListener;", "setSelected", "selected", "setTimelineListener", "switchDisplayBySelectStatus", "updateSlider", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public class TimelineView
  extends ConstraintLayout
{
  public static final TimelineView.Companion b = new TimelineView.Companion(null);
  private final ConstraintSet a = new ConstraintSet();
  private SliderView c;
  private SliderView d;
  private ViewGroup e;
  private Group f;
  private ITimelineListener g;
  private int h;
  
  @JvmOverloads
  public TimelineView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public TimelineView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public TimelineView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private final void a()
  {
    b();
    f();
    e();
  }
  
  private final void b()
  {
    c();
    d();
  }
  
  private final void b(boolean paramBoolean)
  {
    int j = this.h;
    int i = 8;
    Object localObject;
    if (j == 0)
    {
      localObject = this.f;
      if (localObject != null)
      {
        if (paramBoolean) {
          i = 0;
        }
        ((Group)localObject).setVisibility(i);
      }
      if (paramBoolean)
      {
        setBackgroundResource(2130853642);
        localObject = this.e;
        if (localObject != null)
        {
          localObject = ((ViewGroup)localObject).getLayoutParams();
          if (localObject != null)
          {
            localObject = (ViewGroup.MarginLayoutParams)localObject;
            ((ViewGroup.MarginLayoutParams)localObject).topMargin = getFrameHeight();
            ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = getFrameHeight();
            return;
          }
          throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
      }
      else
      {
        setBackgroundColor(getResources().getColor(2131168273));
        localObject = this.e;
        if (localObject != null)
        {
          localObject = ((ViewGroup)localObject).getLayoutParams();
          if (localObject != null)
          {
            localObject = (ViewGroup.MarginLayoutParams)localObject;
            ((ViewGroup.MarginLayoutParams)localObject).topMargin = 0;
            ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = 0;
            return;
          }
          throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
      }
    }
    else if (j == 1)
    {
      localObject = this.f;
      if (localObject != null) {
        ((Group)localObject).setVisibility(8);
      }
    }
  }
  
  private final void c()
  {
    ViewGroup localViewGroup = a(getContentViewId());
    addView((View)localViewGroup);
    this.e = localViewGroup;
  }
  
  private final void d()
  {
    k();
    l();
  }
  
  private final void e()
  {
    Group localGroup = new Group(getContext());
    localGroup.setId(2131447390);
    this.f = localGroup;
    localGroup = this.f;
    if (localGroup != null)
    {
      SliderView localSliderView = this.c;
      int j = 0;
      int i;
      if (localSliderView != null) {
        i = localSliderView.getId();
      } else {
        i = 0;
      }
      localSliderView = this.d;
      if (localSliderView != null) {
        j = localSliderView.getId();
      }
      localGroup.setReferencedIds(new int[] { i, j });
      addView((View)this.f);
      localGroup.setVisibility(8);
    }
  }
  
  private final void f()
  {
    h();
    i();
    j();
    g();
  }
  
  private final void g()
  {
    this.a.applyTo((ConstraintLayout)this);
  }
  
  private final void h()
  {
    ViewGroup localViewGroup = this.e;
    if (localViewGroup != null)
    {
      localViewGroup.setPadding(getContentPadding(), 0, getContentPadding(), 0);
      this.a.constrainWidth(localViewGroup.getId(), getContentWidth());
      this.a.constrainHeight(localViewGroup.getId(), getContentHeight());
      this.a.connect(localViewGroup.getId(), 6, 0, 6, getSliderWidth());
      this.a.connect(localViewGroup.getId(), 3, 0, 3);
      this.a.connect(localViewGroup.getId(), 7, 0, 7, getSliderWidth());
      this.a.connect(localViewGroup.getId(), 4, 0, 4);
    }
  }
  
  private final void i()
  {
    SliderView localSliderView = this.c;
    if (localSliderView != null)
    {
      this.a.constrainWidth(localSliderView.getId(), DensityUtils.a.a(12.0F));
      this.a.constrainHeight(localSliderView.getId(), getSliderHeight());
      this.a.connect(localSliderView.getId(), 6, 0, 6);
      ConstraintSet localConstraintSet = this.a;
      int j = localSliderView.getId();
      ViewGroup localViewGroup = this.e;
      int i;
      if (localViewGroup != null) {
        i = localViewGroup.getId();
      } else {
        i = 0;
      }
      localConstraintSet.connect(j, 7, i, 6);
      this.a.connect(localSliderView.getId(), 3, 0, 3);
      this.a.connect(localSliderView.getId(), 4, 0, 4);
      localSliderView.setOnClickListener(null);
    }
  }
  
  private final void j()
  {
    SliderView localSliderView = this.d;
    if (localSliderView != null)
    {
      this.a.constrainWidth(localSliderView.getId(), DensityUtils.a.a(12.0F));
      this.a.constrainHeight(localSliderView.getId(), getSliderHeight());
      this.a.connect(localSliderView.getId(), 3, 0, 3);
      this.a.connect(localSliderView.getId(), 7, 0, 7);
      ConstraintSet localConstraintSet = this.a;
      int j = localSliderView.getId();
      ViewGroup localViewGroup = this.e;
      int i;
      if (localViewGroup != null) {
        i = localViewGroup.getId();
      } else {
        i = 0;
      }
      localConstraintSet.connect(j, 6, i, 7);
      this.a.connect(localSliderView.getId(), 4, 0, 4);
      localSliderView.setOnClickListener(null);
    }
  }
  
  private final void k()
  {
    SliderView localSliderView = b(getLeftSliderViewId());
    localSliderView.setSliderListener((ISliderListener)new TimelineView.addLeftSlider..inlined.also.lambda.1(this));
    addView((View)localSliderView);
    this.c = localSliderView;
  }
  
  private final void l()
  {
    SliderView localSliderView = c(getRightSliderViewId());
    localSliderView.setSliderListener((ISliderListener)new TimelineView.addRightSlider..inlined.also.lambda.1(this));
    addView((View)localSliderView);
    this.d = localSliderView;
  }
  
  @MainThread
  @NotNull
  protected ViewGroup a(int paramInt)
  {
    Object localObject = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
    localObject = new ContentView((Context)localObject, null, 0, 6, null);
    ((ContentView)localObject).setId(paramInt);
    return (ViewGroup)localObject;
  }
  
  protected void a(float paramFloat)
  {
    ITimelineListener localITimelineListener = this.g;
    if (localITimelineListener != null) {
      localITimelineListener.a(paramFloat, true);
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    getParent().requestDisallowInterceptTouchEvent(false);
    ITimelineListener localITimelineListener = this.g;
    if (localITimelineListener != null) {
      localITimelineListener.b(paramBoolean);
    }
  }
  
  @MainThread
  @NotNull
  protected final SliderView b(int paramInt)
  {
    SliderView localSliderView = new SliderView(getContext(), null, 0, 6, null);
    localSliderView.setId(paramInt);
    localSliderView.setImageResource(2130848850);
    return localSliderView;
  }
  
  protected void b(float paramFloat)
  {
    ITimelineListener localITimelineListener = this.g;
    if (localITimelineListener != null) {
      localITimelineListener.a(paramFloat, false);
    }
  }
  
  @MainThread
  @NotNull
  protected final SliderView c(int paramInt)
  {
    SliderView localSliderView = new SliderView(getContext(), null, 0, 6, null);
    localSliderView.setId(paramInt);
    localSliderView.setImageResource(2130848851);
    return localSliderView;
  }
  
  protected final void d(float paramFloat)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    ITimelineListener localITimelineListener = this.g;
    if (localITimelineListener != null) {
      localITimelineListener.c(paramFloat);
    }
  }
  
  protected final int getContentHeight()
  {
    return 0;
  }
  
  protected int getContentMargin()
  {
    return getResources().getDimensionPixelOffset(2131299834);
  }
  
  protected int getContentPadding()
  {
    return getResources().getDimensionPixelOffset(2131299829);
  }
  
  @Nullable
  public final ViewGroup getContentView()
  {
    return this.e;
  }
  
  @IdRes
  protected final int getContentViewId()
  {
    return 2131447389;
  }
  
  protected final int getContentWidth()
  {
    return 0;
  }
  
  protected final int getFrameHeight()
  {
    return getResources().getDimensionPixelOffset(2131299831);
  }
  
  @IdRes
  protected final int getLeftSliderViewId()
  {
    return 2131447392;
  }
  
  @IdRes
  protected final int getRightSliderViewId()
  {
    return 2131447394;
  }
  
  protected final int getSliderHeight()
  {
    return DensityUtils.a.a(50.0F);
  }
  
  protected int getSliderWidth()
  {
    return DensityUtils.a.a(16.0F);
  }
  
  public void setOnClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    ViewGroup localViewGroup = this.e;
    if (localViewGroup != null) {
      localViewGroup.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setOnLongClickListener(@Nullable View.OnLongClickListener paramOnLongClickListener)
  {
    ViewGroup localViewGroup = this.e;
    if (localViewGroup != null) {
      localViewGroup.setOnLongClickListener(paramOnLongClickListener);
    }
  }
  
  public void setSelected(boolean paramBoolean)
  {
    super.setSelected(paramBoolean);
    b(paramBoolean);
  }
  
  public final void setTimelineListener(@Nullable ITimelineListener paramITimelineListener)
  {
    this.g = paramITimelineListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timeline.TimelineView
 * JD-Core Version:    0.7.0.1
 */