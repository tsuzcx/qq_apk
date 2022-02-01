package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop;

import android.graphics.PointF;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.PanelEvent;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.SelectChangedEvent;
import com.tencent.videocut.utils.DensityUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragEventHandler;", "Landroid/view/View$OnDragListener;", "dropScrollView", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragDropScrollView;", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragDropScrollView;)V", "canAddEmptyTrackOnDrop", "", "dragUp", "dragY", "", "draggingView", "Landroid/view/View;", "lastVibrateXByDrag", "lastVibrateYByDrag", "maxDragScrollPerFrame", "", "scrollRunnable", "Ljava/lang/Runnable;", "getScrollRunnable", "()Ljava/lang/Runnable;", "scrollRunnable$delegate", "Lkotlin/Lazy;", "scrollStartTime", "", "startDragPoint", "Landroid/graphics/PointF;", "startTouchPoint", "touchSlop", "xOffset", "adjustPositionByAttractPointOnDrag", "dragView", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/IDragView;", "newPosition", "expectStartPosition", "expectEndPosition", "adjustVerticalPositionOnDrag", "adjustViewPositionOnDrag", "", "newX", "newY", "attractEnd", "minEndAttractPoint", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/AttractPoint;", "attractStart", "minStartAttractPoint", "checkLeftOrRightAttractMin", "endPoint", "startPoint", "checkNeedRemoveOriginBlock", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/TrackModel;", "needRemoveOriginBlock", "trackModel", "checkNeedRemoveOriginalTrack", "needRemoveOriginal", "originalTrack", "iDragView", "doRecoveryTrack", "isSameTrack", "findMinAttractPoint", "Lkotlin/Pair;", "getScrollPositionInterpolation", "ratio", "getScrollTimeInterpolation", "handleDropView", "event", "Landroid/view/DragEvent;", "handleOnDragExit", "handleOnDragForActionEnded", "handleOnDragForActionLocation", "handleOnDragForActionStarted", "interpolateOutOfBoundsScroll", "viewSize", "viewSizeOutOfBounds", "interpolateOutOfBoundsScroll$qq_wink_impl_release", "isInCurrentTrack", "y", "isInterceptAttract", "isYInSomeTrack", "isYInTrackModel", "needConsumeEvent", "x", "onDrag", "v", "onScrollChanged", "scrollX", "scrollY", "oldScrollX", "oldScrollY", "putDragViewToTrack", "Lkotlin/Triple;", "expectY", "releaseToOriginState", "setCanAddEmptyTrackOnDrop", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class DragEventHandler
  implements View.OnDragListener
{
  public static final DragEventHandler.Companion a = new DragEventHandler.Companion(null);
  private float b;
  private boolean c;
  private View d;
  private long e;
  private int f;
  private float g;
  private float h;
  private final PointF i;
  private boolean j;
  private float k;
  private PointF l;
  private final int m;
  private final Lazy n;
  private final DragDropScrollView o;
  
  public DragEventHandler(@NotNull DragDropScrollView paramDragDropScrollView)
  {
    this.o = paramDragDropScrollView;
    this.f = DensityUtils.a.a(20.0F);
    this.g = -1.0F;
    this.h = -1.0F;
    this.i = new PointF();
    this.j = true;
    this.l = new PointF();
    paramDragDropScrollView = ViewConfiguration.get(this.o.getContext());
    Intrinsics.checkExpressionValueIsNotNull(paramDragDropScrollView, "ViewConfiguration.get(dropScrollView.context)");
    this.m = paramDragDropScrollView.getScaledTouchSlop();
    this.n = LazyKt.lazy((Function0)new DragEventHandler.scrollRunnable.2(this));
  }
  
  private final TrackModel a(boolean paramBoolean, TrackModel paramTrackModel)
  {
    if (paramBoolean) {
      return paramTrackModel;
    }
    return null;
  }
  
  private final Runnable a()
  {
    return (Runnable)this.n.getValue();
  }
  
  private final Pair<AttractPoint, AttractPoint> a(IDragView paramIDragView, float paramFloat1, float paramFloat2)
  {
    Object localObject1 = this.o.a(paramIDragView.getDragViewModel().e());
    int i1 = this.o.getTrackLeftMargin$qq_wink_impl_release();
    float f1 = this.o.getMinAttractDistance$qq_wink_impl_release();
    Object localObject2 = (AttractPoint)null;
    Iterator localIterator = ((List)localObject1).iterator();
    localObject1 = localObject2;
    while (localIterator.hasNext())
    {
      AttractPoint localAttractPoint = (AttractPoint)localIterator.next();
      float f2 = localAttractPoint.b() + i1 - paramIDragView.a();
      float f3 = Math.abs(paramFloat1 - f2);
      Object localObject3 = localObject2;
      if (f3 < f1) {
        if (localObject2 != null)
        {
          localObject3 = localObject2;
          if (f3 >= Math.abs(((AttractPoint)localObject2).b() - paramFloat1)) {}
        }
        else
        {
          localObject3 = localAttractPoint;
        }
      }
      f2 = Math.abs(paramFloat2 - f2);
      localObject2 = localObject3;
      if (f2 < f1) {
        if (localObject1 != null)
        {
          localObject2 = localObject3;
          if (f2 >= Math.abs(((AttractPoint)localObject1).b() - paramFloat2)) {}
        }
        else
        {
          localObject1 = localAttractPoint;
          localObject2 = localObject3;
        }
      }
    }
    return new Pair(localObject2, localObject1);
  }
  
  @RequiresApi(17)
  private final Triple<TrackModel, Boolean, Boolean> a(float paramFloat, IDragView paramIDragView, View paramView)
  {
    TrackModel localTrackModel1 = (TrackModel)null;
    Iterator localIterator = this.o.getTrackModels().iterator();
    for (;;)
    {
      boolean bool4 = localIterator.hasNext();
      bool2 = true;
      bool1 = false;
      bool3 = false;
      if (!bool4) {
        break;
      }
      TrackModel localTrackModel2 = (TrackModel)localIterator.next();
      if (Math.abs(paramFloat - paramIDragView.g() - localTrackModel2.b()) < this.o.getTrackHeight$qq_wink_impl_release() * 0.5F)
      {
        ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
        if (localLayoutParams != null)
        {
          bool1 = bool3;
          if (((ViewGroup.MarginLayoutParams)localLayoutParams).topMargin == localTrackModel2.b() - paramIDragView.g())
          {
            localTrackModel2.a(paramIDragView.getDragViewModel().e());
            bool1 = true;
          }
          if (TrackModel.a(localTrackModel2, paramIDragView.getDragViewModel(), 0, 0, 6, null))
          {
            bool3 = bool1 ^ true;
            Intrinsics.checkExpressionValueIsNotNull(localTrackModel2, "trackModel");
            localTrackModel1 = a(bool3, localTrackModel2);
            a(paramView);
            this.o.a(localTrackModel2, paramIDragView);
            paramIDragView = localTrackModel1;
            bool1 = bool2;
            bool2 = bool3;
            break label326;
          }
          paramIDragView.setDragViewModel(DragViewModel.a(paramIDragView.getDragViewModel(), null, (int)this.i.x - this.o.getStartPosition(), (int)this.i.x + paramIDragView.getLength() - this.o.getStartPosition(), 0L, 0, null, null, 121, null));
          Intrinsics.checkExpressionValueIsNotNull(localTrackModel2, "trackModel");
          a(bool1, localTrackModel2, paramIDragView);
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
      }
    }
    boolean bool3 = false;
    boolean bool2 = bool1;
    boolean bool1 = bool3;
    paramIDragView = localTrackModel1;
    label326:
    return new Triple(paramIDragView, Boolean.valueOf(bool2), Boolean.valueOf(bool1));
  }
  
  private final void a(DragEvent paramDragEvent)
  {
    Object localObject = paramDragEvent.getLocalState();
    paramDragEvent = localObject;
    if (!(localObject instanceof View)) {
      paramDragEvent = null;
    }
    paramDragEvent = (View)paramDragEvent;
    if ((paramDragEvent != null) && (!this.c) && (this.o.a(paramDragEvent))) {
      this.o.c();
    }
  }
  
  private final void a(View paramView)
  {
    paramView.setTranslationX(0.0F);
    paramView.setTranslationY(0.0F);
    paramView.setAlpha(1.0F);
    paramView.setVisibility(0);
  }
  
  @RequiresApi(17)
  private final void a(View paramView, float paramFloat1, float paramFloat2)
  {
    IDragView localIDragView = IDragViewCastUtilKt.a(paramView);
    if (localIDragView != null)
    {
      PointF localPointF = new PointF(paramFloat1, paramFloat2);
      this.o.a(paramView, localPointF);
      Object localObject2 = paramView.getTag(2131432159);
      Object localObject1 = localObject2;
      if (!(localObject2 instanceof Boolean)) {
        localObject1 = null;
      }
      localObject1 = (Boolean)localObject1;
      boolean bool;
      if ((localObject1 != null) && (((Boolean)localObject1).booleanValue())) {
        bool = false;
      } else {
        bool = a(paramView, localPointF);
      }
      paramFloat1 = localPointF.x;
      paramFloat2 = localIDragView.getLength();
      int i1;
      if ((!bool) && (!a(localIDragView, localPointF, paramFloat1, paramFloat2 + paramFloat1))) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      if (this.g != localPointF.x) {
        this.g = -1.0F;
      }
      if (i1 != 0) {
        paramView.performHapticFeedback(0, 2);
      }
      localIDragView.setDragViewModel(DragViewModel.a(localIDragView.getDragViewModel(), null, (int)localPointF.x - this.o.getStartPosition(), (int)localPointF.x + localIDragView.getLength() - this.o.getStartPosition(), 0L, 0, null, null, 121, null));
      this.o.b((int)localPointF.x, paramView);
      paramView.setX(localPointF.x);
      paramView.setY(localPointF.y);
    }
  }
  
  private final void a(boolean paramBoolean, TrackModel paramTrackModel, IDragView paramIDragView)
  {
    if (paramBoolean)
    {
      paramTrackModel.a(paramIDragView.getDragViewModel());
      return;
    }
    this.o.a(paramIDragView.getDragViewModel());
  }
  
  private final void a(boolean paramBoolean, TrackModel paramTrackModel, IDragView paramIDragView, View paramView)
  {
    if (paramBoolean)
    {
      paramView = this.o.getTrackModels().iterator();
      TrackModel localTrackModel;
      do
      {
        if (!paramView.hasNext()) {
          break;
        }
        localTrackModel = (TrackModel)paramView.next();
      } while ((paramTrackModel == localTrackModel) || (!localTrackModel.a(paramIDragView.getDragViewModel().e())));
      return;
    }
    a(paramView);
  }
  
  private final boolean a(float paramFloat)
  {
    return Math.abs(paramFloat - this.g) < this.o.getMinAttractDistance$qq_wink_impl_release();
  }
  
  private final boolean a(float paramFloat1, float paramFloat2)
  {
    paramFloat1 -= this.o.getHorizontalScrollX();
    float f1 = paramFloat1 - this.l.x;
    if ((Math.abs(f1) < this.m) && (Math.abs(paramFloat2 - this.l.y) < this.m)) {
      return false;
    }
    if (Math.signum(f1) != Math.signum(this.k))
    {
      this.e = System.currentTimeMillis();
      this.l.set(paramFloat1, paramFloat2);
    }
    this.k = f1;
    return true;
  }
  
  private final boolean a(float paramFloat, TrackModel paramTrackModel)
  {
    return (paramFloat > paramTrackModel.b()) && (paramFloat < paramTrackModel.c());
  }
  
  private final boolean a(PointF paramPointF)
  {
    return Math.abs(paramPointF.y - this.i.y) % (this.o.getTrackHeight$qq_wink_impl_release() + this.o.getTrackMargin$qq_wink_impl_release()) > this.o.getTrackHeight$qq_wink_impl_release() * 0.5F;
  }
  
  @RequiresApi(17)
  private final boolean a(PointF paramPointF, AttractPoint paramAttractPoint)
  {
    paramPointF.x = (paramAttractPoint.b() + this.o.getStartPosition());
    if (this.g == -1.0F)
    {
      this.g = paramPointF.x;
      this.o.setAdsorbedPoint(paramAttractPoint, null);
      return true;
    }
    return false;
  }
  
  @RequiresApi(17)
  private final boolean a(PointF paramPointF, AttractPoint paramAttractPoint, IDragView paramIDragView)
  {
    paramPointF.x = (paramAttractPoint.b() - paramIDragView.getLength() + this.o.getStartPosition());
    if (this.g == -1.0F)
    {
      this.g = paramPointF.x;
      this.o.setAdsorbedPoint(null, paramAttractPoint);
      return true;
    }
    return false;
  }
  
  private final boolean a(View paramView, float paramFloat, TrackModel paramTrackModel)
  {
    return ((paramFloat > this.i.y) && (a(paramView.getHeight() + paramFloat, paramTrackModel))) || ((paramFloat < this.i.y) && (a(paramFloat, paramTrackModel)));
  }
  
  private final boolean a(View paramView, PointF paramPointF)
  {
    boolean bool1 = a(paramPointF);
    boolean bool3 = false;
    boolean bool2 = false;
    if (bool1)
    {
      Iterator localIterator = this.o.getTrackModels().iterator();
      TrackModel localTrackModel;
      float f1;
      do
      {
        bool1 = bool3;
        if (!localIterator.hasNext()) {
          break;
        }
        localTrackModel = (TrackModel)localIterator.next();
        f1 = paramPointF.y;
        Intrinsics.checkExpressionValueIsNotNull(localTrackModel, "trackModel");
      } while (!a(paramView, f1, localTrackModel));
      paramPointF.y = localTrackModel.b();
      bool1 = bool3;
      if (this.h != paramPointF.y)
      {
        this.h = paramPointF.y;
        bool1 = true;
      }
    }
    else
    {
      bool1 = bool3;
      if (Math.abs(paramPointF.y - this.i.y) < this.o.getTrackHeight$qq_wink_impl_release() * 0.25F)
      {
        bool1 = bool2;
        if (this.h == -1.0F)
        {
          paramPointF.y = this.i.y;
          this.h = paramPointF.y;
          bool1 = true;
        }
        paramPointF.y = this.i.y;
      }
    }
    if (paramPointF.y != this.h) {
      this.h = -1.0F;
    }
    return bool1;
  }
  
  @RequiresApi(17)
  private final boolean a(AttractPoint paramAttractPoint1, float paramFloat1, AttractPoint paramAttractPoint2, float paramFloat2, PointF paramPointF, IDragView paramIDragView)
  {
    paramFloat1 = Math.abs(paramAttractPoint1.b() - paramFloat1);
    paramFloat2 = Math.abs(paramAttractPoint2.b() - paramFloat2);
    if (paramFloat1 < paramFloat2) {
      return a(paramPointF, paramAttractPoint1, paramIDragView);
    }
    if (paramFloat1 > paramFloat2) {
      return a(paramPointF, paramAttractPoint2);
    }
    boolean bool1 = a(paramPointF, paramAttractPoint1, paramIDragView);
    boolean bool2 = a(paramPointF, paramAttractPoint2);
    this.o.setAdsorbedPoint(paramAttractPoint2, paramAttractPoint1);
    return bool1 | bool2;
  }
  
  @RequiresApi(17)
  private final boolean a(IDragView paramIDragView, PointF paramPointF, float paramFloat1, float paramFloat2)
  {
    boolean bool2 = a(paramFloat1);
    boolean bool1 = false;
    if ((!bool2) && (!a(paramFloat2)))
    {
      Object localObject = a(paramIDragView, paramFloat1, paramFloat2);
      AttractPoint localAttractPoint = (AttractPoint)((Pair)localObject).component1();
      localObject = (AttractPoint)((Pair)localObject).component2();
      if ((localAttractPoint != null) && (localObject != null)) {
        return a((AttractPoint)localObject, paramFloat2, localAttractPoint, paramFloat1, paramPointF, paramIDragView);
      }
      if (localObject != null) {
        return a(paramPointF, (AttractPoint)localObject, paramIDragView);
      }
      if (localAttractPoint != null) {
        bool1 = a(paramPointF, localAttractPoint);
      }
      return bool1;
    }
    paramPointF.x = this.g;
    return false;
  }
  
  private final float b(float paramFloat)
  {
    paramFloat -= 1.0F;
    return paramFloat * paramFloat * paramFloat * paramFloat * paramFloat + 1.0F;
  }
  
  @RequiresApi(17)
  private final void b(DragEvent paramDragEvent)
  {
    float f1 = paramDragEvent.getX();
    float f2 = paramDragEvent.getY();
    float f3 = this.b;
    boolean bool = false;
    if (f2 - f3 < 0) {
      bool = true;
    }
    this.c = bool;
    this.b = f2;
    Object localObject = paramDragEvent.getLocalState();
    paramDragEvent = (DragEvent)localObject;
    if (!(localObject instanceof View)) {
      paramDragEvent = null;
    }
    paramDragEvent = (View)paramDragEvent;
    if (paramDragEvent != null)
    {
      localObject = IDragViewCastUtilKt.a(paramDragEvent);
      if (localObject != null)
      {
        localObject = ((IDragView)localObject).getStartTouchPoint();
        if (localObject != null)
        {
          if (!a(f1, f2)) {
            return;
          }
          a(paramDragEvent, f1 - ((PointF)localObject).x, f2 - ((PointF)localObject).y);
          if (this.g == -1.0F)
          {
            this.o.removeCallbacks(a());
            ViewCompat.postOnAnimation((View)this.o, a());
          }
        }
      }
    }
  }
  
  private final float c(float paramFloat)
  {
    return paramFloat * paramFloat * paramFloat * paramFloat * paramFloat;
  }
  
  @RequiresApi(17)
  private final void c(DragEvent paramDragEvent)
  {
    this.o.removeCallbacks(a());
    View localView = this.d;
    if (localView != null) {
      localView.setTag(2131432159, null);
    }
    this.d = ((View)null);
    this.e = 0L;
    e(paramDragEvent);
    paramDragEvent = paramDragEvent.getLocalState();
    if (paramDragEvent != null)
    {
      a((View)paramDragEvent);
      this.g = -1.0F;
      this.h = -1.0F;
      this.o.b();
      this.o.f();
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.View");
  }
  
  @RequiresApi(17)
  private final void d(DragEvent paramDragEvent)
  {
    Object localObject2 = paramDragEvent.getLocalState();
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof View)) {
      localObject1 = null;
    }
    localObject1 = (View)localObject1;
    if (localObject1 != null)
    {
      this.l.set(paramDragEvent.getX() - this.o.getHorizontalScrollX(), paramDragEvent.getY());
      this.e = 0L;
      this.d = ((View)localObject1);
      ((View)localObject1).bringToFront();
      paramDragEvent = IDragViewCastUtilKt.a((View)localObject1);
      if (paramDragEvent != null) {
        this.o.a((PanelEvent)new SelectChangedEvent(paramDragEvent.getDragViewModel().e(), ((View)localObject1).isSelected()));
      }
      paramDragEvent = ((View)localObject1).getLayoutParams();
      if (paramDragEvent != null)
      {
        paramDragEvent = (ViewGroup.MarginLayoutParams)paramDragEvent;
        this.i.set(paramDragEvent.leftMargin + this.o.getStartPosition(), paramDragEvent.topMargin);
        this.h = this.i.y;
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }
  }
  
  @RequiresApi(17)
  private final void e(DragEvent paramDragEvent)
  {
    if ((paramDragEvent != null) && (paramDragEvent.getLocalState() != null))
    {
      paramDragEvent = paramDragEvent.getLocalState();
      if (paramDragEvent != null)
      {
        paramDragEvent = (View)paramDragEvent;
        IDragView localIDragView = IDragViewCastUtilKt.a(paramDragEvent);
        if (localIDragView != null)
        {
          if (!localIDragView.e())
          {
            a(paramDragEvent);
            return;
          }
          float f1 = paramDragEvent.getY();
          while ((this.j) && (f1 > ((TrackModel)this.o.getTrackModels().get(this.o.getTrackModels().size() - 1)).c())) {
            this.o.a(localIDragView.getTrackType());
          }
          boolean bool = this.o.d();
          if (bool) {
            f1 = this.o.a(localIDragView.getTrackType()).b();
          }
          Triple localTriple = a(f1, localIDragView, paramDragEvent);
          if (bool) {
            this.o.post((Runnable)new DragEventHandler.handleDropView.2(this, localIDragView));
          }
          a(((Boolean)localTriple.getSecond()).booleanValue(), (TrackModel)localTriple.getFirst(), localIDragView, paramDragEvent);
          if (!((Boolean)localTriple.getThird()).booleanValue()) {
            return;
          }
          localIDragView.d();
        }
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.view.View");
      }
    }
  }
  
  public final int a(int paramInt, float paramFloat)
  {
    long l1 = System.currentTimeMillis() - this.e;
    int i1 = this.f;
    float f2 = Math.abs(paramFloat);
    float f1 = Math.signum(paramFloat);
    paramFloat = 1.0F;
    float f3 = RangesKt.coerceAtMost(1.0F, f2 * 1.0F / paramInt);
    f2 = i1;
    f3 = b(f3);
    if (l1 <= 2000L) {
      paramFloat = (float)l1 / (float)2000L;
    }
    return (int)(f1 * f2 * f3 * c(paramFloat));
  }
  
  @RequiresApi(17)
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = this.d;
    if (localView != null)
    {
      paramInt1 -= paramInt3;
      float f2 = localView.getX() + paramInt1;
      IDragView localIDragView = IDragViewCastUtilKt.a(localView);
      float f1 = f2;
      if (localIDragView != null)
      {
        if (paramInt1 > 0)
        {
          if (localIDragView.f()) {
            paramInt1 = this.o.getMaxCanScrollPx();
          } else {
            paramInt1 = this.o.getMaxSpace();
          }
          paramInt1 = RangesKt.coerceAtMost(localIDragView.getMaxEndPositionForDrag(), paramInt1);
          f1 = f2;
          if (paramInt1 > 0) {
            f1 = RangesKt.coerceAtMost(f2, paramInt1 - localIDragView.getLength() + this.o.getStartPosition());
          }
        }
        else
        {
          f1 = RangesKt.coerceAtLeast(f2, this.o.getStartPosition());
        }
        DragViewModel localDragViewModel = localIDragView.getDragViewModel();
        paramInt1 = (int)f1;
        localIDragView.setDragViewModel(DragViewModel.a(localDragViewModel, null, paramInt1 - this.o.getStartPosition(), paramInt1 + localIDragView.getLength() - this.o.getStartPosition(), 0L, 0, null, null, 121, null));
      }
      this.o.b((int)f1, localView);
      localView.setX(f1);
      localView.setY(localView.getY() + (paramInt2 - paramInt4));
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  @RequiresApi(17)
  public boolean onDrag(@Nullable View paramView, @Nullable DragEvent paramDragEvent)
  {
    if (paramDragEvent != null) {
      paramView = Integer.valueOf(paramDragEvent.getAction());
    } else {
      paramView = null;
    }
    if ((paramView != null) && (paramView.intValue() == 1))
    {
      d(paramDragEvent);
      return true;
    }
    if ((paramView != null) && (paramView.intValue() == 4))
    {
      c(paramDragEvent);
      return true;
    }
    if ((paramView != null) && (paramView.intValue() == 5))
    {
      this.o.b();
      return true;
    }
    if ((paramView != null) && (paramView.intValue() == 6))
    {
      a(paramDragEvent);
      return true;
    }
    if ((paramView != null) && (paramView.intValue() == 2))
    {
      b(paramDragEvent);
      return true;
    }
    if (paramView == null) {
      return true;
    }
    paramView.intValue();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.DragEventHandler
 * JD-Core Version:    0.7.0.1
 */