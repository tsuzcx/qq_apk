package com.tencent.videocut.model;

import com.squareup.wire.EnumAdapter;
import kotlin.Metadata;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/videocut/model/AudioModel$Type$Companion$ADAPTER$1", "Lcom/squareup/wire/EnumAdapter;", "Lcom/tencent/videocut/model/AudioModel$Type;", "fromValue", "value", "", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class AudioModel$Type$Companion$ADAPTER$1
  extends EnumAdapter<AudioModel.Type>
{
  AudioModel$Type$Companion$ADAPTER$1(KClass paramKClass)
  {
    super(paramKClass);
  }
  
  @Nullable
  protected AudioModel.Type a(int paramInt)
  {
    return AudioModel.Type.Companion.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.AudioModel.Type.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */