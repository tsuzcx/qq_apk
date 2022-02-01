package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack;

import android.view.View;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.AttractPoint;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.IDragDropScrollView;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.IDragView;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.TrackModel;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.TimelinePanelViewController;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scale.ScaleCalculator;
import com.tencent.videocut.utils.DensityUtils;
import com.tencent.videocut.utils.ScreenUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackController$dragScrollViewProxy$1", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/IDragDropScrollView;", "DEFAULT_ATTRACT_DISTANCE_DP", "", "scrollX", "", "getScrollX", "()I", "trackModels", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/TrackModel;", "Lkotlin/collections/ArrayList;", "getTrackModels", "()Ljava/util/ArrayList;", "getAttractPoints", "", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/AttractPoint;", "id", "", "getHalfScreenWidth", "getHorizontalScrollX", "getLeftSidePositionByMargin", "leftMargin", "getMaxCanScrollPx", "getMaxPosition", "getMaxSpace", "getMinAttractDistance", "getRightSidePositionByMargin", "rightMargin", "getStartPosition", "onSliderDown", "", "onSliderUp", "positionOffset", "view", "Landroid/view/View;", "refreshSingleDragView", "iDragView", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/IDragView;", "scrollToX", "x", "y", "setAdsorbedPoint", "startPoint", "endPoint", "updateSelectState", "dragView", "isSelected", "", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class VideoTrackController$dragScrollViewProxy$1
  implements IDragDropScrollView
{
  private final float b = 5.0F;
  @NotNull
  private final ArrayList<TrackModel> c = new ArrayList((Collection)CollectionsKt.listOf(new TrackModel()));
  
  private final int a()
  {
    VideoTrackContainerView localVideoTrackContainerView = (VideoTrackContainerView)this.a.d();
    if (localVideoTrackContainerView != null) {
      return localVideoTrackContainerView.getScrollX();
    }
    return 0;
  }
  
  @NotNull
  public List<AttractPoint> a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "id");
    Object localObject1 = this.a;
    Object localObject2 = (Iterable)VideoTrackController.a((VideoTrackController)localObject1, VideoTrackController.c((VideoTrackController)localObject1));
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      if (Intrinsics.areEqual(paramString, ((VariableClipModel)localObject3).a())) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    localObject1 = (Iterable)localObject1;
    paramString = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramString.add(VideoTrackDataTransHelperKt.a((VariableClipModel)((Iterator)localObject1).next(), this.a.a()));
    }
    localObject1 = (Iterable)paramString;
    paramString = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (VideoTrackModel)((Iterator)localObject1).next();
      paramString.add(new AttractPoint(((VideoTrackModel)localObject2).n().d().b(), ((VideoTrackModel)localObject2).a(), ((VideoTrackModel)localObject2).b(), false));
    }
    paramString = CollectionsKt.toMutableList((Collection)paramString);
    paramString.add(new AttractPoint(this.a.a().e(), this.a.e().b(), "", false));
    return paramString;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a.e().a(paramInt1, null);
  }
  
  public void a(int paramInt, @NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
  }
  
  public void a(@Nullable IDragView paramIDragView, boolean paramBoolean) {}
  
  public int b(int paramInt)
  {
    return a() + getHalfScreenWidth() - DensityUtils.a.a(paramInt);
  }
  
  @RequiresApi(17)
  public void b(@NotNull IDragView paramIDragView)
  {
    Intrinsics.checkParameterIsNotNull(paramIDragView, "iDragView");
    Object localObject2 = (VideoTrackTimelineView)paramIDragView;
    Object localObject1 = ((VideoTrackTimelineView)localObject2).getUuid();
    Object localObject3 = VideoTrackController.a(this.a).iterator();
    int i = 0;
    while (((Iterator)localObject3).hasNext())
    {
      if (Intrinsics.areEqual(localObject1, ((VideoTrackModel)((Iterator)localObject3).next()).b())) {
        break label78;
      }
      i += 1;
    }
    i = -1;
    label78:
    localObject1 = (VideoTrackModel)CollectionsKt.getOrNull(VideoTrackController.a(this.a), i);
    if (localObject1 != null)
    {
      int m = paramIDragView.getStartPosition() - ((VideoTrackModel)localObject1).e();
      Object localObject4;
      int j;
      Object localObject5;
      int k;
      if (m != 0)
      {
        localObject4 = (Iterable)VideoTrackController.a(this.a);
        localObject3 = (Collection)new ArrayList();
        localObject4 = ((Iterable)localObject4).iterator();
        j = 0;
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = ((Iterator)localObject4).next();
          if (j < 0) {
            CollectionsKt.throwIndexOverflow();
          }
          VideoTrackModel localVideoTrackModel = (VideoTrackModel)localObject5;
          if (j < i) {
            k = 1;
          } else {
            k = 0;
          }
          if (k != 0) {
            ((Collection)localObject3).add(localObject5);
          }
          j += 1;
        }
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (VideoTrackModel)((Iterator)localObject3).next();
          ((VideoTrackModel)localObject4).a(((VideoTrackModel)localObject4).e() + m);
        }
        ((VideoTrackTimelineView)localObject2).h();
      }
      m = paramIDragView.getEndPosition() - ((VideoTrackModel)localObject1).a();
      if (m != 0)
      {
        localObject3 = (Iterable)VideoTrackController.a(this.a);
        localObject2 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
        j = 0;
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = ((Iterator)localObject3).next();
          if (j < 0) {
            CollectionsKt.throwIndexOverflow();
          }
          localObject5 = (VideoTrackModel)localObject4;
          if (j > i) {
            k = 1;
          } else {
            k = 0;
          }
          if (k != 0) {
            ((Collection)localObject2).add(localObject4);
          }
          j += 1;
        }
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (VideoTrackModel)((Iterator)localObject2).next();
          ((VideoTrackModel)localObject3).a(((VideoTrackModel)localObject3).e() + m);
        }
      }
      ((VideoTrackModel)localObject1).a(paramIDragView.getStartPosition());
      ((VideoTrackModel)localObject1).b(((VideoTrackModel)localObject1).e() - ((VideoTrackModel)localObject1).g());
      ((VideoTrackModel)localObject1).c(paramIDragView.getEndPosition() - paramIDragView.getStartPosition());
      ((VideoTrackModel)localObject1).a(this.a.a().a(((VideoTrackModel)localObject1).h()));
      paramIDragView = (VideoTrackContainerView)this.a.d();
      if (paramIDragView != null) {
        paramIDragView.a(VideoTrackController.a(this.a), VideoTrackController.b(this.a));
      }
      this.a.e().c();
    }
  }
  
  public int c(int paramInt)
  {
    return a() - getHalfScreenWidth() + DensityUtils.a.a(paramInt);
  }
  
  public void e() {}
  
  public int getHalfScreenWidth()
  {
    return ScreenUtils.a() / 2;
  }
  
  public int getHorizontalScrollX()
  {
    return a();
  }
  
  public int getMaxCanScrollPx()
  {
    return 2147483647;
  }
  
  public int getMaxPosition()
  {
    return this.a.k();
  }
  
  public int getMaxSpace()
  {
    return this.a.a().d();
  }
  
  public float getMinAttractDistance()
  {
    return DensityUtils.a.a(this.b);
  }
  
  @NotNull
  public ArrayList<TrackModel> getTrackModels()
  {
    return this.c;
  }
  
  public void setAdsorbedPoint(@Nullable AttractPoint paramAttractPoint1, @Nullable AttractPoint paramAttractPoint2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VideoTrackController.dragScrollViewProxy.1
 * JD-Core Version:    0.7.0.1
 */