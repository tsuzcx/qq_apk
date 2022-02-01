package com.tencent.videocut.model;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/StickerModel$ActionType;", "", "Lcom/squareup/wire/WireEnum;", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "NONE", "REPLACE_ALL", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public enum StickerModel$ActionType
  implements WireEnum
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<ActionType> ADAPTER = (ProtoAdapter)new StickerModel.ActionType.Companion.ADAPTER.1(Reflection.getOrCreateKotlinClass(ActionType.class));
  public static final StickerModel.ActionType.Companion Companion;
  private final int value;
  
  static
  {
    ActionType localActionType1 = new ActionType("NONE", 0, 0);
    NONE = localActionType1;
    ActionType localActionType2 = new ActionType("REPLACE_ALL", 1, 1);
    REPLACE_ALL = localActionType2;
    $VALUES = new ActionType[] { localActionType1, localActionType2 };
    Companion = new StickerModel.ActionType.Companion(null);
  }
  
  private StickerModel$ActionType(int paramInt)
  {
    this.value = paramInt;
  }
  
  @JvmStatic
  @Nullable
  public static final ActionType fromValue(int paramInt)
  {
    return Companion.a(paramInt);
  }
  
  public int getValue()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.StickerModel.ActionType
 * JD-Core Version:    0.7.0.1
 */