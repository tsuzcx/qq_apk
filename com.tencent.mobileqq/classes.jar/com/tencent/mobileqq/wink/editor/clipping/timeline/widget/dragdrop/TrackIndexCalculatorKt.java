package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"INVALID_INDEX", "", "TAG", "", "calculateTrackIndex", "trackModelList", "", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/TrackModel;", "newModel", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragViewModel;", "type", "createTrackModel", "trackList", "trackType", "trackIndex", "getFirstEmptyTrackIndex", "dragModelList", "", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragModel;", "preAddModelForIndex", "putInValidTrack", "dragViewModel", "putToNewTrack", "tryPutCurrentTrack", "qq-wink-impl_release"}, k=2, mv={1, 1, 16})
public final class TrackIndexCalculatorKt
{
  @NotNull
  public static final TrackModel a(@NotNull List<TrackModel> paramList, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "trackList");
    TrackModel localTrackModel = new TrackModel();
    localTrackModel.f(paramInt1);
    if ((paramInt2 <= paramList.size()) && (paramInt2 >= 0))
    {
      localTrackModel.e(paramInt2);
      paramList.add(paramInt2, localTrackModel);
      return localTrackModel;
    }
    localTrackModel.e(paramList.size());
    paramList.add(localTrackModel);
    return localTrackModel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.TrackIndexCalculatorKt
 * JD-Core Version:    0.7.0.1
 */