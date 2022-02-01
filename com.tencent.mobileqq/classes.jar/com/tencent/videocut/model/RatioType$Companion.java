package com.tencent.videocut.model;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/RatioType$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/RatioType;", "fromValue", "value", "", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class RatioType$Companion
{
  @JvmStatic
  @Nullable
  public final RatioType a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 6: 
      return RatioType.R1_2;
    case 5: 
      return RatioType.R4_3;
    case 4: 
      return RatioType.R3_4;
    case 3: 
      return RatioType.R1_1;
    case 2: 
      return RatioType.R9_16;
    case 1: 
      return RatioType.R16_9;
    }
    return RatioType.ORIGINAL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.RatioType.Companion
 * JD-Core Version:    0.7.0.1
 */