package com.tencent.tavcut.composition.model.component;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/PAGAsset$Replacement$ReplaceType$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/composition/model/component/PAGAsset$Replacement$ReplaceType;", "fromValue", "value", "", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class PAGAsset$Replacement$ReplaceType$Companion
{
  @JvmStatic
  @Nullable
  public final PAGAsset.Replacement.ReplaceType fromValue(int paramInt)
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
          return PAGAsset.Replacement.ReplaceType.FILTER_REPLACEMENT;
        }
        return PAGAsset.Replacement.ReplaceType.IMAGE;
      }
      return PAGAsset.Replacement.ReplaceType.TEXT;
    }
    return PAGAsset.Replacement.ReplaceType.NONE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.PAGAsset.Replacement.ReplaceType.Companion
 * JD-Core Version:    0.7.0.1
 */