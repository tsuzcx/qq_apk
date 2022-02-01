package com.tencent.tavcut.composition.model.component;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/BackgroundFillMode$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/composition/model/component/BackgroundFillMode;", "fromValue", "value", "", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class BackgroundFillMode$Companion
{
  @JvmStatic
  @Nullable
  public final BackgroundFillMode fromValue(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return null;
      }
      return BackgroundFillMode.SOLID_COLOR;
    }
    return BackgroundFillMode.PAG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.BackgroundFillMode.Companion
 * JD-Core Version:    0.7.0.1
 */