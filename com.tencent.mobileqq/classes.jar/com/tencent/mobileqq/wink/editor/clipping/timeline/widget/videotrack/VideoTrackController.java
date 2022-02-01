package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack;

import android.view.View;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.BaseTimelineViewController;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.config.CommonConfig;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.config.LayoutConfig;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.IDragDropScrollView;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.PositionChangedHandler;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.TimelinePanelViewController;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.PanelEvent;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.PanelEventHandler;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.VideoTrackClipClickEvent;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.VideoTrackCutEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.ClipModel;>;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackController;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/BaseTimelineViewController;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView;", "thumbnailProvider", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/IThumbnailProvider;", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/IThumbnailProvider;)V", "dragScrollViewProxy", "com/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackController$dragScrollViewProxy$1", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackController$dragScrollViewProxy$1;", "initialClipList", "", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/ClipModel;", "initialTransitionList", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTransitionModel;", "positionChangedHandler", "com/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackController$positionChangedHandler$1", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackController$positionChangedHandler$1;", "thumbListener", "com/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackController$thumbListener$1", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackController$thumbListener$1;", "getThumbnailProvider", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/IThumbnailProvider;", "videoTrackModelList", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackModel;", "alignPositionToTime", "", "uuid", "", "bindView", "v", "genOriginAssetModel", "", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VariableClipModel;", "clipList", "getAttractPointSet", "", "", "getMinViewWidth", "notifyScroll", "position", "onTimeSliderMoveEnd", "isLeft", "", "onTimeSliderMoveEnd$qq_wink_impl_release", "onViewScale", "refreshView", "refreshWidth", "minWidth", "registerListener", "release", "scrollTo", "sendVideoTrackEvent", "id", "selectedStatus", "sendVideoTrackEvent$qq_wink_impl_release", "setAttractPointSet", "set", "updateData", "videoTransitionList", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class VideoTrackController
  extends BaseTimelineViewController<VideoTrackContainerView>
{
  private final List<ClipModel> a;
  private final List<VideoTransitionModel> b;
  private final List<VideoTrackModel> c;
  private final VideoTrackController.thumbListener.1 d;
  private final VideoTrackController.dragScrollViewProxy.1 e;
  private final VideoTrackController.positionChangedHandler.1 f;
  @NotNull
  private final IThumbnailProvider g;
  
  public VideoTrackController(@NotNull IThumbnailProvider paramIThumbnailProvider)
  {
    this.g = paramIThumbnailProvider;
    this.a = ((List)new ArrayList());
    this.b = ((List)new ArrayList());
    this.c = ((List)new ArrayList());
    this.d = new VideoTrackController.thumbListener.1(this);
    this.e = new VideoTrackController.dragScrollViewProxy.1(this);
    this.f = new VideoTrackController.positionChangedHandler.1(this, (IDragDropScrollView)this.e);
  }
  
  private final List<VariableClipModel> a(List<ClipModel> paramList)
  {
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.add(((ClipModel)((Iterator)localObject).next()).a());
    }
    List localList1 = (List)paramList;
    Iterator localIterator = ((Iterable)localList1).iterator();
    if (!localIterator.hasNext())
    {
      CollectionsKt.emptyList();
      return localList1;
    }
    List localList2 = (List)new ArrayList();
    for (paramList = localIterator.next(); localIterator.hasNext(); paramList = (List<ClipModel>)localObject)
    {
      localObject = localIterator.next();
      VariableClipModel localVariableClipModel = (VariableClipModel)localObject;
      paramList = (VariableClipModel)paramList;
      long l = paramList.d().b() - localVariableClipModel.d().c();
      paramList.b(l);
      localVariableClipModel.a(l);
      localList2.add(Unit.INSTANCE);
    }
    return localList1;
  }
  
  @RequiresApi(17)
  private final void a(String paramString)
  {
    Object localObject1 = this.a;
    ((List)localObject1).clear();
    Object localObject2 = (Iterable)this.c;
    Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      VideoTrackModel localVideoTrackModel = (VideoTrackModel)((Iterator)localObject2).next();
      localCollection.add(VideoTrackDataTransHelperKt.a(localVideoTrackModel, a(), Intrinsics.areEqual(localVideoTrackModel.b(), paramString)));
    }
    ((List)localObject1).addAll((Collection)localCollection);
    int i = ((VideoTrackModel)CollectionsKt.first(this.c)).e();
    paramString = ((Iterable)this.c).iterator();
    while (paramString.hasNext())
    {
      localObject1 = (VideoTrackModel)paramString.next();
      ((VideoTrackModel)localObject1).a(((VideoTrackModel)localObject1).e() - i);
    }
    paramString = (VideoTrackContainerView)d();
    if (paramString != null) {
      paramString.a(this.c, this.b);
    }
  }
  
  private final void m()
  {
    this.g.a((IViewThumbnailGeneratedListener)this.d);
  }
  
  public void a(int paramInt)
  {
    VideoTrackContainerView localVideoTrackContainerView = (VideoTrackContainerView)d();
    if (localVideoTrackContainerView != null) {
      localVideoTrackContainerView.scrollTo(paramInt, localVideoTrackContainerView.getScrollY());
    }
  }
  
  public void a(@NotNull VideoTrackContainerView paramVideoTrackContainerView)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoTrackContainerView, "v");
    super.a((View)paramVideoTrackContainerView);
    paramVideoTrackContainerView.setPositionChangedHandler((PositionChangedHandler)this.f);
  }
  
  public final void a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "id");
    PanelEventHandler localPanelEventHandler = c();
    Iterator localIterator = ((Iterable)this.a).iterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (Intrinsics.areEqual(((ClipModel)localObject).b(), paramString)) {
        break label64;
      }
    }
    Object localObject = null;
    label64:
    localPanelEventHandler.a((PanelEvent)new VideoTrackClipClickEvent(paramString, paramInt, (ClipModel)localObject));
  }
  
  @RequiresApi(17)
  public final void a(@NotNull String paramString, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uuid");
    a(paramString);
    PanelEventHandler localPanelEventHandler = c();
    Iterator localIterator = ((Iterable)this.a).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (Intrinsics.areEqual(((ClipModel)localObject).b(), paramString))
      {
        paramString = localObject;
        break label71;
      }
    }
    paramString = null;
    label71:
    localPanelEventHandler.a((PanelEvent)new VideoTrackCutEvent((ClipModel)paramString, paramBoolean));
  }
  
  @RequiresApi(17)
  public final void a(@NotNull List<ClipModel> paramList, @NotNull List<VideoTransitionModel> paramList1)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "clipList");
    Intrinsics.checkParameterIsNotNull(paramList1, "videoTransitionList");
    Object localObject = this.a;
    if (!(Intrinsics.areEqual(paramList, localObject) ^ true)) {
      localObject = null;
    }
    if (localObject != null)
    {
      ((List)localObject).clear();
      ((List)localObject).addAll((Collection)paramList);
    }
    localObject = this.b;
    if (!(Intrinsics.areEqual(paramList1, localObject) ^ true)) {
      localObject = null;
    }
    if (localObject != null)
    {
      ((List)localObject).clear();
      ((List)localObject).addAll((Collection)paramList1);
    }
    m();
    paramList1 = this.c;
    paramList1.clear();
    localObject = (Iterable)a(paramList);
    paramList = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.add(VideoTrackDataTransHelperKt.a((VariableClipModel)((Iterator)localObject).next(), a()));
    }
    paramList1.addAll((Collection)paramList);
    paramList = (VideoTrackContainerView)d();
    if (paramList != null) {
      paramList.a(this.c, this.b);
    }
  }
  
  public void a(@NotNull Set<Integer> paramSet)
  {
    Intrinsics.checkParameterIsNotNull(paramSet, "set");
  }
  
  public final void b(int paramInt)
  {
    e().a(paramInt, this);
  }
  
  public void c(int paramInt)
  {
    VideoTrackContainerView localVideoTrackContainerView = (VideoTrackContainerView)d();
    if (localVideoTrackContainerView != null) {
      localVideoTrackContainerView.a(paramInt);
    }
  }
  
  @RequiresApi(17)
  public void h()
  {
    Object localObject1 = this.c;
    ((List)localObject1).clear();
    Object localObject2 = (Iterable)a(this.a);
    Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      localCollection.add(VideoTrackDataTransHelperKt.a((VariableClipModel)((Iterator)localObject2).next(), a()));
    }
    ((List)localObject1).addAll((Collection)CollectionsKt.toList((Iterable)localCollection));
    localObject1 = (VideoTrackContainerView)d();
    if (localObject1 != null) {
      ((VideoTrackContainerView)localObject1).a(this.c, this.b);
    }
  }
  
  @NotNull
  public final IThumbnailProvider i()
  {
    return this.g;
  }
  
  @RequiresApi(17)
  public void j()
  {
    h();
  }
  
  public int k()
  {
    Iterator localIterator = ((Iterable)this.c).iterator();
    int i;
    if (!localIterator.hasNext())
    {
      localObject1 = null;
    }
    else
    {
      localObject1 = localIterator.next();
      if (localIterator.hasNext())
      {
        i = ((VideoTrackModel)localObject1).a();
        Object localObject2 = localObject1;
        do
        {
          Object localObject3 = localIterator.next();
          int k = ((VideoTrackModel)localObject3).a();
          localObject1 = localObject2;
          int j = i;
          if (i < k)
          {
            localObject1 = localObject3;
            j = k;
          }
          localObject2 = localObject1;
          i = j;
        } while (localIterator.hasNext());
      }
    }
    Object localObject1 = (VideoTrackModel)localObject1;
    if (localObject1 != null) {
      i = ((VideoTrackModel)localObject1).a();
    } else {
      i = 0;
    }
    return i + (e().g().b().a() << 1);
  }
  
  @NotNull
  public Set<Integer> l()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = ((Iterable)this.c).iterator();
    while (localIterator.hasNext())
    {
      VideoTrackModel localVideoTrackModel = (VideoTrackModel)localIterator.next();
      localHashSet.add(Integer.valueOf(localVideoTrackModel.e()));
      localHashSet.add(Integer.valueOf(localVideoTrackModel.a()));
    }
    return (Set)localHashSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VideoTrackController
 * JD-Core Version:    0.7.0.1
 */