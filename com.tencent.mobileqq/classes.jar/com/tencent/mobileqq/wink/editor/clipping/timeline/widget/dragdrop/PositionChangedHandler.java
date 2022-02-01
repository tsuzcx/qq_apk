package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop;

import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/PositionChangedHandler;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/IValueChangeListener;", "dropScrollView", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/IDragDropScrollView;", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/IDragDropScrollView;)V", "currentScrollEndPosition", "", "currentScrollStartPosition", "isScrollingLeft", "", "isScrollingRight", "lastVibrateEndPositionByScale", "lastVibrateStartPositionByScale", "scrollAnimator", "Landroid/animation/ValueAnimator;", "adjustEndPosition", "Lkotlin/Pair;", "dragViewModel", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragViewModel;", "presetEndPosition", "rawEndPosition", "maxEndPosition", "minEndPosition", "adjustEndPositionByAttractPoint", "position", "adjustStartPosition", "dragView", "Landroid/view/View;", "presetPosition", "rawStartPosition", "minPosition", "maxStartPosition", "adjustStartPositionByAttractPoint", "adjustedPosition", "canPutInCurrentTrack", "startPosition", "endPosition", "checkBoundaryForEnd", "iDragView", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/IDragView;", "checkBoundaryForStart", "doScrollLeftAnimation", "", "animatedValue", "beforeScrollPosition", "startScrollX", "doScrollRightAnimation", "getAdjustedEndPosition", "offsetX", "getAdjustedStartPosition", "getDurationByAnimateValue", "", "getSameTrackMaxEnd", "getSameTrackMinStart", "handleGetAdjustedEndPosition", "handleGetAdjustedStartPosition", "isAttractLeft", "diff", "minStartPoint", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/AttractPoint;", "attractX", "isAttractRight", "minEndPoint", "attractPoint", "onMoveEnd", "positionOffset", "isUp", "view", "isLeft", "onSelectStateChanged", "isSelected", "onSliderDown", "requestLayout", "setAdsorbedPointForNotChangedSlide", "smoothScrollToLeft", "smoothScrollToRight", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public class PositionChangedHandler
  implements IValueChangeListener
{
  public static final PositionChangedHandler.Companion a = new PositionChangedHandler.Companion(null);
  private boolean b;
  private boolean c;
  private ValueAnimator d;
  private int e;
  private int f;
  private int g;
  private int h;
  private final IDragDropScrollView i;
  
  public PositionChangedHandler(@NotNull IDragDropScrollView paramIDragDropScrollView)
  {
    this.i = paramIDragDropScrollView;
    this.g = -1;
    this.h = -1;
  }
  
  private final int a(int paramInt, IDragView paramIDragView)
  {
    if (paramInt < 0) {
      return -1;
    }
    if (paramInt > paramIDragView.getEndPosition() - paramIDragView.getMinDistance()) {
      return paramIDragView.getEndPosition() - paramIDragView.getMinDistance();
    }
    return -1;
  }
  
  private final int a(DragViewModel paramDragViewModel)
  {
    List localList = CollectionsKt.sortedWith((Iterable)((TrackModel)this.i.getTrackModels().get(paramDragViewModel.d())).a(), (Comparator)PositionChangedHandler.getSameTrackMinStart.blocks.1.a);
    int j = localList.indexOf(paramDragViewModel) + 1;
    if (j >= localList.size()) {
      return -1;
    }
    return ((DragViewModel)localList.get(j)).c();
  }
  
  private final long a(int paramInt)
  {
    return Math.abs(paramInt);
  }
  
  private final Pair<Integer, Boolean> a(int paramInt1, int paramInt2, int paramInt3, DragViewModel paramDragViewModel, int paramInt4)
  {
    int j = RangesKt.coerceAtLeast(paramInt3, paramInt1);
    Object localObject1 = Integer.valueOf(a(paramDragViewModel));
    paramInt1 = ((Number)localObject1).intValue();
    boolean bool = false;
    if (paramInt1 != -1) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if (paramInt1 == 0) {
      localObject1 = null;
    }
    paramInt1 = j;
    if (localObject1 != null) {
      paramInt1 = RangesKt.coerceAtLeast(j, ((Number)localObject1).intValue());
    }
    Object localObject2 = (Iterable)this.i.a(paramDragViewModel.e());
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (((AttractPoint)localObject3).b() < paramInt4) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    localObject2 = (List)localObject1;
    localObject1 = (AttractPoint)null;
    Object localObject3 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject2 = (AttractPoint)((Iterator)localObject3).next();
      if (a(Math.abs(paramInt2 - ((AttractPoint)localObject2).b()), (AttractPoint)localObject1, ((AttractPoint)localObject2).b(), paramDragViewModel))
      {
        paramInt4 = RangesKt.coerceAtLeast(((AttractPoint)localObject2).b(), paramInt3);
        paramInt1 = paramInt4;
        if (this.g == -1)
        {
          this.g = paramInt4;
          localObject1 = localObject2;
          bool = true;
          paramInt1 = paramInt4;
        }
      }
    }
    if (localObject1 != null) {
      this.i.setAdsorbedPoint((AttractPoint)localObject1, null);
    }
    return new Pair(Integer.valueOf(paramInt1), Boolean.valueOf(bool));
  }
  
  private final Pair<Integer, Boolean> a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView = IDragViewCastUtilKt.a(paramView);
    if (paramView != null)
    {
      paramView = paramView.getDragViewModel();
      if (paramView != null)
      {
        paramView = a(paramInt1, paramInt2, paramInt3, paramView, paramInt4);
        paramInt1 = ((Number)paramView.getFirst()).intValue();
        if (this.g != paramInt1) {
          this.g = -1;
        }
        return new Pair(Integer.valueOf(paramInt1), paramView.getSecond());
      }
    }
    return new Pair(Integer.valueOf(-1), Boolean.valueOf(false));
  }
  
  private final Pair<Integer, Boolean> a(DragViewModel paramDragViewModel, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramDragViewModel = b(paramInt1, paramInt2, paramInt3, paramDragViewModel, paramInt4);
    paramInt1 = ((Number)paramDragViewModel.getFirst()).intValue();
    if (paramInt1 != this.h) {
      this.h = -1;
    }
    return new Pair(Integer.valueOf(paramInt1), paramDragViewModel.getSecond());
  }
  
  private final void a(int paramInt1, int paramInt2, IDragView paramIDragView, int paramInt3)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, paramInt1 });
    Intrinsics.checkExpressionValueIsNotNull(localValueAnimator, "this");
    localValueAnimator.setDuration(a(paramInt1));
    localValueAnimator.setInterpolator((TimeInterpolator)new LinearInterpolator());
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new PositionChangedHandler.doScrollLeftAnimation..inlined.apply.lambda.1(this, paramInt1, paramInt2, paramIDragView, paramInt3));
    localValueAnimator.addListener((Animator.AnimatorListener)new PositionChangedHandler.doScrollLeftAnimation..inlined.apply.lambda.2(this, paramInt1, paramInt2, paramIDragView, paramInt3));
    localValueAnimator.start();
    this.d = localValueAnimator;
  }
  
  private final void a(IDragView paramIDragView, int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2) {
      this.b = true;
    } else if (paramInt1 > paramInt2) {
      this.c = true;
    }
    int j = this.i.getHorizontalScrollX();
    if (paramInt2 == paramIDragView.getStartPosition())
    {
      IDragDropScrollView localIDragDropScrollView = this.i;
      paramInt2 = paramInt2 - paramInt1 + (localIDragDropScrollView.b(localIDragDropScrollView.getHalfScreenWidth()) - this.i.c(50));
    }
    else
    {
      paramInt2 -= paramInt1;
    }
    a(paramInt2, paramInt1, paramIDragView, j);
  }
  
  private final void a(boolean paramBoolean, DragViewModel paramDragViewModel)
  {
    if (paramBoolean)
    {
      this.i.setAdsorbedPoint(null, new AttractPoint(0L, paramDragViewModel.c(), paramDragViewModel.e(), false));
      return;
    }
    this.i.setAdsorbedPoint(new AttractPoint(0L, paramDragViewModel.b(), paramDragViewModel.e(), true), null);
  }
  
  private final boolean a(int paramInt1, AttractPoint paramAttractPoint, int paramInt2, DragViewModel paramDragViewModel)
  {
    return (paramInt1 < this.i.getMinAttractDistance()) && ((paramAttractPoint == null) || (paramInt1 < Math.abs(paramAttractPoint.b() - paramInt2))) && (a(paramDragViewModel, paramInt2, paramDragViewModel.c()));
  }
  
  private final boolean a(int paramInt, AttractPoint paramAttractPoint1, AttractPoint paramAttractPoint2, DragViewModel paramDragViewModel)
  {
    return (paramInt < this.i.getMinAttractDistance()) && ((paramAttractPoint1 == null) || (paramInt < Math.abs(paramAttractPoint1.b() - paramAttractPoint2.b()))) && (a(paramDragViewModel, paramDragViewModel.b(), paramAttractPoint2.b()));
  }
  
  private final boolean a(DragViewModel paramDragViewModel, int paramInt1, int paramInt2)
  {
    Object localObject = this.i.getTrackModels().get(paramDragViewModel.d());
    Intrinsics.checkExpressionValueIsNotNull(localObject, "dropScrollView.trackMode…dragViewModel.trackIndex]");
    return ((TrackModel)localObject).a(paramDragViewModel, paramInt1, paramInt2);
  }
  
  private final int b(int paramInt, IDragView paramIDragView)
  {
    if (paramInt > this.i.getMaxPosition()) {
      return -1;
    }
    if (paramInt < paramIDragView.getStartPosition() + paramIDragView.getMinDistance()) {
      return paramIDragView.getStartPosition() + paramIDragView.getMinDistance();
    }
    return -1;
  }
  
  private final int b(DragViewModel paramDragViewModel)
  {
    List localList = CollectionsKt.sortedWith((Iterable)((TrackModel)this.i.getTrackModels().get(paramDragViewModel.d())).a(), (Comparator)PositionChangedHandler.getSameTrackMaxEnd.blocks.1.a);
    int j = localList.indexOf(paramDragViewModel) + 1;
    if (j >= localList.size()) {
      return -1;
    }
    return ((DragViewModel)localList.get(j)).b();
  }
  
  private final Pair<Integer, Boolean> b(int paramInt1, int paramInt2, int paramInt3, DragViewModel paramDragViewModel, int paramInt4)
  {
    int j = RangesKt.coerceAtMost(paramInt3, paramInt1);
    Object localObject1 = Integer.valueOf(b(paramDragViewModel));
    paramInt1 = ((Number)localObject1).intValue();
    boolean bool = false;
    if (paramInt1 != -1) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if (paramInt1 == 0) {
      localObject1 = null;
    }
    paramInt1 = j;
    if (localObject1 != null) {
      paramInt1 = RangesKt.coerceAtMost(j, ((Number)localObject1).intValue());
    }
    Object localObject2 = (Iterable)this.i.a(paramDragViewModel.e());
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (((AttractPoint)localObject3).b() > paramInt4) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    localObject2 = (List)localObject1;
    localObject1 = (AttractPoint)null;
    Object localObject3 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject2 = (AttractPoint)((Iterator)localObject3).next();
      if (a(Math.abs(paramInt2 - ((AttractPoint)localObject2).b()), (AttractPoint)localObject1, (AttractPoint)localObject2, paramDragViewModel))
      {
        paramInt4 = RangesKt.coerceAtMost(((AttractPoint)localObject2).b(), paramInt3);
        paramInt1 = paramInt4;
        if (this.h == -1)
        {
          this.h = paramInt4;
          localObject1 = localObject2;
          bool = true;
          paramInt1 = paramInt4;
        }
      }
    }
    if (localObject1 != null) {
      this.i.setAdsorbedPoint(null, (AttractPoint)localObject1);
    }
    return new Pair(Integer.valueOf(paramInt1), Boolean.valueOf(bool));
  }
  
  private final void b(int paramInt1, int paramInt2, IDragView paramIDragView, int paramInt3)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, paramInt1 });
    Intrinsics.checkExpressionValueIsNotNull(localValueAnimator, "this");
    localValueAnimator.setDuration(a(paramInt1));
    localValueAnimator.setInterpolator((TimeInterpolator)new LinearInterpolator());
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new PositionChangedHandler.doScrollRightAnimation..inlined.apply.lambda.1(this, paramInt1, paramInt2, paramIDragView, paramInt3));
    localValueAnimator.addListener((Animator.AnimatorListener)new PositionChangedHandler.doScrollRightAnimation..inlined.apply.lambda.2(this, paramInt1, paramInt2, paramIDragView, paramInt3));
    localValueAnimator.start();
    this.d = localValueAnimator;
  }
  
  private final void b(IDragView paramIDragView, int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2) {
      this.b = true;
    } else if (paramInt1 > paramInt2) {
      this.c = true;
    }
    if (paramInt2 == this.i.getMaxPosition())
    {
      int j = this.i.b(50);
      IDragDropScrollView localIDragDropScrollView = this.i;
      paramInt2 = paramInt2 - paramInt1 + (j - localIDragDropScrollView.b(localIDragDropScrollView.getHalfScreenWidth()));
    }
    else
    {
      paramInt2 -= paramInt1;
    }
    b(paramInt2, paramInt1, paramIDragView, this.i.getHorizontalScrollX());
  }
  
  private final Pair<Boolean, Integer> c(View paramView, int paramInt1, int paramInt2)
  {
    IDragView localIDragView = IDragViewCastUtilKt.a(paramView);
    Integer localInteger = Integer.valueOf(0);
    Boolean localBoolean = Boolean.valueOf(false);
    if (localIDragView != null)
    {
      int j = a(paramInt1, localIDragView);
      if (j != -1) {
        return new Pair(Boolean.valueOf(true), Integer.valueOf(j));
      }
      j = localIDragView.getStartPosition();
      if ((!this.b) && (!this.c))
      {
        int n = this.i.c(50);
        int i1 = this.i.b(50);
        int k = localIDragView.getMinStartPosition();
        int m = localIDragView.getEndPosition() - localIDragView.getMinDistance();
        if ((paramInt1 <= n) && (paramInt1 < localIDragView.getStartPosition()))
        {
          paramInt2 = k;
          j = 1;
        }
        else
        {
          if ((i1 <= paramInt1) && (m > paramInt1))
          {
            a(localIDragView, paramInt2 + j, m);
            return new Pair(localBoolean, localInteger);
          }
          paramInt2 = paramInt1;
          j = 0;
        }
        Pair localPair = a(paramView, paramInt2, paramInt1, k, m);
        if (((Boolean)localPair.getSecond()).booleanValue()) {
          paramView.performHapticFeedback(0, 2);
        }
        if ((j != 0) && (((Number)localPair.getFirst()).intValue() < paramInt1))
        {
          a(localIDragView, paramInt1, ((Number)localPair.getFirst()).intValue());
          return new Pair(localBoolean, localInteger);
        }
        return new Pair(Boolean.valueOf(true), localPair.getFirst());
      }
      return new Pair(localBoolean, localInteger);
    }
    return new Pair(localBoolean, localInteger);
  }
  
  private final int d(View paramView, int paramInt1, int paramInt2)
  {
    IDragView localIDragView = IDragViewCastUtilKt.a(paramView);
    if (localIDragView != null)
    {
      int j = b(paramInt1, localIDragView);
      if (j != -1) {
        return j;
      }
      if (!this.b)
      {
        if (this.c) {
          return -1;
        }
        int k = this.i.c(50);
        int i1 = this.i.b(50);
        int m = paramInt2 + localIDragView.getEndPosition();
        if (localIDragView.f()) {
          j = this.i.getMaxCanScrollPx();
        } else {
          j = this.i.getMaxSpace();
        }
        paramInt2 = j;
        if (localIDragView.getMaxEndPosition() > 0) {
          paramInt2 = RangesKt.coerceAtMost(j, localIDragView.getMaxEndPosition());
        }
        int n = localIDragView.getStartPosition() + localIDragView.getMinDistance();
        if ((paramInt1 >= i1) && (paramInt1 > localIDragView.getEndPosition()))
        {
          k = 1;
          j = paramInt2;
        }
        else
        {
          if ((paramInt1 <= k) && (paramInt1 < localIDragView.getEndPosition()))
          {
            b(localIDragView, m, n);
            return -1;
          }
          j = paramInt1;
          k = 0;
        }
        Pair localPair = a(localIDragView.getDragViewModel(), j, paramInt1, paramInt2, n);
        if (((Boolean)localPair.getSecond()).booleanValue()) {
          paramView.performHapticFeedback(0, 2);
        }
        if ((k != 0) && (((Number)localPair.getFirst()).intValue() > paramInt1))
        {
          b(localIDragView, m, ((Number)localPair.getFirst()).intValue());
          return -1;
        }
        return ((Number)localPair.getFirst()).intValue();
      }
    }
    return -1;
  }
  
  @NotNull
  public Pair<Boolean, Integer> a(@NotNull View paramView, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "dragView");
    return c(paramView, paramInt1, paramInt2);
  }
  
  public void a(int paramInt, boolean paramBoolean1, @NotNull View paramView, boolean paramBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    ValueAnimator localValueAnimator = this.d;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning()))
    {
      localValueAnimator.cancel();
      localValueAnimator.removeAllUpdateListeners();
      this.d = ((ValueAnimator)null);
    }
    if (paramBoolean1)
    {
      this.i.a(paramInt, paramView);
      paramView = IDragViewCastUtilKt.a(paramView);
      if (paramView != null)
      {
        paramView = paramView.getDragViewModel();
        if (paramView != null) {
          a(paramBoolean2, paramView);
        }
      }
    }
  }
  
  public void a(@NotNull IDragView paramIDragView)
  {
    Intrinsics.checkParameterIsNotNull(paramIDragView, "dragView");
    this.i.b(paramIDragView);
  }
  
  public void a(@Nullable IDragView paramIDragView, boolean paramBoolean)
  {
    this.i.a(paramIDragView, paramBoolean);
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public int b(@NotNull View paramView, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "dragView");
    return d(paramView, paramInt1, paramInt2);
  }
  
  public boolean b()
  {
    return this.c;
  }
  
  public void c()
  {
    this.i.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.PositionChangedHandler
 * JD-Core Version:    0.7.0.1
 */