package com.tencent.mobileqq.wink.editor.clipping;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.logger.Logger;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.wink.editor.clipping.thumbnail.ThumbnailProviderManager;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.VideoTrackClipClickEvent;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.VideoTrackCutEvent;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.ClipModel;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.DrawData;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.TagData;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.TimeData;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VideoTrackData;
import com.tencent.tavcut.composition.model.component.TimeRange;
import com.tencent.tavcut.composition.model.component.Timeline;
import com.tencent.tavcut.render.player.IPlayer;
import com.tencent.tavcut.render.player.IPlayer.PlayerStatus;
import com.tencent.tavcut.session.ICutSession;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.MediaType;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.picker.MediaData;
import com.tencent.videocut.render.ComposeRenderLayer;
import com.tencent.videocut.render.ComposeRenderLayer.RenderScene;
import com.tencent.videocut.render.repository.DataBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.tavcut.composition.model.component.Timeline;>;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/TimelineViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "()V", "currentPlayerStatus", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/tavcut/render/player/IPlayer$PlayerStatus;", "getCurrentPlayerStatus", "()Landroidx/lifecycle/MutableLiveData;", "setCurrentPlayerStatus", "(Landroidx/lifecycle/MutableLiveData;)V", "currentPlayerTimeLiveData", "", "getCurrentPlayerTimeLiveData", "setCurrentPlayerTimeLiveData", "durationLiveData", "getDurationLiveData", "setDurationLiveData", "firstEnter", "", "getFirstEnter", "()Z", "setFirstEnter", "(Z)V", "hasChanged", "getHasChanged", "setHasChanged", "mCurrentMediaModel", "Lcom/tencent/videocut/model/MediaModel;", "mCutSession", "Lcom/tencent/tavcut/session/ICutSession;", "mPlayer", "Lcom/tencent/tavcut/render/player/IPlayer;", "getMPlayer", "()Lcom/tencent/tavcut/render/player/IPlayer;", "setMPlayer", "(Lcom/tencent/tavcut/render/player/IPlayer;)V", "playerTime", "renderLayerHelper", "Lcom/tencent/videocut/render/ComposeRenderLayer;", "selectedTimelineLiveData", "Lcom/tencent/mobileqq/wink/editor/clipping/SelectItem;", "getSelectedTimelineLiveData", "setSelectedTimelineLiveData", "timelineList", "Ljava/util/ArrayList;", "Lcom/tencent/tavcut/composition/model/component/Timeline;", "Lkotlin/collections/ArrayList;", "videoSourceDurationLiveData", "getVideoSourceDurationLiveData", "setVideoSourceDurationLiveData", "videoTracksLiveData", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackData;", "getVideoTracksLiveData", "setVideoTracksLiveData", "checkSelectClip", "", "genClipModel", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/ClipModel;", "mediaClip", "Lcom/tencent/videocut/model/MediaClip;", "range", "Lcom/tencent/tavcut/composition/model/component/TimeRange;", "selectedId", "", "genDrawData", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/DrawData;", "isSelected", "getClipMinDuration", "getClipsSize", "", "getCurrentClipIndex", "getCurrentClipSpeed", "", "()Ljava/lang/Float;", "getCurrentClipType", "Lcom/tencent/videocut/model/MediaType;", "getCurrentDuration", "getFinalClips", "getLogTag", "getMediaModel", "getSession", "handleChangeClipsOrder", "id", "targetIndex", "handleChangeVideoRate", "speed", "handleClipAdd", "localMedias", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "handleDeleteVideoClip", "handleUnSelectTimeline", "handleVideoTrackClipClickEvent", "event", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/VideoTrackClipClickEvent;", "handleVideoTrackCutEvent", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/VideoTrackCutEvent;", "init", "cutSession", "player", "mediaModel", "composeRenderLayer", "initMediaModel", "clips", "onTimeChange", "timeUs", "outCalled", "release", "updateDuration", "list", "updateRelatedData", "updateSelectItem", "updateThumbProvider", "updateVideoClipAndTransition", "videos", "selectedTimeline", "updateVideoSourceDuration", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class TimelineViewModel
  extends BaseViewModel
{
  public static final TimelineViewModel.Companion b = new TimelineViewModel.Companion(null);
  @NotNull
  public IPlayer a;
  private ICutSession c;
  private MediaModel d = new MediaModel(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262143, null);
  private ComposeRenderLayer e;
  private ArrayList<Timeline> f = new ArrayList();
  @NotNull
  private MutableLiveData<VideoTrackData> g = new MutableLiveData();
  @NotNull
  private MutableLiveData<Long> h = new MutableLiveData();
  @NotNull
  private MutableLiveData<Long> i = new MutableLiveData();
  @NotNull
  private MutableLiveData<SelectItem<?>> j = new MutableLiveData();
  @NotNull
  private MutableLiveData<Long> k = new MutableLiveData();
  @NotNull
  private MutableLiveData<IPlayer.PlayerStatus> l = new MutableLiveData();
  private long m;
  private boolean n = true;
  private boolean o;
  
  private final ClipModel a(MediaClip paramMediaClip, TimeRange paramTimeRange, String paramString)
  {
    ResourceModel localResourceModel = paramMediaClip.resource;
    if (localResourceModel == null) {
      Intrinsics.throwNpe();
    }
    paramMediaClip = a(Intrinsics.areEqual(localResourceModel.id, paramString), paramMediaClip);
    paramString = localResourceModel.id;
    String str = localResourceModel.path;
    int i1;
    if (localResourceModel.type != null) {
      i1 = localResourceModel.type.ordinal();
    } else {
      i1 = 0;
    }
    return new ClipModel(paramString, i1, str, new TimeData(paramTimeRange.startTime, paramTimeRange.duration, localResourceModel.scaleDuration, localResourceModel.selectDuration, localResourceModel.selectStart, localResourceModel.sourceDuration, localResourceModel.sourceStart), paramMediaClip);
  }
  
  private final DrawData a(boolean paramBoolean, MediaClip paramMediaClip)
  {
    paramMediaClip = paramMediaClip.resource;
    if (paramMediaClip == null) {
      Intrinsics.throwNpe();
    }
    List localList = (List)new ArrayList();
    if ((paramMediaClip.selectDuration != paramMediaClip.scaleDuration) && (paramMediaClip.scaleDuration != 0L))
    {
      Object localObject;
      if ((float)paramMediaClip.selectDuration / (float)paramMediaClip.scaleDuration == 0.75F)
      {
        localObject = StringCompanionObject.INSTANCE;
        localObject = new Object[1];
        localObject[0] = Float.valueOf((float)paramMediaClip.selectDuration / (float)paramMediaClip.scaleDuration);
        paramMediaClip = String.format("%.2fx", Arrays.copyOf((Object[])localObject, localObject.length));
        Intrinsics.checkExpressionValueIsNotNull(paramMediaClip, "java.lang.String.format(format, *args)");
      }
      else
      {
        localObject = StringCompanionObject.INSTANCE;
        localObject = new Object[1];
        localObject[0] = Float.valueOf((float)paramMediaClip.selectDuration / (float)paramMediaClip.scaleDuration);
        paramMediaClip = String.format("%.1fx", Arrays.copyOf((Object[])localObject, localObject.length));
        Intrinsics.checkExpressionValueIsNotNull(paramMediaClip, "java.lang.String.format(format, *args)");
      }
      localList.add(new TagData(paramMediaClip, 0, 2, null));
    }
    if (paramBoolean) {
      return new DrawData(1, true, localList);
    }
    return new DrawData(-1, false, localList);
  }
  
  private final void a(List<MediaClip> paramList, SelectItem<?> paramSelectItem, List<Timeline> paramList1)
  {
    if (paramList1 != null)
    {
      if (paramList == null) {
        return;
      }
      Object localObject1 = (Iterable)paramList1;
      paramList1 = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (Intrinsics.areEqual(((Timeline)localObject2).type, "VideoSource")) {
          paramList1.add(localObject2);
        }
      }
      paramList1 = (List)paramList1;
      if (paramList.size() != paramList1.size())
      {
        paramSelectItem = Logger.a;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("updateVideoClip size diff!,videos:");
        ((StringBuilder)localObject1).append(paramList);
        ((StringBuilder)localObject1).append(",videoSources:");
        ((StringBuilder)localObject1).append(paramList1);
        paramSelectItem.c("QQWinkEditViewModel", ((StringBuilder)localObject1).toString());
        return;
      }
      if (paramSelectItem != null)
      {
        paramSelectItem = paramSelectItem.a();
        if (paramSelectItem != null) {}
      }
      else
      {
        paramSelectItem = "";
      }
      paramList1 = (Iterable)CollectionsKt.zip((Iterable)paramList, (Iterable)paramList1);
      paramList = (Collection)new ArrayList();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        localObject1 = paramList1.next();
        localObject2 = (Pair)localObject1;
        int i1;
        if ((((MediaClip)((Pair)localObject2).getFirst()).resource != null) && (((Timeline)((Pair)localObject2).getSecond()).range != null)) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        if (i1 != 0) {
          paramList.add(localObject1);
        }
      }
      paramList1 = (Iterable)paramList;
      paramList = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault(paramList1, 10));
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        localObject2 = (Pair)paramList1.next();
        localObject1 = (MediaClip)((Pair)localObject2).component1();
        localObject2 = ((Timeline)((Pair)localObject2).component2()).range;
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        paramList.add(a((MediaClip)localObject1, (TimeRange)localObject2, paramSelectItem));
      }
      paramList = (List)paramList;
      this.g.postValue(new VideoTrackData(paramList, null, 2, null));
    }
  }
  
  private final int b(long paramLong)
  {
    TimelineViewModel localTimelineViewModel = (TimelineViewModel)this;
    Iterator localIterator = ((Iterable)localTimelineViewModel.d.videos).iterator();
    long l1 = 0L;
    MediaClip localMediaClip;
    long l2;
    do
    {
      boolean bool = localIterator.hasNext();
      i1 = 0;
      if (!bool) {
        break;
      }
      localMediaClip = (MediaClip)localIterator.next();
      ResourceModel localResourceModel = localMediaClip.resource;
      if (localResourceModel != null) {
        l2 = localResourceModel.selectDuration;
      } else {
        l2 = 0L;
      }
      l2 = l1 + l2;
      l1 = l2;
    } while (l2 <= paramLong);
    int i1 = Math.max(0, localTimelineViewModel.d.videos.indexOf(localMediaClip));
    return i1;
  }
  
  private final void c(List<Timeline> paramList)
  {
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if (Intrinsics.areEqual(((Timeline)localObject2).type, "TimeOffset")) {
        paramList.add(localObject2);
      }
    }
    Iterator localIterator = ((Iterable)paramList).iterator();
    boolean bool = localIterator.hasNext();
    long l4 = 0L;
    if (!bool)
    {
      paramList = null;
    }
    else
    {
      paramList = localIterator.next();
      if (localIterator.hasNext())
      {
        localObject1 = ((Timeline)paramList).range;
        if (localObject1 != null)
        {
          l1 = ((TimeRange)localObject1).duration;
          localObject1 = paramList;
        }
        else
        {
          l1 = 0L;
          localObject1 = paramList;
        }
        do
        {
          localObject2 = localIterator.next();
          paramList = ((Timeline)localObject2).range;
          long l2;
          if (paramList != null) {
            l2 = paramList.duration;
          } else {
            l2 = 0L;
          }
          paramList = (List<Timeline>)localObject1;
          long l3 = l1;
          if (l1 < l2)
          {
            paramList = localObject2;
            l3 = l2;
          }
          localObject1 = paramList;
          l1 = l3;
        } while (localIterator.hasNext());
      }
    }
    paramList = (Timeline)paramList;
    long l1 = l4;
    if (paramList != null)
    {
      paramList = paramList.range;
      l1 = l4;
      if (paramList != null) {
        l1 = paramList.duration;
      }
    }
    this.h.postValue(Long.valueOf(l1));
  }
  
  private final void d(List<Timeline> paramList)
  {
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if (Intrinsics.areEqual(((Timeline)localObject2).type, "VideoSource")) {
        paramList.add(localObject2);
      }
    }
    Iterator localIterator = ((Iterable)paramList).iterator();
    if (!localIterator.hasNext())
    {
      paramList = null;
    }
    else
    {
      paramList = localIterator.next();
      if (localIterator.hasNext())
      {
        localObject1 = ((Timeline)paramList).range;
        if (localObject1 != null)
        {
          l1 = ((TimeRange)localObject1).duration + ((TimeRange)localObject1).startTime;
          localObject1 = paramList;
        }
        else
        {
          l1 = 0L;
          localObject1 = paramList;
        }
        do
        {
          localObject2 = localIterator.next();
          paramList = ((Timeline)localObject2).range;
          long l2;
          if (paramList != null) {
            l2 = paramList.duration + paramList.startTime;
          } else {
            l2 = 0L;
          }
          paramList = (List<Timeline>)localObject1;
          long l3 = l1;
          if (l1 < l2)
          {
            paramList = localObject2;
            l3 = l2;
          }
          localObject1 = paramList;
          l1 = l3;
        } while (localIterator.hasNext());
      }
    }
    paramList = (Timeline)paramList;
    if (paramList != null)
    {
      paramList = paramList.range;
      if (paramList != null)
      {
        l1 = paramList.duration + paramList.startTime;
        break label269;
      }
    }
    long l1 = 0L;
    label269:
    this.i.postValue(Long.valueOf(l1));
  }
  
  private final void t()
  {
    List localList = (List)new ArrayList();
    Object localObject = (Iterable)this.d.videos;
    Collection localCollection = (Collection)new ArrayList();
    Iterator localIterator = ((Iterable)localObject).iterator();
    while (localIterator.hasNext())
    {
      localObject = ((MediaClip)localIterator.next()).resource;
      if (localObject != null) {
        localObject = ResourceModelExtensionKt.a((ResourceModel)localObject);
      } else {
        localObject = null;
      }
      if (localObject != null) {
        localCollection.add(localObject);
      }
    }
    localList.addAll((Collection)localCollection);
    ThumbnailProviderManager.a.a(localList, "QQWinkEditViewModel");
  }
  
  @NotNull
  public String a()
  {
    return "QQWinkEditViewModel";
  }
  
  public final void a(float paramFloat)
  {
    Object localObject1 = (Iterable)this.d.videos;
    Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10));
    Iterator localIterator = ((Iterable)localObject1).iterator();
    while (localIterator.hasNext())
    {
      MediaClip localMediaClip = (MediaClip)localIterator.next();
      localObject1 = localMediaClip.resource;
      String str = null;
      if (localObject1 != null) {
        localObject1 = ((ResourceModel)localObject1).id;
      } else {
        localObject1 = null;
      }
      Object localObject2 = (SelectItem)this.j.getValue();
      if (localObject2 != null) {
        str = ((SelectItem)localObject2).a();
      }
      localObject2 = localMediaClip;
      if (Intrinsics.areEqual(localObject1, str))
      {
        localObject1 = localMediaClip.resource;
        localObject2 = localMediaClip;
        if (localObject1 != null)
        {
          long l1 = ((float)((ResourceModel)localObject1).selectDuration / paramFloat);
          localObject1 = MediaClip.copy$default(localMediaClip, ResourceModel.copy$default(localMediaClip.resource, null, null, Long.valueOf(l1), null, null, null, null, null, null, null, null, null, null, null, null, null, 65531, null), null, null, null, null, null, 62, null);
          localObject2 = localMediaClip;
          if (localObject1 != null) {
            localObject2 = localObject1;
          }
        }
      }
      localCollection.add(localObject2);
    }
    localObject1 = (List)localCollection;
    this.d = MediaModel.copy$default(this.d, null, null, null, null, null, null, (List)localObject1, null, null, null, null, null, null, null, null, null, null, null, 262079, null);
    localObject1 = this.e;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
    }
    ((ComposeRenderLayer)localObject1).a(this.d);
    this.o = true;
  }
  
  public final void a(long paramLong)
  {
    if ((IPlayer.PlayerStatus)this.l.getValue() != IPlayer.PlayerStatus.PLAYING) {
      return;
    }
    int i1 = b(paramLong);
    ResourceModel localResourceModel = ((MediaClip)this.d.videos.get(i1)).resource;
    if (localResourceModel != null)
    {
      Object localObject = (SelectItem)this.j.getValue();
      if (localObject != null) {
        localObject = ((SelectItem)localObject).a();
      } else {
        localObject = null;
      }
      if (Intrinsics.areEqual(localObject, localResourceModel.id)) {
        return;
      }
      localObject = new SelectItem(localResourceModel.id, 1, new TimelineTimeRange(localResourceModel.selectStart, localResourceModel.selectDuration), Integer.valueOf(1));
      this.j.setValue(localObject);
      a(this.d.videos, (SelectItem)localObject, (List)this.f);
    }
  }
  
  public final void a(long paramLong, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      IPlayer localIPlayer = this.a;
      if (localIPlayer == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mPlayer");
      }
      if (paramLong != localIPlayer.e())
      {
        localIPlayer = this.a;
        if (localIPlayer == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mPlayer");
        }
        localIPlayer.a(paramLong);
      }
    }
  }
  
  public final void a(@NotNull VideoTrackClipClickEvent paramVideoTrackClipClickEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoTrackClipClickEvent, "event");
    if (paramVideoTrackClipClickEvent.b() == 1)
    {
      a(this.d.videos, null, (List)this.f);
      this.j.postValue(null);
      return;
    }
    TimelineTimeRange localTimelineTimeRange = new TimelineTimeRange(0L, 0L);
    if (paramVideoTrackClipClickEvent.c() != null) {
      localTimelineTimeRange = new TimelineTimeRange(paramVideoTrackClipClickEvent.c().d().c(), paramVideoTrackClipClickEvent.c().d().d());
    }
    paramVideoTrackClipClickEvent = new SelectItem(paramVideoTrackClipClickEvent.a(), 1, localTimelineTimeRange, Integer.valueOf(1));
    a(this.d.videos, paramVideoTrackClipClickEvent, (List)this.f);
    this.j.postValue(paramVideoTrackClipClickEvent);
    paramVideoTrackClipClickEvent = this.a;
    if (paramVideoTrackClipClickEvent == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mPlayer");
    }
    if (paramVideoTrackClipClickEvent.c())
    {
      paramVideoTrackClipClickEvent = this.a;
      if (paramVideoTrackClipClickEvent == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mPlayer");
      }
      paramVideoTrackClipClickEvent.b();
    }
    paramVideoTrackClipClickEvent = this.a;
    if (paramVideoTrackClipClickEvent == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mPlayer");
    }
    if (paramVideoTrackClipClickEvent.e() >= localTimelineTimeRange.a() + localTimelineTimeRange.b())
    {
      paramVideoTrackClipClickEvent = this.a;
      if (paramVideoTrackClipClickEvent == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mPlayer");
      }
      paramVideoTrackClipClickEvent.a(localTimelineTimeRange.a() + localTimelineTimeRange.b() - 1000);
      return;
    }
    paramVideoTrackClipClickEvent = this.a;
    if (paramVideoTrackClipClickEvent == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mPlayer");
    }
    if (paramVideoTrackClipClickEvent.e() <= localTimelineTimeRange.a())
    {
      paramVideoTrackClipClickEvent = this.a;
      if (paramVideoTrackClipClickEvent == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mPlayer");
      }
      paramVideoTrackClipClickEvent.a(localTimelineTimeRange.a());
    }
  }
  
  public final void a(@NotNull VideoTrackCutEvent paramVideoTrackCutEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoTrackCutEvent, "event");
    ClipModel localClipModel = paramVideoTrackCutEvent.a();
    if (localClipModel != null)
    {
      List localList = CollectionsKt.toMutableList((Collection)this.d.videos);
      Object localObject2 = ((Iterable)localList).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = ((Iterator)localObject2).next();
        paramVideoTrackCutEvent = ((MediaClip)localObject1).resource;
        if (paramVideoTrackCutEvent != null) {
          paramVideoTrackCutEvent = paramVideoTrackCutEvent.id;
        } else {
          paramVideoTrackCutEvent = null;
        }
        if (Intrinsics.areEqual(paramVideoTrackCutEvent, localClipModel.b()))
        {
          paramVideoTrackCutEvent = (VideoTrackCutEvent)localObject1;
          break label107;
        }
      }
      paramVideoTrackCutEvent = null;
      label107:
      Object localObject1 = (MediaClip)paramVideoTrackCutEvent;
      if (localObject1 != null)
      {
        localObject2 = ((MediaClip)localObject1).resource;
        if (localObject2 != null)
        {
          long l1 = localClipModel.d().g();
          long l2 = localClipModel.d().f();
          paramVideoTrackCutEvent = ResourceModel.copy$default((ResourceModel)localObject2, null, null, Long.valueOf(localClipModel.d().e()), null, null, Long.valueOf(l1), Long.valueOf(l2), null, null, null, null, null, null, null, null, null, 65435, null);
          if (!(Intrinsics.areEqual(paramVideoTrackCutEvent, localObject2) ^ true)) {
            paramVideoTrackCutEvent = null;
          }
          if (paramVideoTrackCutEvent != null)
          {
            localList.set(localList.indexOf(localObject1), MediaClip.copy$default((MediaClip)localObject1, paramVideoTrackCutEvent, null, null, null, null, null, 62, null));
            this.d = MediaModel.copy$default(this.d, null, null, null, null, null, null, localList, null, null, null, null, null, null, null, null, null, null, null, 262079, null);
            paramVideoTrackCutEvent = this.e;
            if (paramVideoTrackCutEvent == null) {
              Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
            }
            paramVideoTrackCutEvent.a(this.d);
            this.o = true;
          }
        }
      }
    }
  }
  
  public final void a(@NotNull ICutSession paramICutSession, @NotNull IPlayer paramIPlayer)
  {
    Intrinsics.checkParameterIsNotNull(paramICutSession, "cutSession");
    Intrinsics.checkParameterIsNotNull(paramIPlayer, "player");
    this.c = paramICutSession;
    this.a = paramIPlayer;
  }
  
  public final void a(@NotNull ICutSession paramICutSession, @NotNull IPlayer paramIPlayer, @NotNull MediaModel paramMediaModel, @NotNull ComposeRenderLayer paramComposeRenderLayer)
  {
    Intrinsics.checkParameterIsNotNull(paramICutSession, "cutSession");
    Intrinsics.checkParameterIsNotNull(paramIPlayer, "player");
    Intrinsics.checkParameterIsNotNull(paramMediaModel, "mediaModel");
    Intrinsics.checkParameterIsNotNull(paramComposeRenderLayer, "composeRenderLayer");
    a(paramICutSession, paramIPlayer);
    this.d = paramMediaModel;
    this.e = paramComposeRenderLayer;
    paramICutSession = this.c;
    if (paramICutSession == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mCutSession");
    }
    paramICutSession.h();
  }
  
  public final void a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "id");
    List localList = CollectionsKt.toMutableList((Collection)this.d.videos);
    Iterator localIterator = localList.iterator();
    int i1 = 0;
    while (localIterator.hasNext())
    {
      Object localObject = ((MediaClip)localIterator.next()).resource;
      if (localObject != null) {
        localObject = ((ResourceModel)localObject).id;
      } else {
        localObject = null;
      }
      if (Intrinsics.areEqual(localObject, paramString)) {
        break label97;
      }
      i1 += 1;
    }
    i1 = -1;
    label97:
    paramString = (Function1)new TimelineViewModel.handleChangeClipsOrder.checkRange.1(localList);
    if ((((Boolean)paramString.invoke(Integer.valueOf(i1))).booleanValue()) && (((Boolean)paramString.invoke(Integer.valueOf(paramInt))).booleanValue()))
    {
      localList.add(paramInt, (MediaClip)localList.remove(i1));
      this.d = MediaModel.copy$default(this.d, null, null, null, null, null, null, localList, null, null, null, null, null, null, null, null, null, null, null, 262079, null);
      paramString = this.e;
      if (paramString == null) {
        Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
      }
      paramString.a(this.d);
      this.o = true;
    }
  }
  
  public final void a(@NotNull List<Timeline> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "list");
    this.f.clear();
    this.f.addAll((Collection)paramList);
    c(paramList);
    d(paramList);
    a(this.d.videos, (SelectItem)this.j.getValue(), paramList);
    t();
  }
  
  public final void a(@Nullable List<MediaClip> paramList, long paramLong)
  {
    if (((TimelineViewModel)this).e == null)
    {
      ICutSession localICutSession = this.c;
      if (localICutSession == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mCutSession");
      }
      this.e = new ComposeRenderLayer(localICutSession, new MediaModel(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262143, null), ComposeRenderLayer.RenderScene.VIDEO);
    }
    this.m = paramLong;
    if (paramList != null)
    {
      if (Intrinsics.areEqual(this.d.videos, paramList))
      {
        j();
      }
      else
      {
        this.d = MediaModel.copy$default(this.d, null, null, null, null, null, null, paramList, null, null, null, null, null, null, null, null, null, null, null, 262079, null);
        paramList = this.e;
        if (paramList == null) {
          Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
        }
        paramList.a(this.d);
      }
      paramList = this.a;
      if (paramList == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mPlayer");
      }
      paramList.a();
    }
    this.o = false;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  @NotNull
  public final MutableLiveData<VideoTrackData> b()
  {
    return this.g;
  }
  
  public final void b(@Nullable List<? extends LocalMediaInfo> paramList)
  {
    if (paramList != null)
    {
      Object localObject1 = new ArrayList();
      Object localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        paramList = (LocalMediaInfo)((Iterator)localObject2).next();
        String str1;
        String str2;
        if (QAlbumUtil.getMediaType(paramList) == 1)
        {
          str1 = paramList.mMimeType;
          Intrinsics.checkExpressionValueIsNotNull(str1, "localMediaInfo.mMimeType");
          long l1 = paramList.mDuration;
          long l2 = 1000;
          str2 = paramList.path;
          Intrinsics.checkExpressionValueIsNotNull(str2, "localMediaInfo.path");
          paramList = new MediaData(0, str1, 720, 1280, 0L, 0L, l1 * l2, str2, paramList.path, paramList.mAlbumName);
        }
        else
        {
          str1 = paramList.mMimeType;
          Intrinsics.checkExpressionValueIsNotNull(str1, "localMediaInfo.mMimeType");
          str2 = paramList.path;
          Intrinsics.checkExpressionValueIsNotNull(str2, "localMediaInfo.path");
          paramList = new MediaData(1, str1, 720, 1280, 0L, 0L, 2500000L, str2, paramList.path, paramList.mAlbumName);
        }
        ((ArrayList)localObject1).add(paramList);
      }
      localObject1 = DataBuilder.a.b((List)localObject1);
      localObject2 = (List)new ArrayList();
      ((List)localObject2).addAll((Collection)this.d.videos);
      paramList = (Long)this.k.getValue();
      if (paramList == null) {
        paramList = Long.valueOf(0L);
      }
      ((List)localObject2).addAll(b(paramList.longValue()) + 1, (Collection)localObject1);
      this.d = MediaModel.copy$default(this.d, null, null, null, null, null, null, (List)localObject2, null, null, null, null, null, null, null, null, null, null, null, 262079, null);
      paramList = this.e;
      if (paramList == null) {
        Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
      }
      paramList.a(this.d);
      this.o = true;
    }
  }
  
  @NotNull
  public final MutableLiveData<Long> c()
  {
    return this.i;
  }
  
  @NotNull
  public final MutableLiveData<SelectItem<?>> d()
  {
    return this.j;
  }
  
  @NotNull
  public final MutableLiveData<Long> e()
  {
    return this.k;
  }
  
  @NotNull
  public final MutableLiveData<IPlayer.PlayerStatus> f()
  {
    return this.l;
  }
  
  public final boolean g()
  {
    return this.n;
  }
  
  public final boolean h()
  {
    return this.o;
  }
  
  @NotNull
  public final ICutSession i()
  {
    ICutSession localICutSession = this.c;
    if (localICutSession == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mCutSession");
    }
    return localICutSession;
  }
  
  public final void j()
  {
    int i1 = b(this.m);
    Object localObject = ((MediaClip)this.d.videos.get(i1)).resource;
    if (localObject != null)
    {
      localObject = new SelectItem(((ResourceModel)localObject).id, 1, new TimelineTimeRange(((ResourceModel)localObject).selectStart, ((ResourceModel)localObject).selectDuration), Integer.valueOf(1));
      this.j.setValue(localObject);
      a(this.d.videos, (SelectItem)localObject, (List)this.f);
    }
    localObject = this.a;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mPlayer");
    }
    ((IPlayer)localObject).a(this.m);
  }
  
  public final void k()
  {
    a(this.d.videos, null, (List)this.f);
  }
  
  public final void l()
  {
    SelectItem localSelectItem = (SelectItem)this.j.getValue();
    if (localSelectItem != null)
    {
      List localList = CollectionsKt.toMutableList((Collection)this.d.videos);
      Iterator localIterator = ((Iterable)localList).iterator();
      Object localObject2;
      do
      {
        boolean bool = localIterator.hasNext();
        localObject1 = null;
        if (!bool) {
          break;
        }
        localObject2 = localIterator.next();
        ResourceModel localResourceModel = ((MediaClip)localObject2).resource;
        if (localResourceModel != null) {
          localObject1 = localResourceModel.id;
        }
      } while (!Intrinsics.areEqual(localObject1, localSelectItem.a()));
      Object localObject1 = localObject2;
      break label105;
      localObject1 = null;
      label105:
      localObject1 = (MediaClip)localObject1;
      if (localObject1 != null) {
        localList.remove(localObject1);
      }
      this.d = MediaModel.copy$default(this.d, null, null, null, null, null, null, localList, null, null, null, null, null, null, null, null, null, null, null, 262079, null);
      localObject1 = this.e;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
      }
      ((ComposeRenderLayer)localObject1).a(this.d);
      this.o = true;
    }
  }
  
  @Nullable
  public final Float m()
  {
    Object localObject1 = (Iterable)this.d.videos;
    Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10));
    Iterator localIterator = ((Iterable)localObject1).iterator();
    for (;;)
    {
      boolean bool = localIterator.hasNext();
      Object localObject3 = null;
      if (!bool) {
        break;
      }
      MediaClip localMediaClip = (MediaClip)localIterator.next();
      localObject1 = localMediaClip.resource;
      if (localObject1 != null) {
        localObject1 = ((ResourceModel)localObject1).id;
      } else {
        localObject1 = null;
      }
      Object localObject2 = (SelectItem)this.j.getValue();
      if (localObject2 != null) {
        localObject2 = ((SelectItem)localObject2).a();
      } else {
        localObject2 = null;
      }
      if (Intrinsics.areEqual(localObject1, localObject2))
      {
        localObject2 = localMediaClip.resource;
        localObject1 = localObject3;
        if (localObject2 != null) {
          localObject1 = Float.valueOf((float)((ResourceModel)localObject2).selectDuration / (float)localMediaClip.resource.scaleDuration);
        }
        return localObject1;
      }
      localCollection.add(Unit.INSTANCE);
    }
    localObject1 = (List)localCollection;
    return null;
  }
  
  @Nullable
  public final MediaType n()
  {
    Object localObject1 = (Iterable)this.d.videos;
    Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10));
    Iterator localIterator = ((Iterable)localObject1).iterator();
    for (;;)
    {
      boolean bool = localIterator.hasNext();
      Object localObject3 = null;
      if (!bool) {
        break;
      }
      MediaClip localMediaClip = (MediaClip)localIterator.next();
      localObject1 = localMediaClip.resource;
      if (localObject1 != null) {
        localObject1 = ((ResourceModel)localObject1).id;
      } else {
        localObject1 = null;
      }
      Object localObject2 = (SelectItem)this.j.getValue();
      if (localObject2 != null) {
        localObject2 = ((SelectItem)localObject2).a();
      } else {
        localObject2 = null;
      }
      if (Intrinsics.areEqual(localObject1, localObject2))
      {
        localObject2 = localMediaClip.resource;
        localObject1 = localObject3;
        if (localObject2 != null) {
          localObject1 = ((ResourceModel)localObject2).type;
        }
        return localObject1;
      }
      localCollection.add(Unit.INSTANCE);
    }
    localObject1 = (List)localCollection;
    return null;
  }
  
  @NotNull
  public final ArrayList<MediaClip> o()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll((Collection)this.d.videos);
    return localArrayList;
  }
  
  public final int p()
  {
    return this.d.videos.size();
  }
  
  public final long q()
  {
    Long localLong = (Long)this.i.getValue();
    if (localLong != null) {
      return localLong.longValue();
    }
    return 0L;
  }
  
  public final long r()
  {
    Iterator localIterator = ((Iterable)this.d.videos).iterator();
    boolean bool = localIterator.hasNext();
    long l4 = 0L;
    if (!bool)
    {
      localObject1 = null;
    }
    else
    {
      localObject1 = localIterator.next();
      if (localIterator.hasNext())
      {
        Object localObject2 = ((MediaClip)localObject1).resource;
        if (localObject2 != null)
        {
          l1 = ((ResourceModel)localObject2).selectDuration;
          localObject2 = localObject1;
        }
        else
        {
          l1 = 0L;
          localObject2 = localObject1;
        }
        do
        {
          Object localObject3 = localIterator.next();
          localObject1 = ((MediaClip)localObject3).resource;
          long l2;
          if (localObject1 != null) {
            l2 = ((ResourceModel)localObject1).selectDuration;
          } else {
            l2 = 0L;
          }
          localObject1 = localObject2;
          long l3 = l1;
          if (l1 > l2)
          {
            localObject1 = localObject3;
            l3 = l2;
          }
          localObject2 = localObject1;
          l1 = l3;
        } while (localIterator.hasNext());
      }
    }
    Object localObject1 = (MediaClip)localObject1;
    long l1 = l4;
    if (localObject1 != null)
    {
      localObject1 = ((MediaClip)localObject1).resource;
      l1 = l4;
      if (localObject1 != null) {
        l1 = ((ResourceModel)localObject1).selectDuration;
      }
    }
    return l1;
  }
  
  public final void s()
  {
    ICutSession localICutSession = this.c;
    if (localICutSession == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mCutSession");
    }
    localICutSession.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.TimelineViewModel
 * JD-Core Version:    0.7.0.1
 */