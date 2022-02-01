package com.tencent.videocut.model;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/MediaType$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/MediaType;", "fromValue", "value", "", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class MediaType$Companion
{
  @JvmStatic
  @Nullable
  public final MediaType a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return null;
        }
        return MediaType.AUDIO;
      }
      return MediaType.IMAGE;
    }
    return MediaType.VIDEO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.MediaType.Companion
 * JD-Core Version:    0.7.0.1
 */