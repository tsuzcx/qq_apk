package com.tencent.tavcut.composition.model.component;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/PAGAsset$Replacement$ReplaceType;", "", "Lcom/squareup/wire/WireEnum;", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "NONE", "TEXT", "IMAGE", "FILTER_REPLACEMENT", "Companion", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public enum PAGAsset$Replacement$ReplaceType
  implements WireEnum
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<ReplaceType> ADAPTER = (ProtoAdapter)new PAGAsset.Replacement.ReplaceType.Companion.ADAPTER.1(Reflection.getOrCreateKotlinClass(ReplaceType.class));
  public static final PAGAsset.Replacement.ReplaceType.Companion Companion;
  private final int value;
  
  static
  {
    ReplaceType localReplaceType1 = new ReplaceType("NONE", 0, 0);
    NONE = localReplaceType1;
    ReplaceType localReplaceType2 = new ReplaceType("TEXT", 1, 1);
    TEXT = localReplaceType2;
    ReplaceType localReplaceType3 = new ReplaceType("IMAGE", 2, 2);
    IMAGE = localReplaceType3;
    ReplaceType localReplaceType4 = new ReplaceType("FILTER_REPLACEMENT", 3, 3);
    FILTER_REPLACEMENT = localReplaceType4;
    $VALUES = new ReplaceType[] { localReplaceType1, localReplaceType2, localReplaceType3, localReplaceType4 };
    Companion = new PAGAsset.Replacement.ReplaceType.Companion(null);
  }
  
  private PAGAsset$Replacement$ReplaceType(int paramInt)
  {
    this.value = paramInt;
  }
  
  @JvmStatic
  @Nullable
  public static final ReplaceType fromValue(int paramInt)
  {
    return Companion.fromValue(paramInt);
  }
  
  public int getValue()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.PAGAsset.Replacement.ReplaceType
 * JD-Core Version:    0.7.0.1
 */