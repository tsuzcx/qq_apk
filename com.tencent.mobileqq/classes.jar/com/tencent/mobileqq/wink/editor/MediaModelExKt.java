package com.tencent.mobileqq.wink.editor;

import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.TransitionModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"copyAudioModels", "", "audios", "", "", "Lcom/tencent/videocut/model/AudioModel;", "dest", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "volume", "", "copyAndUpdateBgm", "Lcom/tencent/videocut/model/MediaModel;", "copyAndUpdateBgmVolume", "copyAndUpdateDuration", "time", "", "copyAndUpdateFilters", "filters", "Lcom/tencent/videocut/model/FilterModel;", "copyAndUpdateOriginVolume", "Lcom/tencent/videocut/model/MediaClip;", "copyAndUpdateStickers", "stickers", "Lcom/tencent/videocut/model/StickerModel;", "copyAndUpdateTransition", "context", "Landroid/content/Context;", "transition", "Lcom/tencent/videocut/model/TransitionModel;", "runnable", "Ljava/lang/Runnable;", "copyAndUpdateVideos", "clips", "", "qq-wink-impl_release"}, k=2, mv={1, 1, 16})
public final class MediaModelExKt
{
  @NotNull
  public static final MediaModel a(@NotNull MediaModel paramMediaModel, @NotNull Map<String, TransitionModel> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaModel, "$this$copyAndUpdateTransition");
    Intrinsics.checkParameterIsNotNull(paramMap, "transition");
    return MediaModel.copy$default(paramMediaModel, null, null, null, null, null, null, null, null, null, null, null, null, paramMap, null, null, null, null, null, 258047, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.MediaModelExKt
 * JD-Core Version:    0.7.0.1
 */