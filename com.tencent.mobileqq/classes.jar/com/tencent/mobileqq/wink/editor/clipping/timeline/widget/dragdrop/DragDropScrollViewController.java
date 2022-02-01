package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop;

import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.BaseTimelineViewController;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.TimelinePanelViewController;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scale.ScaleCalculator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragDropScrollViewController;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/BaseTimelineViewController;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragDropScrollView;", "()V", "dragModelList", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragModel;", "Lkotlin/collections/ArrayList;", "trackManager", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/TrackManager;", "getTrackManager$qq_wink_impl_release", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/TrackManager;", "setTrackManager$qq_wink_impl_release", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/TrackManager;)V", "addDragModel", "T", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/IDragView;", "dragModel", "needCalculateTrackIndex", "", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragModel;Z)Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/IDragView;", "clearAllTrack", "", "needClearDragView", "clearStatus", "findDragViewByTag", "tag", "", "(Ljava/lang/Object;)Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/IDragView;", "findDragViewListByTrackType", "", "trackType", "", "getAttractPointSet", "", "getCurrentSelectedBlock", "Landroid/view/View;", "getDragModelListByType", "getMinViewWidth", "getRootViewTop", "getTrackIndexByType", "type", "getTrackIndexMap", "", "getTrackLeftMargin", "getTrackLeftMargin$qq_wink_impl_release", "getTrackRightMargin", "getTrackRightMargin$qq_wink_impl_release", "getTrackTopMap", "hideBottomLine", "horizontalScrollToView", "dragView", "isEmptyTrack", "trackIndex", "notifyScroll", "position", "onViewScale", "preAddViewForIndex", "refreshSingleDragView", "iDragView", "refreshView", "refreshWidth", "minWidth", "removeDragViewByTag", "id", "", "removeTrack", "scrollTo", "scrollToDragView", "setAdsorbedPoint", "startPoint", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/AttractPoint;", "endPoint", "setAdsorbedPoint$qq_wink_impl_release", "setAttractPointSet", "set", "setAttractPointTime", "times", "", "setCanAddEmptyTrackOnDrop", "canAddEmptyTrackOnDrop", "setDisableBottomLine", "disableBottomLine", "setNeedDrawTrackBackground", "needDrawTrackBackground", "updateDragEventAvailable", "available", "updateDragModel", "newModel", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragModel;)Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/IDragView;", "updateTrackConfig", "config", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/TrackConfig;", "updateTrackIndexForTrackType", "newTrackIndex", "verticalScrollToView", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class DragDropScrollViewController
  extends BaseTimelineViewController<DragDropScrollView>
{
  private final ArrayList<DragModel> a = new ArrayList();
  @NotNull
  private TrackManager b = new TrackManager(this);
  
  @Nullable
  public final <T extends IDragView> T a(@Nullable Object paramObject)
  {
    DragDropScrollView localDragDropScrollView = (DragDropScrollView)d();
    if (localDragDropScrollView != null)
    {
      paramObject = localDragDropScrollView.a(paramObject);
      if (paramObject != null)
      {
        if (paramObject != null) {
          return paramObject;
        }
        throw new TypeCastException("null cannot be cast to non-null type T");
      }
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    DragDropScrollView localDragDropScrollView = (DragDropScrollView)d();
    if (localDragDropScrollView != null) {
      localDragDropScrollView.a(paramInt, localDragDropScrollView.getScrollY());
    }
  }
  
  public final void a(@Nullable AttractPoint paramAttractPoint1, @Nullable AttractPoint paramAttractPoint2)
  {
    DragModel localDragModel1 = null;
    Object localObject1 = paramAttractPoint1;
    Object localObject2;
    DragModel localDragModel2;
    label71:
    long l;
    if (paramAttractPoint1 != null)
    {
      localObject2 = ((Iterable)this.a).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = ((Iterator)localObject2).next();
        localDragModel2 = (DragModel)localObject1;
        if (Intrinsics.areEqual(paramAttractPoint1.c(), localDragModel2.f())) {
          break label71;
        }
      }
      localObject1 = null;
      localObject2 = (DragModel)localObject1;
      localObject1 = paramAttractPoint1;
      if (localObject2 != null)
      {
        if (paramAttractPoint1.d()) {
          l = ((DragModel)localObject2).b();
        } else {
          l = ((DragModel)localObject2).c();
        }
        localObject1 = AttractPoint.a(paramAttractPoint1, l, 0, null, false, 14, null);
      }
    }
    paramAttractPoint1 = paramAttractPoint2;
    if (paramAttractPoint2 != null)
    {
      localObject2 = ((Iterable)this.a).iterator();
      do
      {
        paramAttractPoint1 = localDragModel1;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        paramAttractPoint1 = ((Iterator)localObject2).next();
        localDragModel2 = (DragModel)paramAttractPoint1;
      } while (!Intrinsics.areEqual(paramAttractPoint2.c(), localDragModel2.f()));
      localDragModel1 = (DragModel)paramAttractPoint1;
      paramAttractPoint1 = paramAttractPoint2;
      if (localDragModel1 != null)
      {
        if (paramAttractPoint2.d()) {
          l = localDragModel1.b();
        } else {
          l = localDragModel1.c();
        }
        paramAttractPoint1 = AttractPoint.a(paramAttractPoint2, l, 0, null, false, 14, null);
      }
    }
    DragModelKt.a((AttractPoint)localObject1, paramAttractPoint1);
  }
  
  public void a(@NotNull Set<Integer> paramSet)
  {
    Intrinsics.checkParameterIsNotNull(paramSet, "set");
    DragDropScrollView localDragDropScrollView = (DragDropScrollView)d();
    if (localDragDropScrollView != null) {
      localDragDropScrollView.setAttractPointPosition$qq_wink_impl_release(paramSet);
    }
  }
  
  public final void b(int paramInt)
  {
    e().a(paramInt, this);
  }
  
  public void c(int paramInt)
  {
    DragDropScrollView localDragDropScrollView = (DragDropScrollView)d();
    if (localDragDropScrollView != null) {
      localDragDropScrollView.d(paramInt);
    }
  }
  
  public void h()
  {
    DragDropScrollView localDragDropScrollView = (DragDropScrollView)d();
    if (localDragDropScrollView != null) {
      localDragDropScrollView.a();
    }
  }
  
  @NotNull
  public final TrackManager i()
  {
    return this.b;
  }
  
  public void j()
  {
    Object localObject = ((Iterable)this.a).iterator();
    while (((Iterator)localObject).hasNext())
    {
      DragModel localDragModel = (DragModel)((Iterator)localObject).next();
      IDragView localIDragView = a(localDragModel.f());
      if (localIDragView != null)
      {
        localIDragView.setDragViewModel(DragViewModel.a(localIDragView.getDragViewModel(), null, e().a().b(localDragModel.b()), e().a().b(localDragModel.c()), 0L, 0, null, null, 121, null));
        this.b.b(localIDragView.getDragViewModel());
      }
    }
    localObject = (DragDropScrollView)d();
    if (localObject != null) {
      ((DragDropScrollView)localObject).a();
    }
  }
  
  public int k()
  {
    DragDropScrollView localDragDropScrollView = (DragDropScrollView)d();
    if (localDragDropScrollView != null) {
      return localDragDropScrollView.getContentViewWidth$qq_wink_impl_release();
    }
    return 0;
  }
  
  @NotNull
  public Set<Integer> l()
  {
    return SetsKt.emptySet();
  }
  
  public final int m()
  {
    DragDropScrollView localDragDropScrollView = (DragDropScrollView)d();
    if (localDragDropScrollView != null) {
      return localDragDropScrollView.getTrackLeftMargin$qq_wink_impl_release();
    }
    return 0;
  }
  
  public final int n()
  {
    DragDropScrollView localDragDropScrollView = (DragDropScrollView)d();
    if (localDragDropScrollView != null) {
      return localDragDropScrollView.getTrackRightMargin$qq_wink_impl_release();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.DragDropScrollViewController
 * JD-Core Version:    0.7.0.1
 */