package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop;

import com.tencent.videocut.utils.DensityUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/TrackManager;", "", "controller", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragDropScrollViewController;", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragDropScrollViewController;)V", "trackConfig", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/TrackConfig;", "getTrackConfig", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/TrackConfig;", "setTrackConfig", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/TrackConfig;)V", "trackModels", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/TrackModel;", "Lkotlin/collections/ArrayList;", "getTrackModels", "()Ljava/util/ArrayList;", "tracks", "addEmptyTrack", "trackType", "", "addEmptyTrack$qq_wink_impl_release", "calculateTrackIndex", "v", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/IDragView;", "checkBlockInRightTrack", "", "dragViewModel", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragViewModel;", "checkBlockInRightTrack$qq_wink_impl_release", "checkTrackEmpty", "checkTrackEmpty$qq_wink_impl_release", "clearAllTrack", "clearAllTrack$qq_wink_impl_release", "getTrackForIndex", "trackIndex", "getTrackForIndex$qq_wink_impl_release", "getTrackHeight", "getTrackIndexByType", "type", "getTrackIndexByType$qq_wink_impl_release", "getTrackMargin", "isEmptyTrack", "preAddViewForIndex", "removeEmptyTrack", "", "removeEmptyTrack$qq_wink_impl_release", "removeLastTrack", "removeLastTrack$qq_wink_impl_release", "removeTrack", "removeTrack$qq_wink_impl_release", "updateDragViewModelInTracks", "newModel", "updateDragViewModelInTracks$qq_wink_impl_release", "updateTrackModelConfig", "trackModel", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class TrackManager
{
  public static final TrackManager.Companion a = new TrackManager.Companion(null);
  private final ArrayList<TrackModel> b;
  @NotNull
  private TrackConfig c;
  private final DragDropScrollViewController d;
  
  public TrackManager(@NotNull DragDropScrollViewController paramDragDropScrollViewController)
  {
    this.d = paramDragDropScrollViewController;
    this.b = new ArrayList();
    this.c = new TrackConfig(0.0F, 0.0F, 0.0F, 7, null);
  }
  
  private final TrackModel a(TrackModel paramTrackModel)
  {
    paramTrackModel.a(paramTrackModel.f() * (b() + c()));
    paramTrackModel.b(paramTrackModel.b() + b());
    paramTrackModel.c(this.d.m());
    paramTrackModel.d(this.d.n());
    return paramTrackModel;
  }
  
  @NotNull
  public final TrackModel a(int paramInt)
  {
    ArrayList localArrayList = this.b;
    return a(TrackIndexCalculatorKt.a((List)localArrayList, paramInt, localArrayList.size()));
  }
  
  @NotNull
  public final ArrayList<TrackModel> a()
  {
    return this.b;
  }
  
  public final boolean a(@NotNull DragViewModel paramDragViewModel)
  {
    Intrinsics.checkParameterIsNotNull(paramDragViewModel, "dragViewModel");
    Iterator localIterator1 = ((Iterable)this.b).iterator();
    boolean bool2;
    TrackModel localTrackModel;
    Object localObject;
    label108:
    do
    {
      boolean bool3 = localIterator1.hasNext();
      bool2 = false;
      bool1 = bool2;
      if (!bool3) {
        break;
      }
      localTrackModel = (TrackModel)localIterator1.next();
      Iterator localIterator2 = ((Iterable)localTrackModel.a()).iterator();
      while (localIterator2.hasNext())
      {
        localObject = localIterator2.next();
        if (Intrinsics.areEqual(((DragViewModel)localObject).e(), paramDragViewModel.e())) {
          break label108;
        }
      }
      localObject = null;
      localObject = (DragViewModel)localObject;
    } while (localObject == null);
    boolean bool1 = bool2;
    if (localTrackModel.f() == ((DragViewModel)localObject).d()) {
      bool1 = true;
    }
    return bool1;
  }
  
  public final int b()
  {
    return DensityUtils.a.a(this.c.a());
  }
  
  public final void b(@NotNull DragViewModel paramDragViewModel)
  {
    Intrinsics.checkParameterIsNotNull(paramDragViewModel, "newModel");
    Iterator localIterator = ((Iterable)this.b).iterator();
    while (localIterator.hasNext())
    {
      TrackModel localTrackModel = (TrackModel)localIterator.next();
      Object localObject1 = (Iterable)localTrackModel.a();
      int i = 0;
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          CollectionsKt.throwIndexOverflow();
        }
        if (Intrinsics.areEqual(((DragViewModel)localObject2).e(), paramDragViewModel.e()))
        {
          localTrackModel.a().set(i, paramDragViewModel);
          return;
        }
        i += 1;
      }
    }
  }
  
  public final int c()
  {
    return DensityUtils.a.a(this.c.b());
  }
  
  public final void d()
  {
    int i = this.b.size() - 1;
    while ((i >= 0) && (((TrackModel)this.b.get(i)).g()))
    {
      this.b.remove(i);
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.TrackManager
 * JD-Core Version:    0.7.0.1
 */