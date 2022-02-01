package com.tencent.tavcut.model;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/model/ClipSource$ClipType;", "", "Lcom/squareup/wire/WireEnum;", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "PHOTO", "VIDEO", "Companion", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public enum ClipSource$ClipType
  implements WireEnum
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<ClipType> ADAPTER = (ProtoAdapter)new ClipSource.ClipType.Companion.ADAPTER.1(Reflection.getOrCreateKotlinClass(ClipType.class));
  public static final ClipSource.ClipType.Companion Companion;
  private final int value;
  
  static
  {
    ClipType localClipType1 = new ClipType("PHOTO", 0, 0);
    PHOTO = localClipType1;
    ClipType localClipType2 = new ClipType("VIDEO", 1, 1);
    VIDEO = localClipType2;
    $VALUES = new ClipType[] { localClipType1, localClipType2 };
    Companion = new ClipSource.ClipType.Companion(null);
  }
  
  private ClipSource$ClipType(int paramInt)
  {
    this.value = paramInt;
  }
  
  @JvmStatic
  @Nullable
  public static final ClipType fromValue(int paramInt)
  {
    return Companion.fromValue(paramInt);
  }
  
  public int getValue()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.model.ClipSource.ClipType
 * JD-Core Version:    0.7.0.1
 */