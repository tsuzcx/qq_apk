package com.tencent.videocut.model;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/AudioModel$Type$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/AudioModel$Type;", "fromValue", "value", "", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class AudioModel$Type$Companion
{
  @JvmStatic
  @Nullable
  public final AudioModel.Type a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return null;
          }
          return AudioModel.Type.EXTRACT;
        }
        return AudioModel.Type.SOUND;
      }
      return AudioModel.Type.RECORD;
    }
    return AudioModel.Type.MUSIC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.AudioModel.Type.Companion
 * JD-Core Version:    0.7.0.1
 */