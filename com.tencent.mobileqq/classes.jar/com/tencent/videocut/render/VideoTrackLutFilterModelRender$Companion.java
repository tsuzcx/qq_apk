package com.tencent.videocut.render;

import com.tencent.videocut.model.FilterModel;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/render/VideoTrackLutFilterModelRender$Companion;", "", "()V", "TAG", "", "getVideoIndex", "", "mediaModel", "Lcom/tencent/videocut/model/MediaModel;", "id", "getVideoIndex$qq_wink_impl_release", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class VideoTrackLutFilterModelRender$Companion
{
  public final int a(@Nullable MediaModel paramMediaModel, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "id");
    if (paramMediaModel != null)
    {
      paramMediaModel = paramMediaModel.videos;
      int i = 0;
      Iterator localIterator = paramMediaModel.iterator();
      while (localIterator.hasNext())
      {
        paramMediaModel = ((MediaClip)localIterator.next()).filter;
        if (paramMediaModel != null) {
          paramMediaModel = paramMediaModel.id;
        } else {
          paramMediaModel = null;
        }
        if (Intrinsics.areEqual(paramMediaModel, paramString)) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.render.VideoTrackLutFilterModelRender.Companion
 * JD-Core Version:    0.7.0.1
 */