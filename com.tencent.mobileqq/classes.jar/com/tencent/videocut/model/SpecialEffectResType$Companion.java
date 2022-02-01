package com.tencent.videocut.model;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/SpecialEffectResType$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/SpecialEffectResType;", "fromValue", "value", "", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class SpecialEffectResType$Companion
{
  @JvmStatic
  @Nullable
  public final SpecialEffectResType a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return null;
      }
      return SpecialEffectResType.EFFECT_SHADER;
    }
    return SpecialEffectResType.EFFECT_PAG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.SpecialEffectResType.Companion
 * JD-Core Version:    0.7.0.1
 */