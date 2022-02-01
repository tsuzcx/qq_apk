package com.tencent.videocut.model;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/RatioType;", "", "Lcom/squareup/wire/WireEnum;", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "ORIGINAL", "R16_9", "R9_16", "R1_1", "R3_4", "R4_3", "R1_2", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public enum RatioType
  implements WireEnum
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<RatioType> ADAPTER = (ProtoAdapter)new RatioType.Companion.ADAPTER.1(Reflection.getOrCreateKotlinClass(RatioType.class));
  public static final RatioType.Companion Companion;
  private final int value;
  
  static
  {
    RatioType localRatioType1 = new RatioType("ORIGINAL", 0, 0);
    ORIGINAL = localRatioType1;
    RatioType localRatioType2 = new RatioType("R16_9", 1, 1);
    R16_9 = localRatioType2;
    RatioType localRatioType3 = new RatioType("R9_16", 2, 2);
    R9_16 = localRatioType3;
    RatioType localRatioType4 = new RatioType("R1_1", 3, 3);
    R1_1 = localRatioType4;
    RatioType localRatioType5 = new RatioType("R3_4", 4, 4);
    R3_4 = localRatioType5;
    RatioType localRatioType6 = new RatioType("R4_3", 5, 5);
    R4_3 = localRatioType6;
    RatioType localRatioType7 = new RatioType("R1_2", 6, 6);
    R1_2 = localRatioType7;
    $VALUES = new RatioType[] { localRatioType1, localRatioType2, localRatioType3, localRatioType4, localRatioType5, localRatioType6, localRatioType7 };
    Companion = new RatioType.Companion(null);
  }
  
  private RatioType(int paramInt)
  {
    this.value = paramInt;
  }
  
  @JvmStatic
  @Nullable
  public static final RatioType fromValue(int paramInt)
  {
    return Companion.a(paramInt);
  }
  
  public int getValue()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.RatioType
 * JD-Core Version:    0.7.0.1
 */