package com.tencent.weseevideo.camera.mvauto.redo;

import com.tencent.weseevideo.model.resource.MediaClipModel;
import com.tencent.weseevideo.model.resource.VideoConfigurationModel;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weseevideo/camera/mvauto/redo/StoreModelConvert;", "", "()V", "convert", "Lcom/tencent/weseevideo/camera/mvauto/redo/CutModelKt;", "it", "Lcom/tencent/weseevideo/model/resource/MediaClipModel;", "", "resource", "restoreClipTimeRange", "data", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class StoreModelConvert
{
  public static final StoreModelConvert INSTANCE = new StoreModelConvert();
  
  @NotNull
  public final CutModelKt convert(@NotNull MediaClipModel paramMediaClipModel)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaClipModel, "it");
    Object localObject1 = VideoResourceModelKt.Companion;
    Object localObject2 = paramMediaClipModel.getResource();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "it.resource");
    localObject1 = ((VideoResourceModelKt.Companion)localObject1).from((VideoResourceModel)localObject2);
    localObject2 = VideoConfigurationModelKt.Companion;
    VideoConfigurationModel localVideoConfigurationModel = paramMediaClipModel.getVideoConfigurationModel();
    Intrinsics.checkExpressionValueIsNotNull(localVideoConfigurationModel, "it.videoConfigurationModel");
    return new CutModelKt(null, (VideoResourceModelKt)localObject1, ((VideoConfigurationModelKt.Companion)localObject2).from(localVideoConfigurationModel), paramMediaClipModel.getAudioConfigurationModel(), 1, null);
  }
  
  @NotNull
  public final List<CutModelKt> convert(@NotNull List<? extends MediaClipModel> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "resource");
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MediaClipModel localMediaClipModel = (MediaClipModel)((Iterator)localObject).next();
      paramList.add(INSTANCE.convert(localMediaClipModel));
    }
    return (List)paramList;
  }
  
  @NotNull
  public final List<CutModelKt> restoreClipTimeRange(@NotNull List<CutModelKt> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "data");
    List localList = CollectionsKt.toMutableList((Collection)paramList);
    paramList = ((Iterable)RangesKt.reversed((IntProgression)CollectionsKt.getIndices((Collection)paramList))).iterator();
    while (paramList.hasNext())
    {
      int i = ((IntIterator)paramList).nextInt();
      CutModelKt localCutModelKt = (CutModelKt)localList.get(i);
      if (localCutModelKt.getResource().getSelectTimeDuration() < localCutModelKt.getResource().getCutTimeDuration()) {
        localList.set(i, CutModelKt.copy$default(localCutModelKt, null, VideoResourceModelKt.copy$default(localCutModelKt.getResource(), null, 0, ((float)localCutModelKt.getResource().getCutTimeDuration() / localCutModelKt.getResource().getScaleSpeed()), 0L, 0L, 0L, 0L, localCutModelKt.getResource().getCutTimeStart(), localCutModelKt.getResource().getCutTimeDuration(), 0L, localCutModelKt.getResource().getCutTimeDuration() * 1000, 0L, 0L, 0, 0, 0, 64123, null), null, null, 13, null));
      }
    }
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.camera.mvauto.redo.StoreModelConvert
 * JD-Core Version:    0.7.0.1
 */