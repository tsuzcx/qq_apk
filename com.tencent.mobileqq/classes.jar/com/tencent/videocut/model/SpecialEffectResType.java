package com.tencent.videocut.model;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/SpecialEffectResType;", "", "Lcom/squareup/wire/WireEnum;", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "EFFECT_PAG", "EFFECT_SHADER", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public enum SpecialEffectResType
  implements WireEnum
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<SpecialEffectResType> ADAPTER = (ProtoAdapter)new SpecialEffectResType.Companion.ADAPTER.1(Reflection.getOrCreateKotlinClass(SpecialEffectResType.class));
  public static final SpecialEffectResType.Companion Companion;
  private final int value;
  
  static
  {
    SpecialEffectResType localSpecialEffectResType1 = new SpecialEffectResType("EFFECT_PAG", 0, 0);
    EFFECT_PAG = localSpecialEffectResType1;
    SpecialEffectResType localSpecialEffectResType2 = new SpecialEffectResType("EFFECT_SHADER", 1, 1);
    EFFECT_SHADER = localSpecialEffectResType2;
    $VALUES = new SpecialEffectResType[] { localSpecialEffectResType1, localSpecialEffectResType2 };
    Companion = new SpecialEffectResType.Companion(null);
  }
  
  private SpecialEffectResType(int paramInt)
  {
    this.value = paramInt;
  }
  
  @JvmStatic
  @Nullable
  public static final SpecialEffectResType fromValue(int paramInt)
  {
    return Companion.a(paramInt);
  }
  
  public int getValue()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.SpecialEffectResType
 * JD-Core Version:    0.7.0.1
 */