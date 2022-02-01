package com.tencent.tavcut.model;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/model/ClipSource$ClipType$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/model/ClipSource$ClipType;", "fromValue", "value", "", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class ClipSource$ClipType$Companion
{
  @JvmStatic
  @Nullable
  public final ClipSource.ClipType fromValue(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return null;
      }
      return ClipSource.ClipType.VIDEO;
    }
    return ClipSource.ClipType.PHOTO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.model.ClipSource.ClipType.Companion
 * JD-Core Version:    0.7.0.1
 */