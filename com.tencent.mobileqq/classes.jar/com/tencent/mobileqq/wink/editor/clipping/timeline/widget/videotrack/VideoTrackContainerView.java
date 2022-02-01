package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.RelativeLayout;
import androidx.annotation.RequiresApi;
import androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener;
import com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.ClipItemLongClickListener;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.BaseTimelineViewController;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.ITimelineView;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.config.CommonConfig;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.config.VideoTrackConfig;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.DragModel;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.IValueChangeListener;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.PositionChangedHandler;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.TimelineViewListener;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.TimelinePanelViewController;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scale.ScaleCalculator;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scroll.FlingHelper;
import com.tencent.videocut.utils.DensityUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView;", "Landroid/widget/HorizontalScrollView;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/ITimelineView;", "mContext", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "controller", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackController;", "cornerRadius", "handleView", "Landroid/view/View;", "hasDownEvent", "", "hasUpEvent", "itemLongClickListener", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/ClipItemLongClickListener;", "lastTouchPoint", "Landroid/graphics/Point;", "listener", "Landroidx/dynamicanimation/animation/DynamicAnimation$OnAnimationUpdateListener;", "positionChangedHandler", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/PositionChangedHandler;", "getPositionChangedHandler", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/PositionChangedHandler;", "setPositionChangedHandler", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/PositionChangedHandler;)V", "rootView", "Landroid/widget/RelativeLayout;", "getRootView", "()Landroid/widget/RelativeLayout;", "rootView$delegate", "Lkotlin/Lazy;", "selectListener", "com/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView$selectListener$1", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView$selectListener$1;", "timeLineViewListener", "com/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView$timeLineViewListener$1", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView$timeLineViewListener$1;", "videoTrackViews", "", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackTimelineView;", "bindController", "", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/BaseTimelineViewController;", "createAndAddTrackView", "scaleCalculator", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scale/ScaleCalculator;", "cutViewListAndRelease", "T", "source", "targetSize", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "fling", "velocityX", "getContentWidth", "getVideoTrackViews", "", "onScrollChanged", "l", "t", "oldl", "oldt", "onTouchEvent", "refreshAllContentView", "refreshContentWidth", "width", "refreshVideoClip", "clipModels", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackModel;", "transitionList", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTransitionModel;", "refreshViewByUuid", "uuid", "", "setHandleView", "view", "setItemOnLongClickListener", "startTrackUp", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class VideoTrackContainerView
  extends HorizontalScrollView
  implements ITimelineView
{
  private VideoTrackController a;
  private final Lazy b = LazyKt.lazy((Function0)new VideoTrackContainerView.rootView.2(this));
  private final List<VideoTrackTimelineView> c = (List)new ArrayList();
  private int d = -1;
  @Nullable
  private PositionChangedHandler e;
  private ClipItemLongClickListener f;
  private Point g = new Point();
  private View h;
  private boolean i;
  private boolean j;
  private final DynamicAnimation.OnAnimationUpdateListener k;
  private final VideoTrackContainerView.timeLineViewListener.1 l;
  private final VideoTrackContainerView.selectListener.1 m;
  
  @JvmOverloads
  public VideoTrackContainerView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public VideoTrackContainerView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public VideoTrackContainerView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    addView((View)getRootView(), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    setOverScrollMode(2);
    getRootView().setOnClickListener((View.OnClickListener)new VideoTrackContainerView.1(this));
    this.k = ((DynamicAnimation.OnAnimationUpdateListener)new VideoTrackContainerView.listener.1(this));
    this.l = new VideoTrackContainerView.timeLineViewListener.1(this);
    this.m = new VideoTrackContainerView.selectListener.1(this);
  }
  
  @RequiresApi(17)
  private final VideoTrackTimelineView a(ScaleCalculator paramScaleCalculator)
  {
    int n = View.generateViewId();
    DragModel localDragModel = new DragModel(VideoTrackTimelineView.class, 0L, 0L, 0L, 0, String.valueOf(n), 30, null);
    Object localObject1 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "context");
    localObject1 = new VideoTrackTimelineView((Context)localObject1, null, 0, localDragModel, 6, null);
    Object localObject2 = this.a;
    if (localObject2 != null) {
      ((VideoTrackTimelineView)localObject1).setSingleBitmapWidth(DensityUtils.a.a(((VideoTrackController)localObject2).b().c().a()));
    }
    ((VideoTrackTimelineView)localObject1).setId(n);
    localObject2 = this.a;
    if (localObject2 != null)
    {
      localObject2 = ((VideoTrackController)localObject2).i();
      if (localObject2 != null) {
        ((VideoTrackTimelineView)localObject1).setThumbnailProvider((IThumbnailProvider)localObject2);
      }
    }
    ((VideoTrackTimelineView)localObject1).setCornerRadius(this.d);
    ((VideoTrackTimelineView)localObject1).setScaleCalculator(paramScaleCalculator);
    ((VideoTrackTimelineView)localObject1).a(localDragModel);
    ((VideoTrackTimelineView)localObject1).setSelectListener((VideoTrackTimelineView.ContentSelectListener)this.m);
    ((VideoTrackTimelineView)localObject1).setValueChangeListener((IValueChangeListener)this.e);
    ((VideoTrackTimelineView)localObject1).setTimelineViewListener((TimelineViewListener)this.l);
    getRootView().addView((View)localObject1);
    this.c.add(localObject1);
    return localObject1;
  }
  
  private final <T extends View> void a(List<T> paramList, int paramInt)
  {
    int n;
    if ((paramList.size() > paramInt) && (paramInt >= 0)) {
      n = 1;
    } else {
      n = 0;
    }
    Object localObject;
    if (n != 0) {
      localObject = paramList;
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      localObject = ((Iterable)CollectionsKt.toList((Iterable)((List)localObject).subList(paramInt, paramList.size()))).iterator();
      while (((Iterator)localObject).hasNext())
      {
        View localView = (View)((Iterator)localObject).next();
        paramList.remove(localView);
        getRootView().removeView(localView);
      }
    }
  }
  
  @RequiresApi(17)
  private final void c()
  {
    Iterator localIterator = ((Iterable)this.c).iterator();
    while (localIterator.hasNext()) {
      ((VideoTrackTimelineView)localIterator.next()).h();
    }
  }
  
  private final void d()
  {
    a(getContentWidth());
  }
  
  private final int getContentWidth()
  {
    VideoTrackController localVideoTrackController = this.a;
    if (localVideoTrackController != null) {
      return localVideoTrackController.g();
    }
    return 0;
  }
  
  private final RelativeLayout getRootView()
  {
    return (RelativeLayout)this.b.getValue();
  }
  
  public final void a()
  {
    this.j = false;
  }
  
  public final void a(int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams = getRootView().getLayoutParams();
    localLayoutParams.width = paramInt;
    getRootView().setLayoutParams(localLayoutParams);
  }
  
  public void a(@NotNull BaseTimelineViewController<?> paramBaseTimelineViewController)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseTimelineViewController, "controller");
    BaseTimelineViewController<?> localBaseTimelineViewController = paramBaseTimelineViewController;
    if (!(paramBaseTimelineViewController instanceof VideoTrackController)) {
      localBaseTimelineViewController = null;
    }
    this.a = ((VideoTrackController)localBaseTimelineViewController);
  }
  
  @RequiresApi(17)
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uuid");
    Object localObject1 = (Iterable)this.c;
    Collection localCollection = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (Intrinsics.areEqual(((VideoTrackTimelineView)localObject2).getUuid(), paramString)) {
        localCollection.add(localObject2);
      }
    }
    paramString = ((Iterable)localCollection).iterator();
    while (paramString.hasNext()) {
      ((VideoTrackTimelineView)paramString.next()).h();
    }
  }
  
  @RequiresApi(17)
  public final void a(@NotNull List<VideoTrackModel> paramList, @NotNull List<VideoTransitionModel> paramList1)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "clipModels");
    Intrinsics.checkParameterIsNotNull(paramList1, "transitionList");
    paramList1 = this.a;
    if (paramList1 != null)
    {
      ScaleCalculator localScaleCalculator = paramList1.a();
      if (localScaleCalculator != null)
      {
        a(this.c, paramList.size());
        Iterator localIterator = ((Iterable)paramList).iterator();
        int n = 0;
        for (;;)
        {
          boolean bool = localIterator.hasNext();
          ViewGroup localViewGroup = null;
          if (!bool) {
            break;
          }
          paramList1 = localIterator.next();
          if (n < 0) {
            CollectionsKt.throwIndexOverflow();
          }
          VideoTrackModel localVideoTrackModel = (VideoTrackModel)paramList1;
          paramList1 = this.c;
          if ((n >= 0) && (n <= CollectionsKt.getLastIndex(paramList1))) {
            paramList1 = paramList1.get(n);
          } else {
            paramList1 = a(localScaleCalculator);
          }
          VideoTrackTimelineView localVideoTrackTimelineView = (VideoTrackTimelineView)paramList1;
          if (n == CollectionsKt.getLastIndex(paramList)) {
            bool = true;
          } else {
            bool = false;
          }
          VideoTrackController localVideoTrackController = this.a;
          paramList1 = localViewGroup;
          if (localVideoTrackController != null) {
            paramList1 = localVideoTrackController.b();
          }
          localVideoTrackTimelineView.a(localVideoTrackModel, bool, paramList1);
          paramList1 = this.f;
          if (paramList1 != null)
          {
            localViewGroup = localVideoTrackTimelineView.getContentView();
            if (localViewGroup != null) {
              localViewGroup.setOnLongClickListener((View.OnLongClickListener)new VideoTrackContainerView.refreshVideoClip..inlined.forEachIndexed.lambda.1(paramList1, localVideoTrackTimelineView, localVideoTrackModel, this, localScaleCalculator, paramList));
            }
          }
          n += 1;
        }
        paramList1 = ((Iterable)this.c).iterator();
        while (paramList1.hasNext())
        {
          paramList = paramList1.next();
          if (((VideoTrackTimelineView)paramList).isSelected()) {
            break label283;
          }
        }
        paramList = null;
        label283:
        paramList = (VideoTrackTimelineView)paramList;
        if (paramList != null) {
          paramList.bringToFront();
        }
        d();
        paramList = this.a;
        if (paramList != null)
        {
          paramList = paramList.e();
          if (paramList != null) {
            paramList.e();
          }
        }
      }
    }
  }
  
  public final boolean b()
  {
    return this.j;
  }
  
  public boolean dispatchTouchEvent(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "ev");
    this.g = new Point((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY());
    boolean bool;
    if ((paramMotionEvent.getActionMasked() != 1) && (paramMotionEvent.getActionMasked() != 3)) {
      bool = false;
    } else {
      bool = true;
    }
    this.j = bool;
    View localView1 = this.h;
    if (localView1 != null)
    {
      if (!this.i)
      {
        MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
        Intrinsics.checkExpressionValueIsNotNull(localMotionEvent, "down");
        localMotionEvent.setAction(0);
        View localView2 = this.h;
        if (localView2 != null) {
          localView2.dispatchTouchEvent(localMotionEvent);
        }
        this.i = true;
      }
      return localView1.dispatchTouchEvent(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void fling(int paramInt)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((VideoTrackController)localObject).f();
      if (localObject != null) {
        ((FlingHelper)localObject).a(paramInt, getScrollX(), getRootView().getMeasuredWidth(), this.k);
      }
    }
  }
  
  @Nullable
  public final PositionChangedHandler getPositionChangedHandler()
  {
    return this.e;
  }
  
  @NotNull
  public final List<VideoTrackTimelineView> getVideoTrackViews()
  {
    return this.c;
  }
  
  @RequiresApi(17)
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    VideoTrackController localVideoTrackController = this.a;
    if (localVideoTrackController != null) {
      localVideoTrackController.b(paramInt1);
    }
    c();
  }
  
  public boolean onTouchEvent(@Nullable MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    if ((bool) && (paramMotionEvent != null) && (paramMotionEvent.getAction() == 2))
    {
      paramMotionEvent = this.a;
      if (paramMotionEvent != null)
      {
        paramMotionEvent = paramMotionEvent.f();
        if (paramMotionEvent != null) {
          paramMotionEvent.b();
        }
      }
    }
    return bool;
  }
  
  public final void setHandleView(@Nullable View paramView)
  {
    this.h = paramView;
    this.i = false;
  }
  
  public final void setItemOnLongClickListener(@NotNull ClipItemLongClickListener paramClipItemLongClickListener)
  {
    Intrinsics.checkParameterIsNotNull(paramClipItemLongClickListener, "listener");
    this.f = paramClipItemLongClickListener;
  }
  
  public final void setPositionChangedHandler(@Nullable PositionChangedHandler paramPositionChangedHandler)
  {
    this.e = paramPositionChangedHandler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VideoTrackContainerView
 * JD-Core Version:    0.7.0.1
 */