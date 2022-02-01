package com.tencent.weseevideo.camera.mvauto.redo;

import com.tencent.weseevideo.model.resource.MediaClipModel;
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
    return new CutModelKt(null, VideoResourceModelKt.Companion.from(paramMediaClipModel.getResource()), VideoConfigurationModelKt.Companion.from(paramMediaClipModel.getVideoConfigurationModel()), paramMediaClipModel.getAudioConfigurationModel(), 1, null);
  }
  
  @NotNull
  public final List<CutModelKt> convert(@NotNull List<MediaClipModel> paramList)
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
    Object localObject = (Collection)paramList;
    paramList = CollectionsKt.toMutableList((Collection)localObject);
    localObject = ((Iterable)RangesKt.reversed((IntProgression)CollectionsKt.getIndices((Collection)localObject))).iterator();
    while (((Iterator)localObject).hasNext())
    {
      int i = ((IntIterator)localObject).nextInt();
      CutModelKt localCutModelKt = (CutModelKt)paramList.get(i);
      if (localCutModelKt.getResource().getSelectTimeDuration() < localCutModelKt.getResource().getCutTimeDuration()) {
        paramList.set(i, CutModelKt.copy$default(localCutModelKt, null, VideoResourceModelKt.copy$default(localCutModelKt.getResource(), null, 0, ((float)localCutModelKt.getResource().getCutTimeDuration() / localCutModelKt.getResource().getScaleSpeed()), 0L, 0L, 0L, 0L, localCutModelKt.getResource().getCutTimeStart(), localCutModelKt.getResource().getCutTimeDuration(), 0L, localCutModelKt.getResource().getCutTimeDuration() * 1000, 0L, 0L, 0, 0, 0, 64123, null), null, null, 13, null));
      }
    }
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.camera.mvauto.redo.StoreModelConvert
 * JD-Core Version:    0.7.0.1
 */