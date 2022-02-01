package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop;

import android.content.ClipData;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnClickListener;
import android.view.View.OnDragListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.RelativeLayout.LayoutParams;
import androidx.annotation.RequiresApi;
import androidx.core.widget.NestedScrollView;
import androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener;
import com.tencent.mobileqq.wink.edit.log.WinkQLog;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.BaseTimelineViewController;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.ITimelineView;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.TimelinePanelViewController;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.PanelEvent;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.PanelEventHandler;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scale.ScaleCalculator;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scroll.FlingHelper;
import com.tencent.videocut.utils.DensityUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.IntRef;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragDropScrollView;", "Landroidx/core/widget/NestedScrollView;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/IDragDropScrollView;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/ITimelineView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "attractPoints", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "contentTopMargin", "contentView", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/BottomLineRelativeLayout;", "getContentView", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/BottomLineRelativeLayout;", "setContentView", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/BottomLineRelativeLayout;)V", "contentViewDownWidth", "disableBottomLine", "", "dragDropScrollViewController", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragDropScrollViewController;", "dragEventHandler", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragEventHandler;", "flingHelper", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scroll/FlingHelper;", "halfScreenWidth", "horizontalScrollView", "Landroid/widget/HorizontalScrollView;", "lastX", "", "lastY", "listener", "Landroidx/dynamicanimation/animation/DynamicAnimation$OnAnimationUpdateListener;", "minAttractDistance", "getMinAttractDistance$qq_wink_impl_release", "()F", "screenWidth", "getScreenWidth", "()I", "selectedDragView", "Landroid/view/View;", "getSelectedDragView$qq_wink_impl_release", "()Landroid/view/View;", "trackManager", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/TrackManager;", "trackModels", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/TrackModel;", "Lkotlin/collections/ArrayList;", "getTrackModels", "()Ljava/util/ArrayList;", "whiteLineWidth", "xDistance", "yDistance", "addDragView", "", "v", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/IDragView;", "needCalculateTrackIndex", "addDragView$qq_wink_impl_release", "addEmptyTrack", "trackType", "addEmptyTrack$qq_wink_impl_release", "adjustViewBoundary", "dragView", "newPosition", "Landroid/graphics/PointF;", "adjustViewBoundary$qq_wink_impl_release", "adjustViewRightBoundary", "bindController", "controller", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/BaseTimelineViewController;", "bringSelectedViewToFront", "clearOtherSelectedStatus", "selectedView", "clearOtherSelectedStatus$qq_wink_impl_release", "createHorizontalScrollView", "dispatchEvent", "panelEvent", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/PanelEvent;", "dispatchEvent$qq_wink_impl_release", "dp2px", "dp", "findDragViewById", "id", "", "findDragViewById$qq_wink_impl_release", "findDragViewListByTrackType", "", "T", "findDragViewListByTrackType$qq_wink_impl_release", "fling", "velocityY", "forEachContentChildView", "action", "Lkotlin/Function1;", "getAttractPoints", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/AttractPoint;", "", "getContentViewWidth", "getContentViewWidth$qq_wink_impl_release", "getHalfScreenWidth", "getHorizontalScrollX", "getLeftSidePositionByMargin", "leftMargin", "getMaxCanScrollPx", "getMaxPosition", "getMaxSpace", "getMinAttractDistance", "getRightSidePositionByMargin", "rightMargin", "getStartPosition", "getTrackHeight", "getTrackHeight$qq_wink_impl_release", "getTrackLeftMargin", "getTrackLeftMargin$qq_wink_impl_release", "getTrackMargin", "getTrackMargin$qq_wink_impl_release", "getTrackRightMargin", "getTrackRightMargin$qq_wink_impl_release", "hideBottomLine", "hideBottomLine$qq_wink_impl_release", "horizontalScrollToView", "horizontalScrollToView$qq_wink_impl_release", "initContentView", "initHorizontalScrollView", "intiView", "isBottomLineShow", "isBottomLineShow$qq_wink_impl_release", "isDragViewAlignRightWithContentView", "view", "rightSpace", "isDragViewOverBottom", "isDragViewOverBottom$qq_wink_impl_release", "isScrollYBottom", "isScrollYTop", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onScrollChanged", "l", "t", "oldl", "oldt", "onSliderDown", "onSliderUp", "positionOffset", "putBlockOnTrack", "trackModel", "putBlockOnTrack$qq_wink_impl_release", "refreshAllDragView", "refreshDragView", "refreshDragView$qq_wink_impl_release", "refreshSingleDragView", "iDragView", "trackIndex", "refreshSingleDragView$qq_wink_impl_release", "refreshSingleViewLayout", "layoutParams", "Landroid/widget/RelativeLayout$LayoutParams;", "refreshWidth", "minWidth", "refreshWidth$qq_wink_impl_release", "removeDragViewById", "removeDragViewById$qq_wink_impl_release", "removeEmptyTrack", "removeEmptyTrack$qq_wink_impl_release", "removeViewFromContentView", "removeViewSafety", "child", "scrollToDragView", "scrollToDragView$qq_wink_impl_release", "scrollToX", "x", "y", "scrollViewIfNeeded", "xOffset", "scrollViewIfNeeded$qq_wink_impl_release", "scrollXIfNeed", "scrollYIfNeed", "setAdsorbedPoint", "startPoint", "endPoint", "setAttractPointPosition", "points", "", "setAttractPointPosition$qq_wink_impl_release", "setCanAddEmptyTrackOnDrop", "canAddEmptyTrackOnDrop", "setCanAddEmptyTrackOnDrop$qq_wink_impl_release", "setContentPadding", "setContentTopMargin", "setDisableBottomLine", "setDisableBottomLine$qq_wink_impl_release", "setNeedDrawTrackBackground", "needDrawTrackBackground", "setNeedDrawTrackBackground$qq_wink_impl_release", "showBottomLine", "showBottomLine$qq_wink_impl_release", "startDrag", "updateContentViewWidth", "isEnd", "updateContentViewWidthIfNeed", "updateContentViewWidthIfNeed$qq_wink_impl_release", "updateDragEventAvailable", "available", "updateDragEventAvailable$qq_wink_impl_release", "updateDragViewModelInTracks", "dragViewModel", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragViewModel;", "updateDragViewModelInTracks$qq_wink_impl_release", "updateSelectState", "isSelected", "verticalScrollToView", "verticalScrollToView$qq_wink_impl_release", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class DragDropScrollView
  extends NestedScrollView
  implements ITimelineView, IDragDropScrollView
{
  public static final DragDropScrollView.Companion a = new DragDropScrollView.Companion(null);
  private int b = DensityUtils.a.a(10.0F);
  private HorizontalScrollView c;
  @Nullable
  private BottomLineRelativeLayout d;
  private final HashSet<Integer> e = new HashSet();
  private DragDropScrollViewController f;
  private int g;
  private boolean h;
  private TrackManager i;
  private final DragEventHandler j = new DragEventHandler(this);
  private float k;
  private float l;
  private float m;
  private float n;
  private final FlingHelper o = new FlingHelper();
  private final int p = (int)(getScreenWidth() * 0.5F);
  private final DynamicAnimation.OnAnimationUpdateListener q = (DynamicAnimation.OnAnimationUpdateListener)new DragDropScrollView.listener.1(this);
  private int r;
  
  @JvmOverloads
  public DragDropScrollView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public DragDropScrollView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public DragDropScrollView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    g();
  }
  
  private final int a(float paramFloat)
  {
    return DensityUtils.a.a(paramFloat);
  }
  
  private final void a(int paramInt, boolean paramBoolean, View paramView)
  {
    Object localObject = this.d;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    localObject = ((BottomLineRelativeLayout)localObject).getLayoutParams();
    if (paramBoolean)
    {
      if (paramInt < 0) {
        ((ViewGroup.LayoutParams)localObject).width = (this.r + paramInt);
      }
    }
    else if (paramInt > 0)
    {
      IDragView localIDragView = IDragViewCastUtilKt.a(paramView);
      int i1;
      if (localIDragView != null) {
        i1 = localIDragView.b();
      } else {
        i1 = 0;
      }
      if (b(paramView, i1)) {
        ((ViewGroup.LayoutParams)localObject).width += paramInt;
      }
    }
    paramView = this.f;
    if (paramView != null)
    {
      paramView = paramView.e();
      if (paramView != null) {
        paramView.c();
      }
    }
  }
  
  private final void a(PointF paramPointF, View paramView)
  {
    BottomLineRelativeLayout localBottomLineRelativeLayout = this.d;
    if (localBottomLineRelativeLayout != null)
    {
      IDragView localIDragView = IDragViewCastUtilKt.a(paramView);
      if (localIDragView != null)
      {
        if (localIDragView.f()) {
          i1 = getMaxCanScrollPx();
        } else {
          i1 = getMaxSpace();
        }
        int i1 = RangesKt.coerceAtMost(localIDragView.getMaxEndPositionForDrag(), i1);
        if (i1 > 0)
        {
          i1 = localBottomLineRelativeLayout.getPaddingLeft() + i1 + localIDragView.a() + localIDragView.b();
          if (paramPointF.x + paramView.getWidth() > i1) {
            paramPointF.x = (i1 - paramView.getWidth());
          }
        }
      }
    }
  }
  
  private final void a(TrackModel paramTrackModel, IDragView paramIDragView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    paramLayoutParams.leftMargin = paramIDragView.getStartPosition();
    paramLayoutParams.topMargin = (paramTrackModel.b() - paramIDragView.g());
    paramLayoutParams.width = (paramIDragView.a() + paramIDragView.b() + paramIDragView.getLength());
    paramTrackModel = this.i;
    if (paramTrackModel == null) {
      Intrinsics.throwUninitializedPropertyAccessException("trackManager");
    }
    paramLayoutParams.height = paramTrackModel.b();
  }
  
  private final void b(View paramView)
  {
    Object localObject2 = null;
    if (paramView != null) {
      localObject1 = paramView.getParent();
    } else {
      localObject1 = null;
    }
    if (!(localObject1 instanceof ViewGroup)) {
      localObject1 = localObject2;
    }
    Object localObject1 = (ViewGroup)localObject1;
    if (localObject1 != null) {
      ((ViewGroup)localObject1).removeView(paramView);
    }
  }
  
  private final boolean b(View paramView, int paramInt)
  {
    BottomLineRelativeLayout localBottomLineRelativeLayout = this.d;
    if (localBottomLineRelativeLayout == null) {
      Intrinsics.throwNpe();
    }
    return localBottomLineRelativeLayout.getRight() - paramView.getRight() == this.p - paramInt;
  }
  
  private final void c(String paramString)
  {
    BottomLineRelativeLayout localBottomLineRelativeLayout = this.d;
    if (localBottomLineRelativeLayout != null)
    {
      int i1 = 0;
      int i2 = localBottomLineRelativeLayout.getChildCount();
      while (i1 < i2)
      {
        View localView = localBottomLineRelativeLayout.getChildAt(i1);
        if ((localView != null) && ((localView instanceof IDragView)) && (Intrinsics.areEqual(((IDragView)localView).getDragViewModel().e(), paramString)))
        {
          localBottomLineRelativeLayout.removeView(localView);
          return;
        }
        i1 += 1;
      }
    }
  }
  
  private final boolean c(View paramView)
  {
    paramView.performHapticFeedback(0, 2);
    paramView.setAlpha(0.7F);
    a(this, null, 1, null);
    DragShadow localDragShadow = new DragShadow(paramView);
    ClipData localClipData = ClipData.newPlainText((CharSequence)"Label", (CharSequence)"");
    try
    {
      if (Build.VERSION.SDK_INT >= 24) {
        return paramView.startDragAndDrop(localClipData, (View.DragShadowBuilder)localDragShadow, paramView, 0);
      }
      boolean bool = startDrag(localClipData, (View.DragShadowBuilder)localDragShadow, paramView, 0);
      return bool;
    }
    catch (Throwable paramView)
    {
      paramView = paramView.getMessage();
      if (paramView != null) {
        WinkQLog.d("DragDrop-ScrollView", paramView);
      }
    }
    return false;
  }
  
  private final boolean c(View paramView, int paramInt)
  {
    Ref.IntRef localIntRef = new Ref.IntRef();
    HorizontalScrollView localHorizontalScrollView = this.c;
    boolean bool = false;
    if (localHorizontalScrollView != null)
    {
      float f2 = paramView.getX() + paramView.getWidth() - localHorizontalScrollView.getMeasuredWidth() - localHorizontalScrollView.getScrollX();
      float f1 = 0;
      if ((f2 >= f1) && (paramInt > 0))
      {
        localIntRef.element = this.j.a(paramView.getWidth(), f2);
        localHorizontalScrollView.smoothScrollBy(localIntRef.element, 0);
        bool = true;
      }
      else
      {
        bool = false;
      }
      f2 = paramView.getX() - localHorizontalScrollView.getScrollX();
      if ((f2 <= f1) && (paramInt < 0))
      {
        localIntRef.element = this.j.a(paramView.getWidth(), f2);
        localHorizontalScrollView.smoothScrollBy(localIntRef.element, 0);
        return true;
      }
    }
    return bool;
  }
  
  private final boolean d(View paramView)
  {
    int i1 = DensityUtils.a.a(15.0F);
    int i2 = DensityUtils.a.a(5.0F);
    boolean bool1;
    if (paramView.getY() <= getScrollY() + i1)
    {
      if (f(paramView)) {
        return false;
      }
      smoothScrollBy(0, -i2);
      bool1 = true;
    }
    else
    {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (paramView.getY() + paramView.getMeasuredHeight() >= getScrollY() + getMeasuredHeight() - this.b - i1)
    {
      if (e(paramView)) {
        return bool1;
      }
      smoothScrollBy(0, i2);
      bool2 = true;
    }
    paramView.setTag(2131432159, Boolean.valueOf(bool2));
    return bool2;
  }
  
  private final boolean e(View paramView)
  {
    return (int)paramView.getY() + paramView.getMeasuredHeight() == getScrollY() + getMeasuredHeight() - this.b;
  }
  
  private final boolean f(View paramView)
  {
    return (paramView.getY() == 0.0F) && (getScrollY() == 0);
  }
  
  private final void g()
  {
    i();
    this.g = a(2.0F);
  }
  
  private final int getScreenWidth()
  {
    Object localObject = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
    localObject = ((Context)localObject).getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context.resources");
    return ((Resources)localObject).getDisplayMetrics().widthPixels;
  }
  
  private final void h()
  {
    BottomLineRelativeLayout localBottomLineRelativeLayout = new BottomLineRelativeLayout(getContext());
    localBottomLineRelativeLayout.setTrackList(getTrackModels());
    localBottomLineRelativeLayout.setBackgroundColor(localBottomLineRelativeLayout.getResources().getColor(2131168273));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(getMaxPosition(), -1);
    localLayoutParams.topMargin = this.b;
    int i1 = this.p;
    localBottomLineRelativeLayout.setPadding(i1, 0, i1, 0);
    Object localObject = this.i;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("trackManager");
    }
    localBottomLineRelativeLayout.setMinimumHeight(((TrackManager)localObject).b() * 1 + getTrackMargin$qq_wink_impl_release() * 0);
    localObject = this.c;
    if (localObject != null) {
      ((HorizontalScrollView)localObject).addView((View)localBottomLineRelativeLayout, (ViewGroup.LayoutParams)localLayoutParams);
    }
    localBottomLineRelativeLayout.setOnDragListener((View.OnDragListener)this.j);
    localBottomLineRelativeLayout.setOnClickListener((View.OnClickListener)new DragDropScrollView.initContentView..inlined.apply.lambda.1(this));
    this.d = localBottomLineRelativeLayout;
  }
  
  private final void i()
  {
    setFillViewport(true);
    HorizontalScrollView localHorizontalScrollView = j();
    localHorizontalScrollView.setOverScrollMode(2);
    localHorizontalScrollView.setVerticalScrollBarEnabled(false);
    localHorizontalScrollView.setHorizontalScrollBarEnabled(false);
    ((DragDropScrollView)this).addView((View)localHorizontalScrollView, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    this.c = localHorizontalScrollView;
  }
  
  private final HorizontalScrollView j()
  {
    return (HorizontalScrollView)new DragDropScrollView.createHorizontalScrollView.1(this, getContext());
  }
  
  private final void k()
  {
    BottomLineRelativeLayout localBottomLineRelativeLayout = this.d;
    if (localBottomLineRelativeLayout != null)
    {
      int i1 = 0;
      int i2 = localBottomLineRelativeLayout.getChildCount();
      while (i1 < i2)
      {
        View localView = localBottomLineRelativeLayout.getChildAt(i1);
        if (localView != null)
        {
          if (!localView.isSelected()) {
            localView = null;
          }
          if (localView != null) {
            localView.bringToFront();
          }
        }
        i1 += 1;
      }
    }
  }
  
  private final void l()
  {
    BottomLineRelativeLayout localBottomLineRelativeLayout = this.d;
    if (localBottomLineRelativeLayout != null)
    {
      int i3 = localBottomLineRelativeLayout.getChildCount();
      int i1 = 0;
      while (i1 < i3)
      {
        View localView = localBottomLineRelativeLayout.getChildAt(i1);
        Intrinsics.checkExpressionValueIsNotNull(localView, "view");
        Object localObject = localView.getLayoutParams();
        if (localObject != null)
        {
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localObject;
          IDragView localIDragView = IDragViewCastUtilKt.a(localView);
          if (localIDragView != null)
          {
            Iterator localIterator = ((Iterable)getTrackModels()).iterator();
            while (localIterator.hasNext())
            {
              localObject = localIterator.next();
              TrackModel localTrackModel = (TrackModel)localObject;
              int i2;
              if ((localTrackModel.f() == localIDragView.getDragViewModel().d()) && (localTrackModel.b(localIDragView.getDragViewModel().e()))) {
                i2 = 1;
              } else {
                i2 = 0;
              }
              if (i2 != 0) {
                break label164;
              }
            }
            localObject = null;
            label164:
            localObject = (TrackModel)localObject;
            if (localObject != null)
            {
              a((TrackModel)localObject, localIDragView, localLayoutParams);
              localView.invalidate();
              localView.requestLayout();
            }
            i1 += 1;
          }
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        }
      }
    }
  }
  
  private final void setContentPadding(IDragView paramIDragView)
  {
    BottomLineRelativeLayout localBottomLineRelativeLayout = this.d;
    if (localBottomLineRelativeLayout != null) {
      localBottomLineRelativeLayout.setPadding(this.p - paramIDragView.a(), 0, this.p - paramIDragView.b(), 0);
    }
  }
  
  private final void setContentTopMargin(float paramFloat)
  {
    this.b = a(paramFloat);
    Object localObject1 = this.d;
    if (localObject1 != null) {
      localObject1 = ((BottomLineRelativeLayout)localObject1).getLayoutParams();
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      localObject2 = null;
    }
    localObject1 = (ViewGroup.MarginLayoutParams)localObject2;
    if (localObject1 != null) {
      ((ViewGroup.MarginLayoutParams)localObject1).topMargin = this.b;
    }
  }
  
  @Nullable
  public final IDragView a(@Nullable Object paramObject)
  {
    BottomLineRelativeLayout localBottomLineRelativeLayout = this.d;
    if (localBottomLineRelativeLayout != null)
    {
      int i1 = 0;
      int i2 = localBottomLineRelativeLayout.getChildCount();
      while (i1 < i2)
      {
        Object localObject = localBottomLineRelativeLayout.getChildAt(i1);
        if ((localObject instanceof IDragView))
        {
          localObject = (IDragView)localObject;
          if (Intrinsics.areEqual(((IDragView)localObject).getDragViewModel().e(), paramObject)) {
            return localObject;
          }
        }
        i1 += 1;
      }
    }
    return null;
  }
  
  @NotNull
  public final TrackModel a(int paramInt)
  {
    TrackManager localTrackManager = this.i;
    if (localTrackManager == null) {
      Intrinsics.throwUninitializedPropertyAccessException("trackManager");
    }
    return localTrackManager.a(paramInt);
  }
  
  @NotNull
  public List<AttractPoint> a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "id");
    List localList = (List)new ArrayList();
    BottomLineRelativeLayout localBottomLineRelativeLayout = this.d;
    if (localBottomLineRelativeLayout != null)
    {
      int i2 = localBottomLineRelativeLayout.getChildCount();
      int i1 = 0;
      while (i1 < i2)
      {
        Object localObject = localBottomLineRelativeLayout.getChildAt(i1);
        Intrinsics.checkExpressionValueIsNotNull(localObject, "it.getChildAt(i)");
        localObject = IDragViewCastUtilKt.a((View)localObject);
        if (localObject == null) {
          break;
        }
        if ((Intrinsics.areEqual(((IDragView)localObject).getDragViewModel().e(), paramString) ^ true))
        {
          localList.add(((IDragView)localObject).getDragViewModel().a(0L, true));
          localList.add(((IDragView)localObject).getDragViewModel().a(0L, false));
        }
        i1 += 1;
      }
    }
    paramString = ((Iterable)this.e).iterator();
    while (paramString.hasNext()) {
      localList.add(new AttractPoint(-1L, ((Number)paramString.next()).intValue(), null, false));
    }
    return localList;
  }
  
  public final void a()
  {
    int i2 = ((Collection)getTrackModels()).size();
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject = getTrackModels().get(i1);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "trackModels[i]");
      localObject = (TrackModel)localObject;
      int i3 = ((TrackModel)localObject).f();
      TrackManager localTrackManager = this.i;
      if (localTrackManager == null) {
        Intrinsics.throwUninitializedPropertyAccessException("trackManager");
      }
      ((TrackModel)localObject).a(i3 * (localTrackManager.b() + getTrackMargin$qq_wink_impl_release()));
      i3 = ((TrackModel)localObject).b();
      localTrackManager = this.i;
      if (localTrackManager == null) {
        Intrinsics.throwUninitializedPropertyAccessException("trackManager");
      }
      ((TrackModel)localObject).b(i3 + localTrackManager.b());
      ((TrackModel)localObject).c(getTrackLeftMargin$qq_wink_impl_release());
      ((TrackModel)localObject).d(getTrackRightMargin$qq_wink_impl_release());
      i1 += 1;
    }
    l();
    d(getMaxPosition());
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    HorizontalScrollView localHorizontalScrollView = this.c;
    if (localHorizontalScrollView != null) {
      localHorizontalScrollView.scrollTo(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt, @NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    a(paramInt, true, paramView);
    IDragView localIDragView = IDragViewCastUtilKt.a(paramView);
    if (localIDragView != null) {
      paramInt = localIDragView.b();
    } else {
      paramInt = 0;
    }
    if (b(paramView, paramInt))
    {
      paramView = this.c;
      if (paramView == null) {
        Intrinsics.throwNpe();
      }
      a(paramView.getScrollX() + this.p - paramInt, 0);
    }
  }
  
  public final void a(@NotNull View paramView, @NotNull PointF paramPointF)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "dragView");
    Intrinsics.checkParameterIsNotNull(paramPointF, "newPosition");
    BottomLineRelativeLayout localBottomLineRelativeLayout = this.d;
    if (localBottomLineRelativeLayout != null)
    {
      if (paramPointF.x < localBottomLineRelativeLayout.getPaddingLeft()) {
        paramPointF.x = localBottomLineRelativeLayout.getPaddingLeft();
      }
      a(paramPointF, paramView);
      if (paramPointF.y < localBottomLineRelativeLayout.getPaddingTop()) {
        paramPointF.y = localBottomLineRelativeLayout.getPaddingTop();
      }
    }
  }
  
  public final void a(@NotNull View paramView, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "dragView");
    if (paramBoolean)
    {
      paramView.setOnLongClickListener((View.OnLongClickListener)new DragDropScrollView.updateDragEventAvailable.1(this, paramView));
      return;
    }
    paramView.setOnLongClickListener(null);
  }
  
  public void a(@NotNull BaseTimelineViewController<?> paramBaseTimelineViewController)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseTimelineViewController, "controller");
    BaseTimelineViewController<?> localBaseTimelineViewController = paramBaseTimelineViewController;
    if (!(paramBaseTimelineViewController instanceof DragDropScrollViewController)) {
      localBaseTimelineViewController = null;
    }
    paramBaseTimelineViewController = (DragDropScrollViewController)localBaseTimelineViewController;
    if (paramBaseTimelineViewController != null) {
      this.i = paramBaseTimelineViewController.i();
    } else {
      paramBaseTimelineViewController = null;
    }
    this.f = paramBaseTimelineViewController;
    h();
  }
  
  public final void a(@NotNull DragViewModel paramDragViewModel)
  {
    Intrinsics.checkParameterIsNotNull(paramDragViewModel, "dragViewModel");
    TrackManager localTrackManager = this.i;
    if (localTrackManager == null) {
      Intrinsics.throwUninitializedPropertyAccessException("trackManager");
    }
    localTrackManager.b(paramDragViewModel);
  }
  
  public final void a(@NotNull IDragView paramIDragView)
  {
    Intrinsics.checkParameterIsNotNull(paramIDragView, "dragView");
    Object localObject = IDragViewCastUtilKt.a(paramIDragView);
    if (localObject != null) {
      localObject = ((View)localObject).getParent();
    } else {
      localObject = null;
    }
    if (localObject == null) {
      return;
    }
    paramIDragView = IDragViewCastUtilKt.a(paramIDragView);
    if (paramIDragView != null) {
      paramIDragView = paramIDragView.getLayoutParams();
    } else {
      paramIDragView = null;
    }
    localObject = paramIDragView;
    if (!(paramIDragView instanceof ViewGroup.MarginLayoutParams)) {
      localObject = null;
    }
    paramIDragView = (ViewGroup.MarginLayoutParams)localObject;
    if (paramIDragView != null) {
      scrollTo(0, paramIDragView.topMargin);
    }
  }
  
  public final void a(@NotNull IDragView paramIDragView, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramIDragView, "iDragView");
    Object localObject1 = IDragViewCastUtilKt.a(paramIDragView);
    if (localObject1 != null)
    {
      Object localObject2 = ((View)localObject1).getLayoutParams();
      if (localObject2 != null)
      {
        localObject2 = (RelativeLayout.LayoutParams)localObject2;
        int i1 = ((RelativeLayout.LayoutParams)localObject2).width;
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = paramIDragView.getStartPosition();
        ((RelativeLayout.LayoutParams)localObject2).width = (paramIDragView.getEndPosition() - paramIDragView.getStartPosition() + paramIDragView.a() + paramIDragView.b());
        int i2 = ((RelativeLayout.LayoutParams)localObject2).width;
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        a(i2 - i1, false, (View)localObject1);
        localObject1 = this.i;
        if (localObject1 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("trackManager");
        }
        ((TrackManager)localObject1).b(paramIDragView.getDragViewModel());
        if (paramIDragView.getDragViewModel().d() == paramInt)
        {
          localObject1 = this.i;
          if (localObject1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("trackManager");
          }
          if (((TrackManager)localObject1).a(paramIDragView.getDragViewModel())) {
            return;
          }
        }
        if (paramInt < 0) {
          return;
        }
        b(paramIDragView.getDragViewModel().e());
        while (paramInt >= getTrackModels().size()) {
          a(paramIDragView.getTrackType());
        }
        localObject1 = getTrackModels().get(paramInt);
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "trackModels[trackIndex]");
        a((TrackModel)localObject1, paramIDragView);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }
  }
  
  public void a(@Nullable IDragView paramIDragView, boolean paramBoolean)
  {
    if (paramBoolean) {
      c(paramIDragView);
    }
  }
  
  public final void a(@NotNull TrackModel paramTrackModel, @NotNull IDragView paramIDragView)
  {
    Intrinsics.checkParameterIsNotNull(paramTrackModel, "trackModel");
    Intrinsics.checkParameterIsNotNull(paramIDragView, "dragView");
    View localView = IDragViewCastUtilKt.a(paramIDragView);
    if (localView != null)
    {
      b(localView);
      paramIDragView.setDragViewModel(DragViewModel.a(paramIDragView.getDragViewModel(), null, 0, 0, 0L, paramTrackModel.f(), null, null, 111, null));
      paramTrackModel.a(paramIDragView.getDragViewModel());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      a(paramTrackModel, paramIDragView, localLayoutParams);
      paramTrackModel = this.f;
      if (paramTrackModel != null)
      {
        paramTrackModel = paramTrackModel.e();
        if (paramTrackModel != null) {
          paramTrackModel.c();
        }
      }
      paramTrackModel = this.d;
      if (paramTrackModel != null) {
        paramTrackModel.addView(localView, (ViewGroup.LayoutParams)localLayoutParams);
      }
      k();
      a(localView, true);
      paramIDragView.setValueChangeListener((IValueChangeListener)new PositionChangedHandler((IDragDropScrollView)this));
    }
  }
  
  public final void a(@NotNull PanelEvent paramPanelEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramPanelEvent, "panelEvent");
    Object localObject = this.f;
    if (localObject != null)
    {
      localObject = ((DragDropScrollViewController)localObject).c();
      if (localObject != null) {
        ((PanelEventHandler)localObject).a(paramPanelEvent);
      }
    }
  }
  
  public final boolean a(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    BottomLineRelativeLayout localBottomLineRelativeLayout = this.d;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localBottomLineRelativeLayout != null)
    {
      bool1 = bool2;
      if (paramView.getY() + paramView.getHeight() >= localBottomLineRelativeLayout.getBottom() - this.b) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final boolean a(@NotNull View paramView, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    boolean bool = c(paramView, paramInt);
    return d(paramView) | bool;
  }
  
  public int b(int paramInt)
  {
    HorizontalScrollView localHorizontalScrollView = this.c;
    if (localHorizontalScrollView == null) {
      Intrinsics.throwNpe();
    }
    return localHorizontalScrollView.getScrollX() + this.p - a(paramInt);
  }
  
  public final void b()
  {
    if (!this.h)
    {
      BottomLineRelativeLayout localBottomLineRelativeLayout = this.d;
      if (localBottomLineRelativeLayout != null) {
        localBottomLineRelativeLayout.setDrawBottomLine(false);
      }
    }
  }
  
  public final void b(int paramInt, @NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "dragView");
    BottomLineRelativeLayout localBottomLineRelativeLayout = this.d;
    if (localBottomLineRelativeLayout != null)
    {
      if (paramInt + paramView.getWidth() <= localBottomLineRelativeLayout.getWidth() - localBottomLineRelativeLayout.getPaddingRight()) {
        return;
      }
      paramView = this.f;
      if (paramView != null)
      {
        paramView = paramView.e();
        if (paramView != null) {
          paramView.c();
        }
      }
    }
  }
  
  public void b(@NotNull IDragView paramIDragView)
  {
    Intrinsics.checkParameterIsNotNull(paramIDragView, "dragView");
    a(paramIDragView, -1);
  }
  
  public final void b(@Nullable String paramString)
  {
    Iterator localIterator1 = getTrackModels().iterator();
    int i1 = 0;
    int i2;
    do
    {
      if (!localIterator1.hasNext()) {
        break;
      }
      TrackModel localTrackModel = (TrackModel)localIterator1.next();
      Iterator localIterator2 = localTrackModel.a().iterator();
      do
      {
        i2 = i1;
        if (!localIterator2.hasNext()) {
          break;
        }
      } while (!Intrinsics.areEqual(paramString, ((DragViewModel)localIterator2.next()).e()));
      i2 = 1;
      localTrackModel.a(paramString);
      i1 = i2;
    } while (i2 == 0);
    c(paramString);
    paramString = this.f;
    if (paramString != null)
    {
      paramString = paramString.e();
      if (paramString != null) {
        paramString.c();
      }
    }
  }
  
  public int c(int paramInt)
  {
    HorizontalScrollView localHorizontalScrollView = this.c;
    if (localHorizontalScrollView == null) {
      Intrinsics.throwNpe();
    }
    return localHorizontalScrollView.getScrollX() - this.p + a(paramInt);
  }
  
  public final void c()
  {
    if (!this.h)
    {
      BottomLineRelativeLayout localBottomLineRelativeLayout = this.d;
      if (localBottomLineRelativeLayout != null) {
        localBottomLineRelativeLayout.setDrawBottomLine(true);
      }
      performHapticFeedback(0, 2);
    }
  }
  
  public final void c(@Nullable IDragView paramIDragView)
  {
    BottomLineRelativeLayout localBottomLineRelativeLayout = this.d;
    if (localBottomLineRelativeLayout != null)
    {
      int i2 = localBottomLineRelativeLayout.getChildCount();
      int i1 = 0;
      while (i1 < i2)
      {
        View localView = localBottomLineRelativeLayout.getChildAt(i1);
        if (Intrinsics.areEqual(localView, paramIDragView)) {
          localView = null;
        }
        if (localView != null) {
          localView.setSelected(false);
        }
        i1 += 1;
      }
    }
  }
  
  public final void d(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("refreshWidth called minWidth is : ");
    ((StringBuilder)localObject).append(paramInt);
    WinkQLog.a("DragDrop-ScrollView", ((StringBuilder)localObject).toString());
    localObject = this.d;
    if (localObject != null)
    {
      ViewGroup.LayoutParams localLayoutParams = ((BottomLineRelativeLayout)localObject).getLayoutParams();
      localLayoutParams.width = paramInt;
      ((BottomLineRelativeLayout)localObject).setLayoutParams(localLayoutParams);
    }
  }
  
  public final boolean d()
  {
    BottomLineRelativeLayout localBottomLineRelativeLayout = this.d;
    if (localBottomLineRelativeLayout != null) {
      return localBottomLineRelativeLayout.a();
    }
    return false;
  }
  
  public void e()
  {
    BottomLineRelativeLayout localBottomLineRelativeLayout = this.d;
    int i1;
    if (localBottomLineRelativeLayout != null) {
      i1 = localBottomLineRelativeLayout.getWidth();
    } else {
      i1 = 0;
    }
    this.r = i1;
  }
  
  public final void f()
  {
    TrackManager localTrackManager = this.i;
    if (localTrackManager == null) {
      Intrinsics.throwUninitializedPropertyAccessException("trackManager");
    }
    localTrackManager.d();
  }
  
  public void fling(int paramInt)
  {
    FlingHelper localFlingHelper = this.o;
    float f2 = paramInt;
    float f3 = getScrollY();
    BottomLineRelativeLayout localBottomLineRelativeLayout = this.d;
    float f1;
    if (localBottomLineRelativeLayout != null) {
      f1 = localBottomLineRelativeLayout.getMeasuredHeight();
    } else {
      f1 = 0.0F;
    }
    localFlingHelper.a(f2, f3, f1, this.q);
  }
  
  @Nullable
  public final BottomLineRelativeLayout getContentView()
  {
    return this.d;
  }
  
  public final int getContentViewWidth$qq_wink_impl_release()
  {
    BottomLineRelativeLayout localBottomLineRelativeLayout = this.d;
    int i1 = 0;
    int i2 = 0;
    if (localBottomLineRelativeLayout != null)
    {
      int i4 = localBottomLineRelativeLayout.getChildCount();
      int i3;
      for (i1 = 0; i2 < i4; i1 = i3)
      {
        Object localObject = localBottomLineRelativeLayout.getChildAt(i2);
        Intrinsics.checkExpressionValueIsNotNull(localObject, "it.getChildAt(i)");
        localObject = IDragViewCastUtilKt.a((View)localObject);
        i3 = i1;
        if (localObject != null)
        {
          i3 = i1;
          if (((IDragView)localObject).getEndPosition() > i1) {
            i3 = ((IDragView)localObject).getEndPosition();
          }
        }
        i2 += 1;
      }
    }
    return i1 + getTrackLeftMargin$qq_wink_impl_release() + getTrackRightMargin$qq_wink_impl_release();
  }
  
  public int getHalfScreenWidth()
  {
    return this.p;
  }
  
  public int getHorizontalScrollX()
  {
    HorizontalScrollView localHorizontalScrollView = this.c;
    if (localHorizontalScrollView != null) {
      return localHorizontalScrollView.getScrollX();
    }
    return 0;
  }
  
  public int getMaxCanScrollPx()
  {
    return (int)1.073742E+009F;
  }
  
  public int getMaxPosition()
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      if (localObject != null)
      {
        localObject = ((DragDropScrollViewController)localObject).a();
        if (localObject != null)
        {
          localObject = Integer.valueOf(((ScaleCalculator)localObject).d());
          break label35;
        }
      }
      localObject = null;
      label35:
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      return ((Integer)localObject).intValue() + getScreenWidth();
    }
    throw ((Throwable)new Exception("scaleCalculator is null, need set scaleCalculator first"));
  }
  
  public int getMaxSpace()
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      localObject = ((DragDropScrollViewController)localObject).a();
      if (localObject != null) {
        return ((ScaleCalculator)localObject).d();
      }
    }
    return 0;
  }
  
  public float getMinAttractDistance()
  {
    return getMinAttractDistance$qq_wink_impl_release();
  }
  
  public final float getMinAttractDistance$qq_wink_impl_release()
  {
    return a(5);
  }
  
  @Nullable
  public final View getSelectedDragView$qq_wink_impl_release()
  {
    BottomLineRelativeLayout localBottomLineRelativeLayout = this.d;
    if (localBottomLineRelativeLayout != null)
    {
      int i1 = 0;
      int i2 = localBottomLineRelativeLayout.getChildCount();
      while (i1 < i2)
      {
        View localView = localBottomLineRelativeLayout.getChildAt(i1);
        Intrinsics.checkExpressionValueIsNotNull(localView, "it.getChildAt(i)");
        if (((localView instanceof IDragView)) && (localView.isSelected())) {
          return localView;
        }
        i1 += 1;
      }
    }
    return null;
  }
  
  @RequiresApi(17)
  public int getStartPosition()
  {
    BottomLineRelativeLayout localBottomLineRelativeLayout = this.d;
    if (localBottomLineRelativeLayout != null) {
      return localBottomLineRelativeLayout.getPaddingStart();
    }
    return 0;
  }
  
  public final int getTrackHeight$qq_wink_impl_release()
  {
    TrackManager localTrackManager = this.i;
    if (localTrackManager == null) {
      Intrinsics.throwUninitializedPropertyAccessException("trackManager");
    }
    return localTrackManager.b();
  }
  
  public final int getTrackLeftMargin$qq_wink_impl_release()
  {
    return this.p;
  }
  
  public final int getTrackMargin$qq_wink_impl_release()
  {
    TrackManager localTrackManager = this.i;
    if (localTrackManager == null) {
      Intrinsics.throwUninitializedPropertyAccessException("trackManager");
    }
    return localTrackManager.c();
  }
  
  @NotNull
  public ArrayList<TrackModel> getTrackModels()
  {
    TrackManager localTrackManager = this.i;
    if (localTrackManager == null) {
      Intrinsics.throwUninitializedPropertyAccessException("trackManager");
    }
    return localTrackManager.a();
  }
  
  public final int getTrackRightMargin$qq_wink_impl_release()
  {
    return this.p;
  }
  
  public boolean onInterceptTouchEvent(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "ev");
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if (i1 == 2)
      {
        this.k += Math.abs(paramMotionEvent.getX() - this.m);
        this.l += Math.abs(paramMotionEvent.getY() - this.n);
        this.m = paramMotionEvent.getX();
        this.n = paramMotionEvent.getY();
        if (this.k > this.l) {
          return false;
        }
      }
    }
    else
    {
      this.l = 0.0F;
      this.k = 0.0F;
      this.m = paramMotionEvent.getX();
      this.n = paramMotionEvent.getY();
      computeScroll();
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.j.a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setAdsorbedPoint(@Nullable AttractPoint paramAttractPoint1, @Nullable AttractPoint paramAttractPoint2)
  {
    DragDropScrollViewController localDragDropScrollViewController = this.f;
    if (localDragDropScrollViewController != null) {
      localDragDropScrollViewController.a(paramAttractPoint1, paramAttractPoint2);
    }
  }
  
  public final void setAttractPointPosition$qq_wink_impl_release(@Nullable Set<Integer> paramSet)
  {
    if (paramSet != null)
    {
      if (paramSet.isEmpty()) {
        return;
      }
      this.e.clear();
      this.e.addAll((Collection)paramSet);
    }
  }
  
  public final void setCanAddEmptyTrackOnDrop$qq_wink_impl_release(boolean paramBoolean)
  {
    this.j.a(paramBoolean);
  }
  
  public final void setContentView(@Nullable BottomLineRelativeLayout paramBottomLineRelativeLayout)
  {
    this.d = paramBottomLineRelativeLayout;
  }
  
  public final void setDisableBottomLine$qq_wink_impl_release(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public final void setNeedDrawTrackBackground$qq_wink_impl_release(boolean paramBoolean)
  {
    BottomLineRelativeLayout localBottomLineRelativeLayout = this.d;
    if (localBottomLineRelativeLayout != null) {
      localBottomLineRelativeLayout.setNeedDrawTrackBackground(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.DragDropScrollView
 * JD-Core Version:    0.7.0.1
 */